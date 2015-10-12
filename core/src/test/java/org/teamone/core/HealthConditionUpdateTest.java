package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientHealthCondtions;

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

        if(PatientHealthCondtions.updateHealthCondition(test))
        {
            System.out.println("Update successful");
        }
        else
            System.out.println("\nUpdate failed");
        //Person p1 = SQL.cehck

    }
}