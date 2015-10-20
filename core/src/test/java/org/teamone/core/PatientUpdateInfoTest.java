package org.teamone.core;
/**
 * Created by Lin on 2015/10/8.
 */

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

public class PatientUpdateInfoTest {

    private Patient regis;
    private Patient update;

    @Before
    public void setUp()
    {

        regis = new Patient();
        regis.patientInformation.setFirstName("newFirst");
        regis.patientInformation.setLastName("newLast");
        regis.patientInformation.setAddress("Eastern Ocean");
        regis.patientInformation.setCity("Tempe");
        regis.patientInformation.setState("AZ");
        regis.patientInformation.setZipcode("85200");
        regis.patientInformation.setEmail("luffy@asu.edu");
        regis.patientInformation.setHomePhone("13230932");
        regis.patientInformation.setSsn("987654321");
        regis.patientInformation.setInsurance("fight");
        regis.patientInformation.setAge("21");
        regis.patientInformation.setGender("male");
        regis.setPassword("hiRyan");

       /* update = new Patient();
        update.setPatientID(1245);
        update.setUserID(1245);
        update.setName("luffy;monkey");
        update.setAddress("Eastern Ocean");
        update.setEmail("luffy@asu.edu");
        update.setPhone("13230932");
        update.setSSN("987654321");
        update.setInsurance("fight");
        update.setAge("21");
        update.setGender("male");
        update.setPassword("hiRyan");*/

        String queryName = "luf";
    }

    @Test
    public void tester()
    {
        System.out.println("\nTest========Registering New Patient");
        if(HspSQL.RegisterNewPatient(regis))
        {
            System.out.println("*********************Register successful************************");
        }
        else
            System.out.println("\n************************Register failed********************");
        System.out.println(TestStrings.testEnd);

       /* System.out.println("\nTest========Updating Patient Infomation");
        if(PatientSQL.UpdatePersonalInfo(update))
        {
            System.out.println("*********************Update successful************************");
        }
        else
            System.out.println("\n************************Update failed********************");
        System.out.println(TestStrings.testEnd);


        ArrayList<Patient> patientList = PersonUtils.getPatients("luf");
        System.out.println("\nTest========Searching for Patient with 'luf' ");
        System.out.println("*********************Find successful************************");
        Patient tempPat;
        for(int i = 0; i < patientList.size(); i++) {
            tempPat = patientList.get(i);
            System.out.println("Patient Name: " + tempPat.getName() + "\tPatient id: " + tempPat.getPatientID());
        }
        System.out.println(TestStrings.testEnd);*/


    }

}