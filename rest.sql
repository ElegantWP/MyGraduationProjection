/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : rest

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-04-21 17:49:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', 'admin', 'admin', '2018-06-09 12:27:13', '1');

-- ----------------------------
-- Table structure for appoint
-- ----------------------------
DROP TABLE IF EXISTS `appoint`;
CREATE TABLE `appoint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `appointTime` time DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of appoint
-- ----------------------------
INSERT INTO `appoint` VALUES ('6', '张三', '13921831839', '4', '15:01:00', '陆鹏');

-- ----------------------------
-- Table structure for foods
-- ----------------------------
DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double(8,2) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT '0',
  `enName` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `tem` varchar(1000) DEFAULT NULL,
  `size` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of foods
-- ----------------------------
INSERT INTO `foods` VALUES ('1', '1', '白露粉莓', '13.00', 'http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65', '0', 'DEW BERRY POWDER', '1', '测试的简单描述', null, null);
INSERT INTO `foods` VALUES ('2', '1', '荔多多', '9.00', 'http://itheimawang.cn/ac24d3b0-2987-4f02-aefb-964048b7ea26', '0', 'A LOT OF LITCHI', '1', '', null, null);
INSERT INTO `foods` VALUES ('4', '2', '多莓奶冰', '16.00', 'http://itheimawang.cn/038bfc79-00d6-4d7f-83d0-d4e0a8ffa5f3', '0', 'MIXED CRANBERRY SMOOTHIE', '1', '', null, null);
INSERT INTO `foods` VALUES ('5', '2', '泰冰冰', '17.00', 'http://itheimawang.cn/d14dc57c-ece7-4770-8082-7508fb49d715', '0', 'THAILAND SMOOTHIES', '1', '', null, null);
INSERT INTO `foods` VALUES ('6', '2', '泰妃', '20.00', '3', '0', 'TOFFEE', '1', null, null, null);
INSERT INTO `foods` VALUES ('7', '3', '大皇宫7号', '25.00', '1', '0', 'IMPERIAL PALACE NO.7', '1', null, null, null);
INSERT INTO `foods` VALUES ('8', '3', '蛋糕抹茶', '26.00', '2', '0', 'MATCHA CAKE', '1', null, null, null);
INSERT INTO `foods` VALUES ('9', '3', '泰多多', '20.00', '3', '0', 'THAILAND MORE', '1', null, null, null);
INSERT INTO `foods` VALUES ('10', '3', '泰红', '22.00', '4', '0', 'THAILAND BLACK TEA', '1', null, null, null);
INSERT INTO `foods` VALUES ('11', '3', '泰绿', '23.00', '5', '0', 'THAILAND GREEN', '1', null, null, null);
INSERT INTO `foods` VALUES ('12', '4', '榴莲咖啡', '18.00', '1', '0', 'DURIAN COFFEE', '1', null, null, null);
INSERT INTO `foods` VALUES ('13', '4', '象山拿铁', '19.00', '2', '0', 'ELEPHANT MOUNTAIN LATTE', '1', null, null, null);
INSERT INTO `foods` VALUES ('14', '5', '冬阴功', '30.00', '1', '0', 'TOM YUN GOONG', '1', null, null, null);
INSERT INTO `foods` VALUES ('15', '5', '绿松石可可', '16.00', '2', '0', 'TURQUOISE COCOA', '1', null, null, null);
INSERT INTO `foods` VALUES ('16', '5', '泰榴莲', '21.00', '3', '0', 'THAILAND DURIAN', '1', null, null, null);
INSERT INTO `foods` VALUES ('17', '5', '泰芒', '24.00', '4', '0', 'THAILAND MANGO', '1', null, null, null);
INSERT INTO `foods` VALUES ('18', '6', '粉色抹茶', '18.00', '1', '0', 'PINK MATCHA', '1', null, null, null);
INSERT INTO `foods` VALUES ('19', '6', '木炭奈铁', '17.00', '2', '0', 'CHARCOAL LATTE', '1', null, null, null);
INSERT INTO `foods` VALUES ('20', '6', '宇治奈铁', '20.00', '3', '0', 'MATCHA LATTE', '1', null, null, null);
INSERT INTO `foods` VALUES ('21', '6', '芋香草莓', '21.00', '4', '0', 'PEARL COLOCASIA', '1', null, null, null);
INSERT INTO `foods` VALUES ('22', '6', '脏脏抹茶', '22.00', '5', '0', 'VOGUE EATCHA', '1', null, null, null);
INSERT INTO `foods` VALUES ('23', '7', '象丸黑糖', '15.00', '1', '0', 'PEARL BROWN SUGAR', '1', null, '', '');
INSERT INTO `foods` VALUES ('24', '7', '象丸可可', '15.00', '2', '0', 'PEARL COCOA', '1', '广告宣传语可以输入十四个字字', '', '');
INSERT INTO `foods` VALUES ('25', '7', '象丸抹茶', '15.00', '3', '0', 'PEARL MATCHA', '1', null, '', '');
INSERT INTO `foods` VALUES ('26', '7', '象丸芋香', '15.00', '4', '0', 'PEARL COLOCASIA', '1', '象丸＋芋香', '', '');
INSERT INTO `foods` VALUES ('27', '8', '薄脆', '3.00', '1', '0', 'undefined', '1', null, null, null);
INSERT INTO `foods` VALUES ('28', '8', '绿珍珠', '2.00', '2', '0', 'undefined', '1', null, null, null);
INSERT INTO `foods` VALUES ('29', '8', '黑糯米', '2.00', '3', '0', 'undefined', '1', null, null, null);
INSERT INTO `foods` VALUES ('30', '8', '绿珍珠', '2.00', '4', '0', 'undefined', '1', null, null, null);
INSERT INTO `foods` VALUES ('31', '8', '花生蛋糕酱', '3.00', '5', '0', 'undefined', '1', null, null, null);
INSERT INTO `foods` VALUES ('32', '8', '西米', '2.00', '6', '0', 'undefined', '1', null, null, null);
INSERT INTO `foods` VALUES ('33', '8', '桃胶', '2.00', '7', '0', 'undefined', '1', null, null, null);
INSERT INTO `foods` VALUES ('37', '8', '测试数据', '9.90', '2', '0', null, '1', null, null, null);
INSERT INTO `foods` VALUES ('38', '3', '倾城', '20.00', 'http://itheimawang.cn/991a9c6b-087a-4468-89f2-9e05c0d8b604', '0', 'wae', '1', 'hgjhg', null, null);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '泰潮系列');
INSERT INTO `menu` VALUES ('2', '泰高冷系列');
INSERT INTO `menu` VALUES ('3', '泰好喝系列');
INSERT INTO `menu` VALUES ('4', '泰咖系列');
INSERT INTO `menu` VALUES ('5', '泰特别系列');
INSERT INTO `menu` VALUES ('6', '泰炫彩系列');
INSERT INTO `menu` VALUES ('7', '象丸系列');
INSERT INTO `menu` VALUES ('8', '测试队列');

-- ----------------------------
-- Table structure for mycut
-- ----------------------------
DROP TABLE IF EXISTS `mycut`;
CREATE TABLE `mycut` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(40) DEFAULT NULL,
  `reduction` int(10) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0表示未使用 1表示已经使用',
  `getTime` datetime DEFAULT NULL,
  `useTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mycut
