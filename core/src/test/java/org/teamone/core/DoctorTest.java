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
    public void getSpec() {

        System.out.println("\nTest========Getting for Specialty with doctor id ");
        String temp = DoctorSQL.getSpecialty(501);
        assertTrue("Could not get list of patients by doctor", !temp.isEmpty());


        System.out.println("Doctor is a: " + temp);


        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void getListofPatients() {
        Doctor new1 = new Doctor();
        new1.setUserID(501);
        System.out.println("\nTest========Searching for Patients with doctor id ");
        ArrayList<Patient> patientList = DoctorSQL.getDoctorPatientsList(new1);
        assertTrue("Could not get list of patients by doctor", !patientList.isEmpty());

        for (Patient tempPat : patientList) {
            System.out.println("Patient Name: " + tempPat.getName() + "\tPatient id: " + tempPat.getUserID());
        }

        System.out.println(TestStrings.testEnd);
    }



    @Test
    public void getListofPatientsBySpecialty() {
        System.out.println("\nTest========Searching for Patients for doctor specialty 'Emergency' ");
        ArrayList<Appointment> apptList = DoctorSQL.getListSpecialtyPatient("Emergency");
        assertTrue("Could not get list of patients by doctor", !apptList.isEmpty());

        for (Appointment temp : apptList) {
            System.out.println("Patient ID: " + temp.getPatientID() + "\tDate: " + temp.getDate() + "\tTime: " + temp.getTime());
        }

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void createAppt() {
        System.out.println("\nTest========Creating an appointment ");
        Appointment appt = AppointmentSQL.random();
        appt.setDoctorID(501);
        //boolean result = AppointmentSQL.createAppointment(appt);
        //assertTrue("Could not create appointment by doctor", result);


        System.out.println(TestStrings.testEnd);
    }
}