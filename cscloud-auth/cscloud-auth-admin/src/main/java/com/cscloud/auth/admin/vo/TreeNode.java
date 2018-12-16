package com.cscloud.auth.admin.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class TreeNode {
	protected int id;
	
	protected int parentId;
	
	List<TreeNode> children = new ArrayList<TreeNode>();

	public void add(TreeNode node) {
		children.add(node);
		
	}
	
}
