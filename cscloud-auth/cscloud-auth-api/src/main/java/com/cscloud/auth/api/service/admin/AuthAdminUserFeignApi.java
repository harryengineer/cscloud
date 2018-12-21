package com.cscloud.auth.api.service.admin;

import java.util.List;

import com.cscloud.auth.api.model.RequestAuthentication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cscloud.auth.api.model.AuthPermissionVo;
import com.cscloud.auth.api.model.AuthUserVo;
import com.cscloud.auth.api.service.admin.hystrix.AuthAdminUserFeignApiHystrix;
import com.cscloud.common.base.wrapper.Wrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 这个feign对外提供的调用接口
 */
@FeignClient(value = "cscloud-auth-admin",fallback = AuthAdminUserFeignApiHystrix.class)
public interface AuthAdminUserFeignApi {
	@RequestMapping(value = "/api/permissions", method = RequestMethod.GET)
	 public  Wrapper<List<AuthPermissionVo>> getAllPermission();

	@RequestMapping(value = "/api/user/un/{username}/permissions", method = RequestMethod.GET)
	 public Wrapper<List<AuthPermissionVo>> getPermissionByUsername(@PathVariable("username") String username);

	/**
	 * 验证并返回用户的信息
	 * @param body
	 * @return
	 */
//	@RequestMapping(value = "/user/check", method = RequestMethod.POST)
//	 public  Wrapper<AuthUserVo> validate(@RequestBody Map<String,String> body);

	@RequestMapping(value = "/api/user/check", method = RequestMethod.POST)
	public  Wrapper<AuthUserVo> validate(@RequestBody RequestAuthentication body);
}
