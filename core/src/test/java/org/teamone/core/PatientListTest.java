package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

public class PatientListTest {

    private Doctor test;

    @Before
    public void setUp() {

        test = new Doctor();
        test.setStaffID(501);
    }

    @Test
    public void helpM() {
        ArrayList<Patient> testArr = PatientSQL.getPatientByStaff(test);
        System.out.println("\nTest========Searching for Patients by staff ID ");
        if(testArr!=null)
        {
            Patient temppat;
            for(int i = 0; i < testArr.size(); i++) {
                temppat = testArr.get(i);
                System.out.println("Name: " + temppat.getName() + "\tPatient ID: " + temppat.getPatientID());
            }
        }
        else
            System.out.println("SEARCH FAILED");
        System.out.println(TestStrings.testEnd);
    }

}