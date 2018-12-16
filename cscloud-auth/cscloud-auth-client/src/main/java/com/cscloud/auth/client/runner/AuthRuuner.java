package com.cscloud.auth.client.runner;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cscloud.auth.api.service.server.ClientAuthFeignApi;
import com.cscloud.auth.client.properties.ClientAuthProperties;
import com.cscloud.auth.client.properties.UserAuthProperties;
import com.cscloud.common.base.exception.BaseException;
import com.cscloud.common.base.wrapper.HttpStatus;
import com.cscloud.common.base.wrapper.Wrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 随着项目启动，用来获取对应的公钥数据
 * @author Administrator
 *
 */
@Component
@EnableScheduling
@Slf4j
public class AuthRuuner implements CommandLineRunner {
	
	@Resource
	private UserAuthProperties userAuthProperties;
	
	@Resource
	private ClientAuthProperties clientAuthProperties;
	
	@Resource
	private ClientAuthFeignApi authFeignApi;
	
	// 获取用户的信息
	@Override
	public void run(String... args) throws Exception {
		log.info("get the public key");
		try {
			refreshUserPublicKey();
		} catch (Exception e) {
			log.error("获取user的公钥失败，稍后重试,异常原因{}",e.getMessage());
		}
		
		try {
			refreshClientPublicKey();
		} catch (Exception e) {
			log.error("获取client的公钥失败，稍后重试,异常原因{}",e.getMessage());
		}
		
	}

	/**
	 *10分钟获取一次公钥
	 *
	 */
	@Scheduled(cron = "0 0/10 * * * ?")
	private void refreshClientPublicKey() {
		Wrapper<byte[]> result = authFeignApi.getClientPublicKey(clientAuthProperties.getClientId(),clientAuthProperties.getClientSecret());
		log.info("获取加密client的publickey的数据：{}",result.getStatus());
		if (result.getStatus() == HttpStatus.OK.value()) {
			clientAuthProperties.setPubKeyByte(result.getData());
		}else {
			throw new BaseException(result.getMessage());
		}
			
	}

	@Scheduled(cron = "0 */10 * * * ?")
	private void refreshUserPublicKey() {
		Wrapper<byte[]> result = authFeignApi.getUserPublicKey(clientAuthProperties.getClientId(),clientAuthProperties.getClientSecret());
		log.info("获取加密user的publickey的数据：{}",result.getStatus());
		if (result.getStatus() == HttpStatus.OK.value()) {
			userAuthProperties.setPubKeyByte(result.getData());
		}else {
			throw new BaseException(result.getMessage());
		}
	}
	
	

}
