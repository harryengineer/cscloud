package com.cscloud.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import com.cscloud.common.core.mybatis.MyMapper;
import com.cscloud.provider.model.domain.StatisticPo;

/**
 * @MapperScan(basePackages= {"com.cscloud.provider.mapper"})
 * 
 * @author Administrator
 *
 */
@Mapper
@Component
public interface StatisticPoMapper extends MyMapper<StatisticPo> {

}
