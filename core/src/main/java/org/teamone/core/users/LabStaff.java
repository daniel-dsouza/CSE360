package org.teamone.core.users;

import java.util.TreeMap;

/**
 * Created by Ryan on 10/16/2015.
 */
public class LabStaff extends Staff {
    public LabStaff() {
        super();
        agentActions = new TreeMap<String, String>() {};
        agentActions.put("Start Test", "lab/listtests");
    }
}
