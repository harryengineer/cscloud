package com.cscloud.auth.admin.service;

import java.util.List;

import com.cscloud.auth.admin.domain.AuthMenuPo;
import com.cscloud.common.core.support.IService;

public interface AuthMenuPoService extends IService<AuthMenuPo> {

	List<AuthMenuPo> getUserAuthorityMenuByUserId(int userId);

	List<AuthMenuPo> getUserAuthoritySystemByUserId(int userId);


}
