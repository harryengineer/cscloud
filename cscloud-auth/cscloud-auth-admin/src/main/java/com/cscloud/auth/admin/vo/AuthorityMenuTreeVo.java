package com.cscloud.auth.admin.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;



public class AuthorityMenuTreeVo extends TreeNode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4717463148010054701L;
	String text;
    List<AuthorityMenuTreeVo> nodes = new ArrayList<>();
    String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public AuthorityMenuTreeVo(String text, List<AuthorityMenuTreeVo> nodes) {
        this.text = text;
        this.nodes = nodes;
    }

    public AuthorityMenuTreeVo() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<AuthorityMenuTreeVo> getNodes() {
        return nodes;
    }

    public void setNodes(List<AuthorityMenuTreeVo> nodes) {
        this.nodes = nodes;
    }

    @Override
    public void setChildren(List<TreeNode> children) {
        super.setChildren(children);
        nodes = new ArrayList<AuthorityMenuTreeVo>();
    }

    @Override
    public void add(TreeNode node) {
        super.add(node);
        AuthorityMenuTreeVo n = new AuthorityMenuTreeVo();
        BeanUtils.copyProperties(node,n);
        nodes.add(n);
    }
}
