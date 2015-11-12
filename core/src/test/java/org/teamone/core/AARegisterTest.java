package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

import static org.junit.Assert.assertTrue;

/**
 * Created by system on 10/22/15.
 */
public class AARegisterTest {

    private Patient regis;
    private Patient update;

    @Before
    public void setUp() {

    }

    @Test
    public void RegisterTest() {
        for (int i = 0; i < 0; i++) {//change this into how many runs u want.
            System.out.println("\nTest========Registering New Patient");
            regis = HspSQL.random();//call this to random
            Patient p = HspSQL.RegisterNewPatient(regis);
            assertTrue("Failed to register", p != null);//if p!=null returns false, display message
            System.out.println("*********************Register successful************************");
            System.out.println("New patient has id: " + p.getUserID());
            System.out.println(TestStrings.testEnd);

            p.healthConditions.toMapObj("redFace,true:");
            //alerts: "anklePain", "bloodyStools", "discoloredUrine", "floatingStools", "footPain",
            //"impotence", "protrudingEyes", "redFace", "stomachPain", "swelling", "testiclePain", "vomitting"};

            System.out.println("\nTest========Update health conditions");
            boolean check = PatientSQL.setHealthConditions(p);
            assertTrue("Failed to set health conditions", check);
            System.out.println(TestStrings.testEnd);
        }

    }

}