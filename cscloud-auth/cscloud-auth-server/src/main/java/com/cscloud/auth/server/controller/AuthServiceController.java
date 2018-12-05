package com.cscloud.auth.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 单个服务实例可以访问其他服务的操作。比如user 可以访问 订单的那些模块等操作
 * @author Administrator
 *
 */
@RequestMapping("/service")
@RestController
public class AuthServiceController {

}
