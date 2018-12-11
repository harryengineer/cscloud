package com.cscloud.common.core.mybatis;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 这个是所以的实体对象的共有的属性
 * @author Administrator
 *
 */
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3528950649928407370L;

	/**
	 * 格式化对应的
	 */
	@Column(name = "crt_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date crtTime;
	
	
}
