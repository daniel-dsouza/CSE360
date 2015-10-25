package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LabStaffSQL;
import org.teamone.core.SQL.LabTestSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.labs.LabTest;

import java.util.Date;

public class LabStaffTest {

    private LabTest test;

    @Before
    public void setUp() {

        test = new LabTest();
        test.setPatientID(1001);
        test.setLabReport("Patient has negative results. The CT scan was clear.");

        Date dt = new Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(dt);
        test.setStrDateAndTime(time);

    }

    @Test
    public void updateLabReport() {
        System.out.println("\nTest========update lab report");
        if(LabStaffSQL.updateLabTest(test)!=null)
        {

            System.out.println("Update lab test successful");
            System.out.println("PatientID:\t" + test.getPatientID());
            System.out.println("Lab Report:\t" + test.getLabReport());
            System.out.println("Date:\t" + test.getStrDateAndTime());


        }
        else
            System.out.println("\nUpdate lab failed");

        System.out.println(TestStrings.testEnd);

        System.out.println("\nTest========Viewing lab test");
        if(LabTestSQL.viewLabTest(test)!=null)
        {
            System.out.println("\nView successful");
            System.out.println("PatientID:\t" + test.getPatientID());
            System.out.println("Lab Report:\t" + test.getLabReport());
            System.out.println("Date:\t" + test.getStrDateAndTime());

        }
        else
            System.out.println("\nView failed");
        System.out.println(TestStrings.testEnd);



    }
}