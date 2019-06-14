# Host: localhost  (Version 5.5.15)
# Date: 2018-04-17 14:45:43
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "class"
#

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "class"
#

INSERT INTO `class` VALUES (67,'14级网络工程1班','1420551','2000-01-25'),(68,'14级网络工程2班','1420552',NULL);

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `classes` int(11) DEFAULT NULL,
  `politicalStatus` varchar(255) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `birthplace` varchar(255) DEFAULT NULL,
  `studentplace` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `idNum` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(255) DEFAULT NULL,
  `qqNum` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (4,'徐超凡','142055101','男','1995.11.10',67,'团员','汉','天津','天津市滨海新区','体育委员','120109199511000000','15383464198','867455720','','/1480576425048/142055101.png'),(5,'刘蕊','142055102','女','1995.09.26',67,'团员','汉','天津 ','天津市武清区 ','','120222199509000000','15364913207','1310204177','','/1480577699034/142055102.png'),(6,'刘丰玮','142055103','男','1995.05.27',67,'团员','汉','北京昌平','河北省廊坊市','班长','131026199505000000','15364913214','532330772','','/1480577843305/142055103.png'),(56,'张栋杰','142055105','男','1996.08.30',67,'团员','汉','山西晋城','山西省晋城市沁水县','','140521199608000000','15383465001','782299481','','/1480578093073/142055105.png'),(60,'王晨光','142055106','男','',67,'团员','汉','','','','','','','','/1480578130811/142055106.png'),(61,'吕泽林','142055107','男','',67,'','','','','','','','','','/1480578163826/142055107.png'),(62,'刘慧珠','142055108','女','',67,'','','','','','','','','','/1480578183202/142055108.png'),(63,'韩栋梁','142055109','男','',67,'','','','','','','','','','/1480578207912/142055109.png'),(64,'温波','142055110','男','',67,'','','','','','','','','','/1480578225677/142055110.png');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'zhangsheng','123',NULL);
