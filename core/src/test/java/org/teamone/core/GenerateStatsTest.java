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

        GenerateStatsSQL.getNumOfPatientType();
        System.out.println("Number of Alerts within this Month: " + GenerateStatsSQL.getNumOfAlerts());
        System.out.println("Number of New Patients within this Month: " + GenerateStatsSQL.getNumOfNewPatients());
        System.out.println("Male Population: " + GenerateStatsSQL.getMalePopulation() + "%");
        System.out.println("Female Population: " + GenerateStatsSQL.getFemalePopulation() +  "%");
        GenerateStatsSQL.getAgePopulation();

    }
}