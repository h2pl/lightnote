/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2016-04-26 11:22:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(4) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'admin', '123456', null);
INSERT INTO user VALUES ('2', 'abc', 'aaa,', null);
INSERT INTO user VALUES ('3', 'bbb', 'bbb', null);
