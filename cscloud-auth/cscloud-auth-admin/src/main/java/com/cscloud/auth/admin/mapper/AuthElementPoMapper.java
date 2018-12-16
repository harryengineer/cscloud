package com.cscloud.auth.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cscloud.auth.admin.domain.AuthElementPo;
import com.cscloud.common.core.mybatis.MyMapper;


public interface AuthElementPoMapper extends MyMapper<AuthElementPo> {

	List<AuthElementPo> getAuthorityElementByUserId(String userId);

	/**
	 * 这里的返回的menu_id是将menu的名字放进去了
	 * @param userId
	 * @param menuId
	 * @return
	 */
	List<AuthElementPo> getAuthorityElementByUserIdAndMenuId(@Param("userId")String userId,@Param("menuId")String menuId);

	/**
	 * 
	 * @return
	 */
	List<AuthElementPo> selectAllElementPermissions();
}