package com.cscloud.auth.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cscloud.auth.admin.domain.AuthGroupPo;
import com.cscloud.auth.admin.domain.AuthMenuPo;
import com.cscloud.auth.admin.domain.AuthResourceAuthorityPo;
import com.cscloud.auth.admin.mapper.AuthGroupPoMapper;
import com.cscloud.auth.admin.mapper.AuthMenuPoMapper;
import com.cscloud.auth.admin.mapper.AuthResourceAuthorityPoMapper;
import com.cscloud.auth.admin.mapper.AuthUserPoMapper;
import com.cscloud.auth.admin.service.AuthGroupPoService;
import com.cscloud.auth.admin.vo.AuthorityMenuTreeVo;
import com.cscloud.auth.admin.vo.GroupUserVo;
import com.cscloud.common.base.constant.GlobalConstants;
import com.cscloud.common.core.support.BaseService;


@Service
public class AuthGroupPoServiceImpl extends BaseService<AuthGroupPoMapper,AuthGroupPo> implements AuthGroupPoService {

	@Resource
	private AuthUserPoMapper authUserPoMapper;
	
	@Resource
	private AuthResourceAuthorityPoMapper authResourceAuthorityPoMapper;
	
	@Resource
	private AuthMenuPoMapper authMenuPoMapper;
	
	@Override
	public void modifyGroupUsers(int groupId, String members, String leaders) {
		mapper.deleteGroupLeadersById(groupId);
        mapper.deleteGroupMembersById(groupId);
	    if (!StringUtils.isEmpty(members)) {
	        String[] mem = members.split(",");
	        for (String m : mem) {
	            mapper.insertGroupMembersById(groupId, Integer.parseInt(m));
	        }
	    }
	    if (!StringUtils.isEmpty(leaders)) {
	        String[] mem = leaders.split(",");
	        for (String m : mem) {
	            mapper.insertGroupLeadersById(groupId, Integer.parseInt(m));
	        }
	    }
		
	}

	@Override
	public GroupUserVo getGroupUsers(Integer groupId) {
		return new GroupUserVo(authUserPoMapper.selectMemberByGroupId(groupId), authUserPoMapper.selectLeaderByGroupId(groupId)) ;
	}

	@Override
	public void modifyAuthorityMenu(int groupId, String[] menus) {
		authResourceAuthorityPoMapper.deleteByAuthorityIdAndResourceType(groupId + "", GlobalConstants.RESOURCE_TYPE_MENU);
        List<AuthMenuPo> menuList = authMenuPoMapper.selectAll();
        Map<String, String> map = new HashMap<String, String>();
        for (AuthMenuPo menu : menuList) {
            map.put(menu.getAuthMenuId().toString(), menu.getParentId().toString());
        }
        Set<String> relationMenus = new HashSet<String>();
        relationMenus.addAll(Arrays.asList(menus));
        AuthResourceAuthorityPo authority = null;
        
        for (String menuId : menus) {
            findParentID(map, relationMenus, menuId);
        }
        for (String menuId : relationMenus) {
            authority = new AuthResourceAuthorityPo();
            authority.setAuthorityType(GlobalConstants.AUTHORITY_TYPE_GROUP);
            authority.setResourceType(GlobalConstants.RESOURCE_TYPE_MENU);
            authority.setAuthorityId(groupId + "");
            authority.setResourceId(menuId);
            authority.setParentId("-1");
            authResourceAuthorityPoMapper.insertSelective(authority);
        }
		
	}

	   private void findParentID(Map<String, String> map, Set<String> relationMenus, String id) {
	        String parentId = map.get(id);
	        if (String.valueOf(GlobalConstants.ROOT).equals(id)) {
	            return;
	        }
	        relationMenus.add(parentId);
	        findParentID(map, relationMenus, parentId);
	    }
	   
	   
	   
	   /**
	     * 获取群主关联的菜单
	     *
	     * @return
	     */
	    public List<AuthorityMenuTreeVo> getAuthorityMenu(int authorityId) {
	        List<AuthMenuPo> menus = authMenuPoMapper.selectMenuByAuthorityId(String.valueOf(authorityId), GlobalConstants.AUTHORITY_TYPE_GROUP);
	        List<AuthorityMenuTreeVo> trees = new ArrayList<AuthorityMenuTreeVo>();
	        AuthorityMenuTreeVo node = null;
	        for (AuthMenuPo menu : menus) {
	            node = new AuthorityMenuTreeVo();
	            node.setText(menu.getTitle());
	            BeanUtils.copyProperties(menu, node);
	            node.setId(menu.getAuthMenuId());
	            trees.add(node);
	        }
	        return trees;
	    }

	@Override
	public void removeAuthorityElement(int id, int menuId, int elementId) {
	      AuthResourceAuthorityPo authority = new AuthResourceAuthorityPo();
        authority.setAuthorityId(id + "");
        authority.setResourceId(elementId + "");
        authority.setParentId("-1");
        authResourceAuthorityPoMapper.delete(authority);
		
	}

	@Override
	public List<Integer> getAuthorityElementByAuthorityId(int id) {
        AuthResourceAuthorityPo authority = new AuthResourceAuthorityPo();
        authority.setAuthorityType(GlobalConstants.AUTHORITY_TYPE_GROUP);
        authority.setResourceType(GlobalConstants.RESOURCE_TYPE_BTN);
        authority.setAuthorityId(id + "");
        List<AuthResourceAuthorityPo> authorities = authResourceAuthorityPoMapper.select(authority);
        List<Integer> ids = new ArrayList<Integer>();
        for (AuthResourceAuthorityPo auth : authorities) {
            ids.add(Integer.parseInt(auth.getResourceId()));
        }
        return ids;
	}


	public void modifyAuthorityElement(int groupId, int menuId, int elementId) {
		AuthResourceAuthorityPo authority = new AuthResourceAuthorityPo();
		authority.setAuthorityType(GlobalConstants.AUTHORITY_TYPE_GROUP);
		authority.setResourceType(GlobalConstants.RESOURCE_TYPE_BTN);
		authority.setAuthorityId(groupId + "");
		authority.setResourceId(elementId + "");
		authority.setParentId("-1");
		authResourceAuthorityPoMapper.insertSelective(authority);
	}
	
	

}
