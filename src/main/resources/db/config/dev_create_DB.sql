-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Apr 12, 2024 at 12:42 AM
-- Server version: 5.6.38
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `sfg`
--

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE `tasks` (
  `taskID` bigint(20) NOT NULL,
  `task_name` varchar(255) NOT NULL,
  `task_start_date` datetime NOT NULL,
  `task_end_date` datetime NOT NULL,
  `task_description` varchar(255) NOT NULL,
  `task_status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`taskID`, `task_name`, `task_start_date`, `task_end_date`, `task_description`, `task_status`) VALUES
(1, 'add to git checks', '2024-04-12 23:00:00', '2024-04-13 00:00:00', 'task description update', 0),
(2, 'Postman', '2024-04-10 08:45:00', '2024-04-10 09:45:00', 'Take a walk', 1),
(3, 'Postman', '2024-04-11 09:45:00', '2024-04-11 05:45:00', 'Take a walk for real', 1),
(4, 'Postman', '2024-04-11 09:45:00', '2024-04-11 05:45:00', 'Take a walk for real', 1),
(5, 'Postman', '2024-04-11 09:45:00', '2024-04-11 05:45:00', 'Take a walk for real', 1),
(6, 'Postman', '2024-04-11 09:45:00', '2024-04-11 05:45:00', 'Take a walk for real', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tasks_seq`
--

CREATE TABLE `tasks_seq` (
  `id` int(11) NOT NULL,
  `next_val` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tasks_seq`
--

INSERT INTO `tasks_seq` (`id`, `next_val`) VALUES
(123, 173);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD UNIQUE KEY `taskID` (`taskID`);

--
-- Indexes for table `tasks_seq`
--
ALTER TABLE `tasks_seq`
  ADD PRIMARY KEY (`next_val`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `taskID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10000;

--
-- AUTO_INCREMENT for table `tasks_seq`
--
ALTER TABLE `tasks_seq`
  MODIFY `next_val` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
