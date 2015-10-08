package org.teamone.core;


/**
 * Created by Ryan on 10/7/2015.
 */
public class Doctor extends Person{
    private String patientID; //Patient ID is the current patient Doctor is seeing
    private String specialty;
    private boolean alertReceived;
    private boolean isInEmergencyWard;

    public Doctor()
    {
        patientID = ""; //Patient ID is the current patient Doctor is seeing
        specialty = "";
        alertReceived = false;
        isInEmergencyWard = false;
    }
    public void updatePatientInfo()//TODO: rename to updateCurrentCondition
    {

    }
    public void ePrescribeMedicine(String medication, int quanity, java.sql.Timestamp newTime )
    {

    }
    public void ePrescribeLabTest(String LabTest, java.sql.Timestamp newTime)
    {
// 10/8/2015 3:00pm
    }
    public void accessRecords(int patientId)
    {
//Sql query to search ID, and only display on UI
    }
    public void checkEmergency()
    {

    }
}
