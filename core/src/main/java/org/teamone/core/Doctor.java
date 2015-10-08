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
    public void updatePatientInfo()
    {

    }
    public void ePrescribeMedicine()
    {

    }
    public void ePrescribeLabTest()
    {

    }
    public void accessRecords()
    {

    }
    public void checkEmergency()
    {

    }
}
