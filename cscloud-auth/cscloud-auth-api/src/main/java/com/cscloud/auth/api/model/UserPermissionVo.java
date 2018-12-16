package com.cscloud.auth.api.model;

import java.util.List;

import lombok.Data;

/**
 * 用户的权限的vo展示
 * @author Administrator
 *
 */
@Data
public class UserPermissionVo {
    public String id;
    public String username;
    public String name;
    private String description;
    private String image;
    private List<AuthPermissionVo> menus;
    private List<AuthPermissionVo> elements;
}
