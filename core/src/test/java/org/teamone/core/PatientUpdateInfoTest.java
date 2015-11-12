package org.teamone.core;
/**
 * Created by Lin on 2015/10/8.
 */

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;

import static org.junit.Assert.assertTrue;

public class PatientUpdateInfoTest {

    private Patient update;

    @Before
    public void setUp() {

        update = new Patient();
        update.setUserID(1002);
        update.patientInformation.setFirstName("Ryan");
        update.patientInformation.setLastName("Ang");
        update.patientInformation.setAddress("Eastern Ocean");
        update.patientInformation.setCity("Tempe");
        update.patientInformation.setState("AZ");
        update.patientInformation.setZipcode("85200");
        update.patientInformation.setEmail("new@asu.edu");
        update.patientInformation.setHomePhone("(480)-948-9940");
        update.patientInformation.setSsn("194-45-3453");
        update.patientInformation.setInsurance("The Fourth One");
        update.patientInformation.setAge("22");
        update.patientInformation.setGender("Male");

    }

    @Test
    public void tester() {
        System.out.println("\nTest========Updating Patient Infomation");
        Patient p = PatientSQL.UpdatePersonalInfo(update);
        assertTrue("Failed to update personal info", p != null);

        System.out.println("*********************Update successful************************");

        System.out.println(TestStrings.testEnd);
    }

}