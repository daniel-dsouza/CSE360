package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LabStaffSQL;
import org.teamone.core.SQL.LabTestSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.labs.LabTest;

public class LabStaffTest {

    private LabTest test;

    @Before
    public void setUp() {

        test = new LabTest();
        test.getPatient().setPatientID(1001);
        test.toMapObj("potassium,Patient has enough potassium:");

    }

    @Test
    public void updateLabReport() {
        System.out.println("\nTest========update lab report");
        if(LabStaffSQL.updateLabTest(test)!=null)
        {

            System.out.println("Update lab test successful");
            System.out.println("PatientID:\t" + test.getPatient().getPatientID());
            System.out.println("Lab Report:\t" + test.toString());
            System.out.println("Date:\t" + test.getDate());


        }
        else
            System.out.println("\nUpdate lab failed");

        System.out.println(TestStrings.testEnd);

        System.out.println("\nTest========Viewing lab test");
        if(LabTestSQL.viewLabTest(test)!=null)
        {
            System.out.println("\nView successful");
            System.out.println("PatientID:\t" + test.getPatient().getPatientID());
            System.out.println("Lab Report:\t" + test.toString());
            System.out.println("Date:\t" + test.getDate());

        }
        else
            System.out.println("\nView failed");
        System.out.println(TestStrings.testEnd);



    }
}