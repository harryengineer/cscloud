package com.cscloud.auth.server.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.server.config.ClientConfiguration;
import com.cscloud.auth.server.service.AuthClientSerivce;
import com.cscloud.auth.server.util.client.ClientTokenUtils;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;

import lombok.extern.slf4j.Slf4j;

/**
 * 当其他资源服务器访问该服务器的时候，对身份进行对应的校验
 * 
 * @author Administrator
 *
 */
@Slf4j
public class ClientAuthInterceptor implements HandlerInterceptor {

	@Autowired
	private ClientConfiguration client;
	@Autowired
	private ClientTokenUtils clientTokenUtils;
	@Autowired
	private AuthClientSerivce authClientSerivce;

	/**
	 * 在访问之前判断是否允许该服务访问这个资源， 允许的话，获取对应的请求服务的信息
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader(client.getClientTokenHeader());
		IJWTInfo jwtInfo = clientTokenUtils.getInfoFromToken(token);
		log.info("the token of client :{}, and the clientId is :{}", token, jwtInfo.getId());
		if (StringUtils.isBlank(jwtInfo.getUniqueName())) {
			throw new BaseException(ErrorCode.CLIENT_TOKEN_INFO_ERROR);
		}
		
		//问题： 缺少过期时间在jsonwebtoken  中自动验证了）
		
		List<String> allowClientNames = authClientSerivce.getAllowedClient(client.getClientId());
		for (String allowclientName : allowClientNames) {
			if (jwtInfo.getUniqueName().equals(allowclientName)) {
				return HandlerInterceptor.super.preHandle(request, response, handler);
			}
		}
		
		// 没有就抛出异常
		throw new BaseException(ErrorCode.CLIENT_NO_PERMISSION);

	}

}
