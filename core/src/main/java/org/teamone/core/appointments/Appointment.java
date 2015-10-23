package org.teamone.core.appointments;


/**
 * Created by Ryan on 10/7/2015.
 */
public class Appointment {
    private String date;//date is 01/01/2001
    private String time;//time is 3:00 PM
    private String doctorName;
    private String doctorSpec;
    private int doctorID = 0;
    private int appointmentID = 0;
    private String reason;
    private int patientID = 0;

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpec() {
        return doctorSpec;
    }

    public void setDoctorSpec(String doctorSpec) {
        this.doctorSpec = doctorSpec;
    }

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
