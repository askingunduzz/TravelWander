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
-- Table structure for table `activites`
--

DROP TABLE IF EXISTS `activites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activites` (
  `activites_name` varchar(1000) DEFAULT NULL,
  `activites_date` date DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  KEY `city_id` (`city_id`),
  CONSTRAINT `activites_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activites`
--

LOCK TABLES `activites` WRITE;
/*!40000 ALTER TABLE `activites` DISABLE KEYS */;
INSERT INTO `activites` VALUES ('Ankara International Film Festival','2023-08-25',0),('Ankara International Music Festival','2023-07-18',0),('Ankara International Jazz Festival','2023-10-29',0),('Ankara Fashion Week l','2023-11-30',0),('Istanbul Tulip Festival','2023-05-10',1),('Istanbul Marathon','2023-08-24',1),('Istanbul Coffee Festival','2023-11-08',1),('Istanbul Biennia','2023-09-05',1),('Bursa International Film Festival','2023-05-10',2),('Bursa Music Festival','2023-08-24',2),('Bursa International Theater Festival','2023-11-08',2),('Bursa Silk Road Festival','2023-09-05',2),('Izmir Olive Festival','2023-09-10',3),('Izmir European Jazz Festival','2023-12-12',3),('Izmir International Marathon ','2023-12-29',3),('Izmir International Puppet Days','2023-07-13',3),('Antalya International Kite Festival','2023-09-14',5),('Antalya International Sand Sculpture Festival','2023-03-12',5),('Ankara Concert Festival','2023-01-23',0),('90\'s Concert','2023-02-25',0),('80\'s Concert','2023-02-25',1),('70\'s Concert','2023-04-03',2),('2000\'s Concert','2023-01-09',3),('Theathre Festival','2023-02-09',3),('Theathre Competition','2023-09-09',3),('Piano Competition','2023-08-09',3),('Piano Festival','2023-08-12',4),('Guitar Competition','2023-12-12',4),('Bruno Mars Concert','2023-02-12',4),('Britney Spears Concert','2023-06-12',4),('Panic At the Disco','2023-06-01',4),('Piano Recital','2023-06-01',5),('Opera','2023-02-01',5),('Sing-Off','2023-12-01',5),('Voice of Turkey','2023-01-01',2),('Voice of Turkey','2023-01-01',0),('Voice of Turkey','2023-01-01',2),('Voice of Turkey','2023-01-01',3),('Voice of Turkey','2023-01-01',4),('Voice of Turkey','2023-01-01',5),('Chef of Turkey','2023-07-01',4),('Chef of Turkey','2023-03-01',4),('Chef of Turkey','2023-03-01',0),('Chef of Turkey','2023-03-01',1),('Chef of Turkey','2023-03-01',2),('Chef of Turkey','2023-03-01',3),('Chef of Turkey','2023-03-01',4),('Chef of Turkey','2023-03-01',5),('Comedian of Antalya','2023-08-01',5),('Neauty of Turkey','2023-10-10',1),('Neauty of Turkey','2023-10-10',2),('Neauty of Turkey','2023-10-10',3),('Neauty of Turkey','2023-10-10',3),('Neauty of Turkey','2023-10-10',4),('Neauty of Turkey','2023-10-10',5),('Beast of Turkey','2023-06-29',0),('Beast of Turkey','2023-06-29',1),('Beast of Turkey','2023-06-29',2),('Beast of Turkey','2023-06-29',3),('Talk Show','2023-04-20',0),('Talk Show','2023-04-20',1),('Talk Show','2023-04-20',2),('Talk Show','2023-04-20',3),('Talk Show','2023-04-20',4),('Talk Show','2023-04-20',5),('Comedy Show','2023-05-19',4),('Comedy Show','2023-05-19',5),('Comedy Show','2023-05-19',3);
/*!40000 ALTER TABLE `activites` ENABLE KEYS */;
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
