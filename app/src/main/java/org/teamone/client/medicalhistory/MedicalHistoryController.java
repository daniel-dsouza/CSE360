package org.teamone.client.medicalhistory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.MedicalHistory;
import org.teamone.core.users.Patient;

import java.util.Map;

/**
 * Created by James on 10/27/2015.
 */

@Controller
//@Scope("request")// Daniel we need to work together
@RequestMapping(value = "/user/{userid}/medicalhistory")
public class MedicalHistoryController {

    Patient patient = new Patient();

    @RequestMapping(method = RequestMethod.GET)
    public String viewHeathConditions(Map<String, Object> model,
                                      @PathVariable int userid)
    {
        patient.setUserID(userid);
        patient = PatientSQL.getPatientComplete(patient);
        MedicalHistory user = patient.getMedicalHistory();
        model.put("userInput", user);

        return "medical-history/editmedicalhistory";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") MedicalHistory attempt,
                                     @ModelAttribute("user") User user,
                                     Map<String, Object> model) {
        System.out.println("Loading Health Conditions");

        patient.setMedicalHistory(attempt);
        PatientSQL.setMedicalHistory(patient);

        return "redirect:/user/" + user.person.getUserID();
    }
}
