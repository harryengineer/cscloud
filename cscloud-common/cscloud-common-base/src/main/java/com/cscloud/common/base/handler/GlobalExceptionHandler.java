package com.cscloud.common.base.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.exception.BaseException;
import com.cscloud.common.base.wrapper.Wrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 这个是权限的模块的全局的异常定义
 * @author Administrator
 *
 */
@ControllerAdvice("com.cscloud")
@Slf4j
public class GlobalExceptionHandler  {
	
	@ExceptionHandler(BaseException.class)
    public Wrapper baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        log.error(ex.getMessage(),ex);
        return new Wrapper(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Wrapper otherExceptionHandler(HttpServletResponse response, Exception ex) {
	    if (ex instanceof BaseException){
            BaseException exception =(BaseException)ex;
            response.setStatus(exception.getCode());
        }else{
            response.setStatus(500);
        }

        log.error(ex.getMessage(),ex);
        return new Wrapper(ErrorCode.SYSTEM_ERROR.getCode(), ex.getMessage());
    }


	
}
