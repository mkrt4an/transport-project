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
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'bread',100,3),(2,'salo',300,1),(3,'water',500,1),(4,'хлеб',100,1),(5,'сало',5,1),(6,'пиво',6,1);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (3,'SAMARA',3,3),(4,'LONDON',4,4),(5,'MOSCOW',5,5),(6,'KIEV',6,7),(8,'Praha',555,666),(9,'тверь',666,777),(10,'тула',777,888);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'qqq','www',1,1,NULL,NULL,3),(2,'ggg','ggg',2,3,8,35,3),(3,'ggg','ggg',2,3,11,NULL,3),(4,'bbb','bbb',111,2,11,NULL,3),(36,'eee','eee',222,2,12,NULL,3),(46,'eee','eee',222,2,NULL,NULL,3),(47,'eee','eee',222,2,NULL,NULL,3),(48,'eee','eee',222,2,NULL,NULL,3),(49,'eee','eee',222,2,NULL,NULL,3);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `driverlist`
--

LOCK TABLES `driverlist` WRITE;
/*!40000 ALTER TABLE `driverlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `driverlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1111,1),(3,3333,1),(4,4444,1),(5,5555,2),(8,7777,1),(10,7777,2),(27,54321,0),(28,54321,0),(29,54321,0),(30,54321,0),(31,54321,0),(32,54321,0),(33,54321,0),(34,54321,0),(35,54321,0),(36,54321,0);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
INSERT INTO `passport` VALUES (1,333),(5,222),(6,111),(8,444);
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `path`
--

LOCK TABLES `path` WRITE;
/*!40000 ALTER TABLE `path` DISABLE KEYS */;
INSERT INTO `path` VALUES (1,2,123),(1,3,234),(1,4,345),(2,3,456),(2,4,567),(3,4,678);
/*!40000 ALTER TABLE `path` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `routepoint`
--

LOCK TABLES `routepoint` WRITE;
/*!40000 ALTER TABLE `routepoint` DISABLE KEYS */;
INSERT INTO `routepoint` VALUES (1,1,NULL,3,3),(2,2,NULL,3,4),(3,1,NULL,NULL,NULL),(4,1,NULL,NULL,NULL),(5,1,NULL,NULL,NULL),(6,1,NULL,NULL,NULL),(17,1,NULL,NULL,NULL),(18,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `routepoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `truck`
--

LOCK TABLES `truck` WRITE;
/*!40000 ALTER TABLE `truck` DISABLE KEYS */;
INSERT INTO `truck` VALUES (1,3,1000,1,'VAZ2101',6,1),(2,4,500,1,'kraz234',3,27),(3,2,800,1,'maz345',8,30),(8,2,122,1,'BELAZ123',3,35),(10,3,3333,1,'GGG333',3,36),(11,4,2,1,'tatra',3,NULL),(12,2,2,1,'mers321',5,NULL),(13,2,2,1,'daf111',8,NULL),(15,2,2,1,'222',5,NULL);
/*!40000 ALTER TABLE `truck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'mmm_update_2',1),(30,'dfdf',NULL),(32,'zzz',NULL),(37,'ccc',NULL),(38,'vvv',NULL),(40,'vvv',NULL),(44,'bbb',NULL),(45,'чсячс',NULL);
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

-- Dump completed on 2016-10-19 23:35:16
