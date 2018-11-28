package com.cscloud.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.cscloud.common.base.constant.GlobalConstant;

import lombok.Data;

/**
 * 从配置文件注入对应的swagger的配置
 * @ConfigurationProperties是从配置文件中读取信息
 * @author Administrator
 *
 */
@Data
@ConfigurationProperties(prefix = GlobalConstant.SWAGGER2_PREFIX)
public class SwaggerProperties {
	private String title;

	private String description;
	
	private Boolean enabled;

	private String version = "1.0";

	private String license = "Apache License 2.0";

	private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";

	private String contactName = "cs";

	private String contactUrl = "huisou";

	private String contactEmail = "huisou@163.com";
	

}
