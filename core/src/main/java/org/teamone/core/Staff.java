package org.teamone.core;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Staff extends Person{

    private int staffID = 0;
    private String occupation ;
    private String specialty ;
    private int patientID = 0;
    private String schedule ;

    private String emergencyWardDoctor = "yes";

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }


}