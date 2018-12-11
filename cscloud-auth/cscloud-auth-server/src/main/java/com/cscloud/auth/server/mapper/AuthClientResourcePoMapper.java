package com.cscloud.auth.server.mapper;

import java.util.List;

import com.cscloud.auth.server.domain.AuthClientPo;
import com.cscloud.auth.server.domain.AuthClientResourcePo;
import com.cscloud.common.core.mybatis.MyMapper;

public interface AuthClientResourcePoMapper extends MyMapper<AuthClientResourcePo> {

	void deleteByclientId(String clientId);

	List<AuthClientPo> getClientPermitResourceByClientId(String clientId);

}
