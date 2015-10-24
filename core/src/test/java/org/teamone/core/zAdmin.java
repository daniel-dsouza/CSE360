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

public class zAdmin {

    private Staff test;

    @Before
    public void setUp() {

        test = new Staff();
        test.setSpecialty("MASTER");
    }

    @Test
    public void helpM() {
        ArrayList<Person> testArr = HspSQL.revealAll();
        System.out.println("\n======================================");
        System.out.println("Dumping person table.");
        System.out.println("======================================");
        if(testArr!=null)
        {

            Person temp;
            for(int i = 0; i < testArr.size(); i++) {
                temp = testArr.get(i);
                System.out.print("UserID: " + temp.getUserID() + "\t\tName: " + temp.getName() + "\t\tOccupation: " + temp.getOccupation()) ;
                System.out.println("\t\tpassword: " + temp.getPassword() + "\t\temail: " + temp.getEmail());
            }

        }
        else
            System.out.println("SEARCH FAILED");
        System.out.println(TestStrings.testEnd);


        ArrayList<Patient> patientArr = PatientSQL.getAllPatient();
        System.out.println("\n======================================");
        System.out.println("Getting all patients");
        System.out.println("======================================");
        if(patientArr!=null)
        {

            Patient temp;
            for(int i = 0; i < patientArr.size(); i++) {
                temp = patientArr.get(i);
                System.out.println("Name: " + temp.getName());
                System.out.println("Address: " + temp.getAddress());
                System.out.println("SSN: " + temp.getSSN() + "\n");
            }

        }
        else
            System.out.println("SEARCH FAILED");
        System.out.println(TestStrings.testEnd);

        HspSQL.deletePatients();//careful, make sure this is commented out
    }
}