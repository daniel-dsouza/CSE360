package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;
import org.teamone.core.users.Staff;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class zAdmin {

    private Staff test;

    @Before
    public void setUp() {

        test = new Staff();
        test.setSpecialty("MASTER");
    }

    @Test
    public void getAllPersons() {
        System.out.println("\n======================================");
        System.out.println("Dumping person table.");
        System.out.println("======================================");
        ArrayList<Person> testArr = HspSQL.revealAll();
        assertTrue("Failed to dump person table", !testArr.isEmpty());

        Person temp;
        for (int i = 0; i < testArr.size(); i++) {
            temp = testArr.get(i);
            System.out.print("UserID: " + temp.getUserID() + "\t\tName: " + temp.getName() + "\t\tOccupation: " + temp.getOccupation());
            System.out.println("\t\tpassword: " + temp.getPassword() + "\t\temail: " + temp.getEmail());
        }

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void getAllPatients() {
        System.out.println("\n======================================");
        System.out.println("Getting all patients");
        System.out.println("======================================");
        ArrayList<Patient> patientArr = PatientSQL.getAllPatient();
        assertTrue("Failed to get all patients", !patientArr.isEmpty());

        Patient temp;
        for (int i = 0; i < patientArr.size(); i++) {
            temp = patientArr.get(i);
            System.out.println("Name: " + temp.getName());
            System.out.println("Address: " + temp.getAddress());
            System.out.println("SSN: " + temp.getSSN() + "\n");
        }

        System.out.println(TestStrings.testEnd);

        //HspSQL.deletePatients();//careful, make sure this is commented out
    }
}