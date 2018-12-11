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
	
	/**
	 * 通过clientid获取本机允许访问的所有的client的资源code。
	 */
	List<String> getAllowedClient(String clientId);

}
