-- MySQL dump 10.13  Distrib 5.7.35, for linux-glibc2.12 (x86_64)
--
-- Host: localhost    Database: register_system
-- ------------------------------------------------------
-- Server version	5.7.35

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
-- Table structure for table `address_table`
--

DROP TABLE IF EXISTS `address_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_table`
(
    `id`           bigint(64) NOT NULL COMMENT '地址编号',
    `province`     varchar(255) DEFAULT NULL COMMENT '省份',
    `city`         varchar(255) DEFAULT NULL COMMENT '城市',
    `district`     varchar(255) DEFAULT NULL COMMENT '区县',
    `street`       varchar(255) DEFAULT NULL COMMENT '街道',
    `house_number` varchar(255) DEFAULT NULL COMMENT '门牌号',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_table`
--

LOCK
TABLES `address_table` WRITE;
/*!40000 ALTER TABLE `address_table` DISABLE KEYS */;
INSERT INTO `address_table`
VALUES (1098355170925871104, '广东省', '广州市', '番禺区', '桥南街', '奥园广场1号'),
       (1098355175153729536, '广东省', '广州市', '番禺区', '沙湾街', '沙湾古镇3号'),
       (1099066157211582466, '广东省', '广州市', '番禺区', '市桥街', '文化中心1号'),
       (1099433869075021824, '广东省', '广州市', '番禺区', '沙湾街', '沙湾古镇2号'),
       (1100064213411299328, '广东省', '广州市', '番禺区', '市桥街', '西坊大街1号'),
       (1100074978948153346, '广东省', '广州市', '番禺区', '沙湾街', '沙湾古镇1号'),
       (1104031291134705664, '广东省', '广州市', '番禺区', '沙湾街', '沙湾古镇2号'),
       (1104031724322422784, '广东省', '广州市', '番禺区', '沙湾街', '沙湾古镇2号'),
       (1104126803766673408, '广东省', '广州市', '番禺区', '沙湾街', '留耕堂1号'),
       (1104127955438665730, '广东省', '广州市', '番禺区', '沙湾街', '沙湾古镇17号'),
       (1104141782897131522, '广东省', '广州市', '番禺区', '沙湾街', '留耕堂2号');
/*!40000 ALTER TABLE `address_table` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `family_table`
--

DROP TABLE IF EXISTS `family_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family_table`
(
    `id`            bigint(64) NOT NULL COMMENT '家庭编号',
    `address_id`    bigint(64) DEFAULT '0' COMMENT '地址表id',
    `total_members` int(11) DEFAULT '0' COMMENT '家庭人口',
    PRIMARY KEY (`id`),
    KEY             `family_table_fk_address_id` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家庭表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_table`
--

LOCK
TABLES `family_table` WRITE;
/*!40000 ALTER TABLE `family_table` DISABLE KEYS */;
INSERT INTO `family_table`
VALUES (1098356585488449536, 1098355170925871104, 2),
       (1098356589686947840, 1098355175153729536, 2);
/*!40000 ALTER TABLE `family_table` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `household_change_table`
--

DROP TABLE IF EXISTS `household_change_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `household_change_table`
(
    `id`           bigint(64) NOT NULL COMMENT '记录编号',
    `household_id` bigint(64) DEFAULT NULL COMMENT '所属户籍',
    `user_id`      bigint(64) DEFAULT NULL COMMENT '所属用户',
    `address_id`   bigint(64) DEFAULT NULL COMMENT '所属地址',
    `change_date`  date         DEFAULT NULL COMMENT '变更时间',
    `change_type`  varchar(255) DEFAULT NULL COMMENT '变动的类型(迁入 或 迁出)',
    PRIMARY KEY (`id`),
    KEY            `household_change_table_address_id` (`address_id`),
    KEY            `household_change_table_fk_household_id` (`household_id`),
    KEY            `household_change_table_fk_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='户籍变动记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `household_change_table`
--

LOCK
TABLES `household_change_table` WRITE;
/*!40000 ALTER TABLE `household_change_table` DISABLE KEYS */;
INSERT INTO `household_change_table`
VALUES (1098379793910464512, 1098356150027419648, 1098297199034368000, 1098355175153729536, '2023-04-19', '迁入'),
       (1098551238049398784, 1098355963481554944, 1098317435838136320, 1098355170925871104, '2023-04-20', '迁入'),
       (1098551242281451520, 1098356150027419656, 1098317440070189056, 1098355175153729536, '2023-04-20', '迁入'),
       (1099016411239415808, 1098355959224336384, 1098297194831675392, 1098355170925871104, '2023-04-21', '迁入'),
       (1099066157211582464, 1098356150027419656, 1098317440070189056, 1098355175153729536, '2023-04-21', '迁出'),
       (1099066157211582465, 1098356150027419656, 1098317440070189056, 1099066157211582466, '2023-04-21', '迁入'),
       (1099067071372722176, 1098356150027419648, 1098297199034368000, 1098355175153729536, '2023-04-21', '迁出'),
       (1099430001343725568, 1099430001343725568, 1099429962617716736, 1099430001335336960, '2023-04-22', '迁入'),
       (1099433869083410432, 1099433869083410433, 1099433827173924864, 1099433869075021824, '2023-04-22', '迁入'),
       (1099434322403786752, 1099434322403786753, 1099434270859984896, 1099066157211582466, '2023-04-22', '迁入'),
       (1099459770613497856, 1099434322403786753, 1099434270859984896, 1099066157211582466, '2023-04-22', '迁出'),
       (1099459770613497857, 1099434322403786753, 1099434270859984896, 1099459770613497858, '2023-04-22', '迁入'),
       (1099460308721729536, 1099434322403786753, 1099434270859984896, 1099459770613497858, '2023-04-22', '迁出'),
       (1099460308721729537, 1099434322403786753, 1099434270859984896, 1099433869075021824, '2023-04-22', '迁入'),
       (1100064213423882240, 1100064213423882241, 1100064139327307776, 1100064213411299328, '2023-04-24', '迁入'),
       (1100074978948153344, 1099434322403786753, 1099434270859984896, 1099433869075021824, '2023-04-24', '迁出'),
       (1100074978948153345, 1099434322403786753, 1099434270859984896, 1100074978948153346, '2023-04-24', '迁入'),
       (1104126803775062016, 1104126803775062017, 1104126564150280192, 1104126803766673408, '2023-05-05', '迁入'),
       (1104127955438665728, 1104126803775062017, 1104126564150280192, 1104126803766673408, '2023-05-05', '迁出'),
       (1104127955438665729, 1104126803775062017, 1104126564150280192, 1104127955438665730, '2023-05-05', '迁入'),
       (1104141782897131520, 1098355959224336384, 1098297194831675392, 1098355170925871104, '2023-05-05', '迁出'),
       (1104141782897131521, 1098355959224336384, 1098297194831675392, 1104141782897131522, '2023-05-05', '迁入');
/*!40000 ALTER TABLE `household_change_table` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `household_table`
--

DROP TABLE IF EXISTS `household_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `household_table`
(
    `id`             bigint(64) NOT NULL COMMENT '户籍编号',
    `household_type` varchar(255) DEFAULT NULL COMMENT '户籍类型(本地户籍 或 外地户籍)',
    `user_id`        bigint(64) DEFAULT NULL COMMENT '所属用户',
    `address_id`     bigint(64) DEFAULT NULL COMMENT '所属地址',
    PRIMARY KEY (`id`),
    KEY              `household_table_fk_user_id` (`user_id`),
    KEY              `household_table_fk_address_id` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='户籍表\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `household_table`
--

LOCK
TABLES `household_table` WRITE;
/*!40000 ALTER TABLE `household_table` DISABLE KEYS */;
INSERT INTO `household_table`
VALUES (1098355959224336384, '本地户籍', 1098297194831675392, 1104141782897131522),
       (1098355963481554944, '本地户籍', 1098317435838136320, 1098355170925871104),
       (1098356150027419648, '本地户籍', 1098297199034368000, 1099066157211582466),
       (1098356150027419656, '本地户籍', 1098317440070189056, 1099066157211582466),
       (1099433869083410433, '本地户籍', 1099433827173924864, 1099433869075021824),
       (1099434322403786753, '本地户籍', 1099434270859984896, 1100074978948153346),
       (1100064213423882241, '本地户籍', 1100064139327307776, 1100064213411299328),
       (1104126803775062017, '本地户籍', 1104126564150280192, 1104127955438665730);
/*!40000 ALTER TABLE `household_table` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `login_user_table`
--

DROP TABLE IF EXISTS `login_user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_user_table`
(
    `login_user` varchar(25)  NOT NULL COMMENT '用户名',
    `password`   varchar(255) NOT NULL COMMENT '密码',
    `salt`       varchar(255) DEFAULT NULL COMMENT '盐',
    `roles`      varchar(25)  NOT NULL COMMENT '角色'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_user_table`
--

LOCK
TABLES `login_user_table` WRITE;
/*!40000 ALTER TABLE `login_user_table` DISABLE KEYS */;
INSERT INTO `login_user_table`
VALUES ('住户1', '74a3bf3d5754025b5ab78b138b151662', '126414', 'user'),
       ('管理员', 'aad91c8b2a68baf49e84075954d7b468', '224894', 'admin'),
       ('住户2', '3e1b0e829781521f2741dbde20daf469', '568754', 'user'),
       ('住户3', '2e3f36ec6a7168a7f26fccfab94603d5', '360654', 'user'),
       ('住户4', '84330913df52859e2af562d007e966e6', '554325', 'user'),
       ('住户5', '40e042a10c5e66515301b6f6116ab67f', '399517', 'user'),
       ('住户6', 'ee8d83d1c37167a7b8bb2e4e17ef0c69', '177629', 'user'),
       ('住户7', 'a13106b20019e9f2b4a2c09b916726de', '870398', 'user'),
       ('住户8', '9d52e389a0a849c27e56b973e8ad2360', '213830', 'user');
/*!40000 ALTER TABLE `login_user_table` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `operator_table`
--

DROP TABLE IF EXISTS `operator_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operator_table`
(
    `id`   int(11) NOT NULL COMMENT '操作员编号',
    `name` varchar(255) DEFAULT NULL COMMENT '姓名',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator_table`
--

LOCK
TABLES `operator_table` WRITE;
/*!40000 ALTER TABLE `operator_table` DISABLE KEYS */;
INSERT INTO `operator_table`
VALUES (1, '操作员1');
/*!40000 ALTER TABLE `operator_table` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `permission_table`
--

DROP TABLE IF EXISTS `permission_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission_table`
(
    `permission_name` varchar(255) DEFAULT NULL COMMENT '权限'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_table`
--

LOCK
TABLES `permission_table` WRITE;
/*!40000 ALTER TABLE `permission_table` DISABLE KEYS */;
INSERT INTO `permission_table`
VALUES ('user_info'),
       ('update_info'),
       ('family_members'),
       ('user_change'),
       ('add_user'),
       ('admin_info'),
       ('address_info'),
       ('admin_change');
/*!40000 ALTER TABLE `permission_table` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `role_table`
--

DROP TABLE IF EXISTS `role_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_table`
(
    `role_name`   varchar(25) NOT NULL COMMENT '角色名称',
    `permissions` varchar(25) NOT NULL COMMENT '权限'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_table`
--

LOCK
TABLES `role_table` WRITE;
/*!40000 ALTER TABLE `role_table` DISABLE KEYS */;
INSERT INTO `role_table`
VALUES ('user', 'user_info'),
       ('user', 'update_info'),
       ('user', 'family_members'),
       ('user', 'user_change'),
       ('admin', 'add_user'),
       ('admin', 'admin_info'),
       ('admin', 'address_info'),
       ('admin', 'admin_change');
/*!40000 ALTER TABLE `role_table` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_table`
(
    `id`             bigint(64) NOT NULL DEFAULT '0' COMMENT '用户编号',
    `name`           varchar(255) DEFAULT NULL COMMENT '用户姓名',
    `telephone`      varchar(255) DEFAULT NULL COMMENT '联系方式',
    `gender`         varchar(255) DEFAULT NULL COMMENT '性别',
    `id_card_number` varchar(255) DEFAULT NULL COMMENT '身份证',
    `birthdate`      date         DEFAULT NULL COMMENT '出生日期',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK
TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table`
VALUES (1098297194831675392, '住户1', '123456', '男', '20000302', '2000-03-02'),
       (1098297199034368000, '住户2', '123465', '男', '19980309', '1998-03-09'),
       (1098317435838136320, '住户3', '123546', '女', '20020516', '2002-05-16'),
       (1098317440070189056, '住户4', '123564', '女', '20010717', '2001-07-17'),
       (1099433827173924864, '住户5', '123645', '女', '20030306', '2003-03-06'),
       (1099434270859984896, '住户6', '123654', '男', '20030307', '2003-03-07'),
       (1100064139327307776, '住户7', '132456', '女', '20010424', '2001-04-24'),
       (1104126564150280192, '住户8', '234156', '男', '19970729', '1997-07-29');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-05 21:43:53
