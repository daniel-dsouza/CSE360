package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.SQL.MySQL;

public class AuthTest {

    private MySQL test;

    @Before
    public void setUp() {
        test = new MySQL();
    }

    @Test
    public void authentication() {
        try {
            String ID = "Doctor";
            String pass = "Doctor";
            if(test.verify(ID,pass))//Test authentication
                System.out.println("\nCorrect User");
            else
                System.out.println("\nIncorrect User");
        } catch(Exception e)
        {
            System.out.println(e.getStackTrace().toString());
        }
    }
}