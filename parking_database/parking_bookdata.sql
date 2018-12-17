-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: parking
-- ------------------------------------------------------
-- Server version	8.0.13

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

--
-- Table structure for table `bookdata`
--

DROP TABLE IF EXISTS `bookdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bookdata` (
  `idbookdata` int(11) NOT NULL AUTO_INCREMENT,
  `lot` varchar(45) NOT NULL,
  `datein` varchar(45) NOT NULL,
  `timein` varchar(45) NOT NULL,
  `timeout` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `license` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `other` varchar(99) DEFAULT NULL,
  `check` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idbookdata`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookdata`
--

LOCK TABLES `bookdata` WRITE;
/*!40000 ALTER TABLE `bookdata` DISABLE KEYS */;
INSERT INTO `bookdata` VALUES (73,'A3','18/12/2018','8:00','12:00','Peerapol Onhan','กก1234','0837199785','-','0'),(74,'A3','18/12/2018','14:00','16:00','owen owen','พพ 5415','023173166','-','0'),(75,'A8','18/12/2018','9:00','11:00','Mez EIEI','กพ 5847','0123456789','-','0'),(76,'Z5','18/12/2018','11:00','15:00','พีรพล อ่อนแฮน','ฏซ 1587','023173337','-','0');
/*!40000 ALTER TABLE `bookdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-17 19:46:51
