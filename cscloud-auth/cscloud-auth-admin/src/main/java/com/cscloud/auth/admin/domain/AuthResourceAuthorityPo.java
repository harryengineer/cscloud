package com.cscloud.auth.admin.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "auth_base_resource_authority")
public class AuthResourceAuthorityPo implements Serializable {
    @Id
    @Column(name = "resource_authority_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceAuthorityId;

    /**
     * 角色ID
     */
    @Column(name = "authority_id")
    private String authorityId;

    /**
     * 角色类型
     */
    @Column(name = "authority_type")
    private String authorityType;

    /**
     * 资源ID
     */
    @Column(name = "resource_id")
    private String resourceId;

    /**
     * 资源类型
     */
    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "parent_id")
    private String parentId;

    private String path;

    private String description;

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Column(name = "crt_host")
    private String crtHost;

    @Column(name = "upd_time")
    private String updTime;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    private String attr6;

    private String attr7;

    private String attr8;

    private static final long serialVersionUID = 1L;

    /**
     * @return resource_authority_id
     */
    public Integer getResourceAuthorityId() {
        return resourceAuthorityId;
    }

    /**
     * @param resourceAuthorityId
     */
    public void setResourceAuthorityId(Integer resourceAuthorityId) {
        this.resourceAuthorityId = resourceAuthorityId;
    }

    /**
     * 获取角色ID
     *
     * @return authority_id - 角色ID
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * 设置角色ID
     *
     * @param authorityId 角色ID
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 获取角色类型
     *
     * @return authority_type - 角色类型
     */
    public String getAuthorityType() {
        return authorityType;
    }

    /**
     * 设置角色类型
     *
     * @param authorityType 角色类型
     */
    public void setAuthorityType(String authorityType) {
        this.authorityType = authorityType;
    }

    /**
     * 获取资源ID
     *
     * @return resource_id - 资源ID
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源ID
     *
     * @param resourceId 资源ID
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取资源类型
     *
     * @return resource_type - 资源类型
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * 设置资源类型
     *
     * @param resourceType 资源类型
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * @return parent_id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return crt_time
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * @param crtTime
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * @return crt_user
     */
    public String getCrtUser() {
        return crtUser;
    }

    /**
     * @param crtUser
     */
    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    /**
     * @return crt_name
     */
    public String getCrtName() {
        return crtName;
    }

    /**
     * @param crtName
     */
    public void setCrtName(String crtName) {
        this.crtName = crtName;
    }

    /**
     * @return crt_host
     */
    public String getCrtHost() {
        return crtHost;
    }

    /**
     * @param crtHost
     */
    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost;
    }


    /**
     * @return attr2
     */
    public String getAttr2() {
        return attr2;
    }

    /**
     * @param attr2
     */
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    /**
     * @return attr3
     */
    public String getAttr3() {
        return attr3;
    }

    /**
     * @param attr3
     */
    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    /**
     * @return attr4
     */
    public String getAttr4() {
        return attr4;
    }

    /**
     * @param attr4
     */
    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    /**
     * @return attr5
     */
    public String getAttr5() {
        return attr5;
    }

    /**
     * @param attr5
     */
    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    /**
     * @return attr6
     */
    public String getAttr6() {
        return attr6;
    }

    /**
     * @param attr6
     */
    public void setAttr6(String attr6) {
        this.attr6 = attr6;
    }

    /**
     * @return attr7
     */
    public String getAttr7() {
        return attr7;
    }

    /**
     * @param attr7
     */
    public void setAttr7(String attr7) {
        this.attr7 = attr7;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }

    /**
     * @return attr8
     */
    public String getAttr8() {
        return attr8;
    }

    /**
     * @param attr8
     */
    public void setAttr8(String attr8) {
        this.attr8 = attr8;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourceAuthorityId=").append(resourceAuthorityId);
        sb.append(", authorityId=").append(authorityId);
        sb.append(", authorityType=").append(authorityType);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", parentId=").append(parentId);
        sb.append(", path=").append(path);
        sb.append(", description=").append(description);
        sb.append(", crtTime=").append(crtTime);
        sb.append(", crtUser=").append(crtUser);
        sb.append(", crtName=").append(crtName);
        sb.append(", crtHost=").append(crtHost);
        sb.append(", attr1=").append(updTime);
        sb.append(", attr2=").append(attr2);
        sb.append(", attr3=").append(attr3);
        sb.append(", attr4=").append(attr4);
        sb.append(", attr5=").append(attr5);
        sb.append(", attr6=").append(attr6);
        sb.append(", attr7=").append(attr7);
        sb.append(", attr8=").append(attr8);
        sb.append("]");
        return sb.toString();
    }
}