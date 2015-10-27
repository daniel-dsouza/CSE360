package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

import static org.junit.Assert.assertTrue;

public class MedicalHistoryTest {

    private Patient test;

    @Before
    public void setUp() {

        test = new Patient();
        test.setUserID(1004);
        test.medicalHistory.toMapObj("aidsHIVPositive,true:");
    }

    @Test
    public void updateMH() {
        System.out.println("\nTest========setting list medical history");
        boolean check = PatientSQL.setMedicalHistory(test);
        assertTrue("Failed to set medical history", check);
        System.out.println("Set successful");
        System.out.println(TestStrings.testEnd);

    }

    @Test
    public void viewMH() {
        System.out.println("\nTest========Get list health conditions");
        Patient p = PatientSQL.getMedicalHistory(test);
        assertTrue("Failed to view medical history", p != null);

        System.out.println("Get successful");
        System.out.println(TestStrings.testEnd);
    }
}