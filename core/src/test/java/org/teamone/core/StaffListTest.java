package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class StaffListTest {

    private Staff test;

    @Before
    public void setUp() {

        test = new Staff();
        test.setSpecialty("Pediatrician");
    }

    @Test
    public void getListDoctorBySpecialty() {
        System.out.println("\nTest========Searching for Staff members 'Pediatrician' ");
        ArrayList<Staff> testArr = DoctorSQL.getListDoctorSpecialty("Emergency");
        assertTrue("Failed to get doctor specialty", !testArr.isEmpty());

        Staff tempStaff;
        for (int i = 0; i < testArr.size(); i++) {
            tempStaff = testArr.get(i);
            System.out.println(tempStaff.getName());
        }

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void getPatientsAppointmentByName() {
        System.out.println("\nTest========Searching for Patient's Appointments for 'RNG xzkcnmbeaz:894' ");
        ArrayList<Appointment> testAppoint = AppointmentSQL.getPatientsAppointment("RNG xzkcnmbeaz:894");
        assertTrue("Failed to get appointments by name", !testAppoint.isEmpty());

        Appointment tempStaff;
        for (int i = 0; i < testAppoint.size(); i++) {
            tempStaff = testAppoint.get(i);

            System.out.println("Date:\t" + tempStaff.getDate());
            System.out.println("Time:\t" + tempStaff.getTime());
            System.out.println("Reason:\t" + tempStaff.getReason());
            System.out.println("DoctorID:\t" + tempStaff.getDoctorID());
            System.out.println("PatientID:\t" + tempStaff.getPatientID() + "\n");
        }

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void getPatientsByName() {
        System.out.println("\nTest========Searching for Patient with 'RNG' ");
        ArrayList<Patient> patientList = PatientSQL.getPatientByPatient("RNG");
        assertTrue("Failed to get Patient list by name", !patientList.isEmpty());

        System.out.println("*********************Find successful************************");
        Patient tempPat;
        for (int i = 0; i < patientList.size(); i++) {
            tempPat = patientList.get(i);
            System.out.println("Patient Name: " + tempPat.getName() + "\tPatient id: " + tempPat.getUserID());
        }

        System.out.println(TestStrings.testEnd);

    }

}