package org.teamone.core;

/**
 * Created by Ryan on 10/7/2015.
 *
 */
public class MedicalHistory {
    private String medicalHi;
    //TODO: convert from checkboxes to standard input
    public MedicalHistory()
    {
        medicalHi = "";
    }
    public void editMedical(String newHistory)
    {
        medicalHi = newHistory;
    }
}
