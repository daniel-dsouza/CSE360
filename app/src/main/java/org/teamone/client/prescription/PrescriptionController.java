package org.teamone.client.prescription;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.HSP;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by James on 10/27/2015.
 */

@Controller
@RequestMapping(value = "/**/prescription")
public class PrescriptionController {

    @RequestMapping(method = RequestMethod.GET)
     public String viewPatient(@ModelAttribute("user") User user,
                               Map<String, Object> model){
        if (user.getPerson() == null)
            return "redirect:/login";
        else if(user.getPerson() instanceof HSP)    // If the person is HSP they can only see and not create prescriptions
            model.put("readonly", true);
        else if (!(user.getPerson() instanceof Doctor))
            return "redirect:/user/" + user.person.getUserID();

        if(user.getPatient() == null)               // If patient has not been initialized send them to patient select
            return "redirect:/select_patient";


        List prescriptionList = DoctorSQL.getListPrescription(user.getPatient());
        model.put("prescriptions",prescriptionList);

        return "prescription/editprescription";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String moveToCreatePatient(@ModelAttribute("user") User user,
                                      Map<String, Object> model){


        return "redirect:/user/" + user.person.getUserID() + "/prescription/create";
    }





    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPatient(@ModelAttribute("user") User user,
                                Map<String, Object> model) {

        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof Doctor))
            return "redirect:/user/" + user.person.getUserID();

        if(user.getPatient() == null)
            return "redirect:/select_patient";



        Prescription attempt = new Prescription();
        model.put("userInput", attempt);

        return "prescription/createprescription";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") Prescription attempt,
                                     Map<String, Object> model,
                                     @ModelAttribute("user") User user) {
        Date date = new Date();
        attempt.setStaffID(user.person.getUserID());
        attempt.setPatientID(user.getPatient().getUserID());
        attempt.setDateAndTime(date);

        DoctorSQL.addPrescription(attempt);

        return "redirect:/user/" + user.person.getUserID() + "/prescription";
    }
}
