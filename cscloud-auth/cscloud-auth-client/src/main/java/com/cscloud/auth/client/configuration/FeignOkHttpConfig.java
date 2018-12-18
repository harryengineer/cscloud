package com.cscloud.auth.client.configuration;

import com.cscloud.auth.client.interceptor.CustomOkHttpInterceptor;
import feign.Client;
import feign.Feign;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * 添加feign的对应的拦截器
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {


    @Bean
    public CustomOkHttpInterceptor getOkHttpLoggingInterceptor(){
        return new CustomOkHttpInterceptor();
    }


    @Bean
    public okhttp3.OkHttpClient.Builder okHttpClientBuilder(CustomOkHttpInterceptor interceptor) {
        return new okhttp3.OkHttpClient.Builder().addInterceptor(interceptor);
    }



}
