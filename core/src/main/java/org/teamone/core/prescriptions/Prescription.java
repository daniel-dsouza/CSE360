package org.teamone.core.prescriptions;

import java.util.Date;

/**
 * Created by daniel on 10/11/15.
 */
public class Prescription {
    private int patientID;

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    private int staffID;
    private String prescriptionType;
    private String quantity;
    private Date dateAndTime;
    private String strDateAndTime;

    public Prescription() {
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPrescriptionType() {
        return prescriptionType;
    }

    public void setPrescriptionType(String prescriptionType) {
        this.prescriptionType = prescriptionType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
