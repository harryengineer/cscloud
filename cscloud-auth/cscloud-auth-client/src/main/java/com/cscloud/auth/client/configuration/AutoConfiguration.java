package com.cscloud.auth.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.cscloud.auth.client.properties.ClientAuthProperties;
import com.cscloud.auth.client.properties.UserAuthProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 添加注解用来扫描对应的包下面的内容
 */
@ComponentScan(basePackages= {"com.cscloud.auth.client"})
public class AutoConfiguration {

	
}