-- ----------------------------
INSERT INTO `mycut` VALUES ('83', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '19', '1', '2019-04-12 12:24:38', '2019-04-13 14:42:55');
INSERT INTO `mycut` VALUES ('84', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '18', '0', '2019-04-12 12:24:48', null);
INSERT INTO `mycut` VALUES ('85', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '17', '0', '2019-04-12 12:24:50', null);
INSERT INTO `mycut` VALUES ('86', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '16', '0', '2019-04-12 12:24:52', null);
INSERT INTO `mycut` VALUES ('87', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '15', '1', '2019-04-12 12:24:54', '2019-04-16 20:18:43');
INSERT INTO `mycut` VALUES ('88', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '20', '0', '2019-04-20 13:24:41', null);
INSERT INTO `mycut` VALUES ('89', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '14', '0', '2019-04-20 13:24:43', null);
INSERT INTO `mycut` VALUES ('90', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '2', '0', '2019-04-20 13:24:45', null);
INSERT INTO `mycut` VALUES ('91', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '1', '0', '2019-04-20 13:24:46', null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(255) DEFAULT NULL,
  `sumMoney` double(8,2) DEFAULT NULL,
  `cupNumber` int(11) DEFAULT NULL,
  `cartList` varchar(2000) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `orderId` varchar(255) DEFAULT NULL,
  `cathNumber` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `appointTime` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `disTime` datetime DEFAULT NULL,
  `cutMoney` double(8,2) DEFAULT NULL,
  `packages` varchar(1000) DEFAULT NULL,
  `cutText` varchar(200) DEFAULT NULL,
  `note` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('139', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '24.90', '3', '[{\"number\":1,\"img\":\"1-1\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-3\",\"cType\":7,\"price\":2.0,\"cIndex\":2,\"enName\":\"undefined\",\"name\":\"黑糯米\",\"sum\":2.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-2\",\"cType\":7,\"price\":9.9,\"cIndex\":7,\"name\":\"测试数据\",\"sum\":9.9,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-05 09:18:36', '4551748715355701', 'NWU002', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', '多加点糖');
INSERT INTO `order` VALUES ('140', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '34.90', '3', '[{\"number\":1,\"img\":\"1-1\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-2\",\"cType\":7,\"price\":9.9,\"cIndex\":7,\"name\":\"测试数据\",\"sum\":9.9,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-05 09:23:05', '6551748984519347', 'NWU003', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', '我喜欢热的');
INSERT INTO `order` VALUES ('141', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '25.00', '2', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-06 09:21:56', '7551835315546091', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', '甜甜的会不错哟');
INSERT INTO `order` VALUES ('142', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '22.90', '2', '[{\"number\":1,\"img\":\"1-1\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-2\",\"cType\":7,\"price\":9.9,\"cIndex\":7,\"name\":\"测试数据\",\"sum\":9.9,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-06 09:35:42', '5551836141598616', 'NWU002', '1', '10:30', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('143', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '30.90', '3', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-2\",\"cType\":7,\"price\":9.9,\"cIndex\":7,\"name\":\"测试数据\",\"sum\":9.9,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-06 09:38:53', '6551836332537996', 'NWU003', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('144', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '29.90', '3', '[{\"number\":1,\"img\":\"1-1\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-2\",\"cType\":7,\"price\":9.9,\"cIndex\":7,\"name\":\"测试数据\",\"sum\":9.9,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-14 10:30:52', '4552530651245117', 'NWU001', '0', '', '2', null, '5.00', '872929748b4110d40700673305', '满30元立减5元', null);
INSERT INTO `order` VALUES ('145', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '29.90', '3', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-2\",\"cType\":7,\"price\":9.9,\"cIndex\":7,\"name\":\"测试数据\",\"sum\":9.9,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-14 10:35:20', '6552530920004930', 'NWU002', '0', '', '1', null, '5.00', '872929748b4110d40700673305', '满30元立减5元', null);
INSERT INTO `order` VALUES ('146', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '34.90', '3', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-2\",\"cType\":7,\"price\":9.9,\"cIndex\":7,\"name\":\"测试数据\",\"sum\":9.9,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-14 10:59:23', '2552532362724896', 'NWU003', '0', '', '1', null, '3.00', '872929748b4110d40700673305', '满20元立减3元', null);
INSERT INTO `order` VALUES ('147', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '34.00', '3', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-14 11:00:56', '3552532455821666', 'NWU004', '0', '', '1', null, '3.00', '872929748b4110d40700673305', '满20元立减3元', null);
INSERT INTO `order` VALUES ('148', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '48.90', '5', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-2\",\"cType\":7,\"price\":9.9,\"cIndex\":7,\"name\":\"测试数据\",\"sum\":9.9,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-6\",\"cType\":7,\"price\":2.0,\"cIndex\":5,\"enName\":\"undefined\",\"name\":\"西米\",\"sum\":2.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"8-5\",\"cType\":7,\"price\":3.0,\"cIndex\":4,\"enName\":\"undefined\",\"name\":\"花生蛋糕酱\",\"sum\":3.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"5-1\",\"cType\":4,\"price\":30.0,\"cIndex\":0,\"enName\":\"TOM YUN GOONG\",\"name\":\"冬阴功\",\"sum\":30.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-14 14:05:30', '6552543529631281', 'NWU005', '0', '', '1', null, '5.00', '872929748b4110d40700673305', '满30元立减5元', null);
INSERT INTO `order` VALUES ('149', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '46.00', '2', '[{\"number\":1,\"img\":\"3-4\",\"cType\":2,\"price\":22.0,\"cIndex\":3,\"enName\":\"THAILAND BLACK TEA\",\"name\":\"泰红\",\"sum\":22.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"5-4\",\"cType\":4,\"price\":24.0,\"cIndex\":3,\"enName\":\"THAILAND MANGO\",\"name\":\"泰芒\",\"sum\":24.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-19 10:05:30', '5552961129443492', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', '我是在测试备注操作');
INSERT INTO `order` VALUES ('150', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '15.00', '1', '[{\"number\":1,\"img\":\"7-4\",\"cType\":6,\"price\":15.0,\"cIndex\":3,\"enName\":\"PEARL COLOCASIA\",\"name\":\"象丸芋香\",\"sum\":15.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"象丸＋芋香\"}]', '2019-03-19 10:16:56', '3552961815804106', 'NWU002', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('151', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '42.00', '2', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"5-1\",\"cType\":4,\"price\":30.0,\"cIndex\":0,\"enName\":\"TOM YUN GOONG\",\"name\":\"冬阴功\",\"sum\":30.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 10:11:55', '8553220714616822', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('152', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '47.00', '3', '[{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-2\",\"cType\":1,\"price\":17.0,\"cIndex\":1,\"enName\":\"THAILAND SMOOTHIES\",\"name\":\"泰冰冰\",\"sum\":17.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-3\",\"cType\":1,\"price\":20.0,\"cIndex\":2,\"enName\":\"TOFFEE\",\"name\":\"泰妃\",\"sum\":20.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 10:17:02', '7553221022112775', 'NWU002', '0', '', '1', null, '6.00', '872929748b4110d40700673305', '满20元立减6元', null);
INSERT INTO `order` VALUES ('153', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '46.00', '3', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-2\",\"cType\":1,\"price\":17.0,\"cIndex\":1,\"enName\":\"THAILAND SMOOTHIES\",\"name\":\"泰冰冰\",\"sum\":17.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-3\",\"cType\":1,\"price\":20.0,\"cIndex\":2,\"enName\":\"TOFFEE\",\"name\":\"泰妃\",\"sum\":20.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 10:21:29', '2553221289105701', 'NWU003', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('154', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '45.00', '3', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"2-2\",\"cType\":1,\"price\":17.0,\"cIndex\":1,\"enName\":\"THAILAND SMOOTHIES\",\"name\":\"泰冰冰\",\"sum\":17.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 10:25:17', '8553221516725908', 'NWU004', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('155', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 10:54:36', '2553223275902683', 'NWU005', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('156', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 10:56:32', '6553223392156220', 'NWU006', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('157', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 11:11:01', '1553224260846120', 'NWU007', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('158', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '16.00', '1', '[{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 11:16:26', '4553224585805709', 'NWU008', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('159', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 11:21:08', '6553224867776411', 'NWU009', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('160', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 11:22:23', '7553224943225912', 'NWU010', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('161', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '16.00', '1', '[{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 11:23:01', '5553224980967323', 'NWU011', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('162', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-22 11:28:44', '0553225324194595', 'NWU012', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('163', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 12:48:01', '5553662080567347', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('164', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 13:53:45', '5553666024974755', 'NWU002', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('165', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '9.00', '1', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 14:11:53', '8553667112202982', 'NWU003', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('166', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '9.00', '1', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 14:39:23', '3553668762413194', 'NWU004', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('167', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 14:41:49', '3553668908417197', 'NWU005', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('168', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '9.00', '1', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 14:47:53', '5553669273130911', 'NWU006', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('169', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '9.00', '1', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 15:17:24', '5553671043495275', 'NWU007', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('170', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '9.00', '1', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 15:35:02', '7553672101701481', 'NWU008', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('171', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '16.00', '1', '[{\"number\":1,\"img\":\"2-1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 15:39:46', '7553672386125905', 'NWU009', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('172', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '9.00', '1', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 15:47:10', '1553672830002782', 'NWU010', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('173', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 15:48:04', '2553672883658438', 'NWU011', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('174', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '12.00', '1', '[{\"number\":1,\"img\":\"1-3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 15:49:46', '1553672985599379', 'NWU012', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('175', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '9.00', '1', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-27 19:43:57', '2553687036390176', 'NWU013', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('176', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '9.00', '1', '[{\"number\":1,\"img\":\"1-2\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-28 15:20:16', '5553757615568411', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('177', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '52.00', '2', '[{\"number\":1,\"img\":\"3-4\",\"cType\":2,\"price\":22.0,\"cIndex\":3,\"enName\":\"THAILAND BLACK TEA\",\"name\":\"泰红\",\"sum\":22.0,\"detail\":\"常规,+正常糖+常规\"},{\"number\":1,\"img\":\"5-1\",\"cType\":4,\"price\":30.0,\"cIndex\":0,\"enName\":\"TOM YUN GOONG\",\"name\":\"冬阴功\",\"sum\":30.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-03-29 16:14:00', '3553847239966290', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('178', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '20.00', '1', '[{\"number\":1,\"img\":\"http://itheimawang.cn/991a9c6b-087a-4468-89f2-9e05c0d8b604\",\"cType\":2,\"price\":20.0,\"cIndex\":5,\"enName\":\"wae\",\"name\":\"倾城\",\"sum\":20.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"hgjhg\"}]', '2019-03-29 16:21:16', '9553847675739062', 'NWU002', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('179', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '20.00', '1', '[{\"number\":1,\"img\":\"http://itheimawang.cn/991a9c6b-087a-4468-89f2-9e05c0d8b604\",\"cType\":2,\"price\":20.0,\"cIndex\":5,\"enName\":\"wae\",\"name\":\"倾城\",\"sum\":20.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"hgjhg\"}]', '2019-03-29 16:28:55', '9553848135020343', 'NWU003', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('180', 'osoJK5E2-ZDVdN3Dg8hb3SOq_hT4', '13.00', '1', '[{\"number\":1,\"img\":\"1\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+少糖+常规\"}]', '2019-04-08 20:55:36', '0554728135973729', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('181', 'osoJK5E2-ZDVdN3Dg8hb3SOq_hT4', '12.00', '1', '[{\"number\":1,\"img\":\"3\",\"cType\":0,\"price\":12.0,\"cIndex\":2,\"enName\":\"THAILAND ADORABLE\",\"name\":\"泰萌\",\"sum\":12.0,\"detail\":\"常规,+少糖+常规\"}]', '2019-04-08 21:07:31', '0554728850695965', 'NWU002', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('182', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '16.00', '1', '[{\"number\":1,\"img\":\"1\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\"}]', '2019-04-12 12:21:03', '4555042862214789', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('183', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '16.00', '2', '[{\"number\":1,\"img\":\"http://itheimawang.cn/a4102a1b-2e91-48ea-98e9-adf8e3efbe18\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"},{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"}]', '2019-04-13 14:42:54', '4555137773781231', 'NWU001', '1', '3:30', '1', null, '6.00', '872929748b4110d40700673305', '满20元立减6元', null);
INSERT INTO `order` VALUES ('184', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '22.00', '2', '[{\"number\":1,\"img\":\"http://itheimawang.cn/a4102a1b-2e91-48ea-98e9-adf8e3efbe18\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"},{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"}]', '2019-04-13 15:14:06', '0555139646192341', 'NWU002', '1', '17:50', '2', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('185', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '16.00', '1', '[{\"number\":1,\"img\":\"http://itheimawang.cn/038bfc79-00d6-4d7f-83d0-d4e0a8ffa5f3\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"}]', '2019-04-16 18:14:08', '9555409647594388', 'NWU001', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('186', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '13.00', '1', '[{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"}]', '2019-04-16 18:30:24', '7555410623607620', 'NWU002', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('187', 'osoJK5CZCdHprIdCom6WmUPTeet0', '22.00', '2', '[{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"},{\"number\":1,\"img\":\"http://itheimawang.cn/a4102a1b-2e91-48ea-98e9-adf8e3efbe18\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"}]', '2019-04-16 18:34:48', '3555410888066577', 'NWU003', '0', '', '1', null, '0.00', '872929748b4110d40700673305', '', null);
INSERT INTO `order` VALUES ('188', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '16.00', '1', '[{\"number\":1,\"img\":\"http://itheimawang.cn/038bfc79-00d6-4d7f-83d0-d4e0a8ffa5f3\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"}]', '2019-04-16 19:35:21', '0555414520518761', 'NWU004', '0', '', '2', null, '0.00', '315c4c9ee7f0b8b37d641c4b6717581e', '', null);
INSERT INTO `order` VALUES ('189', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '26.00', '2', '[{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"},{\"number\":1,\"img\":\"http://itheimawang.cn/038bfc79-00d6-4d7f-83d0-d4e0a8ffa5f3\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"}]', '2019-04-16 20:18:42', '2555417121420930', 'NWU005', '0', '', '2', null, '3.00', '5bf0aee0d9de4095e87d5a5c54dc2224', '满22元立减3元', null);
INSERT INTO `order` VALUES ('190', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '38.00', '3', '[{\"number\":1,\"img\":\"http://itheimawang.cn/a4102a1b-2e91-48ea-98e9-adf8e3efbe18\",\"cType\":0,\"price\":9.0,\"cIndex\":1,\"enName\":\"A LOT OF LITCHI\",\"name\":\"荔多多\",\"sum\":9.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"},{\"number\":1,\"img\":\"http://itheimawang.cn/038bfc79-00d6-4d7f-83d0-d4e0a8ffa5f3\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"},{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"}]', '2019-04-16 23:37:55', '9555429074338194', 'NWU006', '1', '8:20', '2', null, '0.00', 'bcd4db893609ed99a439aa3a53c07f8d', '', null);
INSERT INTO `order` VALUES ('191', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '29.00', '2', '[{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"},{\"number\":1,\"img\":\"http://itheimawang.cn/038bfc79-00d6-4d7f-83d0-d4e0a8ffa5f3\",\"cType\":1,\"price\":16.0,\"cIndex\":0,\"enName\":\"MIXED CRANBERRY SMOOTHIE\",\"name\":\"多莓奶冰\",\"sum\":16.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"\"}]', '2019-04-16 23:53:33', '5555430012251312', 'NWU007', '1', '8:20', '2', null, '0.00', '25daf0787525905aaa5d750bc1257191', '', '我要测试这个note标签');
INSERT INTO `order` VALUES ('192', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '13.00', '1', '[{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"}]', '2019-04-18 23:20:30', '3555600829603134', 'NWU001', '1', '8:20', '2', null, '0.00', '5e96b63cf35f16d8fd77214760691a20', '', 'o');
INSERT INTO `order` VALUES ('193', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '13.00', '1', '[{\"number\":1,\"img\":\"http://itheimawang.cn/53f9c099-7673-47f2-94a8-224374530f65\",\"cType\":0,\"price\":13.0,\"cIndex\":0,\"enName\":\"DEW BERRY POWDER\",\"name\":\"白露粉莓\",\"sum\":13.0,\"detail\":\"常规,+正常糖+常规\",\"desc\":\"测试的简单描述\"}]', '2019-04-21 15:25:56', '5555831555350916', 'NWU001', '0', '', '1', null, '0.00', 'the formId is a mock one', '', null);

-- ----------------------------
-- Table structure for reduction
-- ----------------------------
DROP TABLE IF EXISTS `reduction`;
CREATE TABLE `reduction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `typeDes` varchar(255) DEFAULT NULL,
  `rule` int(11) DEFAULT NULL,
  `cut` int(11) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of reduction
-- ----------------------------
INSERT INTO `reduction` VALUES ('1', '1', '全场满减券', '20', '3', '2018-05-21 00:00:00', '2019-05-03 00:00:00', '1', 'http://cdn.handsomebird.xin/1526893482285');
INSERT INTO `reduction` VALUES ('2', '2', '象丸可可单品券', '24', '3', '2018-05-21 00:00:00', '2019-05-09 00:00:00', '1', 'http://cdn.handsomebird.xin/1526893482285');
INSERT INTO `reduction` VALUES ('14', '1', '满30减5块', '30', '5', '2018-06-14 00:00:00', '2019-05-01 00:00:00', '1', '');
INSERT INTO `reduction` VALUES ('15', '1', '密码', '22', '3', '2018-06-14 00:00:00', '2019-05-01 00:00:00', '1', '');
INSERT INTO `reduction` VALUES ('16', '2', '科技', '22', '5', '2018-06-14 00:00:00', '2019-05-01 00:00:00', '1', 'undefined');
INSERT INTO `reduction` VALUES ('17', '2', '测试优惠券信息', '23', '2', '2018-06-14 00:00:00', '2019-04-01 00:00:00', '1', '');
INSERT INTO `reduction` VALUES ('18', '2', '测试', '20', '3', '2018-06-21 00:00:00', '2019-04-01 00:00:00', '1', '');
INSERT INTO `reduction` VALUES ('19', '1', '满减卷我是刚刚测试', '20', '6', '2019-03-11 20:39:43', '2019-04-01 00:00:00', '1', '');
INSERT INTO `reduction` VALUES ('20', '1', '这是我商家发布的最新的优惠券的信息  请立即查看', '20', '5', '2019-04-18 00:00:00', '2019-05-31 00:00:00', '1', null);

-- ----------------------------
-- Table structure for shoptime
-- ----------------------------
DROP TABLE IF EXISTS `shoptime`;
CREATE TABLE `shoptime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open` int(11) DEFAULT NULL,
  `close` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shoptime
-- ----------------------------
INSERT INTO `shoptime` VALUES ('1', '8', '22');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(255) DEFAULT NULL,
  `avatarUrl` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `root` int(11) DEFAULT NULL,
  `resum` double(8,2) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `gender` int(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `openId` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_loginTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('21', 'এ᭄゛primary', 'https://wx.qlogo.cn/mmopen/vi_32/IR5xyTwib2icgDU3NdG9MhN2kiaZfIia7SlJywkLranfHIDic15Jh9Ju2mdZ7cBflen1dV0d6Bum7OibGq11h2no8OnQ/132', null, '0', '0', '1708.00', 'Shaanxi', '1', 'Xi\'an', 'osoJK5J0DQhwKgRgbRdBYQlUbpjA', '2019-02-22 13:58:54', '2019-04-21 15:24:54', null);
INSERT INTO `user` VALUES ('22', '倾城', 'http://itheimawang.cn/991a9c6b-087a-4468-89f2-9e05c0d8b604', null, '0', '0', '342.00', 'Shaanxi', '0', 'Xi\'an', null, '2019-03-06 09:13:42', '2019-03-06 09:13:42', null);
INSERT INTO `user` VALUES ('23', 'Primrose', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIxEuD0ytJhQRbAC6UeLqGibg7cGKo0gpzQPBRyFXc6NQ88yxT0YvILjs3aVGuS5IZdw84r2MPAvgg/132', null, '0', '0', '25.00', 'Liaoning', '2', 'Shenyang', 'osoJK5E2-ZDVdN3Dg8hb3SOq_hT4', '2019-04-08 20:54:59', '2019-04-08 20:54:59', null);
INSERT INTO `user` VALUES ('24', '嚯嚯嚯', 'https://wx.qlogo.cn/mmopen/vi_32/GF7Z6rWENFnHda0Zgpd4AWTLbdkxicw5OeibeiaFY2zaGicIPic1qx8hBLNokNBPW4ic2tGa7SFaZ09PxqPwDK6mcQ8A/132', null, '0', '0', '22.00', 'Shaanxi', '1', 'Xi\'an', 'osoJK5CZCdHprIdCom6WmUPTeet0', '2019-04-16 18:34:02', '2019-04-16 18:34:02', null);
