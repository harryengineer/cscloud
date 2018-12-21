package com.cscloud.auth.admin.web.front;

import java.util.HashMap;
import java.util.List;

import com.cscloud.common.core.support.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cscloud.auth.admin.domain.AuthElementPo;
import com.cscloud.auth.admin.domain.AuthUserPo;
import com.cscloud.auth.admin.service.AuthElementPoService;
import com.cscloud.auth.admin.service.AuthUserPoService;
import com.cscloud.auth.common.util.BaseContextMap;
import com.cscloud.common.base.util.ResUtils;

import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

/**
 *
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/element")
public class ElementController  extends BaseController<AuthElementPoService,AuthElementPo> {

  @Autowired
  public ElementController(AuthElementPoService elementPoService) {
      super(elementPoService);
  }

  @Autowired
  private AuthUserPoService authUserPoService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String page(@RequestParam(defaultValue = "10") int limit,
      @RequestParam(defaultValue = "1") int page,String name, @RequestParam(defaultValue = "0") int menuId) {
    Example example = new Example(AuthElementPo.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("menuId", menuId);
    if(StringUtils.isNotBlank(name)){
      criteria.andLike("name", "%" + name + "%");
    }
    List<AuthElementPo> elements = baseService.selectByExample(example);
    HashMap<String, Object> hashMap = new HashMap<>();
    if (elements != null) {
    	hashMap.put("size", elements.size());
    	hashMap.put("data", elements);
    }

    return ResUtils.okRes(hashMap);
  }


  /**
   * 获取用户的权限元素
   * @param menuId
   * @return
   */
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public String getAuthorityElement(String menuId) {
	AuthUserPo authUserPo = new AuthUserPo();
	authUserPo.setUsername(getCurrentUserName());
	List<AuthUserPo> list = authUserPoService.select(authUserPo);
	Integer userId = null;
	if (list != null && list.size() > 0) {
		userId = list.get(0).getAuthUserId();
	}

    List<AuthElementPo> elements = baseService.getAuthorityElementByUserIdAndMenuId(userId + "",menuId);
    return ResUtils.okRes(elements);
  }

  /**
   *  获取用户的所有的权限元素
   * @return
   */
  @RequestMapping(value = "/user/menu", method = RequestMethod.GET)
  public String getAuthorityElement() {
	  AuthUserPo authUserPo = new AuthUserPo();
		authUserPo.setUsername(getCurrentUserName());
		List<AuthUserPo> list = authUserPoService.select(authUserPo);
		Integer userId = null;
		if (list != null && list.size() > 0) {
			userId = list.get(0).getAuthUserId();
		}
	    List<AuthElementPo> elements = baseService.getAuthorityElementByUserId(userId + "");
	    return ResUtils.okRes(elements);
  }
  
  public String getCurrentUserName() {
		return BaseContextMap.getUsername();
	}
}
