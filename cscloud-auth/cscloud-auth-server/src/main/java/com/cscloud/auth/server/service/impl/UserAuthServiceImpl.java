package com.cscloud.auth.server.service.impl;

import javax.annotation.Resource;

import com.cscloud.auth.api.model.AuthUserVo;
import com.cscloud.auth.api.service.admin.AuthAdminUserFeignApi;
import com.cscloud.common.base.wrapper.Wrapper;
import org.springframework.stereotype.Service;

import com.cscloud.auth.api.model.RequestAuthentication;
import com.cscloud.auth.common.bean.JWTInfo;
import com.cscloud.auth.server.service.UserAuthService;
import com.cscloud.auth.server.util.user.UserTokenUtils;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;

/**
 * 用户的远程调用类
 * @author Administrator
 *
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

	@Resource
	private AuthAdminUserFeignApi userAuthFeign;
	@Resource
	private UserTokenUtils userTokenUtils;
	
	@Override
	public String getUserInfo(RequestAuthentication requestAuth) throws Exception {
		Wrapper<AuthUserVo> wrapper = userAuthFeign.validate(requestAuth);
		if (wrapper.getStatus() == 200 && wrapper.getData() != null &&  wrapper.getData().getId() != null) {
			AuthUserVo userInfo = wrapper.getData();
			return userTokenUtils.generateToken(new JWTInfo(userInfo.getUsername(), userInfo.getId().toString(), userInfo.getName()));
		}
		throw new BaseException(ErrorCode.USER_NO_EXIST);
	}

	@Override
	public String refresh(String token) throws Exception {
		return userTokenUtils.generateToken(userTokenUtils.getInfoFromToken(token));
	}

	@Override
	public void verfity(String token) throws Exception {
		userTokenUtils.getInfoFromToken(token);
	}

}
