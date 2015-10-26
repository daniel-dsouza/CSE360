package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.SQL.LabTestSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.labs.LabTestRequest;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;

import javax.print.Doc;
import java.util.ArrayList;

public class LabRequestTest {

    private LabTestRequest test;

    @Before
    public void setUp() {
        Patient pat = new Patient();
        pat.setPatientID(1005);
        Person per = new Person();
        per.setUserID(506);
        test = new LabTestRequest(0, "Hemoglobin,true:vitaminD,true:potassium,true:", pat, per);
    }

    @Test
    public void createLabRequest() {
        System.out.println("Attempting to add lab request");
        boolean result = DoctorSQL.addLabRequest(test);
        assertTrue("A lab request could not be added.", result);
    }

    @Test
    public void listLabRequests() {
        System.out.println("Attempting to get list of requests");
        ArrayList<LabTestRequest> result = LabTestSQL.getAllLabRequests();
        assertTrue("There were not requests, subsequent tests will fail", !result.isEmpty());
        for (LabTestRequest request : result) {
            System.out.println("Found request with id :" + request.getRequestionID());
        }
    }

    @Test
    public void viewLabRequest() {
        System.out.println("Attempting to get one request");
        LabTestRequest result = null;
        try {
            for (int i=0; i <20; i++) {
                LabTestRequest viewable = new LabTestRequest();
                viewable.setRequestionID(i);
                result = LabTestSQL.viewLabRequest(viewable);
                if (result != null)
                    break;
            }
            assertNotNull("The result of the view operation for 1-19 was null", result);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}