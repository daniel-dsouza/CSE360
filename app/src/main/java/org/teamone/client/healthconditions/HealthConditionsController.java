package org.teamone.client.healthconditions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.HealthConditions;
import org.teamone.core.users.LabStaff;
import org.teamone.core.users.Patient;

import java.util.Map;


/**
 * Created by daniel on 10/9/15.
 */

@Controller
//@Scope("request")// Daniel we need to work together
@RequestMapping(value = "/**/healthconditions")
public class HealthConditionsController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewHeathConditions(Map<String, Object> model,
                                      @ModelAttribute("user") User user) {

        if (user.getPerson() == null)
            return "redirect:/login";
        else if (user.getPerson() instanceof LabStaff)
            return "redirect:/user/" + user.person.getUserID();
        else if (user.getPerson() instanceof Patient) {
            Patient p = new Patient();
            p.setUserID(user.getPerson().getUserID());
            user.setPatient(PatientSQL.getPatientComplete(p));
        }
        if (user.getPatient() == null)               // If patient has not been initialized send them to patient select
            return "redirect:/select_patient";


        HealthConditions userHealthConditions = user.getPatient().getHealthConditions();

        model.put("userInput", userHealthConditions);

        return "health-conditions/edithealthconditions";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") HealthConditions attempt,
                                     @ModelAttribute("user") User user) {

        user.getPatient().setHealthConditions(attempt);
        PatientSQL.setHealthConditions(user.getPatient());

        return "redirect:/select_patient";
    }

    @RequestMapping(value = "/view/{patientID}", method = RequestMethod.GET)
    public String readOnly(Map<String, Object> model,
                           @ModelAttribute("user") User user,
                           @PathVariable int patientID) {

        if (user.getPerson() == null)
            return "redirect:/login";
        else if (user.getPerson() instanceof LabStaff)
            return "redirect:/user/" + user.person.getUserID();
        else if (!(user.getPerson() instanceof Patient))//allows doctors and hsp to view
        {
            Patient p = new Patient();
            p.setUserID(patientID);
            user.setPatient(PatientSQL.getPatientComplete(p));
        }
        if (user.getPatient() == null)               // If patient has not been initialized send them to patient select
            return "redirect:/select_patient";


        HealthConditions userHealthConditions = user.getPatient().getHealthConditions();

        model.put("userInput", userHealthConditions);
        model.put("readonly", true);

        return "health-conditions/edithealthconditions";
    }
}