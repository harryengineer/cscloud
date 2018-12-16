package com.cscloud.auth.api.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 权限认证的vo的展示类
 * @author Administrator
 *
 */
@Data
public class AuthPermissionVo implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -1501412463864049706L;
	private String code;
	private String type;
	private String uri;
	private String method;
	private String name;
	private String menu;
}
