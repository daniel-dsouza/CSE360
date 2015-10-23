package org.teamone.core.labs;

import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.util.Date;

/**
 * Created by daniel on 10/11/15.
 */
public class LabTest {
    private Patient patient;
    private int labTestID = 0;

    private Staff staff;

    private String testType;
    private String labReport;
    private Date dateAndTime;
    private String strDateAndTime;
    public LabTest() {
    }

    public int getLabTestID() {
        return labTestID;
    }

    public void setLabTestID(int labTestID) {
        this.labTestID = labTestID;
    }

    public int getStaffID() {
        return staff.getStaffID();
    }

    public void setStaffID(int staffID) {
        this.staff.setStaffID(staffID);
    }



    public int getPatientID() {
        return patient.getPatientID();
    }

    public void setPatientID(int patientID) {
        this.patient.setPatientID(patientID);
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
