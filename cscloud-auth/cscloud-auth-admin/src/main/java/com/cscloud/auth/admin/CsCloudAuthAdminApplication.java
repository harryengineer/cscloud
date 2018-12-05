package com.cscloud.auth.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class CsCloudAuthAdminApplication {
	public static void main(String[] args) {
		new SpringApplication(CsCloudAuthAdminApplication.class).run(args);
	}
}
