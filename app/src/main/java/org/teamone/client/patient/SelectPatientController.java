package org.teamone.client.patient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Alert;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;
import org.teamone.core.users.PatientInformation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by daniel on 10/28/15.
 */

@Controller
@Scope("request")
@RequestMapping(value="/**/select_patient")
public class SelectPatientController {

    @RequestMapping(value="/{patientID}/{action}")
    public String processAction(Map<String, Object> model,
                                @ModelAttribute("user") User user,
                                @PathVariable("action") String action,
                                @PathVariable("patientID") String patientID) {
        //add patient to user variable
        Patient input = new Patient();
        try {
            input.setUserID(Integer.parseInt(patientID));
            user.setPatient(PatientSQL.getPatientComplete(input));
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: redirect to error page.
        }

        //redirect to correct page.
        if (action.equals("lab_test")) {
            return "redirect:/request_test/create";
        } else {
            return "redirect:/user/" + user.person.getUserID();
        }
    }

    @RequestMapping(method=RequestMethod.GET)
    public String renderOptions(Map<String, Object> model,
                                @ModelAttribute("user") User user) {
        ArrayList<Patient> patients = PatientSQL.getAllPatient();

        Map<String, String> actions = new LinkedHashMap<String, String>();
        actions.put("health_conditions", "Health Conditions");
        actions.put("medical_history", "Medical History");

        if(user.getPerson() instanceof Doctor) {
            actions.put("e_prescribe", "E-Prescribe Prescription");
            actions.put("lab_test", "E-Prescribe Lab Tests");
        }

        model.put("actions", actions);
        model.put("patients", patients);
        return "patient/selectpatient";
    }

    /**
     * AJAX handler to return alerts.
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value="/getpatientinfo/{patientID}", method = RequestMethod.GET)
    public @ResponseBody
    PatientInformation getPatientInformation(@PathVariable("patientID") int patientID) {
        Patient p = new Patient();
        p.setUserID(patientID);
        PatientInformation patientInformation = PatientSQL.getPatientComplete(p).getPatientInformation();
        return patientInformation; //return JSON object
    }

    /**
     * AJAX handler to return alerts.
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value="/getpatientappointments/{patientID}", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Appointment> getPatientAppointments(@PathVariable("patientID") int patientID) {
        Patient p = new Patient();
        p.setUserID(patientID);

    }

    /**
     * AJAX handler to return alerts.
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value="/getpatientalerts/{patientID}", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Alert> getPatientAlerts(@PathVariable("patientID") int patientID) {
        Patient p = new Patient();
        p.setUserID(patientID);

    }
}
