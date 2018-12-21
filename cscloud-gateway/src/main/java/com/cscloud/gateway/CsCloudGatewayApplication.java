package com.cscloud.gateway;

import com.cscloud.auth.client.EnableAuthClient;
import feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * zuul，是springcloud的网关
 * 
 * @author Administrator
 *
 */
@EnableEurekaClient
// 导入api的依赖扫描包
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = {"com.cscloud.auth.api.service","com.cscloud.gateway"}) // 不再application的目录下面所以需要扫描
@EnableFeignClients(basePackages = "com.cscloud.auth.api.service")
@EnableAuthClient
@Slf4j
public class CsCloudGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CsCloudGatewayApplication.class).run(args);
    }

//
//    /**
//     * 自定义异常处理[@@]注册Bean时依赖的Bean，会从容器中直接获取，所以直接注入即可
//     * @param viewResolversProvider
//     * @param serverCodecConfigurer
//     * @return
//     */
//    @Primary
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public ErrorWebExceptionHandler errorWebExceptionHandler(ObjectProvider<List<ViewResolver>> viewResolversProvider,
//                                                             ServerCodecConfigurer serverCodecConfigurer) {
//
//        GlobalErrorWebExceptionHandler jsonExceptionHandler = new GlobalErrorWebExceptionHandler();
//        jsonExceptionHandler.setViewResolvers(viewResolversProvider.getIfAvailable(Collections::emptyList));
//        jsonExceptionHandler.setMessageWriters(serverCodecConfigurer.getWriters());
//        jsonExceptionHandler.setMessageReaders(serverCodecConfigurer.getReaders());
//        log.info("Init Json Exception Handler Instead Default ErrorWebExceptionHandler Success");
//        return jsonExceptionHandler;
//    }
}