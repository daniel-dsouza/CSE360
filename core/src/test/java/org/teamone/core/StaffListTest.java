package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.users.PersonUtils;
import org.teamone.core.users.Staff;

import java.util.ArrayList;

public class StaffListTest {

    private Staff test;

    @Before
    public void setUp() {

        test = new Staff();
        test.setSpecialty("Pediatrician");
    }

    @Test
    public void helpM() {
        ArrayList<Staff> testArr = PersonUtils.getStaffList("Pediatrician");
        if(testArr!=null)
        {

            Staff tempStaff;
            for(int i = 0; i < testArr.size(); i++) {
                tempStaff = testArr.get(i);
                System.out.println(tempStaff.getName());
            }
        }
        else
            System.out.println("LOGIN FAILED");
    }
}