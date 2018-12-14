package com.cscloud.auth.admin.web.feign;

import java.util.List;
import java.util.Map;

import com.cscloud.auth.api.model.RequestAuthentication;
import com.cscloud.auth.api.service.admin.AuthAdminUserFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.auth.admin.service.PermissionService;
import com.cscloud.auth.api.model.AuthPermissionVo;
import com.cscloud.auth.api.model.AuthUserVo;
import com.cscloud.common.base.wrapper.Wrapper;



/**
 * admin提供的远程方法的调用
 * @author Administrator
 *
 */
@RestController
@Slf4j
public class AuthAdminUserFeignClient implements AuthAdminUserFeignApi {

	    @Autowired
	    private PermissionService permissionService;

		@Override
	    public  Wrapper<List<AuthPermissionVo>> getAllPermission(){
	        return Wrapper.success(permissionService.getAllPermission());
	    }

		@Override
	    public Wrapper<List<AuthPermissionVo>> getPermissionByUsername(@PathVariable("username") String username){
	        return Wrapper.success(permissionService.getPermissionByUsername(username));
	    }

	    /**
	     * 验证并返回用户的信息
	     * @param body
	     * @return
	     */
//	    public  Wrapper<AuthUserVo> validate(@RequestBody Map<String,String> body){
//	        return Wrapper.success(permissionService.validate(body.get("username"),body.get("password")));
//	    }
	    public  Wrapper<AuthUserVo> validate(@RequestBody RequestAuthentication body){
	    	log.info("传入对应的数据{}",body);
	        return Wrapper.success(permissionService.validate(body.getUsername(),body.getPassword()));
	    }

}
