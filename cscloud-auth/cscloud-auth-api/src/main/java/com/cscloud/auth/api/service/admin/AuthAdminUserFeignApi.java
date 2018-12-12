package com.cscloud.auth.api.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cscloud.auth.api.model.AuthPermissionVo;
import com.cscloud.auth.api.model.AuthUserVo;
import com.cscloud.auth.api.service.admin.hystrix.AuthAdminUserFeignApiHystrix;
import com.cscloud.common.base.wrapper.Wrapper;


@FeignClient(value = "cscloud-auth-admin",fallback = AuthAdminUserFeignApiHystrix.class)
@ComponentScan("com.cscloud.auth.api.service")
public interface AuthAdminUserFeignApi {
	
	 public  Wrapper<List<AuthPermissionVo>> getAllPermission();
	 
	 public Wrapper<List<AuthPermissionVo>> getPermissionByUsername(@PathVariable("username") String username);
	 
	 public  Wrapper<AuthUserVo> validate(@RequestBody Map<String,String> body);
}
