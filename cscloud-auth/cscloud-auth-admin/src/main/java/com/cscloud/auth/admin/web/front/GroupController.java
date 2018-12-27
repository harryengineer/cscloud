package com.cscloud.auth.admin.web.front;

import java.util.ArrayList;
import java.util.List;

import com.cscloud.common.core.support.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cscloud.auth.admin.domain.AuthGroupPo;
import com.cscloud.auth.admin.service.AuthGroupPoService;
import com.cscloud.auth.admin.util.TreeUtils;
import com.cscloud.auth.admin.vo.AuthorityMenuTreeVo;
import com.cscloud.auth.admin.vo.GroupTreeVo;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.constant.GlobalConstants;
import com.cscloud.common.base.util.ResUtils;

import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

/**
 * 群组的对应的操作
 * @author Administrator
 *
 */
@RestController
@RequestMapping("group")
public class GroupController  extends BaseController<AuthGroupPoService,AuthGroupPo> {


    @Autowired
    GroupController(AuthGroupPoService authGroupPoService) {
        super(authGroupPoService);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(String name,String groupType) {
        if(StringUtils.isBlank(name) && StringUtils.isBlank(groupType)) {
            return ResUtils.okRes(new ArrayList<AuthGroupPo>());
        }
        Example example = new Example(AuthGroupPo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        if (StringUtils.isNotBlank(groupType)) {
            criteria.andEqualTo("groupType", groupType);
        }

        return ResUtils.okRes(baseService.selectByExample(example));
    }



    @RequestMapping(value = "/{id}/user", method = RequestMethod.PUT)
    public String modifiyUsers( @PathVariable int id,String members,String leaders){
        baseService.modifyGroupUsers(id, members, leaders);
        return ResUtils.okRes();
    }

    @RequestMapping(value = "//{id}/user", method = RequestMethod.GET)
    public String getUsers(@PathVariable int id){
        return ResUtils.okRes(baseService.getGroupUsers(id));
    }

    @RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.POST)
    public String modifyMenuAuthority( @PathVariable  int id , String menuTrees){
    	if (StringUtils.isBlank(menuTrees) ) {
    		return ResUtils.execRes(ErrorCode.PARAMETER_CHECK_ERROR);
    	}
        String [] menus = menuTrees.split(",");
        baseService.modifyAuthorityMenu(id, menus);
        return ResUtils.okRes();
    }

    @RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.GET)
    public String getMenuAuthority(@PathVariable  int id){
    	List<AuthorityMenuTreeVo> listTree = baseService.getAuthorityMenu(id);
        return ResUtils.okRes(listTree);
    }


    @RequestMapping(value = "/{id}/authority/element/add", method = RequestMethod.POST)

    public String addElementAuthority(@PathVariable  int id,int menuId, int elementId){
        baseService.modifyAuthorityElement(id,menuId,elementId);
        return ResUtils.okRes();
    }

    @RequestMapping(value = "/{id}/authority/element/remove", method = RequestMethod.POST)
    public String removeElementAuthority(@PathVariable int id,int menuId, int elementId){
        baseService.removeAuthorityElement(id,menuId,elementId);
        return ResUtils.okRes();
    }

    @RequestMapping(value = "/{id}/authority/element", method = RequestMethod.GET)
    public String getElementAuthority(@PathVariable  int id){
        return ResUtils.okRes(baseService.getAuthorityElementByAuthorityId(id));
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
        return  ResUtils.okRes(getTree(baseService.selectByExample(example), GlobalConstants.ROOT));
    }

//
    private List<GroupTreeVo> getTree(List<AuthGroupPo> groups,int root) {
        List<GroupTreeVo> trees = new ArrayList<GroupTreeVo>();
        GroupTreeVo node = null;
        for (AuthGroupPo group : groups) {
            node = new GroupTreeVo();
            node.setLabel(group.getName());
            BeanUtils.copyProperties(group, node);
            node.setId(group.getAuthGroupId());
            trees.add(node);
        }
        return TreeUtils.bulid(trees,root) ;
    }
}
