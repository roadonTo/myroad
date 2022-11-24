/*
 Navicat Premium Data Transfer

 Source Server         : MyProject
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : fruit

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 24/11/2022 07:44:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fruit
-- ----------------------------
DROP TABLE IF EXISTS `fruit`;
CREATE TABLE `fruit`  (
  `fid` int(10) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(10) NOT NULL,
  `fcount` int(10) NOT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fruit
-- ----------------------------
INSERT INTO `fruit` VALUES (2, '苹果', 125, 48, '好甜的哟');
INSERT INTO `fruit` VALUES (3, '西瓜', 30, 11, '谢谢你');

SET FOREIGN_KEY_CHECKS = 1;
