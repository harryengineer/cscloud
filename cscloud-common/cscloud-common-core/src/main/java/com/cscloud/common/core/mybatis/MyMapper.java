package com.cscloud.common.core.mybatis;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


// 继承的这2个里面就包含了crud、以及分页、条件查询的所有组件了
public interface MyMapper<T>  extends Mapper<T>, MySqlMapper<T>{

}
