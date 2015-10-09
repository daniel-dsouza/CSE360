package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.LoginSQL;

public class LoginTest {

    private Person test;

    @Before
    public void setUp() {

        test = new Person();
        test.setUserID(101);
        test.setPassword("100");
    }

    @Test
    public void helpM() {
        LoginSQL.authenticate(test);
    }
}