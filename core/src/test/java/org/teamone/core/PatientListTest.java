package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class PatientListTest {

    private Doctor test;

    @Before
    public void setUp() {

        test = new Doctor();
        test.setUserID(501);
    }

    @Test
    public void getPatientByStaf() {
        System.out.println("\\nTest========Searching for Patients by staff ID ");
        ArrayList<Patient> testArr = PatientSQL.getPatientByStaff(test);
        assertTrue("Failed to get patients by staff", !testArr.isEmpty());

        Patient temppat;
        for (int i = 0; i < testArr.size(); i++) {
            temppat = testArr.get(i);
            System.out.println("Name: " + temppat.getName() + "\tPatient ID: " + temppat.getUserID());
        }
        System.out.println(TestStrings.testEnd);
    }

}