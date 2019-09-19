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
INSERT INTO `admin` (`admin_id`, `name`, `account`, `password`) VALUES
	(88, 'yingrui', 'ying8rui', '123456');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table study.bookmark
CREATE TABLE IF NOT EXISTS `bookmark` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '收藏关系主键',
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '用户id',
  `course_id` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.bookmark: ~3 rows (大约)
/*!40000 ALTER TABLE `bookmark` DISABLE KEYS */;
INSERT INTO `bookmark` (`id`, `unionid`, `course_id`) VALUES
	(1, '122', 322),
	(14, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 3),
	(19, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 5),
	(20, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 13);
/*!40000 ALTER TABLE `bookmark` ENABLE KEYS */;

-- Dumping structure for table study.course
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '上传者id',
  `name` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '课程名称',
  `image_url` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '缩略图链接',
  `introduction` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '课程简介',
  `url` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '视频链接',
  `tag1` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `tag2` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `tag3` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `play_num` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '播放次数',
  `bookmark_num` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '收藏次数',
  `visible` tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT '是否可见',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.course: ~11 rows (大约)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`course_id`, `unionid`, `name`, `image_url`, `introduction`, `url`, `tag1`, `tag2`, `tag3`, `play_num`, `bookmark_num`, `visible`) VALUES
	(1, '1', '数学', '/resources/home_images/course1.jpg', '数学是一门理科', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '数学', '理科', '高等数学', 9635, 427, 1),
	(2, '1', '物理', '/resources/home_images/course2.jpg', '物理是一门理科', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '物理', '理科', '高等数学', 66, 53, 1),
	(3, '1', '学科辅导', '/resources/home_images/course3.jpg', '学科辅导', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '教辅', '学科辅导', '高等数学', 4283, 254, 1),
	(4, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', '奥数', '/resources/home_images/course4.jpg', '奥数是一门理科', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '数学', '理科', '奥林匹克数学', 2739, 154, 1),
	(5, 'test01', 'Back To School', '/resources/home_images/course5.jpg', 'back to school', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '视频', '记录', '高等数学', 5476, 230, 1),
	(6, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'Back To School', '/resources/home_images/course6.jpg', '数学是一门理back to school科', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '视频', '记录', '高等数学', 1465, 25, 1),
	(7, 'test01', '1v1辅导', '/resources/home_images/course7.jpg', '1v1辅导', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '教辅', '综合', '学科辅导', 2575, 103, 1),
	(8, '1', '学科辅导', '/resources/home_images/course8.jpg', '学科辅导', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '教辅', '理科', '学科辅导', 3148, 146, 1),
	(11, '1', '学科辅导', '/resources/home_images/course8.jpg', '学科辅导', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400', '教辅', '理科', '学科辅导', 3146, 147, 1),
	(12, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', '学科辅导', '/resources/home_images/course8.jpg', '学科辅导', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882', '教辅', '理科', '学科辅导', 2, 0, 0),
	(13, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', '123', '/resources/home_images/course7.jpg', '课程简介', 'http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882', '教辅', '综合', '学科辅导', 2, 1, 0);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for table study.follow
CREATE TABLE IF NOT EXISTS `follow` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '关注关系主键',
  `unionid1` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '关注者id',
  `unionid2` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '被关注者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.follow: ~4 rows (大约)
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` (`id`, `unionid1`, `unionid2`) VALUES
	(7, '111', '322'),
	(8, '122', '322'),
	(17, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', '88'),
	(18, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'test01');
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;

-- Dumping structure for table study.news
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '用户id',
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(130) COLLATE utf8mb4_bin NOT NULL COMMENT '用户头像',
  `content` varchar(150) COLLATE utf8mb4_bin NOT NULL COMMENT '内容',
  `time` datetime(1) NOT NULL COMMENT '发布时间',
  `visible` tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT '是否可见',
  `likenum` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '点赞数',
  PRIMARY KEY (`id`),
  KEY `用户id关联` (`unionid`),
  CONSTRAINT `用户id关联` FOREIGN KEY (`unionid`) REFERENCES `user` (`unionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.news: ~18 rows (大约)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `unionid`, `name`, `avatar`, `content`, `time`, `visible`, `likenum`) VALUES
	(1, 'test01', 'test01', 'https://i0.hdslb.com/bfs/face/0138f6c4c55808f0af148587bf83a9419524757f.jpg', 'string', '2019-09-11 15:52:10.0', 0, 0),
	(3, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', 'asdasd', '2019-09-11 15:56:47.0', 0, 0),
	(4, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '知之为知之', '2019-09-12 08:23:39.0', 0, 0),
	(5, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '我心永恒', '2019-09-12 08:41:33.0', 0, 0),
	(6, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', 'wo ai ni', '2019-09-12 08:44:29.0', 0, 0),
	(7, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', 'hahaha', '2019-09-12 08:46:06.0', 0, 0),
	(8, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '逝者如斯夫，不舍昼夜', '2019-09-12 08:48:05.0', 0, 0),
	(9, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '究极神兵', '2019-09-12 09:05:23.0', 0, 0),
	(10, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '给我也整一个', '2019-09-12 09:30:59.0', 0, 0),
	(11, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '给我也整两个', '2019-09-12 09:30:59.0', 0, 0),
	(12, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '再给我整一个', '2019-09-12 14:10:31.0', 0, 0),
	(13, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '再给我sa整一个', '2019-09-12 14:27:58.0', 0, 1),
	(14, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', 'asdasfsadf', '2019-09-16 10:31:54.0', 0, 1),
	(15, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '123456', '2019-09-17 09:08:33.0', 0, 6),
	(16, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '456789', '2019-09-17 09:35:12.0', 0, 7),
	(17, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', 'testtime', '2019-09-17 13:48:19.0', 0, 9),
	(18, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', 'wtf', '2019-09-17 13:57:58.0', 0, 12),
	(19, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132', '我的动态', '2019-09-19 10:42:11.0', 0, 1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- Dumping structure for table study.note
CREATE TABLE IF NOT EXISTS `note` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '笔记id',
  `unionid` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '发布者id',
  `course_id` int(11) unsigned NOT NULL COMMENT '课程id',
  `content` varchar(300) COLLATE utf8mb4_bin NOT NULL COMMENT '笔记内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table study.note: ~4 rows (大约)
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` (`id`, `unionid`, `course_id`, `content`) VALUES
	(1, '11', 22, 'niubi'),
	(2, '11', 22, 'niubi'),
	(4, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 1, '我的梦'),
	(7, 'okTuv4lF5Z2wzIm76F13PEF8kF-s', 3, 'shiluochengba热火');
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
INSERT INTO `user` (`unionid`, `name`, `sex`, `privacy`, `tag`, `follow_num`, `punch_time`, `point`, `avatar`) VALUES
	('123', 'ying8rui', '男', 1, 'ABC', 123, '1970-01-01', 0, NULL),
	('88', 'ying8assssrui', '男', 1, 'ABC', 123, '1970-01-01', 0, NULL),
	('okTuv4lF5Z2wzIm76F13PEF8kF-s', 'REFG', '女', 1, NULL, 0, '2019-09-19', 35, 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eooFIHjqbMGTLmFiaMS9bLdxOMPmIgGxLZ1HHC7l6HeF57Mt0Eb0BOCtsGS8WXhPKF79GrE4VtbBpQ/132'),
	('test01', 'yingrui', '男', 0, 'ABC', 124, '1970-01-01', 2555, 'https://i0.hdslb.com/bfs/face/0138f6c4c55808f0af148587bf83a9419524757f.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
