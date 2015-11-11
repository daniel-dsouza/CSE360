package org.teamone.client.appointments;

/**
 * Created by daniel on 10/16/15.
 */

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.AppointmentSQL;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.LabStaff;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.util.*;

//import org.teamone.client.generic.User;


@Controller
@Scope("request")
@RequestMapping(value = "/**/appointment")

public class AppointmentController {

    /**
     * This is used with .ajax to dynamically update the list of doctors.
     *
     * @param speciality which speciality was selected.
     * @return json list of doctors.
     */
    @RequestMapping(value = "/getdoctors/{speciality}", method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<Staff> findDoctors(@PathVariable String speciality) {
        ArrayList<Staff> doctorList = new ArrayList<Staff>(); //Hashing strikes again.
        doctorList = DoctorSQL.getListDoctorSpecialty(speciality);
        System.out.println(speciality); //DEBUG statements
        System.out.println("returning doctor list");
        return doctorList; //return JSON object
    }

    /**
     * This is used with .ajax to dynamically update the list of appointments.
     *
     * @param name which doctor has open appointments.
     * @return json list of appointments.
     */
    @RequestMapping(value = "/gettimes/{name}", method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<Appointment> findTimes(@PathVariable String name) {
        int id = LoginSQL.getID(name);
        Doctor new1 = new Doctor();
        new1.setUserID(id);
        ArrayList<Appointment> dateList = AppointmentSQL.getAvailableDoctorTimes(new1);
        Collections.sort(dateList, Appointment.dateCompare);
        System.out.println(name); //DEBUG statements
        System.out.println("returning date and time list");
        return dateList; //return JSON object
    }


    @RequestMapping(value = "/view/{appointmentID}", method = RequestMethod.GET)    //views one specific appt
    public String viewAppointment(Map<String, Object> model,
                                  @PathVariable int appointmentID,
                                  @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        System.out.println("view an appointment");
        Appointment appt = new Appointment();

        appt.setAppointmentID(appointmentID);
        Appointment appointment = AppointmentSQL.viewAppointmentByApptID(appt);

        //TODO: add extra stuff here.
        model.put("appointment", appointment);
        model.put("readonly", "readonly");
        return "appointment/PatientSchedAppt"; //return the view with linked model
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String viewUserHome(Map<String, Object> model,
                               @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        Appointment appointment1 = new Appointment(); //this is an example of a model attribute

        Map<String, String> speclist = new LinkedHashMap<String, String>(); //this is an example of a model attribute not in the appointment
        speclist.put("List", "List of Specialities");
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

/*
        Map<String, String> dateList = new LinkedHashMap<String, String>();
        dateList.put("0", "List of Times");
        model.put("dateList", dateList);
*/
        Map<String, String> reason = new LinkedHashMap<String, String>();

        model.put("reason", reason);

        //System.out.println(model); //debug statement
        return "appointment/createAppointmentHSPCOPY"; //return the view with linked model
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String handlePost(Map<String, Object> model,
                             @ModelAttribute("appointment") Appointment ap1,
                             @ModelAttribute("special")  LinkedHashMap<String, String> speclist1,
                             @ModelAttribute("doctor")  LinkedHashMap<String, String> doctorsList1,
                             @ModelAttribute("user") User user) { //this tells the method that there will be a field named appointment in the model

        System.out.println(ap1.getDoctorSpec());
        int docID = Integer.parseInt(ap1.getTempDocID());
        ap1.getDoctor().splitName(LoginSQL.getName(docID));
        System.out.println(ap1.getReason());
        System.out.println(user.getPerson().getUserID());
        ap1.setPatientID(user.getPerson().getUserID());
        ap1.setDoctorID(docID);
        System.out.println(ap1.getDoctorID());
        if (AppointmentSQL.createAppointment(ap1)) //Date time and doctor id
        {
            AppointmentSQL.schedAppointmentEmergencyAppt(ap1);
            return "redirect:/user/" + user.person.getUserID(); //this will need to be "redirect:somesuccesspage" at some point.
        }

        else {

            ap1.setFailedToInsert(1);
            model.put("appointment", ap1);
            model.put("speclist", speclist1);

            model.put("doctorlist", doctorsList1);

            Doctor failed = new Doctor();
            failed.setUserID(ap1.getDoctorID());
            List<Appointment> occupiedTimes = AppointmentSQL.getOccupiedTimes(failed);
            Collections.sort(occupiedTimes, Appointment.dateCompare);
            model.put("list", occupiedTimes);
            return "appointment/createAppointmentHSPCOPY"; //failed to insert
        }
    }

    @RequestMapping(value = "/edit/{appointmentID}", method = RequestMethod.GET)
    public String editAppointment(Map<String, Object> model,
                                  @PathVariable int appointmentID,
                                  @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        System.out.println("edit an appointment");

        Appointment appt = new Appointment();

        appt.setAppointmentID(appointmentID);
        Appointment current = AppointmentSQL.viewAppointmentByApptID(appt);

        //TODO: add extra stuff here.
        model.put("appointment", current);

        Map<String, String> speclist = new LinkedHashMap<String, String>(); //this is an example of a model attribute not in the appointment
        speclist.put("List", "List of Specialities");
        speclist.put("Emergency", "Emergency Doctor");//Internal value, user interface value
        speclist.put("Pediatrician", "Pediatrician");
        speclist.put("GeneralCare", "General Care");
        speclist.put("Neurologist", "Neurologist");
        speclist.put("X-Ray", "X-Ray Specialist");

        model.put("speclist", speclist);
        Map<String, String> doctorsList = new LinkedHashMap<String, String>();
        doctorsList.put("", "List of Doctors");
        model.put("doctorlist", doctorsList);


        Map<String, String> dateList = new LinkedHashMap<String, String>();
        dateList.put("0", "List of Times");
        model.put("dateList", dateList);

        Map<String, String> reason = new LinkedHashMap<String, String>();
        model.put("reason", reason);


        return "appointment/PatientSchedAppt"; //return the view with linked model

    }

    @RequestMapping(value = "/edit/{appointmentID}", method = RequestMethod.POST)
    public String handlePostEdit(Map<String, Object> model,
                                 @ModelAttribute("appointment") Appointment ap1,
                                 @PathVariable int appointmentID,
                                 @ModelAttribute("user") User user) { //this tells the method that there will be a field named appointment in the model

        System.out.println(ap1.getDoctorSpec());
        System.out.println(ap1.getDoctorName());
        System.out.println(ap1.getReason());
        System.out.println("new ID:" + ap1.getAppointmentID());
        System.out.println(user.getPerson().getUserID());
        ap1.setPatientID(user.getPerson().getUserID());

        int oldID = appointmentID;
        System.out.println("old ID:" + oldID);
        AppointmentSQL.swapAppointmentAppt(ap1, oldID);


        return "redirect:/user/" + user.person.getUserID(); //this will need to be "redirect:somesuccesspage" at some point.
    }

    @RequestMapping(value = "/createappointment", method = RequestMethod.GET)
    public String createAppointment(Map<String, Object> model,
                                    @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (user.getPerson() instanceof LabStaff || user.getPerson() instanceof Patient)
            return "redirect:/user/" + user.person.getUserID();

        System.out.println("Create an appointment");

        Appointment appt = new Appointment();

        model.put("appointment", appt);
        model.put("user", user);
        return "appointment/createAppointment"; //return the view with linked model

    }

    @RequestMapping(value = "/createappointment/{docID}", method = RequestMethod.GET)
    public String createAppointmentID(Map<String, Object> model,
                                      @PathVariable String docID,
                                      @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (user.getPerson() instanceof LabStaff || user.getPerson() instanceof Patient)
            return "redirect:/user/" + user.person.getUserID();

        System.out.println("Create an appointment");

        Appointment appt = new Appointment();
        appt.setTempDocID(docID);
        model.put("appointment", appt);
        model.put("user", user);
        return "appointment/createAppointmentHSP"; //return the view with linked model

    }

    @RequestMapping(value = "/createappointment", method = RequestMethod.POST)
    public String createAppointmentPost(Map<String, Object> model,
                                        @ModelAttribute("appointment") Appointment appt,
                                        @ModelAttribute("user") User user) { //this tells the method that there will be a field named appointment in the model

        if (user.getPerson() instanceof Doctor)
            appt.setDoctorID(user.getPerson().getUserID());//Doctors can not change the id.
        else
            appt.setDoctorID(Integer.parseInt(appt.getTempDocID()));//must be a HSP person
        //System.out.println("DocID: " + appt.getDoctorID());
        System.out.println("Created appointment Date: " + appt.getDate());
        //System.out.println("Time: " + appt.getTime());

        if (AppointmentSQL.createAppointment(appt)) //Date time and doctor id
        {
            return "redirect:/user/" + user.person.getUserID(); //this will need to be "redirect:somesuccesspage" at some point.
        } else {
            appt.setFailedToInsert(1);
            model.put("appointment", appt);

            Doctor failed = new Doctor();
            failed.setUserID(appt.getDoctorID());
            List<Appointment> occupiedTimes = AppointmentSQL.getOccupiedTimes(failed);

            Collections.sort(occupiedTimes, Appointment.dateCompare);
            model.put("list", occupiedTimes);
            return "appointment/createAppointment"; //failed to insert
        }
    }
    @RequestMapping(value = "/createappointment/{docID}", method = RequestMethod.POST)
    public String createAppointmentHSPPost(Map<String, Object> model,
                                        @ModelAttribute("appointment") Appointment appt,
                                        @ModelAttribute("user") User user) { //this tells the method that there will be a field named appointment in the model

        if (user.getPerson() instanceof Doctor)
            appt.setDoctorID(user.getPerson().getUserID());//Doctors can not change the id.
        else
            appt.setDoctorID(Integer.parseInt(appt.getTempDocID()));//must be a HSP person
        //System.out.println("DocID: " + appt.getDoctorID());
        System.out.println("Created appointment Date: " + appt.getDate());
        //System.out.println("Time: " + appt.getTime());

        if (AppointmentSQL.createAppointment(appt)) //Date time and doctor id
        {
            AppointmentSQL.schedAppointmentEmergencyAppt(appt);
            return "redirect:/user/" + user.person.getUserID(); //this will need to be "redirect:somesuccesspage" at some point.
        }

        else {

            appt.setFailedToInsert(1);
            model.put("appointment", appt);

            Doctor failed = new Doctor();
            failed.setUserID(appt.getDoctorID());
            List<Appointment> occupiedTimes = AppointmentSQL.getOccupiedTimes(failed);
            Collections.sort(occupiedTimes, Appointment.dateCompare);
            model.put("list", occupiedTimes);
            return "appointment/createAppointmentHSP"; //failed to insert
        }
    }
}
