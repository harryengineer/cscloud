package com.cscloud.common.core.mybatis;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 这个是所以的实体对象的共有的属性
 * @author Administrator
 *
 */
@Data
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3528950649928407370L;

	/**
	 * 格式化对应的
	 */
	@Column(name = "created_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	
	
	@Column(name = "update_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	
	
}
