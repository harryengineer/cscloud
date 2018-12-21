package com.cscloud.common.core.support;

import com.cscloud.common.base.util.ResUtils;
import com.cscloud.common.core.bean.PageBean;
import com.cscloud.common.core.support.IService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 基础的controller 继承之后的话保存，获取id，分页等信息暂时用不到
 * @author Administrator
 *
 * @param <Entity>
 */
abstract  public class BaseController <T extends IService<Entity>,Entity> {

    @Autowired
	protected HttpServletRequest request;

    public BaseController(T t){
        this.baseService = t;
    }

	protected T baseService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String add(@RequestBody Entity entity) {
		baseService.save(entity);
		return ResUtils.okRes();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String get(@PathVariable int id) {
		Entity entity = baseService.selectByKey(id);
		return ResUtils.okRes(entity);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String update(@RequestBody Entity entity) {
		baseService.update(entity);
		return ResUtils.okRes();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String remove(@PathVariable int id) {
		baseService.deleteByKey(id);
		return ResUtils.okRes();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return ResUtils.okRes(baseService.selectAll());
	}


    /**
     * 查询对应的内容，只有初始化初始化查询字段才可以进行搜索
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(PageBean pageBean,Map<String,Object> page){
        PageInfo<Entity> pageInfo = baseService.getPage(pageBean);
        return ResUtils.okRes(pageInfo);
    }

}
