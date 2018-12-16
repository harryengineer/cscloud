package com.cscloud.auth.admin.service;

import com.cscloud.auth.admin.domain.AuthUserPo;
import com.cscloud.common.core.support.IService;

public interface AuthUserPoService extends IService<AuthUserPo> {

	AuthUserPo getUserByUsername(String currentUserName);

}
