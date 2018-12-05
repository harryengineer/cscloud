package com.cscloud.common.core.converter;


import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * java的转换器，用来添加对应的配置,
 * @author Administrator
 *
 */
public class JacksonCustomConverter {
	
	private JacksonCustomConverter(){
		
	}
	
	/**
	 *  获取jackson的转换器类
	 * @return
	 */
	public static void buidMvcMessageConverter(List<HttpMessageConverter<?>> converters) {	
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		ObjectMapper objectMapper = new ObjectMapper()
				// JDK8 新特性，可选择多个模块
				.registerModule(new ParameterNamesModule())
				//添加 jdk的模块
				.registerModule(new Jdk8Module())
				//添加java的时间类
				.registerModule(new JavaTimeModule())
				//将所有的时间进行对应的格式化，简单方便
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
				.registerModule(simpleModule);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jackson2HttpMessageConverter.setObjectMapper(objectMapper);
		converters.add(jackson2HttpMessageConverter);
	}

}
