package org.teamone.client.prescription;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.SQL.PrescriptionSQL;
import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.HSP;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

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
                              Map<String, Object> model) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (user.getPerson() instanceof HSP)    // If the person is HSP they can only see and not create prescriptions
            model.put("readonly", true);
        else if (!(user.getPerson() instanceof Doctor))
            return "redirect:/user/" + user.person.getUserID();

        if (user.getPatient() == null)               // If patient has not been initialized send them to patient select
            return "redirect:/select_patient";


        List prescriptionList = PrescriptionSQL.getListPrescription(user.getPatient());
        model.put("prescriptions", prescriptionList);
        model.put("user", user);
        return "prescription/editprescription";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String moveToCreatePatient(@ModelAttribute("user") User user,
                                      Map<String, Object> model) {


        return "redirect:/user/" + user.person.getUserID() + "/prescription/create";
    }


    @RequestMapping(value = "/{prescriptID}/print", method = RequestMethod.GET)
    public String printPatient(@ModelAttribute("user") User user,
                               @PathVariable("prescriptID") int preID,
                               Map<String, Object> model) {

        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof Doctor))
            return "redirect:/user/" + user.person.getUserID();

        if (user.getPatient() == null)
            return "redirect:/select_patient";


        Prescription prescript = new Prescription();
        prescript.setPrescriptionID(preID);
        prescript = PrescriptionSQL.viewPrescriptonByID(prescript);
        Patient pat = PatientSQL.getPatientComplete(prescript.getPatient());
        Staff doc = DoctorSQL.getStaffComplete(prescript.getDoctor());


        model.put("doc", doc);
        model.put("pat", pat);
        model.put("prescription", prescript);


        return "prescription/printprescription";
    }


    @RequestMapping(value = "/{prescriptID}/print", method = RequestMethod.POST)
    public String postPrint(@ModelAttribute("userInput") Prescription attempt,
                            Map<String, Object> model,
                            @ModelAttribute("user") User user) {


        return "redirect:/user/" + user.person.getUserID() + "/prescription";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPatient(@ModelAttribute("user") User user,
                                Map<String, Object> model) {

        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof Doctor))
            return "redirect:/user/" + user.person.getUserID();

        if (user.getPatient() == null)
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
        PrescriptionSQL.addPrescription(attempt);

        return "redirect:/user/" + user.person.getUserID() + "/prescription";
    }
}
