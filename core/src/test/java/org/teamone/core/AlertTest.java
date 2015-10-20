package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Alert;

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
        test2.setPatientID(1245);
        test2.setHealthConditions("anxiety,true:");

    }

    @Test
    public void updateHC() {
        System.out.println("\nTest========Alert off health conditions");
        if(PatientSQL.setAlertOff(test))
        {
            System.out.println("Off successful");
        }
        else
            System.out.println("\nOff failed");

        System.out.println(TestStrings.testEnd);

        ArrayList<Alert> testArr = PatientSQL.getListAlerts();
        System.out.println("\nTest========Searching for Alerts ");
        if(testArr!=null)
        {

            Alert tempAlert;
            for(int i = 0; i < testArr.size(); i++) {
                tempAlert = testArr.get(i);
                System.out.println("Name " + LoginSQL.getName(tempAlert.getPatientID()) + " has reason "+tempAlert.getReason());
            }
        }
        else
            System.out.println("SEARCH FAILED");
        System.out.println(TestStrings.testEnd);

        if(PatientSQL.setHealthConditions(test2)) {
            System.out.println("Set/Update successful");
        }
        else {
            System.out.println("Set/Update failed");
        }

        System.out.println(TestStrings.testEnd);

    }
}