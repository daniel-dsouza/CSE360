package org.teamone.core;

/**
 * Created by Ryan on 10/7/2015.
 */
public class HealthConditions {
    private String condition;
    public HealthConditions()
    {
        condition = "Healthy, nothing to see here";
    }
    public void editConditions(String newCond)
    {
        condition = newCond;
    }
}
