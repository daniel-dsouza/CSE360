package org.teamone.client.prescription;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Patient;

import java.util.ArrayList;
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
        Patient p = new Patient();
        p.setUserID(1002);
        p = PatientSQL.getPatientComplete(p);
        ArrayList<Prescription> prescriptionList = DoctorSQL.getListPrescription(p);

        int i = 0;
        for(Prescription pP : prescriptionList){
            System.out.println(i);
            i++;
            System.out.println(pP.getPrescriptionType());
        }

        //List prescriptionList = DoctorSQL.getListPrescription(user.getPatient());
        model.put("prescriptions",prescriptionList);

        return "prescription/editprescription";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPatient(Map<String, Object> model) {

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
        attempt.setPatientID(user.getPatient().getUserID()); // This needs to be changed to the way we intend to get patient ID
        attempt.setDateAndTime(date);

        DoctorSQL.addPrescription(attempt);

        return "redirect:/user/" + user.person.getUserID();
    }
}
