package org.teamone.core;

import java.util.Date;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Appointments {
    private Doctor currentDoc;
    private Date today;

    public Appointments()
    {
        currentDoc = new Doctor();
        today= new Date();
    }

    public void editApp(Doctor newD)
    {
        currentDoc = newD;
        // call sql query and pass in Doctor's name and TimeStamp
    }
    private java.sql.Timestamp getCurrentTimeStamp()//private for helper method
    //http://www.mkyong.com/jdbc/how-to-insert-timestamp-value-in-preparedstatement/
    {

        today = new Date();
        return new java.sql.Timestamp(today.getTime());

    }

}
