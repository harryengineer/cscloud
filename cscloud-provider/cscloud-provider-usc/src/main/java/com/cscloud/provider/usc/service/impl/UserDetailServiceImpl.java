package com.cscloud.provider.usc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cscloud.common.util.wrapper.Wrapper;
import com.cscloud.provider.api.model.StatisticDto;
import com.cscloud.provider.api.service.DtcStatisticFeignApi;
import com.cscloud.provider.usc.service.UserDetailService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailService {
	
	@Resource
	private DtcStatisticFeignApi dtcStatisticFeignApi;

	@Override
	public String getUserDetailById(Integer id) {
		try {
			Wrapper<StatisticDto> wrapper = dtcStatisticFeignApi.getByStatisticId(id);
			if (wrapper == null) {
				
			}
			
			
			return null;
		} catch (Exception e) {
			log.error("通过id获取用户的信息异常={}", e.getMessage(),e);
			throw new Exception(e);
		}
	}
	
	
}
