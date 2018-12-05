package com.cscloud.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cscloud.common.base.handler.GlobalExceptionHandler;

/**
 * 注入异常的类，可以通过@Import直接导入
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
