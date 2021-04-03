/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : teamproject

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2021-04-03 18:05:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `regTime` datetime NOT NULL,
  `phone` int(11) NOT NULL,
  `birthday` datetime NOT NULL,
  `age` int(11) NOT NULL,
  `headimg` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jaoden', '123123', '1835784566@qq.com', '2021-03-27 17:24:23', '1835784566', '1999-05-25 17:24:43', '22', 'null');
