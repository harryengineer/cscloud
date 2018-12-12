package com.cscloud.auth.api.service.admin.hystrix;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cscloud.auth.api.model.AuthPermissionVo;
import com.cscloud.auth.api.model.AuthUserVo;
import com.cscloud.auth.api.service.admin.AuthAdminUserFeignApi;
import com.cscloud.common.base.wrapper.Wrapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthAdminUserFeignApiHystrix implements AuthAdminUserFeignApi {

	@Override
	public Wrapper<List<AuthPermissionVo>> getAllPermission() {
		log.error("getAllPermission 调用异常");
		return null;
	}

	@Override
	public Wrapper<List<AuthPermissionVo>> getPermissionByUsername(String username) {
	     log.error("调用{}异常{}","getPermissionByUsername",username);
		return null;
	}

	@Override
	public Wrapper<AuthUserVo> validate(Map<String, String> body) {
		log.error("调用异常：{}",body);
		return null;
	}

}
