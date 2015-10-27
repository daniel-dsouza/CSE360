package org.teamone.client.healthconditions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.HealthConditions;
import org.teamone.core.users.Patient;

import java.util.Map;


/**
 * Created by daniel on 10/9/15.
 */

@Controller
//@Scope("request")// Daniel we need to work together
@RequestMapping(value = "/user/{userid}/healthconditions")
public class HealthConditionsController {

    Patient patient = new Patient();

    @RequestMapping(method = RequestMethod.GET)
    public String viewHeathConditions(Map<String, Object> model,
                                      @PathVariable int userid)
    {
       patient.setUserID(userid);
       patient = PatientSQL.getPatientComplete(patient);
       HealthConditions user = patient.getHealthConditions();
       model.put("userInput", user);

       return "health-conditions/edithealthconditions";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") HealthConditions attempt,
                                     @ModelAttribute("user") User user,
                                     Map<String, Object> model) {
       System.out.println("Loading Health Conditions");

       //attempt.displayHealthConditions();
        patient.setHealthConditions(attempt);
        PatientSQL.setHealthConditions(patient);

       //return "/health-conditions/edithealthconditions"; //This needs to change when integration starts
       return "redirect:/user/" + user.person.getUserID();
    }
}