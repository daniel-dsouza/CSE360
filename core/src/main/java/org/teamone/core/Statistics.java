package org.teamone.core;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Statistics {

    private String healthOutcomes ;

    private String patientType ;

    private int patientPopulation = 0;

    private float admissionRates  =  0;


    public String getHealthOutcomes() {
        return healthOutcomes;
    }

    public void setHealthOutcomes(String healthOutcomes) {
        this.healthOutcomes = healthOutcomes;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public int getPatientPopulation() {
        return patientPopulation;
    }

    public void setPatientPopulation(int patientPopulation) {
        this.patientPopulation = patientPopulation;
    }

    public float getAdmissionRates() {
        return admissionRates;
    }

    public void setAdmissionRates(float admissionRates) {
        this.admissionRates = admissionRates;
    }


}
