/*
Navicat MySQL Data Transfer

Source Server         : localhost_sxau
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2018-11-08 17:32:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `classify`
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify` (
  `id` int(11) NOT NULL,
  `name` char(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES ('1', '兰蔻');
INSERT INTO `classify` VALUES ('2', '娇兰');
INSERT INTO `classify` VALUES ('3', '雅诗兰黛');
INSERT INTO `classify` VALUES ('4', '台灯');
INSERT INTO `classify` VALUES ('5', '计算机组成原理的书');
INSERT INTO `classify` VALUES ('6', '课桌');

-- ----------------------------
-- Table structure for `cosmeticform`
-- ----------------------------
DROP TABLE IF EXISTS `cosmeticform`;
CREATE TABLE `cosmeticform` (
  `cosmetic_number` char(255) NOT NULL,
  `cosmetic_name` char(255) default NULL,
  `cosmetic_made` char(255) default NULL,
  `cosmetic_price` float default NULL,
  `cosmetic_mess` char(255) default NULL,
  `cosmetic_pic` char(255) default NULL,
  `id` int(11) default NULL,
  PRIMARY KEY  (`cosmetic_number`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of cosmeticform
-- ----------------------------
INSERT INTO `cosmeticform` VALUES ('Estee001', '雅诗兰黛眼霜', 'EsteeLauder', '389', '功效去黑眼圈', 'est1.jpg', '3');
INSERT INTO `cosmeticform` VALUES ('lan001', '兰蔻柔肤水', '法国LQ', '229', '净含量400g', 'lan1.jpg', '2');
INSERT INTO `cosmeticform` VALUES ('lan002', '兰蔻乳液', '法国LQ', '588', '乳液功效，补水保湿', 'lan2.jpg', '1');
INSERT INTO `cosmeticform` VALUES ('shu','计算机组成原理','中国制造','68','可以用来考研和学习新知识','shu.jpg','4');
INSERT INTO `cosmeticform` VALUES ('taideng','台灯','湖北制造','218','可以用来照亮的道路','taideng.jpg','5');
INSERT INTO `cosmeticform` VALUES ('zhuozi','书桌','武汉制造','424','可以用来给你放书等','kezhuo.jpg','6');


-- ----------------------------
-- Table structure for `orderform`
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `id` int(10) NOT NULL auto_increment,
  `logname` char(255) default NULL,
  `mess` char(255) default NULL,
  `sum` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of orderform
-- ----------------------------
INSERT INTO `orderform` VALUES ('1', 'zhang', '1:(lan001,兰蔻柔肤水,法国LQ,229.0)2:(lan002,兰蔻乳液,法国LQ,588.0)', '817');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `logname` char(255) NOT NULL,
  `password` char(255) default NULL,
  `phone` char(255) default NULL,
  `address` char(255) default NULL,
  `realname` char(255) default NULL,
  PRIMARY KEY  (`logname`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('ls', '456', null, null, null);
INSERT INTO `user` VALUES ('zhang', '123', '', '', '');
INSERT INTO `user` VALUES ('zs', '123', null, null, null);
