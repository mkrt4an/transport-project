CREATE DATABASE  IF NOT EXISTS `transportproject` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `transportproject`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: transportproject
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `weight` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `routePoint_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_routePoint` (`routePoint_id`),
  CONSTRAINT `FK_routePoint` FOREIGN KEY (`routePoint_id`) REFERENCES `routepoint` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (6,'bread',100,1,5),(7,'salo',300,1,6),(8,'water',500,1,NULL),(9,'aa',111,1,NULL),(11,'tools',123,3,NULL),(12,'rtrtrt',321,3,NULL),(15,'qqq',111,1,NULL),(16,'www',222,1,NULL),(17,'eee',333,1,NULL),(18,'rrr',444,1,NULL);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `routepoint_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_city_routePoint` (`routepoint_id`),
  CONSTRAINT `FK_city_routePoint` FOREIGN KEY (`routepoint_id`) REFERENCES `routepoint` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (3,'SAMARA',3,3,1),(4,'LONDON',4,4,2),(5,'MOSCOW',5,5,3),(6,'KIEV',6,7,4),(8,'Praha',555,666,5);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `workedHours` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `truck_id` int(11) DEFAULT NULL,
  `orders_id` int(11) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Driver_Truck_idx` (`truck_id`),
  KEY `FK_city_driver` (`city_id`),
  KEY `FK_orders-driver` (`orders_id`),
  CONSTRAINT `FK_city_driver` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE SET NULL,
  CONSTRAINT `FK_orders-driver` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`ID`) ON DELETE SET NULL,
  CONSTRAINT `fk_Driver_Truck` FOREIGN KEY (`truck_id`) REFERENCES `truck` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (31,'qqq','www',1,1,3,NULL,6),(32,'ggg','ggg',2,3,NULL,NULL,3),(33,'ggg','ggg',2,3,NULL,NULL,8),(35,'bbb','bbb',111,2,NULL,NULL,4),(36,'eee','eee',222,2,NULL,NULL,8),(37,'hhh','hhh',333,2,NULL,NULL,6),(38,'ghgh','tyty',2,2,NULL,NULL,6);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driverlist`
--

DROP TABLE IF EXISTS `driverlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driverlist` (
  `Orders_id` int(11) NOT NULL,
  `Driver_id` int(11) NOT NULL,
  PRIMARY KEY (`Orders_id`,`Driver_id`),
  KEY `fk_DriverList_Driver1_idx` (`Driver_id`),
  CONSTRAINT `fk_DriverList_Driver1` FOREIGN KEY (`Driver_id`) REFERENCES `driver` (`ID`),
  CONSTRAINT `fk_DriverList_Order1` FOREIGN KEY (`Orders_id`) REFERENCES `orders` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driverlist`
--

LOCK TABLES `driverlist` WRITE;
/*!40000 ALTER TABLE `driverlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `driverlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1111,1),(3,3333,1),(4,4444,1),(5,5555,2),(8,7777,1),(10,7777,2),(11,333,2);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passport`
--

DROP TABLE IF EXISTS `passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
INSERT INTO `passport` VALUES (3,333),(5,222),(6,111),(8,444);
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `path`
--

DROP TABLE IF EXISTS `path`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `path` (
  `City_id` int(11) NOT NULL,
  `City_id1` int(11) NOT NULL,
  `distance` int(11) DEFAULT NULL,
  PRIMARY KEY (`City_id`,`City_id1`),
  KEY `fk_Path_City1_idx` (`City_id`),
  KEY `fk_Path_City2_idx` (`City_id1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `path`
--

LOCK TABLES `path` WRITE;
/*!40000 ALTER TABLE `path` DISABLE KEYS */;
INSERT INTO `path` VALUES (1,2,123),(1,3,234),(1,4,345),(2,3,456),(2,4,567),(3,4,678);
/*!40000 ALTER TABLE `path` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routepoint`
--

DROP TABLE IF EXISTS `routepoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routepoint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `orders_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_routpoint` (`orders_id`),
  CONSTRAINT `FK_order_routpoint` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routepoint`
--

LOCK TABLES `routepoint` WRITE;
/*!40000 ALTER TABLE `routepoint` DISABLE KEYS */;
INSERT INTO `routepoint` VALUES (1,1,NULL),(2,1,NULL),(3,1,NULL),(4,1,NULL),(5,1,3),(6,1,4);
/*!40000 ALTER TABLE `routepoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test1`
--

DROP TABLE IF EXISTS `test1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test1` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `foo` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test1`
--

LOCK TABLES `test1` WRITE;
/*!40000 ALTER TABLE `test1` DISABLE KEYS */;
/*!40000 ALTER TABLE `test1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truck`
--

DROP TABLE IF EXISTS `truck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dutySize` int(11) NOT NULL,
  `capasity` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `regNumber` varchar(45) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `orders_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Truck_City1_idx` (`city_id`),
  KEY `fk_order_id` (`orders_id`),
  CONSTRAINT `FK_city_truck` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_order_id` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truck`
--

LOCK TABLES `truck` WRITE;
/*!40000 ALTER TABLE `truck` DISABLE KEYS */;
INSERT INTO `truck` VALUES (1,3,1000,1,'www',6,1),(2,4,500,1,'kraz234',3,NULL),(3,2,800,1,'maz345',8,3),(8,2,122,2,'BELAZ123',3,4),(10,4,3333,2,'GGG333',NULL,NULL);
/*!40000 ALTER TABLE `truck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `passport_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `user_passport_id_uindex` (`passport_id`),
  CONSTRAINT `user_passport_id_fk` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (7,'mmm_update_2',NULL),(30,'dfdf',NULL),(32,'zzz',5),(37,'ccc',3),(38,'vvv',NULL),(40,'vvv',6),(44,'bbb',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-16 14:42:31
