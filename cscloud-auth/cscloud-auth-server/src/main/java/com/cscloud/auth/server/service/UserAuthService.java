package com.cscloud.auth.server.service;


import com.cscloud.auth.api.model.RequestAuthentication;

public interface UserAuthService {

	/**
	 * 远程调用通过账户名称和密码调用
	 * @param requestAuth
	 * @return
	 * @throws Exception
	 */
	String getUserInfo( RequestAuthentication requestAuth) throws Exception;

	/**
	 * 用来刷新用的token，核心是刷新用户的过期时间
	 * @param token
	 * @return
	 * @throws Exception 
	 */
	String refresh(String token) throws Exception;

	void verfity(String token) throws Exception;

}
