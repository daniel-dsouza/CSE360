package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

public class MedicalHistoryTest {

    private Patient test;

    @Before
    public void setUp() {

        test = new Patient();
        test.setPatientID(1234);
        test.setMedicalHistory("Ryan is a good boy");
    }

    @Test
    public void updateHC() {
        System.out.println("\nTest========setting list medical history");
        if(PatientSQL.setMedicalHistory(test))
        {
            System.out.println("Set successful");
        }
        else
            System.out.println("\nSet failed");

        System.out.println(TestStrings.testEnd);

        System.out.println("\nTest========Get list health conditions");
        if(PatientSQL.getMedicalHistory(test)!=null)
        {
            System.out.println("Get successful");
        }
        else
            System.out.println("\nGet failed");

        System.out.println(TestStrings.testEnd);
    }
}