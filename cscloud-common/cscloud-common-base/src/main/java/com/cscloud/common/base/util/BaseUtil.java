package com.cscloud.common.base.util;

import java.io.Serializable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseUtil implements Serializable {


    public void debug(String debugInfo) {
        log.debug(this.getClass() + ":debug=> " + debugInfo);
    }

    public void info(String information) {
    	log.info(this.getClass() + ":info=> " + information);
    }

    public void error(String errorInfo) {
    	log.error(this.getClass() + ":error=> " + errorInfo);
    }

    public void error(String errorInfo, Throwable throwable) {
    	log.error(this.getClass() + ":error=> " + errorInfo, throwable);
    }

}
