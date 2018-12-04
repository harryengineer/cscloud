package com.cscloud.provider.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cscloud.common.base.wrapper.Wrapper;
import com.cscloud.provider.api.model.StatisticDto;
import com.cscloud.provider.api.service.hystrix.DtcStatisticFeignApiHystrix;

@FeignClient(value = "cscloud-provider-dtc",fallback = DtcStatisticFeignApiHystrix.class)
public interface DtcStatisticFeignApi {
	
	@PostMapping(value = "/api/dtc/getByStatisticId")
	public Wrapper<StatisticDto> getByStatisticId(@RequestParam("id") Integer id);

}
