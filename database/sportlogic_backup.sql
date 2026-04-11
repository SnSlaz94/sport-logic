-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sportlogic
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `directivos`
--

DROP TABLE IF EXISTS `directivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directivos` (
  `id_directivo` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_directivo`),
  KEY `id_persona` (`id_persona`),
  CONSTRAINT `directivos_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directivos`
--

LOCK TABLES `directivos` WRITE;
/*!40000 ALTER TABLE `directivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `directivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenadores`
--

DROP TABLE IF EXISTS `entrenadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenadores` (
  `id_entrenador` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) DEFAULT NULL,
  `licencia_entrenador` varchar(50) DEFAULT NULL,
  `experiencia_anios` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_entrenador`),
  KEY `id_persona` (`id_persona`),
  CONSTRAINT `entrenadores_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenadores`
--

LOCK TABLES `entrenadores` WRITE;
/*!40000 ALTER TABLE `entrenadores` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrenadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examenes_medicos`
--

DROP TABLE IF EXISTS `examenes_medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examenes_medicos` (
  `id_examen` int(11) NOT NULL AUTO_INCREMENT,
  `id_jugador` int(11) DEFAULT NULL,
  `tipo_examen` varchar(100) DEFAULT NULL,
  `fecha_examen` date DEFAULT NULL,
  `resultado` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_examen`),
  KEY `id_jugador` (`id_jugador`),
  CONSTRAINT `examenes_medicos_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugadores` (`id_jugador`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examenes_medicos`
--

LOCK TABLES `examenes_medicos` WRITE;
/*!40000 ALTER TABLE `examenes_medicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `examenes_medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fichas_medicas`
--

DROP TABLE IF EXISTS `fichas_medicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichas_medicas` (
  `id_ficha` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_revision` date DEFAULT NULL,
  `historial_clinico` varchar(1000) DEFAULT NULL,
  `observaciones` varchar(1000) DEFAULT NULL,
  `id_jugador` int(11) DEFAULT NULL,
  `id_medico` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ficha`),
  KEY `FK7oiyqbytvxn7hdsdfdbmjnuah` (`id_medico`),
  KEY `FKa2ybcfvfi77wgydbh285555tc` (`id_usuario`),
  KEY `FK1qf3sqtp03muqiccfryji8g0g` (`id_jugador`),
  CONSTRAINT `FK1qf3sqtp03muqiccfryji8g0g` FOREIGN KEY (`id_jugador`) REFERENCES `jugadores` (`id_jugador`) ON DELETE CASCADE,
  CONSTRAINT `FK7oiyqbytvxn7hdsdfdbmjnuah` FOREIGN KEY (`id_medico`) REFERENCES `medicos` (`id_medico`),
  CONSTRAINT `FKa2ybcfvfi77wgydbh285555tc` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fichas_medicas`
--

LOCK TABLES `fichas_medicas` WRITE;
/*!40000 ALTER TABLE `fichas_medicas` DISABLE KEYS */;
INSERT INTO `fichas_medicas` VALUES (1,'2026-04-06','Seguimiento de salud','El jugador se encuentra en buen estado.',1,1,NULL),(2,'2026-04-02','Lesión de Tobillo','Seguimiento al deportista, por lesión durante partido.\r\n',2,1,NULL);
/*!40000 ALTER TABLE `fichas_medicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `id_horario` int(11) NOT NULL AUTO_INCREMENT,
  `dia_semana` varchar(255) DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `hora_fin` time DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_horario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'Lunes','08:00:00','09:00:00','Cancha A'),(2,'Martes','09:00:00','10:00:00','Cancha B'),(3,'Miercoles','08:30:00','09:30:00','Cancha A'),(4,'Jueves','14:00:00','15:00:00','Cancha C'),(6,'Viernes','09:40:00','10:40:00','Cancha A');
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incapacidades`
--

DROP TABLE IF EXISTS `incapacidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incapacidades` (
  `id_incapacidad` int(11) NOT NULL AUTO_INCREMENT,
  `id_lesion` int(11) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_incapacidad`),
  KEY `id_lesion` (`id_lesion`),
  CONSTRAINT `incapacidades_ibfk_1` FOREIGN KEY (`id_lesion`) REFERENCES `lesiones` (`id_lesion`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incapacidades`
--

LOCK TABLES `incapacidades` WRITE;
/*!40000 ALTER TABLE `incapacidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `incapacidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `id_jugador` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) DEFAULT NULL,
  `posicion_campo` varchar(255) DEFAULT NULL,
  `id_horario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_jugador`),
  KEY `fk_jugadores_persona_cascade` (`id_persona`),
  KEY `FK310q60y0l54cfrwn50domoy1s` (`id_horario`),
  CONSTRAINT `FK310q60y0l54cfrwn50domoy1s` FOREIGN KEY (`id_horario`) REFERENCES `horarios` (`id_horario`),
  CONSTRAINT `fk_jugadores_persona_cascade` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,7,'portero',NULL),(2,9,'defensa',NULL);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesiones`
--

DROP TABLE IF EXISTS `lesiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lesiones` (
  `id_lesion` int(11) NOT NULL AUTO_INCREMENT,
  `id_jugador` int(11) DEFAULT NULL,
  `tipo_lesion` varchar(100) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `estado` enum('Activa','Recuperada') DEFAULT NULL,
  PRIMARY KEY (`id_lesion`),
  KEY `id_jugador` (`id_jugador`),
  CONSTRAINT `lesiones_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugadores` (`id_jugador`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesiones`
--

LOCK TABLES `lesiones` WRITE;
/*!40000 ALTER TABLE `lesiones` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicos` (
  `id_medico` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) DEFAULT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_medico`),
  KEY `fk_medicos_persona_cascade` (`id_persona`),
  CONSTRAINT `fk_medicos_persona_cascade` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicos`
--

LOCK TABLES `medicos` WRITE;
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
INSERT INTO `medicos` VALUES (1,5,'Medico General',NULL,NULL,NULL);
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `documento` (`documento`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Super','Admin','00000000','2000-01-01','3001234567','Dirección Admin'),(3,'Brayan','Bautista','1033800892','2026-04-15','3223222233','Calle 49 b sur # 3-04'),(4,'Andres','Garzon','1022000111','1998-01-08','323333333','calle 22 # 3 - 4'),(5,'Luis','Martinez','1033900900','1998-10-08','3214444565','Bogotá D.C.'),(6,'Sebastian','Perafan','1022800892','1988-01-01','3223222233','Bogotá'),(7,'Pedro','Pedroza','52124687','1988-07-07','3223222233','calle 22 # 3 - 4'),(8,'Daniel','Torres','1022233233','1986-11-06','3210866776','Bogotá'),(9,'Sebastian','Perafan','1033899865','2001-11-11','321444565','Carrera 77M #80D 18 sur');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rendimiento`
--

DROP TABLE IF EXISTS `rendimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rendimiento` (
  `id_rendimiento` int(11) NOT NULL AUTO_INCREMENT,
  `id_jugador` int(11) DEFAULT NULL,
  `id_sesion` int(11) DEFAULT NULL,
  `calificacion` tinyint(4) DEFAULT NULL,
  `comentarios_tecnicos` varchar(255) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`id_rendimiento`),
  KEY `id_jugador` (`id_jugador`),
  KEY `id_sesion` (`id_sesion`),
  CONSTRAINT `rendimiento_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugadores` (`id_jugador`) ON DELETE CASCADE,
  CONSTRAINT `rendimiento_ibfk_2` FOREIGN KEY (`id_sesion`) REFERENCES `sesiones_entrenamiento` (`id_sesion`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rendimiento`
--

LOCK TABLES `rendimiento` WRITE;
/*!40000 ALTER TABLE `rendimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `rendimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'DIRECTIVO'),(3,'ENTRENADOR'),(4,'MEDICO'),(5,'DEPORTISTA');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesiones_entrenamiento`
--

DROP TABLE IF EXISTS `sesiones_entrenamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sesiones_entrenamiento` (
  `id_sesion` int(11) NOT NULL AUTO_INCREMENT,
  `id_horario` int(11) DEFAULT NULL,
  `objetivo_sesion` varchar(255) DEFAULT NULL,
  `descripcion_actividades` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_sesion`),
  KEY `id_horario` (`id_horario`),
  CONSTRAINT `sesiones_entrenamiento_ibfk_1` FOREIGN KEY (`id_horario`) REFERENCES `horarios` (`id_horario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesiones_entrenamiento`
--

LOCK TABLES `sesiones_entrenamiento` WRITE;
/*!40000 ALTER TABLE `sesiones_entrenamiento` DISABLE KEYS */;
INSERT INTO `sesiones_entrenamiento` VALUES (1,1,'Mejorar técnica fisica','Pruebas Fisicas en deportistas','2026-04-06'),(2,2,'Mejorar técnica defensiva','Mejora en tácticas defensivas de los deportistas','2026-04-07'),(4,6,'Mejora Fisica','Actividad de Desarrollo','2026-04-03');
/*!40000 ALTER TABLE `sesiones_entrenamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_persona` int(11) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `id_persona_UNIQUE` (`id_persona`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `fk_usuarios_persona_cascade` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`) ON DELETE CASCADE,
  CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'superadmin','$2a$10$mTdahnMw5AmgmoK.yGCyMOknbcf0qGUww/huJwpLxgmteAEKHeguO','superadmin@email.com',1,1),(2,'Brayan_B','$2a$10$5lrEF7evUWXXJ6qGMI8n5u8FgEJ4SdLKdteeCx5JcPBQGXxq8i8be','brayansanty24@gmail.com',3,2),(3,'Andres_G','$2a$10$tB1zFTlWWTZ5JW6neNIe.extvjuXIEYxixWv0Nt8y3inArAQMnhdG','entrenador@club.com',4,3),(4,'Luis_M','$2a$10$JF15iq0Z2OOub.6UJGZqWO1RJjcxc/IZwDRt7sOJU5lpK9sWbrtay','medico@club.com',5,4),(5,'Pedro_P','$2a$10$MwoBri9scMdB4zIAy5Ih0etpJEvRSQWpLuiQZrZvwQ93yWarsMlGe','deportista@club.com',7,5),(6,'Daniel_T','$2a$10$6I6JFgNaXy9AzDkz/ttmpubOZhnsR7s5ZxCZ5qs9Aj7yJ2TNxTyzC','directivo1@club.com',8,2),(7,'Sebastian_P','$2a$10$XVXsLug8zp5WOEdb6pVLb.vx6MQyoPr8YhY4A4SEkNgVEKQlsjkH2','deportista2@club.com',9,5);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_roles`
--

DROP TABLE IF EXISTS `usuarios_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_roles` (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_rol`),
  KEY `fk_rol` (`id_rol`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`) ON DELETE CASCADE,
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_roles`
--

LOCK TABLES `usuarios_roles` WRITE;
/*!40000 ALTER TABLE `usuarios_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sportlogic'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-11 18:37:43
