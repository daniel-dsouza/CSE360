package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientHealthCondtions;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

public class HealthConditionUpdateTest {

    private Patient test;

    @Before
    public void setUp() {

        test = new Patient();
        test.setPatientID(1234);
        test.setHealthConditions("Ryan is a good boy");
    }

    @Test
    public void updateHC() {
        System.out.println("\nTest========Update health conditions");
        if(PatientHealthCondtions.updateHealthCondition(test))
        {
            System.out.println("Update successful");
        }
        else
            System.out.println("\nUpdate failed");
        //Person p1 = SQL.cehck
        System.out.println(TestStrings.testEnd);
    }
}