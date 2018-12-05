package com.cscloud.auth.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 客户端的配置类
 * @author Administrator
 *
 */
@Data
@Configuration
public class ClientConfiguration {
	@Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;
    @Value("${client.token-header}")
    private String clientTokenHeader;
    @Value("#{client.expire}")
    private Integer expire;
    
}
