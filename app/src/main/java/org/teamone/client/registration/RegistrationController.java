package org.teamone.client.registration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by James on 10/8/2015.
 */


@Controller
@Scope("request") //provides the user variable
public class RegistrationController {

    RegistrationAttempt attempt;

    public RegistrationController() {
        if (attempt == null)
            attempt = new RegistrationAttempt();
    }

    @RequestMapping(value = "/registration/{page}", method = RequestMethod.GET)
    public String createPatient(Map<String, Object> model,
                                @PathVariable String page) {

        String pageMapping = "registration/hsp-registration";

        if (page.equals("page1")) {
            attempt = new RegistrationAttempt();
            pageMapping = "registration/hsp-registration";
        }
        else if (page.equals("page2"))
            pageMapping = "registration/hsp-healthConditions";
        else if (page.equals("page3"))
            pageMapping = "registration/registration-page3";

        model.put("userInput", attempt);
        System.out.println("loading Registration");
        return pageMapping;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String createHealthConditions(Map<String, Object> model) {
//
//        HealthConditionsAttempt attempt = new HealthConditionsAttempt();
//        model.put("userChecks", attempt);
//        System.out.println("Loading Health Conditions");
//        return "/registration/hsp-registration";
//    }


/*    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") RegistrationAttempt attempt,
                                     @PathVariable String page,
                                     Map<String, Object> model) {

        System.out.println(page);

        return "/registration/hsp-registration";

    }*/

//    @RequestMapping(method = RequestMethod.POST)
//    public String processHealthConditions(@ModelAttribute("userChecks") HealthConditionsAttempt attempt, Map<String, Object> model) {
//
//        System.out.println("Ankle Pain: "+attempt.getAnklePain());
//        System.out.println("Anxiety: "+attempt.getAnxiety());
//        System.out.println("BadBreath: "+attempt.getBadBreath());
//
//        return "/registration/hsp-healthConditions";
//    }
}

class RegistrationAttempt {
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String homePhone;
    private String email;
    private String insurance;
    private String ssn;
    private String age;
    private String gender;


    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return this.firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return this.lastName; }

    public void setdob(String dob) { this.dob = dob; }
    public String getdob() { return this.dob; }

    public void setAddress(String address) { this.address = address; }
    public String getAddress() { return this.address; }

    public void setCity(String city) { this.city = city; }
    public String getCity() { return this.city; }

    public void setState(String state) { this.state = state; }
    public String getState() { return this.state; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
    public String getZipcode() { return this.zipcode; }

    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }
    public String getHomePhone() { return this.homePhone; }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return this.email; }

    public void setInsurance(String insurance) { this.insurance = insurance; }
    public String getInsurance() { return this.insurance; }

    public void setssn(String ssn) { this.ssn = ssn; }
    public String getssn() { return this.ssn; }

    public void setAge(String age) { this.age = age; }
    public String getAge() { return this.age; }

    public void setGender(String gender) { this.gender = gender; }
    public String getGender() { return this.gender; }

    boolean anklePain;
    boolean anxiety;
    boolean badBreath;

    public void setAnklePain(boolean anklePain) { this.anklePain = anklePain; }
    public boolean getAnklePain() { return this.anklePain; }

    public void setAnxiety(boolean anxiety) { this.anxiety = anxiety; }
    public boolean getAnxiety() { return this.anxiety; }

    public void setBadBreath(boolean badBreath) { this.badBreath = badBreath; }
    public boolean getBadBreath() { return this.badBreath; }

    RegistrationAttempt(){}
}
