package com.cscloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 数据服务中心
 * @author Administrator
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class CsCloudDtcApplication {
	public static void main(String[] args) {
		SpringApplication.run(CsCloudDtcApplication.class, args);
	}
}	
