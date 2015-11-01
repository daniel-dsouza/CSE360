package org.teamone.core.users;

import java.util.LinkedHashMap;

/**
 * Created by Ryan on 10/16/2015.
 */
public class LabStaff extends Staff {
    public LabStaff() {
        super();
        agentActions = new LinkedHashMap<String, String>();
        agentActions.put("View Requests", "request_test");
        agentActions.put("View Reports", "lab_report");
    }
}
