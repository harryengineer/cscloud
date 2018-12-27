package com.cscloud.auth.client.properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 服务实例对应的权限的配置
 * @author Administrator
 *
 */
@Component
public class ClientAuthProperties {
    private byte[] pubKeyByte;
    @Value("${auth.client.id}")
    private String clientId;
    @Value("${auth.client.secret}")
    private String clientSecret;
    @Value("${auth.client.token-header}")
    private String tokenHeader;
    @Value("${spring.application.name}")
    private String applicationName;
	public byte[] getPubKeyByte() {
		return pubKeyByte;
	}
	public void setPubKeyByte(byte[] pubKeyByte) {
		this.pubKeyByte = pubKeyByte;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId =  StringUtils.isBlank(clientId)?applicationName:clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getTokenHeader() {
		return tokenHeader;
	}
	public void setTokenHeader(String tokenHeader) {
		this.tokenHeader = tokenHeader;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
