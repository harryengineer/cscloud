package com.cscloud.auth.admin.web.front;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cscloud.auth.admin.domain.AuthGroupPo;
import com.cscloud.auth.admin.service.AuthGroupPoService;
import com.cscloud.auth.admin.service.AuthResourceAuthorityPoService;
import com.cscloud.auth.admin.util.TreeUtils;
import com.cscloud.auth.admin.vo.AuthorityMenuTreeVo;
import com.cscloud.auth.admin.vo.GroupTreeVo;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.constant.GlobalConstants;
import com.cscloud.common.base.util.ResUtils;
import com.cscloud.common.core.support.BaseController;

import io.swagger.annotations.Api;
import tk.mybatis.mapper.entity.Example;

/**
 * 群组的对应的操作
 * @author Administrator
 *
 */
@Controller
@RequestMapping("group")
@Api("群组模块")
public class GroupController extends BaseController<AuthGroupPoService,AuthGroupPo> {
	
    @Autowired
    private AuthResourceAuthorityPoService resourceAuthorityBiz;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(String name,String groupType) {
        if(StringUtils.isBlank(name) && StringUtils.isBlank(groupType)) {
            return ResUtils.okRes(new ArrayList<AuthGroupPo>());
        }
        Example example = new Example(AuthGroupPo.class);
        if (StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("name", "%" + name + "%");
        }
        if (StringUtils.isNotBlank(groupType)) {
            example.createCriteria().andEqualTo("groupType", groupType);
        }

        return ResUtils.okRes(baseSerivce.selectByExample(example));
    }



    @RequestMapping(value = "/{id}/user", method = RequestMethod.PUT)
    public String modifiyUsers( @PathVariable int id,String members,String leaders){
    	baseSerivce.modifyGroupUsers(id, members, leaders);
        return ResUtils.okRes();
    }

    @RequestMapping(value = "//{id}/user", method = RequestMethod.GET)
    public String getUsers(@PathVariable int id){
        return ResUtils.okRes(baseSerivce.getGroupUsers(id));
    }

    @RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.POST)
    public String modifyMenuAuthority( @PathVariable  int id , String menuTrees){
    	if (StringUtils.isBlank(menuTrees) ) {
    		return ResUtils.execRes(ErrorCode.PARAMETER_CHECK_ERROR);
    	}
        String [] menus = menuTrees.split(",");
        baseSerivce.modifyAuthorityMenu(id, menus);
        return ResUtils.okRes();
    }

    @RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.GET)
    public String getMenuAuthority(@PathVariable  int authorityId){
    	List<AuthorityMenuTreeVo> listTree = baseSerivce.getAuthorityMenu(authorityId);
        return ResUtils.okRes(listTree);
    }


    @RequestMapping(value = "/{id}/authority/element/remove", method = RequestMethod.POST)
    public String removeElementAuthority(@PathVariable int id,int menuId, int elementId){
        baseSerivce.removeAuthorityElement(id,menuId,elementId);
        return ResUtils.okRes();
    }

    @RequestMapping(value = "/{id}/authority/element", method = RequestMethod.GET)
    public String getElementAuthority(@PathVariable  int id){
        return ResUtils.okRes(baseSerivce.getAuthorityElementByAuthorityId(id));
    }


    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String tree(String name,String groupType) {
        if(StringUtils.isBlank(name) && StringUtils.isBlank(groupType)) {
            return ResUtils.okRes();
        }
        Example example = new Example(AuthGroupPo.class);
        if (StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("name", "%" + name + "%");
        }
        if (StringUtils.isNotBlank(groupType)) {
            example.createCriteria().andEqualTo("groupType", groupType);
        }
        return  ResUtils.okRes(getTree(baseSerivce.selectByExample(example), GlobalConstants.ROOT));
    }

//
    private List<GroupTreeVo> getTree(List<AuthGroupPo> groups,int root) {
        List<GroupTreeVo> trees = new ArrayList<GroupTreeVo>();
        GroupTreeVo node = null;
        for (AuthGroupPo group : groups) {
            node = new GroupTreeVo();
            node.setLabel(group.getName());
            BeanUtils.copyProperties(group, node);
            trees.add(node);
        }
        return TreeUtils.bulid(trees,root) ;
    }
}
