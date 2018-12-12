package com.cscloud.auth.server.task;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.cscloud.auth.common.util.UUIDUtils;
import com.cscloud.auth.server.domain.AuthClientPo;
import com.cscloud.auth.server.service.AuthClientSerivce;

/**
 * 如果有服务注册到注册中心，就将它保存数据库中
 * @author Administrator
 *
 */
@Configuration
public class ClientDiscoveryTask {
	
	@Resource
	private DiscoveryClient discoveryClient;
	@Resource
	private AuthClientSerivce authClientSerivce;
	
	/**
	 * 如果有服务注册到注册中心，就将它保存数据库中,并且初始化secret
	 */
	@Scheduled(cron = "0 0/1 * * * *")
	public void discoveryTask() {
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			AuthClientPo clientPo = new AuthClientPo();
			clientPo.setName(service);
			clientPo.setCode(service);
			AuthClientPo po = authClientSerivce.selectOne(clientPo);
			if (po == null) {
				clientPo.setSecret(UUIDUtils.generateShortUuid());
				authClientSerivce.save(clientPo);
			}
			
		}
		
	}
}
