package com.cscloud.auth.admin.web.front;

import com.cscloud.auth.admin.domain.AuthGroupTypePo;
import com.cscloud.auth.admin.service.AuthGroupTypePoService;
import com.cscloud.common.base.util.ResUtils;
import com.cscloud.common.core.support.BaseController;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-08 11:51
 */
@RestController
@RequestMapping("/groupType")
public class GroupTypeController extends BaseController<AuthGroupTypePoService, AuthGroupTypePo> {
    @Autowired
    GroupTypeController(AuthGroupTypePoService authGroupTypePoService) {
        super(authGroupTypePoService);
    }


    @RequestMapping(value = "/pageSearch", method = RequestMethod.GET)
    public String pageSearch(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1") int page, String name) {
        Example example = new Example(AuthGroupTypePo.class);
        if (StringUtils.isNotBlank(name))
            example.createCriteria().andLike("name", "%" + name + "%");
        Page<Object> result = PageHelper.startPage(page, limit);
        List<AuthGroupTypePo> authGroupTypePos = baseService.selectByExample(example);
        return ResUtils.okRes(new PageInfo<>(authGroupTypePos));
    }

}
