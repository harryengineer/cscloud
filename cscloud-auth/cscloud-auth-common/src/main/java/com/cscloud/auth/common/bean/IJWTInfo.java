package com.cscloud.auth.common.bean;
/**
 *  规定jwt需要的信息
 * @author Administrator
 *
 */
public interface IJWTInfo {
    /**
     * 获取用户名,一般来说默认是服务的spring.application.name
     * @return
     */
    String getUniqueName();

    /**
     * 获取用户ID
     * @return
     */
    String getId();

    /**
     * 获取名称,一般是相同
     * @return
     */
    String getName();
}
