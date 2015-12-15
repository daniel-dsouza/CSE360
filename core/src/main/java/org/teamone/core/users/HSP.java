package org.teamone.core.users;

import java.util.LinkedHashMap;

/**
 * Created by Ryan on 10/16/2015.
 */
public class HSP extends Staff {
    public HSP() {
        super();
        agentActions = new LinkedHashMap<String, String>() {
        };
        agentActions.put("Select Patient", "select_patient");
        agentActions.put("Register Patient", "registration/");
        agentActions.put("Register Staff", "registrationStaff/");
        agentActions.put("Generate Statistics", "stats");
        //agentActions.put("Create Appointment", "appointment/createappointment");
    }
}
