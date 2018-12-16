/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : kefu

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-12-07 18:01:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_base_element
-- ----------------------------
DROP TABLE IF EXISTS `auth_base_element`;
CREATE TABLE `auth_base_element` (
  `auth_element_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '资源编码',
  `type` varchar(255) DEFAULT NULL COMMENT '资源类型',
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `uri` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `menu_id` varchar(255) DEFAULT NULL COMMENT '资源关联菜单',
  `parent_id` varchar(255) DEFAULT NULL,
  `path` varchar(2000) DEFAULT NULL COMMENT '资源树状检索路径',
  `method` varchar(10) DEFAULT NULL COMMENT '资源请求类型',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_element_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_base_element
-- ----------------------------
INSERT INTO `auth_base_element` VALUES ('3', 'userManager:btn_add', 'button', '新增', '/admin/user', '1', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('4', 'userManager:btn_edit', 'button', '编辑', '/admin/user/{*}', '1', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('5', 'userManager:btn_del', 'button', '删除', '/admin/user/{*}', '1', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('9', 'menuManager:element', 'uri', '按钮页面', '/admin/element', '6', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('10', 'menuManager:btn_add', 'button', '新增', '/admin/menu/{*}', '6', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('11', 'menuManager:btn_edit', 'button', '编辑', '/admin/menu/{*}', '6', '', '', 'PUT', '', '2017-06-24 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `auth_base_element` VALUES ('12', 'menuManager:btn_del', 'button', '删除', '/admin/menu/{*}', '6', '', '', 'DELETE', '', '2017-06-24 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `auth_base_element` VALUES ('13', 'menuManager:btn_element_add', 'button', '新增元素', '/admin/element', '6', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('14', 'menuManager:btn_element_edit', 'button', '编辑元素', '/admin/element/{*}', '6', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('15', 'menuManager:btn_element_del', 'button', '删除元素', '/admin/element/{*}', '6', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('16', 'groupManager:btn_add', 'button', '新增', '/admin/group', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('17', 'groupManager:btn_edit', 'button', '编辑', '/admin/group/{*}', '7', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('18', 'groupManager:btn_del', 'button', '删除', '/admin/group/{*}', '7', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('19', 'groupManager:btn_userManager', 'button', '分配用户', '/admin/group/{*}/user', '7', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('20', 'groupManager:btn_resourceManager', 'button', '分配权限', '/admin/group/{*}/authority', '7', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('21', 'groupManager:menu', 'uri', '分配菜单', '/admin/group/{*}/authority/menu', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('22', 'groupManager:element', 'uri', '分配资源', '/admin/group/{*}/authority/element', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('23', 'userManager:view', 'uri', '查看', '/admin/user/{*}', '1', '', '', 'GET', '', '2017-06-26 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `auth_base_element` VALUES ('24', 'menuManager:view', 'uri', '查看', '/admin/menu/{*}', '6', '', '', 'GET', '', '2017-06-26 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `auth_base_element` VALUES ('27', 'menuManager:element_view', 'uri', '查看', '/admin/element/{*}', '6', null, null, 'GET', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('28', 'groupManager:view', 'uri', '查看', '/admin/group/{*}', '7', null, null, 'GET', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('32', 'groupTypeManager:view', 'uri', '查看', '/admin/groupType/{*}', '8', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('33', 'groupTypeManager:btn_add', 'button', '新增', '/admin/groupType', '8', null, null, 'POST', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('34', 'groupTypeManager:btn_edit', 'button', '编辑', '/admin/groupType/{*}', '8', null, null, 'PUT', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('35', 'groupTypeManager:btn_del', 'button', '删除', '/admin/groupType/{*}', '8', null, null, 'DELETE', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('41', 'gateLogManager:view', 'button', '查看', '/admin/gateLog', '27', null, null, 'GET', '', '2017-07-01 00:00:00', '1', 'admin', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('42', 'serviceManager:view', 'URI', '查看', '/auth/service/{*}', '30', null, null, 'GET', null, '2017-12-26 20:17:42', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('43', 'serviceManager:btn_add', 'button', '新增', '/auth/service', '30', null, null, 'POST', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('44', 'serviceManager:btn_edit', 'button', '编辑', '/auth/service/{*}', '30', null, null, 'PUT', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('45', 'serviceManager:btn_del', 'button', '删除', '/auth/service/{*}', '30', null, null, 'DELETE', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_element` VALUES ('46', 'serviceManager:btn_clientManager', 'button', '服务授权', '/auth/service/{*}/client', '30', null, null, 'POST', null, '2017-12-30 16:32:48', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_base_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_base_group`;
CREATE TABLE `auth_base_group` (
  `auth_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `parent_id` int(11) NOT NULL COMMENT '上级节点',
  `path` varchar(2000) DEFAULT NULL COMMENT '树状关系',
  `type` char(1) DEFAULT NULL COMMENT '类型',
  `group_type` int(11) NOT NULL COMMENT '角色组类型',
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_base_group
-- ----------------------------
INSERT INTO `auth_base_group` VALUES ('1', 'adminRole', '管理员', '-1', '/adminRole', null, '1', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group` VALUES ('3', 'testGroup', '体验组', '-1', '/testGroup', null, '1', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group` VALUES ('4', 'visitorRole', '游客', '3', '/testGroup/visitorRole', null, '1', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group` VALUES ('6', 'company', 'AG集团', '-1', '/company', null, '2', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group` VALUES ('7', 'financeDepart', '财务部', '6', '/company/financeDepart', null, '2', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group` VALUES ('8', 'hrDepart', '人力资源部', '6', '/company/hrDepart', null, '2', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group` VALUES ('9', 'blogAdmin', '博客管理员', '-1', '/blogAdmin', null, '1', '', '2017-07-16 16:59:30', '1', 'Mr.AG', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_base_group_leader
-- ----------------------------
DROP TABLE IF EXISTS `auth_base_group_leader`;
CREATE TABLE `auth_base_group_leader` (
  `auth_group_leader_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_group_leader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_base_group_leader
-- ----------------------------
INSERT INTO `auth_base_group_leader` VALUES ('6', '9', '4', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group_leader` VALUES ('13', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_base_group_member
-- ----------------------------
DROP TABLE IF EXISTS `auth_base_group_member`;
CREATE TABLE `auth_base_group_member` (
  `auth_group_member_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_group_member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_base_group_member
-- ----------------------------
INSERT INTO `auth_base_group_member` VALUES ('2', '4', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group_member` VALUES ('9', '9', '4', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group_member` VALUES ('10', '1', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_base_group_type
-- ----------------------------
DROP TABLE IF EXISTS `auth_base_group_type`;
CREATE TABLE `auth_base_group_type` (
  `auth_group_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `crt_user` varchar(255) DEFAULT NULL COMMENT '创建人ID',
  `crt_name` varchar(255) DEFAULT NULL COMMENT '创建人',
  `crt_host` varchar(255) DEFAULT NULL COMMENT '创建主机',
  `upd_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `upd_user` varchar(255) DEFAULT NULL COMMENT '最后更新人ID',
  `upd_name` varchar(255) DEFAULT NULL COMMENT '最后更新人',
  `upd_host` varchar(255) DEFAULT NULL COMMENT '最后更新主机',
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_group_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_base_group_type
-- ----------------------------
INSERT INTO `auth_base_group_type` VALUES ('1', 'role', '角色类型', 'role', null, null, null, null, '2017-08-25 17:52:37', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group_type` VALUES ('2', 'depart', '部门类型', null, null, null, null, null, '2017-08-25 17:52:43', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_group_type` VALUES ('3', 'free', '自定义类型', 'sadf', null, null, null, null, '2017-08-26 08:22:25', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_base_menu
-- ----------------------------
DROP TABLE IF EXISTS `auth_base_menu`;
CREATE TABLE `auth_base_menu` (
  `auth_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '路径编码',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `parent_id` int(11) NOT NULL COMMENT '父级节点',
  `href` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `type` char(10) DEFAULT NULL,
  `order_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `path` varchar(500) DEFAULT NULL COMMENT '菜单上下级关系',
  `enabled` char(1) DEFAULT NULL COMMENT '启用禁用',
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_base_menu
-- ----------------------------
INSERT INTO `auth_base_menu` VALUES ('1', 'userManager', '用户管理', '5', '/admin/user', 'fa-user', 'menu', '0', '', '/adminSys/baseManager/userManager', null, null, null, null, null, '2017-09-05 21:06:51', '1', 'Mr.AG', '127.0.0.1', '_import(\'admin/user/index\')', null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('5', 'baseManager', '基础配置管理', '13', '/admin', 'setting', 'dirt', '0', '', '/adminSys/baseManager', null, null, null, null, null, '2017-09-05 21:46:11', '1', 'Mr.AG', '127.0.0.1', 'Layout', null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('6', 'menuManager', '菜单管理', '5', '/admin/menu', 'category', 'menu', '0', '', '/adminSys/baseManager/menuManager', null, null, null, null, null, '2017-09-05 21:10:25', '1', 'Mr.AG', '127.0.0.1', '_import(\'admin/menu/index\')', null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('7', 'groupManager', '角色权限管理', '5', '/admin/group', 'group_fill', 'menu', '0', '', '/adminSys/baseManager/groupManager', null, null, null, null, null, '2017-09-05 21:11:34', '1', 'Mr.AG', '127.0.0.1', 'import(\'admin/group/index\')', null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('8', 'groupTypeManager', '角色类型管理', '5', '/admin/groupType', 'fa-users', 'menu', '0', '', '/adminSys/baseManager/groupTypeManager', null, null, null, null, null, '2017-09-05 21:12:28', '1', 'Mr.AG', '127.0.0.1', '_import(\'admin/groupType/index\')', null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('13', 'adminSys', '权限管理系统', '-1', '/base', 'setting', 'dirt', '0', '', '/adminSys', null, null, null, null, null, '2017-09-28 12:09:22', '1', 'Mr.AG', '127.0.0.1', 'Layout', null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('21', 'dictManager', '数据字典', '5', '', 'fa fa-book', null, '0', '', '/adminSys/baseManager/dictManager', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('27', 'gateLogManager', '操作日志', '5', '/admin/gateLog', 'viewlist', 'menu', '0', '', '/adminSys/baseManager/gateLogManager', null, '2017-07-01 00:00:00', '1', 'admin', '0:0:0:0:0:0:0:1', '2017-09-05 22:32:55', '1', 'Mr.AG', '127.0.0.1', '_import(\'admin/gateLog/index\')', null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('29', 'authManager', '服务权限管理', '13', '/auth', 'service', null, '0', '服务权限管理', '/adminSys/authManager', null, '2017-12-26 19:54:45', '1', 'Mr.AG', '127.0.0.1', '2017-12-26 19:55:18', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('30', 'serviceManager', '服务管理', '29', '/auth/service', 'client', null, '0', '服务管理', '/adminSys/authManager/serviceManager', null, '2017-12-26 19:56:06', '1', 'Mr.AG', '127.0.0.1', '2017-12-26 19:56:06', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('31', 'monitorManager', '监控模块管理', '13', null, 'service', null, '0', null, '/adminSys/monitorManager', null, '2018-02-25 09:36:35', '1', 'Mr.AG', '127.0.0.1', '2018-02-25 09:38:55', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('32', 'serviceEurekaManager', '服务注册中心', '31', null, 'client', null, '0', null, '/adminSys/monitorManager/serviceEurekaManager', null, '2018-02-25 09:37:04', '1', 'Mr.AG', '127.0.0.1', '2018-02-25 09:37:41', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('33', 'serviceMonitorManager', '服务状态监控', '31', null, 'client', null, '0', null, '/adminSys/monitorManager/serviceEurekaManager', null, '2018-02-25 09:37:05', '1', 'Mr.AG', '127.0.0.1', '2018-02-25 09:37:35', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_menu` VALUES ('34', 'serviceZipkinManager', '服务链路监控', '31', null, 'client', null, '0', null, '/adminSys/monitorManager/serviceZipkinManager', null, '2018-02-25 09:38:05', '1', 'Mr.AG', '127.0.0.1', '2018-02-25 09:38:05', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_base_resource_authority
-- ----------------------------
DROP TABLE IF EXISTS `auth_base_resource_authority`;
CREATE TABLE `auth_base_resource_authority` (
  `resource_authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_id` varchar(255) DEFAULT NULL COMMENT '角色ID',
  `authority_type` varchar(255) DEFAULT NULL COMMENT '角色类型',
  `resource_id` varchar(255) DEFAULT NULL COMMENT '资源ID',
  `resource_type` varchar(255) DEFAULT NULL COMMENT '资源类型',
  `parent_id` varchar(255) DEFAULT NULL,
  `path` varchar(2000) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resource_authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=986 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_base_resource_authority
-- ----------------------------
INSERT INTO `auth_base_resource_authority` VALUES ('287', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('288', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('289', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('290', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('291', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('294', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('295', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('296', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('297', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('298', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('299', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('300', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('301', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('302', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('303', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('304', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('305', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('306', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('307', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('308', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('309', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('310', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('311', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('312', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('313', '1', 'group', '16', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('314', '1', 'group', '17', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('315', '1', 'group', '18', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('317', '1', 'group', '20', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('318', '1', 'group', '21', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('319', '1', 'group', '22', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('349', '4', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('371', '1', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('372', '1', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('373', '1', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('374', '1', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('375', '1', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('378', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('379', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('380', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('381', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('382', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('383', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('384', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('385', '1', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('386', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('387', '1', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('388', '1', 'group', '16', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('389', '1', 'group', '18', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('390', '1', 'group', '17', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('392', '1', 'group', '20', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('393', '1', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('394', '1', 'group', '22', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('395', '1', 'group', '21', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('396', '4', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('397', '4', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('398', '4', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('399', '4', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('400', '4', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('401', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('402', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('403', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('421', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('422', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('423', '4', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('424', '4', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('436', '1', 'group', '32', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('437', '1', 'group', '33', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('438', '1', 'group', '34', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('439', '1', 'group', '35', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('440', '4', 'group', '32', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('464', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('465', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('466', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('467', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('468', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('469', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('470', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('471', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('472', '1', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('492', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('493', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('494', '1', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('516', '4', 'group', '41', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('517', '4', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('518', '4', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('519', '4', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('611', '4', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('612', '4', 'group', '36', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('628', '4', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('629', '4', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('630', '4', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('631', '4', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('632', '4', 'group', '7', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('633', '4', 'group', '8', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('634', '4', 'group', '27', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('635', '4', 'group', '9', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('636', '4', 'group', '24', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('637', '4', 'group', '22', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('638', '4', 'group', '23', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('639', '4', 'group', '25', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('640', '4', 'group', '26', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('641', '4', 'group', '28', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('666', '1', 'group', '41', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('689', '1', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('691', '1', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('710', '9', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('711', '9', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('712', '9', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('713', '9', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('718', '9', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('719', '9', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('720', '9', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('721', '9', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('722', '1', 'group', '41', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('749', '10', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('750', '10', 'group', '14', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('751', '10', 'group', '-1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('752', '10', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('753', '10', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('754', '10', 'group', '17', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('755', '10', 'group', '20', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('774', '1', 'group', '3', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('775', '1', 'group', '4', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('812', '1', 'group', '19', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('924', '1', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('945', '1', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('956', '1', 'group', '46', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('967', '1', 'group', '33', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('968', '1', 'group', '34', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('969', '1', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('970', '1', 'group', '-1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('971', '1', 'group', '27', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('972', '1', 'group', '29', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('973', '1', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('974', '1', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('975', '1', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('976', '1', 'group', '7', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('977', '1', 'group', '8', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('978', '1', 'group', '30', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('979', '1', 'group', '31', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('980', '1', 'group', '32', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('981', '9', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('982', '9', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('983', '9', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('984', '9', 'group', '-1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_resource_authority` VALUES ('985', '9', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_base_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_base_user`;
CREATE TABLE `auth_base_user` (
  `auth_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `tel_phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_base_user
-- ----------------------------
INSERT INTO `auth_base_user` VALUES ('1', 'admin', '$2a$12$S/yLlj9kzi5Dgsz97H4rAekxrPlk/10eXp1lUJcAVAx.2M9tOpWie', 'Mr.AG', '', null, '', null, '', '男', null, null, '', null, null, null, null, '2017-11-16 23:23:49', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_user` VALUES ('2', 'test', '$2a$12$zWe6knO6rGp15UVfdWTTxu.Ykt.k3QnD5FPoj6a1cnL63csHY2A1S', '测试账户', '', null, '', null, '', '男', null, null, '', null, null, null, null, '2017-07-15 19:18:07', '1', '管理员', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_base_user` VALUES ('4', 'blog', '$2a$12$S/yLlj9kzi5Dgsz97H4rAekxrPlk/10eXp1lUJcAVAx.2M9tOpWie', 'Mr.AG(博主)', '', null, '', null, '', '女', null, null, '12', null, null, null, null, '2018-03-07 11:21:10', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_client
-- ----------------------------
DROP TABLE IF EXISTS `auth_client`;
CREATE TABLE `auth_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '服务编码',
  `secret` varchar(255) DEFAULT NULL COMMENT '服务密钥',
  `name` varchar(255) DEFAULT NULL COMMENT '服务名',
  `locked` char(1) DEFAULT NULL COMMENT '是否锁定',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `crt_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `crt_name` varchar(255) DEFAULT NULL COMMENT '创建人姓名',
  `crt_host` varchar(255) DEFAULT NULL COMMENT '创建主机',
  `upd_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `upd_user` varchar(255) DEFAULT NULL COMMENT '更新人',
  `upd_name` varchar(255) DEFAULT NULL COMMENT '更新姓名',
  `upd_host` varchar(255) DEFAULT NULL COMMENT '更新主机',
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_client
-- ----------------------------
INSERT INTO `auth_client` VALUES ('1', 'ace-gate', '123456', 'ace-gate', '0', '', null, '', '', '', '2017-07-07 21:51:32', '1', '管理员', '0:0:0:0:0:0:0:1', '', '', '', '', '', '', '', '');
INSERT INTO `auth_client` VALUES ('3', 'ace-admin', '123456', 'ace-admin', '0', '', null, null, null, null, '2017-07-06 21:42:17', '1', '管理员', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null);
INSERT INTO `auth_client` VALUES ('6', 'ace-auth', '123456', 'ace-auth', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_client` VALUES ('11', 'ace-config', 'fXHsssa2', 'ace-config', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_client` VALUES ('12', 'ace-demo-mybatis', 'bZf8yvj9', 'ace-demo-mybatis', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_client` VALUES ('13', 'ace-template', 'bZf8yvj8', 'ace-template', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for auth_client_resouce
-- ----------------------------
DROP TABLE IF EXISTS `auth_client_resouce`;
CREATE TABLE `auth_client_resouce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` varchar(255) DEFAULT NULL COMMENT '这个是提供服务的clientid，也就是本机的clientid',
  `client_id` varchar(255) DEFAULT NULL COMMENT '客户端的id',
  `description` varchar(255) DEFAULT NULL COMMENT '资源描述',
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `crt_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `crt_name` varchar(255) DEFAULT NULL COMMENT '创建人姓名',
  `crt_host` varchar(255) DEFAULT NULL COMMENT '创建人使用主机',
  `upd_time` date DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_client_resouce
-- ----------------------------
INSERT INTO `auth_client_resouce` VALUES ('21', '4', '5', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_client_resouce` VALUES ('23', '6', '6', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `auth_client_resouce` VALUES ('41', '3', '1', null, '2017-12-31 08:58:03', 'null', 'null', 'null', null, null, null, null, null, null, null, null);
INSERT INTO `auth_client_resouce` VALUES ('42', '6', '1', null, '2017-12-31 08:58:03', 'null', 'null', 'null', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for cs_alloction_info
-- ----------------------------
DROP TABLE IF EXISTS `cs_alloction_info`;
CREATE TABLE `cs_alloction_info` (
  `allocate_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(11) DEFAULT NULL COMMENT '用户的id',
  `shop_id` varchar(11) DEFAULT NULL COMMENT '用户的id',
  `cust_id` varchar(11) DEFAULT NULL COMMENT '客服的id',
  `first_reply_time` datetime DEFAULT NULL COMMENT '首次回复的时间',
  `join_way` tinyint(2) DEFAULT NULL COMMENT '用户加入方式',
  `transfer_cust_id` int(11) DEFAULT NULL COMMENT '转接的客服的id',
  `initiating_mode` tinyint(2) DEFAULT '1' COMMENT '发起方式： 1：客户咨询，2.其他客服转接',
  `reply_time_long` int(11) DEFAULT '0' COMMENT '回复的时常((单位是秒)',
  `chat_status` varchar(2) DEFAULT '1' COMMENT '聊天分配的状态，1刚分配，2是聊天中 ，3是聊天结束',
  `chat_duration` int(11) DEFAULT '0' COMMENT '聊天总共的时长（单位分钟）',
  `end_time` datetime DEFAULT NULL,
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间,也是这次回话发起的时间',
  `standby1` varchar(255) DEFAULT NULL,
  `standby2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`allocate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_alloction_info
-- ----------------------------

-- ----------------------------
-- Table structure for cs_cust_joinway_status
-- ----------------------------
DROP TABLE IF EXISTS `cs_cust_joinway_status`;
CREATE TABLE `cs_cust_joinway_status` (
  `cust_join_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_id` int(11) DEFAULT NULL,
  `cust_name` varchar(50) DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL,
  `cust_server_status` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `cust_join_way` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '客服登录方式：PC-电脑端；IOS-苹果手机；',
  `server_user_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `standby1` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `standby2` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `crt_time` timestamp NULL DEFAULT NULL,
  `upd_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cust_join_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_cust_joinway_status
-- ----------------------------

-- ----------------------------
-- Table structure for cs_image
-- ----------------------------
DROP TABLE IF EXISTS `cs_image`;
CREATE TABLE `cs_image` (
  `img_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL COMMENT '图片的路径',
  `size` varchar(40) DEFAULT NULL COMMENT '用来揭露图片的尺寸',
  `title` varchar(255) DEFAULT NULL COMMENT '图片的名称',
  `cust_id` varchar(20) DEFAULT NULL COMMENT '客服的id',
  `user_id` varchar(20) DEFAULT NULL,
  `shop_id` varchar(11) DEFAULT NULL,
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_image
-- ----------------------------

-- ----------------------------
-- Table structure for cs_last_sendtime
-- ----------------------------
DROP TABLE IF EXISTS `cs_last_sendtime`;
CREATE TABLE `cs_last_sendtime` (
  `cust_last_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL COMMENT '店铺的id',
  `has_send` tinyint(2) DEFAULT '1' COMMENT '是否发送过 1：没有，2是有',
  `cust_id` int(11) NOT NULL COMMENT '客服的id',
  `cust_last_time` datetime DEFAULT NULL COMMENT '最后一次发送时间',
  `crt_time` datetime DEFAULT NULL,
  `upd_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `standby1` varchar(255) DEFAULT NULL,
  `standby2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_last_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_last_sendtime
-- ----------------------------

-- ----------------------------
-- Table structure for cs_message
-- ----------------------------
DROP TABLE IF EXISTS `cs_message`;
CREATE TABLE `cs_message` (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `room_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT 'roomid',
  `shop_id` int(10) NOT NULL COMMENT '商户id',
  `cust_id` int(10) DEFAULT NULL COMMENT '客服id',
  `user_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '用户id',
  `user_name` varchar(128) DEFAULT NULL COMMENT '用户名称',
  `shop_name` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `cust_name` varchar(128) DEFAULT NULL COMMENT '客服名称',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `message_content` text COMMENT '消息',
  `msg_type` tinyint(2) DEFAULT '1' COMMENT '消息类型: 1文本类型消息；2图片类型消息；3语音类型消息;',
  `join_way` tinyint(2) DEFAULT '1' COMMENT '接入方式；1-weixin微信；2-phone手机',
  `send_way` tinyint(2) DEFAULT '1' COMMENT '发送方式；1-userway用户发送；2-custway客服发送（用于聊天界面左右消息显示）',
  `headurl` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备用字段1',
  `standby2` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '备用字段2',
  `product_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `product_imgurl` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `product_price` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `shopId_userId` (`shop_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_message
-- ----------------------------

-- ----------------------------
-- Table structure for cs_quick_message
-- ----------------------------
DROP TABLE IF EXISTS `cs_quick_message`;
CREATE TABLE `cs_quick_message` (
  `quick_mes_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '快捷回复id',
  `shop_id` int(10) NOT NULL COMMENT '商户id',
  `cust_id` int(10) NOT NULL COMMENT '客服id',
  `type` tinyint(2) DEFAULT '1' COMMENT '表示快捷消息的类型： 1表示快捷回复 2.表示刚接入时候的消息',
  `mes_content` text CHARACTER SET utf8mb4 NOT NULL COMMENT '快捷回复消息',
  `status` int(1) DEFAULT '1' COMMENT '快捷回复是否删除：1--正常，2--删除',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `standby1` varchar(10) DEFAULT NULL COMMENT '备用字段1',
  `standby2` varchar(10) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`quick_mes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_quick_message
-- ----------------------------

-- ----------------------------
-- Table structure for cs_shop_customer
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_customer`;
CREATE TABLE `cs_shop_customer` (
  `cust_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cust_name` varchar(50) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '客服名称',
  `shop_id` int(11) NOT NULL COMMENT '商户id',
  `cust_online_status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '服务状态（1在线online、2离开leave、3忙碌busy,4offline离线）',
  `max_receive_num` int(5) NOT NULL DEFAULT '5' COMMENT '最大接待数量数量（5、10、15）',
  `cur_receive_num` int(5) NOT NULL DEFAULT '0' COMMENT '当前接待的用户量',
  `cur_receive_user_id` tinyint(11) DEFAULT NULL COMMENT '当前接待的用户量',
  `header` tinyint(3) DEFAULT '1' COMMENT '判断是否老大  1是，2不是',
  `push_info` tinyint(2) DEFAULT '1' COMMENT '是否推送消息： 1是推送，2是关闭',
  `shop_name` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '店铺名称',
  `login_equip` tinyint(2) DEFAULT '1' COMMENT '登陆设备：1.pc 2是安卓  3是ios',
  `headurl` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '头像地址',
  `auto_reply` tinyint(2) DEFAULT '1' COMMENT '自动回复，默认1是开启，2是关闭',
  `upd_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `standby2` varchar(10) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`cust_id`),
  KEY `cust_id` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_shop_customer
-- ----------------------------

-- ----------------------------
-- Table structure for cs_statistics_info
-- ----------------------------
DROP TABLE IF EXISTS `cs_statistics_info`;
CREATE TABLE `cs_statistics_info` (
  `statistic_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '信息的id',
  `shop_id` varchar(11) DEFAULT NULL COMMENT '店铺的id',
  `cust_id` varchar(11) DEFAULT NULL COMMENT '客服的custid',
  `receive_num` int(11) DEFAULT '0' COMMENT '客服的接待人数，算是分配的人数',
  `online_long` int(11) DEFAULT '0' COMMENT '在线的时间（单位是分钟）',
  `transfer_num` int(11) DEFAULT '0' COMMENT '转接的数量',
  `reply_num` int(11) DEFAULT '0' COMMENT '回复的用户的数量',
  `upd_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `crt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `login_time` datetime DEFAULT NULL COMMENT '这一次登陆的时间',
  `standby1` varchar(255) DEFAULT NULL,
  `standby2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`statistic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_statistics_info
-- ----------------------------
INSERT INTO `cs_statistics_info` VALUES ('1', '1', '1', '1', '1', '1', '1', '2018-11-29 10:49:51', '2018-11-29 10:49:43', '2018-11-29 10:49:49', null, null);

-- ----------------------------
-- Table structure for cs_user
-- ----------------------------
DROP TABLE IF EXISTS `cs_user`;
CREATE TABLE `cs_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `other_user_id` tinyint(11) DEFAULT NULL,
  `openid` varchar(60) CHARACTER SET utf8 DEFAULT NULL COMMENT '这个是微信的id',
  `head_img_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像的地址',
  `country` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `city` varchar(60) CHARACTER SET utf8 DEFAULT NULL,
  `province` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `nickname` varchar(60) DEFAULT NULL COMMENT '匿名',
  `union_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '绑定的公众号的id',
  `true_name` varchar(50) DEFAULT NULL COMMENT '真实的姓名',
  `phone_num` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '号码',
  `join_way` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '加入方式:1weixin,2small,3phone',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `weiuserid` (`other_user_id`,`join_way`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_user
-- ----------------------------

-- ----------------------------
-- Table structure for gate_log
-- ----------------------------
DROP TABLE IF EXISTS `gate_log`;
CREATE TABLE `gate_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `menu` varchar(255) DEFAULT NULL COMMENT '菜单',
  `opt` varchar(255) DEFAULT NULL COMMENT '操作',
  `uri` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `crt_time` datetime DEFAULT NULL COMMENT '操作时间',
  `crt_user` varchar(255) DEFAULT NULL COMMENT '操作人ID',
  `crt_name` varchar(255) DEFAULT NULL COMMENT '操作人',
  `crt_host` varchar(255) DEFAULT NULL COMMENT '操作主机',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gate_log
-- ----------------------------
INSERT INTO `gate_log` VALUES ('1', '菜单管理', '新增', '/admin/menu', '2018-02-25 09:36:35', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('2', '菜单管理', '新增', '/admin/menu', '2018-02-25 09:37:04', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('3', '菜单管理', '新增', '/admin/menu', '2018-02-25 09:37:04', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('4', '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:37:20', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('5', '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:37:32', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('6', '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:37:35', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('7', '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:37:40', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('8', '菜单管理', '新增', '/admin/menu', '2018-02-25 09:38:04', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('9', '角色权限管理', '新增', '/admin/group', '2018-02-25 09:38:21', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('10', '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:38:55', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('11', '用户管理', '编辑', '/admin/user', '2018-03-06 11:26:28', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('12', '用户管理', '编辑', '/admin/user', '2018-03-06 11:26:34', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES ('13', '用户管理', '编辑', '/admin/user', '2018-03-07 11:21:10', '1', 'Mr.AG', '127.0.0.1');

-- ----------------------------
-- Table structure for zipkin_annotations
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_annotations`;
CREATE TABLE `zipkin_annotations` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int(11) NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint(20) DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int(11) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint(6) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_annotations
-- ----------------------------

-- ----------------------------
-- Table structure for zipkin_dependencies
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_dependencies`;
CREATE TABLE `zipkin_dependencies` (
  `day` date NOT NULL,
  `parent` varchar(255) NOT NULL,
  `child` varchar(255) NOT NULL,
  `call_count` bigint(20) DEFAULT NULL,
  `error_count` bigint(20) DEFAULT NULL,
  UNIQUE KEY `day` (`day`,`parent`,`child`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_dependencies
-- ----------------------------

-- ----------------------------
-- Table structure for zipkin_spans
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_spans`;
CREATE TABLE `zipkin_spans` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `debug` bit(1) DEFAULT NULL,
  `start_ts` bigint(20) DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint(20) DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts` (`start_ts`) COMMENT 'for getTraces ordering and range'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_spans
-- ----------------------------
