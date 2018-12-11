package com.cscloud.auth.server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 如果这个服务允许其他的服务调用，那么就添加一条对应的记录
 * @author Administrator
 *
 */
@Data
@ApiModel(value="服务实例所能访问的其他服务器")
@Table(name = "auth_client_resource")
public class AuthClientResourcePo {
    @Id
    //对于mysq的插入，使用唯一的主键
    private Integer id;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "client_id")
    private String clientId;

    private String description;

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Column(name = "crt_host")
    private String crtHost;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    private String attr6;

    private String attr7;

    private String attr8;
	

}
