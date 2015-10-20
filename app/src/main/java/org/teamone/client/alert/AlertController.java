package org.teamone.client.alert;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teamone.core.users.Alert;
import org.teamone.core.users.PersonUtils;
import org.teamone.core.users.Staff;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by daniel on 10/19/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/alert")
public class AlertController {

    @RequestMapping(value = "/getalerts/{doctor}", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Alert> findDoctors(@PathVariable String doctor) {
        System.out.println("alerts tagged:" + doctor);
        //request list of patients with optional doctor.

        Alert one = new Alert();
        one.setAlertDateAndTime("rick and morty time");
        one.setAlertStatus(true);
        one.setPatientID(9413);
        one.setDoctorID(4561);
        one.setAlertID(3455);
        one.setReason("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam bibendum ex ac purus pharetra mollis.");

        Alert two = new Alert();
        two.setAlertDateAndTime("rick and morty time");
        two.setAlertStatus(true);
        two.setPatientID(9413);
        two.setDoctorID(4561);
        two.setAlertID(3455);
        two.setReason("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam bibendum ex ac purus pharetra mollis.");

        ArrayList<Alert> alertList= new ArrayList<Alert>();
        alertList.add(one);
        alertList.add(two);
        System.out.println("returning list of alerts");
        return alertList; //return JSON object
    }

    @RequestMapping(method = RequestMethod.GET)
    String displayAlerts(Map<String, Object> model) {
        return "alert/alert";
    }
}
