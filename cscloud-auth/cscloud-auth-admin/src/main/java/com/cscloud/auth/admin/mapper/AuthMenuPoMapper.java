package com.cscloud.auth.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cscloud.auth.admin.domain.AuthMenuPo;
import com.cscloud.common.core.mybatis.MyMapper;

public interface AuthMenuPoMapper extends MyMapper<AuthMenuPo> {
	
	/**
	 * 通过权限的
	 * @param authorityId
	 * @param authorityType
	 * @return
	 */
	public List<AuthMenuPo> selectMenuByAuthorityId(@Param("authorityId") String authorityId,
			@Param("authorityType") String authorityType);

	/**
	 * 根据用户和组的权限关系查找用户可访问菜单
	 * 
	 * @param userId
	 * @return
	 */
	public List<AuthMenuPo> selectAuthorityMenuByUserId(@Param("userId") int userId);

	/**
	 * 根据用户和组的权限关系查找用户可访问的系统
	 * 
	 * @param userId
	 * @return
	 */
	public List<AuthMenuPo> selectAuthoritySystemByUserId(@Param("userId") int userId);
}