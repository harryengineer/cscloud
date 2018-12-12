package com.cscloud.auth.admin.web.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cscloud.auth.admin.domain.AuthUserPo;
import com.cscloud.auth.admin.service.AuthMenuPoService;
import com.cscloud.auth.admin.service.AuthUserPoService;
import com.cscloud.auth.admin.service.PermissionService;
import com.cscloud.auth.api.model.UserPermissionVo;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.util.ResUtils;
import com.cscloud.common.core.support.BaseController;

/**
 * 用户的请求类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<AuthUserPoService,AuthUserPo> {
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

    @RequestMapping(value = "/front/menus", method = RequestMethod.GET)
    public String   getMenusByUsername(String token) throws Exception {
        return ResUtils.okRes(permissionService.getMenusByUsername(token));
    }

    @RequestMapping(value = "/front/menu/all", method = RequestMethod.GET)
    public String getAllMenus() throws Exception {
        return ResUtils.okRes(menuBiz.selectAll());
    }
}
