package org.teamone.client.patient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by James on 10/9/2015.
 */
@Controller
@RequestMapping(value = "/pateint/editPersonal")
public class PersonalController {


    @RequestMapping(method = RequestMethod.GET)
    public String editPersonalInformation(Map<String, Object> model) {

        PersonalUpdate attempt = populatePersonalInformation();
        model.put("userInput", attempt);

        return "/patient/patient-PersonalInformation";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInformation(@ModelAttribute("userInput") PersonalUpdate attempt,
                                            Map<String, Object> model) {

        System.out.println("Creating a Patient");

        //attempt.displayPersonalInformation();

        return "/patient/patient-PersonalInformation"; // should be patient's personal information view page
    }

    public PersonalUpdate populatePersonalInformation(){            //Simulates being given a patient object.
        PersonalUpdate patientInformation = new PersonalUpdate();
        // Random variables so I could not accidentally hard code it.
        // String decs
        String phone;
        String ageS = "";
        String zipcode = "";
        String SSN;
        // Ints
        int age = (int)(Math.random()*100)%100;
        int firstSetP = (int)(Math.random()*1000)%900+100;
        int secondSetP = (int)(Math.random()*1000)%900+100;
        int thirdSetP = (int)(Math.random()*10000)%9000+1000;
        int zip = (int)(Math.random()*100000)%90000+10000;
        int firstSetSSN = (int)(Math.random()*1000)%900+100;
        int secondSetSSN = (int)(Math.random()*100)%90+10;
        int thirdSetSSN = (int)(Math.random()*10000)%9000+1000;
        // String assigns
        phone = "("+firstSetP+")"+"-"+secondSetP+"-"+thirdSetP;
        ageS = ageS+age;
        zipcode = zipcode+zip;
        SSN = firstSetSSN+"-"+secondSetSSN+"-"+thirdSetSSN;

        patientInformation.setFirstName("James");
        patientInformation.setLastName("Hutchins");
        patientInformation.setAge(ageS);
        patientInformation.setAddress("123 S");
        patientInformation.setCity("Chandler");
        patientInformation.setState("Arizona");
        patientInformation.setZipcode(zipcode);
        patientInformation.setHomePhone(phone);
        patientInformation.setEmail("a@aa.aa");
        patientInformation.setInsurance("StateFarm");
        patientInformation.setssn(SSN);
        patientInformation.setGender("Male");           // This not working properly



        return patientInformation;
    }
}



class PersonalUpdate {

    //Start of the Patient's Personal Information (13 strings)__________________________________________________________
    private String firstName;
    private String lastName;        //2
    private String age;
    private String address;         //4
    private String city;
    private String state;           //6
    private String zipcode;
    private String homePhone;       //8
    private String email;
    private String insurance;       //10
    private String ssn;
    private String gender;          //12


    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getFirstName() {return this.firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getLastName() {return this.lastName;}

    public void setAddress(String address) {this.address = address;}
    public String getAddress() {return this.address;}

    public void setCity(String city) {this.city = city;}
    public String getCity() {return this.city;}

    public void setState(String state) {this.state = state;}
    public String getState() {return this.state;}

    public void setZipcode(String zipcode) {this.zipcode = zipcode;}
    public String getZipcode() {return this.zipcode;}

    public void setHomePhone(String homePhone) {this.homePhone = homePhone;}
    public String getHomePhone() {return this.homePhone;}

    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return this.email;}

    public void setInsurance(String insurance) {this.insurance = insurance;}
    public String getInsurance() {return this.insurance;}

    public void setssn(String ssn) {this.ssn = ssn;}
    public String getssn() {return this.ssn;}

    public void setAge(String age) {this.age = age;}
    public String getAge() {return this.age;}

    public void setGender(String gender) {this.gender = gender;}
    public String getGender() {return this.gender;}


    public void displayPersonalInformation() {
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Address: " + getAddress());
        System.out.println("City: " + getCity());
        System.out.println("State: " + getState());
        System.out.println("Zipcode: " + getZipcode());
        System.out.println("Home Phone #: " + getHomePhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Insurance: " + getInsurance());
        System.out.println("Social Security #: " + getssn());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
    }
}