package com.cscloud.auth.admin.config;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cscloud.auth.client.interceptor.ClientRequestInterceptor;
import com.cscloud.auth.client.interceptor.UserRequestInterceptor;
import com.cscloud.common.base.handler.GlobalExceptionHandler;

/**
 * mvc视图拦截器 入口
 * @author Administrator
 *
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	/**
	 * 全局错误拦截
	 * @return
	 */
	@Bean
	public GlobalExceptionHandler getGlobalExceptionHandler() {
		return new GlobalExceptionHandler();
	}
	
	
	/**
	 * 创建用户的请求拦截
	 * @return
	 */
	@Bean
	public UserRequestInterceptor userRequestInterceptor() {
		return new UserRequestInterceptor();
	}
	
	
	/**
	 * 使用对应 的请求拦截器
	 * @return
	 */
	@Bean
	public ClientRequestInterceptor clientRequestInterceptor() {
		return new ClientRequestInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userRequestInterceptor()).addPathPatterns(getIncludePathPatterns());
		registry.addInterceptor(clientRequestInterceptor()).addPathPatterns("/api/user/validate");
		
		
	}

	/**
	 * 配置响应的编码集
	 * @param converters
	 */
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
		stringHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);

		converters.add(stringHttpMessageConverter);
	}

	
	 /**
     * 需要用户和服务认证判断的路径
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/element/**",
                "/gateLog/**",
                "/group/**",
                "/groupType/**",
                "/menu/**",
                "/user/**",
                "/api/permissions",
                "/api/user/un/**"
        };
        Collections.addAll(list, urls);
        return list;
    }
	

}
