package com.cscloud.auth.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 获取所有的密钥信息
 *
 */
@Configuration
@Data
public class SecretConfiguration {
	//用户自己的密钥
    @Value("${jwt.rsa-secret}")
    private String userSecret;
    //工作密钥
    @Value("${client.rsa-secret}")
    private String serviceSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
    private byte[] servicePriKey;
    private byte[] servicePubKey;
}
