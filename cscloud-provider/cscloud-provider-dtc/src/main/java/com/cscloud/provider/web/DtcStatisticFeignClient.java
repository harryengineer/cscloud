package com.cscloud.provider.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.common.base.wrapper.Wrapper;
import com.cscloud.provider.api.model.StatisticDto;
import com.cscloud.provider.api.service.DtcStatisticFeignApi;
import com.cscloud.provider.model.domain.StatisticPo;
import com.cscloud.provider.service.DtcStatisticService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "API - DtcStatisticFeignClient",produces = "application/json")
@Slf4j
public class DtcStatisticFeignClient  implements DtcStatisticFeignApi {

	@Autowired
	private DtcStatisticService dtcStatisticService;
	
	@ApiOperation(value ="通过id获取对应的统计对象", httpMethod = "GET")
	@Override
	public Wrapper<StatisticDto> getByStatisticId(@ApiParam(name = "id", value = "数据的id") @RequestParam("id")Integer id) {
		log.info("getByStatisticId --通过id获取对应的统计对象  : id --{}",id);
		StatisticPo byKey = dtcStatisticService.getByStatisticId(id);
		System.out.println(byKey.toString());
		//这里进行po，转换为dto
		StatisticDto dto = new StatisticDto();
		BeanUtils.copyProperties(byKey, dto);
		return Wrapper.success(dto);
	}

}
