package com.cscloud.auth.client;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.cscloud.auth.client.configuration.AutoConfiguration;

/**
 *  这个注解是加入注解的时候，自动添加访问的拦截器，对于访问进行对应的权限控制和认证。
 *  
 * @author Administrator
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Inherited //可以被继承
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AutoConfiguration.class) //将这个类交给spring去管理
public @interface EnableAuthClient {

}
