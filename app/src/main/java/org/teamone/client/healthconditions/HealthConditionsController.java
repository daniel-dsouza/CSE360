package org.teamone.client.healthconditions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


/**
 * Created by daniel on 10/9/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/healthconditions")
public class HealthConditionsController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewHeathConditions(Map<String, Object> model)
//            @PathVariable String userID


     {
         RegistrationAttempt user = populateInfo();
         model.put("userInput", user);
         System.out.println("getting data");
         System.out.println("view user health conditions for ");
         System.out.print(model);
         return "health-conditions/edithealthconditions";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") RegistrationAttempt attempt,
                                     Map<String, Object> model) {


            System.out.println("Loading Health Conditions");

//            attempt.displayHealthConditions();

            return "/health-conditions/edithealthconditions"; //This needs to change when integration starts

    }
    public RegistrationAttempt populateInfo(){
        RegistrationAttempt user = new RegistrationAttempt();
        user.setConstipation(true);
        user.setAnklePain(true);
        user.setDizziness(true);
        return user;

    }

}





class RegistrationAttempt {


    //Start of "Health conditions (40 booleans)_________________________________________________________________________
    private boolean anklePain;
    private boolean anxiety;
    private boolean badBreath;              //3
    private boolean bleedingGums;
    private boolean bloodyStools;
    private boolean constipation;           //6
    private boolean diarrhea;
    private boolean discoloredUrine;
    private boolean dizziness;              //9
    private boolean drySkin;
    private boolean earDrainage;
    private boolean excessiveBurping;       //12
    private boolean excessiveYawning;
    private boolean fatigue;
    private boolean footPain;               //15
    private boolean frequentUrination;
    private boolean gas;
    private boolean hairLoss;               //18
    private boolean headaches;
    private boolean hearingProblems;
    private boolean heartBurn;              //21
    private boolean highBloodPressure;
    private boolean impotence;
    private boolean jointPain;              //24
    private boolean lowerBackPain;
    private boolean nightBlindness;
    private boolean nightUrination;         //27
    private boolean noseBleeds;
    private boolean protrudingEyes;
    private boolean redFace;                //30
    private boolean redThickSkin;
    private boolean sensitivityToLight;
    private boolean snoring;                //33
    private boolean stomachPain;
    private boolean swelling;
    private boolean testiclePain;           //36
    private boolean visionProblems;
    private boolean vomiting;
    private boolean warts;                  //39
    private boolean wheezing;

    public void setAnklePain(boolean anklePain) {
        this.anklePain = anklePain;
    }

    public boolean getAnklePain() {
        return this.anklePain;
    }

    public void setAnxiety(boolean anxiety) {
        this.anxiety = anxiety;
    }

    public boolean getAnxiety() {
        return this.anxiety;
    }

    public void setBadBreath(boolean badBreath) {
        this.badBreath = badBreath;
    }

    public boolean getBadBreath() {
        return this.badBreath;
    }

    public void setBleedingGums(boolean bleedingGums) {
        this.bleedingGums = bleedingGums;
    }

    public boolean getBleedingGums() {
        return this.bleedingGums;
    }

    public void setBloodyStools(boolean bloodyStools) {
        this.bloodyStools = bloodyStools;
    }

    public boolean getBloodyStools() {
        return this.bloodyStools;
    }

    public void setConstipation(boolean constipation) {
        this.constipation = constipation;
    }

    public boolean getConstipation() {
        return this.constipation;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean getDiarrhea() {
        return this.diarrhea;
    }

    public void setDiscoloredUrine(boolean discoloredUrine) {
        this.discoloredUrine = discoloredUrine;
    }

    public boolean getDiscoloredUrine() {
        return this.discoloredUrine;
    }

    public void setDizziness(boolean dizziness) {
        this.dizziness = dizziness;
    }

    public boolean getDizziness() {
        return this.dizziness;
    }

    public void setDrySkin(boolean drySkin) {
        this.drySkin = drySkin;
    }

    public boolean getDrySkin() {
        return this.drySkin;
    }

    public void setEarDrainage(boolean earDrainage) {
        this.earDrainage = earDrainage;
    }

    public boolean getEarDrainage() {
        return this.earDrainage;
    }

    public void setExcessiveBurping(boolean excessiveBurping) {
        this.excessiveBurping = excessiveBurping;
    }

    public boolean getExcessiveBurping() {
        return this.excessiveBurping;
    }

    public void setExcessiveYawning(boolean excessiveYawning) {
        this.excessiveYawning = excessiveYawning;
    }

    public boolean getExcessiveYawning() {
        return this.excessiveYawning;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public boolean getFatigue() {
        return this.fatigue;
    }

    public void setFootPain(boolean footPain) {
        this.footPain = footPain;
    }

    public boolean getFootPain() {
        return this.footPain;
    }

    public void setFrequentUrination(boolean frequentUrination) {
        this.frequentUrination = frequentUrination;
    }

    public boolean getFrequentUrination() {
        return this.frequentUrination;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public boolean getGas() {
        return this.gas;
    }

    public void setHairLoss(boolean hairLoss) {
        this.hairLoss = hairLoss;
    }

    public boolean getHairLoss() {
        return this.hairLoss;
    }

    public void setHeadaches(boolean headaches) {
        this.headaches = headaches;
    }

    public boolean getHeadaches() {
        return this.headaches;
    }

    public void setHearingProblems(boolean hearingProblems) {
        this.hearingProblems = hearingProblems;
    }

    public boolean getHearingProblems() {
        return this.hearingProblems;
    }

    public void setHeartBurn(boolean heartBurn) {
        this.heartBurn = heartBurn;
    }

    public boolean getHeartBurn() {
        return this.heartBurn;
    }

    public void setHighBloodPressure(boolean highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public boolean getHighBloodPressure() {
        return this.highBloodPressure;
    }

    public void setImpotence(boolean impotence) {
        this.impotence = impotence;
    }

    public boolean getImpotence() {
        return this.impotence;
    }

    public void setJointPain(boolean jointPain) {
        this.jointPain = jointPain;
    }

    public boolean getJointPain() {
        return this.jointPain;
    }

    public void setLowerBackPain(boolean lowerBackPain) {
        this.lowerBackPain = lowerBackPain;
    }

    public boolean getLowerBackPain() {
        return this.lowerBackPain;
    }

    public void setNightBlindness(boolean nightBlindness) {
        this.nightBlindness = nightBlindness;
    }

    public boolean getNightBlindness() {
        return this.nightBlindness;
    }

    public void setNightUrination(boolean nightUrination) {
        this.nightUrination = nightUrination;
    }

    public boolean getNightUrination() {
        return this.nightUrination;
    }

    public void setNoseBleeds(boolean noseBleeds) {
        this.noseBleeds = noseBleeds;
    }

    public boolean getNoseBleeds() {
        return this.noseBleeds;
    }

    public void setProtrudingEyes(boolean protrudingEyes) {
        this.protrudingEyes = protrudingEyes;
    }

    public boolean getProtrudingEyes() {
        return this.protrudingEyes;
    }

    public void setRedFace(boolean redFace) {
        this.redFace = redFace;
    }

    public boolean getRedFace() {
        return this.redFace;
    }

    public void setRedThickSkin(boolean redThickSkin) {
        this.redThickSkin = redThickSkin;
    }

    public boolean getRedThickSkin() {
        return this.redThickSkin;
    }

    public void setSensitivityToLight(boolean sensitivityToLight) {
        this.sensitivityToLight = sensitivityToLight;
    }

    public boolean getSensitivityToLight() {
        return this.sensitivityToLight;
    }

    public void setSnoring(boolean snoring) {
        this.snoring = snoring;
    }

    public boolean getSnoring() {
        return this.snoring;
    }

    public void setStomachPain(boolean stomachPain) {
        this.stomachPain = stomachPain;
    }

    public boolean getStomachPain() {
        return this.stomachPain;
    }

    public void setSwelling(boolean swelling) {
        this.swelling = swelling;
    }

    public boolean getSwelling() {
        return this.swelling;
    }

    public void setTesticlePain(boolean testiclePain) {
        this.testiclePain = testiclePain;
    }

    public boolean getTesticlePain() {
        return this.testiclePain;
    }

    public void setVisionProblems(boolean visionProblems) {
        this.visionProblems = visionProblems;
    }

    public boolean getVisionProblems() {
        return this.visionProblems;
    }

    public void setVomiting(boolean vomiting) {
        this.vomiting = vomiting;
    }

    public boolean getVomiting() {
        return this.vomiting;
    }

    public void setWarts(boolean warts) {
        this.warts = warts;
    }

    public boolean getWarts() {
        return this.warts;
    }

    public void setWheezing(boolean wheezing) {
        this.wheezing = wheezing;
    }

    public boolean getWheezing() {
        return this.wheezing;
    }

    public void displayHealthConditions() {
        System.out.println("Ankle Pain: " + getAnklePain());
        System.out.println("Anxiety: " + getAnxiety());
        System.out.println("Bad Breath: " + getBadBreath());
        System.out.println("Bleeding Gums: " + getBleedingGums());
        System.out.println("Bloody Stools: " + getBloodyStools());
        System.out.println("Constipation: " + getConstipation());
        System.out.println("Diarrhea: " + getDiarrhea());
        System.out.println("Discolored Urine: " + getDiscoloredUrine());
        System.out.println("Dizziness: " + getDizziness());
        System.out.println("Dry Skin: " + getDrySkin());
        System.out.println("Ear Drainage: " + getEarDrainage());
        System.out.println("Excessive Burping: " + getExcessiveBurping());
        System.out.println("Excessive Yawning: " + getExcessiveYawning());
        System.out.println("Fatigue: " + getFatigue());
        System.out.println("Foot Pain: " + getFootPain());
        System.out.println("Frequent Urination: " + getFrequentUrination());
        System.out.println("Gas: " + getGas());
        System.out.println("Hair Loss: " + getHairLoss());
        System.out.println("Headaches: " + getHeadaches());
        System.out.println("Hearing Problems: " + getHearingProblems());
        System.out.println("Heart Burn: " + getHeartBurn());
        System.out.println("High Blood Pressure: " + getHighBloodPressure());
        System.out.println("Impotence: " + getImpotence());
        System.out.println("Joint Pain: " + getJointPain());
        System.out.println("Lower Back Pain: " + getLowerBackPain());
        System.out.println("Night Blindness: " + getNightBlindness());
        System.out.println("Night Urination: " + getNightUrination());
        System.out.println("Nose Bleeds: " + getNoseBleeds());
        System.out.println("Protruding Eyes: " + getProtrudingEyes());
        System.out.println("Red Face: " + getRedFace());
        System.out.println("Red, Thick Skin: " + getRedThickSkin());
        System.out.println("Sensitivity To Light: " + getSensitivityToLight());
        System.out.println("Snoring: " + getSnoring());
        System.out.println("Stomach Pain: " + getStomachPain());
        System.out.println("Swelling: " + getSwelling());
        System.out.println("Testicle Pain: " + getTesticlePain());
        System.out.println("Vision Problems: " + getVisionProblems());
        System.out.println("Vomiting: " + getVomiting());
        System.out.println("Warts: " + getWarts());
        System.out.println("Wheezing: " + getWheezing());
    }

}