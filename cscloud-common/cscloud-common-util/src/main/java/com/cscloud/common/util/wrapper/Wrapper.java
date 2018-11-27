package com.cscloud.common.util.wrapper;

import java.io.Serializable;
import java.util.Map;
/**
 * json字符串的返回值
 * @author Administrator
 *
 * @param <T>
 */
public class Wrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static String SUCCESS_CODE = "200";

    /**
     * 返回状态码
     */
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }



    public Wrapper(){
        this.status = SUCCESS_CODE;
        this.message = "SUCCESS";
    }

    public Wrapper(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Wrapper(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Wrapper(String status, String message, T data, Map<String, Object> ext) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
    }



    //快速返回成功
    public static <T>Wrapper success(){
        return new Wrapper<T>(SUCCESS_CODE,"请求成功",null);
    }

    public static <T>Wrapper success(T result){
        return new Wrapper<T>(SUCCESS_CODE,"请求成功",result);
    }

    public static <T>Wrapper success(String message, T result){
        return new Wrapper<T>(SUCCESS_CODE,message,result);
    }

    public static <T>Wrapper success(String message, T result, Map<String, Object> extra){
        return new Wrapper<T>(SUCCESS_CODE,message,result, extra);
    }


    //快速返回失败状态
    public static <T>Wrapper fail(){
        return new Wrapper<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage());
    }

    public static <T>Wrapper fail(T result){
        return new Wrapper<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage(),result);
    }
    
    public <T>Wrapper fail(String message, T result){
        return new Wrapper<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result);
    }

    public <T>Wrapper fail(String message, T result, Map<String, Object> extra){
        return new Wrapper<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result, extra);
    }

    public static <T>Wrapper fail(ErrorCode errorCode){
        return new Wrapper<T>(errorCode.getCode(),errorCode.getMessage());
    }

    public static <T>Wrapper fail(ErrorCode errorCode, T result){
        return new Wrapper<T>(errorCode.getCode(),errorCode.getMessage(),result);
    }

    public static <T>Wrapper fail(ErrorCode errorCode, String message, T result){
        return new Wrapper<T>(errorCode.getCode(),message,result);
    }

    public static <T>Wrapper fail(ErrorCode errorCode, String message, T result, Map<String, Object> extra){
        return new Wrapper<T>(errorCode.getCode(),message,result, extra);
    }

    //快速返回自定义状态码
    public static <T>Wrapper result(String statusCode, String message){
        return new Wrapper<T>(statusCode,message);
    }

    public static <T>Wrapper result(String statusCode, String message, T result){
        return new Wrapper<T>(statusCode,message,result);
    }

    public static <T>Wrapper result(String statusCode, String message, T result, Map<String, Object> extra){
        return new Wrapper<T>(statusCode,message,result, extra);
    }


    //快速返回Http状态
    public static <T>Wrapper httpStatus(HttpStatus httpStatus, String message){
        return result(httpStatus.toString(),message);
    }

    public static <T>Wrapper httpStatus(HttpStatus httpStatus, String message, T result){
        return result(httpStatus.toString(),message,result);
    }

    public static <T>Wrapper httpStatus(HttpStatus httpStatus, String message, T result, Map<String, Object> extra){
        return result(httpStatus.toString(),message,result, extra);
    }

}