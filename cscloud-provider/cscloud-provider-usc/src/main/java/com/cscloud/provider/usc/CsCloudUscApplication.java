package com.cscloud.provider.usc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 用户数据中心的启动类
 * @author Administrator
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class CsCloudUscApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CsCloudUscApplication.class).run(args);
		
		if (true) {
			
		}
		
		System.out.println("-sdfds");
	}
}
