package com.cscloud.auth.admin.service;

import java.util.List;

import com.cscloud.auth.admin.domain.AuthGroupPo;
import com.cscloud.auth.admin.vo.AuthorityMenuTreeVo;
import com.cscloud.auth.admin.vo.GroupUserVo;
import com.cscloud.common.core.support.IService;

public interface AuthGroupPoService extends IService<AuthGroupPo> {
	/**
	 * 修改用户的组和领导
	 * @param id
	 * @param members
	 * @param leaders
	 */
	void modifyGroupUsers(int id, String members, String leaders);

	/**
	 * 根据group获取成员和leaders
	 * @param groupId
	 * @return
	 */
	GroupUserVo getGroupUsers(Integer groupId);

	/**
	 * 修改权限按钮，先删除后，然后再添加所有的按钮
	 * @param id
	 * @param menus
	 */
	void modifyAuthorityMenu(int id, String[] menus);

	/**
	 * 
	 * @param groupId
	 * @return
	 */
	List<AuthorityMenuTreeVo> getAuthorityMenu(int groupId);

	/**
	 * 删除权限元素
	 * @param id
	 * @param menuId
	 * @param elementId
	 */
	void removeAuthorityElement(int id, int menuId, int elementId);

	/**
	 * 通过权限的获取所有的权限的id
	 * @param id
	 * @return
	 */
	List<Integer> getAuthorityElementByAuthorityId(int id);

	void modifyAuthorityElement(int id, int menuId, int elementId);
}
