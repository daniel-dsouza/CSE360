package org.teamone.core;

/**
 * Created by Ryan on 10/7/2015.
 */
public class Patient extends Person{
    private String address;
    private int SSN;
    private String gender;
    private String insurance;
    private int age;
    private int phone;
    private Appointments appoint;
    private HealthConditions hConditions;

    public Patient()//default constructor
    {
        address= "";
        SSN = 000000000;
        gender= "";
        insurance = "";
        age = 0;
        phone = 0000000000;
        appoint = new Appointments();
        hConditions = new HealthConditions();
    }
    public Patient(String address1, int SSN1, String gender1, String insurance1, int age1, int phone1, Person new1)
    {
        super(new1);// call the parent's constructor
        address = address1;
        SSN = SSN1;
        gender = gender1;
        insurance = insurance1;
        age = age1;
        phone = phone1;

    }
    public String getAddress()      { return address;}
    public int getSSN()             { return SSN;}
    public String getGender()       { return gender;}
    public String getInsurance()    { return insurance;}
    public int getAge()             { return age;}
    public int getPhone()           { return phone;}
    public String getFirstName()         { return getFName();}
    //update info methods

    public void setAddress(String add)      {address = add;}
    public void setSSN(int SSN1)            {SSN = SSN1;}
    public void setGender(String gender1)   {gender = gender1;}
    public void setInsurance(String insurance1){insurance=insurance1;}
    public void setAge(int age1)            {age = age1;}
    public void setPhone(int phone1)        {phone=phone1;}

    public void updatePatient(Patient toUpdate)
    {
        //call sql query with Patient 0bject
    }
    public void updateHealthConditions()
    {
        //modify the object health Conditions
    }
    public void updateAppointment()
    {
        //modify the oject appointments
    }

}

