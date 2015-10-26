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

public class DoctorTest {


    @Before
    public void setUp() {

    }

    @Test
    public void viewAppointment() {


        Doctor new1 = new Doctor();
        new1.setStaffID(501);
        ArrayList<Patient> patientList = DoctorSQL.getDoctorPatientsList(new1);
        System.out.println("\nTest========Searching for Patients with doctor id ");
        if(patientList.size()!=0) {
            System.out.println("*********************Find successful************************");
            Patient tempPat;
            for (int i = 0; i < patientList.size(); i++) {
                tempPat = patientList.get(i);
                System.out.println("Patient Name: " + tempPat.getName() + "\tPatient id: " + tempPat.getPatientID());
            }
        } else
            System.out.println("\nFind failed");
        System.out.println(TestStrings.testEnd);

        System.out.println("\nTest========Searching for Avaiable Doctor Times ");
        ArrayList<Appointment> timesList = AppointmentSQL.getAvailableDoctorTimes(new1);
        if(timesList.size()!=0) {
            System.out.println("*********************Find successful************************");
            Appointment tempApp;
            for (int i = 0; i < timesList.size(); i++) {
                tempApp = timesList.get(i);
                System.out.println("Available Date: " + tempApp.getDate() + "\tTime: " + tempApp.getTime());
            }
        } else
            System.out.println("\nFind failed");
        System.out.println(TestStrings.testEnd);


    }
}