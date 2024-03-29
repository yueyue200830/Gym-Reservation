# 东方体育中心预约系统

Hi! This is a reservation system of **Oriental Sports Center**.
Users are classified as two types, which are normal users and managers. Both can make operations on news, reservations, revenue introductions and messages.

## Configuration Instruction
### Running Environment
This website is running on a localhost provided by Tomcat v9.0.
Although we tried to adapt this system to most platforms, it turns out there are still some unsolved problems. However, it has the best adaption to Chrome.

### Database
The website has an outer database supported by MySQL.
This the structure of our scheme:

CREATE DATABASE

IF NOT EXISTS `reservations` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `reservations`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `messages` (
  `msgID` int(11) NOT NULL AUTO_INCREMENT,
  `msgContent` text NOT NULL,
  `msgAuthor` varchar(45) NOT NULL,
  `msgIsVisible` tinyint(4) NOT NULL,
  `msgTime` timestamp NOT NULL,
  PRIMARY KEY (`msgID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `news` (
  `newID` int(11) NOT NULL AUTO_INCREMENT,
  `newTitle` varchar(45) NOT NULL,
  `newContent` text NOT NULL,
  `newTime` timestamp NOT NULL,
  `newPhoto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`newID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `ordID` int(11) NOT NULL AUTO_INCREMENT,
  `usrID` int(11) NOT NULL,
  `ordName` varchar(45) NOT NULL,
  `rvnID` int(11) NOT NULL,
  `ordPhone` varchar(45) NOT NULL,
  `ordPrice` int(11) NOT NULL,
  `rvnRoom` int(11) NOT NULL,
  `rvnDate` date NOT NULL,
  `rvnTime` int(11) NOT NULL,
  PRIMARY KEY (`ordID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `revenues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `revenues` (
  `rvnID` int(11) NOT NULL AUTO_INCREMENT,
  `rvnName` varchar(45) NOT NULL,
  `rvnNum` int(11) NOT NULL,
  `rvnPrice` int(11) NOT NULL,
  `rvnIntro` text NOT NULL,
  PRIMARY KEY (`rvnID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `usrID` int(11) NOT NULL AUTO_INCREMENT,
  `usrName` varchar(45) NOT NULL,
  `usrKey` varchar(45) NOT NULL,
  `usrEmail` varchar(45) NOT NULL,
  `usrType` int(11) NOT NULL,
  PRIMARY KEY (`usrID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

### External Libraries
If you want to run this system on your own server, please check the following libraries:
- commons-beanutils-1.9.3.jar
- commons-collections-3.2.2.jar
- commons-fileupload-1.3.3.jar
- commons-io-2.6.jar
- commons-lang-2.6.jar
- commons-logging-1.2.jar
- ezmorph-1.0.6.jar
- gson-2.0.jar
- json-lib-2.4-jdk15.jar
- log4j-1.2.17.jar
- slf4j-api-1.7.10.jar
- slf4j-log4j12-1.7.10.jar
- mysql-connector-java-8.0.13.jar

## Operating Instruction

### Normal Users

- Register: signup.jsp
>Users can register the system through signup.jsp. All users created through this page are regarded as normal ones.

- Login: login.jsp

- Read News: news.jsp

- Read Revenue Introduction: rvnintro.jsp

- Make Reservations: reservation.jsp
- Inspect Orders: myorder.jsp

- Leave Messages: addmessage.jsp
- Read Messages: messageboard.jsp

- Personal Information Management: UserInform.jsp

- Logout:  By clicking the button in the top-right corner.

### Managers

- Login: login.jsp

- Manage Orders: managerorder.jsp
> Means scan and cancel orders.

- Manage News
  - Publish news: addnews.jsp
  - Read news: managernews.jsp

- Manage Messages: managermessage.jsp
> Including read and audit messages.

- Personal Information Management: managerInform.jsp

- Login out: By clicking the button in the top-right corner.

## Tips
Please do not upload a .gif picture.

Developed by Jiayi Zhu and Shen Lei
2018-12-28
