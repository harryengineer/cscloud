package com.cscloud.auth.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * jwt认证的服务器端
 * @author Administrator
 *
 */
@EnableFeignClients// 开启服务调用
// 最好添加上去，这样可以减少启动时间
@SpringBootApplication
@ComponentScan(basePackages = {"com.cscloud.auth.api.service.server","com.cscloud.auth.server","com.cscloud.common.config"})
//@EnableHystrix//熔断器，核心是为了turbin的监控
@MapperScan(basePackages = "com.cscloud.auth.server.mapper")//mapper的scan的包路径
@EnableScheduling//开启定时器
@EnableEurekaClient
public class CsCloudAuthServerApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CsCloudAuthServerApplication.class).run(args);
	}
}
