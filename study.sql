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
  `admin_id` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `name` varchar(15) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '管理员姓名',
  `account` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '管理员账号',
  `password` varchar(16) COLLATE utf8mb4_bin NOT NULL DEFAULT 'admin' COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.admin: ~0 rows (大约)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
REPLACE INTO `admin` (`admin_id`, `name`, `account`, `password`) VALUES
	(88, 'yingrui', 'ying8rui', '123456');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table study.bookmark
CREATE TABLE IF NOT EXISTS `bookmark` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '收藏关系主键',
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '用户id',
  `course_id` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.bookmark: ~0 rows (大约)
/*!40000 ALTER TABLE `bookmark` DISABLE KEYS */;
REPLACE INTO `bookmark` (`id`, `unionid`, `course_id`) VALUES
	(1, '122', '322');
/*!40000 ALTER TABLE `bookmark` ENABLE KEYS */;

-- Dumping structure for table study.course
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '上传者id',
  `name` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '课程名称',
  `image_url` varchar(150) COLLATE utf8mb4_bin NOT NULL COMMENT '缩略图链接',
  `introduction` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '课程简介',
  `url` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '视频链接',
  `tag1` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `tag2` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `tag3` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `play_num` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '播放次数',
  `bookmark_num` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '收藏次数',
  `visible` tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT '是否可见',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.course: ~0 rows (大约)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for table study.follow
CREATE TABLE IF NOT EXISTS `follow` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '关注关系主键',
  `unionid1` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '关注者id',
  `unionid2` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '被关注者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.follow: ~2 rows (大约)
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
REPLACE INTO `follow` (`id`, `unionid1`, `unionid2`) VALUES
	(7, '111', '322'),
	(8, '122', '322');
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;

-- Dumping structure for table study.news
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '用户id',
  `content` varchar(150) COLLATE utf8mb4_bin NOT NULL COMMENT '内容',
  `time` datetime(1) NOT NULL COMMENT '发布时间',
  `visible` tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT '是否可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.news: ~0 rows (大约)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
REPLACE INTO `news` (`id`, `unionid`, `content`, `time`, `visible`) VALUES
	(1, 'string', 'string', '2019-09-11 15:52:10.0', 0),
	(2, 'string', 'string', '2019-09-11 15:52:54.0', 0),
	(3, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'asdasd', '2019-09-11 15:56:47.0', 0);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- Dumping structure for table study.note
CREATE TABLE IF NOT EXISTS `note` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '笔记id',
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '发布者id',
  `course_id` int(11) unsigned NOT NULL COMMENT '课程id',
  `content` varchar(300) COLLATE utf8mb4_bin NOT NULL COMMENT '笔记内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.note: ~3 rows (大约)
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
REPLACE INTO `note` (`id`, `unionid`, `course_id`, `content`) VALUES
	(1, '11', 22, 'niubi'),
	(2, '11', 22, 'niubi'),
	(3, '555', 555, '666');
/*!40000 ALTER TABLE `note` ENABLE KEYS */;

-- Dumping structure for table study.user
CREATE TABLE IF NOT EXISTS `user` (
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '用户id',
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户昵称',
  `sex` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户性别',
  `privacy` tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT '隐私开关',
  `tag` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '主标签',
  `follow_num` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '粉丝数',
  `punch_time` date DEFAULT NULL COMMENT '上次打卡时间',
  `point` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '积分',
  `avatar` varchar(130) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像url',
  PRIMARY KEY (`unionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.user: ~3 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`unionid`, `name`, `sex`, `privacy`, `tag`, `follow_num`, `punch_time`, `point`, `avatar`) VALUES
	('123', 'ying8rui', '男', 1, 'ABC', 123, '1970-01-01', 0, NULL),
	('88', 'ying8assssrui', '男', 1, 'ABC', 123, '1970-01-01', 0, NULL),
	('okTuv4lF5Z2wzIm76F13PEF8kF-s', 'asdasd', '保密', 1, NULL, 0, '2019-09-11', 30, 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132'),
	('test01', 'yingrui', '男', 0, 'ABC', 123, '1970-01-01', 2555, 'https://i0.hdslb.com/bfs/face/0138f6c4c55808f0af148587bf83a9419524757f.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
