package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.baseclasstests.TestStrings;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AppointmentTester {

    private Appointment test;
    private Appointment update;

    @Before
    public void setUp() {


        update = new Appointment();
        update.setPatientID(1002);
        update.setDoctorID(501);
        update.setReason("I want to see doctor");
        update.setTime("10:00 PM");
        update.setDate("2015-11-27");

        test = new Appointment();
        test.setDoctorID(501);
    }

    @Test
    public void editAppt() {
        System.out.println("\nTest========Updating appointment");
        update = AppointmentSQL.editAppointment(update);
        assertTrue("editing appointment by patient ID failed ", update != null);
        System.out.println("\nUpdate successful");
        System.out.println("Date:\t" + update.getDate());
        System.out.println("Time:\t" + update.getTime());
        System.out.println("Reason:\t" + update.getReason());
        System.out.println("Doctor ID:\t" + update.getDoctorID());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void viewApptByDocID() {
        //case 1, where user wants appoint through doctorID
        System.out.println("\nTest========Viewing patient with doctor ID");
        List<Appointment> test1 = AppointmentSQL.viewAppointmentByDoctor(test);
        assertTrue("No appointments by doctor ID", !test1.isEmpty());

        Appointment tempAp;
        for (int i = 0; i < test1.size(); i++) {
            tempAp = test1.get(i);
            System.out.println("\nView successful");
            System.out.println("Date:\t" + tempAp.getDate());
            System.out.println("Time:\t" + tempAp.getTime());
            System.out.println("Reason:\t" + tempAp.getReason());
            System.out.println("Patient ID:\t" + tempAp.getPatientID());
        }

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void viewApptByPatID() {
        //case 2, where user wants appoint through patientID
        test.setPatientID(1002);
        System.out.println("\nTest========Viewing patient with patient ID");
        List<Appointment> test1 = AppointmentSQL.viewAppointmentByPatient(test);
        assertTrue("No appointments by patient ID", !test1.isEmpty());
        Appointment tempAp;
        for (int i = 0; i < test1.size(); i++) {
            tempAp = test1.get(i);
            System.out.println("\nView successful");
            System.out.println("Date:\t" + tempAp.getDate());
            System.out.println("Time:\t" + tempAp.getTime());
            System.out.println("Reason:\t" + tempAp.getReason());
            System.out.println("Doctor ID:\t" + tempAp.getDoctorID());
        }

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void viewApptByAppID() {
        //case 1
        update.setAppointmentID(6);
        System.out.println("\nTest========Viewing Appointment with appt ID");
        Appointment test1 = AppointmentSQL.viewAppointmentByApptID(update);
        assertTrue("No appointment by appointment ID", test1 != null);

        System.out.println("\nView successful");
        System.out.println("Date:\t" + test1.getDate());
        System.out.println("Time:\t" + test1.getTime());
        System.out.println("Reason:\t" + test1.getReason());
        System.out.println("Doctor ID:\t" + test1.getDoctorID());
        System.out.println("Patient ID:\t" + test1.getPatientID());
        //System.out.println("Patient address:\t" + test1.getPatient().getAddress());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void editApptByApptID() {
        //case 2
        update.setReason("I need a new reason");
        update.setAppointmentID(6);
        System.out.println("\nTest========updating Appointment with appt ID");

        Appointment newTest = AppointmentSQL.editAppointmentAppt(update);
        assertTrue("Could not edit appointment by appt id", newTest != null);//view appoint returns a object Appointment

        System.out.println("\nupdate successful");
        System.out.println("Date:\t" + newTest.getDate());
        System.out.println("Time:\t" + newTest.getTime());
        System.out.println("Reason:\t" + newTest.getReason());
        System.out.println("Doctor ID:\t" + newTest.getDoctorID());
        System.out.println("Patient ID:\t" + newTest.getPatientID());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void zGetAppointmentID() {
        Appointment view = new Appointment();//doctorID, Time, PatientID, and Date,
        view.setDate("2015-12-24");
        view.setTime("9:00 PM");
        view.setDoctorID(502);
        view.setPatientID(1002);
        System.out.println("\nTest========Getting Appointment ID");
        Appointment new1 = AppointmentSQL.getAppointmentID(view);
        assertTrue("Could not get appointment ID", new1 != null);

        System.out.println("\nView successful");
        System.out.println("Date:\t" + new1.getDate());
        System.out.println("Time:\t" + new1.getTime());
        System.out.println("Reason:\t" + new1.getReason());
        System.out.println("Appointment ID:\t" + new1.getAppointmentID());


        System.out.println(TestStrings.testEnd);
    }

}