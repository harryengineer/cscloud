package com.cscloud.provider.usc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户数据中心的启动类
 * @author Administrator
 *
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.cscloud.provider.usc")
@EnableFeignClients(basePackages = "com.cscloud.provider.api.service")
public class CsCloudUscApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CsCloudUscApplication.class).run(args);
	}
}
