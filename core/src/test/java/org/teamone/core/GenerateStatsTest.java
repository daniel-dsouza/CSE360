package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.GenerateStatsSQL;
import org.teamone.core.users.Alert;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

public class GenerateStatsTest {

    private Alert test;
    private Patient test2;
    private Staff test3;

    @Before
    public void setUp() {

        test = new Alert();

    }

    @Before
    public void setUpPatient() {

        test2 = new Patient();
    }

    @Before
    public void setUpStaff() {

        test3 = new Staff();
    }

    @Test
    public void updateHC(){

        //Ge//nerateStatsSQL.getNumOfPatientType(test3);
        System.out.println("Number of Alerts within this Month: " + GenerateStatsSQL.getNumOfAlerts(test));
        System.out.println("Number of New Patients within this Month: " + GenerateStatsSQL.getNumOfNewPatients(test2));
        System.out.println("Male Population: " + String.format("%.2f",GenerateStatsSQL.getMalePopulation(test2)) + "%");
        System.out.println("Female Population: " + String.format("%.2f",GenerateStatsSQL.getFemalePopulation(test2)) + "%");
        GenerateStatsSQL.getAgePopulation(test2);

    }
}