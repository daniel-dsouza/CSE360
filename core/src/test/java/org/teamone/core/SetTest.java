package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.users.Person;
import org.teamone.core.users.PersonUtils;
import org.teamone.core.users.Staff;

import java.util.ArrayList;

public class SetTest {

    private Person test;

    @Before
    public void setUp() {

        test = new Person();
        test.setUserID(1232);
        test.setPassword("temporary");
    }

    @Test
    public void helpM() {
        ArrayList<Staff> testSet = PersonUtils.getStaffList("Neurologist");
        if(testSet!=null)
        {
            Staff temp = new Staff();
            for(int i = 0; i < testSet.size(); i++) {
            temp = testSet.get(i);
                System.out.println(temp.getName());
            }
        }
        else
            System.out.println("LOGIN FAILED");
    }
}