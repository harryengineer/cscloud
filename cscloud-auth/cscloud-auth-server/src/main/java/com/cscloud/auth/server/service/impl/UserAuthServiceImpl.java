package com.cscloud.auth.server.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cscloud.auth.common.api.UserAuthFeignApi;
import com.cscloud.auth.common.bean.JWTInfo;
import com.cscloud.auth.common.bean.RequestAuthentication;
import com.cscloud.auth.common.dto.UserAuthInfoDto;
import com.cscloud.auth.server.service.UserAuthService;
import com.cscloud.auth.server.util.user.UserTokenUtils;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;
import com.cscloud.common.base.wrapper.Wrapper;

/**
 * 用户的远程调用类
 * @author Administrator
 *
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

	@Resource
	private UserAuthFeignApi  userAuthFeign;
	@Resource
	private UserTokenUtils userTokenUtils;
	
	@Override
	public String getUserInfo(RequestAuthentication requestAuth) throws Exception {
		UserAuthInfoDto userInfo = userAuthFeign.getUserInfo(requestAuth);
		if (userInfo != null && userInfo.getId() != null) {
			return userTokenUtils.generateToken(new JWTInfo(userInfo.getUsername(), userInfo.getId().toString(), userInfo.getName()));
		}
		throw new BaseException(ErrorCode.USER_NO_EXIST.getCode(), ErrorCode.USER_NO_EXIST.getMessage());
	}

	@Override
	public String refresh(String token) throws Exception {
		return userTokenUtils.generateToken(userTokenUtils.getInfoFromToken(token));
	}

}
