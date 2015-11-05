package org.teamone.core.users;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Staff extends Person {

    private String occupation ;
    private String specialty ;
    private int patientID = 0;
    private String schedule ;
    private int alertsPresent =0;

    private String emergencyWardDoctor = "yes";

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

    public int getAlertsPresent() {
        return alertsPresent;
    }

    public void setAlertsPresent(int alertsPresent) {
        this.alertsPresent = alertsPresent;
    }

    public String getEmergencyWardDoctor() {
        return emergencyWardDoctor;
    }

    public void setEmergencyWardDoctor(String emergencyWardDoctor) {
        this.emergencyWardDoctor = emergencyWardDoctor;
    }

    public Staff() {
        super();
    }
}