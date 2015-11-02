package org.teamone.client.patient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.LabStaff;
import org.teamone.core.users.Patient;
import org.teamone.core.users.PatientInformation;

import java.util.Map;

/**
 * Created by James on 10/9/2015.
 */
@Controller
@RequestMapping(value = "/**/personal")
public class PersonalController {

    @RequestMapping(method = RequestMethod.GET)
    public String editPersonalInformation(Map<String, Object> model,
                                          @ModelAttribute("user") User user) {

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



        String currentGender;
        String oppisiteGender;

        PatientInformation attempt = user.getPatient().getPatientInformation();
        if(attempt.getGender().equals("Male")){
            currentGender = "Male";
            oppisiteGender = "Female";
        }else{
            currentGender = "Female";
            oppisiteGender = "Male";
        }
        model.put("gender1", currentGender);
        model.put("gender2", oppisiteGender);
        model.put("userInput", attempt);

        return "/patient/patient-PersonalInformation";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInformation(@ModelAttribute("userInput") PatientInformation attempt,
                                            @ModelAttribute("user") User user) {

        user.getPatient().setPatientInformation(attempt);
        PatientSQL.UpdatePersonalInfo(user.getPatient());

        return "redirect:/user/" + user.person.getUserID();
    }
}