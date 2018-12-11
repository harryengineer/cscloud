package com.cscloud.auth.server.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.auth.server.config.SecretConfiguration;
import com.cscloud.auth.server.service.AuthClientSerivce;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.wrapper.Wrapper;

/**
 * 这个是用来判断和展示，删除 对应的服务实例
 * @author Administrator
 *
 */
@RequestMapping("/client")
@RestController
public class ClientAuthController {
	
	@Resource
	private AuthClientSerivce authClientService;
	@Resource
	private SecretConfiguration secretConfiguration;
	
	/**
	 * 
	 * 服务实例获取客户端的token
	 * @param clientId
	 * @param secret
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/token")
	public Wrapper<String>  getClientToken(String clientId,String secret) throws Exception{
		if (StringUtils.isBlank(clientId) || StringUtils.isBlank(secret)) {
			return Wrapper.fail(ErrorCode.PARAMETER_CHECK_ERROR);
		}
		
		String token = authClientService.getToken(clientId, secret);
		return Wrapper.success(token);
	}
	
	/**
	 * 通过client获取可以访问的code列表
	 * @param clientId
	 * @param secret
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAllowClient")
	public Wrapper<List<String>> getClient(String clientId,String secret) throws Exception{
		if (StringUtils.isBlank(clientId) || StringUtils.isBlank(secret)) {
			return Wrapper.fail(ErrorCode.PARAMETER_CHECK_ERROR);
		}
	
		List<String> clientCodes = authClientService.getAllowedClient(clientId,secret);
		return Wrapper.success(clientCodes);
	}
	
	/**
	 * 获取该服务实例对其他服务提供的公钥
	 * @param clientId
	 * @param secret
	 * @return
	 */
	@RequestMapping("/getClientPubKey")
	public Wrapper<byte[]> getClientPubKey (String clientId,String secret){
		if (StringUtils.isBlank(clientId) || StringUtils.isBlank(secret)) {
			return Wrapper.fail(ErrorCode.PARAMETER_CHECK_ERROR);
		}
		
		authClientService.validate(clientId,secret);
		return Wrapper.success(secretConfiguration.getServicePubKey());
	}
	
	/**
	 *  根据服务器的帐号和secret验证，获取为用户准备的公钥
	 * @param client
	 * @param secret
	 * @return
	 */
	@RequestMapping("/getUserPubKey")
	public Wrapper<byte[]> getUserPubKey(String clientId,String secret){
		if (StringUtils.isBlank(clientId) || StringUtils.isBlank(secret)) {
			return Wrapper.fail(ErrorCode.PARAMETER_CHECK_ERROR);
		}
		
		authClientService.validate(clientId,secret);
		return Wrapper.success(secretConfiguration.getUserPubKey());
		
	}
	

}
