package org.teamone.core.users;

import java.util.TreeMap;

/**
 * Created by Ryan on 10/16/2015.
 */
public class Doctor extends Staff {

    public Doctor() {
        super();
        agentActions = new TreeMap<String, String>() {};
        agentActions.put("Select Patient", "select_patient");
        agentActions.put("Create Appointment", "appointment/createappointment");
        agentActions.put("View Appointments", "appointment/list/doctor");
        //agentActions.put("Alerts", "alert");
    }
}
