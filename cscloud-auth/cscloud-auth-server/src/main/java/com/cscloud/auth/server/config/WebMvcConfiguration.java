package com.cscloud.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cscloud.auth.server.interceptor.ClientAuthInterceptor;
import com.cscloud.auth.server.interceptor.UserAuthInterceptor;

/**
 * 视图配置工具类，用来添加对应的视图配置（拦截器，过滤器，以及其他等
 * 
 * @author Administrator
 *
 */
@Configuration(value = "webMvcConfig")
public class WebMvcConfiguration implements WebMvcConfigurer {

	/**
	 * 添加拦截器服务权限的访问拦截器和 用户的拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userAuthInterceptor()).addPathPatterns("/service/**");
		registry.addInterceptor(clientAuthInterceptor()).addPathPatterns("/service/**");
	}

	/**
	 * 注入之前的2个拦截器
	 * 
	 * @return
	 */
	@Bean
	public UserAuthInterceptor userAuthInterceptor() {
		return new UserAuthInterceptor();
	}

	@Bean
	public ClientAuthInterceptor clientAuthInterceptor() {
		return new ClientAuthInterceptor();
	}

}