package org.teamone.core.prescriptions;

import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.util.Date;

/**
 * Created by daniel on 10/11/15.
 */
public class Prescription {
    private Patient patient;
    private int prescriptionID = 0;
    private Staff doctor;
    private String prescriptionType;
    private Date dateAndTime;
    private String strDateAndTime;

    public Prescription() {
    }

    public int getStaffID() {
        return doctor.getUserID();
    }

    public void setStaffID(int staffID) {
        this.doctor.setUserID(staffID);
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public int getPatientID() {
        return patient.getUserID();
    }

    public void setPatientID(int patientID) {
        this.patient.setUserID(patientID);
    }

    public String getPrescriptionType() {
        return prescriptionType;
    }

    public void setPrescriptionType(String prescriptionType) {
        this.prescriptionType = prescriptionType;
    }


    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getStrDateAndTime() {
        return strDateAndTime;
    }

    public void setStrDateAndTime(String strDateAndTime) {
        this.strDateAndTime = strDateAndTime;
    }

    public void convertDate()
    {
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        strDateAndTime = sdf.format(dateAndTime);
    }
}
