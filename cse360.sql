-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 11, 2015 at 04:49 AM
-- Server version: 5.6.27-log
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cse360` remote is `sql393597`
--
CREATE DATABASE IF NOT EXISTS `cse360` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cse360`;

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE IF NOT EXISTS `appointment` (
  `serialNumber` int(100) NOT NULL AUTO_INCREMENT,
  `date` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `doctorID` int(10) NOT NULL,
  `reason` varchar(500) NOT NULL,
  `patientID` int(10) NOT NULL,
  PRIMARY KEY (`serialNumber`),
  KEY `doctorID` (`doctorID`),
  KEY `patientID` (`patientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `serialNumber` int(100) NOT NULL AUTO_INCREMENT,
  `patientID` int(10) NOT NULL,
  `medicalHistory` varchar(5000) DEFAULT NULL,
  `occupation` enum('patient') NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `SSN` varchar(9) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `insurance` varchar(100) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `healthConditions` varchar(5000) DEFAULT NULL,
  `labReports` varchar(5000) DEFAULT NULL,
  `alertDateAndTime` varchar(255) DEFAULT NULL,
  `alertStatus` tinyint(1) DEFAULT NULL,
  `prescription` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
  UNIQUE KEY `patientID` (`patientID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`serialNumber`, `patientID`, `medicalHistory`, `occupation`, `address`, `SSN`, `gender`, `insurance`, `age`, `phone`, `healthConditions`, `labReports`, `alertDateAndTime`, `alertStatus`, `prescription`) VALUES
  (13, 1234, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (14, 1245, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (15, 1246, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (16, 1247, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (17, 1248, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (18, 1249, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (19, 1250, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (20, 1260, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (21, 1265, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (22, 1266, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (23, 1267, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (24, 1268, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (25, 1269, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `userID` int(10) NOT NULL DEFAULT '0',
  `name` varchar(100) NOT NULL,
  `occupation` enum('labstaff','doctor','patient','hsp') NOT NULL DEFAULT 'patient',
  `password` varchar(100) NOT NULL,
  `emailID` varchar(100) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`userID`, `name`, `occupation`, `password`, `emailID`) VALUES
  (1232, 'Dr. Ryan Ang', 'doctor', 'temporary', 'ryan@asu.edu'),
  (1233, 'Mr. Daniel', 'doctor', 'temporary', 'Dan1@asu.edu'),
  (1234, 'James', 'patient', 'temporary', 'james1@asu.edu'),
  (1235, 'Cameron', 'hsp', 'temporary', 'cameron1@asu.edu'),
  (1236, 'Haisheng', 'hsp', 'temporary', 'Haishen1@asu.edu'),
  (1237, 'Jaime', 'hsp', 'temporary', 'Jaime@asu.edu'),
  (1238, 'Vince', 'labstaff', 'temporary', 'Vrose@asu.edu'),
  (1239, 'Aby', 'labstaff', 'temporary', 'Aby@asu.edu'),
  (1240, 'Dr. Rie', 'doctor', 'temporary', 'Rie12@asu.edu'),
  (1241, 'Dr. Stephanie', 'doctor', 'temporary', 'Steph@asu.edu'),
  (1242, 'Dr. Eric', 'doctor', 'temporary', 'eric@asu.edu'),
  (1243, 'Dr. Get', 'doctor', 'temporary', 'ryaaan@asu.edu'),
  (1244, 'Dr. Ryan', 'doctor', 'temporary', 'ryanad@asu.edu'),
  (1245, 'Patien1', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1246, 'Patien2', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1247, 'Patien3', 'patient', 'temporary', 'ryanadhdad@asu.edu'),
  (1248, 'Patien4', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1249, 'Patien5', 'patient', 'temporary', 'ryanaAdad@asu.edu'),
  (1250, 'Patien6', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1260, 'Patien7', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1265, 'Patien8', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1266, 'Patien9', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1267, 'Patien10', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1268, 'Patien11', 'patient', 'temporary', 'ryanadad@asu.edu'),
  (1269, 'Patien12', 'patient', 'temporary', 'ryanadad@asu.edu');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `serialNumber` int(100) NOT NULL AUTO_INCREMENT,
  `staffID` int(10) NOT NULL,
  `occupation` enum('labstaff','doctor','hsp') NOT NULL,
  `specialty` varchar(100) NOT NULL,
  `patientID` int(10) DEFAULT NULL,
  `schedule` varchar(100) DEFAULT NULL,
  `emergencyWardDoctor` enum('yes','no') DEFAULT 'yes',
  PRIMARY KEY (`serialNumber`),
  UNIQUE KEY `staffID` (`staffID`),
  KEY `patientID` (`patientID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`serialNumber`, `staffID`, `occupation`, `specialty`, `patientID`, `schedule`, `emergencyWardDoctor`) VALUES
  (1, 1232, 'doctor', 'EmergencyDoctor', NULL, NULL, 'yes'),
  (2, 1233, 'doctor', 'EmergencyDoctor', NULL, NULL, 'yes'),
  (3, 1240, 'doctor', 'Pediatrician', NULL, NULL, 'yes'),
  (4, 1241, 'doctor', 'Pediatrician', NULL, NULL, 'yes'),
  (5, 1242, 'doctor', 'GeneralCare', NULL, NULL, 'yes'),
  (6, 1243, 'doctor', 'Neurologist', NULL, NULL, 'yes'),
  (7, 1244, 'doctor', 'X-Ray', NULL, NULL, 'yes'),
  (8, 1235, 'hsp', 'hsp', NULL, NULL, 'yes'),
  (9, 1236, 'hsp', 'hsp', NULL, NULL, 'yes'),
  (10, 1237, 'hsp', 'hsp', NULL, NULL, 'yes'),
  (11, 1238, 'labstaff', 'labstaff', NULL, NULL, 'yes'),
  (12, 1239, 'labstaff', 'labstaff', NULL, NULL, 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `statistics`
--

CREATE TABLE IF NOT EXISTS `statistics` (
  `serialNumber` int(10) NOT NULL AUTO_INCREMENT,
  `patientPopulation` int(10) DEFAULT NULL,
  `patientType` varchar(500) DEFAULT NULL,
  `admissionRates` double DEFAULT NULL,
  `healthOutcomes` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `statistics`
--

INSERT INTO `statistics` (`serialNumber`, `patientPopulation`, `patientType`, `admissionRates`, `healthOutcomes`) VALUES
  (1, 25, NULL, 2.2, 'positive');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`doctorID`) REFERENCES `staff` (`staffID`) ON DELETE CASCADE,
ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`) ON DELETE CASCADE;

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `person` (`userID`) ON DELETE CASCADE;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`staffID`) REFERENCES `person` (`userID`) ON DELETE CASCADE,
ADD CONSTRAINT `staff_ibfk_2` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`);

CREATE TABLE IF NOT EXISTS `alerts` (
  `alert_id` INT NOT NULL AUTO_INCREMENT,
  `alert_reason` VARCHAR(45) NULL,
  `doctor_id` INT NOT NULL DEFAULT 0,
  `patient_id` INT NOT NULL,
  `AlertActive` BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY (`alert_id`),
  UNIQUE INDEX `alertId_UNIQUE` (`alert_id` ASC),
  UNIQUE INDEX `patient_id_UNIQUE` (`patient_id` ASC)
  );
INSERT INTO `alerts` (`alert_reason`, `doctor_id`, `patient_id`, `AlertActive`) VALUES
  ("anklePain:", 1244, 1249, TRUE);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
