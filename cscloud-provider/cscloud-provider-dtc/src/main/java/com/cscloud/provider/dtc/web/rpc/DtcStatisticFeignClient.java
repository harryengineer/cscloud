package com.cscloud.provider.dtc.web.rpc;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.cscloud.common.util.wrapper.Wrapper;
import com.cscloud.provider.api.model.StatisticDto;
import com.cscloud.provider.api.service.DtcStatisticFeignApi;
import com.cscloud.provider.dtc.model.domain.StatisticPo;
import com.cscloud.provider.dtc.service.DtcStatisticService;

@RestController
public class DtcStatisticFeignClient  implements DtcStatisticFeignApi {

	@Resource
	private DtcStatisticService dtcStatisticService;
	
	@Override
	public Wrapper<StatisticDto> getByStatisticId(Integer id) {
		StatisticPo byKey = dtcStatisticService.selectByKey(id);
		return Wrapper.success(byKey);
	}

}
