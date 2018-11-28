package com.cscloud.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.cscloud.common.config.configuration.Swagger2Configuration;


@EnableEurekaClient
@SpringBootApplication
@Import(Swagger2Configuration.class)
public class CsCloudMonitorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CsCloudMonitorApplication.class, args);
	}
	
}
