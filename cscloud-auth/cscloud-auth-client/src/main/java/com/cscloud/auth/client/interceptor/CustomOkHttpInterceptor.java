package com.cscloud.auth.client.interceptor;

import java.io.IOException;


import com.cscloud.auth.client.util.SpringUtils;
import com.cscloud.auth.client.properties.ClientAuthProperties;
import com.cscloud.auth.client.properties.UserAuthProperties;
import com.cscloud.auth.client.util.ClientTokenUtils;
import com.cscloud.auth.common.util.BaseContextMap;
import com.cscloud.common.base.constant.ErrorCode;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 *
 * httpclient没有拦截器，只有okhttp有拦截器，
 * 所以我们这里对加了注解的所有feign发出的请求添加拦截器
 * 添加对应的user: header是：  x-client-token
 * 服务实例认证头是   head  :  Authorization
 * @author Administrator
 *
 */
@Slf4j
public class CustomOkHttpInterceptor implements Interceptor{

	public ClientAuthProperties clientAuthProperties ;

	public UserAuthProperties userAuthProperties;

	public SpringUtils springUtils;


	public CustomOkHttpInterceptor(ClientAuthProperties clientAuthProperties, UserAuthProperties userAuthProperties, SpringUtils springUtils) {
		this.clientAuthProperties = clientAuthProperties;
		this.userAuthProperties = userAuthProperties;
		this.springUtils = springUtils;
	}

	/**
	 * 拦截，添加对应的请求头和token
	 */
	@Override
	public Response intercept(Chain chain) throws IOException {

		// 排除获取token路径  /client/getClientPubKey   /client/getUserPubKey
        String curUrl = chain.request().url().toString();
        if (curUrl.contains("/client/getClientPubKey") || curUrl.contains("/client/getUserPubKey")){
            return  chain.proceed(chain.request());
        }

		Request newRequest = null;
		ClientTokenUtils clientTokenUtils = springUtils.getBean(ClientTokenUtils.class);
        if (chain.request().url().toString().contains("client/token")) {
			newRequest = chain.request().newBuilder()
				.addHeader(clientAuthProperties.getTokenHeader() ,BaseContextMap.getClientToken())
				.build();
		}else {
			newRequest = chain.request().newBuilder()
					.addHeader(clientAuthProperties.getTokenHeader(), clientTokenUtils.getToken())
					// header 的token是在本地获取到
					.addHeader(userAuthProperties.getUserTokenHeader(), BaseContextMap.getUserToken())
					.build();
		}
		
		// 执行这个请求后，获取的返回,对返回的内容进行对应的判断
		Response response = chain.proceed(newRequest);
		// 如果token已经过期了，那么就重新刷新请求
		log.info("the okhttp  get the code :{}",response.code());
		if (response.code() == ErrorCode.CLIENT_TOKEN_EXPIRED.getCode()) {
			newRequest = chain.request().newBuilder()
					.addHeader(clientAuthProperties.getTokenHeader(), clientTokenUtils.getToken())
					// header 的token是在本地获取到
					.addHeader(userAuthProperties.getUserTokenHeader(), BaseContextMap.getUserToken())
					.build();
			response = chain.proceed(newRequest);
		}
		
		return response;
	}
}
