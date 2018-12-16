package com.cscloud.auth.admin.vo;


import java.util.List;

import com.cscloud.auth.admin.domain.AuthUserPo;

import lombok.Data;

/**
 * 团用户的vo使用
 * @author Administrator
 *
 */
@Data
public class GroupUserVo {
	private List<AuthUserPo> members;
	private List<AuthUserPo> leaders;
	public GroupUserVo(List<AuthUserPo> members, List<AuthUserPo> leaders) {
		super();
		this.members = members;
		this.leaders = leaders;
	}
	
	

}