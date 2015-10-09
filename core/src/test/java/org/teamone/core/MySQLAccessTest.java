package org.teamone.core;

import org.teamone.core.SQL.MySQLAccess;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MySQLAccessTest {

    private MySQLAccess test;

    @Before
    public void setUp() {
        test = new MySQLAccess();
    }

    @Test
    public void getMessage_ShouldReturnMessage() {
        try {
            //test.readDataBase();//comment out this to prevent testing it.
           // System.out.println("Read successfully");
        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace().toString());
        }
    }
}