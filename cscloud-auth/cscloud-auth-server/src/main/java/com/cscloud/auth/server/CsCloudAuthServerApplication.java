package com.cscloud.auth.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * jwt认证的服务器端
 * @author Administrator
 *
 */
@EnableFeignClients// 开启服务调用
@EnableEurekaClient//注册中心
@SpringBootApplication(scanBasePackages= "com.cscloud.auth.api.service.server")
@EnableHystrix//熔断器，核心是为了turbin的监控
@MapperScan("com.cscloud.auth.server.mapper")//mapper的scan的包路径
@EnableScheduling//开启定时器
public class CsCloudAuthServerApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CsCloudAuthServerApplication.class).run(args);
	}
}
