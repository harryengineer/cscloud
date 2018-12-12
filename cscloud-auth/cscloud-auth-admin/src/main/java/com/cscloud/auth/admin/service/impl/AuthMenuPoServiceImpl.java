package com.cscloud.auth.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cscloud.auth.admin.domain.AuthMenuPo;
import com.cscloud.auth.admin.mapper.AuthMenuPoMapper;
import com.cscloud.auth.admin.service.AuthMenuPoService;
import com.cscloud.common.core.support.BaseService;

@Service
public class AuthMenuPoServiceImpl extends BaseService<AuthMenuPoMapper,AuthMenuPo> implements AuthMenuPoService {

	 public List<AuthMenuPo> getUserAuthorityMenuByUserId(int id) {
	        return mapper.selectAuthorityMenuByUserId(id);
	    }

	@Override
	public List<AuthMenuPo> getUserAuthoritySystemByUserId(int userId) {
		// TODO Auto-generated method stub
		  return mapper.selectAuthoritySystemByUserId(userId);
	}


}
