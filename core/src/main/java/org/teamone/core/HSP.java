package org.teamone.core;

/**
 * Created by Ryan on 10/7/2015.
 */
public class HSP extends Person{
    private int numOfHSP;
    private boolean alertSubmitted;

    public HSP ()
    {
        numOfHSP = 0;
        alertSubmitted = false;

    }
    public void generateStats()
    {

    }
    public void checkAlert()
    {

    }

    public void receiveAlert( )
    {

    }

    public void updateAppointment(int patientId, int doctorID, java.sql.Timestamp newTime )
    {
    //sql query search patientID, UPDATE appointment table
    }

    public void updateHealthCon(int patientId, String health )
    {
//sql query search patientID, UPDATE  health
    }

    public void updateMedicalHistory(int patientId, String mHistory )
    {
        //sql query search patientID, UPDATE  history
    }


}
