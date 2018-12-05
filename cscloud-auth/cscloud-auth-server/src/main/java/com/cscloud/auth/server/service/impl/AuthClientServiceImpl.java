package com.cscloud.auth.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cscloud.auth.server.domain.AuthClientPo;
import com.cscloud.auth.server.dto.ClientJwtInfoDto;
import com.cscloud.auth.server.mapper.AuthClientPoMapper;
import com.cscloud.auth.server.service.AuthClientSerivce;
import com.cscloud.auth.server.util.client.ClientTokenUtils;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;
import com.cscloud.common.core.support.BaseService;

/**
 *  服务与服务之间需要认证的，是查询和判断服务是否有有权限等操作
 * @author Administrator
 *
 */
@Service
public class AuthClientServiceImpl extends BaseService<AuthClientPo>  implements AuthClientSerivce{
	
	
	@Autowired
	private AuthClientPoMapper authClientPoMapper;
	@Autowired
	private ClientTokenUtils clientTokenUtils;
	
	@Override
	public String getToken(String clientId, String clientSecret) throws Exception {
		AuthClientPo  clientPo = getClient(clientId,clientSecret);
		return clientTokenUtils.generateToken(new ClientJwtInfoDto(clientPo.getCode(), clientPo.getId().toString(), clientPo.getName()));
	}
	
	/**
	 * 获取clientpo的对象，如果为空的，那么就报错
	 */
	@Override
	public  AuthClientPo getClient(String clientId, String clientSecret)throws Exception {
		AuthClientPo authClientPo = new AuthClientPo();
		authClientPo.setSecret(clientSecret);
		authClientPo.setCode(clientId);
		AuthClientPo one = authClientPoMapper.selectOne(authClientPo);
		if (one == null){
			throw new BaseException(ErrorCode.CLIENT_TOKEN_SIGNATURE_ERROR.getCode(), ErrorCode.CLIENT_TOKEN_SIGNATURE_ERROR.getMessage());
		}
		
		return one;
		
	}
	
	/**
	 * 通过clientid获取本机允许访问的所有的client。
	 */
	@Override
	public List<String> getAllowedClient(String clientId) {
		List<String> list = authClientPoMapper.getAllowedClient(clientId);
		if (list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

}
