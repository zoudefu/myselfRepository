/*
Navicat MySQL Data Transfer

Source Server         : 10.100.102.19
Source Server Version : 50619
Source Host           : 10.100.102.19:3306
Source Database       : ydfr

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2018-12-24 14:03:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_department_id
-- ----------------------------
DROP TABLE IF EXISTS `t_department_id`;
CREATE TABLE `t_department_id` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父部门id',
  `department_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `enable` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_right_td
-- ----------------------------
DROP TABLE IF EXISTS `t_right_td`;
CREATE TABLE `t_right_td` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父级角色id',
  `right_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `enable` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role_right_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_right_relation`;
CREATE TABLE `t_role_right_relation` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色id',
  `right_id` varchar(32) DEFAULT NULL COMMENT '权限id',
  `right_type` int(1) DEFAULT NULL COMMENT '权限类型（0：可以访问，1可授权）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `enable` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role_td
-- ----------------------------
DROP TABLE IF EXISTS `t_role_td`;
CREATE TABLE `t_role_td` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父级角色id',
  `role_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `enable` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role_relation`;
CREATE TABLE `t_user_role_relation` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updae_time` datetime DEFAULT NULL COMMENT '更新时间',
  `enable` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_td
-- ----------------------------
DROP TABLE IF EXISTS `t_user_td`;
CREATE TABLE `t_user_td` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户名',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登陆账号',
  `password` varchar(32) DEFAULT '' COMMENT '密码',
  `department_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  `email` varchar(64) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `enabled` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
