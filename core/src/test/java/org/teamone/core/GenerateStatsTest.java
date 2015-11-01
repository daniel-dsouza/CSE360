package org.teamone.core;

import org.junit.Test;
import org.teamone.core.SQL.GenerateStatsSQL;

import java.util.ArrayList;

public class GenerateStatsTest {


    @Test
    public void updateHC(){

        /*GenerateStatsSQL.getNumOfPatientType();
        System.out.println("Number of Alerts within this Month: " + GenerateStatsSQL.getNumOfAlerts());
        System.out.println("Number of New Patients within this Month: " + GenerateStatsSQL.getNumOfNewPatients());
        System.out.println("Male Population: " + GenerateStatsSQL.getMalePopulation() + "%");
        System.out.println("Female Population: " + GenerateStatsSQL.getFemalePopulation() +  "%");
        GenerateStatsSQL.getAgePopulation();*/



        System.out.println("\n==EXAMPLE HOW TO GET FROM OBJECT====\nNumber of Alerts within this Month: " + GenerateStatsSQL.getNumOfAlerts());
        System.out.println("Number of New Patients within this Month: " + GenerateStatsSQL.getNumOfNewPatients());
        System.out.println("Male Population: " + GenerateStatsSQL.getMalePopulation() + "%");
        System.out.println("Female Population: "+GenerateStatsSQL.getFemalePopulation() + "%\n");

        double[] Agepop = GenerateStatsSQL.getAgePopulation();
        System.out.println("Ages 0-12: " + Agepop[0] + "%");
        System.out.println("Ages 13-18: " + Agepop[1]+ "%");
        System.out.println("Ages 19-26: " + Agepop[2] + "%");
        System.out.println("Ages 27-40: " + Agepop[3] + "%");
        System.out.println("Ages 41-50: " + Agepop[4] + "%");
        System.out.println("Ages 51-60: " + Agepop[5] + "%");
        System.out.println("Ages 61-74: " + Agepop[6] + "%");
        System.out.println("Ages 75 & Up: " + Agepop[7] + "%\n");

        System.out.println("PATIENT TYPE TESTING");

        ArrayList<ArrayList<Double>> patientTypes = new ArrayList<ArrayList<Double>>();
        patientTypes = GenerateStatsSQL.getNumOfPatientType();

        System.out.println("Pediatrician: " + patientTypes.get(0));
        System.out.println("General Care: " + patientTypes.get(1));
        System.out.println("X-Ray: " + patientTypes.get(2));
        System.out.println("Emergency: " + patientTypes.get(3));
        System.out.println("Neurologist: " + patientTypes.get(4) + "\n");


        System.out.println("Number of Emergency Alerts within the Year");

        /*int[] numOfAlerts = GenerateStatsSQL.getNumOfAlerts();
        System.out.println("January: " + numOfAlerts[0]);
        System.out.println("February: " + numOfAlerts[1]);
        System.out.println("March: " + numOfAlerts[2]);
        System.out.println("April: " + numOfAlerts[3]);
        System.out.println("May: " + numOfAlerts[4]);
        System.out.println("June: " + numOfAlerts[5]);
        System.out.println("July: " + numOfAlerts[6]);
        System.out.println("August: " + numOfAlerts[7]);
        System.out.println("September: " + numOfAlerts[8]);
        System.out.println("October: " + numOfAlerts[9]);
        System.out.println("November: " + numOfAlerts[10]);
        System.out.println("December: " + numOfAlerts[11] + "\n");

        System.out.println("Number of New Patients within the Year");

        int[] patientCount = GenerateStatsSQL.getNumOfNewPatients();
        System.out.println("January: " + patientCount[0]);
        System.out.println("February: " + patientCount[1]);
        System.out.println("March: " + patientCount[2]);
        System.out.println("April: " + patientCount[3]);
        System.out.println("May: " + patientCount[4]);
        System.out.println("June: " + patientCount[5]);
        System.out.println("July: " + patientCount[6]);
        System.out.println("August: " + patientCount[7]);
        System.out.println("September: " + patientCount[8]);
        System.out.println("October: " + patientCount[9]);
        System.out.println("November: " + patientCount[10]);
        System.out.println("December: " + patientCount[11]); */

    }
}
