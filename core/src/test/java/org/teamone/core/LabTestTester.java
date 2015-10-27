package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LabTestSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.labs.LabTest;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LabTestTester {

    private LabTest test;

    @Before
    public void setUp() {

        test = new LabTest();
        test.getPatient().setPatientID(1005);
        test.setRequestionID(11);
        test.toMapObj("potassium,WHAT WHT WHAT:");

    }

    @Test
    public void updateLabReport() {
        System.out.println("\nTest========update lab report");
        test = LabTestSQL.updateLabTest(test);
        assertTrue("Could not update lab report", test != null);

        System.out.println("Update lab test successful");
        System.out.println("PatientID:\t" + test.getPatient().getPatientID());
        System.out.println("Lab Report:\t" + test.toString());
        System.out.println("Date:\t" + test.getDate());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void viewLabReport() {
        System.out.println("\nTest========Viewing lab test");
        test = LabTestSQL.viewLabTest(test);
        assertTrue("Could not get lab test", test != null);
        System.out.println("\nView successful");
        System.out.println("PatientID:\t" + test.getPatient().getPatientID());
        System.out.println("Lab Report:\t" + test.toString());
        System.out.println("Date:\t" + test.getDate());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void getAllPatientTest() {

        System.out.println("\nTest========Extract all lab tests for a patient");
        Patient new1 = new Patient();
        new1.setPatientID(1002);
        ArrayList<LabTest> tempList = LabTestSQL.getListLabTestByPatient(new1);
        assertTrue("No lab tests by patient ID", !tempList.isEmpty());
        LabTest tempRequest;
        for (LabTest l : tempList) {
            System.out.println(l.getPatient().getName() + "\tTest ID: " + l.getRequestionID());
        }

        System.out.println(TestStrings.testEnd);

    }
}