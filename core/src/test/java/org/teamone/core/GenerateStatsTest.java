package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.GenerateStatsSQL;
import org.teamone.core.users.Alert;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

public class GenerateStatsTest {


    @Test
    public void updateHC(){
        Statistics new1 = GenerateStatsSQL.main();
        /*GenerateStatsSQL.getNumOfPatientType();
        System.out.println("Number of Alerts within this Month: " + GenerateStatsSQL.getNumOfAlerts());
        System.out.println("Number of New Patients within this Month: " + GenerateStatsSQL.getNumOfNewPatients());
        System.out.println("Male Population: " + GenerateStatsSQL.getMalePopulation() + "%");
        System.out.println("Female Population: " + GenerateStatsSQL.getFemalePopulation() +  "%");
        GenerateStatsSQL.getAgePopulation();*/

        System.out.println("\n\n==EXAMPLE HOW TO GET FROM OBJECT====\nNumber of Alerts within this Month: " + new1.getHealthOutcomes());
        System.out.println("Number of New Patients within this Month: " + new1.getAdmissionRates());
        System.out.println("Male Population: " + new1.getMalePatientPopulation() + "%");
        System.out.println("Female Population: "+new1.getFemalePatientPopulation() + "%\n");

        double[] Agepop = new1.getPatientAgePopulation();
        System.out.println("Ages 0-12: " + Agepop[0] + "%");
        System.out.println("Ages 13-18: " + Agepop[1]+ "%");
        System.out.println("Ages 19-26: " + Agepop[2] + "%");
        System.out.println("Ages 27-40: " + Agepop[3] + "%");
        System.out.println("Ages 41-50: " + Agepop[4] + "%");
        System.out.println("Ages 51-60: " + Agepop[5] + "%");
        System.out.println("Ages 61-74: " + Agepop[6] + "%");
        System.out.println("Ages 75 & Up: " + Agepop[7] + "%\n");

        double[] types = new1.getPatientType();
        System.out.println("Pediatric Patients: " + types[0] + "%");
        System.out.println("General Care Patients: " + types[1]  + "%");
        System.out.println("Emergency Patients: " + types[2]  + "%");
        System.out.println("Radiology (X-ray) Patients: " + types[3]  + "%");
        System.out.println("Neurology Patients: " + types[4]  + "%");
    }
}