package com.cscloud.common.config.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

import com.cscloud.common.base.constant.GlobalConstants;

import lombok.Data;
/**
 * 是其他所有配置的托管类，使用了 组合设计模式
 * @author Administrator
 *
 */
@Data
//@Component 在这个项目中，没有办法注入对应的类，所以只能交给@EnableConfigurationProperties,获取c创建bean
@ConfigurationProperties(prefix = GlobalConstants.ROOT_PREFIX)
public class PaasCsCloudProperties {
	
	private SwaggerProperties swagger = new SwaggerProperties();
}
