package org.teamone.core.users;

import java.util.TreeMap;

/**
 * Created by Ryan on 10/16/2015.
 */
public class HSP extends Staff {
    public HSP() {
        super();
        agentActions = new TreeMap<String, String>() {};
        agentActions.put("Select Patient", "patient/patientselect");
    }
}
