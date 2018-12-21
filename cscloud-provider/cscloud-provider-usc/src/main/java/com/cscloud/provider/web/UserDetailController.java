package com.cscloud.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.common.base.wrapper.Wrapper;
import com.cscloud.provider.api.model.StatisticDto;
import com.cscloud.provider.service.UserDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/userDetail",tags= {"这是个描述用户细节的类"})
@RequestMapping("/test")
public class UserDetailController {
	
	@Autowired
	private UserDetailService userDetailService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getUserDetailById")
	@ApiOperation(value = "这个是通过用户的id获取用户细节",httpMethod = "GET")
	public Wrapper<StatisticDto> getUserDetailById(@ApiParam(value = "是对应的id", name = "id")Integer id) {
		System.out.println(id);
		 StatisticDto statisticDto = userDetailService.getUserDetailById(id);
		return Wrapper.success(statisticDto);
	}
	
	@RequestMapping(value = "/helloworld")
	public Wrapper  hello(String test) {
		return Wrapper.success("hello");
	}
}
