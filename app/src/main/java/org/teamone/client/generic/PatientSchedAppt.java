package org.teamone.client.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.teamone.client.generic.User;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by daniel on 10/7/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/appointment") //request mapping usually needed. this will suffice if unless you have multi-page form logic, eg. greater than 2 requests.
public class PatientSchedAppt {

    @RequestMapping(method = RequestMethod.GET)
    public String viewUserHome(Map<String, Object> model) {
        Appointment appointment1 = new Appointment(); //this is an example of a model attribute

        Map<String, String> doctorsList = new LinkedHashMap<String,String>(); //this is an example of a model attribute not in the appointment
        doctorsList.put("Emergency Doctor", "Emergency Doctor");
        doctorsList.put("Pediatrician", "Pediatrician");
        doctorsList.put("General Care", "General Care");
        doctorsList.put("Neurologist", "Neurologist");
        doctorsList.put("X-Ray Specialist", "X-Ray Specialist");

        /*
        adding the model attributes to the model. Can be used to have preset answers,
        can be useful for updating stuff in the future.
         */
        model.put("appointment", appointment1);
        model.put("doctorlist", doctorsList);

       // Experimental below this line
        Map<String,String> doctorPerson = new LinkedHashMap<String,String>();

        doctorPerson.put("Dr. A", "Dr. A");
        doctorPerson.put("Dr. B", "Dr. B");
        doctorPerson.put("Dr. C", "Dr. C");
        doctorPerson.put("Dr. D", "Dr. D");
        model.put("doctorPersonList", doctorPerson);

        Map<String,String> reason = new LinkedHashMap<String,String>();

        model.put("reason", reason);

        System.out.println(model); //debug statement
        return "PatientSchedAppt"; //return the view with linked model
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePost(Map<String, Object> model,
                             @ModelAttribute("appointment") Appointment ap1) { //this tells the method that there will be a field named appointment in the model
        System.out.println(ap1.getDoctor()); //proof.
        return "PatientSchedAppt"; //this will need to be "redirect:somesuccesspage" at some point.
    }
}

class Appointment {
    public String doctor;
    public String doctorPerson;
    public String reason;

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getDoctor() {
        return this.doctor;
    }

    public void setdoctorPerson(String doctorPerson) {
        this.doctorPerson = doctorPerson;
    }
    public String getdoctorPerson() {
        return this.doctorPerson;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getReason(){
        return this.reason;
    }
}