package com.cscloud.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication(scanBasePackages="com.cscloud.common.config")
public class CsCloudMonitorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CsCloudMonitorApplication.class, args);
	}
		
}
