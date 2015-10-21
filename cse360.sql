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
CREATE TABLE IF NOT EXISTS `person` (
  `userID` int(10) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `occupation` enum('labstaff','doctor','patient','hsp') NOT NULL DEFAULT 'patient',
  `password` varchar(100) NOT NULL,
  `emailID` varchar(100) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1000;

--
-- Table structure for table `appointment`
--
INSERT INTO `person` (`userID`, `name`, `occupation`, `password`, `emailID`) VALUES
  (501, 'Dr. Ryan Ang', 'doctor', 'go', 'ryan@asu.edu'),
  (502, 'Mr. Daniel', 'doctor', 'go', 'Dan1@asu.edu'),
  (503, 'James', 'patient', 'go', 'james1@asu.edu'),
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
  `labReports` varchar(5000) DEFAULT NULL,
  `alertDateAndTime` varchar(255) DEFAULT NULL,
  `alertStatus` tinyint(1) DEFAULT NULL,
  `prescription` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`),
  UNIQUE KEY `patientID` (`patientID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8  ;

-- INSERT INTO `patient` (`serialNumber`, `patientID`, `medicalHistory`, `occupation`, `address`, `SSN`, `gender`, `insurance`, `age`, `phone`, `healthConditions`, `labReports`, `alertDateAndTime`, `alertStatus`, `prescription`) VALUES
--  (13, 1234, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
--   (14, 1245, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
 --  (15, 1246, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
 --  (16, 1247, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
 --  (17, 1248, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
 --  (18, 1249, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
 --  (19, 1250, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  -- (20, 1260, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  -- (21, 1265, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  -- (22, 1266, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
 --  (23, 1267, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
 --  (24, 1268, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
--   (25, 1269, NULL, 'patient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;

INSERT INTO `staff` (`staffID`, `occupation`,`specialty`,`emergencyWardDoctor`) VALUES
  (501, 'doctor', 'Pediatrician','yes'),
  (502, 'doctor', 'GeneralCare','yes'),
  (504, 'hsp', 'hsp','yes'),
  (505, 'hsp', 'hsp','yes'),
  (506, 'hsp', 'hsp','yes'),
  (507, 'labstaff', 'labstaff','yes'),
  (508, 'labstaff', 'labstaff','yes'),
  (509, 'doctor', 'Emergency','yes'),
  (510, 'doctor', 'Emergency','yes'),
  (511, 'doctor', 'Pediatrician','yes'),
  (512, 'doctor', 'GeneralCare','yes'),
  (513, 'doctor', 'X-ray','yes');

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

CREATE TABLE IF NOT EXISTS  `alerts` (
  `alert_id` INT NOT NULL AUTO_INCREMENT,
  `alert_reason` VARCHAR(45) NULL,
  `doctor_id` INT NOT NULL DEFAULT 0,
  `patient_id` INT NOT NULL,
  `AlertActive` BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY (`alert_id`),
  UNIQUE INDEX `alertId_UNIQUE` (`alert_id` ASC),
  UNIQUE INDEX `patient_id_UNIQUE` (`patient_id` ASC) 
  )AUTO_INCREMENT=2000
  ;
  INSERT INTO `alerts` (`alert_reason`, `doctor_id`, `patient_id`, `AlertActive`) VALUES 
  ("anklePain:", 501, 1000, TRUE); 
