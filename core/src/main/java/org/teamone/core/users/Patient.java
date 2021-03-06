package org.teamone.core.users;

import org.teamone.core.labs.LabReport;
import org.teamone.core.prescriptions.Prescription;

import java.util.Comparator;
import java.util.LinkedHashMap;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Patient extends Person implements Comparable<Patient> {
    private String occupation; //why do we care?

    public PatientInformation patientInformation;
    public HealthConditions healthConditions;
    public MedicalHistory medicalHistory;
    public Prescription prescription;
    public LabReport labReports;

    public Patient() {
        super();
        patientInformation = new PatientInformation();
        healthConditions = new HealthConditions();
        medicalHistory = new MedicalHistory();
        agentActions = new LinkedHashMap<String, String>();
        agentActions.put("Update Personal Information", "personal");
        agentActions.put("Update Health Conditions", "healthconditions");
        agentActions.put("Schedule an Appointment", "appointment/new");
        agentActions.put("View Appointments", "appointment/list");

    }

    public PatientInformation getPatientInformation() {
        return patientInformation;
    }

    public void setPatientInformation(PatientInformation patientInformation) {
        this.patientInformation = patientInformation;
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

    public String getEmail() {
        return patientInformation.getEmail();
    }

    public void setEmail(String email) {
        this.patientInformation.setEmail(email);
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

    public String getName() {

        return patientInformation.getName();
    }

    public void setName(String name) {
        patientInformation.setName(name);
        patientInformation.splitName(name);
    }

    public String getAddress() {

        return patientInformation.getAddress();
    }

    public void setAddress(String add) {
        patientInformation.setAddress(add);
        patientInformation.splitAddress(add);
    }

    public LabReport getLabReports() {
        return labReports;
    }

    public void setLabReports(LabReport labReports) {
        this.labReports = labReports;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public int compareTo(Patient compare) {

        int compareID = compare.getUserID();

        //ascending order
        return this.getUserID() - compareID;

        //descending order
        //return compareQuantity - this.quantity;

    }

    //http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
    public static Comparator<Patient> patientIDComparator
            = new Comparator<Patient>() {

        public int compare(Patient first, Patient second) {

            int ID1 = first.getUserID();
            int ID2 = second.getUserID();

            //ascending order
            return ID1 - ID2;

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }


    };
}

