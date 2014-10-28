-- MySQL dump 10.11
--
-- Host: 127.0.0.1    Database: blog
-- ------------------------------------------------------
-- Server version	5.0.95

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_def_tag`
--

DROP TABLE IF EXISTS `t_def_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_def_tag` (
  `N_TAG_ID` int(11) NOT NULL auto_increment,
  `VC_TAG_NAME` varchar(128) default NULL,
  `DT_ADD_TAG_TIME` datetime default NULL,
  `DT_DEL_TAG_TIME` datetime default NULL,
  PRIMARY KEY  (`N_TAG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_def_tag`
--

LOCK TABLES `t_def_tag` WRITE;
/*!40000 ALTER TABLE `t_def_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_def_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_link`
--

DROP TABLE IF EXISTS `t_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_link` (
  `N_LINK_ID` int(11) NOT NULL auto_increment,
  `N_S_NODE_ID` int(11) default NULL,
  `N_E_NODE_ID` int(11) default NULL,
  `N_LINK_STYLE_ID` int(11) default NULL,
  `N_LINK_TYPE_ID` int(11) default NULL,
  `N_DEPT` int(11) default NULL,
  `DT_DEL_LINK_TIME` datetime default NULL,
  `DT_ADD_LINK_TIME` datetime default NULL,
  PRIMARY KEY  (`N_LINK_ID`),
  KEY `FK_Relationship_10` (`N_LINK_STYLE_ID`),
  KEY `FK_Relationship_3` (`N_LINK_TYPE_ID`),
  KEY `FK_Relationship_7` (`N_S_NODE_ID`),
  KEY `FK_Relationship_8` (`N_E_NODE_ID`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`N_LINK_STYLE_ID`) REFERENCES `t_link_style` (`N_LINK_STYLE_ID`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`N_LINK_TYPE_ID`) REFERENCES `t_link_type` (`N_LINK_TYPE_ID`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`N_S_NODE_ID`) REFERENCES `t_node` (`N_NODE_ID`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`N_E_NODE_ID`) REFERENCES `t_node` (`N_NODE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_link`
--

LOCK TABLES `t_link` WRITE;
/*!40000 ALTER TABLE `t_link` DISABLE KEYS */;
INSERT INTO `t_link` VALUES (4,9,10,4,9,0,NULL,'2013-12-24 23:31:17'),(9,9,16,4,9,-1,NULL,'2013-12-31 11:18:22'),(10,9,17,4,9,-1,NULL,'2014-01-13 20:00:41'),(12,9,18,4,9,-1,NULL,'2014-01-13 20:09:57'),(13,18,19,4,9,-1,NULL,'2014-01-13 20:23:09'),(14,16,20,4,9,-1,NULL,'2014-01-20 21:51:37'),(15,9,21,4,9,-1,'2014-01-23 16:50:09','2014-01-23 16:34:20'),(16,9,22,4,9,-1,'2014-01-29 14:23:09','2014-01-29 14:22:55'),(17,16,23,4,9,-1,NULL,'2014-01-29 16:02:57'),(18,18,24,4,9,-1,NULL,'2014-01-30 13:10:48'),(19,17,25,4,9,-1,NULL,'2014-02-26 13:22:00'),(20,25,26,4,9,-1,NULL,'2014-02-26 13:29:02'),(21,9,27,4,9,-1,'2014-09-17 19:42:13','2014-09-07 20:59:22');
/*!40000 ALTER TABLE `t_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_link_style`
--

DROP TABLE IF EXISTS `t_link_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_link_style` (
  `N_LINK_STYLE_ID` int(11) NOT NULL auto_increment,
  `VC_LINK_COLOR` varchar(128) default NULL,
  `N_LINK_WEIGHT` int(11) default NULL,
  `DT_LS_ADD_TIME` datetime default NULL,
  `DT_LS_DEL_TIME` datetime default NULL,
  PRIMARY KEY  (`N_LINK_STYLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_link_style`
--

LOCK TABLES `t_link_style` WRITE;
/*!40000 ALTER TABLE `t_link_style` DISABLE KEYS */;
INSERT INTO `t_link_style` VALUES (4,'#000000',1,'2013-12-24 23:31:17',NULL);
/*!40000 ALTER TABLE `t_link_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_link_type`
--

DROP TABLE IF EXISTS `t_link_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_link_type` (
  `N_LINK_TYPE_ID` int(11) NOT NULL auto_increment,
  `VC_LINK_NAME` varchar(128) default NULL,
  `VC_LINK_CODE` varchar(128) default NULL,
  `DT_DEL_LT_TIME` datetime default NULL,
  `DT_ADD_LT_TIME` datetime default NULL,
  PRIMARY KEY  (`N_LINK_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='1-上下级关系\r\n2-同级系列关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_link_type`
