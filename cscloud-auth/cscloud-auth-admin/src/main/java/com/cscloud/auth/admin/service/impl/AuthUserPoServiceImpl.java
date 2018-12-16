package com.cscloud.auth.admin.service.impl;

import org.springframework.stereotype.Service;

import com.cscloud.auth.admin.domain.AuthUserPo;
import com.cscloud.auth.admin.mapper.AuthUserPoMapper;
import com.cscloud.auth.admin.service.AuthUserPoService;
import com.cscloud.common.core.support.BaseService;

/**
 *  用户的逻辑类
 * @author Administrator
 *
 */
@Service
public class AuthUserPoServiceImpl extends BaseService<AuthUserPoMapper, AuthUserPo> implements AuthUserPoService {

	@Override
	public AuthUserPo getUserByUsername(String username) {
		AuthUserPo user = new AuthUserPo();
		user.setUsername(username);
		return mapper.selectOne(user);
	}

}
