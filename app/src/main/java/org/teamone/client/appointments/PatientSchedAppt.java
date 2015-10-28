package org.teamone.client.appointments;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Staff;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;





//import org.teamone.client.generic.User;

/**
 * Created by daniel on 10/7/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/appointment") //allows arbitrary prefixes.
public class PatientSchedAppt {

    /**
     * This is used with .ajax to dynamically update the list of doctors.
     * @param speciality which speciality was selected.
     * @return json list of doctors.
     */
    @RequestMapping(value = "/getdoctors/{speciality}", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Staff> findDoctors(@PathVariable String speciality) {
        ArrayList<Staff> doctorList = new ArrayList<Staff>(); //Hashing strikes again.
        doctorList = DoctorSQL.getListDoctorSpecialty(speciality);
        System.out.println(speciality); //DEBUG statements
        System.out.println("returning list");
        return doctorList; //return JSON object
    }

    @RequestMapping(value = "/gettimes/{name}", method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<Appointment> findTimes(@PathVariable String name) {
        System.out.println("Sending User name: " + name);
        int id = LoginSQL.getID(name);
        Doctor new1 = new Doctor();
        new1.setUserID(id);
        ArrayList<Appointment> dateList = AppointmentSQL.getAvailableDoctorTimes(new1);
        System.out.println(name); //DEBUG statements
        System.out.println("returning list");
        return dateList; //return JSON object
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewUserHome(Map<String, Object> model) {
        Appointment appointment1 = new Appointment(); //this is an example of a model attribute

        Map<String, String> speclist = new LinkedHashMap<String, String>(); //this is an example of a model attribute not in the appointment
        speclist.put("Emergency", "Emergency Doctor");//Internal value, user interface value
        speclist.put("Pediatrician", "Pediatrician");
        speclist.put("GeneralCare", "General Care");
        speclist.put("Neurologist", "Neurologist");
        speclist.put("X-Ray", "X-Ray Specialist");

        /*
        adding the model attributes to the model. Can be used to have preset answers,
        can be useful for updating stuff in the future.
         */
        model.put("appointment", appointment1);
        model.put("speclist", speclist);
        Map<String, String> doctorsList = new LinkedHashMap<String, String>();
        doctorsList.put("", "List of Doctors");
        model.put("doctorlist", doctorsList);


        Map<String,String> dateList = new LinkedHashMap<String,String>();
        dateList.put("List of Times", "List of Times");
        model.put("dateList", dateList);

        /*Doctor new1 = new Doctor();
        new1.setUserID(501);
        ArrayList<Appointment> timesList = AppointmentSQL.getAvailableDoctorTimes(new1);

        dateList.put("List of Times", "List of Times");
        Appointment tempApp;
        for (int i = 0; i < timesList.size(); i++) {
            tempApp = timesList.get(i);
            dateList.put(tempApp.getDate() + " " + tempApp.getTime(),tempApp.getDate() + " " +tempApp.getTime());
            System.out.println("Available Date: " + tempApp.getDate() + "\tTime: " + tempApp.getTime());
        }


       /dateList.put("October 14, 2015 10:00 AM", "October 14, 2015 10:00 AM");
        dateList.put("October 15, 2015 11:00 AM", "October 15, 2015 11:00 AM");
        dateList.put("October 16, 2015 9:00 AM","October 16, 2015 9:00 AM");
        dateList.put("October 16, 2015 3:00 PM", "October 16, 2015 3:00 PM");*/


        Map<String,String> reason = new LinkedHashMap<String,String>();

        model.put("reason", reason);

        System.out.println(model); //debug statement
        return "appointment/PatientSchedAppt"; //return the view with linked model
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePost(Map<String, Object> model,
                             @ModelAttribute("appointment") Appointment ap1) { //this tells the method that there will be a field named appointment in the model
        System.out.println(ap1.getDoctorSpec());
        System.out.println(ap1.getDoctorName());
        System.out.println(ap1.getReason());
        System.out.println(ap1.getDate());//proof.
        return "appointment/PatientSchedAppt"; //this will need to be "redirect:somesuccesspage" at some point.
    }
}
