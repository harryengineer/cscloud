package com.cscloud.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cscloud.common.core.support.BaseService;
import com.cscloud.provider.mapper.StatisticPoMapper;
import com.cscloud.provider.model.domain.StatisticPo;
import com.cscloud.provider.service.DtcStatisticService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DtcStatisticServiceImpl extends BaseService<StatisticPo> implements DtcStatisticService{
	
	
	@Autowired
	private StatisticPoMapper statisticPoMapper;

	@Override
	public StatisticPo getByStatisticId(Integer id) {
		return statisticPoMapper.selectByPrimaryKey(id);
	}
	
	
	
}
