package org.teamone.core;

import org.junit.Test;
import org.teamone.core.SQL.GenerateStatsSQL;

import java.util.ArrayList;

public class GenerateStatsTest {


    @Test
    public void GenerateStats() {

        /*GenerateStatsSQL.getNumOfPatientType();
        System.out.println("Number of Alerts within this Month: " + GenerateStatsSQL.getNumOfAlerts());
        System.out.println("Number of New Patients within this Month: " + GenerateStatsSQL.getNumOfNewPatients());
        System.out.println("Male Population: " + GenerateStatsSQL.getMalePopulation() + "%");
        System.out.println("Female Population: " + GenerateStatsSQL.getFemalePopulation() +  "%");
        GenerateStatsSQL.getAgePopulation();*/

        System.out.println("\n==EXAMPLE HOW TO GET FROM OBJECT====\nNumber of Alerts within this Month: " + GenerateStatsSQL.getNumOfAlerts());
        System.out.println("Number of New Patients within this Month: " + GenerateStatsSQL.getNumOfNewPatients());
        System.out.println("Male Population: " + GenerateStatsSQL.getMalePopulation() + "%");
        System.out.println("Female Population: " + GenerateStatsSQL.getFemalePopulation() + "%\n");

        double[] Agepop = GenerateStatsSQL.getAgePopulation();
        System.out.println("Ages 0-12: " + Agepop[0] + "%");
        System.out.println("Ages 13-18: " + Agepop[1] + "%");
        System.out.println("Ages 19-26: " + Agepop[2] + "%");
        System.out.println("Ages 27-40: " + Agepop[3] + "%");
        System.out.println("Ages 41-50: " + Agepop[4] + "%");
        System.out.println("Ages 51-60: " + Agepop[5] + "%");
        System.out.println("Ages 61-74: " + Agepop[6] + "%");
        System.out.println("Ages 75 & Up: " + Agepop[7] + "%\n");

        ArrayList<ArrayList<Integer>> patientTypes = new ArrayList<ArrayList<Integer>>(GenerateStatsSQL.getNumOfPatientType());
        System.out.println("Pediatrician: " + patientTypes.get(0));
        System.out.println("General Care: " + patientTypes.get(1));
        System.out.println("X-Ray: " + patientTypes.get(2));
        System.out.println("Emergency: " + patientTypes.get(3));
        System.out.println("Neurologist: " + patientTypes.get(4) + "\n");


        System.out.println("Number of Emergency Alerts within the Year");

        ArrayList<Integer> numOfAlerts = new ArrayList<Integer>(GenerateStatsSQL.getNumOfAlerts());
        System.out.println("January: " + numOfAlerts.get(0));
        System.out.println("February: " + numOfAlerts.get(1));
        System.out.println("March: " + numOfAlerts.get(2));
        System.out.println("April: " + numOfAlerts.get(3));
        System.out.println("May: " + numOfAlerts.get(4));
        System.out.println("June: " + numOfAlerts.get(5));
        System.out.println("July: " + numOfAlerts.get(6));
        System.out.println("August: " + numOfAlerts.get(7));
        System.out.println("September: " + numOfAlerts.get(8));
        System.out.println("October: " + numOfAlerts.get(9));
        System.out.println("November: " + numOfAlerts.get(10));
        System.out.println("December: " + numOfAlerts.get(11) + "\n");

        System.out.println("Number of New Patients within the Year");

        ArrayList<Integer> patientCount = new ArrayList<Integer>(GenerateStatsSQL.getNumOfNewPatients());
        System.out.println("January: " + patientCount.get(0));
        System.out.println("February: " + patientCount.get(1));
        System.out.println("March: " + patientCount.get(2));
        System.out.println("April: " + patientCount.get(3));
        System.out.println("May: " + patientCount.get(4));
        System.out.println("June: " + patientCount.get(5));
        System.out.println("July: " + patientCount.get(6));
        System.out.println("August: " + patientCount.get(7));
        System.out.println("September: " + patientCount.get(8));
        System.out.println("October: " + patientCount.get(9));
        System.out.println("November: " + patientCount.get(10));
        System.out.println("December: " + patientCount.get(11) + "\n");

    }
}
