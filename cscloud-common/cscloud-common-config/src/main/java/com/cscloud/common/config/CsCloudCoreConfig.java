package com.cscloud.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.cscloud.common.config.properties.PaasCsCloudProperties;

@Configuration
@EnableConfigurationProperties(PaasCsCloudProperties.class)
public class CsCloudCoreConfig {
	
//  这种注入方式	
//	@Bean  
//	public PaasCsCloudProperties PaasCsCloudProperties() {
//		return new PaasCsCloudProperties();
//		
//	}

}
