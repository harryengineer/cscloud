package com.cscloud.auth.client.configuration;

import com.cscloud.auth.client.interceptor.CustomOkHttpInterceptor;
import com.cscloud.auth.client.properties.ClientAuthProperties;
import com.cscloud.auth.client.properties.UserAuthProperties;
import com.cscloud.auth.client.util.SpringUtils;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 添加feign的对应的拦截器
 */
@Configuration
public class FeignOkHttpConfig {

    @Autowired
    public ClientAuthProperties clientAuthProperties ;

    @Resource
    public UserAuthProperties userAuthProperties;

    @Autowired
    public SpringUtils springUtils;

    @Bean
    public okhttp3.OkHttpClient okHttpClient(){
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool())
                 .addInterceptor(new CustomOkHttpInterceptor(clientAuthProperties,userAuthProperties,springUtils))
                .build();
    }



}
