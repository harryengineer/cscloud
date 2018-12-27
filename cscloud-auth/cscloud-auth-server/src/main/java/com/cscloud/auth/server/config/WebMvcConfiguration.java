package com.cscloud.auth.server.config;

import java.util.List;

import com.cscloud.common.config.configuration.RedisConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cscloud.auth.server.interceptor.ClientAuthInterceptor;
import com.cscloud.auth.server.interceptor.UserAuthInterceptor;
import com.cscloud.common.core.converter.JacksonCustomConverter;

/**
 * 视图配置工具类，用来添加对应的视图配置（拦截器，过滤器，以及其他等
 * 
 * @author Administrator
 *
 */
@Configuration(value = "webMvcConfig")
@Import(RedisConfiguration.class)//手动注入需要的配置文件
public class WebMvcConfiguration implements WebMvcConfigurer {

	/**
	 * 添加拦截器服务权限的访问拦截器和 用户的拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(clientAuthInterceptor()).addPathPatterns("/service/**");
		registry.addInterceptor(userAuthInterceptor()).addPathPatterns("/service/**");
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
	
	/**
	 * 修改jackson的date的格式化形式，通过add添加就可以了。
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		JacksonCustomConverter.buidMvcMessageConverter(converters);
	}

}