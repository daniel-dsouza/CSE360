package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AlertSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Alert;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class AlertTest {

    private Alert test;
    private Patient test2;

    @Before
    public void setUp() {

        test = new Alert();
        test.setAlertID(2004);


    }

    @Before
    public void setUpPatient() {

        test2 = new Patient();
        test2.setUserID(1002);
        test2.healthConditions.toMapObj("anxiety,true:discoloredUrine,true");

    }

    @Test
    public void setAlertOf() {
        System.out.println("\nTest========Alert off health conditions");
        boolean check = AlertSQL.setAlertOff(test);
        //assertTrue("Failed to set alert off", check);//uncomment when read to test
        System.out.println("Off successful");
        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void checkAlertPopUp() {
        System.out.println("\nTest========Checking for alerts within a 5min");
        ArrayList<Alert> testArr = AlertSQL.getListAlertsPopUp();
        if (testArr != null) {
            Alert tempAlert;

            for (int i = 0; i < testArr.size(); i++) {
                tempAlert = testArr.get(i);
                System.out.println("Patient ID: " + tempAlert.getPatientID() + " has reason " + tempAlert.getReason());
                System.out.println("Timestamp: " + tempAlert.getAlertDateAndTime());
            }
        }
        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void setHC() {
        boolean check = PatientSQL.setHealthConditions(test2);
        assertTrue("Failed to set health conditions", check);
        System.out.println("Set/Update successful");
        System.out.println(TestStrings.testEnd);
    }

    /*@Test
    public void getListofAlerts() {
        System.out.println("Test========Attempting to get a few alerts");
        ArrayList<Alert> testArr = AlertSQL.getListAlerts();

        assertTrue("There were no alerts, subsequent tests will fail", !testArr.isEmpty());
        Alert tempAlert;

        for (int i = 0; i < 3; i++) {
            tempAlert = testArr.get(i);
            System.out.println("Name " + LoginSQL.getName(tempAlert.getPatientID()) + " has reason " + tempAlert.getReason());
            System.out.println("Alert ID: " + tempAlert.getAlertID());
            System.out.println("Timestamp: " + tempAlert.getAlertDateAndTime());
        }
        System.out.println(TestStrings.testEnd);
    }*/

    /*@Test
    public void getListByPatient() {
        System.out.println("\nTest========Searching for Alerts by patient ID 1002 ");
        Patient pat1 = new Patient();
        pat1.setUserID(1002);
        ArrayList<Alert> testArr = AlertSQL.getListAlertsByPatient(pat1);

        assertTrue("There were no alerts, subsequent tests will fail", !testArr.isEmpty());

        for (Alert tempAlert : testArr) {
            System.out.println("Name " + LoginSQL.getName(tempAlert.getPatientID()) + " has reason " + tempAlert.getReason());
            System.out.println("Alert ID: " + tempAlert.getAlertID());
            System.out.println("Timestamp: " + tempAlert.getAlertDateAndTime());
        }
        System.out.println(TestStrings.testEnd);
    }*/
}