package org.teamone.client.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.Patient;

import java.util.Map;

@Controller
public class RegistrationController {

    //Patient attempt = new Patient();

    //The web page that leads to this must direct to registration/, registration will return a 404 error
    @RequestMapping(value = "/user/**/registration/", method = RequestMethod.GET)
    public String createPatient(Map<String, Object> model) {

        Patient attempt = new Patient();
        model.put("userInput", attempt);

        return "/registration/hsp-registration";
    }

    int ID = 0;

    @RequestMapping(value = "/user/**/registration/{page}", method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") Patient attempt,
                                     Map<String, Object> model, @ModelAttribute("user") User user,
                                     @PathVariable String page) {

        if(page.equalsIgnoreCase("page1")) {
            System.out.println("Creating a Patient");

            //attempt.displayPatientPersonalInformation();
            attempt=HspSQL.RegisterNewPatient(attempt);
            if(attempt!=null)
            {
                System.out.println("*********************Register successful************************");
                ID = attempt.getUserID();
            }
            else
                System.out.println("\n************************Register failed********************");

            return "/registration/hsp-healthConditions";
        }else if(page.equalsIgnoreCase("page2")){
            System.out.println("Loading Health Conditions");

            //attempt.displayHealthConditions();
            attempt.setUserID(ID);
            if(PatientSQL.setHealthConditions(attempt))
            {
                System.out.println("Set successful");
            }
            else
                System.out.println("\nSet failed");

            //return "/registration/hsp-healthConditions"; //Used for debugging to make sure that check boxes functioned properly
            return "/registration/hsp-medicalHistory"; //This is the correct return
        }else{
            System.out.println("Loading Medical Conditions");

            //attempt.displayMedicalHistory();
            attempt.setUserID(ID);
            if(PatientSQL.setMedicalHistory(attempt))
            {
                System.out.println("Set successful");
            }
            else
                System.out.println("\nSet failed");

            //return "/registration/hsp-medicalHistory"; //Used for debugging to make sure that check boxes functioned properly
            //return "/registration/hsp-registration"; //This should be hsp-patients page or hsp-homepage or what ever the page that this should exit to is called
            return "redirect:/user/" + user.person.getUserID();
        }
    }
}
