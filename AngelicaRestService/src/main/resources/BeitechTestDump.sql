-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pruebasbeitechorden
-- ------------------------------------------------------
-- Server version	5.6.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allowed_product_customer`
--

DROP TABLE IF EXISTS `allowed_product_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allowed_product_customer` (
  `product_customer_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(45) NOT NULL,
  `product_id` bigint(45) NOT NULL,
  PRIMARY KEY (`product_customer_id`),
  KEY `fk_producto` (`product_id`),
  KEY `fk_customer` (`customer_id`),
  CONSTRAINT `fx_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allowed_product_customer`
--

LOCK TABLES `allowed_product_customer` WRITE;
/*!40000 ALTER TABLE `allowed_product_customer` DISABLE KEYS */;
INSERT INTO `allowed_product_customer` VALUES (1,1019085669,1),(2,1019085669,2),(3,1019085669,3),(4,1019085669,4),(5,1019085669,5),(6,1019085669,6),(7,1019085669,8),(8,1019085669,10),(9,1019085669,12),(10,1019085669,13),(11,10200758345,7),(12,10200758345,9),(13,10200758345,11),(14,10200758345,13),(15,41778433,11),(16,41778433,12),(17,102043567,13),(18,102043567,14);
/*!40000 ALTER TABLE `allowed_product_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Carnes'),(2,'Lacteos'),(3,'Ropa'),(4,'Mercado'),(5,'ElectrodomÃ©sticos'),(6,'TecnologÃ­a');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` bigint(45) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `correo_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (41778433,'María Vargas','maria@gmail.com'),(102043567,'Daniel Vega','daniel@gmail.com'),(1019085669,'Angelica quevedo','angelica@gmail.com'),(10200758345,'Juan Vargas','juan@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `detail_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(45) NOT NULL,
  `product_id` bigint(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `detail_description` varchar(255) NOT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `fk_order_detail1_idx` (`order_id`),
  KEY `fx_product_detail1_idx` (`product_id`),
  CONSTRAINT `order_detail_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_detail_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,1,20,'description order 1'),(2,1,2,16,'description 2 order 1'),(3,2,8,35,'camisa mujer'),(4,2,10,55,'pantalon mujer');
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(45) NOT NULL,
  `delivery_address` varchar(250) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `k_orden_custumer1_idx_idx` (`customer_id`),
  CONSTRAINT `fx_customer_order` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1019085669,'calle falsa 123','2017-10-26','2017-10-23 12:22:10',3500),(2,1019085669,'calle falsa 123','2017-10-27','2017-10-24 13:01:57',70);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `creation_date` date NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `category_id` bigint(45) NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `k_product_category1_idx_idx` (`category_id`),
  CONSTRAINT `product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Carne de res','Carne de res','2017-10-19',5,1),(2,'Carne de cerdo','Carne de cerdo','2017-10-19',8,1),(3,'Pollo','Pollo','2017-10-19',6,1),(4,'Leche entera','Leche entera','2017-10-19',15,2),(5,'Yoghurt','Yoghurt','2017-10-19',3,2),(6,'Leche descremada','Leche descremada','2017-10-19',16,2),(7,'Camisa hombre','Camisa hombre','2017-10-19',40,3),(8,'Camisa mujer','Camisa mujer','2017-10-19',35,3),(9,'Pantalon hombre','Pantalon hombre','2017-10-19',60,3),(10,'Pantalon mujer','Paantalon mujer','2017-10-19',55,3),(11,'Televisor samsung','Televisor samsung','2017-10-19',650,6),(12,'Televisor LG','Televisor LG','2017-10-19',700,6),(13,'Celular iPhone 8','Celular iPhone 8','2017-10-19',1900,6),(14,'Celular iPhone 7','Celular iPhone 7','2017-10-19',1500,6);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-23 16:31:14
