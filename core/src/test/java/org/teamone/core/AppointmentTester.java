package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.baseclasstests.TestStrings;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AppointmentTester {

    private Appointment create;//doctor creates one
    private Appointment sched;//Patient gets to picka  list of NULL values. fill in row
    private Appointment update;//swap values

    @Before
    public void setUp() {
        create = new Appointment();
        create.setDoctorID(501);
        create.setTime("9:00 AM");
        create.setDate("2015-12-13");

        sched = new Appointment();
        sched.setDoctorID(501);
        sched.setTime("9:00 AM");
        sched.setDate("2015-12-13");
        sched.setAppointmentID(56);
        sched.setPatientID(1002);
        sched.setReason("I want to see doctor");


        update = new Appointment();
        update.setPatientID(1002);
        update.setDoctorID(501);
        update.setReason("Changing dates");
        update.setTime("11:00 AM");
        update.setDate("2015-12-26");
        update.setAppointmentID(5);//new id. frontend extracts the oldID with "getAppointmentID" and uses as second parameter


    }

    @Test
    public void createAppt() //doctor calls this
    {
        System.out.println("\nTest========Creating appointment");
        Boolean check = AppointmentSQL.createAppointment(create);
        assertTrue("Create appointment failed ", check);
        System.out.println("\nCreate successful");
        System.out.println("Date:\t" + create.getDate());
        System.out.println("Time:\t" + create.getTime());
        System.out.println("Reason:\t" + create.getReason());
        System.out.println("Doctor ID:\t" + create.getDoctorID());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void dSchedAppt() //patient calls this when updating an existing one
    {
        System.out.println("\nTest========Scheduling appointment");
        Boolean check = AppointmentSQL.schedAppointmentAppt(sched);
        assertTrue("editing appointment by patient ID failed ", check);
        System.out.println("\nUpdate successful");
        System.out.println("Date:\t" + sched.getDate());
        System.out.println("Time:\t" + sched.getTime());
        System.out.println("Reason:\t" + sched.getReason());
        System.out.println("Doctor ID:\t" + sched.getDoctorID());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void editApptByApptID() //edit an already filled appointment. This must be the old time is now free for other users
    {
        System.out.println("\nTest========updating Appointment with appt ID");

        Boolean newTest = AppointmentSQL.swapAppointmentAppt(update, 56);
        assertTrue("Could not edit appointment by appt id", newTest);

        System.out.println("\nupdate successful");

        System.out.println(TestStrings.testEnd);
    }
    @Test
    public void viewApptByDocID() {
        //case 1, where user wants appoint through doctorID
        System.out.println("\nTest========Viewing patient with doctor ID");
        List<Appointment> test1 = AppointmentSQL.viewAppointmentByDoctor(update);
        assertTrue("No appointments by doctor ID", !test1.isEmpty());

        for (Appointment tempAp : test1) {
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
        update.setPatientID(1002);
        System.out.println("\nTest========Viewing patient with patient ID");
        List<Appointment> test1 = AppointmentSQL.viewAppointmentByPatient(update);
        assertTrue("No appointments by patient ID", !test1.isEmpty());
        for (Appointment tempAp : test1) {
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
        update.setAppointmentID(5);
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




    /*@Test
    public void zGetAppointmentID() {
        Appointment view = new Appointment();//doctorID, Time, PatientID, and Date,
        view.setDate("2015-12-26");
        view.setTime("11:00 AM");
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
    }*/

}