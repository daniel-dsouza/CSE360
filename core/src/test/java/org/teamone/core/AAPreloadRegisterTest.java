package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by system on 10/22/15.
 * This one is for preloading Patients. We can specify the date registered.
 */
public class AAPreloadRegisterTest {

    private Patient regis;
    private String date;

    @Before
    public void setUp() {

    }

    @Test
    public void PreloadRegisterTest() {
        for (int x = 0; x < 0; x++) {//Change this to become how many random dates
            randomTime();
            for (int i = 0; i < 1; i++) {//change this into how many patients to be registered on that date
                System.out.println("\nTest========Registering New Patient");
                regis = HspSQL.random();//call this to random
                Patient p = HspSQL.RegisterPreload(regis, date);
                assertTrue("Failed to register", p != null);//if p!=null returns false, display message
                System.out.println("*********************Register successful************************");
                System.out.println("New patient has id: " + p.getUserID());
                System.out.println(TestStrings.testEnd);

                //p.healthConditions.toMapObj("redFace,true:");
                //alerts: "anklePain", "bloodyStools", "discoloredUrine", "floatingStools", "footPain",
                //"impotence", "protrudingEyes", "redFace", "stomachPain", "swelling", "testiclePain", "vomitting"};

                //System.out.println("\nTest========Update health conditions");
                //boolean check = PatientSQL.setHealthConditions(p);
                //assertTrue("Failed to set health conditions", check);
                System.out.println(TestStrings.testEnd);
            }
        }

    }

    public void randomTime() {
        date = "2015-0";
        Random randomGenerator = new Random();
        date += Integer.toString(randomGenerator.nextInt((9 - 1) + 1));//random between month 1 and month 9
        date += "-";
        int test1 = randomGenerator.nextInt((28 - 1) + 1);//random between day 1 and day 28
        if (test1 <= 9)
            date += "0" + Integer.toString(test1);//since this is 1 digit number, we need a 0 in front of it
        else
            date += Integer.toString(test1);
        date += " 11:19:00";//we really dont care, so preloading is because HSP did it same exact time
    }
}