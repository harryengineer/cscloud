package com.cscloud.auth.client.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cscloud.auth.client.properties.UserAuthProperties;
import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.common.util.JWTRSAUtils;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;



/**
 * 
 * 通过用户的token获取用户的对应的信息
 * @author Administrator
 *
 */
@Component
public class UserTokenUtils {
	@Autowired
    private UserAuthProperties userAuthProperties;
	
	/**
	 * 获取用户信息
	 * @param token
	 * @return
	 * @throws Exception
	 */
    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTRSAUtils.getInfoFromToken(token, userAuthProperties.getPubKeyByte());
            }catch (ExpiredJwtException ex){
                throw new BaseException(ErrorCode.USER_TOKEN_EXPIRED);
            }catch (SignatureException ex){
            	   throw new BaseException(ErrorCode.USER_TOKEN_SIGNATURE_ERROR);
            }catch (IllegalArgumentException ex){
            	   throw new BaseException(ErrorCode.SYSTEM_ERROR);
            }
    }
}
