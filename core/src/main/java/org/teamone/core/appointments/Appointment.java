package org.teamone.core.appointments;


import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Appointment {

    private int appointmentID;
    private String date;//date is 01/01/2001
    private String time;//time is 3:00 PM
    private String tempID;
    private Staff doctor;
    private String reason;
    private Patient patient;

    public Appointment()
    {
        doctor = new Staff();
        patient = new Patient();
    }
    public String getDoctorName() {
        return doctor.getName();
    }
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setDoctorName(String doctorName) {
        this.doctor.setName(doctorName);
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public Staff getDoctor() {
        return doctor;
    }

    public void setDoctor(Staff doctor) {
        this.doctor = doctor;
        //this.doctor = DoctorSQL.getStaffComplete(doctor);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        //this.patient = PatientSQL.getPatientComplete(patient);
    }

    public String getDoctorSpec() {
        return doctor.getSpecialty();
    }

    public void setDoctorSpec(String doctorSpec)
    {
        this.doctor.setSpecialty(doctorSpec);
    }

    public int getPatientID() {
        return patient.getUserID();
    }

    public void setPatientID(int patientID)
    {
        this.patient.setUserID(patientID);
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
        return doctor.getUserID();
    }

    public void setDoctorID(int doctorID) {
        this.doctor.setUserID(doctorID);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTempID() {
        return tempID;
    }

    public void setTempID(String tempID) {
        this.tempID = tempID;
    }
}

