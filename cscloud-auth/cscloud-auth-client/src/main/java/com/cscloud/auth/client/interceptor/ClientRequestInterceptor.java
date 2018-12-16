package com.cscloud.auth.client.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cscloud.auth.client.properties.ClientAuthProperties;
import com.cscloud.auth.client.util.ClientTokenUtils;
import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.common.util.JWTRSAUtils;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;

import lombok.extern.slf4j.Slf4j;

/**
 * 客服端请求的拦截器
 * 
 * @author Administrator
 *
 */
@Slf4j
public class ClientRequestInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private ClientAuthProperties clientProperties;

	@Resource
	private ClientTokenUtils clientTokenUtils;

	/**
	 * 对访问的实例请求进行权限认证
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader(clientProperties.getTokenHeader());
		IJWTInfo jwtInfo = clientTokenUtils.getJwtInfo(token);
		log.info("the token of client :{}, and the clientId is :{}", token, jwtInfo.getId());
		if (StringUtils.isBlank(jwtInfo.getUniqueName())) {
			throw new BaseException(ErrorCode.CLIENT_TOKEN_INFO_ERROR);
		}
		
		List<String> clients = clientTokenUtils.getAllowClients();
		for (String client : clients) {
			if (client.equals(jwtInfo.getUniqueName())) {
				return super.preHandle(request, response, handler);
			}

		}
		
		throw new BaseException(ErrorCode.CLIENT_NO_PERMISSION);

	}
}
