package com.cscloud.auth.client.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cscloud.auth.client.annotation.IgnoreUserToken;
import com.cscloud.auth.client.properties.UserAuthProperties;
import com.cscloud.auth.client.util.UserTokenUtils;
import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.common.util.BaseContextMap;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;

import java.util.Enumeration;


/**
 * 用户请求的拦截
 * @author Administrator
 *
 */
public class UserRequestInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	private UserAuthProperties userAuthProperties;
	
	@Resource
	private UserTokenUtils userAuthUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod){
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			IgnoreUserToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
			if (annotation != null) {
				annotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
			}
			System.out.println(request.getRequestURL());
			if (annotation != null) {
				return super.preHandle(request, response, handler);
			}
		}


		//先从header中获取token信息，如果获取不到的话，那么到去cookie中获取
		String token = request.getHeader(userAuthProperties.getUserTokenHeader());
		if (StringUtils.isEmpty(token)) {
			Cookie[] cookies = request.getCookies();
			if (cookies == null){
				throw new BaseException(ErrorCode.SYSTEM_ERROR);
			}
			for (Cookie cookie : cookies) {
				if (userAuthProperties.getUserTokenHeader().equals(cookie.getName())) {
					token = cookie.getValue();
				}
			}
		}
		
		if (StringUtils.isBlank(token)) {
			throw new BaseException(ErrorCode.USER_TOKEN_EMPTY);
		}
		
		//取出用户的数据放到本地的缓存中去
		IJWTInfo info = userAuthUtil.getInfoFromToken(token);
		if (StringUtils.isNotBlank(info.getId())) {
			BaseContextMap.setName(info.getName());
			BaseContextMap.setUserID(info.getId());
			BaseContextMap.setUsername(info.getUniqueName());
			BaseContextMap.setHost(request.getRemoteHost());
			 return super.preHandle(request, response, handler);
		}
		
		throw new BaseException(ErrorCode.USER_NO_EXIST);
	}
	
	
	
	

}
