package org.teamone.core;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.LoginSQL;
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

    @Ignore
    public void getAllPersons() {

        String type = "MasterPanel";
        String pass = "RyanRocks";
        if(HspSQL.authenticate(type,pass)) {
            System.out.println("\n======================================");
            System.out.println("Dumping person table.");
            System.out.println("======================================");
            ArrayList<Person> testArr = HspSQL.revealAll();
            assertTrue("Failed to dump person table", !testArr.isEmpty());

            for (Person temp : testArr) {
                System.out.print("UserID: " + temp.getUserID() + "\t\tName: " + temp.getName() + "\t\tOccupation: " + temp.getOccupation());
                System.out.println("\t\tpassword: " + temp.getPassword() + "\t\temail: " + temp.getEmail());
            }
        }
        else
        {
            System.out.print("Authentication failed");
        }
        System.out.println(TestStrings.testEnd);
    }

    @Ignore
    public void getAllPatients() {
        System.out.println("\n======================================");
        System.out.println("Getting all patients");
        System.out.println("======================================");
        ArrayList<Patient> patientArr = PatientSQL.getAllPatient();
        assertTrue("Failed to get all patients", !patientArr.isEmpty());

        for (Patient temp : patientArr) {
            System.out.println("Name: " + temp.getName());
            System.out.println("Address: " + temp.getAddress());
            System.out.println("SSN: " + temp.getSSN() + "\n");
        }

        System.out.println(TestStrings.testEnd);

        //HspSQL.deletePatients();//careful, make sure this is commented out
    }

    @Ignore
    public void changePassword() {
        Person p1 = new Person();
        p1.setUserID(501);
        p1.setPassword("go");//this is old password
        String newPass = "hey";
        if(LoginSQL.authenticate(p1)!=null)
        {
            if(LoginSQL.changePassword(p1,newPass))
                System.out.println("Password changed!");
            else
                System.out.println("Password not changed");
        }
        else
        {
            System.out.println("Password incorrect");
        }


    }
}