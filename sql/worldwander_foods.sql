-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: worldwander
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `foods`
--

DROP TABLE IF EXISTS `foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foods` (
  `food_name` varchar(1000) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  `images` varchar(100) DEFAULT NULL,
  KEY `city_id` (`city_id`),
  CONSTRAINT `foods_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foods`
--

LOCK TABLES `foods` WRITE;
/*!40000 ALTER TABLE `foods` DISABLE KEYS */;
INSERT INTO `foods` VALUES ('Izmir Kofte (spicy meatballs)',3,'ikofte.jpg'),('Boyoz (yeasted pastry)',3,'boyoz.jpg'),('Kumru (a type of sandwich)',3,'kumru.jpg'),('Etli Ekmek (meat bread)',4,'etli.jpg'),('Mevlana soup',4,'soup.jpg'),('Döner Kebabı (rotisserie-style kebab)',4,'doner.jpg'),('Piyaz (white bean salad)',5,'piyaz.jpg'),('Antalya orange',5,'aorange.jpg'),('Döner Kebabı (rotisserie-style kebab)',5,'doner.jpg'),('Mihaliç Cheese',2,'mihalic.jpg'),('Inegöl Meatballs',2,'inegol.jpg'),('Döner Kebabı (rotisserie-style kebab)',0,'doner.jpg'),('Ankara Tava',0,'ankara.jpg'),('Ayva Tatlısı',0,'ayva.jpg'),('Kumpir',1,'kumpir.jpg'),('Balık Ekmek',1,'balik.jpg'),('Boza',1,'boza.jpg'),('Iskender Kebab',2,'iskender.jpg');
/*!40000 ALTER TABLE `foods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-12 21:53:53
