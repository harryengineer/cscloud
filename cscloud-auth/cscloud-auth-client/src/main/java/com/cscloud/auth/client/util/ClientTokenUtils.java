package com.cscloud.auth.client.util;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cscloud.auth.api.service.server.ClientAuthFeignApi;
import com.cscloud.auth.client.properties.ClientAuthProperties;
import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.common.util.JWTRSAUtils;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;
import com.cscloud.common.base.wrapper.Wrapper;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 用户的token的工具类，核心是获取用户token已经刷新过期等等
 * 
 * 
 * @author Administrator
 *
 */
@Component
@Slf4j
@EnableScheduling
public class ClientTokenUtils {
	
	@Resource
	private ClientAuthFeignApi clientFeignApi;
	
	@Autowired
	private ClientAuthProperties clientAuthProperties;
	
	public  String clientToken;
	
	public List<String> allowClients;

	public  String getToken() {
		if (this.clientToken == null) {
			getRefreshToken();
		}
		return this.clientToken;
	}
	
	
	public List<String> getAllowClients(){
		if (allowClients == null) {
			allowClients();
		}
		return allowClients;
	}
	/**
	 * 为了防止服务的id失效的话，我们半个小时就刷新一下，过期时间没有添加，
	 * 问题:  没有用到在jsonwebtoken  中自动验证了）
	 * @return
	 */
	@Scheduled(cron = "0 */30 * * * ?")
	public String  getRefreshToken() {
		Wrapper<String> result = clientFeignApi.getClientToken(clientAuthProperties.getClientId(),clientAuthProperties.getClientSecret());
		log.info("the result of refresh client token : {} ",result);
		if (result.getStatus() == 200) {
			clientToken = result.getData();
		}else {
			if (ErrorCode.getByCode(result.getStatus()) != null) {
				throw new BaseException(ErrorCode.getByCode(result.getStatus()));
			}
			throw new BaseException(result.getMessage());
		}
		return clientToken;
	}
	
	/**
	 * 30 查询到自己允许的服务器，并保存到本地
	 */
	@Scheduled(cron = "0 */30 * * * ?")
	public void allowClients() {
		log.info("get the allowed client........{}",clientAuthProperties.getClientId());
		Wrapper<List<String>> clientList = clientFeignApi.getAllowClient(clientAuthProperties.getClientId(),clientAuthProperties.getClientSecret());
		if (clientList.getStatus() == 200) {
			this.allowClients = clientList.getData();
		}else {
			if (ErrorCode.getByCode(clientList.getStatus()) != null) {
				throw new BaseException(ErrorCode.getByCode(clientList.getStatus()));
			}
			throw new BaseException(clientList.getMessage());
		}
	}
	
	public IJWTInfo getJwtInfo(String token) throws Exception {
		return JWTRSAUtils.getInfoFromToken(token, clientAuthProperties.getPubKeyByte());
	}
	

}
