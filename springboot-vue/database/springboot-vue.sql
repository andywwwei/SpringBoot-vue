/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : springboot-vue

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 03/07/2019 08:46:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `user_birthday` datetime(0) NOT NULL COMMENT '出生日期',
  `user_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '居住地址',
  `user_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `user_role` int(11) NULL DEFAULT NULL COMMENT '用户角色:1.管理员,2.普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '秦始皇', '2000-01-01 00:00:00', '赵国邯郸', '110', 1);
INSERT INTO `sys_user` VALUES (2, '汉武帝', '2001-01-01 00:00:00', '长安未央宫猗兰殿', '119', 2);
INSERT INTO `sys_user` VALUES (3, '汉光武帝', '2002-01-01 00:00:00', '陈留郡济阳县济阳宫', '120', 2);
INSERT INTO `sys_user` VALUES (4, '唐太宗', '2003-01-01 00:00:00', '陇西成纪', '122', 2);
INSERT INTO `sys_user` VALUES (5, '唐玄宗', '2004-01-01 00:00:00', '东都洛阳', '95119', 2);
INSERT INTO `sys_user` VALUES (6, '宋太祖', '2005-01-01 00:00:00', '洛阳夹马营', '12358', 2);
INSERT INTO `sys_user` VALUES (7, '成吉思汗', '2006-01-01 00:00:00', '漠北', '12315', 2);
INSERT INTO `sys_user` VALUES (8, '漠北', '2007-01-01 00:00:00', '四川绵阳江油', '12306', 2);
INSERT INTO `sys_user` VALUES (9, '杜甫', '2007-12-31 08:00:00', '湖北襄阳', '010-62752114', 1);

SET FOREIGN_KEY_CHECKS = 1;
