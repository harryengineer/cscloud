package com.cscloud.auth.common.util;

import java.util.Date;

import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.time.DateUtils;

import com.cscloud.auth.common.bean.IJWTInfo;
import com.cscloud.auth.common.bean.JWTInfo;
import com.cscloud.common.base.constant.GlobalConstants;
import com.cscloud.common.base.util.RSAUtils;
import com.cscloud.common.base.util.StringHelperUtils;

/**
 * jwt的工具类，用来获取对应的加密信息
 * @author Administrator
 *
 */
public class JWTRSAUtils {
    private static RSAUtils rsaKeyHelper = new RSAUtils();
    /**
     * 密钥加密token
     * 还有过期时间
     *
     * @param jwtInfo
     * @param priKeyPath
     * @param expire  这个是秒数
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(GlobalConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(GlobalConstants.JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateUtils.addSeconds(new Date(), expire))
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, byte priKey[], int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(GlobalConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(GlobalConstants.JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateUtils.addSeconds(new Date(), expire))
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }
    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {
        try {
            return  Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            throw new BaseException(ErrorCode.CLIENT_TOKEN_EMPTY);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelperUtils.getNoNullString(body.get(GlobalConstants.JWT_KEY_USER_ID)), StringHelperUtils.getNoNullString(body.get(GlobalConstants.JWT_KEY_NAME)));
    }
    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelperUtils.getNoNullString(body.get(GlobalConstants.JWT_KEY_USER_ID)), StringHelperUtils.getNoNullString(body.get(GlobalConstants.JWT_KEY_NAME)));
    }
}
