package org.teamone.client.patient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.AlertSQL;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by daniel on 10/28/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/**/select_patient")
public class SelectPatientController {

    /**
     * This method handles the redirects for the buttons.
     *
     * @param model
     * @param user
     * @param action
     * @param patientID
     * @return
     */
    @RequestMapping(value = "/{patientID}/{action}")
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
        } else if (action.equals("health_conditions")) {
            return "redirect:/request_healthconditions/healthconditions";
        } else if (action.equals("medical_history")) {
            return "redirect:/request_medicalhistory/medicalhistory";
        } else if (action.equals("e_prescribe")) {
            return "redirect:/request_prescriptions/prescription";
        } else if (action.equals("view_lab_report")) {
            return "redirect:/request_report/lab_report/view_list/" + user.getPatient().getUserID();
        } else if (action.equals("edit_info")){
            return "redirect:/request_info/personal";
        } else {
            return "redirect:/user/" + user.person.getUserID();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String renderOptions(Map<String, Object> model,
                                @ModelAttribute("user") User user) {
        //and i would have gotten away with if it weren't for those meddling kids.
        if (user.getPerson() == null)
            return "redirect:/login";
        if (!(user.getPerson() instanceof Doctor) && !(user.getPerson() instanceof HSP))
            return "redirect:/user/" + user.person.getUserID();

        ArrayList<Patient> patients = PatientSQL.getAllPatient();

        Map<String, String> actions = new LinkedHashMap<String, String>();

        actions.put("medical_history", "Medical History");

        if (user.getPerson() instanceof Doctor) {
            actions.put("health_conditions", "Health Conditions");
            actions.put("e_prescribe", "E-Prescribe Prescription");
            actions.put("lab_test", "E-Prescribe Lab Tests");
            actions.put("view_lab_report", "View Lab Reports");
        }

        if (user.getPerson() instanceof HSP) {
            actions.put("e_prescribe", "View Prescriptions");
            actions.put("edit_info", "Update Personal");
        }

        model.put("actions", actions);
        model.put("patients", patients);
        return "patient/selectpatient";
    }

    /**
     * AJAX handler to return patient object
     *
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value = "/getpatientinfo/{patientID}", method = RequestMethod.GET)
    public
    @ResponseBody
    PatientInformation getPatientInformation(@PathVariable("patientID") int patientID) {
        Patient p = new Patient();
        p.setUserID(patientID);
        PatientInformation patientInformation = PatientSQL.getPatientComplete(p).getPatientInformation();
        return patientInformation; //return JSON object
    }

    /**
     * AJAX handler to return a patient's appointments.
     *
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value = "/getpatientappointments/{patientID}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Appointment> getPatientAppointments(@PathVariable("patientID") int patientID) {
//        Patient p = new Patient();
//        p.setUserID(patientID);
        Appointment a = new Appointment();
        a.setPatientID(patientID);
        List<Appointment> patientAppointments = AppointmentSQL.viewAppointmentByPatient(a);
        return patientAppointments;
    }

    /**
     * AJAX handler to return a patients alerts.
     *
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value = "/getpatientalerts/{patientID}", method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<Alert> getPatientAlerts(@PathVariable("patientID") int patientID) {
        Patient p = new Patient();
        p.setUserID(patientID);
        ArrayList<Alert> patientAlerts = AlertSQL.getListAlertsByPatient(p);
        return patientAlerts;
    }
}
