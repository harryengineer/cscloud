package com.cscloud.provider.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cscloud.common.config.configuration.Swagger2Configuration;
import com.cscloud.common.config.properties.PaasCsCloudProperties;
import com.cscloud.common.core.converter.JacksonCustomConverter;

/**
 * 这个是用来配置对应的试图解析的配置类spring.jackson.date-format=
 * spring.jackson.time-zone=
 * 目前使用的是注解解决的 yyyy-MM-dd HH:mm:ss
 * 
 * @EnableWebMvc 是启用试图类
 * @author Administrator
 *
 */
@Configuration
@EnableWebMvc  
@Import({PaasCsCloudProperties.class,Swagger2Configuration.class})
public class WebUscMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/");
	}
		
	

}
