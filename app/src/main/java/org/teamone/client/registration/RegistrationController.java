package org.teamone.client.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.core.SQL.HspSQL;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.Patient;

import java.util.Map;

@Controller
public class RegistrationController {

    //Patient attempt = new Patient();

    //The web page that leads to this must direct to registration/, registration will return a 404 error
    @RequestMapping(value = "/registration/", method = RequestMethod.GET)
    public String createPatient(Map<String, Object> model) {

        Patient attempt = new Patient();
        model.put("userInput", attempt);

        return "/registration/hsp-registration";
    }

    @RequestMapping(value = "/registration/{page}",method = RequestMethod.POST)
    public String processPatientInfo(@ModelAttribute("userInput") Patient attempt,
                                     Map<String, Object> model,
                                     @PathVariable String page) {

        if(page.equalsIgnoreCase("page1")) {
            System.out.println("Creating a Patient");

            //attempt.displayPatientPersonalInformation();
            attempt=HspSQL.RegisterNewPatient(attempt);
            if(attempt!=null)
            {
                System.out.println("*********************Register successful************************");
            }
            else
                System.out.println("\n************************Register failed********************");

            return "/registration/hsp-healthConditions";
        }else if(page.equalsIgnoreCase("page2")){
            System.out.println("Loading Health Conditions");

            //attempt.displayHealthConditions();
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
            if(PatientSQL.setMedicalHistory(attempt))
            {
                System.out.println("Set successful");
            }
            else
                System.out.println("\nSet failed");

            //return "/registration/hsp-medicalHistory"; //Used for debugging to make sure that check boxes functioned properly
            return "/registration/hsp-registration"; //This should be hsp-patients page or hsp-homepage or what ever the page that this should exit to is called
        }
    }
}

