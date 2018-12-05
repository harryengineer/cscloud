package com.cscloud.auth.server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 使用lombok和swagger的注解来编写注释认证的客户端信息，
 * 核心来说的话，服务与服务之间也是需要权限认证的，所以这个就是对应的服务认证的对象
 * @author Administrator
 *
 */
@Data
@ApiModel(value="每个提供服务的认证信息")
@Table()
public class AuthClientPo {
	@Id
	// 这里数据的
	@ApiModelProperty(value="客服端信息的id")
	private Integer id;
	@ApiModelProperty(value="服务编码")
	private String code;
	@ApiModelProperty(value="服务登录密钥")
	private String secret;
	@ApiModelProperty(value="服务名")
	private String name;
	@ApiModelProperty(value="是否锁定")
	private String locked = "0";
	@ApiModelProperty(value="描述")
	private String description;
	@ApiModelProperty(value="创建时间")
	@Column(name = "crt_time")
	private Date crtTime;
	@ApiModelProperty(value="创建人")
	@Column(name = "crt_user")
	private String crtUser;
	@ApiModelProperty(value="创建人姓名")
	@Column(name = "crt_name")
	private String crtName;
	@ApiModelProperty(value="创建主机")
	@Column(name = "crt_host")
	private String crtHost;
	@ApiModelProperty(value="更新时间")
	@Column(name = "upd_time")
	private Date updTime;
	@ApiModelProperty(value="更新人")
	@Column(name = "upd_user")
	private String updUser;
	@ApiModelProperty(value="更新姓名")
	@Column(name = "upd_name")
	private String updName;
	@ApiModelProperty(value="更新主机")
	@Column(name = "upd_host")
	private String updHost;

	private String attr1;

	private String attr2;

	private String attr3;

	private String attr4;

	private String attr5;

	private String attr6;

	private String attr7;

	private String attr8;
}
