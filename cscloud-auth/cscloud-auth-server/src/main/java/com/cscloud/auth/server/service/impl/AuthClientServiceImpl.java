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
public class AuthClientServiceImpl extends BaseService<AuthClientPoMapper,AuthClientPo>  implements AuthClientSerivce{
	

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
		AuthClientPo one = mapper.selectOne(authClientPo);
		if (one == null){
			throw new BaseException(ErrorCode.CLIENT_TOKEN_SIGNATURE_ERROR);
		}
		
		return one;
		
	}
	@Override
	public List<String> getAllowedClient(String clientId) {
		List<String> list = mapper.getAllowedClient(clientId);
		if (list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<String> getAllowedClient(String clientId, String secret) throws Exception {
		AuthClientPo client = getClient(clientId,secret);
		return getAllowedClient(String.valueOf(client.getId()));
		
	}

	@Override
	public void validate(String clientId, String secret) {
		AuthClientPo clientPo = new AuthClientPo();
		clientPo.setCode(clientId);
		clientPo.setSecret(secret);
		AuthClientPo po = mapper.selectOne(clientPo);
		if (po == null) {
			throw new BaseException(ErrorCode.CLIENT_NO_CLIENTID_SECRET);
		}
		
	}

}
