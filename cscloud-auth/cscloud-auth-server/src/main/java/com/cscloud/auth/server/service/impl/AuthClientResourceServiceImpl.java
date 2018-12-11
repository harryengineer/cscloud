package com.cscloud.auth.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.cscloud.auth.server.domain.AuthClientPo;
import com.cscloud.auth.server.domain.AuthClientResourcePo;
import com.cscloud.auth.server.dto.ClientReousrceDto;
import com.cscloud.auth.server.mapper.AuthClientPoMapper;
import com.cscloud.auth.server.mapper.AuthClientResourcePoMapper;
import com.cscloud.auth.server.service.AuthClientResourceService;
import com.cscloud.common.core.support.BaseService;

@Service
public class AuthClientResourceServiceImpl extends BaseService<AuthClientResourcePoMapper,AuthClientResourcePo> implements AuthClientResourceService {

	@Resource
	private AuthClientResourcePoMapper resourceMapper;
	@Resource
	private AuthClientPoMapper clientPoMapper;

	@Override
	public void modifyPermitSource(Integer clientId, String serviceIds) {
		// 这里没有写通用的mapper
		resourceMapper.deleteByclientId(String.valueOf(clientId));
		if (StringUtils.isNotBlank(serviceIds)) {
			String[] serviceids = serviceIds.split(",");
			for (String serviceId : serviceids) {
				// 判断是否为字符串是否是数字
				if (StringUtils.isNumeric(serviceId)) {
					AuthClientResourcePo resourcePo = new AuthClientResourcePo();
					resourcePo.setClientId(clientId + "");
					resourcePo.setServiceId(serviceId);
					// 问题: 如果修改的话，应该登记对应的修改人才对
					resourceMapper.insertSelective(resourcePo);
				}
			}
		}

	}

	
	@Override
	public ClientReousrceDto getClientPermitResource(Integer clientId) {
		 List<AuthClientPo> authClientPos = resourceMapper.getClientPermitResourceByClientId(String.valueOf(clientId));
		 AuthClientPo clientPo = clientPoMapper.selectByPrimaryKey(clientId);
		 ClientReousrceDto dto = new ClientReousrceDto();
		 dto.setClientCode(clientPo.getCode());
		 dto.setClientDescription(clientPo.getDescription());
		 dto.setClientId(clientId);
		 dto.setClientLocked(clientPo.getLocked());
		 dto.setClientName(clientPo.getName());
		 dto.setServiceClientPo(authClientPos);
		return dto;
		
	}

}
