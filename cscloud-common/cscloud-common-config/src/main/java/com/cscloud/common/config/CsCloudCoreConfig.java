package com.cscloud.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.cscloud.common.config.properties.PaasCsCloudProperties;

/**
 *  将自动配置的文件PaasCsCloudProperties交给spring去管理的
 * @author Administrator
 *
 */
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
