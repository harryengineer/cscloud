package com.cscloud.auth.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cscloud.auth.client.EnableAuthClient;

/**
 * 这个是权限管理的模块
 * @author Administrator
 *
 */
@EnableFeignClients(basePackages = "com.cscloud.auth.api")
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.cscloud.auth.admin","com.cscloud.auth.api","com.cscloud.common"})
@EnableHystrix
@MapperScan(basePackages= {"com.cscloud.auth.admin.mapper"})
@EnableAuthClient //开启对应的权限认证
public class CsCloudAuthAdminApplication {
	public static void main(String[] args) {
		new SpringApplication(CsCloudAuthAdminApplication.class).run(args);
	}
}
