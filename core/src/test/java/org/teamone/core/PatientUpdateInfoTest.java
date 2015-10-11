package org.teamone.core;
/**
 * Created by Lin on 2015/10/8.
 */

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.users.Patient;
import org.teamone.core.users.PersonUtils;

import java.util.ArrayList;

public class PatientUpdateInfoTest {

    private Patient regis;
    private Patient update;

    @Before
    public void setUp()
    {
        /*
        regis = new Patient();
        regis.setPatientID(123);
        regis.setUserID(123);
        regis.setName("luffy;monkey");
        regis.setAddress("Eastern Ocean");
        regis.setEmail("luffy@asu.edu");
        regis.setPhone(13230932);
        regis.setSSN(987654321);
        regis.setInsurance("fight");
        regis.setAge(21);
        regis.setGender("male");
        regis.setPassword("hiRyan");

        update = new Patient();
        update.setPatientID(1245);
        update.setUserID(1245);
        update.setName("luffy;monkey");
        update.setAddress("Eastern Ocean");
        update.setEmail("luffy@asu.edu");
        update.setPhone(13230932);
        update.setSSN(987654321);
        update.setInsurance("fight");
        update.setAge(21);
        update.setGender("male");
        update.setPassword("hiRyan");
        */
        String queryName = "luf";
    }

    @Test
    public void tester()
    {
        /*
        if(HSPRegistration.RegisterNewPatient(regis))
        {
            System.out.println("*********************Register successful************************");
        }
        else
            System.out.println("\n************************Register failed********************");
        if(PatientUpdateInfo.UpdatePersonalInfo(update))
        {
            System.out.println("*********************Update successful************************");
        }
        else
            System.out.println("\n************************Update failed********************");
        */
        ArrayList<Patient> patientList = PersonUtils.getPatients("luf");
        System.out.println("*********************Find successful************************");
        System.out.println("******"+patientList+"***********");


    }

}