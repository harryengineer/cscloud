package com.cscloud.auth.api.service.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cscloud.auth.api.model.RequestAuthentication;
import com.cscloud.auth.api.model.UserAuthInfoDto;
import com.cscloud.auth.api.service.server.feign.UserAuthFeignApiHystrix;

/**
 * user的feign的提供api的接口
 * @author Administrator
 *
 */
@FeignClient(value = "cscloud-auth-admin",fallback = UserAuthFeignApiHystrix.class)
public interface UserAuthFeignApi {
	/**
	 * 通过帐号密码获取用户的信息,通过远程调用
	 * @param requestAuth
	 * @return
	 */
	@RequestMapping("/api/user/validate")
	UserAuthInfoDto getUserInfo(RequestAuthentication requestAuth);
}
