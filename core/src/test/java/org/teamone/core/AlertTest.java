package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AlertSQL;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Alert;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

public class AlertTest {

    private Alert test;
    private Patient test2;

    @Before
    public void setUp() {

        test = new Alert();
        test.setAlertID(2);


    }
    @Before
    public void setUpPatient() {

        test2 = new Patient();
        test2.setPatientID(1001);
        test2.healthConditions.toMapObj("anxiety,true:discoloredUrine,true");
        test2.medicalHistory.toMapObj(":");

    }

    @Test
    public void updateHC() {
        System.out.println("\nTest========Alert off health conditions");
        if(AlertSQL.setAlertOff(test))//turn off alertID, 2
        {
            System.out.println("Off successful");
        }
        else
            System.out.println("\nOff failed");

        System.out.println(TestStrings.testEnd);

        PatientSQL.setMedicalHistory(test2);
        if(PatientSQL.setHealthConditions(test2)) {
            System.out.println("Set/Update successful");
        }
        else {
            System.out.println("Set/Update failed");
        }
        System.out.println(TestStrings.testEnd);


        ArrayList<Alert> testArr = AlertSQL.getListAlerts();
        System.out.println("\nTest========Searching for Alerts ");
        if(testArr!=null)
        {

            Alert tempAlert;
            for(int i = 0; i < testArr.size(); i++) {
                tempAlert = testArr.get(i);
                System.out.println("Name " + LoginSQL.getName(tempAlert.getPatientID()) + " has reason "+tempAlert.getReason());
                System.out.println("Alert ID: " + tempAlert.getAlertID());
                System.out.println("Timestamp: " + tempAlert.getAlertDateAndTime());
            }
        }
        else
            System.out.println("SEARCH FAILED");
        System.out.println(TestStrings.testEnd);



    }
}