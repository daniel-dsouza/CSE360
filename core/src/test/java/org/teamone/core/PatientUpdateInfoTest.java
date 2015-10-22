package org.teamone.core;
/**
 * Created by Lin on 2015/10/8.
 */

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

public class PatientUpdateInfoTest {

    private Patient regis;
    private Patient update;

    @Before
    public void setUp()
    {

        regis = new Patient();
        regis.patientInformation.setFirstName("newFirst");
        regis.patientInformation.setLastName("nw");
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

        update = new Patient();
        update.setPatientID(1004);
        update.setUserID(1004);
        update.patientInformation.setFirstName("Ryan");
        update.patientInformation.setLastName("Syani");
        update.patientInformation.setAddress("Eastern Ocean");
        update.patientInformation.setCity("Tempe");
        update.patientInformation.setState("AZ");
        update.patientInformation.setZipcode("85200");
        update.patientInformation.setEmail("new@as.edu");
        update.patientInformation.setHomePhone("(480)-948-9940");
        update.patientInformation.setSsn("194-45-3453");
        update.patientInformation.setInsurance("newSrurnace");
        update.patientInformation.setAge("22");
        update.patientInformation.setGender("male");

    }

    @Test
    public void tester()
    {
        System.out.println("\nTest========Registering New Patient");
        Patient p = HspSQL.RegisterNewPatient(regis);
        if(p!=null)
        {
            System.out.println("*********************Register successful************************");
            System.out.println("New patient has id: " + p.getPatientID());
        }
        else
            System.out.println("\n************************Register failed********************");
        System.out.println(TestStrings.testEnd);

       System.out.println("\nTest========Updating Patient Infomation");
        if(PatientSQL.UpdatePersonalInfo(update) != null)
        {
            System.out.println("*********************Update successful************************");
        }
        else
            System.out.println("\n************************Update failed********************");
        System.out.println(TestStrings.testEnd);


        ArrayList<Patient> patientList = PatientSQL.getPatientByPatient("new");
        System.out.println("\nTest========Searching for Patient with 'new' ");
        if(patientList.size()!=0) {
            System.out.println("*********************Find successful************************");
            Patient tempPat;
            for (int i = 0; i < patientList.size(); i++) {
                tempPat = patientList.get(i);
                System.out.println("Patient Name: " + tempPat.getName() + "\tPatient id: " + tempPat.getPatientID());
            }
        }
        System.out.println(TestStrings.testEnd);


    }

}