package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

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
    public void RegisterTest()
        {
            for(int i = 0; i < 1; i++) {//change this into how many runs u want.
                System.out.println("\nTest========Registering New Patient");
                random();//call this to random
                Patient p = HspSQL.RegisterNewPatient(regis);
                assertTrue("Failed to register", p!=null);//if p!=null returns false, display message
                    System.out.println("*********************Register successful************************");
                System.out.println("New patient has id: " + p.getUserID());
                System.out.println(TestStrings.testEnd);

                p.healthConditions.toMapObj("redFace,true:");
                //alerts: "anklePain", "bloodyStools", "discoloredUrine", "floatingStools", "footPain",
                //"impotence", "protrudingEyes", "redFace", "stomachPain", "swelling", "testiclePain", "vomitting"};

                System.out.println("\nTest========Update health conditions");
                boolean check =PatientSQL.setHealthConditions(p);
                assertTrue("Failed to set health conditions", check);
                System.out.println(TestStrings.testEnd);
            }

    }
    public void random()//randomizer so we can loop multiple
    {
        regis = new Patient();
        Random randomGenerator = new Random();

        //pick female or male name http://deron.meranda.us/data/
        String firstFile = "src/test/java/org/teamone/core/input/Female.txt";
        int femaleOrMale = randomGenerator.nextInt(500);
        if((femaleOrMale%2)==0)//even
            firstFile ="src/test/java/org/teamone/core/input/Male.txt";

        String lastFile = "src/test/java/org/teamone/core/input/lastNames.txt";

        //First Name array
        ArrayList<String> firstNames = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(firstFile));
            while (in.ready()) {
                firstNames.add(in.readLine());
            }
            in.close();
        }
        catch(Exception e){    System.out.println(e);    }
        //Last Name array
        ArrayList<String> lastNames = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(firstFile));
            while (in.ready()) {
                lastNames.add(in.readLine());
            }
            in.close();
        }
        catch(Exception e){System.out.println(e);

        }

        String firstRNG = firstNames.get(randomGenerator.nextInt(firstNames.size()));
        String lastRNG = lastNames.get(randomGenerator.nextInt(lastNames.size()));
        regis.patientInformation.setFirstName(firstRNG);
        regis.patientInformation.setLastName(lastRNG);
        firstRNG += lastRNG + "@asu.edu";
        regis.patientInformation.setEmail(firstRNG);
        String random = "" + (char) (randomGenerator.nextInt(26) + 'A');
        for(int i = 0; i< 10; i++)//address
        {
            random += (char) (randomGenerator.nextInt(26) + 'a');
        }

        //Street Name array
        String streetFile = "src/test/java/org/teamone/core/input/StreetNamesTempe.txt";
        ArrayList<String> streets = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(streetFile));
            while (in.ready()) {
                streets.add(in.readLine());
            }
            in.close();
        }
        catch(Exception e){System.out.println(e);

        }
        regis.patientInformation.setAddress(streets.get(randomGenerator.nextInt(streets.size())));
        regis.patientInformation.setCity("Phoenix");
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

        //Insurance array
        String insureFile = "src/test/java/org/teamone/core/input/Insurance.txt";
        ArrayList<String> insure = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(insureFile));
            while (in.ready()) {
                insure.add(in.readLine());
            }
            in.close();
        }
        catch(Exception e){System.out.println(e);

        }
        regis.patientInformation.setInsurance((insure.get(randomGenerator.nextInt(insure.size()))));

        int age = randomGenerator.nextInt(100);//age
        random =Integer.toString(age);
        regis.patientInformation.setAge(random);

        String gender ="Female";
        if((femaleOrMale%2)==0)//even
            gender = "Male";
        regis.patientInformation.setGender(gender);
    }
}