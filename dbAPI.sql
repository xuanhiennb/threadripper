/*
SQLyog Ultimate v11.3 (64 bit)
MySQL - 10.3.15-MariaDB : Database - threadripper
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`threadripper` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `threadripper`;

/*Table structure for table `avatar` */

DROP TABLE IF EXISTS `avatar`;

CREATE TABLE `avatar` (
  `avatar_id` int(11) NOT NULL AUTO_INCREMENT,
  `avatarUrl` varchar(300) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`avatar_id`),
  KEY `fk_username_idx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Table structure for table `conversation` */

DROP TABLE IF EXISTS `conversation`;

CREATE TABLE `conversation` (
  `conversationId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `readMessageId` int(11) DEFAULT 0,
  PRIMARY KEY (`conversationId`,`username`),
  CONSTRAINT `fk_convIdToConvIdSet` FOREIGN KEY (`conversationId`) REFERENCES `conversation_setting` (`conversationid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Table structure for table `conversation_setting` */

DROP TABLE IF EXISTS `conversation_setting`;

CREATE TABLE `conversation_setting` (
  `conversationId` int(11) NOT NULL AUTO_INCREMENT,
  `conversationName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`conversationId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `datetime` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `image` */

DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
  `imageId` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(50) DEFAULT NULL,
  `datetime` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`imageId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `conversationId` int(11) DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `datetime` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`messageId`),
  KEY `fk_convIdToConvId_idx` (`conversationId`),
  CONSTRAINT `fk_convIdToConvId` FOREIGN KEY (`conversationId`) REFERENCES `conversation_setting` (`conversationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `password` varchar(72) CHARACTER SET utf8 NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 NOT NULL,
  `active` tinyint(1) DEFAULT 1,
  `lock` tinyint(1) DEFAULT 0,
  `datetime_update` datetime DEFAULT NULL,
  `datetime_create` datetime DEFAULT NULL,
  `displayName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `hash` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `online` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/* Function  structure for function  `getAvatar` */

/*!50003 DROP FUNCTION IF EXISTS `getAvatar` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getAvatar`(`u` VARCHAR(50)) RETURNS varchar(300) CHARSET utf8
    DETERMINISTIC
BEGIN
	DECLARE var VARCHAR(300); 
	SELECT avatarUrl INTO var FROM threadripper.avatar WHERE avatar.username=u ORDER BY datetime DESC LIMIT 1;
	IF var IS NULL THEN SET var='http://192.168.11.46/api/avatar/default.jpg';
	END IF;
	RETURN var;
END */$$
DELIMITER ;

/* Function  structure for function  `getNotiCount` */

/*!50003 DROP FUNCTION IF EXISTS `getNotiCount` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getNotiCount`(convId INTEGER, usern VARCHAR(50)) RETURNS int(11)
    DETERMINISTIC
BEGIN
	DECLARE var INTEGER; 
    DECLARE readId INTEGER;
    SELECT readMessageId INTO readId FROM threadripper.conversation WHERE conversation.conversationId = convId AND conversation.username = usern;
	SELECT count(1) INTO var FROM threadripper.message WHERE conversationId = convId AND messageId > readId;
	RETURN var;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
