package com.cscloud.auth.server.service;

import java.util.List;

import com.cscloud.auth.server.domain.AuthClientPo;
import com.cscloud.common.core.support.IService;

public interface AuthClientSerivce extends IService<AuthClientPo> {

	/**
	 * 通过服务的id和secret验证并生成token
	 * @param clientId
	 * @param clientSecret
	 * @return
	 * @throws Exception 
	 */
	String getToken(String clientId, String clientSecret) throws Exception;
	
	/**
	 * 通过服务的id和clientSecret 来获取这个服务所拥有的权限对象
	 * @param clientId
	 * @param clientSecret
	 * @return
	 * @throws Exception 
	 */
	public  AuthClientPo getClient(String clientId, String clientSecret) throws Exception;

	List<String> getAllowedClient(String clientId);
	

}
