package com.cscloud.auth.admin.mapper;

import org.apache.ibatis.annotations.Param;

import com.cscloud.auth.admin.domain.AuthGroupPo;
import com.cscloud.common.core.mybatis.MyMapper;

public interface AuthGroupPoMapper extends MyMapper<AuthGroupPo> {
    public void deleteGroupMembersById (@Param("groupId") int groupId);
    public void deleteGroupLeadersById (@Param("groupId") int groupId);
    public void insertGroupMembersById (@Param("groupId") int groupId,@Param("userId") int userId);
    public void insertGroupLeadersById (@Param("groupId") int groupId,@Param("userId") int userId);
}