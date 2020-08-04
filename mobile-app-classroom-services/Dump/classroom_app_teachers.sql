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
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `id` bigint NOT NULL,
  `dob` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_verification_status` bit(1) NOT NULL,
  `email_verification_token` varchar(255) DEFAULT NULL,
  `encrpyted_reg_id` varchar(255) NOT NULL,
  `encrypted_password` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `organization` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `reg_id` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `teacher_id` varchar(255) NOT NULL,
  `organizations_id` bigint DEFAULT NULL,
  `subjects_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmjfas8qog5mmb47leir8uwstv` (`organizations_id`),
  KEY `FKp05m4kciwl0r2nljwa1bmy1eu` (`subjects_id`),
  CONSTRAINT `FKmjfas8qog5mmb47leir8uwstv` FOREIGN KEY (`organizations_id`) REFERENCES `organizations` (`id`),
  CONSTRAINT `FKp05m4kciwl0r2nljwa1bmy1eu` FOREIGN KEY (`subjects_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (23,'12/07/1978','teacher@teacher.com',_binary '\0',NULL,'9)Hh4*4HC&7jI(OOHWF$','q7^&&fYd8R*bg98yh8Dy^&&j^y*dIh','Brijesh','Sharma','ABC School','abc','StX1223','maths','so83oQoecvpMV0BX8o2A',18,20),(24,'12/07/1978','teacher@teacher.com',_binary '\0',NULL,'CWHIFIDH(3HI3HFJH%HH','*eTyigTE&b%8&7uG77yd*&&d^3T*&R','Brijesh','Sharma','ABC School','abc','StX1223','maths','ApTGgOxdjPaQla1UIpew',18,20),(27,'12/07/1978','teacher@teacher.com',_binary '\0',NULL,'F448I^y91YIW*IHHE9D^','dYhThq^iy&*eyn8^tYhWrgq88Iw*hE','Shalini','Sharma','ABC School','abc','StX1223','maths','aeFqJY9TJNpFaWiRj22G',18,20),(34,'12/07/1978','teacher@teacher.com',_binary '\0',NULL,'^cI7W$$YIH(^7J9*J(HW','Dhfed*&oD3Teg32q8nY*Y^yTfy8YIU','Malini','Sharma','ABC School','abc','StX1223','physics','589R3JRYz2kp8S3h5C49',18,30);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-04 14:18:27
