package com.cscloud.auth.server.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.cscloud.auth.server.config.ClientConfiguration;
import com.cscloud.auth.server.service.AuthClientSerivce;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 客户端feign访问的拦截器，用于调用其他服务的时候添加token
 * @author Administrator
 *
 */
@Slf4j
public class FeignClientTokenInteceptor implements RequestInterceptor {
	
	
	@Autowired
	private ClientConfiguration clientConfiguration;
	@Autowired
	private AuthClientSerivce authClientService;
	
	/**
	 * 为feign的每个请求添加对应的请求头等需要的信息,这里存放对应的请求同和生成的token
	 */
	@Override
	public void apply(RequestTemplate template) {
		try {
			log.info("为请求添加对应的token信息");
			template.header(clientConfiguration.getClientTokenHeader(),authClientService.getToken(clientConfiguration.getClientId(),clientConfiguration.getClientSecret()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
