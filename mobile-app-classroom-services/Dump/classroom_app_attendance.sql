-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: classroom_app
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `id` bigint NOT NULL,
  `attendance_id` varchar(255) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `present` bit(1) NOT NULL,
  `section` varchar(255) NOT NULL,
  `standard` varchar(255) NOT NULL,
  `sessions_id` bigint DEFAULT NULL,
  `standards_id` bigint DEFAULT NULL,
  `students_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc7j5ujec9upwwt3pqcb1qdqd3` (`sessions_id`),
  KEY `FK14fsj36rt56pky43cri63lwk0` (`standards_id`),
  KEY `FK9ngrhj2tsxh09cjjwbutb1neq` (`students_id`),
  CONSTRAINT `FK14fsj36rt56pky43cri63lwk0` FOREIGN KEY (`standards_id`) REFERENCES `standards` (`id`),
  CONSTRAINT `FK9ngrhj2tsxh09cjjwbutb1neq` FOREIGN KEY (`students_id`) REFERENCES `students` (`id`),
  CONSTRAINT `FKc7j5ujec9upwwt3pqcb1qdqd3` FOREIGN KEY (`sessions_id`) REFERENCES `sessions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (257,'21hQi','2020-07-10 05:30:00.000000',_binary '\0','A','X',255,NULL,19),(258,'4BbI1','2020-07-10 05:30:00.000000',_binary '\0','A','X',255,NULL,19),(259,'uh33y','2020-07-10 05:30:00.000000',_binary '\0','A','X',255,NULL,19),(260,'y7y34','2020-07-10 05:30:00.000000',_binary '\0','A','X',255,NULL,19),(261,'tO4y7','2020-07-10 05:30:00.000000',_binary '\0','A','X',255,NULL,19),(262,'pm3Ob','2020-07-21 05:30:00.000000',_binary '\0','A','X',256,NULL,19),(263,'ycUh4','2020-07-21 05:30:00.000000',_binary '\0','A','X',256,26,19),(266,'cm4fc','2020-08-05 05:30:00.000000',_binary '','A','X',265,26,19),(267,'th94h','2020-08-05 05:30:00.000000',_binary '\0','A','X',265,26,19);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-05 14:41:35
