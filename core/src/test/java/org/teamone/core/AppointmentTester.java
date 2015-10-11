package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AppointmentViewEdit;
import org.teamone.core.appointments.Appointment;

public class AppointmentTester {

    private Appointment test;
    private Appointment update;
    @Before
    public void setUp() {


        update = new Appointment();
        update.setPatientID(1246);
        update.setDoctorID(1232);
        update.setReason("I want to see doctor");
        update.setTime("1:00 pm");
        update.setDate("10/01/2011");

        test = new Appointment();
        test.setDoctorID(1232);
    }

    @Test
    public void viewAppointment() {
        //case 1, where user wants appoint through PatientID
        if(AppointmentViewEdit.editAppointmentPatient(update)!=null)//edit appoint returns a object Appointment
        {
            System.out.println("\nUpdate successful");
            System.out.println("Date:\t" + update.getDate());
            System.out.println("Time:\t" + update.getTime());
            System.out.println("Reason:\t" + update.getReason());
            System.out.println("Doctor ID:\t" + update.getDoctorID());
        }
        else
            System.out.println("\nUpdate failed");

        //case 2, where user wants appoint through DoctorID
        if(AppointmentViewEdit.editAppointmentPatient(update)!=null)//edit appoint returns a object Appointment
        {
            System.out.println("\nUpdate successful");
            System.out.println("Date:\t" + update.getDate());
            System.out.println("Time:\t" + update.getTime());
            System.out.println("Reason:\t" + update.getReason());
            System.out.println("Patient ID:\t" + update.getPatientID());
        }
        else
            System.out.println("\nUpdate failed");


        //case 1, where user wants appoint through doctorID
        if(AppointmentViewEdit.viewAppointmentDoctor(test)!=null)//view appoint returns a object Appointment
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
        if(AppointmentViewEdit.viewAppointmentPatient(test)!=null)//view appoint returns a object Appointment
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