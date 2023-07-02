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
-- Table structure for table `places_to_visit`
--

DROP TABLE IF EXISTS `places_to_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `places_to_visit` (
  `place_name` varchar(1000) DEFAULT NULL,
  `place_address` varchar(10000) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  `images` varchar(100) DEFAULT NULL,
  KEY `city_id` (`city_id`),
  CONSTRAINT `places_to_visit_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `places_to_visit`
--

LOCK TABLES `places_to_visit` WRITE;
/*!40000 ALTER TABLE `places_to_visit` DISABLE KEYS */;
INSERT INTO `places_to_visit` VALUES ('Grand Mosque Bursa','Nalbantoğlu, Ulucami Cd. No:2, 16010 Osmangazi/Bursa',2,'grandbursa.jpg'),('Green Mausoleum','Yeşil, 1. Yeşil Cd. 66-1, 16360 Yıldırım/Bursa',2,'green.jpg'),('Cable car up to Uludag Mountain','Uludag',2,'cable.jpg'),('Cumalikizik - UNESCO World Heritage Town','Cumalıkızık, 16370 Yıldırım/Bursa',2,'cumali.jpg'),('Living Museum of Umurbey Silk Production','Mollaarap, 6. Park Sk. No:20, 16360 Yıldırım/Bursa',2,'living.jpg'),('Anıtkabir','Rasattepe, Anıtkabir Cd., 06630 Çankaya/Ankara',0,'sehir1.jpg'),('Kocatepe Mosque','Kocatepe Mahallesi, Dr. Abdülhalim Güven Cd. No:35, 06420 Çankaya/Ankara',0,'kocatepe.jpg'),('Atatürk Forest Farm and Zoo','Atatürk Orman Çiftliği, Atatürk Orman Çiftliği Cd. No:18, 06830 Çankaya/Ankara',0,'ataturk.jpg'),('Museum of Anatolian Civilizations','Kale, Gözcü Sk. No:2, 06240 Ulus/Altındağ/Ankara',0,'anadolu.jpg'),('Haci Bayram Mosque','Hacıbayram, Atpazarı Cd. No:1, 06050 Ulus/Altındağ/Ankara',0,'hacibayram.jpg'),('Topkapi Palace','Bab-ı Hümayün Cd., 34122 Fatih/Istanbul',1,'topkapi.jpg'),('Hagia Sophia','Sultan Ahmet, Ayasofya Meydanı No:1, 34122 Fatih/Istanbul',1,'hagia.jpg'),('Blue Mosque','Sultan Ahmet, Atmeydanı Cd. No:7, 34122 Fatih/Istanbul',1,'blue.jpg'),('Grand Bazaar','Beyazıt, Kalpakçılar Cd. No:22, 34126 Fatih/Istanbul',1,'grand.jpg'),('Bosphorus Strait','Ortaköy Mh., 34347 Beşiktaş/Istanbul',1,'bosp.jpg'),('Ephesus Ancient City','Atatürk Mahallesi, Uğur Mumcu Sevgi Yolu, 35920 Selçuk/İzmir\n , Turkey',3,'ephesus.jpg'),('Clock Tower','Konak Square, Cumhuriyet Blvd., 35250 Konak/İzmir, Turkey',3,'clock.jpg'),('The Velvet Castlen','Atatürk Caddesi, 35100 İzmir, Turkey',3,'velvet.jpg'),('Alsancak','Alsancak, 35220 Konak/İzmir, Turkey',3,'alsancak.jpg'),('Kemeraltı Bazaar','Anafartalar Cd., 35250 Konak/İzmir, Turkey',3,'kemeralti.jpg'),('Mevlana Museum','Mevlana Cd., 42030 Karatay/Konya, Turkey',4,'mevlana.jpg'),('Alaaddin Hill ','Alaaddin Mahallesi, 42030 Selçuklu/Konya, Turkey',4,'alaaddin.jpg'),('Karatay Medrese','Aziziye Mahallesi, Mevlana Cd. No:155, 42030 Karatay/Konya, Turkey',4,'karatay.jpg'),('Museum of Stone and Wood Art','Şems Mahallesi, Şems-i Tebrizi Cd., 42030 Karatay/Konya, Turkey',4,'ince.jpg'),('Konya Archaeological Museum','Akabe Mahallesi, Sancaklar Cd. No:1, 42030 Karatay/Konya, Turkey',4,'konya.jpg'),('Old Town',' Kaleiçi, Muratpaşa, 07100 Antalya, Turkey',5,'oldtown.jpg'),('Hadrian\'s Gate','Barbaros Mahallesi, 07100 Muratpaşa/Antalya, Turkey',5,'hadrian.jpg'),('Antalya Museum',' Konyaaltı, Şarampol Cd. No:30, 07100 Muratpaşa/Antalya, Turkey',5,'antalya.jpg'),('\nAspendos Theatre ','Belkıs Mahallesi, Aspendos Blv., 07500 Serik/Antalya, Turkey',5,'aspendos.jpg'),('Konyaaltı Beach','Konyaaltı, Liman Cd., 07070 Muratpaşa/Antalya, Turkey',5,'konyaalti.jpg');
/*!40000 ALTER TABLE `places_to_visit` ENABLE KEYS */;
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
