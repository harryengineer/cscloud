package com.cscloud.auth.admin.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "auth_operate_log")
public class AuthOperateLogPo implements Serializable {
    @Id
    @Column(name = "auth_log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authLogId;
    @Column(name = "sql_context")
    private String sqlContext;
    @Column(name = "table_name")
    private String tableName;
    @Column(name = "op_type")
    private String opType;

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Column(name = "crt_host")
    private String crtHost;

    public String getSqlContext() {
        return sqlContext;
    }

    public void setSqlContext(String sqlContext) {
        this.sqlContext = sqlContext;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public String getCrtName() {
        return crtName;
    }

    public void setCrtName(String crtName) {
        this.crtName = crtName;
    }

    public String getCrtHost() {
        return crtHost;
    }

    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost;
    }

    public Integer getAuthLogId() {
        return authLogId;
    }

    public void setAuthLogId(Integer authLogId) {
        this.authLogId = authLogId;
    }


}