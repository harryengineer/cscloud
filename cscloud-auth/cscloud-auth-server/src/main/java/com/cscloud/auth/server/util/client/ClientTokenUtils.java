package com.cscloud.auth.server.util.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.common.util.JWTRSAUtils;
import com.cscloud.auth.server.config.ClientConfiguration;
import com.cscloud.auth.server.config.SecretConfiguration;

/**
 * 半个工具类，这个是用于服务的客户端的，核心是将设置的过期时间注入到生成的token中去，并且和对应的解析
 * @author Administrator
 *
 */
@Configuration
public class ClientTokenUtils {
	
	@Autowired
	private ClientConfiguration clientConfig;
	@Autowired
	private SecretConfiguration secretConfiguration;
	
	/**
	 * 用于根据传入的jwt的对象信息，使用工作私钥生成token
	 * @param jwtInfo
	 * @return
	 * @throws Exception
	 */
	public String generateToken(IJWTInfo jwtInfo) throws Exception {
		return JWTRSAUtils.generateToken(jwtInfo,secretConfiguration.getServicePriKey() , clientConfig.getExpire());
	}
	
	/**
	 * 通过传入的token，然后通过公钥获取加密的信息
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public IJWTInfo getInfoFromToken(String token) throws Exception {
		return JWTRSAUtils.getInfoFromToken(token, secretConfiguration.getServicePubKey());
	}
	
	
}
