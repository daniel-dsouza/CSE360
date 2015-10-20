package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.baseclasstests.TestStrings;
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
        System.out.println("\nTest========Testing login authentication");
        Person p = LoginSQL.authenticate(test);
        if(p!=null)
        {
            System.out.println("LOGIN SUCCESS!");
            System.out.println("Class: " + p.getClass());
            System.out.println("Name: " + p.getName());
            System.out.println("Occupation: " + p.getOccupation());
            System.out.println("Email: " + p.getEmail());
        }
        else
            System.out.println("LOGIN FAILED");
        System.out.println(TestStrings.testEnd);
    }
}
