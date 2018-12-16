package com.cscloud.auth.server.service;

import com.cscloud.auth.server.domain.AuthClientResourcePo;
import com.cscloud.auth.server.dto.ClientReousrceDto;
import com.cscloud.common.core.support.IService;

public interface AuthClientResourceService extends IService<AuthClientResourcePo> {
	/**
	 * 修改 服务器可以访问的资源
	 * @param clientId
	 * @param serviceIds
	 */
	void modifyPermitSource(Integer clientId, String serviceIds);

	ClientReousrceDto getClientPermitResource(Integer clientId);
}
