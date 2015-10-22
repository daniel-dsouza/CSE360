package org.teamone.core.labs;

import java.util.Date;

/**
 * Created by daniel on 10/11/15.
 */
public class LabTest {
    private int patientID = 0;


    private int staffID = 0;

    private String testType;
    private String labReport;
    private Date dateAndTime;
    private String strDateAndTime;

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }


    public LabTest() {
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getLabReport() {
        return labReport;
    }

    public void setLabReport(String labReport) {
        this.labReport = labReport;
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
