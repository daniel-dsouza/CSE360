package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.PrescriptionSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Patient;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PrescriptionTest {

    private Prescription add;


    @Before
    public void setUp() {


        add = new Prescription();
        add.setPatientID(1002);
        add.setStaffID(501);
        add.setPrescriptionType("Allergies");
        add.setQuantity("50mg");
        Date date = new Date();
        add.setDateAndTime(date);
    }

    /*@Test
    public void addPrescrition() {
        System.out.println("\nTest========adding prescription");

        //boolean check = PrescriptionSQL.addPrescription(add);
        //assertTrue("Adding prescription failed ", check);
        System.out.println("\nUpdate successful");

        System.out.println(TestStrings.testEnd);
    }*/

    @Test
    public void getListPrescr() {

        System.out.println("\nTest========get a list of all prescriptions by Patient ID");
        Patient new1 = new Patient();
        new1.setUserID(1002);
        List<Prescription> test1 = PrescriptionSQL.getListPrescription(new1);
        assertTrue("No prescriptions by patient ID", !test1.isEmpty());
        System.out.println("\nView successful");
        for (Prescription tempAp : test1) {
            System.out.println("Prescription ID:\t" + tempAp.getPrescriptionID());
            System.out.println("Time:\t" + tempAp.getStrDateAndTime());
            System.out.println("Type:\t" + tempAp.getPrescriptionType());
            System.out.println("Quantity:\t" + tempAp.getQuantity());
            System.out.println("Patient ID:\t" + tempAp.getPatientID());
        }

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void getAll() {

        System.out.println("\nTest========get a list of all prescriptions ");
        List<Prescription> test1 = PrescriptionSQL.getAllPrescriptions();
        assertTrue("No prescriptions by patient ID", !test1.isEmpty());
        System.out.println("\nView successful");
        for (Prescription tempAp : test1) {
            System.out.println("Prescription ID:\t" + tempAp.getPrescriptionID());
            System.out.println("Time:\t" + tempAp.getStrDateAndTime());
            System.out.println("Type:\t" + tempAp.getPrescriptionType());
            System.out.println("Quantity:\t" + tempAp.getQuantity());
            System.out.println("Patient ID:\t" + tempAp.getPatientID());
        }

        System.out.println(TestStrings.testEnd);
    }

    /*@Test
    public void getPrescriptionID() {
        Prescription getID = new Prescription();
        getID.setPatientID(1002);
        getID.setStaffID(501);
        getID.setPrescriptionType("Allergies");
        getID.setQuantity("50mg");
        getID.setStrDateAndTime("2015-10-27 16:10:11");
        System.out.println("\nTest========Getting ID");
        getID = DoctorSQL.getPrescriptionID(getID);
        assertTrue("Could not get ID", getID != null);

        System.out.println("\nView successful");
        System.out.println("Prescription ID:\t" + getID.getPrescriptionID());
        System.out.println(TestStrings.testEnd);
    }*/

    @Test
    public void viewByID() {

        System.out.println("\nTest========get one prescription by prescription ID");
        Prescription new2 = new Prescription();
        new2.setPrescriptionID(2);
        Prescription test1 = PrescriptionSQL.viewPrescriptonByID(new2);
        assertTrue("No prescription by prescription ID", test1 != null);
        System.out.println("\nView successful");
        System.out.println("Time:\t" + test1.getStrDateAndTime());
        System.out.println("Type:\t" + test1.getPrescriptionType());
        System.out.println("Quantity:\t" + test1.getQuantity());
        System.out.println("Patient ID:\t" + test1.getPatientID());


        System.out.println(TestStrings.testEnd);
    }


}