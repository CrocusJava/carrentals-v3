CREATE DATABASE  IF NOT EXISTS `car` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `car`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: car
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `idcar` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `carnumber` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `conditioner` bit(1) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `quantityDoors` int(11) DEFAULT NULL,
  `quantitySeats` int(11) DEFAULT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  `idplace` int(11) NOT NULL,
  PRIMARY KEY (`idcar`),
  KEY `FK17FD45BBB34BD` (`idplace`),
  CONSTRAINT `FK17FD45BBB34BD` FOREIGN KEY (`idplace`) REFERENCES `place` (`idplace`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'Daewoo','AA 4331 КВ','white','','Matiz','DaewooMatiz.jpg',25,5,5,'manual',3),(2,'Daewoo','AA 4351 КВ','gray','','Lanos','DaewooLanos.jpg',28,5,4,'manual',2),(3,'Mitsubishi','AA 3532 KB','black','','LancerX','MitsubishiLancerX.jpg',47,5,4,'tiptronic',1),(4,'Toyota','AA 3532 KB','gray','','Camry40','ToyotaCamry40.jpg',80,5,4,'tiptronic',5),(5,'MercedesBenz','AA 4352 KB','gray','','Lorincer','MercedesBenzLorinser.jpg',300,5,4,'tiptronic',2);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `idclient` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `passportseries` varchar(255) DEFAULT NULL,
  `passportnumber` int(11) DEFAULT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`idclient`),
  KEY `FKAF12F3CBC0E9C307` (`iduser`),
  CONSTRAINT `FKAF12F3CBC0E9C307` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,2,'1986-12-02','HK',436352,971111113),(2,3,'1988-09-01','BK',647255,972223334),(3,4,'1988-08-30','HO',547326,123234234),(4,5,'1990-10-10','TT',2134,1234),(5,6,'1990-01-01','EE',231432,1324234),(6,7,'1989-02-02','AE',123123,112233454),(7,8,'1980-10-10','EE',23454,44554);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `place` (
  `idplace` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idplace`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (1,'Kiev','Aeroport Shulani'),(2,'Kiev','Aeroport Borispol'),(3,'Kiev','Railway Station Centralniy'),(4,'Lviv','Aeroport'),(5,'Harkiv','Aeroport');
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `middlename` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@gmail.com','root','Vasilevich','Ruslan','root','admin','Tkachuk'),(2,'user@gmail.com','user','Petrovich','Taras','user','user','Vlasenkov'),(3,'user2@gmail.com','user2','Anatolivna','Irina','user2','user','Ustemuk'),(4,'user3@gmail.com','user3','user3','user3','user3','user','user3'),(5,'user5@gmail.com','user5','user5','user5','user5','user','user5'),(6,'user6@gmail.com','user6','user6','user6','user6','user','user6'),(7,'user7@gmail.com','user7','user7','user7','user7','user','user7'),(8,'user8@gmail.com','user8','user8','user8','user8','user','user8');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlist`
--

DROP TABLE IF EXISTS `orderlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderlist` (
  `idorder` int(11) NOT NULL AUTO_INCREMENT,
  `idclient` int(11) NOT NULL,
  `idcar` int(11) NOT NULL,
  `idplaceget` int(11) NOT NULL,
  `idplacereturn` int(11) NOT NULL,
  `dateget` date DEFAULT NULL,
  `datereturn` date DEFAULT NULL,
  `stateorder` bit(1) DEFAULT b'0',
  `description` varchar(255) DEFAULT NULL,
  `orderexecuted` bit(1) DEFAULT b'0',
  `descriptiondamage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idorder`),
  KEY `FKE8B3E0EC19DA8ED` (`idplacereturn`),
  KEY `FKE8B3E0ECEF54BAC7` (`idclient`),
  KEY `FKE8B3E0EC83F376FB` (`idplaceget`),
  KEY `FKE8B3E0EC71936217` (`idcar`),
  CONSTRAINT `FKE8B3E0EC19DA8ED` FOREIGN KEY (`idplacereturn`) REFERENCES `place` (`idplace`),
  CONSTRAINT `FKE8B3E0EC71936217` FOREIGN KEY (`idcar`) REFERENCES `car` (`idcar`),
  CONSTRAINT `FKE8B3E0EC83F376FB` FOREIGN KEY (`idplaceget`) REFERENCES `place` (`idplace`),
  CONSTRAINT `FKE8B3E0ECEF54BAC7` FOREIGN KEY (`idclient`) REFERENCES `client` (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlist`
--

LOCK TABLES `orderlist` WRITE;
/*!40000 ALTER TABLE `orderlist` DISABLE KEYS */;
INSERT INTO `orderlist` VALUES (1,2,2,1,4,'2013-01-10','2013-01-15','','    ','','    '),(2,2,2,1,2,'2013-01-01','2013-01-15','','was many car damages','','bumper was broken'),(3,3,1,1,2,'2013-01-01','2013-01-15','','','','     '),(4,1,3,1,3,'2013-01-01','2013-01-01','\0','','\0',''),(5,2,1,3,5,'2013-01-08','2013-01-08','\0','','\0',''),(6,1,3,1,5,'2013-02-10','2013-03-02','\0','','\0',''),(7,3,1,3,5,'2013-01-10','2013-01-23','',' ','\0',' '),(8,2,5,2,2,'2013-04-03','2013-04-12','','','',''),(9,1,4,5,5,'2013-04-14','2013-04-14','\0','','\0',''),(10,4,4,5,5,'2013-04-14','2013-04-14','\0','','\0',''),(11,5,4,5,5,'2013-04-14','2013-04-14','\0','','\0',''),(12,5,4,5,5,'2013-04-14','2013-04-14','\0','','\0',''),(13,6,4,5,5,'2013-04-14','2013-04-14','\0','','\0',''),(14,7,4,5,5,'2013-04-15','2013-04-30','\0','','\0',''),(15,7,5,2,2,'2013-04-15','2013-04-12','\0','','\0','');
/*!40000 ALTER TABLE `orderlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-15 22:17:29
