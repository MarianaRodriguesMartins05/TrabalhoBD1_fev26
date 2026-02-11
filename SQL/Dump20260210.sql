CREATE DATABASE  IF NOT EXISTS `condominio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `condominio`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: condominio
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `area_comum`
--

DROP TABLE IF EXISTS `area_comum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_comum` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `nome_area` varchar(50) NOT NULL,
  `descricao` text,
  `capacidade` int DEFAULT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_comum`
--

LOCK TABLES `area_comum` WRITE;
/*!40000 ALTER TABLE `area_comum` DISABLE KEYS */;
INSERT INTO `area_comum` VALUES (1,'Salão de Festas','Espaço para eventos e confraternizações',80),(2,'Churrasqueira','Área com churrasqueira e mesas',30),(3,'Piscina','Piscina coletiva para moradores',40),(4,'Playground','Área infantil com brinquedos',25);
/*!40000 ALTER TABLE `area_comum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aviso`
--

DROP TABLE IF EXISTS `aviso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aviso` (
  `id_aviso` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `mensagem` text NOT NULL,
  `data_publicacao` date NOT NULL,
  `id_sindico` int DEFAULT NULL,
  PRIMARY KEY (`id_aviso`),
  KEY `id_sindico` (`id_sindico`),
  CONSTRAINT `aviso_ibfk_1` FOREIGN KEY (`id_sindico`) REFERENCES `sindico` (`id_sindico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aviso`
--

LOCK TABLES `aviso` WRITE;
/*!40000 ALTER TABLE `aviso` DISABLE KEYS */;
/*!40000 ALTER TABLE `aviso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloco`
--

DROP TABLE IF EXISTS `bloco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bloco` (
  `id_bloco` int NOT NULL AUTO_INCREMENT,
  `nome_bloco` varchar(50) NOT NULL,
  PRIMARY KEY (`id_bloco`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloco`
--

LOCK TABLES `bloco` WRITE;
/*!40000 ALTER TABLE `bloco` DISABLE KEYS */;
INSERT INTO `bloco` VALUES (1,'Bloco A'),(2,'Bloco B'),(3,'Bloco C');
/*!40000 ALTER TABLE `bloco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `morador`
--

DROP TABLE IF EXISTS `morador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `morador` (
  `cpf` char(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `id_unidade` int NOT NULL,
  PRIMARY KEY (`cpf`),
  KEY `id_unidade` (`id_unidade`),
  CONSTRAINT `morador_ibfk_1` FOREIGN KEY (`id_unidade`) REFERENCES `unidade` (`id_unidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `morador`
--

LOCK TABLES `morador` WRITE;
/*!40000 ALTER TABLE `morador` DISABLE KEYS */;
/*!40000 ALTER TABLE `morador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocorrencia`
--

DROP TABLE IF EXISTS `ocorrencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ocorrencia` (
  `id_ocorrencia` int NOT NULL AUTO_INCREMENT,
  `data_ocorrencia` date NOT NULL,
  `descricao` text NOT NULL,
  `status` enum('ABERTA','RESOLVIDA') NOT NULL,
  `id_unidade` int NOT NULL,
  PRIMARY KEY (`id_ocorrencia`),
  KEY `id_unidade` (`id_unidade`),
  CONSTRAINT `ocorrencia_ibfk_1` FOREIGN KEY (`id_unidade`) REFERENCES `unidade` (`id_unidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocorrencia`
--

LOCK TABLES `ocorrencia` WRITE;
/*!40000 ALTER TABLE `ocorrencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocorrencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `data_reserva` date NOT NULL,
  `horario_inicio` time NOT NULL,
  `horario_fim` time NOT NULL,
  `cpf_morador` char(11) NOT NULL,
  `id_area` int NOT NULL,
  PRIMARY KEY (`id_reserva`),
  UNIQUE KEY `id_area` (`id_area`,`data_reserva`,`horario_inicio`,`horario_fim`),
  KEY `cpf_morador` (`cpf_morador`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`cpf_morador`) REFERENCES `morador` (`cpf`),
  CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_area`) REFERENCES `area_comum` (`id_area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sindico`
--

DROP TABLE IF EXISTS `sindico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sindico` (
  `id_sindico` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `id_bloco` int DEFAULT NULL,
  PRIMARY KEY (`id_sindico`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `id_bloco` (`id_bloco`),
  CONSTRAINT `sindico_ibfk_1` FOREIGN KEY (`id_bloco`) REFERENCES `bloco` (`id_bloco`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sindico`
--

LOCK TABLES `sindico` WRITE;
/*!40000 ALTER TABLE `sindico` DISABLE KEYS */;
INSERT INTO `sindico` VALUES (1,'Carlos Almeida','carlos.sindico','123456',1),(2,'Ana Paula Ribeiro','ana.sindica','123456',2),(3,'João Pereira','joao.sindico','123456',3);
/*!40000 ALTER TABLE `sindico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxa`
--

DROP TABLE IF EXISTS `taxa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taxa` (
  `id_taxa` int NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) NOT NULL,
  `data_vencimento` date NOT NULL,
  `status_pagamento` enum('PENDENTE','PAGA','ATRASADA','CANCELADA') NOT NULL,
  `id_unidade` int NOT NULL,
  `descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`id_taxa`),
  KEY `id_unidade` (`id_unidade`),
  CONSTRAINT `taxa_ibfk_1` FOREIGN KEY (`id_unidade`) REFERENCES `unidade` (`id_unidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxa`
--

LOCK TABLES `taxa` WRITE;
/*!40000 ALTER TABLE `taxa` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidade`
--

DROP TABLE IF EXISTS `unidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidade` (
  `id_unidade` int NOT NULL AUTO_INCREMENT,
  `num_unidade` int NOT NULL,
  `tipo` varchar(30) DEFAULT NULL,
  `id_bloco` int DEFAULT NULL,
  PRIMARY KEY (`id_unidade`),
  KEY `id_bloco` (`id_bloco`),
  CONSTRAINT `unidade_ibfk_1` FOREIGN KEY (`id_bloco`) REFERENCES `bloco` (`id_bloco`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidade`
--

LOCK TABLES `unidade` WRITE;
/*!40000 ALTER TABLE `unidade` DISABLE KEYS */;
INSERT INTO `unidade` VALUES (4,101,'Apartamento',1),(5,102,'Apartamento',1),(6,103,'Apartamento',1),(7,104,'Apartamento',1),(8,201,'Apartamento',1),(9,202,'Apartamento',1),(10,203,'Apartamento',1),(11,204,'Apartamento',1),(12,301,'Apartamento',1),(13,302,'Apartamento',1),(14,303,'Apartamento',1),(15,304,'Apartamento',1),(16,401,'Cobertura',1),(17,402,'Cobertura',1),(18,403,'Cobertura',1),(19,404,'Cobertura',1),(20,101,'Apartamento',2),(21,102,'Apartamento',2),(22,103,'Apartamento',2),(23,104,'Apartamento',2),(24,201,'Apartamento',2),(25,202,'Apartamento',2),(26,203,'Apartamento',2),(27,204,'Apartamento',2),(28,301,'Apartamento',2),(29,302,'Apartamento',2),(30,303,'Apartamento',2),(31,304,'Apartamento',2),(32,401,'Cobertura',2),(33,403,'Cobertura',2),(34,402,'Cobertura',2),(35,404,'Cobertura',2),(36,101,'Apartamento',3),(37,102,'Apartamento',3),(38,103,'Apartamento',3),(39,104,'Apartamento',3),(40,201,'Apartamento',3),(41,202,'Apartamento',3),(42,203,'Apartamento',3),(43,204,'Apartamento',3),(44,301,'Apartamento',3),(45,302,'Apartamento',3),(46,303,'Apartamento',3),(47,304,'Apartamento',3),(48,401,'Cobertura',3),(49,403,'Cobertura',3),(50,402,'Cobertura',3),(51,404,'Cobertura',3);
/*!40000 ALTER TABLE `unidade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-10 22:31:52
