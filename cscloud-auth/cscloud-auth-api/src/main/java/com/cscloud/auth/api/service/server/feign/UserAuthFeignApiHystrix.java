package com.cscloud.auth.api.service.server.feign;

import org.springframework.stereotype.Component;

import com.cscloud.auth.api.model.RequestAuthentication;
import com.cscloud.auth.api.model.UserAuthInfoDto;
import com.cscloud.auth.api.service.server.UserAuthFeignApi;

@Component
public class UserAuthFeignApiHystrix implements UserAuthFeignApi {

	@Override
	public UserAuthInfoDto getUserInfo(RequestAuthentication requestAuth) {
		return null;
	}

}
