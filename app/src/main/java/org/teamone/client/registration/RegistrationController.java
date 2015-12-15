package org.teamone.client.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.HSP;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
//@Scope("request")//This breaks userID
public class RegistrationController {


    //The web page that leads to this must direct to registration/, registration will return a 404 error
    @RequestMapping(value = "/**/registration/", method = RequestMethod.GET)
    public String createPatient(Map<String, Object> model,
                                @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof HSP))//only HSP
            return "redirect:/user/" + user.person.getUserID();
        Patient attempt = new Patient();
        model.put("userInput", attempt);

        return "/registration/hsp-registration";
    }

    int ID = 0;

    @RequestMapping(value = "/**/registration/{page}", method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") Patient attempt,
                                     @ModelAttribute("user") User user,
                                     @PathVariable String page) {

        if (page.equalsIgnoreCase("page1")) {
            System.out.println("Creating a Patient");

            attempt = HspSQL.RegisterNewPatient(attempt);
            if (attempt != null) {
                System.out.println("*********************Register successful************************");
                ID = attempt.getUserID();
            } else
                System.out.println("\n************************Register failed********************");

            return "/registration/hsp-healthConditions";
        } else if (page.equalsIgnoreCase("page2")) {
            System.out.println("Loading Health Conditions");

            //attempt.displayHealthConditions();
            attempt.setUserID(ID);
            if (PatientSQL.setHealthConditions(attempt)) {
                System.out.println("Set successful");
            } else
                System.out.println("\nSet failed");

            //return "/registration/hsp-healthConditions"; //Used for debugging to make sure that check boxes functioned properly
            return "/registration/hsp-medicalHistory"; //This is the correct return
        } else {
            System.out.println("Loading Medical Conditions");

            //attempt.displayMedicalHistory();
            attempt.setUserID(ID);
            if (PatientSQL.setMedicalHistory(attempt)) {
                System.out.println("Set successful");
            } else
                System.out.println("\nSet failed");

            return "redirect:/user/" + user.person.getUserID();
        }
    }

    @RequestMapping(value = "/**/registrationStaff/", method = RequestMethod.GET)
    public String createStaff(Map<String, Object> model,
                                @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof HSP))//only HSP
            return "redirect:/user/" + user.person.getUserID();
        Staff attempt = new Staff();
        model.put("userInput", attempt);

        Map<String, String> speclist = new LinkedHashMap<String, String>(); //this is an example of a model attribute not in the appointment
        speclist.put("List", "List of Specialities");
        speclist.put("Emergency", "Emergency Doctor");//Internal value, user interface value
        speclist.put("Pediatrician", "Pediatrician");
        speclist.put("GeneralCare", "General Care");
        speclist.put("Neurologist", "Neurologist");
        speclist.put("X-Ray", "X-Ray Specialist");
        model.put("speclist",speclist);

        Map<String, String> occlist = new LinkedHashMap<String, String>(); //this is an example of a model attribute not in the appointment
        occlist.put("List", "List of Occupations");
        occlist.put("hsp", "One of us (HSP)");//Internal value, user interface value
        occlist.put("labstaff", "Lab Staff");
        occlist.put("doctor", "Doctor");
        model.put("occlist",occlist);

        Map<String, String> titlelist = new LinkedHashMap<String, String>(); //this is an example of a model attribute not in the appointment
        titlelist.put("List", " ");
        titlelist.put("Mr.", "Mr.");//Internal value, user interface value
        titlelist.put("Mister", "Mister");
        titlelist.put("Ms.", "Ms.");
        titlelist.put("Mrs.", "Mrs.");
        titlelist.put("Miss", "Miss");
        titlelist.put("Doctor", "Doctor");
        model.put("titlelist",titlelist);

        return "/registration/hsp-registrationStaff";
    }
    @RequestMapping(value = "/**/registrationStaff/", method = RequestMethod.POST)
    public String processStaff(Map<String, Object> model,
                               @ModelAttribute("userInput") Staff attempt,
                               @ModelAttribute("user") User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof HSP))//only HSP
            return "redirect:/user/" + user.person.getUserID();
        Staff result = HspSQL.RegisterNewStaff(attempt);
        if(result != null)
        {
            System.out.println("*********************Register successful************************");

            return "redirect:/user/" + user.person.getUserID();
        }
        else
        {
            String errorMessage = "Something went wrong. Contact your system Administrator";
            model.put("errorMessage", errorMessage);
            return "/registration/hsp-registrationStaff";
        }

    }
}
