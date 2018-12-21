package com.cscloud.auth.admin.service;

import java.util.List;

import com.cscloud.auth.admin.domain.AuthElementPo;
import com.cscloud.common.core.support.IService;

public interface AuthElementPoService extends IService<AuthElementPo> {


	/**
	 * 通过按钮的id获取按钮的所有符合权限的元素
	 * @param userId
	 * @param menuId
	 * @return
	 */
	List<AuthElementPo> getAuthorityElementByUserIdAndMenuId(String userId, String menuId);

	/**
	 * 通过 用户的id获取所有符合条件的元素
	 * @param userId
	 * @return
	 */
	List<AuthElementPo> getAuthorityElementByUserId(String userId);

	List<AuthElementPo> getAllElementPermissions();


}
