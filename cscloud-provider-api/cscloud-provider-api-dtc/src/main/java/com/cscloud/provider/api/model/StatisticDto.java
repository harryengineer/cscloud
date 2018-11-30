package com.cscloud.provider.api.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统计数据的dto
 * @author Administrator
 *
 */
@Data // @相当于
@ApiModel
public class StatisticDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(name = "statisticId",value = "统计的id",example = "1")
	private Integer statisticId;
	@ApiModelProperty(name = "shopId",value = "店铺的的id",example = "1")
	private String shopId;
	@ApiModelProperty(name = "custId",value = "客服的id",example = "1")
	private String custId;
	@ApiModelProperty(name = "receiveNum",value = "回答的数量",example = "1")
	private Integer receiveNum;
	@ApiModelProperty(name = "onlineLong",value = "在线时长",example = "1")
	private Integer onlineLong;
	@ApiModelProperty(name = "transferNum",value = "转接的数量",example = "1")
	private Integer transferNum;
	@ApiModelProperty(name = "replyNum",value = "统计回答数量",example = "1")
	private Integer replyNum;
	@ApiModelProperty(name = "createTime",value = "创建时间",example = "1")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	@ApiModelProperty(name = "loginTime",value = "登录时间",example = "1")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date loginTime;	
}
