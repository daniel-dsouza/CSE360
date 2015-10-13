package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.PersonUtils;
import org.teamone.core.users.Staff;

import java.util.ArrayList;

public class StaffListTest {

    private Staff test;

    @Before
    public void setUp() {

        test = new Staff();
        test.setSpecialty("Pediatrician");
    }

    @Test
    public void helpM() {
        ArrayList<Staff> testArr = PersonUtils.getStaffList("Pediatrician");
        System.out.println("\nTest========Searching for Staff members 'Pediatrician' ");
        if(testArr!=null)
        {

            Staff tempStaff;
            for(int i = 0; i < testArr.size(); i++) {
                tempStaff = testArr.get(i);
                System.out.println(tempStaff.getName());
            }
        }
        else
            System.out.println("SEARCH FAILED");
        System.out.println(TestStrings.testEnd);

        ArrayList<Appointment> testAppoint = PersonUtils.getPatientsAppointment("Patien2");
        System.out.println("\nTest========Searching for Patient's Appointments for 'Patien2' ");
        if(testAppoint!=null)
        {

            Appointment tempStaff;
            for(int i = 0; i < testAppoint.size(); i++) {
                tempStaff = testAppoint.get(i);

                System.out.println("Date:\t" + tempStaff.getDate());
                System.out.println("Time:\t" + tempStaff.getTime());
                System.out.println("Reason:\t" + tempStaff.getReason());
                System.out.println("DoctorID:\t" + tempStaff.getDoctorID());
                System.out.println("PatientID:\t" + tempStaff.getPatientID() + "\n");
            }
        }
        else
            System.out.println("SEARCH FAILED");
        System.out.println(TestStrings.testEnd);
    }
}