package org.teamone.core;
/**
 * Created by Lin on 2015/10/8.
 */

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

public class PatientUpdateInfoTest {

    private Patient update;

    @Before
    public void setUp()
    {

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
       System.out.println("\nTest========Updating Patient Infomation");
        if(PatientSQL.UpdatePersonalInfo(update) != null)
        {
            System.out.println("*********************Update successful************************");
        }
        else
            System.out.println("\n************************Update failed********************");
        System.out.println(TestStrings.testEnd);
    }

}