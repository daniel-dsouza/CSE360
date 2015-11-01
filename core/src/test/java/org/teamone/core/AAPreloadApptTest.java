package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.appointments.Appointment;

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
                //appt = AppointmentSQL.random();//call this to random
                //boolean p = AppointmentSQL.preloadAppointment(appt);
                //assertTrue("Failed to preload", p);//if p!=null returns false, display message


            }
            // System.out.println("*********************Preload successful************************");
            // System.out.println(TestStrings.testEnd);
        }

    }


}
