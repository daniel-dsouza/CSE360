package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

import java.util.Random;

/**
 * Created by system on 10/22/15.
 */
public class RegisterTest {

    private Patient regis;
    private Patient update;

    @Before
    public void setUp() {

        regis = new Patient();
        Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(1000);
        String lastRNG = Integer.toString(randomInt);
        regis.patientInformation.setFirstName("Random generator");
        regis.patientInformation.setLastName(lastRNG);
        regis.patientInformation.setAddress("Eastern Ocean");
        regis.patientInformation.setCity("Tempe");
        regis.patientInformation.setState("AZ");
        regis.patientInformation.setZipcode("85200");
        regis.patientInformation.setEmail("luffy@au.edu");
        regis.patientInformation.setHomePhone("13230932");
        regis.patientInformation.setSsn("987654321");
        regis.patientInformation.setInsurance("fight");
        regis.patientInformation.setAge("21");
        regis.patientInformation.setGender("male");
        regis.setPassword("hiRyan");

    }
        @Test
    public void tester() {
        System.out.println("\nTest========Registering New Patient");
        Patient p = HspSQL.RegisterNewPatient(regis);
        if (p != null) {
            System.out.println("*********************Register successful************************");
            System.out.println("New patient has id: " + p.getPatientID());
        } else
            System.out.println("\n************************Register failed********************");
        System.out.println(TestStrings.testEnd);

    }
}