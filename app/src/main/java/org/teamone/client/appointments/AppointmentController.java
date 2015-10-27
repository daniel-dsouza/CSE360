package org.teamone.client.appointments;

/**
 * Created by daniel on 10/16/15.
 */

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Staff;
//import org.teamone.client.generic.User;

import java.util.*;
import java.util.Map;


@Controller
@Scope("request")
@RequestMapping(value = "/**/appointment")
public class AppointmentController {

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
        System.out.println("returning doctor list");
        return doctorList; //return JSON object
    }

    /**
     * This is used with .ajax to dynamically update the list of appointments.
     * @param doctor which doctor has open appointments.
     * @return json list of appointments.
     */
    @RequestMapping(value = "/getappointments/{doctor}", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Staff> findAppointments(@PathVariable String doctor) {
//        ArrayList<Staff> doctorList = new ArrayList<Staff>(); //Hashing strikes again.
        //doctorList = PersonUtils.getStaffList(speciality);
        //System.out.println(speciality); //DEBUG statements
        ArrayList<Appointment> timesList = new ArrayList<Appointment>();
        int docId = LoginSQL.getID(doctor);                     //NEEDS THIS
        timesList = DoctorSQL.getDoctorsAppointment(docId); // TODO: method needs to be created in backend
        System.out.println(doctor); //DEBUG statements
        System.out.println("returning times list");
        return timesList;   //NEEDS THIS
    }

    @RequestMapping(method = RequestMethod.POST)    // this method pre-populates editAppt criteria with previously selected criteria
    public String handlePost(Map<String, Object> model,
                             @ModelAttribute("appointment") Appointment ap1) { //this tells the method that there will be a field named appointment in the model
        System.out.println(ap1.getDoctorSpec());
        System.out.println(ap1.getDoctorName());
        System.out.println(ap1.getReason());//proof.
        //TODO: needs to end up in database.
        //TODO: DANIEL DOES THIS
        return "appointment/EditAppt"; //TODO: this needs to redirect back to the appointment list page. /{user}/appointment/list
    }

    @RequestMapping(value = "/view/{appointmentID}", method = RequestMethod.GET)    //views one specific appt
    public String viewAppointment(Map<String, Object> model,
                                      @PathVariable String appointmentID) {
        System.out.println("view an appointment");
        Appointment appointment = AppointmentSQL.viewAppointmentAppt(appointmentID); //TODO: method needs to return just one appt in backend

        //TODO: add extra stuff here.
        model.put("appointment", appointment);
        model.put("readonly", "readonly");
        return "appointment/PatientSchedAppt"; //return the view with linked model
    }

    @RequestMapping(value = "/edit/{appointmentID}", method = RequestMethod.GET)
    public String editAppointment(Map<String, Object> model,
                                  @PathVariable String appointmentID) {
        System.out.println("edit an appointment");
        Appointment appointment = AppointmentSQL.viewAppointmentAppt(appointmentID); //TODO: method needs to return just one appt in backend

        //TODO: add extra stuff here.
        model.put("appointment", appointment);

        return "appointment/PatientSchedAppt"; //return the view with linked model

    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAppointment(Map<String, Object> model) {
        System.out.println("Creating a new appointment");
        Appointment appointment1 = new Appointment(); //this is an example of a model attribute
        model.put("appointment", appointment1);

        Map<String, String> doctorsList = new LinkedHashMap<String,String>(); //this is an example of a model attribute not in the appointment
       //TODO:only thing that stays????
        doctorsList.put("Emergency", "Emergency Doctor");//Internal value, user interface value
        doctorsList.put("Pediatrician", "Pediatrician");
        doctorsList.put("GeneralCare", "General Care");
        doctorsList.put("Neurologist", "Neurologist");
        doctorsList.put("X-Ray", "X-Ray Specialist");

        /*
        adding the model attributes to the model. Can be used to have preset answers,
        can be useful for updating stuff in the future.
         */
        model.put("doctorlist", doctorsList);

        Map<String,String> dateList = new LinkedHashMap<String,String>();
        //goes
        //get list of times
        //display list of times
        dateList.put("List of Times", "List of Times");
        dateList.put("October 14, 2015 10:00 AM", "October 14, 2015 10:00 AM");
        dateList.put("October 15, 2015 11:00 AM", "October 15, 2015 11:00 AM");
        dateList.put("October 16, 2015 9:00 AM","October 16, 2015 9:00 AM");
        dateList.put("October 16, 2015 3:00 PM", "October 16, 2015 3:00 PM");
        model.put("dateList", dateList);

        Map<String,String> reason = new LinkedHashMap<String,String>();

        model.put("reason", reason); //TODO: needs to go into base class.

        model.put("readonly", "none");
        return "appointment/PatientSchedAppt"; //return the view with linked model
    }
}
