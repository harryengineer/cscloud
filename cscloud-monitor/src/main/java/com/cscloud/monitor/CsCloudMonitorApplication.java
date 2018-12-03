package com.cscloud.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


/**
 * 监控类(包括监控设置）
 * @author Administrator
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class CsCloudMonitorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CsCloudMonitorApplication.class, args);
	}
		
}
