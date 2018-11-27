package com.cscloud.provider.api.service.hystrix;

import org.springframework.stereotype.Component;

import com.cscloud.common.util.wrapper.Wrapper;
import com.cscloud.provider.api.model.StatisticDto;
import com.cscloud.provider.api.service.DtcStatisticFeignApi;

@Component
public class DtcStatisticFeignApiHystrix implements DtcStatisticFeignApi {

	//可以不做任何的响应
	@Override
	public Wrapper<StatisticDto> getByStatisticId(Integer id) {
		return null;
	}

}
