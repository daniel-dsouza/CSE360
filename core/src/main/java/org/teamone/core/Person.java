package org.teamone.core;

/**
 * Created by Ryan on 10/7/2015.
 */


public class Person {
    private int userID;
    private String fName;
    private String lName;
    private String occupation;
    private String password;
    private String email;

    public Person()//default constructor
    {
        userID= 0;
        fName = "";
        lName = "";
        occupation= "";
        password = "";
        email = "";
    }
    public Person(int ID ,String first, String last, String occ, String pas, String emai)// constructor
    {
        userID= ID;
        fName = first;
        lName=last;
        occupation= occ;
        password = pas;
        email = emai;
    }
    public Person(Person new1)//person constructor
    {
        userID= new1.getUserID();
        fName = new1.getFName();
        lName = new1.getLName();
        occupation= new1.getOccupation();
        password = new1.getPassword();
        email = new1.getEmail();
    }

    public String getEmail()        {        return email;    }
    public String getFName()        {        return fName;    }
    public String getLName()        {        return lName;    }
    public String getOccupation()   {        return occupation;    }
    public String getPassword()     {        return password;    }
    public int getUserID()          {        return userID;    }

    //update infomethods
    public void setEmail(String email1)    {        email = email1;    }
    public void setFName(String name1)     {        fName = name1;    }
    public void setLName(String name1)     {        lName = name1;    }
    public void setOccupation(String occ)  {        occupation = occ;    }
    public void setPassword(String pass)   {        password = pass;    }
    public void setUserID(int ID)          {        userID = ID;    }

    public void verify(String userID, String pass)
    {

    }
}