--

LOCK TABLES `t_link_type` WRITE;
/*!40000 ALTER TABLE `t_link_type` DISABLE KEYS */;
INSERT INTO `t_link_type` VALUES (9,'父子关系连接','parentAndChild',NULL,'2013-12-24 23:31:16');
/*!40000 ALTER TABLE `t_link_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_node`
--

DROP TABLE IF EXISTS `t_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_node` (
  `N_NODE_ID` int(11) NOT NULL auto_increment,
  `N_NODE_TYPE_ID` int(11) default NULL,
  `N_NODE_STYLE_ID` int(11) default NULL,
  `VC_NODE_NAME` varchar(128) default NULL,
  `N_RECORD_OR_CT_ID` int(11) default NULL,
  `DT_NODE_ADD_TIME` datetime default NULL,
  `DT_NODE_DEL_TIME` datetime default NULL,
  `VC_NODE_DESCRIPTION` varchar(128) default NULL,
  PRIMARY KEY  (`N_NODE_ID`),
  KEY `FK_Relationship_5` (`N_NODE_TYPE_ID`),
  KEY `FK_Relationship_6` (`N_NODE_STYLE_ID`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`N_NODE_TYPE_ID`) REFERENCES `t_node_type` (`N_NODE_TYPE_ID`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`N_NODE_STYLE_ID`) REFERENCES `t_node_style` (`N_NODE_STYLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_node`
--

LOCK TABLES `t_node` WRITE;
/*!40000 ALTER TABLE `t_node` DISABLE KEYS */;
INSERT INTO `t_node` VALUES (9,19,10,'根',NULL,'2013-12-24 23:31:16',NULL,'根节点'),(10,18,11,'登陆',NULL,'2013-12-24 23:31:16',NULL,'管理登陆'),(16,16,17,'关于',NULL,'2013-12-31 11:18:22',NULL,'关于我和网站'),(17,16,18,'资源',NULL,'2014-01-13 20:00:41',NULL,'分享资源'),(18,16,19,'API',NULL,'2014-01-13 20:07:04',NULL,'常用的API'),(19,16,20,'J2SE',NULL,'2014-01-13 20:23:09',NULL,'Java SE API'),(20,17,21,'关于我',4,'2014-01-20 21:51:37',NULL,'我的足迹'),(21,16,22,'测试',NULL,'2014-01-23 16:34:20',NULL,'测试ajax添加'),(22,16,23,'关于',NULL,'2014-01-29 14:22:55',NULL,'dsafdsfasdf'),(23,17,24,'关于网站',5,'2014-01-29 16:02:57',NULL,'网站开发技术'),(24,16,25,'Java EE',NULL,'2014-01-30 13:10:48',NULL,'java ee api'),(25,16,26,'办公工具',NULL,'2014-02-26 13:22:00',NULL,'办公软件、工具'),(26,17,27,'网址列表',6,'2014-02-26 13:29:02',NULL,'软件下载连接'),(27,16,28,'Evernote',NULL,'2014-09-07 20:59:22',NULL,'我的笔记');
/*!40000 ALTER TABLE `t_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_node_style`
--

DROP TABLE IF EXISTS `t_node_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_node_style` (
  `N_NODE_STYLE_ID` int(11) NOT NULL auto_increment,
  `VC_NODE_STYLE_NAME` varchar(128) default NULL,
  `N_STROKE_WEIGHT` int(11) default NULL,
  `VC_STROKE_COLOR` varchar(128) default NULL,
  `VC_FILL_COLOR` varchar(128) default NULL,
  `DA_IMG` varchar(128) default NULL,
  `N_IMG_HEIGHT` int(11) default NULL,
  `N_IMG_WIDTH` int(11) default NULL,
  `N_FONT_SIZE` int(11) default NULL,
  `N_R` int(11) default NULL,
  `VC_FONT_COLOR` varchar(128) default NULL,
  `DT_NODE_STYLE_ADD_TIME` datetime default NULL,
  `DT_NODE_STYLE_DEL_TIME` datetime default NULL,
  PRIMARY KEY  (`N_NODE_STYLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_node_style`
--

LOCK TABLES `t_node_style` WRITE;
/*!40000 ALTER TABLE `t_node_style` DISABLE KEYS */;
INSERT INTO `t_node_style` VALUES (10,'根节点样式',2,'#fa9800','#003366','images/navImgWithD3/key.ico',48,48,14,56,'#eeeeee','2013-12-24 23:31:16',NULL),(11,'11',2,'#fa9800','#001c35','images/navImgWithD3/key.ico',48,48,12,56,'#e3dddd','2013-12-24 23:31:16',NULL),(17,'17',2,'#fa9800','#eff3ff','images/common/user_88x93.ico',48,48,10,60,'#fa9800','2013-12-31 11:18:22',NULL),(18,'18',2,'#000000','#dd6666','images/navImgWithD3/backup.ico',48,48,12,60,'#003366','2014-01-13 20:00:41',NULL),(19,'19',2,'#1b1b1b','#eeee66','images/navImgWithD3/api.ico',48,48,12,60,'#000000','2014-01-13 20:07:04',NULL),(20,'20',2,'#1b1b1b','#eeee66','images/navImgWithD3/java_48.png',48,48,10,60,'#000000','2014-01-13 20:23:09',NULL),(21,'21',2,'#59f56e','#ffffff','images/navImgWithD3/personal.ico',56,56,10,55,'#781162','2014-01-20 21:51:37',NULL),(22,'',2,'#00ff22','#ff0000','images/navImgWithD3/api.ico',48,48,10,55,'#fff700','2014-01-23 16:34:20',NULL),(23,'',2,'#00ff22','#ff0000','images/navImgWithD3/plugin.ico',48,48,10,55,'#fff700','2014-01-29 14:22:55',NULL),(24,'24',2,'#fa9800','#eff3ff','images/navImgWithD3/web.ico',48,48,10,60,'#fa9800','2014-01-29 16:02:57',NULL),(25,'25',2,'#6b252d','#cccc99','images/navImgWithD3/java_48.png',48,48,10,60,'#111111','2014-01-30 13:10:48',NULL),(26,'26',2,'#cc9933','#336666','http://www.easyicon.net/api/resize_png_new.php?id=1110361&size=48',48,48,10,65,'#ffffcc','2014-02-26 13:22:00',NULL),(27,'27',2,'#cccc33','#336699','http://www.easyicon.net/api/resize_png_new.php?id=1116244&size=64',56,56,10,65,'#ffffff','2014-02-26 13:29:01',NULL),(28,'28',2,'#00ff22','#e7e2e2','images/enlogo.png',48,48,9,65,'#0d0d0c','2014-09-07 20:59:22',NULL);
/*!40000 ALTER TABLE `t_node_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_node_type`
--

DROP TABLE IF EXISTS `t_node_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_node_type` (
  `N_NODE_TYPE_ID` int(11) NOT NULL auto_increment,
  `VC_NODE_TYPE_CODE` varchar(128) default NULL,
  `VC_NODE_TYPE_NAME` varchar(128) default NULL,
  `VC_REF_TABLE_NAME` varchar(128) NOT NULL,
  `DT_ADD_NT_TIME` datetime default NULL,
  `DT_DEL_NT_TIME` datetime default NULL,
  PRIMARY KEY  (`N_NODE_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_node_type`
--

LOCK TABLES `t_node_type` WRITE;
/*!40000 ALTER TABLE `t_node_type` DISABLE KEYS */;
INSERT INTO `t_node_type` VALUES (16,'clazz','内容分类','','2013-12-24 23:31:16',NULL),(17,'leaf','记录','T_RECORD_ARTICLE','2013-12-24 23:31:16',NULL),(18,'manage','管理登陆','  ','2013-12-24 23:31:16',NULL),(19,'root','根节点',' ','2013-12-24 23:49:26',NULL);
/*!40000 ALTER TABLE `t_node_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_r_node_tag`
--

DROP TABLE IF EXISTS `t_r_node_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_r_node_tag` (
  `N_NODE_ID` int(11) NOT NULL,
  `N_TAG_ID` int(11) NOT NULL,
  PRIMARY KEY  (`N_NODE_ID`,`N_TAG_ID`),
  KEY `FK_t_r_node_tag2` (`N_TAG_ID`),
  CONSTRAINT `FK_t_r_node_tag` FOREIGN KEY (`N_NODE_ID`) REFERENCES `t_node` (`N_NODE_ID`),
  CONSTRAINT `FK_t_r_node_tag2` FOREIGN KEY (`N_TAG_ID`) REFERENCES `t_def_tag` (`N_TAG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_r_node_tag`
--

LOCK TABLES `t_r_node_tag` WRITE;
/*!40000 ALTER TABLE `t_r_node_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_r_node_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_record_content`
--

DROP TABLE IF EXISTS `t_record_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_record_content` (
  `N_RECORD_ID` int(11) NOT NULL auto_increment,
  `VC_RECORD_CONTENT` varchar(10240) default NULL,
  `VC_DOWNLOAD_URL` varchar(1024) default NULL,
  `VC_LINK_URL` varchar(1024) default NULL,
  `VC_INTRO` varchar(1024) default NULL,
  `VC_PREVIEW` varchar(1024) default NULL,
  `VC_ARTICLE_TITLE` varchar(128) default NULL,
  `VC_ARTICLE_SUBHEAD` varchar(128) default NULL,
  `DT_RECORD_ADD_TIME` datetime default NULL,
  `DT_RECORD_DEL_TIME` datetime default NULL,
  PRIMARY KEY  (`N_RECORD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_record_content`
--

LOCK TABLES `t_record_content` WRITE;
/*!40000 ALTER TABLE `t_record_content` DISABLE KEYS */;
INSERT INTO `t_record_content` VALUES (4,'<div><p style=\"margin-left:30px;\"><strong></strong><strong><img alt=\"key\" src=\"http://www.easyicon.net/api/resize_png_new.php?id=1108672&size=16\" />Java, Servlet, JSP, Struts 1&amp;2, MyBatis, jQuery  </strong><strong><em>深圳</em></strong></p><p style=\"margin-left:30px;\"><strong></strong></p><p><br /></p><p style=\"margin-left:30px;\"><img alt=\"rf\" src=\"http://www.easyicon.net/api/resize_png_new.php?id=1101942&size=16\" />运维监控项目(深圳)二期-机房动力及巡检开发 (2013.11-2014.07)</p><p style=\"margin-left:30px;\"><img alt=\"lf\" src=\"http://www.easyicon.net/api/resize_png_new.php?id=1101672&size=16\" />运维(成都) (2012.12-2013.10)</p><p style=\"margin-left:30px;\"><img alt=\"rf\" src=\"http://www.easyicon.net/api/resize_png_new.php?id=1101942&size=16\" />成都信息工程 软件工程 毕业 (2013.7)</p></div><div style=\"margin-left:30px;\"></div><p style=\"margin-left:30px;\"><strong></strong><img alt=\"lf\" src=\"http://www.easyicon.net/api/resize_png_new.php?id=1101672&size=16\" />DHCC(2012.12)</p><p style=\"margin-left:30px;\"><strong></strong><br /></p><p style=\"margin-left:30px;\"><strong></strong><br /></p><p><br /></p>','','http://weibo.com/swasantworker/','简历(resume)',NULL,'chendong','mail: cedoo@qq.com','2014-07-13 08:53:03',NULL),(5,'<ul><li><strong>D3.js (SVG)</strong></li><li><strong>Kendoui (HTML5 + CSS3)</strong></li><li><strong>struts 2</strong></li><li><strong>mybatis</strong></li></ul><p><strong></strong></p><p><strong>IE9+ Chrome Firefox Safari ..</strong></p>','','','html 5, css3, struts2',NULL,'网站信息','简介','2014-06-05 14:39:30',NULL),(6,'<ol><li><span style=\"color:#35383d;font-family:\'Microsoft YaHei\';font-size:14px;line-height:20px;\">ABBYY FineReader 11 ：</span><span style=\"color:#35383d;font-family:\'Microsoft YaHei\';font-size:14px;line-height:20px;\">一个好的Demo演示，可让老板对你刮目相看。</span>&nbsp;<a href=\"http://www.x-berry.com/abbyy-finereader-11/\" target=\"_blank\" title=\"打开\">传送</a></li><li><span style=\"color:#35383d;font-family:\'Microsoft YaHei\';font-size:14px;line-height:20px;\">Tanida Demo Builder ：老</span><span style=\"color:#35383d;font-family:\'Microsoft YaHei\';font-size:14px;line-height:20px;\">做图片文字转换成word的杂活，难道自己不能自己安装一个专门的ocr识别软件吗？ &nbsp;</span><a href=\"http://www.x-berry.com/tanida-demo-builder-v9\" target=\"_blank\" title=\"打开\">传送</a><br /><br /></li></ol>','','','我就是个工具控',NULL,'soft','ware','2014-02-26 13:45:54',NULL);
/*!40000 ALTER TABLE `t_record_content` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-14 20:11:10
