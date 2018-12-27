package com.cscloud.auth.client.properties;

import org.springframework.beans.factory.annotation.Value;

import com.cscloud.common.base.constant.GlobalConstants;
import org.springframework.stereotype.Component;

/**
 *  用来获取作为用户需要的配置,不配置默认是Authentication
 * @author Administrator
 *
 */
@Component
public class UserAuthProperties {
	
	@Value("${auth.user.token-header:null}")
	public String userTokenHeader;
	
	public byte[] pubKeyByte;

	public String getUserTokenHeader() {
		return userTokenHeader;
	}

	public void setUserTokenHeader(String userTokenHeader) {
		this.userTokenHeader = "null".equals(userTokenHeader)?GlobalConstants.USER_AUTH_HEADER:userTokenHeader;
	}

	public byte[] getPubKeyByte() {
		return pubKeyByte;
	}

	public void setPubKeyByte(byte[] pubKeyByte) {
		this.pubKeyByte = pubKeyByte;
	}
}
