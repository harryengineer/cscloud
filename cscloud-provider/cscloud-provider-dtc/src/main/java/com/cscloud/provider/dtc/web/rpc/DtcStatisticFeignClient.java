package com.cscloud.provider.dtc.web.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.common.util.wrapper.Wrapper;
import com.cscloud.provider.api.model.StatisticDto;
import com.cscloud.provider.api.service.DtcStatisticFeignApi;
import com.cscloud.provider.dtc.model.domain.StatisticPo;
import com.cscloud.provider.dtc.service.DtcStatisticService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "API - DtcStatisticFeignClient",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DtcStatisticFeignClient  implements DtcStatisticFeignApi {

	@Autowired
	private DtcStatisticService dtcStatisticService;
	
	@ApiOperation(value ="通过id获取对应的统计对象", httpMethod = "GET")
	@Override
	public Wrapper<StatisticDto> getByStatisticId(@ApiParam(name = "id", value = "数据的id") @RequestParam("id")Integer id) {
		StatisticPo byKey = dtcStatisticService.selectByKey(id);
		return Wrapper.success(byKey);
	}

}
