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
-- Temporary view structure for view `activities_famous_people3`
--

DROP TABLE IF EXISTS `activities_famous_people3`;
/*!50001 DROP VIEW IF EXISTS `activities_famous_people3`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `activities_famous_people3` AS SELECT 
 1 AS `activites_name`,
 1 AS `people_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `activities_famous_peoplenew`
--

DROP TABLE IF EXISTS `activities_famous_peoplenew`;
/*!50001 DROP VIEW IF EXISTS `activities_famous_peoplenew`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `activities_famous_peoplenew` AS SELECT 
 1 AS `activites_name`,
 1 AS `people_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `activities_famous_people2`
--

DROP TABLE IF EXISTS `activities_famous_people2`;
/*!50001 DROP VIEW IF EXISTS `activities_famous_people2`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `activities_famous_people2` AS SELECT 
 1 AS `activites_name`,
 1 AS `people_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `activities_famous_people`
--

DROP TABLE IF EXISTS `activities_famous_people`;
/*!50001 DROP VIEW IF EXISTS `activities_famous_people`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `activities_famous_people` AS SELECT 
 1 AS `activites_name`,
 1 AS `people_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `activities_famous_people3`
--

/*!50001 DROP VIEW IF EXISTS `activities_famous_people3`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `activities_famous_people3` AS select `a`.`activites_name` AS `activites_name`,`fp`.`people_name` AS `people_name` from (`activites` `a` left join `famous_people` `fp` on((`a`.`city_id` = `fp`.`city_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `activities_famous_peoplenew`
--

/*!50001 DROP VIEW IF EXISTS `activities_famous_peoplenew`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `activities_famous_peoplenew` AS select `a`.`activites_name` AS `activites_name`,`fp`.`people_name` AS `people_name` from (`activites` `a` left join `famous_people` `fp` on((`a`.`city_id` = `fp`.`city_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `activities_famous_people2`
--

/*!50001 DROP VIEW IF EXISTS `activities_famous_people2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `activities_famous_people2` AS select `a`.`activites_name` AS `activites_name`,`fp`.`people_name` AS `people_name` from (`activites` `a` left join `famous_people` `fp` on((`a`.`city_id` = `fp`.`city_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `activities_famous_people`
--

/*!50001 DROP VIEW IF EXISTS `activities_famous_people`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `activities_famous_people` AS select `a`.`activites_name` AS `activites_name`,`fp`.`people_name` AS `people_name` from (`activites` `a` left join `famous_people` `fp` on((`a`.`city_id` = `fp`.`city_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-12 21:53:53
