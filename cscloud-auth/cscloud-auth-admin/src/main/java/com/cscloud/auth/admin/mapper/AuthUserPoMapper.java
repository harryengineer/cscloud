package com.cscloud.auth.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cscloud.auth.admin.domain.AuthUserPo;
import com.cscloud.common.core.mybatis.MyMapper;

public interface AuthUserPoMapper extends MyMapper<AuthUserPo> {
	public List<AuthUserPo> selectMemberByGroupId(@Param("groupId") int groupId);

	public List<AuthUserPo> selectLeaderByGroupId(@Param("groupId") int groupId);
}