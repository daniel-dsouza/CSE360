package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.appointments.Appointment;

import java.util.Random;

/**
 * Created by system on 10/22/15.
 */
public class AAPreloadApptTest {

    private Appointment appt;

    @Before
    public void setUp() {
        appt = new Appointment();
    }

    @Test
    public void RegisterTest() {
        System.out.println("\nTest========Preloading appointments");
        for (int docID = 501; docID <= 511; docID++) {//This loop generates appointments PER doctor
            for (int x = 0; x < 5; x++) {//this loops generates 5 appoints for each doctor
                //uncomment when ready

                //appt.setDoctorID(docID);
                //random();//call this to random
                //boolean p = AppointmentSQL.preloadAppointment(appt);
                //assertTrue("Failed to preload", p);//if p!=null returns false, display message


            }
            // System.out.println("*********************Preload successful************************");
            // System.out.println(TestStrings.testEnd);
        }

    }

    public void random()//randomizer so we can loop multiple
    {
        //INSERT INTO `appointment`(`date`, `time`, `doctorID`) VALUES ("2015-10-25","9:00 AM",501),

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String date = "2015-";
        //nextInt((max - min) + 1) + min
        int date1 = randomGenerator.nextInt((12 - 11) + 1) + 11;//month
        date += Integer.toString(date1) + "-";
        date1 = randomGenerator.nextInt((28 - 1) + 1) + 1;//day
        date += Integer.toString(date1);
        String time = "";
        //nextInt((max - min) + 1)
        int time1 = randomGenerator.nextInt((12 - 0) + 1);//12 hour clock
        String time2 = "";
        if (time1 >= 0 && time1 <= 6 || time1 == 12)//if generator is between midnight and 6:00, then this must be set to PM since no doctors wake up.
        {
            if (time1 == 0)//if this is 0, we cant have 0:00 PM, so we set that 12:00
            {
                time1 = 12;
            }
            time2 = "PM";
        } else {
            if ((randomGenerator.nextInt(10) % 2) == 0)//time between 7 AM to 11:00 AM could be either AM or PM.
                time2 = "AM";
            else
                time2 = "PM";
        }
        time += Integer.toString(time1) + ":00 ";
        time += time2;

        appt.setDate(date);
        appt.setTime(time);
    }
}
