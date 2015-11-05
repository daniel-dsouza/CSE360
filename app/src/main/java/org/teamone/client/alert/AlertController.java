package org.teamone.client.alert;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.AlertSQL;
import org.teamone.core.users.Alert;
import org.teamone.core.users.Doctor;

import java.util.ArrayList;
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
    ArrayList<Alert> findDoctors() {
        //System.out.println("alerts tagged:" + doctor);
        //request list of patients with optional doctor.

        ArrayList<Alert> alertList = AlertSQL.getListAlerts();
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
        if (user.getPerson() != null && user.getDoctor() != null && user.doctor.getSpecialty().equals("Emergency")) {
            if (AlertSQL.areThereAlerts()) {
                System.out.println("Alerts Detected");
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
     * @return
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
}
