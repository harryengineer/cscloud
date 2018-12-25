package com.cscloud.auth.admin.service.impl;

import com.cscloud.common.core.bean.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cscloud.auth.admin.domain.AuthUserPo;
import com.cscloud.auth.admin.mapper.AuthUserPoMapper;
import com.cscloud.auth.admin.service.AuthUserPoService;
import com.cscloud.common.core.support.BaseService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 *  用户的逻辑类
 * @author Administrator
 *
 */
@Service
public class AuthUserPoServiceImpl extends BaseService<AuthUserPoMapper, AuthUserPo> implements AuthUserPoService {

	@Override
	public AuthUserPo getUserByUsername(String username) {
		AuthUserPo user = new AuthUserPo();
		user.setUsername(username);
		return mapper.selectOne(user);
	}

	@Override
	public PageInfo<AuthUserPo> searchByCondition(PageBean pageBean, String name) {
		PageHelper.startPage(pageBean.getPage(),pageBean.getLimit());
		Example example = new Example(AuthUserPo.class);
		example.createCriteria().andLike("name","%" + name + "%");
		List<AuthUserPo> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}
	@Override
	public int save(AuthUserPo record) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		record.setPassword(encoder.encode(record.getPassword().trim()));
		return mapper.insertSelective(record);
	}

}
