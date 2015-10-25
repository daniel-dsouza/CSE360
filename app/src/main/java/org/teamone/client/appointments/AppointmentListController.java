package org.teamone.client.appointments;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.PersonUtils;
import org.teamone.core.users.Staff;
//import org.teamone.client.generic.User;

import java.util.*;
import java.util.Map;

/**
 * Created by daniel on 10/16/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/**/{user}/appointment/list")
public class AppointmentListController {

    @RequestMapping(method = RequestMethod.GET)
    void findDoctors(Map<String, Object> model, @PathVariable String user) {
        ArrayList<Staff> doctorList = new ArrayList<Staff>(); //Hashing strikes again.
        System.out.println(user + "this works"); //DEBUG statements
        //TODO: get user appointments from the path variable.

        //TODO: this controller will display a list of the user appointments. for each, the user can select whether to create a new appointment, or edit/delete one. Delete not necessary.
    }
}
