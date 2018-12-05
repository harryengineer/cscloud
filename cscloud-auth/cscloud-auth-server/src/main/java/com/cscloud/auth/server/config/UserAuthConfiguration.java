package com.cscloud.auth.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class UserAuthConfiguration {
	@Value("${jwt.token-header}")
	private String userTokenHeader;
	
	@Value("${jwt.expire}")
	private Integer expire;
	
}
