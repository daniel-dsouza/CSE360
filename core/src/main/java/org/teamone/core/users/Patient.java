package org.teamone.core.users;

import java.util.TreeMap;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Patient extends Person {
    private int patientID = 0;
    private String occupation; //why do we care?
    private String labReports; //wtf is this
    private String prescription; //wtf is this

    public PatientInformation patientInformation;
    public HealthConditions healthConditions;
    public MedicalHistory medicalHistory;

    public Patient() {
        super();
        patientInformation = new PatientInformation();
        healthConditions = new HealthConditions();
        medicalHistory = new MedicalHistory();

        agentActions = new TreeMap<String, String>() {};
        agentActions.put("Update Information", "registration/personalinformation");
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

    public String getSSN() {
        //return SSN;
        return this.patientInformation.getSsn();
    }

    public void setSSN(String SSN) {
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

    public String getAge() {
        //return age;
        return this.patientInformation.getAge();
    }

    public void setAge(String age) {
        //this.age = age;
        this.patientInformation.setAge(age);
    }

    public String getPhone() {
        //return phone;
        return this.patientInformation.getHomePhone();
    }

    public void setPhone(String phone) {
        //this.phone = phone;
        this.patientInformation.setHomePhone(phone);
    }

    public String getHealthConditions() {
        //return healthConditions;
        return healthConditions.toString();
    }

    public void setHealthConditions(String healthCondition) {
        healthConditions.toMapObj(healthCondition);
    }

    public String getLabReports() {
        return labReports;
    }

    public void setLabReports(String labReports) {
        this.labReports = labReports;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}

