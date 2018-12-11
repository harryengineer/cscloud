package com.cscloud.common.base.wrapper;

import java.io.Serializable;
import java.util.Map;

import com.cscloud.common.base.constant.ErrorCode;

import lombok.Data;
/**
 *  包装类，将json的转换交给了mvc的视图转化器，已经feign的转换器
 *  不行最后统一用自己jackson转换器
 * @author Administrator
 *
 * @param <T>
 */
@Data
public class Wrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static int SUCCESS_CODE = 200;

    /**
     * 返回状态码
     */
    private int status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回内容
     */
    private T data;


    /**
     * 其他内容
     */
    private Map<String, Object> ext;
    
    public Wrapper(){
        this.status = SUCCESS_CODE;
        this.message = "SUCCESS";
    }

    public Wrapper(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Wrapper(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Wrapper(int status, String message, T data, Map<String, Object> ext) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
    }



    /*
     * 快速创建成功或者失败
     */
    public static <T>Wrapper<T> success(){
        return new Wrapper<T>(SUCCESS_CODE,"请求成功",null);
    }

    public static <T>Wrapper<T> success(T result){
        return new Wrapper<T>(SUCCESS_CODE,"请求成功",result);
    }

    public static <T>Wrapper<T> success(String message, T result){
        return new Wrapper<T>(SUCCESS_CODE,message,result);
    }

    public static <T>Wrapper<T> success(String message, T result, Map<String, Object> extra){
        return new Wrapper<T>(SUCCESS_CODE,message,result, extra);
    }
    
    
    /**
     * 判断是否是成功的
     * @return
     */
    public  Boolean whetherSuccess() {
    	return  status == SUCCESS_CODE;
    }
    

    //快速返回失败状态
    public static <T>Wrapper<T> fail(){
        return new Wrapper<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage());
    }

    public static <T>Wrapper<T> fail(T result){
        return new Wrapper<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage(),result);
    }
    
    public Wrapper<T> fail(String message, T result){
        return new Wrapper<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result);
    }

    public Wrapper<T> fail(String message, T result, Map<String, Object> extra){
        return new Wrapper<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result, extra);
    }

    public static <T>Wrapper<T> fail(ErrorCode errorCode){
        return new Wrapper<T>(errorCode.getCode(),errorCode.getMessage());
    }

    public static <T>Wrapper<T> fail(ErrorCode errorCode, T result){
        return new Wrapper<T>(errorCode.getCode(),errorCode.getMessage(),result);
    }

    public static <T>Wrapper<T> fail(ErrorCode errorCode, String message, T result){
        return new Wrapper<T>(errorCode.getCode(),message,result);
    }

    public static <T>Wrapper<T> fail(ErrorCode errorCode, String message, T result, Map<String, Object> extra){
        return new Wrapper<T>(errorCode.getCode(),message,result, extra);
    }

    /**
     * 快速返回自定义的结果
     * @param statusCode
     * @param message
     * @return
     */
    public static <T>Wrapper<T> result(int statusCode, String message){
        return new Wrapper<T>(statusCode,message);
    }

    public static <T>Wrapper<T> result(int statusCode, String message, T result){
        return new Wrapper<T>(statusCode,message,result);
    }

    public static <T>Wrapper<T> result(int statusCode, String message, T result, Map<String, Object> extra){
        return new Wrapper<T>(statusCode,message,result, extra);
    }


    /*
     * /快速返回Http状态
     */
    public static <T>Wrapper<T> httpStatus(HttpStatus httpStatus, String message){
        return result(httpStatus.value(),message);
    }

    public static <T>Wrapper<T> httpStatus(HttpStatus httpStatus, String message, T result){
        return result(httpStatus.value(),message,result);
    }

    public static <T>Wrapper<T> httpStatus(HttpStatus httpStatus, String message, T result, Map<String, Object> extra){
        return result(httpStatus.value(),message,result, extra);
    }

}