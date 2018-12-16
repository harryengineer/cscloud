package com.cscloud.auth.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cscloud.auth.admin.domain.AuthElementPo;
import com.cscloud.auth.admin.mapper.AuthElementPoMapper;
import com.cscloud.auth.admin.service.AuthElementPoService;
import com.cscloud.common.core.support.BaseService;

@Service
public class AuthElementPoServiceImpl extends BaseService<AuthElementPoMapper, AuthElementPo>
		implements AuthElementPoService {

	@Override
	public List<AuthElementPo> getAuthorityElementByUserIdAndMenuId(String userId, String menuId) {
		// TODO Auto-generated method stub
		return mapper.getAuthorityElementByUserIdAndMenuId(userId, menuId);
	}

	@Override
	public List<AuthElementPo> getAuthorityElementByUserId(String userId) {
		return mapper.getAuthorityElementByUserId(userId);
	}
	
	@Override
	public List<AuthElementPo> getAllElementPermissions() {
		return mapper.selectAllElementPermissions();
	}

}
