package com.cscloud.auth.server.util.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.common.util.JWTRSAUtils;
import com.cscloud.auth.server.config.SecretConfiguration;
import com.cscloud.auth.server.config.UserAuthConfiguration;

/**
 *  普通用户访问的token的生成和解析
 * @author Administrator
 *
 */
@Configuration
public class UserTokenUtils {
	@Autowired
	private UserAuthConfiguration userAuthConfiguration;
	@Autowired
	private SecretConfiguration secretConfiguration;
	
	/**
	 * 用于根据传入的jwt的对象信息，使用工作私钥生成token
	 * @param jwtInfo
	 * @return
	 * @throws Exception
	 */
	public String generateToken(IJWTInfo jwtInfo) throws Exception {
		return JWTRSAUtils.generateToken(jwtInfo,secretConfiguration.getUserPriKey() , userAuthConfiguration.getExpire());
	}
	
	/**
	 * 通过传入的token，然后通过公钥获取加密的信息
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public IJWTInfo getInfoFromToken(String token) throws Exception {
		return JWTRSAUtils.getInfoFromToken(token, secretConfiguration.getUserPubKey());
	}
	
	
}
