package org.teamone.core;

/**
 * Created by Lin on 2015/10/8.
 */
public class PatientManipulation {

    public static int UpdatePersonalInfo(Patient patient)
    {
        int patientID = patient.getPatientID();
        int SSN = patient.getSSN();
        String address = patient.getAddress();
     //   String email = patient.getEmail();
        int phone = patient.getPhone();
        String insurance = patient.getInsurance();
        int age = patient.getAge();
        String gender = patient.getGender();

        //judge whether is connected to DB
        /*
        if()
        {

        }*/
        String cmdText = "update patient set FName='"+fname+"',LName='"+lname+"',address='"+address+"',email'"+email+   ;
        return 1;
    }
}
