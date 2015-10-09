package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LoginSQL;

public class HealthConditionUpdateTest {

    private Patient test;

    @Before
    public void setUp() {

        test = new Person();
        test.setPatientID(101);
        test.setHealthConditions("asdfghjklqwertyuiopzxcvbnm");
    }

    @Test
    public void helpM() {

        if(LoginSQL.authenticate(test))
        {
            System.out.println("LOGIN SUCCESS!");
        }
        else
            System.out.println("LOGIN FAILED");
        //Person p1 = SQL.cehck

    }
}