package org.teamone.client.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.teamone.client.generic.User;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by daniel on 10/7/15.
 */

@Controller
@Scope("request")
public class PatientSchedAppt {

    //@Autowired
    //private User user;

    @RequestMapping(value = "/SchedAppt", method = RequestMethod.GET)
    public String viewUserHome(
            Map<String, Object> model)
            {
        //model.put("user", user);
        System.out.println("load User?");
        System.out.println(model);
        //System.out.println(user);
        //System.out.println(user.getUsername());
        //System.out.println(userID);
        return "PatientSchedAppt";
            }
    @ModelAttribute("creditCardTypes")

    public Map<String,String> populateDoctorsList() {
        Map<String,String> doctorsList = new LinkedHashMap<String,String>();
        doctorsList.put("VS", "Visa"); doctorsList.put("MC", "MasterCard");
        doctorsList.put("AE", "American Express");
        doctorsList.put("DS", "Discover"); doctorsList.put("DC", "Diner's Club");
        return  doctorsList;
    }

}

class Appointment {
    public String doctor;

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getDoctor() {
        return this.doctor;
    }
}