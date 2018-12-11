package com.cscloud.auth.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.cscloud.common.base.constant.GlobalConstants;

/**
 * 客户端的配置类
 * @author Administrator
 *
 */
@Configuration
public class ClientConfiguration {
	@Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;
    @Value("${client.token-header:null}")
    private String clientTokenHeader;
    @Value("#{client.expire}")
    private Integer expire;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getClientTokenHeader() {
		return clientTokenHeader;
	}
	public void setClientTokenHeader(String clientTokenHeader) {
		this.clientTokenHeader = "null".equals(clientTokenHeader)?GlobalConstants.CLIENT_AUTH_HEADER:clientTokenHeader;
	}
	public Integer getExpire() {
		return expire;
	}
	public void setExpire(Integer expire) {
		this.expire = expire;
	}
    
    
    
}
