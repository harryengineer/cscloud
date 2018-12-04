/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：BusinessException.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */
package com.cscloud.common.base.exception;

import com.cscloud.common.base.constant.ErrorCode;

/**
 * 业务异常的基本类
 *
 * @author Administrator
 */

public class BaseException extends RuntimeException {

	/**
	 * 异常码
	 */
	protected int code;

	private static final long serialVersionUID = 3160241586346324994L;

	public BaseException() {
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(int code, String message) {
		super(message);
		this.code = code;
	}

	public BaseException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
	}

	public BaseException(ErrorCode errorCode, Object... args) {
		super(String.format(errorCode.getMessage(), args));
		this.code = Integer.valueOf(errorCode.getCode());
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
