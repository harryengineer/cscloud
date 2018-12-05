package com.cscloud.provider.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;

import com.cscloud.common.core.mybatis.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 是统计数据的对象实体
 * @author Administrator
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Table(name= "cs_statistics_info")
@Alias(value = "statisticPo")
public class StatisticPo extends BaseEntity implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 4722570153950536300L;
	@Id
	//主键使用数据库自动生成的
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Integer statisticId;
	private String shopId;
	private String custId;
	private Integer receiveNum;
	private Integer onlineLong;
	private Integer transferNum;
	private Integer replyNum;
	private Date loginTime;	

}
