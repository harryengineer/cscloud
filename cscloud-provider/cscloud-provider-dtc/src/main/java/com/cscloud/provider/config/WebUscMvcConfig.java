package com.cscloud.provider.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cscloud.common.config.configuration.Swagger2Configuration;
import com.cscloud.common.config.properties.PaasCsCloudProperties;
import com.cscloud.common.core.converter.JacksonCustomConverter;

@Configuration
@EnableWebMvc
@Import({ PaasCsCloudProperties.class, Swagger2Configuration.class })
public class WebUscMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/",
				"classpath:/resources/", "classpath:/static/");
	}

	/**
	 * 修改jackson的date的格式化形式，通过add添加就可以了。
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		JacksonCustomConverter.buidMvcMessageConverter(converters);
	}

}