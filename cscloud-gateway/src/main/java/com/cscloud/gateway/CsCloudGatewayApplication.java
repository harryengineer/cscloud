package com.cscloud.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul，是springcloud的网关
 * @author Administrator
 *
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class CsCloudGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CsCloudGatewayApplication.class).run(args);
    }
    
}