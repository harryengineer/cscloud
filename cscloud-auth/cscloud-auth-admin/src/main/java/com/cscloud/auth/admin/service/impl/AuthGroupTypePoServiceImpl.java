package com.cscloud.auth.admin.service.impl;

import com.cscloud.auth.admin.domain.AuthGroupTypePo;
import com.cscloud.auth.admin.mapper.AuthGroupTypePoMapper;
import com.cscloud.auth.admin.service.AuthGroupTypePoService;
import com.cscloud.common.core.support.BaseService;
import com.cscloud.common.core.support.IService;
import org.springframework.stereotype.Service;

/**
 *  groupType的service对应的类
 * @Auther: Administrator
 * @Date: 2018/12/20 16:17
 * @Description:
 */
@Service
public class AuthGroupTypePoServiceImpl extends BaseService<AuthGroupTypePoMapper,AuthGroupTypePo> implements AuthGroupTypePoService {
}
