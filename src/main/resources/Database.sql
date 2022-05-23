CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
                             `idMaterial` int NOT NULL AUTO_INCREMENT,
                             `description` varchar(45) NOT NULL,
                             `unit` varchar(45) DEFAULT NULL,
                             `length` int DEFAULT NULL,
                             PRIMARY KEY (`idMaterial`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'25x200 mm trykimp Brædt',NULL,NULL),(2,'25x125 mm trykimp brædt',NULL,NULL),(3,'38x73 mm lægte Brædt',NULL,NULL),(4,'45x95 mm Reglar ub',NULL,NULL),(5,'45x195 mm spærtræ ubh',NULL,NULL),(6,'97x97 mm trykimp Stolpe',NULL,NULL),(7,'19x100 mm trykimp brædt',NULL,NULL),(8,'Plastmo Ecolite blåtonet',NULL,NULL),(9,'plastmo bundskruer 200 stk',NULL,NULL),(10,'hulbånd 1x20 mm 10 mtr',NULL,NULL),(11,'universal 190 mm  højre',NULL,NULL),(12,'universal 190 mm venstre',NULL,NULL),(13,'4.5 x 60 mm  skruer 200 stk',NULL,NULL),(14,'4 x 50 mm beslagskruer 250 stk',NULL,NULL),(15,'bræddebolt 10 x 120 mm',NULL,NULL),(16,'firkantskiver 40x40x11 mm',NULL,NULL),(17,'4.5 x 70 mm skruer 400 stk',NULL,NULL),(18,'4.5 x 50 mm skruer 300 stk',NULL,NULL),(19,'stalddørsgreb 50x75',NULL,NULL),(20,'t hængsel 390 mm',NULL,NULL),(21,'vinkelbeslag 35',NULL,NULL);
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
                          `idOrders` int NOT NULL AUTO_INCREMENT,
                          `date` date NOT NULL,
                          `fk_idUser` int NOT NULL,
                          `width` int DEFAULT NULL,
                          `length` int DEFAULT NULL,
                          `price` int DEFAULT NULL,
                          `idRoof` int DEFAULT NULL,
                          `idToolshed` int DEFAULT NULL,
                          `carportType` varchar(45) DEFAULT NULL,
                          PRIMARY KEY (`idOrders`),
                          KEY `fk_orders_user_idx` (`fk_idUser`),
                          KEY `fk_orders_toolshed1_idx` (`idToolshed`),
                          KEY `fk_orders_roof1_idx` (`idRoof`),
                          CONSTRAINT `fk_orders_roof1` FOREIGN KEY (`idRoof`) REFERENCES `roof` (`idRoof`),
                          CONSTRAINT `fk_orders_toolshed1` FOREIGN KEY (`idToolshed`) REFERENCES `toolshed` (`idToolshed`),
                          CONSTRAINT `fk_orders_user` FOREIGN KEY (`fk_idUser`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (12,'2022-05-19',5,240,240,10000,1,1,'single'),(13,'2022-05-19',5,420,420,1000,1,1,'single'),(14,'2022-05-19',5,690,420,10000,1,1,'single');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partslist`
--

DROP TABLE IF EXISTS `partslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partslist` (
                             `idPartslist` int NOT NULL AUTO_INCREMENT,
                             `idMaterials` int NOT NULL,
                             `description` varchar(45) NOT NULL,
                             `amount` int DEFAULT NULL,
                             `length` int DEFAULT NULL,
                             `idOrders` int DEFAULT NULL,
                             PRIMARY KEY (`idPartslist`),
                             KEY `fk_partslist_orders1_idx` (`idOrders`),
                             KEY `fk_partslist_materials1_idx` (`idMaterials`),
                             CONSTRAINT `fk_partslist_materials1` FOREIGN KEY (`idMaterials`) REFERENCES `materials` (`idMaterial`),
                             CONSTRAINT `fk_partslist_orders1` FOREIGN KEY (`idOrders`) REFERENCES `orders` (`idOrders`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partslist`
--

LOCK TABLES `partslist` WRITE;
/*!40000 ALTER TABLE `partslist` DISABLE KEYS */;
INSERT INTO `partslist` VALUES (1,6,'Stolper nedgraves 90 cm jord',11,300,13),(2,5,'Remme i sider, sadles ned i stolper',2,600,13);
/*!40000 ALTER TABLE `partslist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roof`
--

DROP TABLE IF EXISTS `roof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roof` (
                        `idRoof` int NOT NULL AUTO_INCREMENT,
                        `roofType` varchar(45) NOT NULL,
                        `roofTilt` int DEFAULT NULL,
                        PRIMARY KEY (`idRoof`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roof`
--

LOCK TABLES `roof` WRITE;
/*!40000 ALTER TABLE `roof` DISABLE KEYS */;
INSERT INTO `roof` VALUES (1,'flat tag',0),(2,'skråt tag',20);
/*!40000 ALTER TABLE `roof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toolshed`
--

DROP TABLE IF EXISTS `toolshed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toolshed` (
                            `idToolshed` int NOT NULL AUTO_INCREMENT,
                            `TSwidth` int NOT NULL,
                            `TSLength` int NOT NULL,
                            PRIMARY KEY (`idToolshed`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toolshed`
--

LOCK TABLES `toolshed` WRITE;
/*!40000 ALTER TABLE `toolshed` DISABLE KEYS */;
INSERT INTO `toolshed` VALUES (1,1,2);
/*!40000 ALTER TABLE `toolshed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `user_id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(45) NOT NULL,
                        `password` varchar(45) NOT NULL,
                        `email` varchar(45) NOT NULL,
                        `role` varchar(45) NOT NULL DEFAULT 'user',
                        `balance` int NOT NULL DEFAULT '500',
                        `address` varchar(45) DEFAULT NULL,
                        `phone` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'a','123','a@a.dk','admin',100,'vej','123'),(6,'b','123','b@b.dk','user',500,'vej1','888');
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

-- Dump completed on 2022-05-19 15:22:47
