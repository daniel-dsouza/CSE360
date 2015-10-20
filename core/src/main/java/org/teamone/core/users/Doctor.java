package org.teamone.core.users;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ryan on 10/16/2015.
 */
public class Doctor extends Staff {

    public Doctor() {
        super();
        agentActions = new TreeMap<String, String>() {};
        agentActions.put("Select Patient", "patient/patientselect");
        agentActions.put("Create Appointment", "appointment/createappointment");
    }
}
