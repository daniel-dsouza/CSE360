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
        //nextInt((max - min) + 1) + min
        int time1 = randomGenerator.nextInt((12 - 0) + 1) + 0;//12 hour clock
        time += Integer.toString(time1) + ":00 ";

        String time2 = "";
        if ((randomGenerator.nextInt(10) % 2) == 0)//even
            time2 = "AM";
        else
            time2 = "PM";
        time += time2;
        appt.setDate(date);
        appt.setTime(time);
    }
}