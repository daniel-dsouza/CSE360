package org.teamone.core.users;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Patient extends Person {
    private int patientID = 0;
    //private String medicalHistory; //wtf is this?
    private String occupation; //why do we care?
    //private String address;
    //private int SSN = 0;
    //private String gender;
    //private String insurance;
    //private int age = 0;
    //private long phone = 0;
    //private String healthConditions; //wtf is this
    private String labReports; //wtf is this
    private String alertDateAndTime;
    private boolean alertStatus = false;
    private String prescription; //wtf is this

    public PatientInformation patientInformation;
    public HealthConditions healthConditions;
    public MedicalHistory medicalHistory;

    public Patient() {
        patientInformation = new PatientInformation();
        healthConditions = new HealthConditions();
        medicalHistory = new MedicalHistory();
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getMedicalHistory() {
        return medicalHistory.toString();
    }

    public void setMedicalHistory(String medicalHistory) {
        //this.medicalHistory = medicalHistory;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return this.patientInformation.getAddress();
    }

    public void setAddress(String address) {
        //this.address = address;
        this.patientInformation.setAddress(address);
    }

    public int getSSN() {
        //return SSN;
        return this.patientInformation.getSsn();
    }

    public void setSSN(int SSN) {
        //this.SSN = SSN;
        this.patientInformation.setSsn(SSN);
    }

    public String getGender() {
        //return gender;
        return this.patientInformation.getGender();
    }

    public void setGender(String gender) {
        //this.gender = gender;
        this.patientInformation.setGender(gender);
    }

    public String getInsurance() {
        //return insurance;
        return this.patientInformation.getInsurance();
    }

    public void setInsurance(String insurance) {
        //this.insurance = insurance;
        this.patientInformation.setInsurance(insurance);
    }

    public int getAge() {
        //return age;
        return Integer.parseInt(this.patientInformation.getAge());
    }

    public void setAge(int age) {
        //this.age = age;
        this.patientInformation.setAge(Integer.toString(age));
    }

    public long getPhone() {
        //return phone;
        return Long.parseLong(this.patientInformation.getHomePhone());
    }

    public void setPhone(int phone) {
        //this.phone = phone;
        this.patientInformation.setHomePhone(Integer.toString(phone));
    }

    public String getHealthConditions() {
        //return healthConditions;
        return "this is lazy.";
    }

    public void setHealthConditions(String healthConditions) {
        //this.healthConditions = healthConditions;
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

