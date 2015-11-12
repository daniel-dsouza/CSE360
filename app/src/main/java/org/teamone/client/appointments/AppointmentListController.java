package org.teamone.client.appointments;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.appointments.Appointment;

import java.util.Collections;
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
        if (user.getPerson() == null )
            return "redirect:/login";
        List<Appointment> patientList; //Hashing strikes again.
        //System.out.println(user.getPerson().getUserID() + " this works"); //DEBUG statements
        Appointment temp = new Appointment();
        temp.setPatientID(user.getPerson().getUserID());
        patientList = AppointmentSQL.viewAppointmentByPatient(temp);
        /*for (Appointment tem : patientList) {
            System.out.println("Appt ID: " + tem.getAppointmentID());
        }*/
        Collections.sort(patientList, Appointment.dateCompare);
        model.put("patientList", patientList);

        return "appointment/PatientList";//return the view with linked model

    }


    @RequestMapping(value = "/delete/{appointmentID}", method = RequestMethod.GET)
    public String handlePostEdit(Map<String, Object> model,
                                 @PathVariable int appointmentID) { //this tells the method that there will be a field named appointment in the model

        AppointmentSQL.delAppointmentAppt(appointmentID);


        return "redirect:/appointment/list"; //this will need to be "redirect:somesuccesspage" at some point.
    }
    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public String findDoctors(Map<String, Object> model, @ModelAttribute User user) {
        if (user.getPerson() == null )
            return "redirect:/login";
        List<Appointment> doctorList; //Hashing strikes again.
        //System.out.println(user.getPerson().getUserID() + " this works"); //DEBUG statements
        Appointment temp = new Appointment();
        temp.setDoctorID(user.getPerson().getUserID());
        doctorList = AppointmentSQL.viewAppointmentByDoctor(temp);
        /*for (Appointment tem : doctorList) {
            System.out.println("Appt ID: " + tem.getAppointmentID());
        }*/
        Collections.sort(doctorList, Appointment.dateCompare);
        model.put("doctorList", doctorList);

        return "appointment/DoctorList";//return the view with linked model

    }


}
