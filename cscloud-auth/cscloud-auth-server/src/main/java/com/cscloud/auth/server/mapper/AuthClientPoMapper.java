package com.cscloud.auth.server.mapper;

import java.util.List;

import com.cscloud.auth.server.domain.AuthClientPo;
import com.cscloud.common.core.mybatis.MyMapper;

/**
 * AuthClientPo的对应的持久化操作
 * @author Administrator
 *
 */
public interface AuthClientPoMapper extends MyMapper<AuthClientPo> {

	List<String> getAllowedClient(String clientId);

}
