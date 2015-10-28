package org.teamone.client.appointments;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.appointments.Appointment;

import java.util.List;
import java.util.Map;

//import org.teamone.client.generic.User;

/**
 * Created by daniel on 10/16/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/**/appointment/list")
public class AppointmentListController {

    @RequestMapping(method = RequestMethod.GET)
    public String findPatients(Map<String, Object> model, @ModelAttribute User user) {
        List<Appointment> patientList; //Hashing strikes again.
        System.out.println(user.getPerson().getUserID() + " this works"); //DEBUG statements
        //TODO: get user appointments from the path variable.
        Appointment temp = new Appointment();
        temp.setPatientID(user.getPerson().getUserID());
        patientList = AppointmentSQL.viewAppointmentByPatient(temp);
        for (Appointment tem : patientList) {
            System.out.println("ID: " + tem.getAppointmentID());
        }
        model.put("patientList", patientList);

        return "appointment/list";//return the view with linked model
        //TODO: this controller will display a list of the user appointments. for each, the user can select whether to create a new appointment, or edit/delete one. Delete not necessary.
    }
}
