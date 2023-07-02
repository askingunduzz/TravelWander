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
-- Table structure for table `famous_people`
--

DROP TABLE IF EXISTS `famous_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `famous_people` (
  `people_name` varchar(1000) DEFAULT NULL,
  `people_birthday` date DEFAULT NULL,
  `people_age` int DEFAULT NULL,
  `people_job` varchar(10000) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  `images` varchar(100) DEFAULT NULL,
  KEY `city_id` (`city_id`),
  CONSTRAINT `famous_people_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `famous_people`
--

LOCK TABLES `famous_people` WRITE;
/*!40000 ALTER TABLE `famous_people` DISABLE KEYS */;
INSERT INTO `famous_people` VALUES ('Sezen Aksu','1954-07-13',68,'Singer',3,'sezenaksu.jpg'),('Özcan Deniz','1972-05-19',50,'Actor',3,'ozcandeniz.jpg'),('Cem Yılmaz','1973-04-23',49,'Comedian',3,'cemyilmaz.jpg'),('Jalal ad-Din Muhammad Rumi',NULL,NULL,'Philosopher',4,'jalal.jpg'),('Necip Fazıl Kısakürek','1904-05-26',NULL,'Poet-Playwright',4,'necip.jpg'),('Orhan Pamuk','1952-06-07',70,'Novelist',4,'orhan.jpg'),('Tarkan','1972-10-17',46,'Singer-Songwriter',5,'tarkan.jpg'),('Aslıhan Güner','1985-12-16',37,'Actress',5,'aslihan.jpg'),('Engin Akyürek','1981-01-12',39,'Actor',5,'engin.jpg'),('Ömer Aşık','1986-07-04',36,'Basketball Player',2,'omer.jpg'),('Bensu Soral','1991-03-23',32,'Actress',2,'bensu.jpg'),('Metin Akdüler','1988-04-10',35,'Actor',2,'metin.jpg'),('Beren Saat','1984-02-26',39,'Actress',0,'beren.jpg'),('Serenay Sarıka','1991-07-01',30,'Actress',0,'serenay.jpg'),('Buğra Gülsoy','1982-02-22',38,'Actor',0,'buğra.jpg'),('Kenan İmirzalioğlu','1974-06-18',49,'Actor',1,'kenan.jpg'),('Sibel Can','1970-08-01',52,'Singer',1,'sibel.jpg'),('Kenan Doğulu','1974-05-31',48,'Singer',1,'kenandogulu.jpg');
/*!40000 ALTER TABLE `famous_people` ENABLE KEYS */;
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
