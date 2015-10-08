package org.teamone.client.registration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by James on 10/8/2015.
 */


@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model) {
        //User userInput = new User();
        RegistrationAttempt attempt = new RegistrationAttempt();
        model.put("userInput", attempt);
        System.out.println("loading Registration");
        return "/registration/hsp-registration";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String processLogin(
            @ModelAttribute("userInput") RegistrationAttempt attempt,
            Map<String, Object> model) {
        System.out.println("First Name: " + attempt.getFirstName());
        System.out.println("Last Name: " + attempt.getLastName());
        System.out.println("Date of birth: " + attempt.getdob());
        System.out.println("Address: " + attempt.getAddress());
        System.out.println("City: " + attempt.getCity());
        System.out.println("State: " + attempt.getState());
        System.out.println("Zipcode: " + attempt.getZipcode());
        System.out.println("Home Phone #: " + attempt.getHomePhone());
        System.out.println("Email: " + attempt.getEmail());
        System.out.println("Gender: " + attempt.getGender());
        //more code
        return "/registration/hsp-registration";
    }
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
    private String gender;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }
    public String getdob() {
        return this.dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() { return this.city; }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return this.state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getZipcode() {
        return this.zipcode;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public String getHomePhone() {
        return this.homePhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return this.gender;
    }

    RegistrationAttempt(){}
}
