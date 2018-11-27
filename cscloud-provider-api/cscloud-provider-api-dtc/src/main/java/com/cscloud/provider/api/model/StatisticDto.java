package com.cscloud.provider.api.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 统计数据的dto
 * @author Administrator
 *
 */
@Data
public class StatisticDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer infoId;
	private String shopId;
	private String custId;
	private Integer receiveNum;
	private Integer onlineLong;
	private Integer transferNum;
	private Integer replyNum;
	private Date createTime;
	private Date onlineTime;	
}
