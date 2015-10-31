-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net


--
-- Database: `cse360`
--
CREATE DATABASE IF NOT EXISTS `cse360` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cse360`;

-- Table structure for table `alerts'

CREATE TABLE IF NOT EXISTS `alerts` (
  `alert_id` int(11) NOT NULL AUTO_INCREMENT,
  `AlertActive` tinyint(1) NOT NULL DEFAULT '1',
  `alert_reason` varchar(5000) DEFAULT NULL,
  `doctor_id` int(11) NOT NULL DEFAULT '0',
  `patient_id` int(11) NOT NULL,
  `alertDateAndTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`alert_id`),
  UNIQUE KEY `alertId_UNIQUE` (`alert_id`),
  KEY `patient_id` (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2000 ;

-- Table structure for table `appointment`

CREATE TABLE IF NOT EXISTS `appointment` (
  `serialNumber` int(100) NOT NULL AUTO_INCREMENT,
  `date` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `doctorID` int(10) NOT NULL,
  `reason` varchar(500) DEFAULT NULL,
  `patientID` int(10) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
  KEY `doctorID` (`doctorID`),
  KEY `patientID` (`patientID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=60 ;

-- Dumping data for table `appointment`

INSERT INTO `appointment` (`serialNumber`, `date`, `time`, `doctorID`, `reason`, `patientID`) VALUES
(1, '2015-11-19', '5:00 PM', 501, NULL, NULL),
(2, '2015-11-27', '11:00 PM', 501, NULL, NULL),
(3, '2015-12-21', '5:00 PM', 501, NULL, NULL),
(4, '2015-12-23', '7:00 PM', 501, NULL, NULL),
(5, '2015-11-12', '9:00 PM', 501, NULL, NULL),
(6, '2015-12-25', '6:00 PM', 502, NULL, NULL),
(7, '2015-12-20', '4:00 PM', 502, NULL, NULL),
(8, '2015-12-4', '12:00 PM', 502, NULL, NULL),
(9, '2015-11-12', '2:00 PM', 502, NULL, NULL),
(10, '2015-12-6', '6:00 PM', 502, NULL, NULL),
(11, '2015-11-28', '6:00 PM', 503, NULL, NULL),
(12, '2015-11-7', '1:00 PM', 503, NULL, NULL),
(13, '2015-11-27', '1:00 PM', 503, NULL, NULL),
(14, '2015-11-7', '1:00 PM', 503, NULL, NULL),
(15, '2015-12-19', '11:00 AM', 503, NULL, NULL),
(16, '2015-12-1', '6:00 PM', 504, NULL, NULL),
(17, '2015-12-20', '10:00 PM', 504, NULL, NULL),
(18, '2015-11-13', '2:00 PM', 504, NULL, NULL),
(19, '2015-12-11', '11:00 AM', 504, NULL, NULL),
(20, '2015-11-2', '4:00 PM', 504, NULL, NULL),
(21, '2015-11-14', '10:00 AM', 505, NULL, NULL),
(22, '2015-12-19', '7:00 PM', 505, NULL, NULL),
(23, '2015-11-15', '12:00 PM', 505, NULL, NULL),
(24, '2015-12-10', '5:00 PM', 505, NULL, NULL),
(25, '2015-11-27', '8:00 PM', 505, NULL, NULL),
(26, '2015-12-13', '4:00 PM', 506, NULL, NULL),
(27, '2015-11-18', '8:00 AM', 506, NULL, NULL),
(28, '2015-12-7', '2:00 PM', 506, NULL, NULL),
(29, '2015-11-11', '10:00 AM', 506, NULL, NULL),
(30, '2015-12-2', '12:00 PM', 506, NULL, NULL),
(31, '2015-12-22', '10:00 PM', 507, NULL, NULL),
(32, '2015-11-22', '10:00 AM', 507, NULL, NULL),
(33, '2015-12-14', '12:00 PM', 507, NULL, NULL),
(34, '2015-11-19', '7:00 AM', 507, NULL, NULL),
(35, '2015-11-20', '8:00 AM', 507, NULL, NULL),
(36, '2015-12-12', '6:00 PM', 508, NULL, NULL),
(37, '2015-12-27', '12:00 PM', 508, NULL, NULL),
(38, '2015-11-3', '10:00 AM', 508, NULL, NULL),
(39, '2015-11-2', '11:00 PM', 508, NULL, NULL),
(40, '2015-11-6', '12:00 PM', 508, NULL, NULL),
(41, '2015-11-19', '10:00 PM', 509, NULL, NULL),
(42, '2015-12-7', '8:00 PM', 509, NULL, NULL),
(43, '2015-12-5', '8:00 PM', 509, NULL, NULL),
(44, '2015-11-13', '11:00 AM', 509, NULL, NULL),
(45, '2015-11-6', '8:00 AM', 509, NULL, NULL),
(46, '2015-11-5', '9:00 AM', 510, NULL, NULL),
(47, '2015-11-8', '5:00 PM', 510, NULL, NULL),
(48, '2015-11-4', '2:00 PM', 510, NULL, NULL),
(49, '2015-11-4', '12:00 PM', 510, NULL, NULL),
(50, '2015-12-15', '3:00 PM', 510, NULL, NULL),
(51, '2015-11-6', '9:00 AM', 511, NULL, NULL),
(52, '2015-12-3', '7:00 PM', 511, NULL, NULL),
(53, '2015-12-28', '4:00 PM', 511, NULL, NULL),
(54, '2015-12-16', '4:00 PM', 511, NULL, NULL),
(55, '2015-11-25', '12:00 PM', 511, NULL, NULL),
(56, '2015-11-24', '5:00 PM', 501, NULL, NULL),
(57, '2015-11-19', '6:00 PM', 501, NULL, NULL),
(58, '2015-11-21', '3:00 PM', 501, NULL, NULL),
(59, '2015-12-20', '12:00 PM', 501, NULL, NULL);


-- Table structure for table `labtest`

CREATE TABLE IF NOT EXISTS `labtest` (
  `serialNumber` int(100) NOT NULL AUTO_INCREMENT,
  `patientID` int(10) NOT NULL,
  `staffID` int(10) NOT NULL,
  `labType` varchar(500) DEFAULT NULL,
  `labReport` varchar(5000) DEFAULT NULL,
  `date` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
  KEY `patientID` (`patientID`),
  KEY `labTest_ibfk_2` (`staffID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- Table structure for table `patient`

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
  `date` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
  UNIQUE KEY `patientID` (`patientID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- Table structure for table `person`

CREATE TABLE IF NOT EXISTS `person` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `occupation` enum('labstaff','doctor','patient','hsp') NOT NULL DEFAULT 'patient',
  `password` varchar(100) NOT NULL,
  `emailID` varchar(100) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1001 ;

-- Dumping data for table `person`

INSERT INTO `person` (`userID`, `name`, `occupation`, `password`, `emailID`) VALUES
(501, 'Doctor Ryan:Ang', 'doctor', 'go', 'ryan@asu.edu'),
(502, 'Doctor Daniel:', 'doctor', 'go', 'Dan1@asu.edu'),
(503, 'Doctor James:', 'doctor', 'go', 'james1@asu.edu'),
(504, 'Doctor Cameron:', 'doctor', 'go', 'cameron1@asu.edu'),
(505, 'Doctor Haisheng:', 'doctor', 'go', 'Haishen1@asu.edu'),
(506, 'Doctor Jaime:', 'doctor', 'go', 'Jaime@asu.edu'),
(507, 'Doctor Vince:', 'doctor', 'go', 'Vrose@asu.edu'),
(508, 'Doctor Aby:', 'doctor', 'go', 'Aby@asu.edu'),
(509, 'Doctor Rie:', 'doctor', 'go', 'Rie12@asu.edu'),
(510, 'Doctor Stephanie:', 'doctor', 'go', 'Steph@asu.edu'),
(511, 'Doctor Ryan:', 'doctor', 'go', 'rya@asu.edu'),
(512, 'Hannah:', 'hsp', 'go', 'ryaaan@asu.edu'),
(513, 'Rick:', 'hsp', 'go', 'ryanad@asu.edu'),
(514, 'Try:Hard', 'hsp', 'go', 'ryanad@asu.edu'),
(515, 'Eric:', 'hsp', 'go', 'ryanad@asu.edu'),
(516, 'John:', 'hsp', 'go', 'ryanad@asu.edu'),
(517, 'Gabriela:', 'labstaff', 'go', 'ryanad@asu.edu'),
(518, 'Troy:', 'labstaff', 'go', 'ryanad@asu.edu'),
(519, 'Derrick:', 'labstaff', 'go', 'ryanad@asu.edu'),
(520, 'Terrence:', 'labstaff', 'go', 'ryanad@asu.edu'),
(521, 'Doctor Dre:', 'labstaff', 'go', 'ryanad@asu.edu');

-- Table structure for table `prescription`

CREATE TABLE IF NOT EXISTS `prescription` (
  `serialNumber` int(100) NOT NULL AUTO_INCREMENT,
  `patientID` int(10) NOT NULL,
  `staffID` int(10) NOT NULL,
  `type` varchar(500) DEFAULT NULL,
  `quantity` varchar(500) DEFAULT NULL,
  `date` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
  KEY `patientID` (`patientID`),
  KEY `prescription_ibfk_2` (`staffID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


-- Table structure for table `staff`

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

-- Dumping data for table `staff`

INSERT INTO `staff` (`serialNumber`, `staffID`, `occupation`, `specialty`, `patientID`, `schedule`, `emergencyWardDoctor`) VALUES
(1, 501, 'doctor', 'Emergency', NULL, NULL, 'no'),
(2, 502, 'doctor', 'GeneralCare', NULL, NULL, 'no'),
(3, 503, 'doctor', 'Neurologist', NULL, NULL, 'no'),
(4, 504, 'doctor', 'GeneralCare', NULL, NULL, 'no'),
(5, 505, 'doctor', 'GeneralCare', NULL, NULL, 'no'),
(6, 506, 'doctor', 'X-Ray', NULL, NULL, 'no'),
(7, 507, 'doctor', 'X-Ray', NULL, NULL, 'no'),
(8, 508, 'doctor', 'Pediatrician', NULL, NULL, 'no'),
(9, 509, 'doctor', 'Emergency', NULL, NULL, 'yes'),
(10, 510, 'doctor', 'Pediatrician', NULL, NULL, 'yes'),
(11, 511, 'doctor', 'Pediatrician', NULL, NULL, 'no'),
(12, 512, 'hsp', 'hsp', NULL, NULL, 'no'),
(13, 513, 'hsp', 'hsp', NULL, NULL, 'no'),
(14, 514, 'hsp', 'hsp', NULL, NULL, 'no'),
(15, 515, 'hsp', 'hsp', NULL, NULL, 'no'),
(16, 516, 'hsp', 'hsp', NULL, NULL, 'no'),
(17, 517, 'labstaff', 'labstaff', NULL, NULL, 'no'),
(18, 518, 'labstaff', 'labstaff', NULL, NULL, 'no'),
(19, 519, 'labstaff', 'labstaff', NULL, NULL, 'no'),
(20, 520, 'labstaff', 'labstaff', NULL, NULL, 'no'),
(21, 521, 'labstaff', 'labstaff', NULL, NULL, 'no');

-- Table structure for table `statistics`

CREATE TABLE IF NOT EXISTS `statistics` (
  `serialNumber` int(10) NOT NULL AUTO_INCREMENT,
  `patientPopulation` int(10) DEFAULT NULL,
  `patientType` varchar(500) DEFAULT NULL,
  `admissionRates` double DEFAULT NULL,
  `healthOutcomes` varchar(500) DEFAULT NULL,
  `date` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- Dumping data for table `statistics`

INSERT INTO `statistics` (`serialNumber`, `patientPopulation`, `patientType`, `admissionRates`, `healthOutcomes`, `date`) VALUES
(1, 25, NULL, 2.2, 'positive', NULL);


-- Constraints for table `alerts`
--
ALTER TABLE `alerts`
ADD CONSTRAINT `alerts_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patientID`) ON UPDATE CASCADE;

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`doctorID`) REFERENCES `staff` (`staffID`) ON UPDATE CASCADE,
ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`) ON UPDATE CASCADE;

--
-- Constraints for table `labtest`
--
ALTER TABLE `labtest`
ADD CONSTRAINT `labTest_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`) ON UPDATE CASCADE,
ADD CONSTRAINT `labTest_ibfk_2` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON UPDATE CASCADE;

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `person` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prescription`
--
ALTER TABLE `prescription`
ADD CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`) ON UPDATE CASCADE,
ADD CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON UPDATE CASCADE;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`staffID`) REFERENCES `person` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `staff_ibfk_2` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`) ON UPDATE CASCADE;