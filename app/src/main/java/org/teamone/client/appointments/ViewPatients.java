package org.teamone.client.appointments;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.HSP;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//import org.teamone.client.generic.User;


@Controller
@Scope("request")
@RequestMapping(value = "/ViewPatients") //request mapping usually needed. this will suffice if unless you have multi-page form logic, eg. greater than 2 requests.
public class ViewPatients {

    @RequestMapping(method = RequestMethod.GET)
    public String viewUserHome(Map<String, Object> model,
                               @ModelAttribute("user") User user) {
        //this is an example of a model attribute
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        if (user.person instanceof HSP)
            patientList = PatientSQL.getAllPatient();
        else if (user.person instanceof Doctor)
        {
            Staff temp = new Staff();
            temp.setStaffID(user.person.getUserID());
            patientList = PatientSQL.getPatientByStaff(temp); //getPatientByStaff not complete

        }
        else
            return "redirect:/login";

        model.put("patientList", patientList);

        System.out.println(model); //debug statement
        return "appointment/ViewAppt"; //return the view with linked model

    }

}