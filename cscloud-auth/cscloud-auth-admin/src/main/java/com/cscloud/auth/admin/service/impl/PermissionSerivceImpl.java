package com.cscloud.auth.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cscloud.auth.admin.domain.AuthElementPo;
import com.cscloud.auth.admin.domain.AuthMenuPo;
import com.cscloud.auth.admin.domain.AuthUserPo;
import com.cscloud.auth.admin.service.AuthElementPoService;
import com.cscloud.auth.admin.service.AuthMenuPoService;
import com.cscloud.auth.admin.service.AuthUserPoService;
import com.cscloud.auth.admin.service.PermissionService;
import com.cscloud.auth.admin.util.TreeUtils;
import com.cscloud.auth.admin.vo.MenuTree;
import com.cscloud.auth.api.model.AuthPermissionVo;
import com.cscloud.auth.api.model.AuthUserVo;
import com.cscloud.auth.api.model.UserPermissionVo;
import com.cscloud.auth.client.util.UserTokenUtils;
import com.cscloud.common.base.constant.GlobalConstants;

/**
 *  权限的使用类
 */
@Service
public class PermissionSerivceImpl  implements PermissionService {
	 @Autowired
	    private AuthUserPoService userBiz;
	    @Autowired
	    private AuthMenuPoService menuBiz;
	    @Autowired
	    private AuthElementPoService elementBiz;
	    @Autowired
	    private UserTokenUtils userAuthUtil;
	    
	    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	    @Override
	    public AuthUserVo getUserByUsername(String username) {
	    	AuthUserVo info = new AuthUserVo();
	        AuthUserPo user = userBiz.getUserByUsername(username);
	        BeanUtils.copyProperties(user, info);
	        info.setId(user.getAuthUserId().toString());
	        return info;
	    }
	    
	    @Override
	    public AuthUserVo validate(String username,String password){
	        AuthUserVo info = new AuthUserVo();
	        AuthUserPo user = userBiz.getUserByUsername(username);
	        if (encoder.matches(password, user.getPassword())) {
	            BeanUtils.copyProperties(user, info);
	            info.setId(user.getAuthUserId().toString());
	        }
	        return info;
	    }

	    @Override
	    public List<AuthPermissionVo> getAllPermission() {
	        List<AuthMenuPo> menus = menuBiz.selectAll();
	        List<AuthPermissionVo> result = new ArrayList<AuthPermissionVo>();
	        AuthPermissionVo info = null;
	        menu2permission(menus, result);
	        List<AuthElementPo> elements = elementBiz.getAllElementPermissions();
	        element2permission(result, elements);
	        return result;
	    }

	    private void menu2permission(List<AuthMenuPo> menus, List<AuthPermissionVo> result) {
	    	AuthPermissionVo info;
	        for (AuthMenuPo menu : menus) {
	            if (StringUtils.isBlank(menu.getHref())) {
	                menu.setHref("/" + menu.getCode());
	            }
	            info = new AuthPermissionVo();
	            info.setCode(menu.getCode());
	            info.setType(GlobalConstants.RESOURCE_TYPE_MENU);
	            info.setName(GlobalConstants.RESOURCE_ACTION_VISIT);
	            String uri = menu.getHref();
	            if (!uri.startsWith("/")) {
	                uri = "/" + uri;
	            }
	            info.setUri(uri);
	            info.setMethod(GlobalConstants.RESOURCE_REQUEST_METHOD_GET);
	            result.add(info
	            );
	            info.setMenu(menu.getTitle());
	        }
	    }

	    public List<AuthPermissionVo> getPermissionByUsername(String username) {
	        AuthUserPo user = userBiz.getUserByUsername(username);
	        List<AuthMenuPo> menus = menuBiz.getUserAuthorityMenuByUserId(user.getAuthUserId());
	        List<AuthPermissionVo> result = new ArrayList<AuthPermissionVo>();
	        AuthPermissionVo info = null;
	        menu2permission(menus, result);
	        List<AuthElementPo> elements = elementBiz.getAuthorityElementByUserId(user.getAuthUserId() + "");
	        element2permission(result, elements);
	        return result;
	    }

	    private void element2permission(List<AuthPermissionVo> result, List<AuthElementPo> elements) {
	    	AuthPermissionVo info;
	        for (AuthElementPo element : elements) {
	            info = new AuthPermissionVo();
	            info.setCode(element.getCode());
	            info.setType(element.getType());
	            info.setUri(element.getUri());
	            info.setMethod(element.getMethod());
	            info.setName(element.getName());
	            info.setMenu(element.getMenuId());
	            result.add(info);
	        }
	    }


	    private List<MenuTree> getMenuTree(List<AuthMenuPo> menus, int root) {
	        List<MenuTree> trees = new ArrayList<>();
	        MenuTree node = null;
	        for (AuthMenuPo menu : menus) {
	            node = new MenuTree();
	            node.setId(menu.getAuthMenuId());
	            BeanUtils.copyProperties(menu, node);
	            trees.add(node);
	        }
	        return TreeUtils.bulid(trees, root);
	    }

	    public UserPermissionVo getUserInfo(String token) throws Exception {
	        String username = userAuthUtil.getInfoFromToken(token).getUniqueName();
	        if (username == null) {
	            return null;
	        }
	        AuthUserVo user = this.getUserByUsername(username);
	        UserPermissionVo frontUser = new UserPermissionVo();
	        frontUser.setId(user.getId());
	        BeanUtils.copyProperties(user, frontUser);
	        List<AuthPermissionVo> permissionInfos = this.getPermissionByUsername(username);
	        Stream<AuthPermissionVo> menus = permissionInfos.parallelStream().filter((permission) -> {
	            return permission.getType().equals(GlobalConstants.RESOURCE_TYPE_MENU);
	        });
	        frontUser.setMenus(menus.collect(Collectors.toList()));
	        Stream<AuthPermissionVo> elements = permissionInfos.parallelStream().filter((permission) -> {
	            return !permission.getType().equals(GlobalConstants.RESOURCE_TYPE_MENU);
	        });
	        frontUser.setElements(elements.collect(Collectors.toList()));
	        return frontUser;
	    }

	    public List<MenuTree> getMenusByUsername(String token) throws Exception {
	        String username = userAuthUtil.getInfoFromToken(token).getUniqueName();
	        if (username == null) {
	            return null;
	        }
	        AuthUserPo user = userBiz.getUserByUsername(username);
	        List<AuthMenuPo> menus = menuBiz.getUserAuthorityMenuByUserId(user.getAuthUserId());
	        return getMenuTree(menus,GlobalConstants.ROOT);
	    }

}
