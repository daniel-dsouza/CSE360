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
        test.setUserID(1002);
        test.healthConditions.toMapObj("anklePain,true:");
    }

   /* @Test
    public void updateHC() {
        System.out.println("\nTest========Update health conditions");
        Boolean p = PatientSQL.setHealthConditions(test);
        assertTrue("Could not update health conditions", p);

        System.out.println("Update successful");
        System.out.println(TestStrings.testEnd);
    }*/

    @Test
    public void viewHC() {
        System.out.println("\nTest========Get list health conditions");
        Patient p = PatientSQL.getHealthConditions(test);
        assertTrue("Could not view health conditions", p != null);

        System.out.println("View successful");
        System.out.println(TestStrings.testEnd);
    }
}