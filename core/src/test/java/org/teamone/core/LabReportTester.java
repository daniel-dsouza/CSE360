package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LabReportSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.labs.LabReport;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LabReportTester {

    private LabReport test;

    @Before
    public void setUp() {

        test = new LabReport();
        test.getPatient().setUserID(1002);
        test.setRequestionID(4);
        test.toMapObj("potassium,WHAT WHT WHAT:");

    }

    @Test
    public void updateLabReport() {
        System.out.println("\nTest========update lab report");
        test = LabReportSQL.updateLabReport(test);
        assertTrue("Could not update lab report", test != null);

        System.out.println("Update lab test successful");
        System.out.println("PatientID:\t" + test.getPatient().getUserID());
        System.out.println("Lab Report:\t" + test.toString());
        System.out.println("Date:\t" + test.getDate());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void viewLabReport() {
        System.out.println("\nTest========Viewing lab test");
        test = LabReportSQL.viewLabReport(test);
        assertTrue("Could not get lab test", test != null);
        System.out.println("\nView successful");
        System.out.println("PatientID:\t" + test.getPatient().getUserID());
        System.out.println("Lab Report:\t" + test.toString());
        System.out.println("Date:\t" + test.getDate());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void getAllPatientTest() {

        System.out.println("\nTest========Extract all lab tests for a patient");
        Patient new1 = new Patient();
        new1.setUserID(1002);
        ArrayList<LabReport> tempList = LabReportSQL.getListLabReportByPatient(new1);
        assertTrue("No lab tests by patient ID", !tempList.isEmpty());
        LabReport tempRequest;
        for (LabReport l : tempList) {
            System.out.println("Test ID: " + l.getRequestionID());
        }

        System.out.println(TestStrings.testEnd);

    }

    @Test
    public void getAllReport() {

        System.out.println("\nTest========Extract all lab tests");
        ArrayList<LabReport> tempList = LabReportSQL.getAllLabReports();
        assertTrue("No lab tests ", !tempList.isEmpty());
        for (LabReport l : tempList) {
            System.out.println("Patient ID: " + l.getPatient().getUserID() +"\tTest ID: " + l.getRequestionID());
        }

        System.out.println(TestStrings.testEnd);

    }
}