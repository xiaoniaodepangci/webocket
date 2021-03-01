/*
 Navicat Premium Data Transfer

 Source Server         : RDS
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-bp1e45u18p77qz3l7eo.mysql.rds.aliyuncs.com:3306
 Source Schema         : websocket-im

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 01/03/2021 16:17:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_msg
-- ----------------------------
DROP TABLE IF EXISTS `chat_msg`;
CREATE TABLE `chat_msg`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sender` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送者',
  `receiver` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接收者',
  `msg` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '消息实体',
  `sign_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接收标志',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_msg
-- ----------------------------
INSERT INTO `chat_msg` VALUES ('1358315109174534145', '1706101020', '1706101022', '111111111111', '0', NULL, NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358315116904636418', '1706101020', '1706101022', '111111111', '0', NULL, NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358608478928949250', '1706101020', '1706101022', '1', '0', '2021-02-08 10:47:58', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358608741790175233', '1706101020', '1706101022', '1', '0', '2021-02-08 10:49:00', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358611088067055617', '1706101020', '1706101022', '1', '0', '2021-02-08 10:58:20', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358611190378713089', '1706101020', '1706101022', '1', '0', '2021-02-08 10:58:44', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358611227427000322', '1706101020', '1706101022', '1', '0', '2021-02-08 10:58:53', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358613642373025794', '1706101020', '1706101022', '1123123', '0', '2021-02-08 11:08:29', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358613671405998082', '1706101020', '1706101022', '123123', '0', '2021-02-08 11:08:36', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358616034313293826', '1706101020', '1706101022', '123', '0', '2021-02-08 11:17:59', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358618260528222209', '1706101020', '1706101022', '123', '0', '2021-02-08 11:26:50', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358618338936541186', '1706101020', '1706101022', '1111111111111111111111111', '0', '2021-02-08 11:27:09', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358619100110442497', '1706101020', '1706101022', '11', '0', '2021-02-08 11:30:10', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358619287310618626', '1706101020', '1706101022', '2222', '0', '2021-02-08 11:30:55', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358619384249372674', '1706101020', '1706101022', '12331312312312312', '0', '2021-02-08 11:31:18', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358622923323396097', '1706101022', '1706101022', '1', '0', '2021-02-08 11:45:22', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358623384600367105', '1706101020', '1706101022', '12312312323', '0', '2021-02-08 11:47:12', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358623477642612737', '1706101020', '1706101022', '1', '0', '2021-02-08 11:47:34', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358623567098728450', '1706101020', '1706101022', '1111111111111', '0', '2021-02-08 11:47:55', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358623862071545857', '1706101020', '1706101022', '12312', '0', '2021-02-08 11:49:05', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358623912491274241', '1706101020', '1706101022', '111111111111', '0', '2021-02-08 11:49:17', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358623998986211329', '1706101022', '1706101022', '123123', '0', '2021-02-08 11:49:38', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358624077088346113', '1706101022', '1706101022', '231', '0', '2021-02-08 11:49:57', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358625103686193153', '1706101022', '1706101020', '123', '0', '2021-02-08 11:54:01', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358626848462131202', '1706101020', '1706101022', '123', '0', '2021-02-08 12:00:57', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358626892917559298', '1706101020', '1706101022', '123', '0', '2021-02-08 12:01:08', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358626919849185282', '1706101022', '1706101020', '123', '0', '2021-02-08 12:01:14', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358626984462438401', '1706101022', '1706101022', '1', '0', '2021-02-08 12:01:30', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358627494481416194', '1706101020', '1706101022', '123', '0', '2021-02-08 12:03:31', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358627527394119682', '1706101020', '1706101022', '111111111111111', '0', '2021-02-08 12:03:39', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358628617296596993', '1706101020', '1706101022', '1111', '0', '2021-02-08 12:07:59', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358628819730485249', '1706101020', '1706101022', '111', '0', '2021-02-08 12:08:47', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358628872599687169', '1706101022', '1706101020', '123', '0', '2021-02-08 12:09:00', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358633839918108674', '1706101020', '1706101022', '11', '0', '2021-02-08 12:28:44', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358633900311891969', '1706101022', '1706101020', '1231212311123123', '0', '2021-02-08 12:28:59', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358634333164064769', '1706101020', '1706101022', '123', '0', '2021-02-08 12:30:42', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358634397412413442', '1706101022', '1706101020', '123', '0', '2021-02-08 12:30:57', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1358634416731377666', '1706101022', '1706101020', '1111111111111111', '0', '2021-02-08 12:31:02', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362964820699381762', '1706101022', '1706101020', '请问', '0', '2021-02-20 11:18:31', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362965459030507521', '1706101022', '1706101020', '1', '0', '2021-02-20 11:21:03', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362966706445877249', '1706101022', '1706101020', '123213', '0', '2021-02-20 11:26:00', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362968076578193410', '1706101022', '1706101020', '111111', '0', '2021-02-20 11:31:27', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362968323727556610', '1706101022', '1706101020', '123213', '0', '2021-02-20 11:32:26', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362968347391819777', '1706101022', '1706101020', '啊啊啊', '0', '2021-02-20 11:32:31', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362968731011252225', '1706101022', '1706101020', '不不不不不', '0', '2021-02-20 11:34:03', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362968747012521985', '1706101022', '1706101020', '啊啊啊', '0', '2021-02-20 11:34:07', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362972614026592258', '1706101022', '1706101020', ' 阿斯达萨达撒', '0', '2021-02-20 11:49:29', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1362973153539915777', '1706101022', '1706101020', '去去去去去去去去去去去群群群', '0', '2021-02-20 11:51:37', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364853379010166786', '1706101020', '1706101021', '说的', '0', '2021-02-25 16:22:58', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364853381929402369', '1706101020', '1706101021', '', '0', '2021-02-25 16:22:59', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364853413957107714', '1706101020', '1706101021', '12', '0', '2021-02-25 16:23:06', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854558926602241', '1706101020', '1706101022', '阿斯达萨达', '0', '2021-02-25 16:27:39', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854567428456450', '1706101020', '1706101022', '阿斯达', '0', '2021-02-25 16:27:41', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854576580427778', '1706101020', '1706101022', ' 阿斯达', '0', '2021-02-25 16:27:43', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854582829940738', '1706101020', '1706101022', '阿斯达', '0', '2021-02-25 16:27:45', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854587183628290', '1706101020', '1706101022', '阿斯达', '0', '2021-02-25 16:27:46', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854592418119681', '1706101020', '1706101022', '阿斯达', '0', '2021-02-25 16:27:47', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854596947968002', '1706101020', '1706101022', '阿斯达', '0', '2021-02-25 16:27:48', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854601779806210', '1706101020', '1706101022', '阿斯达', '0', '2021-02-25 16:27:49', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1364854606443872258', '1706101020', '1706101022', '阿斯达', '0', '2021-02-25 16:27:51', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1366296736177639426', '1706101020', '1706101022', '1', '0', '2021-03-01 15:58:21', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1366298021656317954', '1706101020', '1706101022', '1', '0', '2021-03-01 16:03:28', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1366298141445640194', '1706101020', '1706101022', '1', '0', '2021-03-01 16:03:56', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1366298353174106113', '1706101020', '1706101022', '1', '0', '2021-03-01 16:04:47', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1366298546187587586', '1706101020', '1706101022', '1', '0', '2021-03-01 16:05:33', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1366298598566055937', '1706101022', '1706101020', '1', '0', '2021-03-01 16:05:45', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1366299089995878402', '1706101022', '1706101020', '1', '0', '2021-03-01 16:07:42', NULL, '0');
INSERT INTO `chat_msg` VALUES ('1366299284900990977', '1706101022', '1706101020', '1', '0', '2021-03-01 16:08:29', NULL, '0');

-- ----------------------------
-- Table structure for friends_request
-- ----------------------------
DROP TABLE IF EXISTS `friends_request`;
CREATE TABLE `friends_request`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求发送者',
  `receiver` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求接收者',
  `request_date_time` datetime(0) NULL DEFAULT NULL COMMENT '请求时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '本请求状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '好友请求' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friends_request
-- ----------------------------

-- ----------------------------
-- Table structure for my_friends
-- ----------------------------
DROP TABLE IF EXISTS `my_friends`;
CREATE TABLE `my_friends`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `my_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '本人id',
  `my_friend_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '朋友id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '好友关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_friends
-- ----------------------------
INSERT INTO `my_friends` VALUES ('1', '1', '2');
INSERT INTO `my_friends` VALUES ('2', '2', '1');
INSERT INTO `my_friends` VALUES ('3', '1', '3');
INSERT INTO `my_friends` VALUES ('4', '3', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '/test/per1');
INSERT INTO `permission` VALUES (2, '/test/per2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'role1');
INSERT INTO `role` VALUES ('2', 'role2');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `role_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `role_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名 即登录账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `profile` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1706101020', '5c4ff83a75ab2d35a60b63410f986ed3', 'user1', '../common/img/profile/4895636.jpg');
INSERT INTO `users` VALUES ('2', '1706101022', '5c4ff83a75ab2d35a60b63410f986ed3', 'user2', '../common/img/profile/56484253.jpg');
INSERT INTO `users` VALUES ('3', '1706101021', '5c4ff83a75ab2d35a60b63410f986ed3', 'user3', '../common/img/profile/552548669.jpg');

SET FOREIGN_KEY_CHECKS = 1;
