package com.cscloud.auth.common.api;

import org.springframework.cloud.openfeign.FeignClient;

import com.cscloud.auth.common.api.hystrix.UserAuthFeignApiHystrix;
import com.cscloud.auth.common.bean.RequestAuthentication;
import com.cscloud.auth.common.dto.UserAuthInfoDto;

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
	UserAuthInfoDto getUserInfo(RequestAuthentication requestAuth);
}
