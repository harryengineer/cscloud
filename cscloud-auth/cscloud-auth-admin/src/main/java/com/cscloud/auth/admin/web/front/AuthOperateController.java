package com.cscloud.auth.admin.web.front;

import com.cscloud.auth.admin.domain.AuthOperateLogPo;
import com.cscloud.auth.admin.service.AuthOperateLogPoService;
import com.cscloud.common.core.support.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2018/12/21 14:26
 * @Description:
 */
@RequestMapping("/operatelog")
@RestController
public class AuthOperateController extends BaseController<AuthOperateLogPoService, AuthOperateLogPo> {

    @Autowired
    AuthOperateController(AuthOperateLogPoService authOperateLogPoService) {
        super(authOperateLogPoService);
    }


}
