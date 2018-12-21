package com.cscloud.common.core.bean;

/**
 * 用来封装对应的分页信息的类
 */
public class PageBean {
	private Integer page;
	private Integer limit;
	public Integer getPage() {
		if(page==null){
			return 1;
		}else {
			return page;
		}
	}
	public void setPage(Integer pageNum) {
		this.page = pageNum;
	}
	public Integer getLimit() {
		return limit == null ? 10 : limit;
	}
	public void setLimit(Integer pageSize) {
		this.limit = pageSize;
	}
}