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
        test.setUserID(101);
        test.setPassword("doctor1");
    }

    @Test
    public void helpM() {

        if(LoginSQL.authenticate(test))
        {
            System.out.println("LOGIN SUCCESS!");
        }
        else
            System.out.println("LOGIN FAILED");
    }
}