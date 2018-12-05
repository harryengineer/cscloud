package com.cscloud.auth.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.server.config.UserAuthConfiguration;
import com.cscloud.auth.server.util.UserInfoContext;
import com.cscloud.auth.server.util.user.UserTokenUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 对用户的权限进行认证和拦截
 * @author Administrator
 *
 */
@Slf4j
public class UserAuthInterceptor implements HandlerInterceptor {
	@Autowired
	private UserAuthConfiguration userAuthConfiguration;
	@Autowired
	private UserTokenUtils userTokenUtils;
	
	/**
	 * 对用户的token信息进行解析
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader(userAuthConfiguration.getUserTokenHeader());
		IJWTInfo ijwtInfo = userTokenUtils.getInfoFromToken(token);
		
		
		//问题:，这里因该对用户的访问权限进行验证才对？？？，
		UserInfoContext.setToken(token);
		UserInfoContext.setUserID(ijwtInfo.getId());
		UserInfoContext.setName(ijwtInfo.getName());
		UserInfoContext.setUsername(ijwtInfo.getUniqueName());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	/**
	 * 在访问完成之后，删除用户保存的信息
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		UserInfoContext.remove();
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
}	
