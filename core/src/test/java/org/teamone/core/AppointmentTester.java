package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AppointmentViewEdit;

public class AppointmentTester {

    private Appointments test;

    @Before
    public void setUp() {

        test = new Appointments();
        test.setDoctorID(101);
    }

    @Test
    public void viewAppointments() {

        //case 1, where user wants appoint through doctorID
        if(AppointmentViewEdit.viewAppointmentDoctor(test)!=null)//view appoint returns a object appointments
        {
            System.out.println("\nView successful");
            System.out.println("Date:\t" + test.getDate());
            System.out.println("Time:\t" + test.getTime());
            System.out.println("Reason:\t" + test.getReason());
            System.out.println("Patient ID:\t" + test.getPatientID());
        }
        else
            System.out.println("\nView failed");

        //case 2, where user wants appoint through patientID
        test.setPatientID(102);
        if(AppointmentViewEdit.viewAppointmentPatient(test)!=null)//view appoint returns a object appointments
        {
            System.out.println("\nView successful");
            System.out.println("Date:\t" + test.getDate());
            System.out.println("Time:\t" + test.getTime());
            System.out.println("Reason:\t" + test.getReason());
            System.out.println("Doctor ID:\t" + test.getDoctorID());
        }
        else
            System.out.println("\nView failed");

    }
}