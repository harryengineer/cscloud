package com.cscloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


/**
 * @Auther: Administrator
 * @Date: 2018/12/24 15:06
 * @Description:
 */
@SpringBootApplication
@EnableTurbine//该注解中集成了相关的服务发现等内容
@EnableHystrixDashboard
@EnableEurekaClient
public class HystrixTurbineCscloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineCscloudApplication.class,args);
    }
}
