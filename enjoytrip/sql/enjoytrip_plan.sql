CREATE DATABASE  IF NOT EXISTS `enjoytrip` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `enjoytrip`;

select auto_increment
from information_schema.tables
where table_schema='enjoytrip' and table_name = 'plan';

drop table plan;
CREATE TABLE `plan` (
  `planNo` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(20) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `hit` int DEFAULT NULL,
  `registerTime` varchar(20) DEFAULT NULL,
  `startDate` varchar(20) DEFAULT NULL,
  `endDate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`planNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

drop table travel;
CREATE TABLE `travel` (
  `planNo` int DEFAULT NULL,
  `travelNo` int NOT NULL AUTO_INCREMENT,
  `address_name` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `place_name` varchar(255) DEFAULT NULL,
  `place_url` varchar(255) DEFAULT NULL,
  `x` varchar(100) DEFAULT NULL,
  `y` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`travelNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into plan (planNo)
values (0);
