package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class DoctorTest {


    @Before
    public void setUp() {

    }

    @Test
    public void getListofPatients() {
        Doctor new1 = new Doctor();
        new1.setUserID(501);
        System.out.println("\nTest========Searching for Patients with doctor id ");
        ArrayList<Patient> patientList = DoctorSQL.getDoctorPatientsList(new1);
        assertTrue("Could not get list of patients by doctor", !patientList.isEmpty());

        Patient tempPat;
        for (int i = 0; i < patientList.size(); i++) {
            tempPat = patientList.get(i);
            System.out.println("Patient Name: " + tempPat.getName() + "\tPatient id: " + tempPat.getUserID());
        }

        System.out.println(TestStrings.testEnd);
    }
    @Test
    public void getAvailableTimes() {
        System.out.println("\nTest========Searching for Available Doctor Times ");
        Doctor new1 = new Doctor();
        new1.setUserID(501);
        ArrayList<Appointment> timesList = AppointmentSQL.getAvailableDoctorTimes(new1);
        assertTrue("Could not get Available Doctor Times", !timesList.isEmpty());

            System.out.println("*********************Find successful************************");
            Appointment tempApp;
            for (int i = 0; i < timesList.size(); i++) {
                tempApp = timesList.get(i);
                System.out.println("Available Date: " + tempApp.getDate() + "\tTime: " + tempApp.getTime());
            }

        System.out.println(TestStrings.testEnd);


    }
}