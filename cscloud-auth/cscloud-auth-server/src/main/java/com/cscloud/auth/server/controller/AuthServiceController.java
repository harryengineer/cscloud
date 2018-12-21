package com.cscloud.auth.server.controller;

import com.cscloud.auth.server.domain.AuthClientPo;
import com.cscloud.auth.server.dto.ClientReousrceDto;
import com.cscloud.auth.server.service.AuthClientResourceService;
import com.cscloud.auth.server.service.AuthClientSerivce;
import com.cscloud.common.base.constant.ErrorCode;
import com.cscloud.common.base.util.ResUtils;
import com.cscloud.common.core.support.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2018/12/21 16:56
 * @Description:
 */
@RequestMapping("/service")
@RestController
public class AuthServiceController extends BaseController<AuthClientSerivce, AuthClientPo> {

    @Autowired
    private AuthClientResourceService authClientResource;

    @Autowired
    public AuthServiceController(AuthClientSerivce authClientSerivce) {
        super(authClientSerivce);
    }

    /**
     * 修改客户端可以访问的资源路径
     * @param id
     * @param serviceIds
     * @return
     */
    @RequestMapping(value = "/{id}/client",method = RequestMethod.POST)
    public String modifyPermitSource(@PathVariable int id, String serviceIds){

        authClientResource.modifyPermitSource(id,serviceIds);
        return  ResUtils.okRes();
    }


    /**
     * 获取服务器可以访问的资源服务器的列表
     * @return
     */
    @RequestMapping("/{id}/client")
    public String  getClientPermitResource(@PathVariable int id){
        ClientReousrceDto dto = authClientResource.getClientPermitResource(id);
        return ResUtils.okRes(dto);
    }


}
