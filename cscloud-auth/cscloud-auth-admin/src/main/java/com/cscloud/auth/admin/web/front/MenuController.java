package com.cscloud.auth.admin.web.front;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import com.cscloud.common.core.support.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cscloud.auth.admin.domain.AuthMenuPo;
import com.cscloud.auth.admin.service.AuthMenuPoService;
import com.cscloud.auth.admin.service.AuthUserPoService;
import com.cscloud.auth.admin.util.TreeUtils;
import com.cscloud.auth.admin.vo.AuthorityMenuTreeVo;
import com.cscloud.auth.admin.vo.MenuTree;
import com.cscloud.auth.common.util.BaseContextMap;
import com.cscloud.common.base.constant.GlobalConstants;
import com.cscloud.common.base.util.ResUtils;
import com.cscloud.common.base.wrapper.Wrapper;

import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

/**
 * 对应的menu的对应的配置
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/menu")
public class MenuController  extends BaseController<AuthMenuPoService,AuthMenuPo> {
    @Autowired
    private AuthUserPoService userBiz;

    @Resource
    private AuthMenuPoService baseSerivce;

    @Autowired
    MenuController(AuthMenuPoService authMenuPoService) {
        super(authMenuPoService);
    }


    /**
     * 获取所有的按钮集合
     * @param title
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String  list(String title) {
        Example example = new Example(AuthMenuPo.class);
        if (StringUtils.isNotBlank(title)) {
            example.createCriteria().andLike("title", "%" + title + "%");
        }
        return ResUtils.okRes(baseSerivce.selectByExample(example));
    }

    /**
     * 用来获取数对应的数据
     * @param title
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String getTree(String title) {
        Example example = new Example(AuthMenuPo.class);
        if (StringUtils.isNotBlank(title)) {
            example.createCriteria().andLike("title", "%" + title + "%");
        }
        return ResUtils.okRes(getMenuTree(baseSerivce.selectByExample(example), GlobalConstants.ROOT));
    }

    /**
     * 获取系统的按钮
     * @return
     */
    @RequestMapping(value = "/system", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<List<AuthMenuPo>> getSystem() {
    	AuthMenuPo menu = new AuthMenuPo();
        menu.setParentId(GlobalConstants.ROOT);
        return Wrapper.success(baseSerivce.select(menu));
    }

    /**
     * 
     * 通过parent按钮的id获取子类所有的树
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/menuTree", method = RequestMethod.GET)
    public List<MenuTree> listMenu(Integer parentId) {
        try {
            if (parentId == null) {
                parentId = this.getSystem().getData().get(0).getAuthMenuId();
            }
        } catch (Exception e) {
            return new ArrayList<MenuTree>();
        }
        List<MenuTree> trees = new ArrayList<MenuTree>();
        MenuTree node = null;
        Example example = new Example(AuthMenuPo.class);
        AuthMenuPo parent = baseSerivce.selectByKey(parentId);
        example.createCriteria().andLike("path", parent.getPath() + "%").andNotEqualTo("id",parent.getAuthMenuId());
        return getMenuTree(baseSerivce.selectByExample(example), parent.getAuthMenuId());
    }

    /**
     * 权限树
     * @return
     */
    @RequestMapping(value = "/authorityTree", method = RequestMethod.GET)
    @ResponseBody
    public String listAuthorityMenu() {
        List<AuthorityMenuTreeVo> trees = new ArrayList<>();
        AuthorityMenuTreeVo node = null;
        for (AuthMenuPo menu : baseSerivce.selectAll()) {
            node = new AuthorityMenuTreeVo();
            node.setText(menu.getTitle());
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        }
        return ResUtils.okRes(TreeUtils.bulid(trees, GlobalConstants.ROOT));
    }

    /**
     * 获取用户的权限树
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/user/authorityTree", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuTree> listUserAuthorityMenu(Integer parentId){
        int userId = userBiz.getUserByUsername(getCurrentUserName()).getAuthUserId();
        try {
            if (parentId == null) {
                parentId = this.getSystem().getData().get(0).getAuthMenuId();
            }
        } catch (Exception e) {
            return new ArrayList<MenuTree>();
        }
        return getMenuTree(baseSerivce.getUserAuthorityMenuByUserId(userId),parentId);
    }

    @RequestMapping(value = "/user/system", method = RequestMethod.GET)
    @ResponseBody
    public String listUserAuthoritySystem() {
        int userId = userBiz.getUserByUsername(getCurrentUserName()).getAuthUserId();
        return ResUtils.okRes(baseSerivce.getUserAuthoritySystemByUserId(userId));
    }

    private List<MenuTree> getMenuTree(List<AuthMenuPo> menus,int root) {
        List<MenuTree> trees = new ArrayList<MenuTree>();
        MenuTree node = null;
        for (AuthMenuPo menu : menus) {
            node = new MenuTree();
            BeanUtils.copyProperties(menu, node);
            node.setLabel(menu.getTitle());
            node.setId(menu.getAuthMenuId());
            trees.add(node);
        }
        return TreeUtils.bulid(trees,root) ;
    }

    public String getCurrentUserName() {
    	return BaseContextMap.getUsername();
    }

}
