package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.users.Person;

public class LoginTest {

    private Person test;

    @Before
    public void setUp() {

        test = new Person();
        test.setUserID(1232);
        test.setPassword("temporary");
    }

    @Test
    public void helpM() {

        if(LoginSQL.authenticate(test)!=null)
        {
            System.out.println("LOGIN SUCCESS!");
            System.out.println("Name: " + test.getName());
            System.out.println("Occupation: " + test.getOccupation());
            System.out.println("Email: " + test.getEmail());
        }
        else
            System.out.println("LOGIN FAILED");
    }
}