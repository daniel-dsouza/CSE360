-- phpMyAdmin SQL Dump
-- http://www.phpmyadmin.net
--

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cse360`   remote is `sql393597`
--
CREATE DATABASE IF NOT EXISTS `cse360` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cse360`;

-- --------------------------------------------------------

--
-- Table structure for table `alerts`
--

CREATE TABLE IF NOT EXISTS `alerts` (
  `alert_id` int(11) NOT NULL AUTO_INCREMENT,
  `alert_reason` varchar(45) DEFAULT NULL,
  `doctor_id` int(11) NOT NULL DEFAULT '0',
  `patient_id` int(11) NOT NULL,
  `alertDateAndTime` varchar(255) DEFAULT NULL,
  `AlertActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`alert_id`),
  UNIQUE KEY `alertId_UNIQUE` (`alert_id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`),
  KEY `patient_id` (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2000 ;

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
-- Table structure for table `labtest`
--

CREATE TABLE IF NOT EXISTS `labtest` (
  `serialNumber` int(100) NOT NULL AUTO_INCREMENT,
  `patientID` int(10) NOT NULL,
  `staffID` int(10) NOT NULL,
  `labType` varchar(500) DEFAULT NULL,
  `labReport` varchar(5000) DEFAULT NULL,
  `date` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
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
  `SSN` varchar(50) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `insurance` varchar(100) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `healthConditions` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
  UNIQUE KEY `patientID` (`patientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `occupation` enum('labstaff','doctor','patient','hsp') NOT NULL DEFAULT 'patient',
  `password` varchar(100) NOT NULL,
  `emailID` varchar(100) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1000 ;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`userID`, `name`, `occupation`, `password`, `emailID`) VALUES
(501, 'Dr. Ryan Ang', 'doctor', 'go', 'ryan@asu.edu'),
(502, 'Mr. Daniel', 'doctor', 'go', 'Dan1@asu.edu'),
(503, 'Dr. James', 'doctor', 'go', 'james1@asu.edu'),
(504, 'Cameron', 'hsp', 'go', 'cameron1@asu.edu'),
(505, 'Haisheng', 'hsp', 'go', 'Haishen1@asu.edu'),
(506, 'Jaime', 'hsp', 'go', 'Jaime@asu.edu'),
(507, 'Vince', 'labstaff', 'go', 'Vrose@asu.edu'),
(508, 'Aby', 'labstaff', 'go', 'Aby@asu.edu'),
(509, 'Dr. Rie', 'doctor', 'go', 'Rie12@asu.edu'),
(510, 'Dr. Stephanie', 'doctor', 'go', 'Steph@asu.edu'),
(511, 'Dr. Eric', 'doctor', 'go', 'eric@asu.edu'),
(512, 'Dr. Get', 'doctor', 'go', 'ryaaan@asu.edu'),
(513, 'Dr. Ryan', 'doctor', 'go', 'ryanad@asu.edu');

-- --------------------------------------------------------

--
-- Table structure for table `prescriptions`
--

CREATE TABLE IF NOT EXISTS `prescription` (
  `serialNumber` int(100) NOT NULL AUTO_INCREMENT,
  `patientID` int(10) NOT NULL,
  `staffID` int(10) NOT NULL,
  `type` varchar(500) DEFAULT NULL,
  `quantity` varchar(500) DEFAULT NULL,
  `date` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
  KEY `patientID` (`patientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
(1, 501, 'doctor', 'Pediatrician', NULL, NULL, 'no'),
(2, 502, 'doctor', 'GeneralCare', NULL, NULL, 'no'),
(3, 503, 'doctor', 'GeneralCare', NULL, NULL, 'no'),
(4, 504, 'hsp', 'hsp', NULL, NULL, 'no'),
(5, 505, 'hsp', 'hsp', NULL, NULL, 'no'),
(6, 506, 'hsp', 'hsp', NULL, NULL, 'no'),
(7, 507, 'labstaff', 'labstaff', NULL, NULL, 'no'),
(8, 508, 'labstaff', 'labstaff', NULL, NULL, 'no'),
(9, 509, 'doctor', 'Emergency', NULL, NULL, 'yes'),
(10, 510, 'doctor', 'Emergency', NULL, NULL, 'yes'),
(11, 511, 'doctor', 'Pediatrician', NULL, NULL, 'no'),
(12, 512, 'doctor', 'GeneralCare', NULL, NULL, 'no'),
(13, 513, 'doctor', 'X-ray', NULL, NULL, 'no');

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
-- Constraints for table `alerts`
--
ALTER TABLE `alerts`
  ADD CONSTRAINT `alerts_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patientID`) ON DELETE CASCADE;

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`doctorID`) REFERENCES `staff` (`staffID`) ON DELETE CASCADE,
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`) ON DELETE CASCADE;

--
-- Constraints for table `labtest`
--
ALTER TABLE `labtest`
  ADD CONSTRAINT `labTest_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`) ON DELETE CASCADE,
    ADD CONSTRAINT `labTest_ibfk_2` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON DELETE CASCADE;

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `person` (`userID`) ON DELETE CASCADE;

--
-- Constraints for table `prescriptions`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`) ON DELETE CASCADE,
    ADD CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON DELETE CASCADE;


--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`staffID`) REFERENCES `person` (`userID`) ON DELETE CASCADE,
  ADD CONSTRAINT `staff_ibfk_2` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`);
