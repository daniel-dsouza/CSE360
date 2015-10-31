package org.teamone.core.users;

import java.util.TreeMap;

/**
 * Created by Ryan on 10/16/2015.
 */
public class HSP extends Staff {
    public HSP() {
        super();
        agentActions = new TreeMap<String, String>() {};
        agentActions.put("Select Patient", "select_patient");
        String registration ="user/" + getUserID() + "/registration/";//TODO: Almost working. need from session userID
        agentActions.put("Registration", registration);
    }
}
