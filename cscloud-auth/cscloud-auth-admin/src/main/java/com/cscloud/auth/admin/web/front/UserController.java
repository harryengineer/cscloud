package com.cscloud.auth.admin.web.front;

import com.cscloud.auth.admin.domain.AuthUserPo;
import com.cscloud.common.core.bean.PageBean;
import com.cscloud.common.core.support.BaseController;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.auth.admin.service.AuthMenuPoService;
import com.cscloud.auth.admin.service.AuthUserPoService;
import com.cscloud.auth.admin.service.PermissionService;
import com.cscloud.auth.api.model.UserPermissionVo;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.util.ResUtils;

/**
 * 用户的请求类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<AuthUserPoService,AuthUserPo> {

    /**
     * 初始化注入bean给父类
     * @param baseService
     */
    @Autowired
    public UserController(AuthUserPoService baseService) {
        super(baseService);

    }

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private AuthMenuPoService menuBiz;

    @RequestMapping(value = "/front/info", method = RequestMethod.GET)
    public String getUserInfo(String token) throws Exception {
    	UserPermissionVo userInfo = permissionService.getUserInfo(token);
        if(userInfo==null) {
            return ResUtils.execRes(ErrorCode.UNLOGIN_ERROR);
        } else {
            return ResUtils.okRes(userInfo);
        }
        
        
    }

    @RequestMapping(value = "/front/menus", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
    public String   getMenusByUsername(String token) throws Exception {
        return ResUtils.okRes(permissionService.getMenusByUsername(token));
    }

    @RequestMapping(value = "/front/menu/all", method = RequestMethod.GET,produces = "text/html; charset=utf-8")
    public String getAllMenus() throws Exception {
        return ResUtils.okRes(menuBiz.selectAll());
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchUser(PageBean pageBean,String name ){
        if (StringUtils.isNotBlank(name)){
            PageInfo<AuthUserPo> info = baseService.searchByCondition(pageBean,name);
           return ResUtils.okRes(info);
        }
        return ResUtils.execRes(ErrorCode.PARAMETER_CHECK_ERROR);
    }





}
