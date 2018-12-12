package com.cscloud.auth.server.dto;

import java.util.List;

import com.cscloud.auth.server.domain.AuthClientPo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用来获取  客服端的可以访问的资源服务器的地址
 * @author Administrator
 *
 */
@ApiModel(value="用来获取  客服端的可以访问的资源服务器的地址")
@Data
public class ClientReousrceDto {
	
	@ApiModelProperty(value="客服端信息的id")
	private Integer clientId;
	@ApiModelProperty(value="客服端服务编码")
	private String clientCode;
	@ApiModelProperty(value="客服端服务名")
	private String clientName;
	@ApiModelProperty(value="客服端是否锁定")
	private String clientLocked;
	@ApiModelProperty(value="客服端描述")
	private String clientDescription;
	
	@ApiModelProperty(value="服务端对象")
	private List<AuthClientPo> serviceClientPo;
	
	

	

}
