package org.teamone.core.appointments;


import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.util.Comparator;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Appointment implements Comparable<Appointment>{

    private int appointmentID;
    private String date;//date is 01/01/2001
    private String time;//time is 3:00 PM
    private String tempDocID;
    private Staff doctor;
    private String reason;
    private Patient patient;
    private int failedToInsert;//1 for failed to insert. If the insertion was successful, there is no need to set this value

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

    public String getTempDocID() {
        return tempDocID;
    }

    public void setTempDocID(String tempDocID) {
        this.tempDocID = tempDocID;
    }

    public int getFailedToInsert() {
        return failedToInsert;
    }

    public void setFailedToInsert(int failedToInsert) {
        this.failedToInsert = failedToInsert;
    }

    //http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
    public int compareTo(Appointment compare) {

        String compareDate = ((Appointment) compare).getDate();

        //ascending order
        return this.date.compareTo(compareDate);

        //descending order
        //return compareQuantity - this.quantity;

    }

    //http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
    public static Comparator<Appointment> dateCompare
            = new Comparator<Appointment>() {

        public int compare(Appointment first, Appointment second) {

            String date1 = first.getDate();
            String date2 = second.getDate();

            //ascending order
            return date1.compareTo(date2);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }
        //http://stackoverflow.com/questions/5805602/how-to-sort-list-of-objects-by-some-property
        public int secondaryCompare(Appointment first, Appointment second) {

            String time1 = first.getTime();
            String time2 = second.getTime();

            //ascending order
            return time1.compareTo(time2);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };
}



