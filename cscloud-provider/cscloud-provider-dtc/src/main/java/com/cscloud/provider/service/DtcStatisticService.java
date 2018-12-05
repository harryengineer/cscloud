package com.cscloud.provider.service;

import com.cscloud.common.core.support.IService;
import com.cscloud.provider.model.domain.StatisticPo;

/**
 * 这里的继承是给接口使用的
 * @author Administrator
 *
 */
public interface DtcStatisticService extends IService<StatisticPo>{

	StatisticPo getByStatisticId(Integer id);
	
	

}
