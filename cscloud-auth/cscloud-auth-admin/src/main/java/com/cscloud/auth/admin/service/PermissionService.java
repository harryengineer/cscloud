package com.cscloud.auth.admin.service;

import java.util.List;

import com.cscloud.auth.admin.vo.MenuTree;
import com.cscloud.auth.api.model.AuthPermissionVo;
import com.cscloud.auth.api.model.AuthUserVo;
import com.cscloud.auth.api.model.UserPermissionVo;

public interface PermissionService {

	/**
	 * 通过用户名称来获用户vo
	 * 
	 * @param username
	 * @return
	 */
	public AuthUserVo getUserByUsername(String username);

	/**
	 * 验证用户的帐号密码
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public AuthUserVo validate(String username, String password);

	/**
	 * 获取所有的权限的认证
	 * @return
	 */
	public List<AuthPermissionVo> getAllPermission();

	/**
	 * 通过token获取用户对应的信息等
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public UserPermissionVo getUserInfo(String token) throws Exception;

	/**
	 * 通过tokne，然后获取所有的权限的按钮
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public  List<MenuTree> getMenusByUsername(String token) throws Exception;
	
	/**
	 * 通过用户名称获取所有的权限
	 * @param username
	 * @return
	 */
	 public List<AuthPermissionVo> getPermissionByUsername(String username);

}
