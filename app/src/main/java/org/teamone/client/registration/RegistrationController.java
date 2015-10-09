package org.teamone.client.registration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String createPatient(Map<String, Object> model) {
        //User userInput = new User();
        RegistrationAttempt attempt = new RegistrationAttempt();
        model.put("userInput", attempt);
        System.out.println("Loading Registration");
        return "/registration/hsp-registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") RegistrationAttempt attempt,
                                     Map<String, Object> model) {

        if(1 == 1) {        //Still can't get the moving through the pages & assign values to variables to work at the same time______This code gets the form inputs but does not cycle
            System.out.println("Creating a Patient");

            //attempt.displayPatientPersonalInformation();

            return "/registration/hsp-healthConditions";
        }else if(2 == 2){
            System.out.println("Loading Health Conditions");

            //attempt.displayHealthConditions();

            //return "/registration/hsp-healthConditions"; //Used for debugging to make sure that check boxes functioned properly
            return "/registration/registration-page3"; //This is the correct return
        }else{


            return "/registration/hsp-registration";
        }
    }

}

class RegistrationAttempt {

    //Start of the Patient's Personal Information_______________________________________________________________________
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


    public void displayPatientPersonalInformation(){
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Date of Birth: " + getdob());
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




    //Start of "Health conditions_______________________________________________________________________________________
    private boolean anklePain;
    private boolean anxiety;
    private boolean badBreath;
    private boolean bleedingGums;
    private boolean bloodyStools;
    private boolean constipation;
    private boolean diarrhea;
    private boolean discoloredUrine;
    private boolean dizziness;
    private boolean drySkin;
    private boolean earDrainage;
    private boolean excessiveBurping;
    private boolean excessiveYawning;
    private boolean fatigue;
    private boolean footPain;
    private boolean frequentUrination;
    private boolean gas;
    private boolean hairLoss;
    private boolean headaches;
    private boolean hearingProblems;
    private boolean heartBurn;
    private boolean highBloodPressure;
    private boolean impotence;
    private boolean jointPain;
    private boolean lowerBackPain;
    private boolean nightBlindness;
    private boolean nightUrination;
    private boolean noseBleeds;
    private boolean protrudingEyes;
    private boolean redFace;
    private boolean redThickSkin;
    private boolean sensitivityToLight;
    private boolean snoring;
    private boolean stomachPain;
    private boolean swelling;
    private boolean testiclePain;
    private boolean visionProblems;
    private boolean vomiting;
    private boolean warts;
    private boolean wheezing;

    public void setAnklePain(boolean anklePain) { this.anklePain = anklePain; }
    public boolean getAnklePain() { return this.anklePain; }

    public void setAnxiety(boolean anxiety) { this.anxiety = anxiety; }
    public boolean getAnxiety() { return this.anxiety; }

    public void setBadBreath(boolean badBreath) { this.badBreath = badBreath; }
    public boolean getBadBreath() { return this.badBreath; }

    public void setBleedingGums(boolean bleedingGums) { this.bleedingGums = bleedingGums; }
    public boolean getBleedingGums() { return this.bleedingGums; }

    public void setBloodyStools(boolean bloodyStools) { this.bloodyStools = bloodyStools; }
    public boolean getBloodyStools() { return this.bloodyStools; }

    public void setConstipation(boolean constipation) { this.constipation = constipation; }
    public boolean getConstipation() { return this.constipation; }

    public void setDiarrhea(boolean diarrhea) { this.diarrhea = diarrhea; }
    public boolean getDiarrhea() { return this.diarrhea; }

    public void setDiscoloredUrine(boolean discoloredUrine) { this.discoloredUrine = discoloredUrine; }
    public boolean getDiscoloredUrine() { return this.discoloredUrine; }

    public void setDizziness(boolean dizziness) { this.dizziness = dizziness; }
    public boolean getDizziness() { return this.dizziness; }

    public void setDrySkin(boolean drySkin) { this.drySkin = drySkin; }
    public boolean getDrySkin() { return this.drySkin; }

    public void setEarDrainage(boolean earDrainage) { this.earDrainage = earDrainage; }
    public boolean getEarDrainage() { return this.earDrainage; }

    public void setExcessiveBurping(boolean excessiveBurping) { this.excessiveBurping = excessiveBurping; }
    public boolean getExcessiveBurping() { return this.excessiveBurping; }

    public void setExcessiveYawning(boolean excessiveYawning) { this.excessiveYawning = excessiveYawning; }
    public boolean getExcessiveYawning() { return this.excessiveYawning; }

    public void setFatigue(boolean fatigue) { this.fatigue = fatigue; }
    public boolean getFatigue() { return this.fatigue; }

    public void setFootPain(boolean footPain) { this.footPain = footPain; }
    public boolean getFootPain() { return this.footPain; }

    public void setFrequentUrination(boolean frequentUrination) { this.frequentUrination = frequentUrination; }
    public boolean getFrequentUrination() { return this.frequentUrination; }

    public void setGas(boolean gas) { this.gas = gas; }
    public boolean getGas() { return this.gas; }

    public void setHairLoss(boolean hairLoss) { this.hairLoss = hairLoss; }
    public boolean getHairLoss() { return this.hairLoss; }

    public void setHeadaches(boolean headaches) { this.headaches = headaches; }
    public boolean getHeadaches() { return this.headaches; }

    public void setHearingProblems(boolean hearingProblems) { this.hearingProblems = hearingProblems; }
    public boolean getHearingProblems() { return this.hearingProblems; }

    public void setHeartBurn(boolean heartBurn) { this.heartBurn = heartBurn; }
    public boolean getHeartBurn() { return this.heartBurn; }

    public void setHighBloodPressure(boolean highBloodPressure) { this.highBloodPressure = highBloodPressure; }
    public boolean getHighBloodPressure() { return this.highBloodPressure; }

    public void setImpotence(boolean impotence) { this.impotence = impotence; }
    public boolean getImpotence() { return this.impotence; }

    public void setJointPain(boolean jointPain) { this.jointPain = jointPain; }
    public boolean getJointPain() { return this.jointPain; }

    public void setLowerBackPain(boolean lowerBackPain) { this.lowerBackPain = lowerBackPain; }
    public boolean getLowerBackPain() { return this.lowerBackPain; }

    public void setNightBlindness(boolean nightBlindness) { this.nightBlindness = nightBlindness; }
    public boolean getNightBlindness() { return this.nightBlindness; }

    public void setNightUrination(boolean nightUrination) { this.nightUrination = nightUrination; }
    public boolean getNightUrination() { return this.nightUrination; }

    public void setNoseBleeds(boolean noseBleeds) { this.noseBleeds = noseBleeds; }
    public boolean getNoseBleeds() { return this.noseBleeds; }

    public void setProtrudingEyes(boolean protrudingEyes) { this.protrudingEyes = protrudingEyes; }
    public boolean getProtrudingEyes() { return this.protrudingEyes; }

    public void setRedFace(boolean redFace) { this.redFace = redFace; }
    public boolean getRedFace() { return this.redFace; }

    public void setRedThickSkin(boolean redThickSkin) { this.redThickSkin = redThickSkin; }
    public boolean getRedThickSkin() { return this.redThickSkin; }

    public void setSensitivityToLight(boolean sensitivityToLight) { this.sensitivityToLight = sensitivityToLight; }
    public boolean getSensitivityToLight() { return this.sensitivityToLight; }

    public void setSnoring(boolean snoring) { this.snoring = snoring; }
    public boolean getSnoring() { return this.snoring; }

    public void setStomachPain(boolean stomachPain) { this.stomachPain = stomachPain; }
    public boolean getStomachPain() { return this.stomachPain; }

    public void setSwelling(boolean swelling) { this.swelling = swelling; }
    public boolean getSwelling() { return this.swelling; }

    public void setTesticlePain(boolean testiclePain) { this.testiclePain = testiclePain; }
    public boolean getTesticlePain() { return this.testiclePain; }

    public void setVisionProblems(boolean visionProblems) { this.visionProblems = visionProblems; }
    public boolean getVisionProblems() { return this.visionProblems; }

    public void setVomiting(boolean vomiting) { this.vomiting = vomiting; }
    public boolean getVomiting() { return this.vomiting; }

    public void setWarts(boolean warts) { this.warts = warts; }
    public boolean getWarts() { return this.warts; }

    public void setWheezing(boolean wheezing) { this.wheezing = wheezing; }
    public boolean getWheezing() { return this.wheezing; }

    public void displayHealthConditions(){
        System.out.println("Ankle Pain: "+getAnklePain());
        System.out.println("Anxiety: "+getAnxiety());
        System.out.println("Bad Breath: "+getBadBreath());
        System.out.println("Bleeding Gums: "+getBleedingGums());
        System.out.println("Bloody Stools: "+getBloodyStools());
        System.out.println("Constipation: "+getConstipation());
        System.out.println("Diarrhea: "+getDiarrhea());
        System.out.println("Discolored Urine: "+getDiscoloredUrine());
        System.out.println("Dizziness: "+getDizziness());
        System.out.println("Dry Skin: "+getDrySkin());
        System.out.println("Ear Drainage: "+getEarDrainage());
        System.out.println("Excessive Burping: "+getExcessiveBurping());
        System.out.println("Excessive Yawning: "+getExcessiveYawning());
        System.out.println("Fatigue: "+getFatigue());
        System.out.println("Foot Pain: "+getFootPain());
        System.out.println("Frequent Urination: "+getFrequentUrination());
        System.out.println("Gas: "+getGas());
        System.out.println("Hair Loss: "+getHairLoss());
        System.out.println("Headaches: "+getHeadaches());
        System.out.println("Hearing Problems: "+getHearingProblems());
        System.out.println("Heart Burn: "+getHeartBurn());
        System.out.println("High Blood Pressure: "+getHighBloodPressure());
        System.out.println("Impotence: "+getImpotence());
        System.out.println("Joint Pain: "+getJointPain());
        System.out.println("Lower Back Pain: "+getLowerBackPain());
        System.out.println("Night Blindness: "+getNightBlindness());
        System.out.println("Night Urination: "+getNightUrination());
        System.out.println("Nose Bleeds: "+getNoseBleeds());
        System.out.println("Protruding Eyes: "+getProtrudingEyes());
        System.out.println("Red Face: "+getRedFace());
        System.out.println("Red, Thick Skin: "+getRedThickSkin());
        System.out.println("Sensitivity To Light: "+getSensitivityToLight());
        System.out.println("Snoring: "+getSnoring());
        System.out.println("Stomach Pain: "+getStomachPain());
        System.out.println("Swelling: "+getSwelling());
        System.out.println("Testicle Pain: "+getTesticlePain());
        System.out.println("Vision Problems: "+getVisionProblems());
        System.out.println("Vomiting: "+getVomiting());
        System.out.println("Warts: "+getWarts());
        System.out.println("Wheezing: "+getWheezing());
    }





    RegistrationAttempt(){}
}