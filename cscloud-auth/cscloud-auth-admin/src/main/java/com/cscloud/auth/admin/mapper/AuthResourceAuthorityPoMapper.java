package com.cscloud.auth.admin.mapper;

import org.apache.ibatis.annotations.Param;

import com.cscloud.auth.admin.domain.AuthResourceAuthorityPo;
import com.cscloud.common.core.mybatis.MyMapper;

public interface AuthResourceAuthorityPoMapper extends MyMapper<AuthResourceAuthorityPo> {
    public void deleteByAuthorityIdAndResourceType(@Param("authorityId")String authorityId,@Param("resourceType") String resourceType);

}