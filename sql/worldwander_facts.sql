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
-- Table structure for table `facts`
--

DROP TABLE IF EXISTS `facts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facts` (
  `fact_description` varchar(10000) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  KEY `city_id` (`city_id`),
  CONSTRAINT `facts_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facts`
--

LOCK TABLES `facts` WRITE;
/*!40000 ALTER TABLE `facts` DISABLE KEYS */;
INSERT INTO `facts` VALUES ('Izmir is a large city located on the western coast of Turkey.',3),('It is a significant center in the Aegean Region, vibrant in terms of economy, culture, and tourism.',3),('Konya is a city located in central Anatolia, Turkey',4),('It is known for its rich historical and cultural heritage, especially as the home of the Mevlana Museum and the Whirling Dervishes.',4),('Konya is deeply rooted in Islamic traditions and is considered an important center of Sufism.',4),('Antalya is a city located on the southwestern coast of Turkey, known as the \"Turkish Riviera.\"',5),('It is a popular tourist destination, famous for its beautiful beaches, ancient ruins, and vibrant nightlife.',5),('Antalya has a rich history, with influences from ancient civilizations such as the Greeks, Romans, and Byzantines.',5),('Izmir is famous for its historical and cultural heritage, beautiful beaches, and delicious cuisine',3),('Istanbul have the largest population among all cities in Turkey.',1),('It is the cultural and economic center of Turkey.',1),('Istanbul is the only city in the world that is located on two continents: Europe and Asia.',1),('The architecture of the present-day city reflects its varied history.',0),('The leader of the Turkish nationalists, Kemal Atatürk, established the headquarters of his resistance movement in Ankara in 1919.\n',0),('Ankara, historically known as Ancyra and Angora is the capital of Turkey.',0),('Bursa was once an important stop for traders of Silk.',2),('    Has a village built in Ottoman style.',2),('It hosts The Green Mosque And The Green Tomb, built by Sultan Mehmed I.',2);
/*!40000 ALTER TABLE `facts` ENABLE KEYS */;
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
