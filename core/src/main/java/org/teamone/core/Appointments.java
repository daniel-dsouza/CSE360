package org.teamone.core;

import java.util.Date;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Appointments {
    private int doctorID;
    private String date;//do away with the calender
    private String time;//
    private String reason;

    public Appointments()
    {
        doctorID = 0;
        date= "0/0/0000";
        time= "0:00 AM";
        reason = "I'm healthy";
    }
    public Appointments(int ID, String Date, String Time, String Reason)
    {
        doctorID = 0;
        date = Date;
        time = Time;
        reason = Reason;
    }
    public void editAppoint(int newID)
    {
        doctorID = newID;

    }
    public void search(String type)
    {
        //sql query to report all avaviable doctors of that "Type"
        //return array[strings]
    }
   /* public java.sql.Timestamp getCurrentTimeStamp()//private for helper method
    //http://www.mkyong.com/jdbc/how-to-insert-timestamp-value-in-preparedstatement/
    {

        //today = new Date();
        return new java.sql.Timestamp(today.getTime());

    }*/

}
