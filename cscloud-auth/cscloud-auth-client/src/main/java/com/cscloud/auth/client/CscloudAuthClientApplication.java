package com.cscloud.auth.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class CscloudAuthClientApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CscloudAuthClientApplication.class).run(args);
	}
}
