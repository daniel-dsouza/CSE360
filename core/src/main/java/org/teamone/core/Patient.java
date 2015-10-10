package org.teamone.core;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Patient extends Person{
    private int patientID = 0;
    private String medicalHistory;
    private String occupation;
    private String address;
    private int SSN = 0;
    private String gender;
    private String insurance;
    private int age = 0;
    private int phone = 0;
    private String healthConditions;
    private String labReports;
    private String alertDateAndTime;
    private boolean alertStatus = false;
    private String prescription;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getHealthConditions() {
        return healthConditions;
    }

    public void setHealthConditions(String healthConditions) {
        this.healthConditions = healthConditions;
    }

    public String getLabReports() {
        return labReports;
    }

    public void setLabReports(String labReports) {
        this.labReports = labReports;
    }

    public String getAlertDateAndTime() {
        return alertDateAndTime;
    }

    public void setAlertDateAndTime(String alertDateAndTime) {
        this.alertDateAndTime = alertDateAndTime;
    }

    public boolean isAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(boolean alertStatus) {
        this.alertStatus = alertStatus;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}

