package com.cscloud.auth.server.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.auth.api.model.RequestAuthentication;
import com.cscloud.auth.server.service.UserAuthService;
import com.cscloud.common.base.wrapper.Wrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 这个是用户的权限的校验，修改，删除等操作
 * @author Administrator
 *
 */
@RequestMapping("/jwt")
@RestController
@Slf4j
public class UserAuthController {
	
	@Autowired
	private UserAuthService userService;
	
	/**
	 * 通过帐号密码获取用户的token
	 * @param requestAuth
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/token",method =  RequestMethod.POST)
	public Wrapper<String> getToken(@RequestBody RequestAuthentication requestAuth) throws Exception {
		log.info("user have getting token and  username :{}, password:{}",requestAuth.getUsername(),requestAuth.getPassword());
		return Wrapper.success(userService.getUserInfo(requestAuth));
	}
	
	/**
	 *用户刷新用的过期时间 
	 *问题: 其他地方没有用到过期时间（在jsonwebtoken  中自动验证了）
	 * @throws Exception 
	 * 
	 */
	@RequestMapping("/refresh")
	public Wrapper<String> refresh(String token) throws Exception{
		return Wrapper.success(userService.refresh(token));
	}
	
	/**
	 * 用来校验用户的 token
	 * @throws Exception 
	 * 
	 */
	@RequestMapping("/verfity")
	public Wrapper<String> verfity(String token) throws Exception{
		userService.verfity(token);
		return Wrapper.success();
	}
}
