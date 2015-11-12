package org.teamone.client.alert;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.AlertSQL;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Alert;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.HSP;
import org.teamone.core.users.Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by daniel on 10/19/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/alert")
public class AlertController {

    /**
     * AJAX handler to return alerts.
     *
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value = "/getalerts", method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<Alert> getListAlert() {
        //System.out.println("alerts tagged:" + doctor);
        //request list of patients with optional doctor.

        ArrayList<Alert> alertList = AlertSQL.getListAlerts();
        System.out.println("returning list of alerts");
        return alertList; //return JSON object
    }

    /**
     * AJAX handler to return alerts.
     *
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value = "/getalertspopup", method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<Alert> find5min() {
        //System.out.println("alerts tagged:" + doctor);
        //request list of patients with optional doctor.

        ArrayList<Alert> alertList = AlertSQL.getListAlertsPopUp();
        System.out.println("returning list of alerts");
        return alertList; //return JSON object
    }

    /**
     * This is used with .ajax to dynamically update the list of doctors.
     *
     * @return json list of doctors.
     */
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public
    @ResponseBody
    Doctor checkAlert(@ModelAttribute("user") User user) {
        Doctor temp1 = new Doctor();
        Boolean isEmergency = false;//use this to prevent null pointer since doctor may not be created

        if (user.getDoctor() != null) //if doctor
        {
            if (user.doctor.getSpecialty() != null)// if specialty exists
            {
                if (user.doctor.getSpecialty().equals("Emergency")) {
                    isEmergency = true;
                }
            }
        }
        if (isEmergency || user.getPerson() instanceof HSP)//HSP override
        {
            if (AlertSQL.areThereAlerts()) {
                java.util.Date dateAndTime = new java.util.Date();
                java.text.SimpleDateFormat sdf =
                        new java.text.SimpleDateFormat("h:mm:ss a");
                String Time = sdf.format(dateAndTime);
                System.out.println("Alerts Detected " + Time);
                temp1.setAlertsPresent(1);
                user.doctor.setAlertsPresent(1);
            } else {
                temp1.setAlertsPresent(0);
                user.doctor.setAlertsPresent(0);
            }
        }
        return temp1; //return JSON object
    }

    /**
     * Resolves an alert.
     *
     * @param alertID
     */
    @RequestMapping(value = "/resolvealert/{alertID}", method = RequestMethod.GET)
    public
    @ResponseBody
    void resolveAlert(@PathVariable String alertID) {
        Alert resolved = new Alert();
        try {
            resolved.setAlertID(Integer.parseInt(alertID));
            AlertSQL.setAlertOff(resolved);
            System.out.println("Resolved alert: " + alertID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    String displayAlerts(Map<String, Object> model) {
        return "alert/alert";
    }

    @RequestMapping(value = "/hsp", method = RequestMethod.GET)
    public String resolveAlert(Map<String, Object> model,
                               @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (user.getPerson() instanceof HSP) {
            System.out.println("Getting Emergency doctor list");
            ArrayList<Staff> doctorList;
            doctorList = DoctorSQL.getListDoctorSpecialty("Emergency");
            model.put("docList", doctorList);
            return "alert/hsp";
        } else {
            return "redirect:/user/" + user.person.getUserID();
        }

    }

    /**
     * AJAX handler to return doctor object
     *
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value = "/getdoctorinfo/{doctorID}", method = RequestMethod.GET)
    public
    @ResponseBody
    Staff getPatientInformation(@PathVariable("doctorID") int doctorID) {
        Staff staff = new Staff();
        staff.setUserID(doctorID);
        Staff sendBack = DoctorSQL.getStaffComplete(staff);
        return sendBack; //return JSON object
    }

    /**
     * AJAX handler to return a doctor's appointments.
     *
     * @return list of alerts as JSON objects
     */
    @RequestMapping(value = "/getdoctorappt/{doctorID}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Appointment> getDoctorAppointments(@PathVariable("doctorID") int doctorID) {
        Appointment a = new Appointment();
        a.setDoctorID(doctorID);
        List<Appointment> doctorAppointments = AppointmentSQL.viewFutureAppointmentByDoctor(a);
        Collections.sort(doctorAppointments, Appointment.dateCompare);
        return doctorAppointments;
    }
}
