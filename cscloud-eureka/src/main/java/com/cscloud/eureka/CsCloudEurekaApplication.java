package com.cscloud.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 是eureka的注册中心的服务器
 * @author Administrator
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class CsCloudEurekaApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CsCloudEurekaApplication.class).run(args);
	}
}
