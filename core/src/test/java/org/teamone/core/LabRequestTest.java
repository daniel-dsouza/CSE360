package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LabTestSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.labs.LabTestRequest;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

public class LabRequestTest {

    private LabTestRequest test;

    @Before
    public void setUp() {

        Patient pat = new Patient();
        pat.setPatientID(1001);
        Doctor sta = new Doctor();
        sta.setStaffID(501);
        test = new LabTestRequest(0, "vitaminD,true:potassium,true:", pat, sta);

    }

    @Test
    public void updateLabReport() {
        /*System.out.println("\nTest========add lab request");
        if(DoctorSQL.addLabRequest(test)!=null)
        {

            System.out.println("add lab request successful");
            System.out.println("Date:\t" + test.getStrDateAndTime());


        }
        else
            System.out.println("\nadd lab requestfailed");
*/
        System.out.println(TestStrings.testEnd);

        System.out.println("\nTest========Viewing lab request through ID");
        test.setRequestionID(1);
        if(LabTestSQL.viewLabRequest(test)!=null)
        {
            System.out.println("\nView successful");
            System.out.println("PatientID:\t" + test.getPatient().getPatientID());
            System.out.println("Date:\t" + test.getStrDateAndTime());

        }
        else
            System.out.println("\nView failed");
        System.out.println(TestStrings.testEnd);

        System.out.println("\nTest========Extract all lab requests");
        ArrayList<LabTestRequest> tempList = LabTestSQL.getAllLabRequests();
        if(tempList!=null)
        {
            LabTestRequest tempRequest;
            for(LabTestRequest l : tempList)
            {
                System.out.println(l.getPatient().getName());
            }
        }
        else
            System.out.println("\nExtract failed");
        System.out.println(TestStrings.testEnd);

    }
}