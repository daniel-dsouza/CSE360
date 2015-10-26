package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

import static org.junit.Assert.assertTrue;

public class HealthConditionTest {

    private org.teamone.core.users.Patient test;

    @Before
    public void setUp() {

        test = new Patient();
        test.setPatientID(1004);
        test.healthConditions.toMapObj("anklePain,true:");
    }

    @Test
    public void updateHC() {
        System.out.println("\nTest========Update health conditions");
        Patient p = PatientSQL.updateHealthCondition(test);
        assertTrue("Could not update health conditions", p != null);

        System.out.println("Update successful");
        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void setHC() {
        System.out.println("\nTest========setting list health conditions");
        boolean check = PatientSQL.setHealthConditions(test);
        assertTrue("Could not set health conditions", check);

        System.out.println("Set successful");
        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void viewHC() {
        System.out.println("\nTest========Get list health conditions");
        Patient p = PatientSQL.getHealthConditions(test);
        assertTrue("Could not view health conditions", p != null);

        System.out.println("View successful");
        System.out.println(TestStrings.testEnd);
    }
}