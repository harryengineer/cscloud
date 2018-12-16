package com.cscloud.auth.api.model;

import lombok.Data;

@Data
public class AuthUserVo {
	public String id;
	public String username;
	public String password;
	public String name;
	private String description;
}
