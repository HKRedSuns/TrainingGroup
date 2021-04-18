/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : teamproject

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2021-04-18 16:59:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for headimg
-- ----------------------------
DROP TABLE IF EXISTS `headimg`;
CREATE TABLE `headimg` (
  `img_ID` int(10) NOT NULL AUTO_INCREMENT,
  `img_Percorso` varchar(100) NOT NULL,
  PRIMARY KEY (`img_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of headimg
-- ----------------------------
INSERT INTO `headimg` VALUES ('1', '/img/HeadImg/a.png');
INSERT INTO `headimg` VALUES ('2', '/img/HeadImg/1.jpg');
INSERT INTO `headimg` VALUES ('3', '/img/HeadImg/2.jpg');
INSERT INTO `headimg` VALUES ('4', '/img/HeadImg/3.jpg');
INSERT INTO `headimg` VALUES ('5', '/img/HeadImg/4.jpg');
INSERT INTO `headimg` VALUES ('6', '/img/HeadImg/5.jpg');
INSERT INTO `headimg` VALUES ('7', '/img/HeadImg/6.jpg');
INSERT INTO `headimg` VALUES ('8', '/img/HeadImg/7.jpg');
INSERT INTO `headimg` VALUES ('9', '/img/HeadImg/8.jpg');
INSERT INTO `headimg` VALUES ('10', '/img/HeadImg/9.jpg');
INSERT INTO `headimg` VALUES ('11', '/img/HeadImg/10.jpg');
INSERT INTO `headimg` VALUES ('12', '/img/HeadImg/11.jpg');
INSERT INTO `headimg` VALUES ('13', '/img/HeadImg/12.jpg');
INSERT INTO `headimg` VALUES ('14', '/img/HeadImg/13.jpg');
INSERT INTO `headimg` VALUES ('15', '/img/HeadImg/14.jpg');
INSERT INTO `headimg` VALUES ('16', '/img/HeadImg/15.jpg');
INSERT INTO `headimg` VALUES ('17', '/img/HeadImg/16.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `regTime` datetime NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `headimg` int(20) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jaoden', '123123', '1835784566@qq.com', '2021-03-27 17:24:23', '1999-05-25 17:24:43', '22', '1');
