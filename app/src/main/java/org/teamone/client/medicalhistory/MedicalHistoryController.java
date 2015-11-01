package org.teamone.client.medicalhistory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.LabStaff;
import org.teamone.core.users.MedicalHistory;
import org.teamone.core.users.Patient;

import java.util.Map;

/**
 * Created by James on 10/27/2015.
 */

@Controller
//@Scope("request")// Daniel we need to work together
@RequestMapping(value = "/**/medicalhistory")
public class MedicalHistoryController {


    //TODO add a button so patients can access this function
    @RequestMapping(method = RequestMethod.GET)
    public String viewHeathConditions(Map<String, Object> model,
                                      @ModelAttribute("user") User user)
    {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if(user.getPerson() instanceof LabStaff)
            return "redirect:/user/" + user.person.getUserID();
        else if(user.getPerson() instanceof Patient){
            Patient p = new Patient();
            p.setUserID(user.getPerson().getUserID());
            user.setPatient(PatientSQL.getPatientComplete(p));
        }

        if(user.getPatient() == null)               // If patient has not been initialized send them to patient select
            return "redirect:/select_patient";




        MedicalHistory userMedicalHistory = user.getPatient().getMedicalHistory();
        model.put("userInput", userMedicalHistory);

        return "medical-history/editmedicalhistory";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") MedicalHistory attempt,
                                     @ModelAttribute("user") User user) {

        user.getPatient().setMedicalHistory(attempt);
        PatientSQL.setMedicalHistory(user.getPatient());

        return "redirect:/user/" + user.getPerson().getUserID();
    }
}
