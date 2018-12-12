package com.cscloud.common.core.bean;

public class PageTemp {
	private Integer pageNum;
	private Integer pageSize;
	public Integer getPageNum() {
		if(pageNum==null){
			return 1;
		}else {
			return pageNum;
		}
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize == null ? 10 : pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}