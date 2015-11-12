package org.teamone.core.Statistics;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Statistics {

    private float healthOutcomes;

    private double[] patientType;

    private double[] patientAge;

    private double patientFemalePopulation = 0;

    private double patientMalePopulation = 0;

    private float admissionRates = 0;


    public float getHealthOutcomes() {
        return healthOutcomes;
    }

    public void setHealthOutcomes(float healthOutcomes) {
        this.healthOutcomes = healthOutcomes;
    }

    public double[] getPatientType() {
        return patientType;
    }

    public void setPatientType(double[] patientType) {
        this.patientType = patientType;
    }

    public double getFemalePatientPopulation() {
        return patientFemalePopulation;
    }

    public void setFemalePatientPopulation(double patientFemalePopulation) {
        this.patientFemalePopulation = patientFemalePopulation;
    }

    public double getMalePatientPopulation() {
        return patientMalePopulation;
    }

    public void setMalePatientPopulation(double patientMalePopulation) {
        this.patientMalePopulation = patientMalePopulation;
    }

    public double[] getPatientAgePopulation() {
        return patientAge;
    }

    public void setPatientAgePopulation(double[] patientAge) {
        this.patientAge = patientAge;
    }

    public float getAdmissionRates() {
        return admissionRates;
    }

    public void setAdmissionRates(float admissionRates) {
        this.admissionRates = admissionRates;
    }


}
