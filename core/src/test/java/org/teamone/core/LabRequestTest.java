package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LabRequestSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.labs.LabTestRequest;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LabRequestTest {

    private LabTestRequest test;

    @Before
    public void setUp() {
        Patient pat = new Patient();
        pat.setUserID(1002);
        Person per = new Person();
        per.setUserID(506);
        test = new LabTestRequest(0, "Hemoglobin,true:vitaminD,true:potassium,true:", pat, per);
    }

    @Test
    public void createLabRequest() {
        System.out.println("Test========Attempting to add lab request");
        boolean result = LabRequestSQL.addLabRequest(test);
        assertTrue("A lab request could not be added.", result);
        System.out.println(TestStrings.testEnd);
    }
    @Test
    public void createEmptyLabRequest() {
        System.out.println("Test========Attempting to add lab request with empty string");
        Patient pat = new Patient();
        pat.setUserID(1002);
        Person per = new Person();
        per.setUserID(505);
        LabTestRequest new1 = new LabTestRequest(0, "", pat, per);
        boolean result = LabRequestSQL.addLabRequest(new1);
        assertTrue("A lab request could not be added.", result);
        System.out.println(TestStrings.testEnd);
    }
    @Test
    public void listLabRequests() {
        System.out.println("Test========Attempting to get list of requests");
        ArrayList<LabTestRequest> result = LabRequestSQL.getAllLabRequests();
        assertTrue("There were not requests, subsequent tests will fail", !result.isEmpty());
        for (LabTestRequest request : result) {
            System.out.println("Found request with id :" + request.getRequestionID());
        }
        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void viewLabRequest() {
        System.out.println("Test========Attempting to get one request");
        LabTestRequest result = null;
        try {
            for (int i=0; i <20; i++) {
                LabTestRequest viewable = new LabTestRequest();
                viewable.setRequestionID(i);
                result = LabRequestSQL.viewLabRequest(viewable);
                if (result != null)
                    break;
            }
            assertNotNull("The result of the view operation for 1-19 was null", result);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        System.out.println(TestStrings.testEnd);
    }
}
