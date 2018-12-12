package com.cscloud.auth.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cscloud.common.base.handler.GlobalExceptionHandler;

/**
 * 注入全局处理的异常的类
 * @author Administrator
 *
 */
@Configuration
public class AuthExceptionHandlerConfiguration {
	
	@Bean
	public GlobalExceptionHandler getGlobalExceptionHandler() {
		return new GlobalExceptionHandler();
	}

}
