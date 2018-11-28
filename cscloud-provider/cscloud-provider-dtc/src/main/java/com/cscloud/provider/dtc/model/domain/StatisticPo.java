package com.cscloud.provider.dtc.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import org.apache.ibatis.type.Alias;

import com.cscloud.common.core.mybatis.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name= "cs_statistics_info")
@Alias(value = "statisticPo")
public class StatisticPo extends BaseEntity implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 4722570153950536300L;
	private Integer statisticId;
	private String shopId;
	private String custId;
	private Integer receiveNum;
	private Integer onlineLong;
	private Integer transferNum;
	private Integer replyNum;
	private Date loginTime;	

}
