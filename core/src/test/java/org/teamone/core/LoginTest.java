package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.baseclasstests.TestStrings;
import org.teamone.core.users.Person;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private Person test;

    @Before
    public void setUp() {

        test = new Person();
        test.setUserID(501);
        test.setName("Doctor Ryan:Ang");
        test.setPassword("go");
    }

    @Test
    public void helpM() {
        System.out.println("\nTest========Testing login authentication");
        Person p = LoginSQL.authenticate(test);
        assertTrue("Login failed", p != null);

        System.out.println("LOGIN SUCCESS!");
        System.out.println("Class: " + p.getClass());
        System.out.println("Name: " + p.getName());
        System.out.println("Occupation: " + p.getOccupation());
        System.out.println("Email: " + p.getEmail());
        System.out.println("UserID: " + p.getUserID());

        System.out.println(TestStrings.testEnd);
    }

    @Test
    public void twoWay() {
        System.out.println("\nTest========Testing name to ID and ID to name");
        LoginSQL.getName(test.getUserID());
        LoginSQL.getID(test.getName());

        System.out.println(TestStrings.testEnd);
    }

}
