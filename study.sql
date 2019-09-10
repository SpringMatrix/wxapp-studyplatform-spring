-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        10.3.14-MariaDB - mariadb.org binary distribution
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for study
CREATE DATABASE IF NOT EXISTS `study` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `study`;

-- Dumping structure for table study.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` varchar(3) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(15) COLLATE utf8mb4_bin NOT NULL,
  `account` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(16) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Data exporting was unselected.

-- Dumping structure for table study.bookmark
CREATE TABLE IF NOT EXISTS `bookmark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `course_id` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Data exporting was unselected.

-- Dumping structure for table study.course
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `introduction` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `url` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `tag1` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `tag2` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `tag3` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `play_num` varchar(15) COLLATE utf8mb4_bin NOT NULL DEFAULT '0',
  `bookmark_num` varchar(15) COLLATE utf8mb4_bin NOT NULL DEFAULT '0',
  `visible` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Data exporting was unselected.

-- Dumping structure for table study.follow
CREATE TABLE IF NOT EXISTS `follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unionid1` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `unionid2` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Data exporting was unselected.

-- Dumping structure for table study.news
CREATE TABLE IF NOT EXISTS `news` (
  `id` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `content` varchar(300) COLLATE utf8mb4_bin NOT NULL,
  `time` datetime(1) NOT NULL,
  `visible` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Data exporting was unselected.

-- Dumping structure for table study.note
CREATE TABLE IF NOT EXISTS `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `course_id` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `content` varchar(300) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Data exporting was unselected.

-- Dumping structure for table study.user
CREATE TABLE IF NOT EXISTS `user` (
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `sex` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `privacy` tinyint(4) unsigned NOT NULL DEFAULT 0,
  `tag` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `follow_num` int(10) unsigned NOT NULL DEFAULT 0,
  `punch_time` date DEFAULT NULL,
  `point` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`unionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
