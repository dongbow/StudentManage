/*
Navicat MySQL Data Transfer
Source Host     : 115.159.148.205:3306
Source Database : studentmanager
Target Host     : 115.159.148.205:3306
Target Database : studentmanager
Date: 2016-06-24 15:41:41
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'Administrator', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuid` varchar(12) NOT NULL,
  `stuname` varchar(10) NOT NULL,
  `stusex` varchar(2) NOT NULL,
  `stuage` varchar(3) NOT NULL,
  `stuclass` varchar(20) NOT NULL,
  `stuaddress` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '10001', '李四', '男', '18', '计算机二班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('3', '10002', '王小花', '女', '17', '会计一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('4', '10003', '飞碟说', '男', '20', '测试一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('5', '10004', '李颖', '女', '18', '计算机一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('6', '10005', '赵六', '男', '19', '计算机一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('7', '10006', '张思德', '男', '19', '计算机一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('8', '10007', '小七', '女', '18', '会计一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('9', '10008', '笑吧', '男', '19', '计算机一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('10', '10009', '小酒', '男', '20', '工商管理二班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('11', '10010', '赵毅', '男', '20', '计算机一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('12', '10011', '孙思', '男', '19', '工商管理二班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('13', '10012', '测试', '男', '20', '计算机一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('14', '10013', '孙思', '女', '18', '工商管理二班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('15', '10014', '王乐', '男', '19', '会计一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('16', '10015', '惮烦', '男', '19', '计算机一班', '河南省某某市。。。');
INSERT INTO `student` VALUES ('19', '10016', '神武', '男', '18', '工商管理二班', '河南省某某市。。。');
