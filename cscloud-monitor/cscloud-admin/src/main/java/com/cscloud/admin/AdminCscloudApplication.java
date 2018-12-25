package com.cscloud.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;


/**
 * @Auther: Administrator
 * @Date: 2018/12/24 15:03
 * @Description:
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class AdminCscloudApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminCscloudApplication.class).run(args);
    }

}
