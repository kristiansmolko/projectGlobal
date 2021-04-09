-- MySQL dump 10.13  Distrib 5.7.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ubergardenv1
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Table structure for table `tconfigv1`
--

DROP TABLE IF EXISTS `tconfigv1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tconfigv1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `bowl_capacity` int(11) DEFAULT NULL,
  `lat` decimal(8,6) DEFAULT NULL,
  `lon` decimal(9,6) DEFAULT NULL,
  `location_title` varchar(50) DEFAULT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tconfigv1`
--

LOCK TABLES `tconfigv1` WRITE;
/*!40000 ALTER TABLE `tconfigv1` DISABLE KEYS */;
/*!40000 ALTER TABLE `tconfigv1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmeasurementv1`
--

DROP TABLE IF EXISTS `tmeasurementv1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmeasurementv1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `sensor_type` int(11) DEFAULT NULL,
  `sensor_unit` varchar(20) DEFAULT NULL,
  `sensor_value` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sensor_type` (`sensor_type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmeasurementv1`
--

LOCK TABLES `tmeasurementv1` WRITE;
/*!40000 ALTER TABLE `tmeasurementv1` DISABLE KEYS */;
/*!40000 ALTER TABLE `tmeasurementv1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tsensor_typev1`
--

DROP TABLE IF EXISTS `tsensor_typev1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsensor_typev1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sensor_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsensor_typev1`
--

LOCK TABLES `tsensor_typev1` WRITE;
/*!40000 ALTER TABLE `tsensor_typev1` DISABLE KEYS */;
INSERT INTO `tsensor_typev1` VALUES (1,'rainfall'),(2,'temperature'),(3,'humidity'),(4,'pressure');
/*!40000 ALTER TABLE `tsensor_typev1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-09 17:38:38
