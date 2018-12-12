package com.cscloud.auth.api.model;

import lombok.Data;

/**
 * 用户信息的dto内容
 * 
 * @author Administrator
 *
 */
//@ApiModel("用户权限用到的dto的信息")
@Data
public class UserAuthInfoDto {
	private Integer id;

	private String username;

	private String password;

	private String name;

	private String birthday;

	private String address;

}
