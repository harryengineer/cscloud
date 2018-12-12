package com.cscloud.auth.api.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * 请求认证的对象，用来帐号和密码的校验，使用spring的valid进行校验
 * @author Administrator
 *
 */
@Data
public class RequestAuthentication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2150650668067071300L;
	
	@NotBlank
	@Min(value= 6)
	@Max(value = 20)
	@Pattern(regexp = "^[A-Za-z0-9]{4,40}$",message = "账户必须是英文或者数字")
	private String username;
	
	@NotBlank
	@Min(value= 6,message = "密码必须大于6位")
	@Max(value = 20,message = "密码必须小于40位")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_!@#$%\\^\\+\\*&\\\\\\/\\?\\|:\\.<>{}()';=\")*]{6,20}$",message= "密码格式错误,只能是数字字母和特殊符号")
	private String password;
}
