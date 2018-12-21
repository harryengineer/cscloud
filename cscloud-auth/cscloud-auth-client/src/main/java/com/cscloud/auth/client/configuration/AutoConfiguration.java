package com.cscloud.auth.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.cscloud.auth.client.properties.ClientAuthProperties;
import com.cscloud.auth.client.properties.UserAuthProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages= {"com.cscloud.auth.client"})
public class AutoConfiguration {
	
	@Bean
	public ClientAuthProperties clientAuthProperties() {
		return new ClientAuthProperties();
	}
	
	@Bean
	public UserAuthProperties userAuthProperties() {
		return new UserAuthProperties();
	}

	
}
