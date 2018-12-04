package com.cscloud.provider.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cscloud.common.base.wrapper.Wrapper;
import com.cscloud.provider.api.model.StatisticDto;
import com.cscloud.provider.api.service.DtcStatisticFeignApi;
import com.cscloud.provider.service.UserDetailService;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户的细节类
 * @author Administrator
 *
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailService {
	
	@Resource
	private DtcStatisticFeignApi dtcStatisticFeignApi;

	@Override
	public StatisticDto getUserDetailById(Integer id) {
		try {
			Wrapper<StatisticDto> wrapper = dtcStatisticFeignApi.getByStatisticId(id);
			if (wrapper == null) {
				throw new RuntimeException();
			}
			
			log.info(wrapper.toString());
			if (wrapper.whetherSuccess()) {
				return wrapper.getData();
			}
			
			return null;
		} catch (Exception e) {
			log.error("通过id获取用户的信息异常={}", e.getMessage(),e);
		}
		
		return null;
	}
	
	
}
