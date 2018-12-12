package com.cscloud.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.cscloud.auth.client.EnableAuthClient;

/**
 * zuul，是springcloud的网关
 * 
 * @author Administrator
 *
 */
@EnableEurekaClient
// 导入api的依赖扫描包
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = "com.cscloud.auth.api.service") // 不再application的目录下面所以需要扫描
@EnableFeignClients(basePackages = "com.cscloud.auth.api.service")
//@EnableAuthClient
public class CsCloudGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CsCloudGatewayApplication.class).run(args);
    }
}