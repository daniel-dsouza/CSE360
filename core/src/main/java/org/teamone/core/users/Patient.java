package org.teamone.core.users;

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



    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public HealthConditions getHealthConditions() {
        //return healthConditions;
        return healthConditions;
    }

    public void setHealthConditions(HealthConditions hc) {
        healthConditions = hc;
    }
    public MedicalHistory getMedicalHistory() {

        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory mh) {
        medicalHistory = mh;
    }

    public String getName()
    {

        return patientInformation.getName();
    }
    public void setName(String name)
    {
        patientInformation.setName(name);
        patientInformation.splitName(name);
    }

    public String getAddress()
    {

        return patientInformation.getAddress();
    }
    public void setAddress(String add)
    {
        patientInformation.setAddress(add);
        patientInformation.splitAddress(add);
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