/*
class RegistrationAttempt {

    //Start of the Patient's Personal Information (13 strings)__________________________________________________________
    private String firstName;
    private String lastName;        //2
    private String age;
    private String address;         //4
    private String city;
    private String state;           //6
    private String zipcode;
    private String homePhone;       //8         Make into a longint
    private String email;
    private String insurance;       //10
    private String ssn;                         //probably should be a long int
    private String gender;             //12



    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return this.firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return this.lastName; }

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




// Start of Medical History (48 boolean)________________________________________________________________________________
    private boolean aidsHIVPositive;
    private boolean alzheimerDisease;
    private boolean anaphylaxis;
    private boolean anemia;                         //4
    private boolean angina;
    private boolean arthritis;
    private boolean artificialHeartValve;
    private boolean artificialJoint;                //8
    private boolean asthma;
    private boolean bloodDisease;
    private boolean bloodTransfusion;
    private boolean breathingProblem;               //12
    private boolean bruiseEasily;
    private boolean cancer;
    private boolean chemotherapy;
    private boolean chestPains;                     //16
    private boolean coldSores;
    private boolean congenitalDisorder;
    private boolean convulsions;
    private boolean cortisonMedicine;               //20
    private boolean diabetes;
    private boolean drugAddiction;
    private boolean easilyWinded;
    private boolean emphysema;                      //24
    private boolean epilepsy;
    private boolean excessiveBleeding;
    private boolean excessiveThirst;
    private boolean faintingSpells;                 //28
    private boolean glaucoma;
    private boolean heyFever;
    private boolean heartAttack;
    private boolean heartMurmur;                    //32
    private boolean heartPacemaker;
    private boolean heartDisease;
    private boolean hemophilia;
    private boolean hepitisA;                       //36
    private boolean hepatitisBC;
    private boolean highBloodPressure2;
    private boolean highCholesterol;
    private boolean hives;                          //40
    private boolean hypoglicemia;
    private boolean irregularHearbeat;
    private boolean kidneyProblems;
    private boolean leukemia;                       //44
    private boolean liverDisease;
    private boolean lowBloodPressure;
    private boolean lungDisease;
    private boolean mitralValveProlapse;            //48



    public void setAidsHIVPositive(boolean aidsHIVPositive) { this.aidsHIVPositive = aidsHIVPositive; }
    public boolean getAidsHIVPositive() { return this.aidsHIVPositive; }

    public void setAlzheimerDisease(boolean alzheimerDisease) { this.alzheimerDisease = alzheimerDisease; }
    public boolean getAlzheimerDisease() { return this.alzheimerDisease; }

    public void setAnaphylaxis(boolean anaphylaxis) { this.anaphylaxis = anaphylaxis; }
    public boolean getAnaphylaxis() { return this.anaphylaxis; }

    public void setAnemia(boolean anemia) { this.anemia = anemia; }
    public boolean getAnemia() { return this.anemia; }

    public void setAngina(boolean angina) { this.angina = angina; }
    public boolean getAngina() { return this.angina; }

    public void setArthritis(boolean arthritis) { this.arthritis = arthritis; }
    public boolean getArthritis() { return this.arthritis; }

    public void setArtificialHeartValve(boolean artificialHeartValve) { this.artificialHeartValve = artificialHeartValve; }
    public boolean getArtificialHeartValve() { return this.artificialHeartValve; }

    public void setArtificialJoint(boolean artificialJoint) { this.artificialJoint = artificialJoint; }
    public boolean getArtificialJoint() { return this.artificialJoint; }

    public void setAsthma(boolean asthma) { this.asthma = asthma; }
    public boolean getAsthma() { return this.asthma; }

    public void setBloodDisease(boolean bloodDisease) { this.bloodDisease = bloodDisease; }
    public boolean getBloodDisease() { return this.bloodDisease; }

    public void setBloodTransfusion(boolean bloodTransfusion) { this.bloodTransfusion = bloodTransfusion; }
    public boolean getBloodTransfusion() { return this.bloodTransfusion; }

    public void setBreathingProblem(boolean breathingProblem) { this.breathingProblem = breathingProblem; }
    public boolean getBreathingProblem() { return this.breathingProblem; }

    public void setBruiseEasily(boolean bruiseEasily) { this.bruiseEasily = bruiseEasily; }
    public boolean getBruiseEasily() { return this.bruiseEasily; }

    public void setCancer(boolean cancer) { this.cancer = cancer; }
    public boolean getCancer() { return this.cancer; }

    public void setChemotherapy(boolean chemotherapy) { this.chemotherapy = chemotherapy; }
    public boolean getChemotherapy() { return this.chemotherapy; }

    public void setChestPains(boolean chestPains) { this.chestPains = chestPains; }
    public boolean getChestPains() { return this.chestPains; }

    public void setColdSores(boolean coldSores) { this.coldSores = coldSores; }
    public boolean getColdSores() { return this.coldSores; }

    public void setCongenitalDisorder(boolean congenitalDisorder) { this.congenitalDisorder = congenitalDisorder; }
    public boolean getCongenitalDisorder() { return this.congenitalDisorder; }

    public void setConvulsions(boolean convulsions) { this.convulsions = convulsions; }
    public boolean getConvulsions() { return this.convulsions; }

    public void setCortisonMedicine(boolean cortisonMedicine) { this.cortisonMedicine = cortisonMedicine; }
    public boolean getCortisonMedicine() { return this.cortisonMedicine; }

    public void setDiabetes(boolean diabetes) { this.diabetes = diabetes; }
    public boolean getDiabetes() { return this.diabetes; }

    public void setDrugAddiction(boolean drugAddiction) { this.drugAddiction = drugAddiction; }
    public boolean getDrugAddiction() { return this.drugAddiction; }

    public void setEasilyWinded(boolean easilyWinded) { this.easilyWinded = easilyWinded; }
    public boolean getEasilyWinded() { return this.easilyWinded; }

    public void setEmphysema(boolean emphysema) { this.emphysema = emphysema; }
    public boolean getEmphysema() { return this.emphysema; }

    public void setEpilepsy(boolean epilepsy) { this.epilepsy = epilepsy; }
    public boolean getEpilepsy() { return this.epilepsy; }

    public void setExcessiveBleeding(boolean excessiveBleeding) { this.excessiveBleeding = excessiveBleeding; }
    public boolean getExcessiveBleeding() { return this.excessiveBleeding; }

    public void setExcessiveThirst(boolean excessiveThirst) { this.excessiveThirst = excessiveThirst; }
    public boolean getExcessiveThirst() { return this.excessiveThirst; }

    public void setFaintingSpells(boolean faintingSpells) { this.faintingSpells = faintingSpells; }
    public boolean getFaintingSpells() { return this.faintingSpells; }

    public void setGlaucoma(boolean glaucoma) { this.glaucoma = glaucoma; }
    public boolean getGlaucoma() { return this.glaucoma; }

    public void setHeyFever(boolean heyFever) { this.heyFever = heyFever; }
    public boolean getHeyFever() { return this.heyFever; }

    public void setHeartAttack(boolean heartAttack) { this.heartAttack = heartAttack; }
    public boolean getHeartAttack() { return this.heartAttack; }

    public void setHeartMurmur(boolean heartMurmur) { this.heartMurmur = heartMurmur; }
    public boolean getHeartMurmur() { return this.heartMurmur; }

    public void setHeartPacemaker(boolean heartPacemaker) { this.heartPacemaker = heartPacemaker; }
    public boolean getHeartPacemaker() { return this.heartPacemaker; }

    public void setHeartDisease(boolean heartDisease) { this.heartDisease = heartDisease; }
    public boolean getHeartDisease() { return this.heartDisease; }

    public void setHemophilia(boolean hemophilia) { this.hemophilia = hemophilia; }
    public boolean getHemophilia() { return this.hemophilia; }

    public void setHepitisA(boolean hepitisA) { this.hepitisA = hepitisA; }
    public boolean getHepitisA() { return this.hepitisA; }

    public void setHepatitisBC(boolean hepatitisBC) { this.hepatitisBC = hepatitisBC; }
    public boolean getHepatitisBC() { return this.hepatitisBC; }

    public void setHighBloodPressure2(boolean highBloodPressure2) { this.highBloodPressure2 = highBloodPressure2; }
    public boolean getHighBloodPressure2() { return this.highBloodPressure2; }

    public void setHighCholesterol(boolean highCholesterol) { this.highCholesterol = highCholesterol; }
    public boolean getHighCholesterol() { return this.highCholesterol; }

    public void setHives(boolean hives) { this.hives = hives; }
    public boolean getHives() { return this.hives; }

    public void setHypoglicemia(boolean hypoglicemia) { this.hypoglicemia = hypoglicemia; }
    public boolean getHypoglicemia() { return this.hypoglicemia; }

    public void setIrregularHearbeat(boolean irregularHearbeat) { this.irregularHearbeat = irregularHearbeat; }
    public boolean getIrregularHearbeat() { return this.irregularHearbeat; }

    public void setKidneyProblems(boolean kidneyProblems) { this.kidneyProblems = kidneyProblems; }
    public boolean getKidneyProblems() { return this.kidneyProblems; }

    public void setLeukemia(boolean leukemia) { this.leukemia = leukemia; }
    public boolean getLeukemia() { return this.leukemia; }

    public void setLiverDisease(boolean liverDisease) { this.liverDisease = liverDisease; }
    public boolean getLiverDisease() { return this.liverDisease; }

    public void setLowBloodPressure(boolean lowBloodPressure) { this.lowBloodPressure = lowBloodPressure; }
    public boolean getLowBloodPressure() { return this.lowBloodPressure; }

    public void setLungDisease(boolean lungDisease) { this.lungDisease = lungDisease; }
    public boolean getLungDisease() { return this.lungDisease; }

    public void setMitralValveProlapse(boolean mitralValveProlapse) { this.mitralValveProlapse = mitralValveProlapse; }
    public boolean getMitralValveProlapse() { return this.mitralValveProlapse; }



    public void displayMedicalHistory(){
        System.out.println("AIDS/HIV Positive: "+getAidsHIVPositive());
        System.out.println("Alzheimer's Disease: "+getAlzheimerDisease());
        System.out.println("Anaphylaxis: "+getAnaphylaxis());
        System.out.println("Anemia: "+getAnemia());
        System.out.println("Angina: "+getAngina());
        System.out.println("Arthritis/Gout: "+getArthritis());
        System.out.println("Artificial Heart Valve: "+getArtificialHeartValve());
        System.out.println("Artificial Joint: "+getArtificialJoint());
        System.out.println("Asthma: "+getAsthma());
        System.out.println("Blood Disease: "+getBloodDisease());
        System.out.println("Blood Transfusion: "+getBloodTransfusion());
        System.out.println("Breathing Problem: "+getBreathingProblem());
        System.out.println("Bruise Easily: "+getBruiseEasily());
        System.out.println("Cancer: "+getCancer());
        System.out.println("Chemotherapy: "+getChemotherapy());
        System.out.println("Chest Pains: "+getChestPains());
        System.out.println("Cold Sores: "+getColdSores());
        System.out.println("Congenital Disorder: "+getCongenitalDisorder());
        System.out.println("Convulsions: "+getConvulsions());
        System.out.println("Cortisone Medicine: "+getCortisonMedicine());
        System.out.println("Drug Addiction: "+getDrugAddiction());
        System.out.println("Easily Winded: "+getEasilyWinded());
        System.out.println("Emphysema: "+getEmphysema());
        System.out.println("Epilepsy or Seizures: "+getEpilepsy());
        System.out.println("Excessive Bleeding: "+getExcessiveBleeding());
        System.out.println("Excessive Thirst: "+getExcessiveThirst());
        System.out.println("Fainting Spells: "+getFaintingSpells());
        System.out.println("Glaucoma: "+getGlaucoma());
        System.out.println("Hay Fever: "+getHeyFever());
        System.out.println("Heart Attack/Failure: "+getHeartAttack());
        System.out.println("Heart Murmur: "+getHeartMurmur());
        System.out.println("Heart Pacemaker: "+getHeartPacemaker());
        System.out.println("Heart Trouble/Disease: "+getHeartDisease());
        System.out.println("Hemophilia: "+getHemophilia());
        System.out.println("Hepatitis A: "+getHepitisA());
        System.out.println("Hepatitis B or C: "+getHepatitisBC());
        System.out.println("High Blood Pressure: "+getHighBloodPressure2());
        System.out.println("High Cholesterol: "+getHighCholesterol());
        System.out.println("Hives or Rash: "+getHives());
        System.out.println("Hypoglicemia: "+getHypoglicemia());
        System.out.println("Irregular Heartbeat: "+getIrregularHearbeat());
        System.out.println("Kidney Problems: "+getKidneyProblems());
        System.out.println("Leukemia: "+getLeukemia());
        System.out.println("Liver Disease: "+getLiverDisease());
        System.out.println("Low Blood Pressure: "+getLowBloodPressure());
        System.out.println("Lung Disease: "+getLungDisease());
        System.out.println("Mitral Valve Prolapse: "+getMitralValveProlapse());
    }

    RegistrationAttempt(){}
}
*/
