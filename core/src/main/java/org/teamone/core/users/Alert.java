package org.teamone.core.users;

/**
 * Created by Ryan on 10/19/2015.
 */
public class Alert {
    private String alertDateAndTime;
    private boolean alertStatus = false;
    private String reason;
    private int patientID;
    private int doctorID;
    private int alertID;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getAlertID() {
        return alertID;
    }

    public void setAlertID(int alertID) {
        this.alertID = alertID;
    }

    public Alert() {

    }
}
