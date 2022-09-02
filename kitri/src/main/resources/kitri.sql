-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- 생성 시간: 22-09-01 13:39
-- 서버 버전: 10.6.7-MariaDB
-- PHP 버전: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `kitri`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `home_category`
--

CREATE TABLE `home_category` (
  `bid` int(11) UNSIGNED NOT NULL,
  `datetime` datetime NOT NULL DEFAULT current_timestamp(),
  `name` char(50) NOT NULL,
  `path_value` char(50) NOT NULL,
  `ordering` int(11) UNSIGNED NOT NULL DEFAULT 999
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `home_category`
--

INSERT INTO `home_category` (`bid`, `datetime`, `name`, `path_value`, `ordering`) VALUES
(1, '2022-08-31 12:23:15', 'KITRI소개', 'info', 1),
(2, '2022-08-31 12:23:15', '교육사업', 'education', 1),
(3, '2022-08-31 12:24:02', '정보보안', 'security', 3),
(4, '2022-08-31 12:24:28', '연구분야', 'research', 4),
(5, '2022-08-31 12:24:49', '기업지원', 'employed', 5),
(6, '2022-08-31 12:25:09', '알림마당', 'notice', 6),
(7, '2022-08-31 12:25:29', '참여마당', 'participation', 7);

-- --------------------------------------------------------

--
-- 테이블 구조 `home_category_value`
--

CREATE TABLE `home_category_value` (
  `bid` int(11) UNSIGNED NOT NULL,
  `category_id` int(11) UNSIGNED NOT NULL,
  `datetime` datetime NOT NULL DEFAULT current_timestamp(),
  `name` char(50) NOT NULL,
  `path_value` char(50) NOT NULL,
  `view_name` char(50) NOT NULL,
  `page_value` text DEFAULT NULL,
  `edit_view` char(1) NOT NULL DEFAULT 'N',
  `ordering` int(11) UNSIGNED NOT NULL DEFAULT 999
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `home_category_value`
--

INSERT INTO `home_category_value` (`bid`, `category_id`, `datetime`, `name`, `path_value`, `view_name`, `page_value`, `edit_view`, `ordering`) VALUES
(1, 1, '2022-08-31 13:19:10', '기관장 인사말', 'info', 'greetings', NULL, 'N', 1),
(2, 1, '2022-08-31 13:19:41', '연혁', 'info', 'history', NULL, 'Y', 2),
(3, 2, '2022-08-31 16:41:38', 'IT취업교육', 'education', 'edu_it', NULL, 'N', 999),
(5, 2, '2022-09-01 12:52:50', '테스트1', 'education', 'test1', NULL, 'N', 1),
(6, 2, '2022-09-01 12:53:55', '테스트2', 'education', 'test2', NULL, 'N', 5),
(7, 7, '2022-09-01 12:59:36', 'Q&A', 'participation', 'qna', NULL, 'N', 1),
(8, 6, '2022-09-01 12:59:54', '공지사항', 'notice', 'notice', NULL, 'N', 1),
(9, 3, '2022-09-01 13:00:30', '보안리더양성', 'security', 'security', NULL, 'N', 2);

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `home_category`
--
ALTER TABLE `home_category`
  ADD PRIMARY KEY (`bid`,`path_value`) USING BTREE;

--
-- 테이블의 인덱스 `home_category_value`
--
ALTER TABLE `home_category_value`
  ADD PRIMARY KEY (`bid`),
  ADD KEY `path_value` (`path_value`),
  ADD KEY `home_category_base` (`category_id`,`path_value`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `home_category`
--
ALTER TABLE `home_category`
  MODIFY `bid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- 테이블의 AUTO_INCREMENT `home_category_value`
--
ALTER TABLE `home_category_value`
  MODIFY `bid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 덤프된 테이블의 제약사항
--

--
-- 테이블의 제약사항 `home_category_value`
--
ALTER TABLE `home_category_value`
  ADD CONSTRAINT `home_category_base` FOREIGN KEY (`category_id`,`path_value`) REFERENCES `home_category` (`bid`, `path_value`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
