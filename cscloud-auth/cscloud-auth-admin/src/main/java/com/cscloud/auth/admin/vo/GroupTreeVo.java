package com.cscloud.auth.admin.vo;

/**
 * 展示对应的group的对应的数的内容
 * @author Administrator
 *
 */
public class GroupTreeVo extends TreeNode {
	String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
