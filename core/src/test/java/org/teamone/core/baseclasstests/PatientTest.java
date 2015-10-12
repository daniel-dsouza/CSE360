package org.teamone.core.baseclasstests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import org.teamone.core.users.Patient;

/**
 * Created by daniel on 10/12/15.
 */
public class PatientTest {
    private Patient patient;

    @Before
    public void setup() {
        patient = new Patient();

        patient.patientInformation.setFirstName("Morty");
        patient.patientInformation.setLastName("Smith");
        patient.patientInformation.setAge("12");
        patient.patientInformation.setAddress("Jerry's house");
        patient.patientInformation.setCity("Nocity");
        patient.patientInformation.setState("Nostate");
        patient.patientInformation.setZipcode("Nozip");
        patient.patientInformation.setHomePhone("9876543210");
        patient.patientInformation.setEmail("morty@smith.com");
        patient.patientInformation.setInsurance("Allstate");
        patient.patientInformation.setSsn(456784569);
        patient.patientInformation.setGender("Male");

        for (String condition : patient.healthConditions.getKeys()) {
            patient.healthConditions.set(condition, true);
        }
    }
    @Test
    public void checkPatientInformation() {
        Assert.assertEquals("Testing first name", patient.patientInformation.getFirstName(), "Morty");
        Assert.assertEquals("Testing last name", patient.patientInformation.getLastName(), "Smith");
        Assert.assertEquals("Testing age", patient.patientInformation.getAge(), "12");
        Assert.assertEquals("Testing address", patient.patientInformation.getAddress(), "Jerry's house");
        Assert.assertEquals("Testing city", patient.patientInformation.getCity(), "Nocity");
        Assert.assertEquals("Testing state", patient.patientInformation.getState(), "Nostate");
        Assert.assertEquals("Testing zip", patient.patientInformation.getZipcode(), "Nozip");
        Assert.assertEquals("Testing phone", patient.patientInformation.getHomePhone(), "9876543210");
        Assert.assertEquals("Testing email", patient.patientInformation.getEmail(), "morty@smith.com");
        Assert.assertEquals("Testing insurance", patient.patientInformation.getInsurance(), "Allstate");
        Assert.assertEquals("Testing SSN", patient.patientInformation.getSsn(), 456784569);
        Assert.assertEquals("Testing Gender", patient.patientInformation.getGender(), "Male");

        System.out.println("Patient Information successfully modified and accessed");
    }

    @Test
    public void checkHealthConditions() {
        for (String condition : patient.healthConditions.getKeys()) {
            Assert.assertTrue(patient.healthConditions.isTrue(condition));
        }
    }
}
