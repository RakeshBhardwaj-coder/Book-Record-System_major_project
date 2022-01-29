-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 19, 2021 at 04:02 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_Book_Record_System`
--

-- --------------------------------------------------------

--
-- Table structure for table `db_Book`
--

CREATE TABLE `db_Book` (
  `b_id` int(11) NOT NULL,
  `b_name` varchar(50) NOT NULL,
  `b_author` varchar(50) NOT NULL,
  `b_edition` int(11) NOT NULL,
  `b_for_year` int(11) NOT NULL,
  `b_count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `db_Book`
--

INSERT INTO `db_Book` (`b_id`, `b_name`, `b_author`, `b_edition`, `b_for_year`, `b_count`) VALUES
(2, 'Raji', 'Game', 42, 4, 1),
(4, 'ak', 'Game', 42, 2, -1),
(5, 'New', 'Book', 41, 2, 9);

-- --------------------------------------------------------

--
-- Table structure for table `db_Book_Issued`
--

CREATE TABLE `db_Book_Issued` (
  `issu_id` int(11) NOT NULL,
  `issu_name` varchar(30) DEFAULT NULL,
  `issu_book` varchar(30) NOT NULL,
  `issu_book_author` varchar(20) NOT NULL,
  `issu_book_code` varchar(10) NOT NULL,
  `issu_date` varchar(10) NOT NULL,
  `issu_reissue_date` varchar(10) NOT NULL,
  `issu_return_date` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `db_Book_Issued`
--

INSERT INTO `db_Book_Issued` (`issu_id`, `issu_name`, `issu_book`, `issu_book_author`, `issu_book_code`, `issu_date`, `issu_reissue_date`, `issu_return_date`) VALUES
(3, '', 'ram', 'ram', '23', '2021-29-24', '01-10-2021', ''),
(4, '', 'fan', 'fan', '43', '2021-30-24', '-4', ''),
(5, '', 'ram', 'ram', '23', '24-58-2021', '06-10-2021', ''),
(6, '', 'fan', 'fan', '43', '24-01-2021', '01-10-2021', '24-01-2021'),
(7, '', 'fan', 'fan', '43', '24-03-2023', '24-03-2023', '24-03-2023'),
(8, '', 'fan', 'fan', '43', '24-04-2023', '24-04-2023', '24-04-2023'),
(9, '', 'ba', 'ab', '3', '05-10-2021', '', '05-10-2021'),
(10, '', 'ab', 'ab', '3', '06-10-2021', '29-10-2021', ''),
(11, '', 'ght', 'ght', '14', '04-11-2021', '', ''),
(12, '', 'Raji', 'Game', '25', '03-11-2021', '', '03-11-2021'),
(13, '', 'Raji', 'Game', '123', '03-11-2021', '', ''),
(14, '', 'ak', 'Game', '123', '04-11-2021', '', '04-11-2021'),
(15, '', 'ak', 'Game', '123', '04-11-2021', '', ''),
(16, '', 'ak', 'Game', '123', '04-11-2021', '', ''),
(17, '', 'ak', 'Game', '154', '04-11-2021', '', ''),
(18, 'null', 'Raji', 'Game', '25', '05-11-2021', '', '05-11-2021'),
(19, 'null', 'ak', 'Game', '254', '03-11-2021', '', ''),
(20, 'null', 'ak', 'Game', '254', '03-11-2021', '', '03-11-2021'),
(21, 'lokes', 'ak', 'Game', '245', '05-11-2021', '', ''),
(22, 'dsfewfewrer', 'ak', 'Game', '254', '04-11-2021', '', ''),
(23, '', 'Raji', 'Game', '123', '04-11-2021', '', '04-11-2021'),
(24, '', 'Raji', 'Game', '123', '04-11-2021', '', ''),
(25, 'Rakesh Bhardwaj', 'New', 'Book', '258', '01-11-2021', '', '01-11-2021');

-- --------------------------------------------------------

--
-- Table structure for table `db_Faculty`
--

CREATE TABLE `db_Faculty` (
  `fac_id` int(11) NOT NULL,
  `fac_name` varchar(30) NOT NULL,
  `fac_gender` varchar(10) NOT NULL,
  `fac_email` varchar(30) NOT NULL,
  `fac_mobile` bigint(20) NOT NULL,
  `fac_detail` varchar(50) NOT NULL,
  `fac_address` varchar(50) NOT NULL,
  `fac_season` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `db_Faculty`
--

INSERT INTO `db_Faculty` (`fac_id`, `fac_name`, `fac_gender`, `fac_email`, `fac_mobile`, `fac_detail`, `fac_address`, `fac_season`) VALUES
(1, 'faf', 'Other', 'dfadd', 234342, 'rbsd', 'adfdff', '2021-22'),
(2, 'faf', 'Other', 'dfadd', 234342, 'rbsd', 'adfdff', '2021-22'),
(3, 'faf', 'Other', 'dfadd', 234342, 'rbsd', 'adfdff', '2021-22'),
(5, 'faf', 'Male', 'dfadd', 234342, 'rbsd', 'adfdff', '2021-22'),
(7, 'faf', 'Male', 'dfadd', 234342, 'rbsd', 'adfdff', '2021-22'),
(9, 'raj kapr', 'Male', 'dfadd', 234342, 'rbsd', 'adfdff', '2021-22'),
(12, 'faf', 'Male', 'dfadd', 234342, 'rbsd', 'adfdff', '2021-22');

-- --------------------------------------------------------

--
-- Table structure for table `db_Fac_Book_Issued`
--

CREATE TABLE `db_Fac_Book_Issued` (
  `issu_fac_id` int(11) NOT NULL,
  `issu_fac_name` varchar(30) NOT NULL,
  `issu_book` varchar(30) NOT NULL,
  `issu_book_author` varchar(20) NOT NULL,
  `issu_book_code` varchar(10) NOT NULL,
  `issu_date` varchar(10) NOT NULL,
  `issu_reissue_date` varchar(10) NOT NULL,
  `issu_return_date` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `db_Fac_Book_Issued`
--

INSERT INTO `db_Fac_Book_Issued` (`issu_fac_id`, `issu_fac_name`, `issu_book`, `issu_book_author`, `issu_book_code`, `issu_date`, `issu_reissue_date`, `issu_return_date`) VALUES
(1, '', 'Raji', 'Game', '123', '05-11-2021', '05-11-2021', ''),
(2, '', 'Raji', 'Game', '514', '05-11-2021', '', '05-11-2021'),
(3, 'faf', 'ak', 'Game', '25', '04-11-2021', '', '04-11-2021'),
(4, 'raj kapr', 'Raji', 'Game', '852', '04-11-2021', '', ''),
(5, 'faf', 'ak', 'Game', '213', '04-11-2021', '', ''),
(6, 'faf', 'Raji', 'Game', '258', '03-11-2021', '', ''),
(7, 'raj kapr', 'Raji', 'Game', '41', '04-11-2021', '', ''),
(8, 'raj kapr', 'New', 'Book', '254', '05-11-2021', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `db_Instructor`
--

CREATE TABLE `db_Instructor` (
  `ins_id` int(11) NOT NULL,
  `ins_name` varchar(30) NOT NULL,
  `ins_gender` varchar(10) NOT NULL,
  `ins_email` varchar(30) NOT NULL,
  `ins_pass` varchar(15) NOT NULL,
  `ins_mobile` bigint(20) NOT NULL,
  `ins_detail` varchar(50) NOT NULL,
  `ins_address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `db_Instructor`
--

INSERT INTO `db_Instructor` (`ins_id`, `ins_name`, `ins_gender`, `ins_email`, `ins_pass`, `ins_mobile`, `ins_detail`, `ins_address`) VALUES
(1, 'Rakesh', 'Male', 'admin', '1234', 9685326271, 'Libararian of BSP', 'Pamgarh');

-- --------------------------------------------------------

--
-- Table structure for table `db_Student`
--

CREATE TABLE `db_Student` (
  `stu_id` int(11) NOT NULL,
  `stu_name` varchar(30) NOT NULL,
  `stu_gender` varchar(10) NOT NULL,
  `stu_email` varchar(30) NOT NULL,
  `stu_mobile` bigint(20) NOT NULL,
  `stu_rollno` bigint(20) NOT NULL,
  `stu_branch` varchar(10) NOT NULL,
  `stu_year` int(4) NOT NULL,
  `stu_detail` varchar(30) NOT NULL,
  `stu_address` varchar(50) NOT NULL,
  `stu_season` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `db_Student`
--

INSERT INTO `db_Student` (`stu_id`, `stu_name`, `stu_gender`, `stu_email`, `stu_mobile`, `stu_rollno`, `stu_branch`, `stu_year`, `stu_detail`, `stu_address`, `stu_season`) VALUES
(1, 'ddg', 'Female', 'fdffs', 33, 3, 'g', 3, 'dfaf', 'add', 'se'),
(2, 'dsfewfewrer', 'Female', 'fdffs', 33, 3, 'g', 3, '3', 'g', '3'),
(3, 'raa', 'Female', 'fdffs', 33, 3, 'g', 3, '3', 'g', '3'),
(6, 'spd', 'Male', 'sdd', 52, 5, 'sd', 1, 'sdsdsd', 'sdsd', 'sds'),
(7, 'lokes', 'Male', 'kreere', 85, 52, 'cse', 1, 'dfaf', 'dfa', '2022'),
(8, 'Rakesh Bhardwaj', 'Male', 'Rb610883@gmail.com', 9685326271, 300703319032, 'IT', 3, 'Student of BSP', 'Pamgarh', '2021-22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `db_Book`
--
ALTER TABLE `db_Book`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `db_Book_Issued`
--
ALTER TABLE `db_Book_Issued`
  ADD PRIMARY KEY (`issu_id`);

--
-- Indexes for table `db_Faculty`
--
ALTER TABLE `db_Faculty`
  ADD PRIMARY KEY (`fac_id`);

--
-- Indexes for table `db_Fac_Book_Issued`
--
ALTER TABLE `db_Fac_Book_Issued`
  ADD PRIMARY KEY (`issu_fac_id`);

--
-- Indexes for table `db_Instructor`
--
ALTER TABLE `db_Instructor`
  ADD PRIMARY KEY (`ins_id`);

--
-- Indexes for table `db_Student`
--
ALTER TABLE `db_Student`
  ADD PRIMARY KEY (`stu_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `db_Book`
--
ALTER TABLE `db_Book`
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `db_Book_Issued`
--
ALTER TABLE `db_Book_Issued`
  MODIFY `issu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `db_Faculty`
--
ALTER TABLE `db_Faculty`
  MODIFY `fac_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `db_Fac_Book_Issued`
--
ALTER TABLE `db_Fac_Book_Issued`
  MODIFY `issu_fac_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `db_Instructor`
--
ALTER TABLE `db_Instructor`
  MODIFY `ins_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `db_Student`
--
ALTER TABLE `db_Student`
  MODIFY `stu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
