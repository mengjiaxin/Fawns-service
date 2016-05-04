/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : qmp

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2014-05-15 21:31:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `sys_control`
-- ----------------------------
DROP TABLE IF EXISTS `sys_control`;
CREATE TABLE `sys_control` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `control_id` varchar(200) NOT NULL,
  `resource_id` varchar(100) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_control
-- ----------------------------
INSERT INTO `sys_control` VALUES ('21', 'Role:Add', 'Role', '添加', '1', '添加', '1', '2014-01-08 17:25:49', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('22', 'Role:Delete', 'Role', '删除', '1', '删除', '1', '2014-01-08 17:26:02', 'admin', '2014-01-09 13:45:27', 'admin');
INSERT INTO `sys_control` VALUES ('23', 'Role:Update', 'Role', '修改', '1', '修改', '1', '2014-01-08 17:26:14', 'admin', '2014-01-09 13:45:34', 'admin');
INSERT INTO `sys_control` VALUES ('24', 'Role:Query', 'Role', '搜索', '1', '搜索', '1', '2014-01-08 17:26:35', 'admin', '2014-01-23 17:12:59', 'admin');
INSERT INTO `sys_control` VALUES ('25', 'User:Add', 'User', '添加', '1', '添加', '1', '2014-01-08 17:26:54', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('26', 'User:Delete', 'User', '删除', '1', '删除', '1', '2014-01-08 17:27:05', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('27', 'User:Update', 'User', '修改', '1', '修改', '1', '2014-01-08 17:27:18', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('28', 'User:Query', 'User', '搜索', '1', '搜索', '1', '2014-01-08 17:27:32', 'admin', '2014-01-23 17:13:09', 'admin');
INSERT INTO `sys_control` VALUES ('33', 'Department:Add', 'Department', '添加', '1', '添加', '1', '2014-01-15 21:31:11', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('34', 'Department:Delete', 'Department', '删除', '1', '删除', '1', '2014-01-15 21:31:24', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('35', 'Department:Update', 'Department', '修改', '1', '修改', '1', '2014-01-15 21:31:33', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('36', 'Department:Query', 'Department', '搜索', '1', '搜索', '1', '2014-01-15 21:31:52', 'admin', '2014-03-06 12:47:29', 'admin');
INSERT INTO `sys_control` VALUES ('37', 'Dictionary:Add', 'Dictionary', '添加', '1', '添加', '1', '2014-01-15 21:32:17', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('38', 'Dictionary:Delete', 'Dictionary', '删除', '1', '删除', '1', '2014-01-15 21:32:30', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('39', 'Dictionary:Update', 'Dictionary', '修改', '1', '修改', '1', '2014-01-15 21:32:45', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('40', 'Dictionary:Query', 'Dictionary', '搜索', '1', '搜索', '1', '2014-01-15 21:32:59', 'admin', '2014-01-23 17:13:50', 'admin');
INSERT INTO `sys_control` VALUES ('48', 'Dictionary:Refresh', 'Dictionary', '刷新字典', '1', '刷新字典', '1', '2014-01-16 17:20:16', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('72', 'User:ResetPwd', 'User', '密码重置', '1', '密码重置', '1', '2014-02-12 20:56:25', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('73', 'Role:View', 'Role', '查看', '1', '查看', '1', '2014-03-07 17:43:42', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('74', 'User:View', 'User', '查看', '1', '查看', '1', '2014-03-07 17:44:03', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('75', 'Department:View', 'Department', '查看', '1', '查看', '1', '2014-03-07 20:22:27', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('77', 'Dictionary:View', 'Dictionary', '查看', '1', '查看', '1', '2014-03-07 20:23:09', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('93', 'KitchenerMgr:Query', 'KitchenerMgr', '查询', '1', '查询', '1', '2014-04-14 22:56:05', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('94', 'KitchenerMgr:Add', 'KitchenerMgr', '添加', '1', '添加', '1', '2014-04-14 22:56:14', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('95', 'KitchenerMgr:Update', 'KitchenerMgr', '修改', '1', '修改', '1', '2014-04-14 22:56:32', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('96', 'KitchenerMgr:Delete', 'KitchenerMgr', '删除', '1', '删除', '1', '2014-04-14 22:56:45', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('97', 'KitchenerMgr:View', 'KitchenerMgr', '查看', '1', '查看', '1', '2014-04-14 22:56:55', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('98', 'DishMgr:Query', 'DishMgr', '查询', '1', '查询', '1', '2014-04-14 22:57:16', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('99', 'DishMgr:Add', 'DishMgr', '添加', '1', '添加', '1', '2014-04-14 22:57:26', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('100', 'DishMgr:Update', 'DishMgr', '修改', '1', '修改', '1', '2014-04-14 22:57:34', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('101', 'DishMgr:Delete', 'DishMgr', '删除', '1', '删除', '1', '2014-04-14 22:57:45', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('102', 'DishMgr:View', 'DishMgr', '查看', '1', '查看', '1', '2014-04-14 22:57:53', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('103', 'CookbookMgr:Query', 'CookbookMgr', '查询', '1', '查询', '1', '2014-04-14 22:58:07', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('104', 'CookbookMgr:Add', 'CookbookMgr', '添加', '1', '添加', '1', '2014-04-14 22:58:17', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('105', 'CookbookMgr:Update', 'CookbookMgr', '修改', '1', '修改', '1', '2014-04-14 22:58:27', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('106', 'CookbookMgr:Delete', 'CookbookMgr', '删除', '1', '删除', '1', '2014-04-14 22:58:38', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('107', 'CookbookMgr:View', 'CookbookMgr', '查看', '1', '查看', '1', '2014-04-14 22:58:49', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('109', 'DishMgr:ChangeStatus', 'DishMgr', '设置/取消优秀菜品', '1', '设置/取消优秀菜品', '1', '2014-04-15 23:06:29', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('110', 'KitchenerMgr:ChangeState', 'KitchenerMgr', '设置/取消优秀厨师', '1', '设置/取消优秀厨师', '1', '2014-04-15 23:18:41', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('111', 'PurchasePlanMgr:Query', 'PurchasePlanMgr', '查询', '1', '查询', '1', '2014-04-16 00:25:45', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('112', 'PurchasePlanMgr:Add', 'PurchasePlanMgr', '添加', '1', '添加', '1', '2014-04-16 00:25:54', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('113', 'PurchasePlanMgr:Update', 'PurchasePlanMgr', '修改', '1', '修改', '1', '2014-04-16 00:26:02', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('114', 'PurchasePlanMgr:Delete', 'PurchasePlanMgr', '删除', '1', '删除', '1', '2014-04-16 00:26:20', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('115', 'PurchasePlanMgr:View', 'PurchasePlanMgr', '查看', '1', '查看', '1', '2014-04-16 00:26:31', 'admin', null, null);
INSERT INTO `sys_control` VALUES ('116', 'NoticeMgr:Edit', 'NoticeMgr', '修改', '1', '修改', '1', '2014-04-16 23:34:29', 'admin', null, null);

-- ----------------------------
-- Table structure for `sys_department`
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `departmentid` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `supdepid` varchar(30) NOT NULL,
  `manager` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `mgrphone` varchar(20) DEFAULT NULL,
  `isend` varchar(1) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `createoperid` varchar(30) DEFAULT NULL,
  `updateoperid` varchar(30) DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES ('4101', '8645部队', '41', 'admin', '中国北京', '13252513352', '22322222', '1', '8645部队', '2013-12-26 10:31:38', null, null, null);
INSERT INTO `sys_department` VALUES ('410101', '测试一部', '4101', '测试一部a', '测试一部a', '测试一部a', '测试一部a', '1', '测试一部a', '2013-12-30 14:17:46', 'admin', 'admin', '2014-03-07 23:29:58');
INSERT INTO `sys_department` VALUES ('41010101', '测试一部—1', '410101', '测试一部—1', '测试一部—1', '333', '333', null, '测试一部—1', '2013-12-30 14:21:30', 'admin', 'admin', '2014-03-08 14:08:27');
INSERT INTO `sys_department` VALUES ('41010102', '测试一部—2', '410101', '测试一部—2', '测试一部—2', '4343242', '43434', '1', '测试一部—2', '2013-12-30 14:21:50', 'admin', 'admin', '2014-03-05 21:40:29');
INSERT INTO `sys_department` VALUES ('4101010201', '测试一部—2-1', '41010102', '测试一部—2-1', '测试一部—2-1', '432432', '4234', '1', '测试一部—2-1', '2013-12-30 14:23:07', 'admin', 'admin', '2014-03-05 16:39:06');
INSERT INTO `sys_department` VALUES ('410102', '测试二部', '4101', '测试二部', '测试二部', '测试二部', '测试二部', '1', '测试二部', '2013-12-30 14:20:35', 'admin', 'admin', '2014-03-05 16:49:38');
INSERT INTO `sys_department` VALUES ('41010201', '测试二部-1', '410102', '测试二部-1', '测试二部-1', '42342', '4234234', null, '测试二部-1', '2013-12-30 14:22:08', 'admin', null, null);
INSERT INTO `sys_department` VALUES ('41010202', '测试二部-2', '410102', '测试二部-2', '测试二部-2', '42423', '43242', null, '测试二部-2', '2013-12-30 14:22:20', 'admin', null, null);
INSERT INTO `sys_department` VALUES ('410103', '测试三部', '4101', '测试三部', '测试三部', '测试三部', '测试三部', '1', '测试三部', '2013-12-30 14:20:47', 'admin', null, null);
INSERT INTO `sys_department` VALUES ('41010301', '测试三部-1', '410103', '测试三部-1', '测试三部-1', '24242', '4234234', null, '测试三部-1', '2013-12-30 14:22:39', 'admin', 'admin', '2014-03-07 22:39:30');

-- ----------------------------
-- Table structure for `sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` varchar(32) NOT NULL,
  `dictionary_type` varchar(50) NOT NULL,
  `dictionary_code` varchar(10) NOT NULL,
  `status` varchar(2) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `sort` bigint(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('1', '1', '0', '1', '顶级字典', '顶级字典', '0', '1', null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('8ae400ab422be25d01422be430a60003', 'SOURCE_TITLE', '400', '1', '来源', '来源', '1', '0', null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('8ae400ab422be25d01422be4afd60004', 'SOURCE', '401', '1', '菜市场', '51job', '8ae400ab422be25d01422be430a60003', '1', null, null, '2014-04-17 22:32:01', 'admin');
INSERT INTO `sys_dictionary` VALUES ('8ae400ab422be25d01422be5163e0005', 'SOURCE', '402', '1', '批发市场', '智联招聘', '8ae400ab422be25d01422be430a60003', '2', null, null, '2014-04-17 22:32:14', 'admin');
INSERT INTO `sys_dictionary` VALUES ('8ae400ab422c4b0601422c505db60004', 'POSITION', '701', '1', '司令', '司令', '8ae4030e439f642601439f6426600000', '1', null, null, '2014-04-17 22:32:59', 'admin');
INSERT INTO `sys_dictionary` VALUES ('8ae400ab422c4b0601422c50c30c0005', 'POSITION', '702', '1', '军长', '军长', '8ae4030e439f642601439f6426600000', '2', null, null, '2014-04-17 22:33:11', 'admin');
INSERT INTO `sys_dictionary` VALUES ('8ae400ab422c4b0601422c5109ba0006', 'POSITION', '703', '1', '厨师长', '厨师长', '8ae4030e439f642601439f6426600000', '3', null, null, '2014-04-17 22:33:21', 'admin');
INSERT INTO `sys_dictionary` VALUES ('8ae4030e439f642601439f6426600000', 'POSITION_TITLE', '700', '1', '职位', '董事长', '1', '0', '2014-01-17 16:49:37', 'admin', '2014-04-16 00:38:18', 'admin');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `oper_id` varchar(30) NOT NULL,
  `oper_ip` varchar(30) NOT NULL,
  `oper_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `oper_type` varchar(1) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `department_id` varchar(30) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1047 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('656', 'admin', '127.0.0.1', '2014-03-07 23:29:46', '2', '超级管理员在2014-03-07 23:29:46成功修改了[普通用户组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('657', 'admin', '127.0.0.1', '2014-03-07 23:29:52', '2', '超级管理员在2014-03-07 23:29:52成功修改了[admin-超级管理员]的用户信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('658', 'admin', '127.0.0.1', '2014-03-07 23:29:58', '2', '超级管理员在2014-03-07 23:29:58成功修改了[测试一部]的部门信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('659', 'admin', '127.0.0.1', '2014-03-07 23:30:05', '2', '超级管理员在2014-03-07 23:30:05成功修改了[候选人列表]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('660', 'admin', '127.0.0.1', '2014-03-07 23:30:28', '2', '超级管理员在2014-03-07 23:30:28成功修改了[CandidateList-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('661', 'admin', '127.0.0.1', '2014-03-07 23:30:34', '2', '超级管理员在2014-03-07 23:30:34成功修改了[院校]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('662', 'admin', '127.0.0.1', '2014-03-07 23:31:22', '2', '超级管理员在2014-03-07 23:31:22成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('663', 'admin', '127.0.0.1', '2014-03-07 23:36:38', '2', '超级管理员在2014-03-07 23:36:38成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('664', 'admin', '127.0.0.1', '2014-03-08 00:00:53', '2', '超级管理员在2014-03-08 00:00:53成功修改了[ResumeRep-搜索]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('665', 'admin', '127.0.0.1', '2014-03-08 14:08:27', '2', '超级管理员在2014-03-08 14:08:27成功修改了[测试一部—1]的部门信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('666', 'admin', '127.0.0.1', '2014-03-08 14:09:33', '2', '超级管理员在2014-03-08 14:09:33成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('667', 'admin', '127.0.0.1', '2014-03-08 15:19:22', '2', '超级管理员在2014-03-08 15:19:22成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('668', 'admin', '127.0.0.1', '2014-03-08 15:40:26', '2', '超级管理员在2014-03-08 15:40:26成功添加了[aa]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('669', 'admin', '127.0.0.1', '2014-03-08 15:40:37', '2', '超级管理员在2014-03-08 15:40:37成功添加了[bb]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('670', 'admin', '127.0.0.1', '2014-03-08 15:40:50', '2', '超级管理员在2014-03-08 15:40:50成功添加了[cc]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('671', 'admin', '127.0.0.1', '2014-03-08 15:41:19', '2', '超级管理员在2014-03-08 15:41:19成功添加了[dd]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('672', 'admin', '127.0.0.1', '2014-03-08 15:41:30', '2', '超级管理员在2014-03-08 15:41:30成功添加了[ee]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('673', 'admin', '127.0.0.1', '2014-03-08 15:41:42', '2', '超级管理员在2014-03-08 15:41:42成功添加了[ff]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('674', 'admin', '127.0.0.1', '2014-03-08 15:42:09', '2', '超级管理员在2014-03-08 15:42:09成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('675', 'admin', '127.0.0.1', '2014-03-08 15:45:49', '2', '超级管理员在2014-03-08 15:45:49成功删除了资源ID为[aa]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('676', 'admin', '127.0.0.1', '2014-03-08 15:45:53', '2', '超级管理员在2014-03-08 15:45:53成功删除了资源ID为[bb]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('677', 'admin', '127.0.0.1', '2014-03-08 15:45:57', '2', '超级管理员在2014-03-08 15:45:57成功删除了资源ID为[cc]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('678', 'admin', '127.0.0.1', '2014-03-08 15:46:02', '2', '超级管理员在2014-03-08 15:46:02成功删除了资源ID为[dd]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('679', 'admin', '127.0.0.1', '2014-03-08 15:46:06', '2', '超级管理员在2014-03-08 15:46:06成功删除了资源ID为[ee]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('680', 'admin', '127.0.0.1', '2014-03-08 15:46:11', '2', '超级管理员在2014-03-08 15:46:11成功删除了资源ID为[ff]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('681', 'admin', '127.0.0.1', '2014-03-08 16:00:34', '2', '超级管理员在2014-03-08 16:00:34成功添加了[aa]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('682', 'admin', '127.0.0.1', '2014-03-08 16:00:43', '2', '超级管理员在2014-03-08 16:00:43成功添加了[bb]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('683', 'admin', '127.0.0.1', '2014-03-08 16:00:52', '2', '超级管理员在2014-03-08 16:00:52成功添加了[cc]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('684', 'admin', '127.0.0.1', '2014-03-08 16:01:04', '2', '超级管理员在2014-03-08 16:01:04成功添加了[dd]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('685', 'admin', '127.0.0.1', '2014-03-08 16:01:16', '2', '超级管理员在2014-03-08 16:01:16成功添加了[ee]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('686', 'admin', '127.0.0.1', '2014-03-08 16:01:26', '2', '超级管理员在2014-03-08 16:01:26成功添加了[ff]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('687', 'admin', '127.0.0.1', '2014-03-08 16:01:37', '2', '超级管理员在2014-03-08 16:01:37成功添加了[gg]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('688', 'admin', '127.0.0.1', '2014-03-08 16:01:50', '2', '超级管理员在2014-03-08 16:01:50成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('689', 'admin', '127.0.0.1', '2014-03-08 16:24:45', '2', '超级管理员在2014-03-08 16:24:45成功添加了[qq]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('690', 'admin', '127.0.0.1', '2014-03-08 16:24:55', '2', '超级管理员在2014-03-08 16:24:55成功添加了[ww]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('691', 'admin', '127.0.0.1', '2014-03-08 16:25:24', '2', '超级管理员在2014-03-08 16:25:24成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('692', 'admin', '127.0.0.1', '2014-03-08 16:32:52', '2', '超级管理员在2014-03-08 16:32:52成功删除了资源ID为[aa]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('693', 'admin', '127.0.0.1', '2014-03-08 16:32:57', '2', '超级管理员在2014-03-08 16:32:57成功删除了资源ID为[bb]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('694', 'admin', '127.0.0.1', '2014-03-08 16:33:00', '2', '超级管理员在2014-03-08 16:33:00成功删除了资源ID为[cc]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('695', 'admin', '127.0.0.1', '2014-03-08 16:33:03', '2', '超级管理员在2014-03-08 16:33:03成功删除了资源ID为[dd]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('696', 'admin', '127.0.0.1', '2014-03-08 16:33:09', '2', '超级管理员在2014-03-08 16:33:09成功删除了资源ID为[ee]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('697', 'admin', '127.0.0.1', '2014-03-08 16:33:12', '2', '超级管理员在2014-03-08 16:33:12成功删除了资源ID为[ff]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('698', 'admin', '127.0.0.1', '2014-03-08 16:33:16', '2', '超级管理员在2014-03-08 16:33:16成功删除了资源ID为[gg]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('699', 'admin', '127.0.0.1', '2014-03-08 16:33:19', '2', '超级管理员在2014-03-08 16:33:19成功删除了资源ID为[Log]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('700', 'admin', '127.0.0.1', '2014-03-08 16:33:33', '2', '超级管理员在2014-03-08 16:33:33成功删除了资源ID为[qq]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('701', 'admin', '127.0.0.1', '2014-03-08 16:33:38', '2', '超级管理员在2014-03-08 16:33:38成功删除了资源ID为[ww]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('702', 'admin', '127.0.0.1', '2014-03-08 16:34:54', '2', '超级管理员在2014-03-08 16:34:54成功添加了[日志管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('703', 'admin', '127.0.0.1', '2014-03-08 16:37:36', '2', '超级管理员在2014-03-08 16:37:36成功添加了[Log-搜索]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('704', 'admin', '127.0.0.1', '2014-03-08 16:38:23', '2', '超级管理员在2014-03-08 16:38:23成功添加了[Log-日志清理]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('705', 'admin', '127.0.0.1', '2014-03-08 16:38:57', '2', '超级管理员在2014-03-08 16:38:57成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('706', 'admin', '127.0.0.1', '2014-03-08 16:39:14', '2', '超级管理员在2014-03-08 16:39:14成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('707', 'admin', '127.0.0.1', '2014-03-08 16:40:15', '2', '超级管理员在2014-03-08 16:40:15成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('708', 'admin', '127.0.0.1', '2014-03-08 16:51:16', '2', '超级管理员在2014-03-08 16:51:16成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('709', 'admin', '127.0.0.1', '2014-03-08 16:53:34', '2', '超级管理员在2014-03-08 16:53:34成功删除了[Log-79]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('710', 'admin', '127.0.0.1', '2014-03-08 16:54:08', '2', '超级管理员在2014-03-08 16:54:08成功添加了[Log-日志清理]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('711', 'admin', '127.0.0.1', '2014-03-08 16:54:18', '2', '超级管理员在2014-03-08 16:54:18成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('712', 'admin', '127.0.0.1', '2014-03-08 17:41:02', '2', '超级管理员在2014-03-08 17:41:02成功添加了[test]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('713', 'admin', '127.0.0.1', '2014-03-08 17:41:17', '2', '超级管理员在2014-03-08 17:41:17成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('714', 'admin', '127.0.0.1', '2014-03-08 17:41:50', '2', '超级管理员在2014-03-08 17:41:50成功删除了资源ID为[test]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('715', 'admin', '127.0.0.1', '2014-03-08 17:42:08', '2', '超级管理员在2014-03-08 17:42:08成功修改了[角色管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('716', 'admin', '127.0.0.1', '2014-03-08 17:59:55', '2', '超级管理员在2014-03-08 17:59:55成功删除了资源ID为[EmployeeList]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('717', 'admin', '127.0.0.1', '2014-03-08 18:00:01', '2', '超级管理员在2014-03-08 18:00:01成功删除了资源ID为[EmployeeMgr]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('718', 'admin', '127.0.0.1', '2014-03-08 18:01:46', '2', '超级管理员在2014-03-08 18:01:46成功添加了[库存管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('719', 'admin', '127.0.0.1', '2014-03-08 18:44:20', '2', '超级管理员在2014-03-08 18:44:20添加[库存管理]的资源信息时失败！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('720', 'admin', '127.0.0.1', '2014-03-08 18:44:58', '2', '超级管理员在2014-03-08 18:44:58成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('721', 'admin', '127.0.0.1', '2014-03-08 18:46:50', '2', '超级管理员在2014-03-08 18:46:50成功添加了[仓库管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('722', 'admin', '127.0.0.1', '2014-03-08 18:47:11', '2', '超级管理员在2014-03-08 18:47:11成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('723', 'admin', '127.0.0.1', '2014-03-09 15:04:42', '2', '超级管理员在2014-03-09 15:04:42添加[测试]的仓库信息时失败！', '4101', '业务护日志');
INSERT INTO `sys_log` VALUES ('724', 'admin', '127.0.0.1', '2014-03-09 15:08:18', '1', '超级管理员在2014-03-09 15:08:18成功添加了[test]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('725', 'admin', '127.0.0.1', '2014-03-09 15:43:21', '1', '超级管理员在2014-03-09 15:43:21删除[1]的仓库信息时失败！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('726', 'admin', '127.0.0.1', '2014-03-09 15:45:14', '1', '超级管理员在2014-03-09 15:45:14删除[1]的仓库信息时失败！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('727', 'admin', '127.0.0.1', '2014-03-09 15:46:53', '1', '超级管理员在2014-03-09 15:46:53删除[1]的仓库信息时失败！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('728', 'admin', '127.0.0.1', '2014-03-09 15:48:54', '1', '超级管理员在2014-03-09 15:48:54成功删除了[1]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('729', 'admin', '127.0.0.1', '2014-03-09 15:50:05', '1', '超级管理员在2014-03-09 15:50:05成功添加了[一号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('730', 'admin', '127.0.0.1', '2014-03-09 15:55:47', '1', '超级管理员在2014-03-09 15:55:47成功删除了[2]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('731', 'admin', '127.0.0.1', '2014-03-09 15:56:33', '1', '超级管理员在2014-03-09 15:56:33成功添加了[一号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('732', 'admin', '127.0.0.1', '2014-03-09 15:57:25', '1', '超级管理员在2014-03-09 15:57:25成功添加了[仓库二号]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('733', 'admin', '127.0.0.1', '2014-03-09 15:57:47', '1', '超级管理员在2014-03-09 15:57:47成功添加了[三号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('734', 'admin', '127.0.0.1', '2014-03-09 17:05:44', '1', '超级管理员在2014-03-09 17:05:44成功修改了[仓库二号]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('735', 'admin', '127.0.0.1', '2014-03-09 17:08:16', '1', '超级管理员在2014-03-09 17:08:16成功修改了[二号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('736', 'admin', '127.0.0.1', '2014-03-09 17:08:24', '1', '超级管理员在2014-03-09 17:08:24成功修改了[二号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('737', 'admin', '127.0.0.1', '2014-03-09 17:09:00', '1', '超级管理员在2014-03-09 17:09:00成功添加了[四号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('738', 'admin', '127.0.0.1', '2014-03-09 17:09:13', '1', '超级管理员在2014-03-09 17:09:13成功添加了[五号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('739', 'admin', '127.0.0.1', '2014-03-09 17:09:52', '1', '超级管理员在2014-03-09 17:09:52成功添加了[六号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('740', 'admin', '127.0.0.1', '2014-03-09 17:10:03', '1', '超级管理员在2014-03-09 17:10:03成功添加了[七号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('741', 'admin', '127.0.0.1', '2014-03-09 17:10:13', '1', '超级管理员在2014-03-09 17:10:13成功添加了[八号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('742', 'admin', '127.0.0.1', '2014-03-09 17:10:27', '1', '超级管理员在2014-03-09 17:10:27成功添加了[九号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('743', 'admin', '127.0.0.1', '2014-03-09 17:10:39', '1', '超级管理员在2014-03-09 17:10:39成功添加了[十号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('744', 'admin', '127.0.0.1', '2014-03-09 17:16:54', '1', '超级管理员在2014-03-09 17:16:54成功添加了[十一号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('745', 'admin', '127.0.0.1', '2014-03-09 17:17:11', '1', '超级管理员在2014-03-09 17:17:11成功添加了[十二号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('746', 'admin', '127.0.0.1', '2014-03-09 17:17:26', '1', '超级管理员在2014-03-09 17:17:26成功添加了[十三号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('747', 'admin', '127.0.0.1', '2014-03-09 17:24:37', '1', '超级管理员在2014-03-09 17:24:37成功添加了[十四号仓库]的仓库信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('748', 'admin', '127.0.0.1', '2014-03-09 17:37:37', '2', '超级管理员在2014-03-09 17:37:37成功添加了[WarehouseList-查询]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('749', 'admin', '127.0.0.1', '2014-03-09 17:38:02', '2', '超级管理员在2014-03-09 17:38:02成功添加了[WarehouseList-删除]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('750', 'admin', '127.0.0.1', '2014-03-09 17:38:16', '2', '超级管理员在2014-03-09 17:38:16成功添加了[WarehouseList-修改]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('751', 'admin', '127.0.0.1', '2014-03-09 17:38:31', '2', '超级管理员在2014-03-09 17:38:31成功添加了[WarehouseList-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('752', 'admin', '127.0.0.1', '2014-03-09 17:41:25', '2', '超级管理员在2014-03-09 17:41:25成功添加了[WarehouseList-添加]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('753', 'admin', '127.0.0.1', '2014-03-09 17:41:34', '2', '超级管理员在2014-03-09 17:41:34成功删除了[WarehouseList-81]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('754', 'admin', '127.0.0.1', '2014-03-09 17:44:47', '2', '超级管理员在2014-03-09 17:44:47成功添加了[WarehouseList-搜索]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('755', 'admin', '127.0.0.1', '2014-03-09 17:55:09', '2', '超级管理员在2014-03-09 17:55:09成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('756', 'admin', '127.0.0.1', '2014-03-09 18:33:46', '2', '超级管理员在2014-03-09 18:33:46成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('757', 'admin', '127.0.0.1', '2014-03-09 18:38:31', '2', '超级管理员在2014-03-09 18:38:31成功添加了[库存管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('758', 'admin', '127.0.0.1', '2014-03-09 18:38:49', '2', '超级管理员在2014-03-09 18:38:49成功修改了[库存管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('759', 'admin', '127.0.0.1', '2014-03-09 18:39:49', '2', '超级管理员在2014-03-09 18:39:49成功修改了[货架管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('760', 'admin', '127.0.0.1', '2014-03-09 19:17:39', '2', '超级管理员在2014-03-09 19:17:39成功修改了[WarehouseMgr-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('761', 'admin', '127.0.0.1', '2014-03-09 19:17:45', '2', '超级管理员在2014-03-09 19:17:45成功修改了[WarehouseMgr-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('762', 'admin', '127.0.0.1', '2014-03-09 19:27:43', '2', '超级管理员在2014-03-09 19:27:43成功修改了[货架管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('763', 'admin', '127.0.0.1', '2014-03-09 19:54:45', '2', '超级管理员在2014-03-09 19:54:45成功修改了[货架管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('764', 'admin', '127.0.0.1', '2014-03-09 20:33:58', '2', '超级管理员在2014-03-09 20:33:58成功添加了[ContainerMgr-搜索]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('765', 'admin', '127.0.0.1', '2014-03-09 20:34:11', '2', '超级管理员在2014-03-09 20:34:11成功添加了[ContainerMgr-添加]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('766', 'admin', '127.0.0.1', '2014-03-09 20:34:25', '2', '超级管理员在2014-03-09 20:34:25成功添加了[ContainerMgr-删除]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('767', 'admin', '127.0.0.1', '2014-03-09 20:34:39', '2', '超级管理员在2014-03-09 20:34:39成功添加了[ContainerMgr-修改]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('768', 'admin', '127.0.0.1', '2014-03-09 20:34:55', '2', '超级管理员在2014-03-09 20:34:55成功添加了[ContainerMgr-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('769', 'admin', '127.0.0.1', '2014-03-09 20:35:15', '2', '超级管理员在2014-03-09 20:35:15成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('770', 'admin', '127.0.0.1', '2014-03-09 22:37:51', '1', '超级管理员在2014-03-09 22:37:51成功修改了[二号仓库]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('771', 'admin', '127.0.0.1', '2014-03-09 22:37:56', '1', '超级管理员在2014-03-09 22:37:56成功修改了[二号仓库]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('772', 'admin', '127.0.0.1', '2014-03-09 22:38:17', '1', '超级管理员在2014-03-09 22:38:17成功修改了[二号货架]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('773', 'admin', '127.0.0.1', '2014-03-09 22:38:55', '2', '超级管理员在2014-03-09 22:38:55添加[一号货架1]的货架信息时失败！', '4101', '业务护日志');
INSERT INTO `sys_log` VALUES ('774', 'admin', '127.0.0.1', '2014-03-09 22:43:58', '1', '超级管理员在2014-03-09 22:43:58成功修改了[十三号仓库]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('775', 'admin', '127.0.0.1', '2014-03-09 22:44:05', '1', '超级管理员在2014-03-09 22:44:05成功添加了[te]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('776', 'admin', '127.0.0.1', '2014-03-09 22:44:48', '1', '超级管理员在2014-03-09 22:44:48成功修改了[货架测试1]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('777', 'admin', '127.0.0.1', '2014-03-09 22:44:56', '1', '超级管理员在2014-03-09 22:44:56成功修改了[货架测试1]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('778', 'admin', '127.0.0.1', '2014-03-09 22:47:07', '1', '超级管理员在2014-03-09 22:47:07成功修改了[货架1]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('779', 'admin', '127.0.0.1', '2014-03-09 22:47:19', '1', '超级管理员在2014-03-09 22:47:19成功修改了[货架2]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('780', 'admin', '127.0.0.1', '2014-03-09 22:49:39', '1', '超级管理员在2014-03-09 22:49:39成功修改了[十三号仓库]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('781', 'admin', '127.0.0.1', '2014-03-09 22:49:50', '1', '超级管理员在2014-03-09 22:49:50成功修改了[一号仓库]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('782', 'admin', '127.0.0.1', '2014-03-10 20:48:50', '2', '超级管理员在2014-03-10 20:48:50成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('783', 'admin', '127.0.0.1', '2014-03-10 20:48:53', '2', '超级管理员在2014-03-10 20:48:53成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('784', 'admin', '127.0.0.1', '2014-03-10 20:50:54', '2', '超级管理员在2014-03-10 20:50:54成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('785', 'admin', '127.0.0.1', '2014-03-10 20:51:16', '2', '超级管理员在2014-03-10 20:51:16成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('786', 'admin', '127.0.0.1', '2014-03-10 20:52:30', '2', '超级管理员在2014-03-10 20:52:30成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('787', 'admin', '127.0.0.1', '2014-03-10 20:52:39', '2', '超级管理员在2014-03-10 20:52:39成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('788', 'admin', '127.0.0.1', '2014-03-10 20:52:53', '2', '超级管理员在2014-03-10 20:52:53成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('789', 'admin', '127.0.0.1', '2014-03-10 20:53:42', '2', '超级管理员在2014-03-10 20:53:42成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('790', 'admin', '127.0.0.1', '2014-03-10 20:53:45', '2', '超级管理员在2014-03-10 20:53:45成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('791', 'admin', '127.0.0.1', '2014-03-10 20:53:47', '2', '超级管理员在2014-03-10 20:53:47成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('792', 'admin', '127.0.0.1', '2014-03-10 20:53:50', '2', '超级管理员在2014-03-10 20:53:50成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('793', 'admin', '127.0.0.1', '2014-03-10 20:54:39', '2', '超级管理员在2014-03-10 20:54:39成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('794', 'admin', '127.0.0.1', '2014-03-10 20:55:27', '2', '超级管理员在2014-03-10 20:55:27成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('795', 'admin', '127.0.0.1', '2014-03-10 20:57:35', '2', '超级管理员在2014-03-10 20:57:35成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('796', 'admin', '127.0.0.1', '2014-03-10 20:58:21', '2', '超级管理员在2014-03-10 20:58:21成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('797', 'admin', '127.0.0.1', '2014-03-10 20:58:49', '2', '超级管理员在2014-03-10 20:58:49成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('798', 'admin', '127.0.0.1', '2014-03-10 20:59:32', '2', '超级管理员在2014-03-10 20:59:32成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('799', 'admin', '127.0.0.1', '2014-03-10 21:00:35', '2', '超级管理员在2014-03-10 21:00:35成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('800', 'admin', '127.0.0.1', '2014-03-10 21:02:00', '2', '超级管理员在2014-03-10 21:02:00成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('801', 'admin', '127.0.0.1', '2014-03-10 21:02:04', '2', '超级管理员在2014-03-10 21:02:04成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('802', 'admin', '127.0.0.1', '2014-03-10 21:02:06', '2', '超级管理员在2014-03-10 21:02:06成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('803', 'admin', '127.0.0.1', '2014-03-10 21:02:11', '2', '超级管理员在2014-03-10 21:02:11成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('804', 'admin', '127.0.0.1', '2014-03-10 21:02:15', '2', '超级管理员在2014-03-10 21:02:15成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('805', 'admin', '127.0.0.1', '2014-03-10 21:03:15', '2', '超级管理员在2014-03-10 21:03:15成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('806', 'admin', '127.0.0.1', '2014-03-10 21:03:38', '2', '超级管理员在2014-03-10 21:03:38成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('807', 'admin', '127.0.0.1', '2014-03-10 21:13:04', '2', '超级管理员在2014-03-10 21:13:04成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('808', 'admin', '127.0.0.1', '2014-03-10 21:13:13', '2', '超级管理员在2014-03-10 21:13:13成功修改了[院校]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('809', 'admin', '127.0.0.1', '2014-03-10 21:13:32', '2', '超级管理员在2014-03-10 21:13:32成功修改了[领导组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('810', 'admin', '127.0.0.1', '2014-03-10 21:13:55', '1', '超级管理员在2014-03-10 21:13:55成功修改了[货架1]的货架信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('811', 'admin', '127.0.0.1', '2014-04-14 22:48:03', '2', '超级管理员在2014-04-14 22:48:03成功删除了资源ID为[ContainerMgr]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('812', 'admin', '127.0.0.1', '2014-04-14 22:48:07', '2', '超级管理员在2014-04-14 22:48:07成功删除了资源ID为[WarehouseMgr]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('813', 'admin', '127.0.0.1', '2014-04-14 22:48:10', '2', '超级管理员在2014-04-14 22:48:10成功删除了资源ID为[StockMgr]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('814', 'admin', '127.0.0.1', '2014-04-14 22:48:16', '2', '超级管理员在2014-04-14 22:48:16成功删除了资源ID为[RecommendCaseRep]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('815', 'admin', '127.0.0.1', '2014-04-14 22:48:19', '2', '超级管理员在2014-04-14 22:48:19成功删除了资源ID为[CandidateRep]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('816', 'admin', '127.0.0.1', '2014-04-14 22:48:22', '2', '超级管理员在2014-04-14 22:48:22成功删除了资源ID为[ResumeRep]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('817', 'admin', '127.0.0.1', '2014-04-14 22:48:24', '2', '超级管理员在2014-04-14 22:48:24成功删除了资源ID为[ReportCount]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('818', 'admin', '127.0.0.1', '2014-04-14 22:48:30', '2', '超级管理员在2014-04-14 22:48:30成功删除了资源ID为[CandidateList]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('819', 'admin', '127.0.0.1', '2014-04-14 22:48:34', '2', '超级管理员在2014-04-14 22:48:34成功删除了资源ID为[CandidateMgr]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('820', 'admin', '127.0.0.1', '2014-04-14 22:48:39', '2', '超级管理员在2014-04-14 22:48:39成功删除了资源ID为[ResumeList]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('821', 'admin', '127.0.0.1', '2014-04-14 22:48:43', '2', '超级管理员在2014-04-14 22:48:43成功删除了资源ID为[ResumeMgr]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('822', 'admin', '127.0.0.1', '2014-04-14 22:48:54', '2', '超级管理员在2014-04-14 22:48:54成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('823', 'admin', '127.0.0.1', '2014-04-14 22:49:06', '2', '超级管理员在2014-04-14 22:49:06成功重置了[admin]的密码！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('824', 'admin', '127.0.0.1', '2014-04-14 22:49:18', '2', '超级管理员在2014-04-14 22:49:18成功重置了[test1]的密码！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('825', 'admin', '127.0.0.1', '2014-04-14 22:50:13', '2', '超级管理员在2014-04-14 22:50:13成功添加了[信息维护]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('826', 'admin', '127.0.0.1', '2014-04-14 22:52:33', '2', '超级管理员在2014-04-14 22:52:33成功添加了[厨师管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('827', 'admin', '127.0.0.1', '2014-04-14 22:54:07', '2', '超级管理员在2014-04-14 22:54:07成功添加了[菜品管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('828', 'admin', '127.0.0.1', '2014-04-14 22:55:09', '2', '超级管理员在2014-04-14 22:55:09成功添加了[菜谱管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('829', 'admin', '127.0.0.1', '2014-04-14 22:55:41', '2', '超级管理员在2014-04-14 22:55:41成功添加了[KitchenerMgr-]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('830', 'admin', '127.0.0.1', '2014-04-14 22:55:54', '2', '超级管理员在2014-04-14 22:55:54成功删除了[KitchenerMgr-92]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('831', 'admin', '127.0.0.1', '2014-04-14 22:56:05', '2', '超级管理员在2014-04-14 22:56:05成功添加了[KitchenerMgr-查询]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('832', 'admin', '127.0.0.1', '2014-04-14 22:56:14', '2', '超级管理员在2014-04-14 22:56:14成功添加了[KitchenerMgr-添加]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('833', 'admin', '127.0.0.1', '2014-04-14 22:56:32', '2', '超级管理员在2014-04-14 22:56:32成功添加了[KitchenerMgr-修改]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('834', 'admin', '127.0.0.1', '2014-04-14 22:56:45', '2', '超级管理员在2014-04-14 22:56:45成功添加了[KitchenerMgr-删除]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('835', 'admin', '127.0.0.1', '2014-04-14 22:56:55', '2', '超级管理员在2014-04-14 22:56:55成功添加了[KitchenerMgr-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('836', 'admin', '127.0.0.1', '2014-04-14 22:57:16', '2', '超级管理员在2014-04-14 22:57:16成功添加了[DishMgr-查询]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('837', 'admin', '127.0.0.1', '2014-04-14 22:57:26', '2', '超级管理员在2014-04-14 22:57:26成功添加了[DishMgr-添加]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('838', 'admin', '127.0.0.1', '2014-04-14 22:57:34', '2', '超级管理员在2014-04-14 22:57:34成功添加了[DishMgr-修改]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('839', 'admin', '127.0.0.1', '2014-04-14 22:57:46', '2', '超级管理员在2014-04-14 22:57:46成功添加了[DishMgr-删除]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('840', 'admin', '127.0.0.1', '2014-04-14 22:57:53', '2', '超级管理员在2014-04-14 22:57:53成功添加了[DishMgr-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('841', 'admin', '127.0.0.1', '2014-04-14 22:58:07', '2', '超级管理员在2014-04-14 22:58:07成功添加了[CookbookMgr-查询]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('842', 'admin', '127.0.0.1', '2014-04-14 22:58:17', '2', '超级管理员在2014-04-14 22:58:17成功添加了[CookbookMgr-添加]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('843', 'admin', '127.0.0.1', '2014-04-14 22:58:28', '2', '超级管理员在2014-04-14 22:58:28成功添加了[CookbookMgr-修改]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('844', 'admin', '127.0.0.1', '2014-04-14 22:58:38', '2', '超级管理员在2014-04-14 22:58:38成功添加了[CookbookMgr-删除]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('845', 'admin', '127.0.0.1', '2014-04-14 22:58:49', '2', '超级管理员在2014-04-14 22:58:49成功添加了[CookbookMgr-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('846', 'admin', '127.0.0.1', '2014-04-14 22:59:09', '2', '超级管理员在2014-04-14 22:59:09成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('847', 'admin', '127.0.0.1', '2014-04-14 23:38:11', '2', '超级管理员在2014-04-14 23:38:11成功新增了[43424]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('848', 'admin', '127.0.0.1', '2014-04-14 23:39:20', '2', '超级管理员在2014-04-14 23:39:20成功新增了[fasfd]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('849', 'admin', '127.0.0.1', '2014-04-14 23:39:26', '2', '超级管理员在2014-04-14 23:39:26成功删除了[8]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('850', 'admin', '127.0.0.1', '2014-04-14 23:39:35', '2', '超级管理员在2014-04-14 23:39:35成功删除了[9]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('851', 'admin', '127.0.0.1', '2014-04-14 23:52:57', '2', '超级管理员在2014-04-14 23:52:57成功新增了[fsafdasf]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('852', 'admin', '127.0.0.1', '2014-04-14 23:53:40', '2', '超级管理员在2014-04-14 23:53:40成功删除了[10]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('853', 'admin', '127.0.0.1', '2014-04-15 00:07:47', '2', '超级管理员在2014-04-15 00:07:47成功修改了[22]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('854', 'admin', '127.0.0.1', '2014-04-15 00:08:48', '2', '超级管理员在2014-04-15 00:08:48成功删除了[7]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('855', 'admin', '127.0.0.1', '2014-04-15 00:08:51', '2', '超级管理员在2014-04-15 00:08:51成功删除了[6]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('856', 'admin', '127.0.0.1', '2014-04-15 00:08:54', '2', '超级管理员在2014-04-15 00:08:54成功删除了[5]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('857', 'admin', '127.0.0.1', '2014-04-15 00:09:11', '2', '超级管理员在2014-04-15 00:09:11成功新增了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('858', 'admin', '127.0.0.1', '2014-04-15 00:12:40', '2', '超级管理员在2014-04-15 00:12:40成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('859', 'admin', '127.0.0.1', '2014-04-15 00:12:44', '2', '超级管理员在2014-04-15 00:12:44成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('860', 'admin', '127.0.0.1', '2014-04-15 00:12:55', '2', '超级管理员在2014-04-15 00:12:55成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('861', 'admin', '127.0.0.1', '2014-04-15 00:13:14', '2', '超级管理员在2014-04-15 00:13:14成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('862', 'admin', '127.0.0.1', '2014-04-15 00:13:29', '2', '超级管理员在2014-04-15 00:13:29成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('863', 'admin', '127.0.0.1', '2014-04-15 00:25:37', '2', '超级管理员在2014-04-15 00:25:37修改[小鸡炖蘑菇a]的菜品信息时失败！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('864', 'admin', '127.0.0.1', '2014-04-15 00:25:44', '2', '超级管理员在2014-04-15 00:25:44修改[小鸡炖蘑菇a]的菜品信息时失败！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('865', 'admin', '127.0.0.1', '2014-04-15 00:26:37', '2', '超级管理员在2014-04-15 00:26:37修改[小鸡炖蘑菇aaaa]的菜品信息时失败！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('866', 'admin', '127.0.0.1', '2014-04-15 00:26:47', '2', '超级管理员在2014-04-15 00:26:47修改[小鸡炖蘑菇]的菜品信息时失败！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('867', 'admin', '127.0.0.1', '2014-04-15 00:27:39', '2', '超级管理员在2014-04-15 00:27:39修改[小鸡炖蘑菇]的菜品信息时失败！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('868', 'admin', '127.0.0.1', '2014-04-15 00:29:23', '2', '超级管理员在2014-04-15 00:29:23成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('869', 'admin', '127.0.0.1', '2014-04-15 00:29:28', '2', '超级管理员在2014-04-15 00:29:28成功修改了[小鸡炖蘑菇aa]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('870', 'admin', '127.0.0.1', '2014-04-15 00:29:40', '2', '超级管理员在2014-04-15 00:29:40成功修改了[小鸡炖蘑菇aaa]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('871', 'admin', '127.0.0.1', '2014-04-15 00:30:36', '2', '超级管理员在2014-04-15 00:30:36成功修改了[小鸡炖蘑菇aa]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('872', 'admin', '127.0.0.1', '2014-04-15 00:30:42', '2', '超级管理员在2014-04-15 00:30:42成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('873', 'admin', '127.0.0.1', '2014-04-15 00:31:35', '2', '超级管理员在2014-04-15 00:31:35成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('874', 'admin', '127.0.0.1', '2014-04-15 13:16:43', '2', '超级管理员在2014-04-15 13:16:43成功修改了[厨师管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('875', 'admin', '127.0.0.1', '2014-04-15 13:26:51', '2', '超级管理员在2014-04-15 13:26:51成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('876', 'admin', '127.0.0.1', '2014-04-15 21:06:08', '1', '超级管理员在2014-04-15 21:06:08修改[5]的厨师信息时失败！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('877', 'admin', '127.0.0.1', '2014-04-15 21:08:05', '1', '超级管理员在2014-04-15 21:08:05修改[1]的厨师信息时失败！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('878', 'admin', '127.0.0.1', '2014-04-15 21:13:03', '1', '超级管理员在2014-04-15 21:13:03成功修改了[1]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('879', 'admin', '127.0.0.1', '2014-04-15 21:15:08', '1', '超级管理员在2014-04-15 21:15:08成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('880', 'admin', '127.0.0.1', '2014-04-15 21:16:36', '1', '超级管理员在2014-04-15 21:16:36成功修改了[2]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('881', 'admin', '127.0.0.1', '2014-04-15 21:17:11', '1', '超级管理员在2014-04-15 21:17:11成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('882', 'admin', '127.0.0.1', '2014-04-15 21:18:30', '2', '超级管理员在2014-04-15 21:18:30成功新增了[红烧肉]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('883', 'admin', '127.0.0.1', '2014-04-15 21:24:21', '1', '超级管理员在2014-04-15 21:24:21成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('884', 'admin', '127.0.0.1', '2014-04-15 21:24:28', '1', '超级管理员在2014-04-15 21:24:28成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('885', 'admin', '127.0.0.1', '2014-04-15 21:25:12', '1', '超级管理员在2014-04-15 21:25:12成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('886', 'admin', '127.0.0.1', '2014-04-15 21:27:41', '1', '超级管理员在2014-04-15 21:27:41成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('887', 'admin', '127.0.0.1', '2014-04-15 21:34:36', '1', '超级管理员在2014-04-15 21:34:36成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('888', 'admin', '127.0.0.1', '2014-04-15 21:34:42', '1', '超级管理员在2014-04-15 21:34:42成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('889', 'admin', '127.0.0.1', '2014-04-15 21:34:46', '1', '超级管理员在2014-04-15 21:34:46成功修改了[1]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('890', 'admin', '127.0.0.1', '2014-04-15 21:38:48', '1', '超级管理员在2014-04-15 21:38:48成功修改了[2]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('891', 'admin', '127.0.0.1', '2014-04-15 21:38:57', '1', '超级管理员在2014-04-15 21:38:57成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('892', 'admin', '127.0.0.1', '2014-04-15 21:39:04', '1', '超级管理员在2014-04-15 21:39:04成功修改了[2]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('893', 'admin', '127.0.0.1', '2014-04-15 21:39:13', '1', '超级管理员在2014-04-15 21:39:13成功修改了[1]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('894', 'admin', '127.0.0.1', '2014-04-15 21:39:40', '2', '超级管理员在2014-04-15 21:39:40成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('895', 'admin', '127.0.0.1', '2014-04-15 21:49:58', '1', '超级管理员在2014-04-15 21:49:58成功修改了[5]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('896', 'admin', '127.0.0.1', '2014-04-15 21:50:07', '2', '超级管理员在2014-04-15 21:50:07成功修改了[小鸡炖蘑菇]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('897', 'admin', '127.0.0.1', '2014-04-15 22:30:10', '2', '超级管理员在2014-04-15 22:30:10成功修改了[菜谱1]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('898', 'admin', '127.0.0.1', '2014-04-15 22:30:30', '2', '超级管理员在2014-04-15 22:30:30成功修改了[菜谱2]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('899', 'admin', '127.0.0.1', '2014-04-15 22:30:37', '2', '超级管理员在2014-04-15 22:30:37成功删除了[17]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('900', 'admin', '127.0.0.1', '2014-04-15 22:30:40', '2', '超级管理员在2014-04-15 22:30:40成功删除了[16]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('901', 'admin', '127.0.0.1', '2014-04-15 22:30:43', '2', '超级管理员在2014-04-15 22:30:43成功删除了[15]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('902', 'admin', '127.0.0.1', '2014-04-15 22:30:45', '2', '超级管理员在2014-04-15 22:30:45成功删除了[14]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('903', 'admin', '127.0.0.1', '2014-04-15 22:30:48', '2', '超级管理员在2014-04-15 22:30:48成功删除了[13]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('904', 'admin', '127.0.0.1', '2014-04-15 22:32:25', '2', '超级管理员在2014-04-15 22:32:25成功修改了[菜谱1]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('905', 'admin', '127.0.0.1', '2014-04-15 22:32:32', '2', '超级管理员在2014-04-15 22:32:32成功修改了[菜谱2]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('906', 'admin', '127.0.0.1', '2014-04-15 22:32:36', '2', '超级管理员在2014-04-15 22:32:36成功修改了[菜谱1]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('907', 'admin', '127.0.0.1', '2014-04-15 22:32:40', '2', '超级管理员在2014-04-15 22:32:40成功修改了[菜谱2]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('908', 'admin', '127.0.0.1', '2014-04-15 22:32:56', '2', '超级管理员在2014-04-15 22:32:56新增[菜谱3]的菜谱信息时失败！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('909', 'admin', '127.0.0.1', '2014-04-15 22:34:22', '2', '超级管理员在2014-04-15 22:34:22成功新增了[菜谱3]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('910', 'admin', '127.0.0.1', '2014-04-15 23:04:09', '2', '超级管理员在2014-04-15 23:04:09成功新增了[东北大炖菜]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('911', 'admin', '127.0.0.1', '2014-04-15 23:05:15', '2', '超级管理员在2014-04-15 23:05:15成功添加了[CookbookMgr-更改菜品状态]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('912', 'admin', '127.0.0.1', '2014-04-15 23:05:23', '2', '超级管理员在2014-04-15 23:05:23成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('913', 'admin', '127.0.0.1', '2014-04-15 23:06:01', '2', '超级管理员在2014-04-15 23:06:01成功删除了[CookbookMgr-108]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('914', 'admin', '127.0.0.1', '2014-04-15 23:06:29', '2', '超级管理员在2014-04-15 23:06:29成功添加了[DishMgr-设置/取消优秀菜品]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('915', 'admin', '127.0.0.1', '2014-04-15 23:06:37', '2', '超级管理员在2014-04-15 23:06:37成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('916', 'admin', '127.0.0.1', '2014-04-15 23:09:19', '1', '超级管理员在2014-04-15 23:09:19成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('917', 'admin', '127.0.0.1', '2014-04-15 23:09:22', '1', '超级管理员在2014-04-15 23:09:22成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('918', 'admin', '127.0.0.1', '2014-04-15 23:09:24', '1', '超级管理员在2014-04-15 23:09:24成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('919', 'admin', '127.0.0.1', '2014-04-15 23:18:41', '2', '超级管理员在2014-04-15 23:18:41成功添加了[KitchenerMgr-设置/取消优秀厨师]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('920', 'admin', '127.0.0.1', '2014-04-15 23:18:52', '2', '超级管理员在2014-04-15 23:18:52成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('921', 'admin', '127.0.0.1', '2014-04-15 23:20:07', '1', '超级管理员在2014-04-15 23:20:07成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('922', 'admin', '127.0.0.1', '2014-04-15 23:20:42', '1', '超级管理员在2014-04-15 23:20:42成功更改了[6]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('923', 'admin', '127.0.0.1', '2014-04-15 23:20:45', '1', '超级管理员在2014-04-15 23:20:45成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('924', 'admin', '127.0.0.1', '2014-04-15 23:21:34', '1', '超级管理员在2014-04-15 23:21:34成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('925', 'admin', '127.0.0.1', '2014-04-15 23:21:36', '1', '超级管理员在2014-04-15 23:21:36成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('926', 'admin', '127.0.0.1', '2014-04-15 23:21:41', '1', '超级管理员在2014-04-15 23:21:41成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('927', 'admin', '127.0.0.1', '2014-04-15 23:21:43', '1', '超级管理员在2014-04-15 23:21:43成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('928', 'admin', '127.0.0.1', '2014-04-16 00:25:31', '2', '超级管理员在2014-04-16 00:25:31成功添加了[采购计划]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('929', 'admin', '127.0.0.1', '2014-04-16 00:25:45', '2', '超级管理员在2014-04-16 00:25:45成功添加了[PurchasePlanMgr-查询]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('930', 'admin', '127.0.0.1', '2014-04-16 00:25:54', '2', '超级管理员在2014-04-16 00:25:54成功添加了[PurchasePlanMgr-添加]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('931', 'admin', '127.0.0.1', '2014-04-16 00:26:02', '2', '超级管理员在2014-04-16 00:26:02成功添加了[PurchasePlanMgr-修改]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('932', 'admin', '127.0.0.1', '2014-04-16 00:26:20', '2', '超级管理员在2014-04-16 00:26:20成功添加了[PurchasePlanMgr-删除]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('933', 'admin', '127.0.0.1', '2014-04-16 00:26:32', '2', '超级管理员在2014-04-16 00:26:32成功添加了[PurchasePlanMgr-查看]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('934', 'admin', '127.0.0.1', '2014-04-16 00:26:42', '2', '超级管理员在2014-04-16 00:26:42成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('935', 'admin', '127.0.0.1', '2014-04-16 00:34:24', '2', '超级管理员在2014-04-16 00:34:24成功删除了ID为[8ae400ab422be25d01422be637920007]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('936', 'admin', '127.0.0.1', '2014-04-16 00:34:29', '2', '超级管理员在2014-04-16 00:34:29成功删除了ID为[8ae400ab422be25d01422be68c780008]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('937', 'admin', '127.0.0.1', '2014-04-16 00:34:33', '2', '超级管理员在2014-04-16 00:34:33成功删除了ID为[8ae400ab422be25d01422be704d70009]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('938', 'admin', '127.0.0.1', '2014-04-16 00:34:37', '2', '超级管理员在2014-04-16 00:34:37成功删除了ID为[8ae400ab422be25d01422be5d9fd0006]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('939', 'admin', '127.0.0.1', '2014-04-16 00:37:40', '2', '超级管理员在2014-04-16 00:37:40成功修改了[职位]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('940', 'admin', '127.0.0.1', '2014-04-16 00:37:48', '2', '超级管理员在2014-04-16 00:37:48成功删除了ID为[ff80808142380beb0142380cc4c00002]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('941', 'admin', '127.0.0.1', '2014-04-16 00:37:53', '2', '超级管理员在2014-04-16 00:37:53成功删除了ID为[ff80808142380beb0142380c65f20001]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('942', 'admin', '127.0.0.1', '2014-04-16 00:37:58', '2', '超级管理员在2014-04-16 00:37:58成功删除了ID为[ff80808142380beb0142380beb810000]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('943', 'admin', '127.0.0.1', '2014-04-16 00:38:18', '2', '超级管理员在2014-04-16 00:38:18成功修改了[职位]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('944', 'admin', '127.0.0.1', '2014-04-16 00:38:25', '2', '超级管理员在2014-04-16 00:38:25成功修改了[51job]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('945', 'admin', '127.0.0.1', '2014-04-16 00:38:30', '2', '超级管理员在2014-04-16 00:38:30成功修改了[智联招聘]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('946', 'admin', '127.0.0.1', '2014-04-16 00:38:34', '2', '超级管理员在2014-04-16 00:38:34成功修改了[智联招聘]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('947', 'admin', '127.0.0.1', '2014-04-16 00:46:24', '1', '超级管理员在2014-04-16 00:46:24成功添加了[1]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('948', 'admin', '127.0.0.1', '2014-04-16 01:00:38', '1', '超级管理员在2014-04-16 01:00:38成功修改了[1]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('949', 'admin', '127.0.0.1', '2014-04-16 01:00:48', '1', '超级管理员在2014-04-16 01:00:48成功修改了[1]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('950', 'admin', '127.0.0.1', '2014-04-16 01:02:17', '1', '超级管理员在2014-04-16 01:02:17成功修改了[1]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('951', 'admin', '127.0.0.1', '2014-04-16 01:02:21', '1', '超级管理员在2014-04-16 01:02:21成功删除了[1]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('952', 'admin', '127.0.0.1', '2014-04-16 01:02:34', '1', '超级管理员在2014-04-16 01:02:34成功添加了[2]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('953', 'admin', '127.0.0.1', '2014-04-16 01:02:41', '1', '超级管理员在2014-04-16 01:02:41成功修改了[2]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('954', 'admin', '127.0.0.1', '2014-04-16 01:03:14', '1', '超级管理员在2014-04-16 01:03:14成功修改了[2]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('955', 'admin', '127.0.0.1', '2014-04-16 01:03:19', '1', '超级管理员在2014-04-16 01:03:19成功修改了[2]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('956', 'admin', '127.0.0.1', '2014-04-16 01:07:00', '1', '超级管理员在2014-04-16 01:07:00成功修改了[2]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('957', 'admin', '127.0.0.1', '2014-04-16 23:34:14', '2', '超级管理员在2014-04-16 23:34:14成功添加了[公告管理]的资源信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('958', 'admin', '127.0.0.1', '2014-04-16 23:34:29', '2', '超级管理员在2014-04-16 23:34:29成功添加了[NoticeMgr-修改]的控件信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('959', 'admin', '127.0.0.1', '2014-04-16 23:34:44', '2', '超级管理员在2014-04-16 23:34:44成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('960', 'admin', '127.0.0.1', '2014-04-16 23:35:33', '2', '超级管理员在2014-04-16 23:35:33成功修改了[1]的公告信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('961', 'admin', '127.0.0.1', '2014-04-17 01:22:52', '1', '超级管理员在2014-04-17 01:22:52成功添加了[3]的采购计划信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('962', 'admin', '127.0.0.1', '2014-04-17 21:24:57', '1', '超级管理员在2014-04-17 21:24:57成功更改了[1]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('963', 'admin', '127.0.0.1', '2014-04-17 21:25:03', '1', '超级管理员在2014-04-17 21:25:03成功更改了[1]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('964', 'admin', '127.0.0.1', '2014-04-17 21:25:09', '1', '超级管理员在2014-04-17 21:25:09成功更改了[1]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('965', 'admin', '127.0.0.1', '2014-04-17 21:25:13', '1', '超级管理员在2014-04-17 21:25:13成功更改了[13]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('966', 'admin', '127.0.0.1', '2014-04-17 21:26:02', '2', '超级管理员在2014-04-17 21:26:02成功新增了[艾丝凡阿萨德飞]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('967', 'admin', '127.0.0.1', '2014-04-17 21:26:14', '2', '超级管理员在2014-04-17 21:26:14成功新增了[阿德辅导费]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('968', 'admin', '127.0.0.1', '2014-04-17 21:26:29', '2', '超级管理员在2014-04-17 21:26:29成功新增了[黄火凤凰]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('969', 'admin', '127.0.0.1', '2014-04-17 21:26:32', '1', '超级管理员在2014-04-17 21:26:32成功更改了[14]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('970', 'admin', '127.0.0.1', '2014-04-17 21:26:34', '1', '超级管理员在2014-04-17 21:26:34成功更改了[15]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('971', 'admin', '127.0.0.1', '2014-04-17 21:26:58', '2', '超级管理员在2014-04-17 21:26:58成功修改了[黄火凤凰]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('972', 'admin', '127.0.0.1', '2014-04-17 21:27:02', '2', '超级管理员在2014-04-17 21:27:02成功修改了[黄火凤凰]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('973', 'admin', '127.0.0.1', '2014-04-17 21:27:15', '2', '超级管理员在2014-04-17 21:27:15成功修改了[黄火凤凰]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('974', 'admin', '127.0.0.1', '2014-04-17 21:27:55', '2', '超级管理员在2014-04-17 21:27:55成功新增了[]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('975', 'admin', '127.0.0.1', '2014-04-17 21:28:07', '2', '超级管理员在2014-04-17 21:28:07成功修改了[周一]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('976', 'admin', '127.0.0.1', '2014-04-17 21:28:33', '2', '超级管理员在2014-04-17 21:28:33成功新增了[周二]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('977', 'admin', '127.0.0.1', '2014-04-17 21:32:41', '2', '超级管理员在2014-04-17 21:32:41成功新增了[啊啊啊]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('978', 'admin', '127.0.0.1', '2014-04-17 21:32:51', '1', '超级管理员在2014-04-17 21:32:51成功更改了[17]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('979', 'admin', '127.0.0.1', '2014-04-17 21:33:39', '1', '超级管理员在2014-04-17 21:33:39成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('980', 'admin', '127.0.0.1', '2014-04-17 21:34:26', '2', '超级管理员在2014-04-17 21:34:26成功修改了[啊啊啊]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('981', 'admin', '127.0.0.1', '2014-04-17 21:34:38', '1', '超级管理员在2014-04-17 21:34:38成功更改了[17]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('982', 'admin', '127.0.0.1', '2014-04-17 21:41:45', '1', '超级管理员在2014-04-17 21:41:45成功更改了[14]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('983', 'admin', '127.0.0.1', '2014-04-17 21:41:47', '1', '超级管理员在2014-04-17 21:41:47成功更改了[13]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('984', 'admin', '127.0.0.1', '2014-04-17 21:41:49', '1', '超级管理员在2014-04-17 21:41:49成功更改了[12]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('985', 'admin', '127.0.0.1', '2014-04-17 21:41:50', '1', '超级管理员在2014-04-17 21:41:50成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('986', 'admin', '127.0.0.1', '2014-04-17 21:46:26', '1', '超级管理员在2014-04-17 21:46:26成功更改了[11]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('987', 'admin', '127.0.0.1', '2014-04-17 21:46:28', '1', '超级管理员在2014-04-17 21:46:28成功更改了[12]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('988', 'admin', '127.0.0.1', '2014-04-17 21:46:36', '1', '超级管理员在2014-04-17 21:46:36成功更改了[1]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('989', 'admin', '127.0.0.1', '2014-04-17 21:46:37', '1', '超级管理员在2014-04-17 21:46:37成功更改了[2]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('990', 'admin', '127.0.0.1', '2014-04-17 21:46:39', '1', '超级管理员在2014-04-17 21:46:39成功更改了[5]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('991', 'admin', '127.0.0.1', '2014-04-17 21:46:40', '1', '超级管理员在2014-04-17 21:46:40成功更改了[6]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('992', 'admin', '127.0.0.1', '2014-04-17 21:46:45', '1', '超级管理员在2014-04-17 21:46:45成功更改了[6]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('993', 'admin', '127.0.0.1', '2014-04-17 21:46:48', '1', '超级管理员在2014-04-17 21:46:48成功更改了[2]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('994', 'admin', '127.0.0.1', '2014-04-17 21:46:48', '1', '超级管理员在2014-04-17 21:46:48成功更改了[2]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('995', 'admin', '127.0.0.1', '2014-04-17 21:46:49', '1', '超级管理员在2014-04-17 21:46:49成功更改了[5]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('996', 'admin', '127.0.0.1', '2014-04-17 21:46:51', '1', '超级管理员在2014-04-17 21:46:51成功更改了[7]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('997', 'admin', '127.0.0.1', '2014-04-17 21:47:25', '1', '超级管理员在2014-04-17 21:47:25成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('998', 'admin', '127.0.0.1', '2014-04-17 21:47:30', '1', '超级管理员在2014-04-17 21:47:30成功更改了[8]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('999', 'admin', '127.0.0.1', '2014-04-17 21:52:02', '1', '超级管理员在2014-04-17 21:52:02成功更改了[13]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1000', 'admin', '127.0.0.1', '2014-04-17 21:52:06', '1', '超级管理员在2014-04-17 21:52:06成功更改了[14]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1001', 'admin', '127.0.0.1', '2014-04-17 21:52:08', '1', '超级管理员在2014-04-17 21:52:08成功更改了[15]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1002', 'admin', '127.0.0.1', '2014-04-17 21:52:09', '1', '超级管理员在2014-04-17 21:52:09成功更改了[16]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1003', 'admin', '127.0.0.1', '2014-04-17 21:52:11', '1', '超级管理员在2014-04-17 21:52:11成功更改了[17]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1004', 'admin', '127.0.0.1', '2014-04-17 22:31:08', '1', '超级管理员在2014-04-17 22:31:08成功更改了[8]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1005', 'admin', '127.0.0.1', '2014-04-17 22:31:11', '1', '超级管理员在2014-04-17 22:31:11成功更改了[8]的厨师的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1006', 'admin', '127.0.0.1', '2014-04-17 22:32:01', '2', '超级管理员在2014-04-17 22:32:01成功修改了[菜市场]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1007', 'admin', '127.0.0.1', '2014-04-17 22:32:14', '2', '超级管理员在2014-04-17 22:32:14成功修改了[批发市场]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1008', 'admin', '127.0.0.1', '2014-04-17 22:32:59', '2', '超级管理员在2014-04-17 22:32:59成功修改了[司令]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1009', 'admin', '127.0.0.1', '2014-04-17 22:33:11', '2', '超级管理员在2014-04-17 22:33:11成功修改了[军长]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1010', 'admin', '127.0.0.1', '2014-04-17 22:33:21', '2', '超级管理员在2014-04-17 22:33:21成功修改了[厨师长]的字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1011', 'admin', '127.0.0.1', '2014-04-17 22:33:23', '2', '超级管理员在2014-04-17 22:33:23成功刷新了字典信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1012', 'admin', '127.0.0.1', '2014-04-17 22:34:14', '2', '超级管理员在2014-04-17 22:34:14成功修改了[超级管理员组]的角色信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1013', 'admin', '127.0.0.1', '2014-04-17 23:05:33', '2', '超级管理员在2014-04-17 23:05:33成功修改了[1]的公告信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1014', 'admin', '127.0.0.1', '2014-04-26 23:28:34', '2', '超级管理员在2014-04-26 23:28:34成功新增了[test]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1015', 'admin', '127.0.0.1', '2014-04-26 23:35:03', '2', '超级管理员在2014-04-26 23:35:03成功修改了[test]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1016', 'admin', '127.0.0.1', '2014-04-26 23:35:16', '2', '超级管理员在2014-04-26 23:35:16成功修改了[test]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1017', 'admin', '127.0.0.1', '2014-04-26 23:35:39', '2', '超级管理员在2014-04-26 23:35:39成功新增了[test2]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1018', 'admin', '127.0.0.1', '2014-04-27 00:15:46', '2', '超级管理员在2014-04-27 00:15:46成功修改了[test2]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1019', 'admin', '127.0.0.1', '2014-04-27 00:16:11', '2', '超级管理员在2014-04-27 00:16:11成功修改了[test2]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1020', 'admin', '127.0.0.1', '2014-04-27 01:51:07', '2', '超级管理员在2014-04-27 01:51:07成功新增了[test]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1021', 'admin', '127.0.0.1', '2014-04-27 01:52:56', '2', '超级管理员在2014-04-27 01:52:56成功修改了[东北大炖菜]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1022', 'admin', '127.0.0.1', '2014-04-27 01:53:02', '2', '超级管理员在2014-04-27 01:53:02成功修改了[红烧肉]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1023', 'admin', '127.0.0.1', '2014-04-27 01:53:16', '2', '超级管理员在2014-04-27 01:53:16成功新增了[test2]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1024', 'admin', '127.0.0.1', '2014-04-27 01:53:36', '1', '超级管理员在2014-04-27 01:53:36成功更改了[19]的菜品的状态！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1025', 'admin', '127.0.0.1', '2014-04-27 01:54:24', '2', '超级管理员在2014-04-27 01:54:24成功修改了[红烧肉]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1026', 'admin', '127.0.0.1', '2014-04-27 02:02:03', '2', '超级管理员在2014-04-27 02:02:03成功修改了[test]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1027', 'admin', '127.0.0.1', '2014-04-27 02:04:04', '2', '超级管理员在2014-04-27 02:04:04成功修改了[菜谱3]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1028', 'admin', '127.0.0.1', '2014-04-27 02:04:10', '2', '超级管理员在2014-04-27 02:04:10成功修改了[周一]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1029', 'admin', '127.0.0.1', '2014-04-27 02:04:21', '2', '超级管理员在2014-04-27 02:04:21成功修改了[菜谱2]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1030', 'admin', '127.0.0.1', '2014-04-27 02:04:26', '2', '超级管理员在2014-04-27 02:04:26成功修改了[菜谱3]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1031', 'admin', '127.0.0.1', '2014-04-27 02:04:32', '2', '超级管理员在2014-04-27 02:04:32成功修改了[周一]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1032', 'admin', '127.0.0.1', '2014-04-27 02:05:05', '2', '超级管理员在2014-04-27 02:05:05成功修改了[菜谱1]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1033', 'admin', '127.0.0.1', '2014-04-27 02:05:29', '2', '超级管理员在2014-04-27 02:05:29成功修改了[菜谱1]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1034', 'admin', '127.0.0.1', '2014-04-27 02:06:12', '2', '超级管理员在2014-04-27 02:06:12成功修改了[周二]的菜谱信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1035', 'admin', '127.0.0.1', '2014-05-04 22:58:00', '1', '超级管理员在2014-05-04 22:58:00成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1036', 'admin', '127.0.0.1', '2014-05-04 22:58:16', '1', '超级管理员在2014-05-04 22:58:16成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1037', 'admin', '127.0.0.1', '2014-05-04 22:58:54', '1', '超级管理员在2014-05-04 22:58:54成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1038', 'admin', '127.0.0.1', '2014-05-04 22:59:09', '1', '超级管理员在2014-05-04 22:59:09成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1039', 'admin', '127.0.0.1', '2014-05-04 22:59:23', '1', '超级管理员在2014-05-04 22:59:23成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1040', 'admin', '127.0.0.1', '2014-05-04 22:59:41', '1', '超级管理员在2014-05-04 22:59:41成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1041', 'admin', '127.0.0.1', '2014-05-04 23:03:40', '1', '超级管理员在2014-05-04 23:03:40成功添加了[0]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1042', 'admin', '127.0.0.1', '2014-05-06 21:13:44', '2', '超级管理员在2014-05-06 21:13:44成功修改了[test]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1043', 'admin', '127.0.0.1', '2014-05-06 21:13:57', '2', '超级管理员在2014-05-06 21:13:57成功修改了[东北大炖菜]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1044', 'admin', '127.0.0.1', '2014-05-06 21:14:12', '2', '超级管理员在2014-05-06 21:14:12成功修改了[test2]的菜品信息！', '4101', '系统维护日志');
INSERT INTO `sys_log` VALUES ('1045', 'admin', '127.0.0.1', '2014-05-06 21:14:42', '1', '超级管理员在2014-05-06 21:14:42成功修改了[10]的厨师信息！', '4101', '业务日志');
INSERT INTO `sys_log` VALUES ('1046', 'admin', '127.0.0.1', '2014-05-06 21:14:58', '1', '超级管理员在2014-05-06 21:14:58成功修改了[9]的厨师信息！', '4101', '业务日志');

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `url` varchar(255) NOT NULL,
  `parent_id` varchar(100) DEFAULT NULL,
  `icon_url` varchar(200) DEFAULT NULL,
  `sort` bigint(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6510844BF7EFB7EB` (`parent_id`),
  CONSTRAINT `FK6510844BF7EFB7EB` FOREIGN KEY (`parent_id`) REFERENCES `sys_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('Base', '根模块', '根模块', '#', null, null, '0', null, null, '2014-01-03 11:20:01', 'admin');
INSERT INTO `sys_resource` VALUES ('BaseInfo', '信息维护', '信息维护', '#', 'Base', null, '1', '2014-04-14 22:50:13', 'admin', null, null);
INSERT INTO `sys_resource` VALUES ('CookbookMgr', '菜谱管理', '菜谱管理', 'baseInfo/cookbook/listIFrame', 'BaseInfo', null, '13', '2014-04-14 22:55:09', 'admin', null, null);
INSERT INTO `sys_resource` VALUES ('Department', '部门管理', '部门管理', 'system/department/list', 'SystemMgr', null, '53', '2014-01-08 13:29:52', 'admin', '2014-01-23 23:35:34', 'admin');
INSERT INTO `sys_resource` VALUES ('Dictionary', '字典管理', '字典管理', 'system/dictionary/list', 'SystemMgr', null, '55', '2014-01-08 13:30:45', 'admin', '2014-01-23 23:35:49', 'admin');
INSERT INTO `sys_resource` VALUES ('DishMgr', '菜品管理', '菜品管理', 'baseInfo/dish/listIFrame', 'BaseInfo', null, '12', '2014-04-14 22:54:07', 'admin', null, null);
INSERT INTO `sys_resource` VALUES ('KitchenerMgr', '厨师管理', '厨师管理', 'baseInfo/kitchener/listIFrame', 'BaseInfo', null, '11', '2014-04-14 22:52:32', 'admin', '2014-04-15 13:16:43', 'admin');
INSERT INTO `sys_resource` VALUES ('NoticeMgr', '公告管理', '公告管理', 'baseInfo/notice/edit', 'BaseInfo', null, '15', '2014-04-16 23:34:13', 'admin', null, null);
INSERT INTO `sys_resource` VALUES ('PurchasePlanMgr', '采购计划', '采购计划', 'baseInfo/purchaseplan/list', 'BaseInfo', null, '14', '2014-04-16 00:25:31', 'admin', null, null);
INSERT INTO `sys_resource` VALUES ('Role', '角色管理', '角色管理', 'system/role/list', 'SystemMgr', null, '51', '2014-01-08 13:29:05', 'admin', '2014-03-08 17:42:08', 'admin');
INSERT INTO `sys_resource` VALUES ('SystemMgr', '系统管理', '系统管理', '#', 'Base', null, '5', '2014-01-03 11:16:10', 'admin', '2014-01-23 23:33:30', 'admin');
INSERT INTO `sys_resource` VALUES ('User', '用户管理', '用户管理', 'system/user/list', 'SystemMgr', null, '52', '2014-01-08 13:28:46', 'admin', '2014-01-23 23:35:21', 'admin');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('22', '普通用户组', '普通用户组', '1', '2014-01-09 14:37:35', 'admin', '2014-03-07 23:29:45', 'admin');
INSERT INTO `sys_role` VALUES ('23', '领导组', '领导组', '1', '2014-01-09 15:21:06', 'admin', '2014-03-10 21:13:32', 'admin');
INSERT INTO `sys_role` VALUES ('24', '超级管理员组', '超级管理员组拥有所有权限，且该角色不能删除，为系统默认角色', '1', '2014-01-17 16:50:23', 'admin', '2014-04-17 22:34:14', 'admin');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` bigint(12) NOT NULL DEFAULT '0',
  `permission` varchar(255) NOT NULL DEFAULT '',
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`role_id`,`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('22', 'Base', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'Dictionary', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'Dictionary:Add', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'Dictionary:Delete', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'Dictionary:Refresh', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'Dictionary:View', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'Log', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'Log:Export', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'Log:Query', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('22', 'SystemMgr', '2014-03-07 23:29:46', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Base', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateList', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateList:CancelRecommend', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateList:Evaluation', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateList:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateList:Recommend', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateList:View', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateMgr', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateRep', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'CandidateRep:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Department', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Department:Add', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Department:Delete', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Department:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Department:Update', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Department:View', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Dictionary', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Dictionary:Add', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Dictionary:Delete', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Dictionary:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Dictionary:Refresh', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Dictionary:Update', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Dictionary:View', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Log', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Log:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'RecommendCaseRep', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'RecommendCaseRep:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ReportCount', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Resource', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Resource:Add', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Resource:Delete', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Resource:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Resource:Update', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Resource:View', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Resource:ViewControl', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList:Add', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList:CancelCandidate', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList:Delete', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList:DownLoad', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList:SetCandidate', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList:Update', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeList:View', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeMgr', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeRep', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'ResumeRep:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Role', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Role:Add', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Role:Delete', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Role:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Role:Update', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'Role:View', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'SystemMgr', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'User', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'User:Add', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'User:Delete', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'User:Query', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'User:ResetPwd', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'User:Update', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('23', 'User:View', '2014-03-10 21:13:32', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Base', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'BaseInfo', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'CookbookMgr', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'CookbookMgr:Add', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'CookbookMgr:Delete', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'CookbookMgr:Query', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'CookbookMgr:Update', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'CookbookMgr:View', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Department', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Department:Add', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Department:Delete', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Department:Query', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Department:Update', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Department:View', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Dictionary', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Dictionary:Add', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Dictionary:Delete', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Dictionary:Query', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Dictionary:Refresh', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Dictionary:Update', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Dictionary:View', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'DishMgr', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'DishMgr:Add', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'DishMgr:ChangeStatus', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'DishMgr:Delete', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'DishMgr:Query', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'DishMgr:Update', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'DishMgr:View', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'KitchenerMgr', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'KitchenerMgr:Add', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'KitchenerMgr:ChangeState', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'KitchenerMgr:Delete', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'KitchenerMgr:Query', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'KitchenerMgr:Update', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'KitchenerMgr:View', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'NoticeMgr', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'NoticeMgr:Edit', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'PurchasePlanMgr', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'PurchasePlanMgr:Add', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'PurchasePlanMgr:Delete', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'PurchasePlanMgr:Query', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'PurchasePlanMgr:Update', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'PurchasePlanMgr:View', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Role', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Role:Add', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Role:Delete', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Role:Query', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Role:Update', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'Role:View', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'SystemMgr', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'User', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'User:Add', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'User:Delete', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'User:Query', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'User:ResetPwd', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'User:Update', '2014-04-17 22:34:14', 'admin', null, null);
INSERT INTO `sys_role_permission` VALUES ('24', 'User:View', '2014-04-17 22:34:14', 'admin', null, null);

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `departmentId` varchar(100) DEFAULT NULL,
  `positionId` varchar(255) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `createoperator` varchar(100) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `updateoperator` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'F4X/QxuZf5M2QeWi9B1n8LJHSS85gc2piKMmSf3ynkSFhYuaJMB+NWCFQsXqdn2Z', '超级管理员', '4101', '704', '1', '2014-05-09 00:33:29', '2013-12-19 11:46:49', '', '2014-03-07 23:29:52', 'admin');
INSERT INTO `sys_user` VALUES ('2', 'test1', 'F4X/QxuZf5M2QeWi9B1n8LJHSS85gc2piKMmSf3ynkSFhYuaJMB+NWCFQsXqdn2Z', '测试一', '41010101', '701', '1', '2014-03-08 01:42:27', '2014-03-07 21:06:18', 'admin', '2014-03-07 21:11:44', 'admin');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` bigint(20) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`role_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('22', 'test1', '2014-03-07 21:11:44', 'admin', null, null);
INSERT INTO `sys_user_role` VALUES ('24', 'admin', '2014-03-07 23:29:52', 'admin', null, null);

-- ----------------------------
-- Table structure for `t_cookbook`
-- ----------------------------
DROP TABLE IF EXISTS `t_cookbook`;
CREATE TABLE `t_cookbook` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `department_id` int(100) DEFAULT NULL,
  `cook_dish_id` varchar(200) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `week` varchar(1) DEFAULT NULL,
  `threemeals` varchar(1) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cookbook
-- ----------------------------
INSERT INTO `t_cookbook` VALUES ('11', '菜谱1', '41010101', 'default.png', '1', '1', '1', '法萨芬', '2014-03-09 17:10:27', 'admin', '2014-04-27 02:05:29', 'admin');
INSERT INTO `t_cookbook` VALUES ('12', '菜谱2', '41010102', 'default.png', '1', '1', '1', '暗示法', '2014-03-09 17:10:38', 'admin', '2014-04-27 02:04:21', 'admin');
INSERT INTO `t_cookbook` VALUES ('18', '菜谱3', '41010101', null, '1', '1', '1', '菜谱333', '2014-04-15 22:34:21', 'admin', '2014-04-27 02:04:26', 'admin');
INSERT INTO `t_cookbook` VALUES ('19', '周一', '41010201', null, '1', '1', '1', '', '2014-04-17 21:27:54', 'admin', '2014-04-27 02:04:32', 'admin');
INSERT INTO `t_cookbook` VALUES ('20', '周二', '41010201', null, '1', '1', '3', '', '2014-04-17 21:28:33', 'admin', '2014-04-27 02:06:12', 'admin');
INSERT INTO `t_cookbook` VALUES ('21', 'test', '41010201', null, '1', '6', '2', '', '2014-04-26 23:28:34', 'admin', '2014-04-27 02:02:02', 'admin');
INSERT INTO `t_cookbook` VALUES ('22', 'test2', '41010201', null, '1', '2', '1', '', '2014-04-26 23:35:39', 'admin', '2014-04-27 00:16:11', 'admin');

-- ----------------------------
-- Table structure for `t_cookbook_dish`
-- ----------------------------
DROP TABLE IF EXISTS `t_cookbook_dish`;
CREATE TABLE `t_cookbook_dish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cook_id` bigint(20) DEFAULT NULL,
  `dish_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cookbook_dish
-- ----------------------------
INSERT INTO `t_cookbook_dish` VALUES ('35', '22', '11', '2014-04-27 00:16:11', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('36', '22', '12', '2014-04-27 00:16:11', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('37', '22', '13', '2014-04-27 00:16:11', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('38', '21', '11', '2014-04-27 02:02:02', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('39', '21', '12', '2014-04-27 02:02:02', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('45', '12', '12', '2014-04-27 02:04:21', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('46', '18', '11', '2014-04-27 02:04:26', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('47', '19', '12', '2014-04-27 02:04:32', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('48', '19', '13', '2014-04-27 02:04:32', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('49', '19', '14', '2014-04-27 02:04:32', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('50', '19', '15', '2014-04-27 02:04:32', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('57', '11', '11', '2014-04-27 02:05:29', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('58', '11', '12', '2014-04-27 02:05:29', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('59', '11', '13', '2014-04-27 02:05:29', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('60', '11', '14', '2014-04-27 02:05:29', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('61', '11', '15', '2014-04-27 02:05:29', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('62', '11', '16', '2014-04-27 02:05:29', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('63', '20', '11', '2014-04-27 02:06:12', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('64', '20', '12', '2014-04-27 02:06:12', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('65', '20', '13', '2014-04-27 02:06:12', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('66', '20', '14', '2014-04-27 02:06:12', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('67', '20', '15', '2014-04-27 02:06:12', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('68', '20', '16', '2014-04-27 02:06:12', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('69', '20', '17', '2014-04-27 02:06:12', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('70', '20', '18', '2014-04-27 02:06:12', 'admin', null, null);
INSERT INTO `t_cookbook_dish` VALUES ('71', '20', '19', '2014-04-27 02:06:12', 'admin', null, null);

-- ----------------------------
-- Table structure for `t_dish`
-- ----------------------------
DROP TABLE IF EXISTS `t_dish`;
CREATE TABLE `t_dish` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `image_name` varchar(200) DEFAULT NULL,
  `score` varchar(500) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `department_id` varchar(100) DEFAULT NULL,
  `type` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dish
-- ----------------------------
INSERT INTO `t_dish` VALUES ('11', '小鸡炖蘑菇', '侧二十按时发送方', '3.jpg', '4', '1', '41010101', '1', '2014-04-15 00:09:11', 'admin', '2014-04-15 21:50:07', 'admin');
INSERT INTO `t_dish` VALUES ('12', '红烧肉', '红烧肉红烧肉红烧肉红烧肉', '5.jpg', '5', '1', '41010101', '7', '2014-04-15 21:18:30', 'admin', '2014-04-27 01:54:23', 'admin');
INSERT INTO `t_dish` VALUES ('13', '东北大炖菜', '东北大炖菜东北大炖菜', '8.jpg', '13', '1', '41010101', '4', '2014-04-15 23:04:08', 'admin', '2014-05-06 21:13:57', 'admin');
INSERT INTO `t_dish` VALUES ('14', '艾丝凡阿萨德飞', '', '1.jpg', '8', '1', '41010301', '4', '2014-04-17 21:26:02', 'admin', null, null);
INSERT INTO `t_dish` VALUES ('15', '阿德辅导费', '', '2.jpg', '9', '1', '41010201', '5', '2014-04-17 21:26:14', 'admin', null, null);
INSERT INTO `t_dish` VALUES ('16', '黄火凤凰', '', '5.jpg', '0', '1', '41010301', '6', '2014-04-17 21:26:28', 'admin', '2014-04-17 21:27:14', 'admin');
INSERT INTO `t_dish` VALUES ('17', '啊啊啊', '', '10.jpg', '2', '1', '41010301', '7', '2014-04-17 21:32:41', 'admin', '2014-04-17 21:34:26', 'admin');
INSERT INTO `t_dish` VALUES ('18', 'test', '', '2.jpg', '6', '0', '41010301', '1', '2014-04-27 01:51:07', 'admin', '2014-05-06 21:13:44', 'admin');
INSERT INTO `t_dish` VALUES ('19', 'test2', '', '10.jpg', '0', '1', '41010301', '4', '2014-04-27 01:53:16', 'admin', '2014-05-06 21:14:12', 'admin');

-- ----------------------------
-- Table structure for `t_kitchener`
-- ----------------------------
DROP TABLE IF EXISTS `t_kitchener`;
CREATE TABLE `t_kitchener` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `department_id` varchar(100) DEFAULT NULL,
  `kitchener_dish_id` varchar(50) DEFAULT NULL,
  `photo_name` varchar(200) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `score` varchar(10) DEFAULT NULL,
  `create_date` varchar(30) DEFAULT NULL,
  `create_oper_id` varchar(100) DEFAULT NULL,
  `update_date` varchar(30) DEFAULT NULL,
  `update_oper_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kitchener
-- ----------------------------
INSERT INTO `t_kitchener` VALUES ('1', '张三', '1', '3213123213', '41010101', null, 'cs_4.jpg', '测试aaa', '0', '18', '2014-03-26 21:17:00', 'admin', '2014-04-15 21:39:12', 'admin');
INSERT INTO `t_kitchener` VALUES ('2', '赵四', '1', '312321321', '41010101', null, 'cs_2.jpg', '备注备注备注备注备注备注备注备注', '1', '32', '2014-03-26 21:56:40', 'admin', '2014-04-15 21:39:04', 'admin');
INSERT INTO `t_kitchener` VALUES ('5', '王五', '0', '43242423', '41010101', '7', 'cs_3.jpg', '备注备注备注', '1', '3', '2014-04-13 11:58:43', 'admin', '2014-04-15 21:49:58', 'admin');
INSERT INTO `t_kitchener` VALUES ('6', '麻子', '1', '432424', '41010101', null, 'cs_1.jpg', '飞洒发斯蒂芬', '1', '8', '2014-04-15 23:20:07', 'admin', null, null);
INSERT INTO `t_kitchener` VALUES ('7', '啊啊啊', '0', '234234', '41010301', null, 'cs_4.jpg', '', '1', '3', '2014-04-17 21:33:39', 'admin', null, null);
INSERT INTO `t_kitchener` VALUES ('8', '宝宝', '1', '23日3', '4101010201', null, 'cs_4.jpg', '', '1', '3', '2014-04-17 21:47:25', 'admin', null, null);
INSERT INTO `t_kitchener` VALUES ('9', 'asdfsdf', '1', 'sdfasdf', '41010101', null, 'cs_1.jpg', '', '0', '0', '2014-05-04 22:58:00', 'admin', '2014-05-06 21:14:58', 'admin');
INSERT INTO `t_kitchener` VALUES ('10', 'fdfdfd', '1', 'dfdf', '41010101', null, 'cs_2.jpg', '', '0', '0', '2014-05-04 22:58:16', 'admin', '2014-05-06 21:14:42', 'admin');
INSERT INTO `t_kitchener` VALUES ('11', 'dfdfdasdf', '1', 'asdfas', '41010101', null, 'cs_3.jpg', '', '0', '0', '2014-05-04 22:58:54', 'admin', null, null);
INSERT INTO `t_kitchener` VALUES ('12', 'wewe', '0', 'wefw', '41010101', null, 'cs_3.jpg', '', '0', '0', '2014-05-04 22:59:09', 'admin', null, null);
INSERT INTO `t_kitchener` VALUES ('13', 'wefwef', '0', 'wef', '41010101', null, 'cs_3.jpg', '', '0', '0', '2014-05-04 22:59:23', 'admin', null, null);
INSERT INTO `t_kitchener` VALUES ('14', 'wefwe', '1', 'wefwef', '41010101', null, 'cs_2.jpg', '', '0', '0', '2014-05-04 22:59:41', 'admin', null, null);
INSERT INTO `t_kitchener` VALUES ('15', '222', '1', '22323', '41010101', null, 'cs_1.jpg', '', '0', '0', '2014-05-04 23:03:40', 'admin', null, null);

-- ----------------------------
-- Table structure for `t_kitchener_dish`
-- ----------------------------
DROP TABLE IF EXISTS `t_kitchener_dish`;
CREATE TABLE `t_kitchener_dish` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `kitchener_id` bigint(32) DEFAULT NULL,
  `dish_id` bigint(32) DEFAULT NULL,
  `is_good_at` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kitchener_dish
-- ----------------------------
INSERT INTO `t_kitchener_dish` VALUES ('73', '2', '11', '', '2014-04-15 21:39:04', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('74', '2', '12', '', '2014-04-15 21:39:04', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('75', '1', '12', '', '2014-04-15 21:39:13', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('76', '5', '11', '', '2014-04-15 21:49:58', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('77', '6', '11', '', '2014-04-15 23:20:07', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('78', '7', '11', '', '2014-04-17 21:33:39', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('79', '7', '12', '', '2014-04-17 21:33:39', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('80', '7', '13', '', '2014-04-17 21:33:39', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('81', '8', '11', '', '2014-04-17 21:47:25', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('82', '8', '12', '', '2014-04-17 21:47:25', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('83', '8', '13', '', '2014-04-17 21:47:25', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('84', '8', '14', '', '2014-04-17 21:47:25', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('85', '8', '15', '', '2014-04-17 21:47:25', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('86', '8', '16', '', '2014-04-17 21:47:25', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('87', '8', '17', '', '2014-04-17 21:47:25', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('90', '11', '13', '', '2014-05-04 22:58:54', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('91', '12', '11', '', '2014-05-04 22:59:09', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('92', '12', '13', '', '2014-05-04 22:59:09', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('93', '13', '11', '', '2014-05-04 22:59:23', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('94', '15', '11', '', '2014-05-04 23:03:40', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('95', '10', '13', '', '2014-05-06 21:14:42', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('96', '9', '11', '', '2014-05-06 21:14:58', 'admin', null, null);
INSERT INTO `t_kitchener_dish` VALUES ('97', '9', '14', '', '2014-05-06 21:14:58', 'admin', null, null);

-- ----------------------------
-- Table structure for `t_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', '公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告公告aaa', '2014-04-16 22:57:38', 'admin', null, null);

-- ----------------------------
-- Table structure for `t_purchase_plan`
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase_plan`;
CREATE TABLE `t_purchase_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(200) DEFAULT NULL,
  `unit_price` varchar(10) DEFAULT NULL,
  `amount` varchar(10) DEFAULT NULL,
  `purchaser_name` varchar(50) DEFAULT NULL,
  `purchase_date` varchar(30) DEFAULT NULL,
  `source_id` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_oper_id` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_oper_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_purchase_plan
-- ----------------------------
INSERT INTO `t_purchase_plan` VALUES ('2', '测试', '4234', '333', '测试一下', '2014-04-16', '401', '2014-04-16 01:02:34', 'admin', '2014-04-16 01:06:59', 'admin');
INSERT INTO `t_purchase_plan` VALUES ('3', 'sgasd', 'asdf', 'asdf', 'asdf', '2014-04-17', '401', '2014-04-17 01:22:52', 'admin', null, null);
