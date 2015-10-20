package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

public class HealthConditionTest {

    private org.teamone.core.users.Patient test;

    @Before
    public void setUp() {

        test = new Patient();
        test.setPatientID(1245);
        test.setHealthConditions("protrudingEyes,false:visionProblems,false:testiclePain,true:stomachPain,false:frequentUrination,false");
    }

    @Test
    public void updateHC() {
        System.out.println("\nTest========Update health conditions");
        if(PatientSQL.updateHealthCondition(test))
        {
            System.out.println("Update successful");
        }
        else
            System.out.println("\nUpdate failed");

        System.out.println(TestStrings.testEnd);

        System.out.println("\nTest========setting list health conditions");
        if(PatientSQL.setHealthConditions(test))
        {
            System.out.println("Set successful");
        }
        else
            System.out.println("\nSet failed");

        System.out.println(TestStrings.testEnd);

        System.out.println("\nTest========Get list health conditions");
        if(PatientSQL.getHealthConditions(test)!=null)
        {
            System.out.println("Get successful");
        }
        else
            System.out.println("\nGet failed");

        System.out.println(TestStrings.testEnd);
    }
}