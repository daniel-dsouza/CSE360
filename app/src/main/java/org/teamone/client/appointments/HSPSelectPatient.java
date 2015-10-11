package org.teamone.client.appointments;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.teamone.client.generic.User;

import java.util.*;

import java.util.Map;

@Controller
@Scope("request")
@RequestMapping(value = "/HSPSelectPatient") //request mapping usually needed. this will suffice if unless you have multi-page form logic, eg. greater than 2 requests.
public class HSPSelectPatient {

    @RequestMapping(method = RequestMethod.GET)
    public String viewUserHome(Map<String, Object> model) {
        Appointment appointment1 = new Appointment(); //this is an example of a model attribute

        Map<String, String> patientList = new LinkedHashMap<String, String>(); //this is an example of a model attribute not in the appointment
        patientList.put("import", "import");
        patientList.put("IM", "IM");
        patientList.put("PORT", "PORT");

        //PRINT SELECTED NAME
        //PATIENT ID GOES TO APPT CLASS

        /*
        adding the model attributes to the model. Can be used to have preset answers,
        can be useful for updating stuff in the future.
         */
        model.put("appointment", appointment1);
        model.put("patientlist", patientList);


        System.out.println(model); //debug statement
        return "appointment/HSPSelectPatient"; //return the view with linked model
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePost(Map<String, Object> model,
                             @ModelAttribute("appointment") Appointment ap1) { //this tells the method that there will be a field named appointment in the model

        //System.out.println(ap1.getPatient());//proof.
        return "appointment/HSPSelectPatient"; //this will need to be "redirect:somesuccesspage" at some point.
    }
}
