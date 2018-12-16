package com.cscloud.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cscloud.common.config.configuration.RedisConfiguration;
import com.cscloud.common.config.configuration.Swagger2Configuration;

/**
 * 
 * 配置都已经写入到common中了，如果需要直接通过@Import直接注册就可以
 *  @author Administrator
// *
// */
//@Configuration
//public class InjectConfiguration {
//
//	@Bean
//	public Swagger2Configuration swagger2Configuration() {
//		return new Swagger2Configuration();
//	}
//
//
//	@Bean
//	public RedisConfiguration RedisConfiguration() {
//		return new RedisConfiguration();
//	}
//
//}
