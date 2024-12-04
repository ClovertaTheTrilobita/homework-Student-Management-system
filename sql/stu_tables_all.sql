-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 导出  表 ry-vue.stu_class 结构
CREATE TABLE IF NOT EXISTS `stu_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '班级名称',
  `college` int(11) DEFAULT NULL COMMENT '所属学院',
  `grade` int(11) DEFAULT NULL COMMENT '年级',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_del` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci COMMENT='班级表';

-- 正在导出表  ry-vue.stu_class 的数据：1 rows
/*!40000 ALTER TABLE `stu_class` DISABLE KEYS */;
INSERT INTO `stu_class` (`id`, `name`, `college`, `grade`, `create_time`, `update_time`, `is_del`) VALUES
	(4, '软工2023-3', 1, 1, '2024-12-05 01:20:40', NULL, NULL);
/*!40000 ALTER TABLE `stu_class` ENABLE KEYS */;

-- 导出  表 ry-vue.stu_course 结构
CREATE TABLE IF NOT EXISTS `stu_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `name` varchar(50) COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '课程名称',
  `desc` text COLLATE utf8mb4_german2_ci COMMENT '课程描述',
  `remark` varchar(200) COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '课程评论',
  `credit` int(11) DEFAULT NULL COMMENT '学分',
  `pass_score` int(11) DEFAULT NULL COMMENT '及格分数',
  `type` int(11) DEFAULT NULL COMMENT '课程类型（选修，必修）',
  `method` int(11) DEFAULT NULL COMMENT '授课方式（线上，线下）',
  `status` int(11) DEFAULT NULL COMMENT '状态（已停止，可选，不可选）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` int(11) DEFAULT NULL COMMENT '逻辑删除（0逻辑删除,1逻辑存在）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci COMMENT='课程表';

-- 正在导出表  ry-vue.stu_course 的数据：0 rows
/*!40000 ALTER TABLE `stu_course` DISABLE KEYS */;
INSERT INTO `stu_course` (`id`, `name`, `desc`, `remark`, `credit`, `pass_score`, `type`, `method`, `status`, `create_time`, `update_time`, `is_del`) VALUES
	(4, 'GalGame鉴赏', '快来选出你最喜欢的gal吧', '满昏！', 4, NULL, 2, 2, 2, '2024-12-05 03:52:58', '2024-12-05 03:57:33', NULL);
/*!40000 ALTER TABLE `stu_course` ENABLE KEYS */;

-- 导出  表 ry-vue.stu_student 结构
CREATE TABLE IF NOT EXISTS `stu_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_del` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci COMMENT='学生表';

-- 正在导出表  ry-vue.stu_student 的数据：1 rows
/*!40000 ALTER TABLE `stu_student` DISABLE KEYS */;
INSERT INTO `stu_student` (`id`, `name`, `age`, `sex`, `create_time`, `update_time`, `is_del`, `class_id`) VALUES
	(1, '孙振飞', 18, 0, NULL, '2024-12-05 01:20:49', NULL, 4),
	(2, 'steve', 3, NULL, '2024-12-05 03:31:06', NULL, NULL, 4);
/*!40000 ALTER TABLE `stu_student` ENABLE KEYS */;

-- 导出  表 ry-vue.stu_student_course_relation 结构
CREATE TABLE IF NOT EXISTS `stu_student_course_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课ID',
  `course_id` int(11) NOT NULL COMMENT '课程ID',
  `student_id` int(11) NOT NULL COMMENT '学生ID',
  `week` int(11) NOT NULL COMMENT '周几上课',
  `timetable_type` int(11) NOT NULL COMMENT '第几节',
  `address` varchar(50) COLLATE utf8mb4_german2_ci NOT NULL COMMENT '授课地点',
  `teacher_id` int(11) NOT NULL COMMENT '教师ID(用户ID)',
  `status` int(11) NOT NULL COMMENT '状态ID',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_del` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci COMMENT='选修（student_course_relation）课表';

-- 正在导出表  ry-vue.stu_student_course_relation 的数据：0 rows
/*!40000 ALTER TABLE `stu_student_course_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `stu_student_course_relation` ENABLE KEYS */;

-- 导出  表 ry-vue.stu_transcript 结构
CREATE TABLE IF NOT EXISTS `stu_transcript` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩ID',
  `course_id` int(11) DEFAULT NULL COMMENT '课程ID',
  `student_id` int(11) DEFAULT NULL COMMENT '学生ID',
  `score` int(11) DEFAULT NULL COMMENT '分数',
  `is_pass` int(11) DEFAULT NULL COMMENT '是否及格 0 及格，1不及格',
  `course_name` varchar(50) COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '课程名称',
  `student_name` varchar(50) COLLATE utf8mb4_german2_ci DEFAULT NULL COMMENT '学生名称',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_del` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci COMMENT='成绩表';

-- 正在导出表  ry-vue.stu_transcript 的数据：0 rows
/*!40000 ALTER TABLE `stu_transcript` DISABLE KEYS */;
/*!40000 ALTER TABLE `stu_transcript` ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
