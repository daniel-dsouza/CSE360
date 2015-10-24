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
        String firstRNG ="RNG ";
        for(int i = 0; i< 10; i++)//firstName
        {
            firstRNG += (char) (randomGenerator.nextInt(26) + 'a');
        }
        String lastRNG = Integer.toString(randomInt);//lastname
        regis.patientInformation.setFirstName(firstRNG);
        regis.patientInformation.setLastName(lastRNG);
        firstRNG += "@asu.edu";
        regis.patientInformation.setEmail(firstRNG);
       String random = "" + (char) (randomGenerator.nextInt(26) + 'A');
        for(int i = 0; i< 10; i++)//address
        {
            random += (char) (randomGenerator.nextInt(26) + 'a');
        }

        regis.patientInformation.setAddress(random);
        regis.patientInformation.setCity("Tempe");
        regis.patientInformation.setState("AZ");
        random ="";
        for(int i = 0; i< 5; i++)//zipcode
        {
            random += (char) (randomGenerator.nextInt(10) + '0');
        }

        regis.patientInformation.setZipcode(random);

        random ="";
        for(int i = 0; i< 10; i++)//phone (480)-748-7374
        {
            if( i==0)
                random +="(";
            if( i==3)
                random +=")-";
            if( i==6)
                random +="-";
            random += (char) (randomGenerator.nextInt(10) + '0');
        }
        regis.patientInformation.setHomePhone(random);
        random ="";
        for(int i = 0; i < 9; i++)//SSN 000-00-0000
        {
            if( i==3)
                random +="-";
            if( i==5)
                random +="-";
            random += (char) (randomGenerator.nextInt(10) + '0');
        }
        regis.patientInformation.setSsn(random);
        random = "" + (char) (randomGenerator.nextInt(26) + 'A');
        for(int i = 0; i< 10; i++)//insurance
        {
            random += (char) (randomGenerator.nextInt(26) + 'a');
        }
        regis.patientInformation.setInsurance(random);

        int age = randomGenerator.nextInt(50);//age
            random =Integer.toString(age);
        regis.patientInformation.setAge(random);

        String gender ="";
        if((randomGenerator.nextInt(10)%2)==0)//even
            gender ="Female";
        else
            gender = "Male";
        regis.patientInformation.setGender(gender);

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