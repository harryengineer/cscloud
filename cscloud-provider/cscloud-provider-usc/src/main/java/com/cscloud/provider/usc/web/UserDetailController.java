package com.cscloud.provider.usc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.provider.usc.service.UserDetailService;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/userDetail",tags= {"这是个描述用户细节的类"})
@RequestMapping("/userDetail")
public class UserDetailController {
	
	@Autowired
	private UserDetailService userDetailService;
	
	@RequestMapping(value = "/getUserDetailById",method = RequestMethod.GET)
	@ApiOperation(value = "这个是通过用户的id获取用户细节",httpMethod = "GET")
	public String getUserDetailById(@ApiParam(value = "是对应的id", name = "id")Integer id) {
		return userDetailService.getUserDetailById(id);
	}
	
	
	
	

}
