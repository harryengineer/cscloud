package com.cscloud.auth.common.api.hystrix;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.cscloud.auth.common.api.UserAuthFeignApi;
import com.cscloud.auth.common.bean.RequestAuthentication;
import com.cscloud.auth.common.dto.UserAuthInfoDto;

@Component
public class UserAuthFeignApiHystrix implements UserAuthFeignApi {

	@Override
	public UserAuthInfoDto getUserInfo(RequestAuthentication requestAuth) {
		return null;
	}

}
