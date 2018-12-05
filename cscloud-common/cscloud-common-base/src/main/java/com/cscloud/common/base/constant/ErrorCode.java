package com.cscloud.common.base.constant;

/**
 *  自定义的错误代码
 * @author Administrator
 *
 */
public enum ErrorCode {
	    SYSTEM_ERROR(500, "系统错误"),
	    PARAMETER_CHECK_ERROR(400, "参数校验错误"),
	    AUTH_VALID_ERROR(701, "用户权限不足"),
	    UNLOGIN_ERROR(401, "用户未登录或登录状态超时失效"),
	    
	    //token异常
	    /**
	     * 用户的token的超过时间
	     */
	    USER_TOKEN_EXPIRED(40001,"user  token expired"),
	    /**
	     *  用户的token校验失败
	     */
	 	USER_TOKEN_SIGNATURE_ERROR(40002,"User token signature error!"),
	 	/**
	 	 * 用户的token问空或者为null
	 	 */
	 	USER_TOKEN_EMPTY(40003,"user Token is null or Empty"),
	 	
	 	/**
	 	 *  用户不存在
	 	 */
	 	USER_NO_EXIST(40004,"user  is not  exist"),
		
		 /**
	     * 服务的token的超过时间
	     */
	    CLIENT_TOKEN_EXPIRED(41001,"client  token expired"),
	    /**
	     *  服务的token校验失败
	     */
	    CLIENT_TOKEN_SIGNATURE_ERROR(41002,"client token signature error!"),
	 	/**
	 	 * 服务的token问空或者为null
	 	 */
	    CLIENT_TOKEN_EMPTY(41003,"client Token is null or Empty"),
		
		/**
		 * 从token解析的数据错误
		 */
		CLIENT_TOKEN_INFO_ERROR(41004,"info from client token error!"),
		
		/**
		 * 该服务没有权限访问这个服务器上的资源
		 */
		CLIENT_NO_PERMISSION(41005,"have no permission visit the server");
	
	
	
		

	    private final Integer value;
	    private final String message;

	    ErrorCode(int value, String message) {
	        this.value = value;
	        this.message = message;
	    }

	    public int getValue() {
	        return value;
	    }

	    public String getMessage() {
	        return message;
	    }

	    @Override
	    public String toString() {
	        return value.toString();
	    }

	    public int getCode() {
	        return value;
	    }

	    public static ErrorCode getByCode(Integer value) {
	        for (ErrorCode _enum : values()) {
	            if (_enum.getValue() == value) {
	                return _enum;
	            }
	        }
	        return null;
	    }

}
