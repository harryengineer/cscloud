package com.cscloud.auth.api.service.server;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cscloud.common.base.wrapper.Wrapper;

/**
 * 远程调用的api，用来获取用户的公钥内容
 * @author Administrator
 *
 */
@FeignClient(value ="cscloud-auth-server")
public interface ClientAuthFeignApi {
	
	@GetMapping(value = "/client/token")
	public  Wrapper<String> getClientToken(@RequestParam(name = "clientId") String clientId, @RequestParam(name = "secret") String secret) ;
	
	@GetMapping(value = "/client/getAllowClient")
	public Wrapper<List<String>> getAllowClient(@RequestParam(name = "clientId") String clientId, @RequestParam(name = "secret") String secret);

	@GetMapping(value = "/client/getClientPubKey")
	public Wrapper<byte[]> getClientPublicKey(@RequestParam(name = "clientId")String clientId,@RequestParam(name = "secret")String secret);
	
	@GetMapping(value = "/user/getUserPubKey")
	public Wrapper<byte[]> getUserPublicKey(@RequestParam(name = "clientId")String clientId,@RequestParam(name = "secret")String secret);
	
	
}
