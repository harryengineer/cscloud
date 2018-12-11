package com.cscloud.auth.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.cscloud.common.base.constant.GlobalConstants;

@Configuration
public class UserAuthConfiguration {
	@Value("${jwt.token-header:null}")
	private String userTokenHeader;
	
	@Value("${jwt.expire}")
	private Integer expire;

	public String getUserTokenHeader() {
		return userTokenHeader;
	}

	public void setUserTokenHeader(String userTokenHeader) {
		this.userTokenHeader = "null".equals(userTokenHeader)?GlobalConstants.USER_AUTH_HEADER:userTokenHeader;
	}

	public Integer getExpire() {
		return expire;
	}

	public void setExpire(Integer expire) {
		this.expire = expire;
	}
	
	
	
}
