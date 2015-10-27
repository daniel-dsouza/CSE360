package org.teamone.client.patient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.Patient;
import org.teamone.core.users.PatientInformation;

import java.util.Map;

/**
 * Created by James on 10/9/2015.
 */
@Controller
@RequestMapping(value = "/user/{userid}/personal")
public class PersonalController {

    Patient patient = new Patient();

    @RequestMapping(method = RequestMethod.GET)
    public String editPersonalInformation(Map<String, Object> model,
                                          @PathVariable int userid) {

        patient.setUserID(userid);
        patient = PatientSQL.getPatientComplete(patient);
        System.out.println(patient.getAddress());
        //PersonalUpdate attempt = populatePersonalInformation();
        PatientInformation attempt = patient.getPatientInformation();
        model.put("userInput", attempt);

        return "/patient/patient-PersonalInformation";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInformation(@ModelAttribute("userInput") PatientInformation attempt,
                                            @ModelAttribute("user") User user,
                                            Map<String, Object> model) {

        System.out.println("Creating a Patient");

        //attempt.displayPersonalInformation();
        patient.setPatientInformation(attempt);
        PatientSQL.UpdatePersonalInfo(patient);

        //return "/patient/patient-PersonalInformation"; // should be patient's personal information view page
        return "redirect:/user/" + user.person.getUserID();
    }
}