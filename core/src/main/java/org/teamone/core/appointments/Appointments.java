package org.teamone.core.appointments;


/**
 * Created by Ryan on 10/7/2015.
 */
public class Appointments {
    private String date;//date is 01/01/2001
    private String time;//time is 3:00 PM
    private int doctorID = 0;
    private String reason;
    private int patientID = 0;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }



}
