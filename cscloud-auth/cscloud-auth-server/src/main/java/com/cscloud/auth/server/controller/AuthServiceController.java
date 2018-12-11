package com.cscloud.auth.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.auth.server.dto.ClientReousrceDto;
import com.cscloud.auth.server.service.AuthClientResourceService;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.wrapper.Wrapper;

/**
 * 单个服务实例可以访问其他服务的操作。比如user 可以访问 订单的那些模块等操作
 * @author Administrator
 *
 */
@RequestMapping("/service")
@RestController
public class AuthServiceController {
	
	@Autowired
	private AuthClientResourceService authClientResource;
	
	/**
	 * 修改客户端可以访问的资源路径
	 * @param clientId
	 * @param serviceIds
	 * @return
	 */
	@RequestMapping(value = "/modifyPermitSource",method = RequestMethod.POST)
	public Wrapper<String> modifyPermitSource(Integer clientId, String serviceIds){
		if (clientId == null) {
			return Wrapper.fail(ErrorCode.PARAMETER_CHECK_ERROR);
		}
		
		authClientResource.modifyPermitSource(clientId,serviceIds);
		return Wrapper.success();
	}
	
	
	/**
	 * 获取服务器可以访问的资源服务器的列表
	 * @param clientId
	 * @return
	 */
	@RequestMapping("/getClientPermitResource")
	public Wrapper<ClientReousrceDto>  getClientPermitResource(Integer clientId){
		if (clientId == null) {
			return Wrapper.fail(ErrorCode.PARAMETER_CHECK_ERROR);
		}
		ClientReousrceDto dto = authClientResource.getClientPermitResource(clientId);
		return Wrapper.success(dto);
	}
	
	
}

