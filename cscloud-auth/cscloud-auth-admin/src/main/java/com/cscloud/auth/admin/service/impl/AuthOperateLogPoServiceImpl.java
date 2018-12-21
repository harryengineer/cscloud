package com.cscloud.auth.admin.service.impl;

import com.cscloud.auth.admin.domain.AuthOperateLogPo;
import com.cscloud.auth.admin.mapper.AuthOperateLogPoMapper;
import com.cscloud.auth.admin.service.AuthOperateLogPoService;
import com.cscloud.common.core.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2018/12/21 14:18
 * @Description:
 */
@Service
public class AuthOperateLogPoServiceImpl extends BaseService<AuthOperateLogPoMapper,AuthOperateLogPo> implements AuthOperateLogPoService {
}
