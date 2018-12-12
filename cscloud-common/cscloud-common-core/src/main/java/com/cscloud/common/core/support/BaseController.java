package com.cscloud.common.core.support;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cscloud.common.base.util.ResUtils;

/**
 * 基础的controller 继承之后的话保存，获取id，分页等信息暂时用不到
 * 
 * @author Administrator
 *
 * @param <Service>
 * @param <Entity>
 */
public class BaseController<Service extends IService<Entity>, Entity> {

	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected Service baseSerivce;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String add(@RequestBody Entity entity) {
		baseSerivce.save(entity);
		return ResUtils.okRes();
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@ResponseBody
	public String get(int id) {
		Entity entity = baseSerivce.selectByKey(id);
		return ResUtils.okRes(entity);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String update(@RequestBody Entity entity) {
		baseSerivce.update(entity);
		return ResUtils.okRes();
	}

	@RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
	@ResponseBody
	public String remove(@PathVariable int id) {
		baseSerivce.deleteByKey(id);
		return ResUtils.okRes();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return ResUtils.okRes(baseSerivce.selectAll());
	}

//  用不到把
//	@RequestMapping(value = "/page", method = RequestMethod.GET)
//	public String getPage(PageTemp pageTemp,@RequestBody Entity entity) {
//		
//		return baseSerivce.selectPageByCondition(pageTemp,entity);
//	}

}
