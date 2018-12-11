package com.cscloud.auth.server.dto;

import com.cscloud.auth.common.bean.IJWTInfo;

/**
 * dto对象，用来封装clientinfo到  jwtinfo中去
 * @author Administrator
 *
 */
public class ClientJwtInfoDto implements IJWTInfo {
	
	private String clientName;
	
	private String id;
	
	private String name;

	public ClientJwtInfoDto(String clientName, String id, String name) {
		super();
		this.clientName = clientName;
		this.id = id;
		this.name = name;
	}

	@Override
	public String getUniqueName() {
		// TODO Auto-generated method stub
		return clientName;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
