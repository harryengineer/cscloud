package com.cscloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages ="com.cscloud.provider.api.service")
public class CsCloudDtcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CsCloudDtcApplication.class, args);
	}
	
}	
