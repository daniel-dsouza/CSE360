package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.baseclasstests.TestStrings;

import java.util.Date;
import java.util.List;

public class AppointmentTester {

    private Appointment test;
    private Appointment update;
    @Before
    public void setUp() {


        update = new Appointment();
        update.setPatientID(1001);
        update.setDoctorID(501);
        update.setReason("I want to see doctor");
        update.setTime("1:00 pm");
        Date dt = new Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(dt);
        update.setDate(time);

        test = new Appointment();
        test.setDoctorID(501);
    }

    @Test
    public void viewAppointment() {
        //case 1, where user wants appoint through PatientID
        System.out.println("\nTest========Updating patient with patient ID");
        if(AppointmentSQL.editAppointmentPatient(update)!=null)//edit appoint returns a object Appointment
        {
            System.out.println("\nUpdate successful");
            System.out.println("Date:\t" + update.getDate());
            System.out.println("Time:\t" + update.getTime());
            System.out.println("Reason:\t" + update.getReason());
            System.out.println("Doctor ID:\t" + update.getDoctorID());
        }
        else
            System.out.println("\nUpdate failed");
        System.out.println(TestStrings.testEnd);

        //case 2, where user wants appoint through DoctorID
        System.out.println("\nTest========Updating patient with doctor ID");
        if(AppointmentSQL.editAppointmentDoctor(update)!=null)//edit appoint returns a object Appointment
        {
            System.out.println("\nUpdate successful");
            System.out.println("Date:\t" + update.getDate());
            System.out.println("Time:\t" + update.getTime());
            System.out.println("Reason:\t" + update.getReason());
            System.out.println("Patient ID:\t" + update.getPatientID());
        }
        else
            System.out.println("\nUpdate failed");
        System.out.println(TestStrings.testEnd);

        //case 1, where user wants appoint through doctorID
        System.out.println("\nTest========Viewing patient with doctor ID");
        List<Appointment> test1 = AppointmentSQL.viewAppointmentDoctor(test);
        if(test1 !=null)//view appoint returns a list Appointment
        {
            Appointment tempAp;
            for(int i = 0; i < test1.size(); i++) {
                tempAp = test1.get(i);
                System.out.println("\nView successful");
                System.out.println("Date:\t" + tempAp.getDate());
                System.out.println("Time:\t" + tempAp.getTime());
                System.out.println("Reason:\t" + tempAp.getReason());
                System.out.println("Patient ID:\t" + tempAp.getPatientID());
            }
        }
        else
            System.out.println("\nView failed");
        System.out.println(TestStrings.testEnd);

        //case 2, where user wants appoint through patientID
        test.setPatientID(1001);
        System.out.println("\nTest========Viewing patient with patient ID");
        test1 = AppointmentSQL.viewAppointmentPatient(test);
        if(test1!=null)//view appoint returns a object Appointment
        { Appointment tempAp;
            for(int i = 0; i < test1.size(); i++) {
                tempAp = test1.get(i);
                System.out.println("\nView successful");
                System.out.println("Date:\t" + tempAp.getDate());
                System.out.println("Time:\t" + tempAp.getTime());
                System.out.println("Reason:\t" + tempAp.getReason());
                System.out.println("Doctor ID:\t" + tempAp.getDoctorID());
            }
        }
        else
            System.out.println("\nView failed");
        System.out.println(TestStrings.testEnd);


       //case 1
        update.setAppointmentID(1);
        System.out.println("\nTest========Viewing Appointment with appt ID");
        test1 = AppointmentSQL.viewAppointmentAppt(update);
        if(test1!=null)//view appoint returns a object Appointment
        { Appointment tempAp;
            for(int i = 0; i < test1.size(); i++) {
                tempAp = test1.get(i);
                System.out.println("\nView successful");
                System.out.println("Date:\t" + tempAp.getDate());
                System.out.println("Time:\t" + tempAp.getTime());
                System.out.println("Reason:\t" + tempAp.getReason());
                System.out.println("Doctor ID:\t" + tempAp.getDoctorID());
                System.out.println("Patient ID:\t" + tempAp.getPatientID());
                System.out.println("Patient address:\t" + tempAp.getPatient().getAddress());
            }
        }
        else
            System.out.println("\nView failed");
        System.out.println(TestStrings.testEnd);

        //case 2
        update.setReason("I need a new reason");
        System.out.println("\nTest========updating Appointment with appt ID");

        Appointment newTest = AppointmentSQL.editAppointmentAppt(update);
        if(newTest!=null)//view appoint returns a object Appointment
        {
                System.out.println("\nView successful");
                System.out.println("Date:\t" + newTest.getDate());
                System.out.println("Time:\t" + newTest.getTime());
                System.out.println("Reason:\t" + newTest.getReason());
                System.out.println("Doctor ID:\t" + newTest.getDoctorID());
                System.out.println("Patient ID:\t" + newTest.getPatientID());
                System.out.println("Patient address:\t" + newTest.getPatient().getAddress());
        }
        else
            System.out.println("\nView failed");
        System.out.println(TestStrings.testEnd);
    }
}