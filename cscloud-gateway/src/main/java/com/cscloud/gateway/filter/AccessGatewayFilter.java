package com.cscloud.gateway.filter;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ServerWebExchange;

import com.cscloud.auth.api.model.AuthPermissionVo;
import com.cscloud.auth.api.service.admin.AuthAdminUserFeignApi;
import com.cscloud.auth.client.properties.ClientAuthProperties;
import com.cscloud.auth.client.properties.UserAuthProperties;
import com.cscloud.auth.client.util.ClientTokenUtils;
import com.cscloud.auth.client.util.UserTokenUtils;
import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.common.util.BaseContextMap;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;
import com.cscloud.common.base.util.JacksonUtils;
import com.cscloud.common.base.wrapper.Wrapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 配置全局的过滤器对网关等进行对应的过滤操作 有如下功能，权限认证，路径过滤忽略
 * 
 * @author Administrator
 *
 */
@Component
@Slf4j
public class AccessGatewayFilter implements GlobalFilter, Ordered {

	private String GATEWAY_PREFIX = "/api";

	@Resource
	private UserAuthProperties userProperties;

	@Resource
	private UserTokenUtils userTokenUtils;

	@Resource
	private AuthAdminUserFeignApi authAdminUserFeignApi;
	
	@Resource
	private ClientAuthProperties clientAuthProperties;
	
	
	@Resource
	private ClientTokenUtils  clientTokenUtils;

	@Value("${gateway.ignore.url}")
	private String ignoreUrl;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		LinkedHashSet<URI> uris = exchange
				.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
		ServerHttpRequest request = exchange.getRequest();
		// 获取解析后的原始路径
		String requestUrl = request.getPath().pathWithinApplication().value();
		// 获取原始的路径，然后将路径给reqeusturl，如果没有 就使用默认的路径
		if (uris != null && uris.size() > 0) {
			for (URI uri : uris) {
				if (uri.toString().startsWith(GATEWAY_PREFIX)) {
					requestUrl.substring(GATEWAY_PREFIX.length());
				}
			}
		}

		// 这个是webflux中的内容之后再看
		org.springframework.http.server.reactive.ServerHttpRequest.Builder mutate = request.mutate();
		final String method = request.getMethod().toString();
		BaseContextMap.setUserToken(null);
		if (StringUtils.isNotBlank(ignoreUrl)) {
			String[] urlSplits = ignoreUrl.split(",");
			for (String urlSplit : urlSplits) {
				if (requestUrl.startsWith(urlSplit)) {
					ServerHttpRequest build = mutate.build();
					return chain.filter(exchange.mutate().request(build).build());
				}
			}
		}

		IJWTInfo user = null;
		try {
			user = getJWTUser(request, mutate);
		} catch (Exception e) {
			log.error("用户Token过期异常", e);
			try {
				return getVoidMono(exchange, new BaseException(ErrorCode.USER_TOKEN_EXPIRED));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		// 获取用户的所有的权限
		Wrapper<List<AuthPermissionVo>> permission = authAdminUserFeignApi.getAllPermission();
		if (permission.getStatus() == HttpStatus.OK.value()) {
			List<AuthPermissionVo> list = permission.getData();
			list = getPermissionIfs(requestUrl, method, list);
			AuthPermissionVo[] permissionVos = list.toArray(new AuthPermissionVo[] {});
			if (permissionVos.length > 0) {
				try {
					if (checkUserPermission(permissionVos, exchange, user)) {
						return getVoidMono(exchange, new BaseException(ErrorCode.USER_NO_PERMISSION));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			throw new BaseException(ErrorCode.getByCode(permission.getStatus()));
		}
		
		//成功后添加权限信息
		mutate.header(clientAuthProperties.getTokenHeader(),clientTokenUtils.getToken());
		
		return chain.filter(exchange.mutate().request(mutate.build()).build());
	}

	/**
	 * 检查用户是否有权限
	 * 
	 * @param permissionVos
	 * @param exchange
	 * @param user
	 * @return
	 */
	private boolean checkUserPermission(AuthPermissionVo[] permissionVos, ServerWebExchange exchange, IJWTInfo user) {
		Wrapper<List<AuthPermissionVo>> apiResult = authAdminUserFeignApi.getPermissionByUsername(user.getUniqueName());
		log.info("调用的{}的方法{},结果是:{}", "authAdminUserFeignApi", "getPermissionByUsername", apiResult);
		AuthPermissionVo current = null;
		if (apiResult.getData() != null && apiResult.getData().size() > 0) {
			for (AuthPermissionVo authPermissionVo : permissionVos) {
				boolean match = apiResult.getData().parallelStream().anyMatch((key) -> {
					return key.getCode().equals(authPermissionVo.getCode());
				});

				if (match) {
					current = authPermissionVo;
					break;
				}
			}

			if (current == null) {
				return true;
			} else {
				if (!RequestMethod.GET.toString().equalsIgnoreCase(current.getMethod())) {
					System.out.println("写入对应的日志");
				}
			}
		}
		return false;
	}

	/**
	 * 通过路径和方法获取所有符合的权限
	 * 
	 * @param requestUrl
	 * @param method
	 * @param list
	 * @return
	 */
	private List<AuthPermissionVo> getPermissionIfs(String requestUrl, String method, List<AuthPermissionVo> list) {
		return list.parallelStream().filter(key -> {
			String uri = key.getUri();
			if (uri.indexOf("{") > 0) {
				uri = uri.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
			}

			String regEx = "^" + uri + "$";
			return (Pattern.compile(regEx).matcher(requestUrl).find()) && method.equals(key.getMethod());
		}).collect(Collectors.toList());

	}

	/**
	 * webflux 返回对应的响应
	 * 
	 * @param exchange
	 * @param baseException
	 * @return
	 * @throws IOException
	 */
	private Mono<Void> getVoidMono(ServerWebExchange exchange, BaseException baseException) throws IOException {
		exchange.getResponse().setStatusCode(HttpStatus.OK);
		byte[] bytes = JacksonUtils.toJson(baseException).getBytes(StandardCharsets.UTF_8);
		DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
		return exchange.getResponse().writeWith(Flux.just(buffer));
	}

	/**
	 * 从get中获取数据，然后返回对应的数据
	 * 
	 * @param request
	 * @param mutate
	 * @return
	 * @throws Exception
	 */
	private IJWTInfo getJWTUser(ServerHttpRequest request,
			org.springframework.http.server.reactive.ServerHttpRequest.Builder mutate) throws Exception {
		List<String> authList = request.getHeaders().get(userProperties.getUserTokenHeader());
		String authToken = null;
		if (authList != null) {
			authToken = authList.get(0);
		}

		// 判断这个时候如果为空的话，从query数据中尝试获取
		if (StringUtils.isBlank(authToken)) {
			List<String> queryParas = request.getQueryParams().get(userProperties.getUserTokenHeader());
			if (queryParas != null) {
				authToken = queryParas.get(0);
			}
		}

		// 获取token，然后放到本地缓存和mutate中的，如果改变属性就将属性放进去重新创建
		BaseContextMap.setUserToken(authToken);
		mutate.header(userProperties.getUserTokenHeader(), authToken);
		return userTokenUtils.getInfoFromToken(authToken);

	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

}
