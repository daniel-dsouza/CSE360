package org.teamone.core.labs;

import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;

import java.text.ParsePosition;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by daniel on 10/11/15.
 */
public class LabReport {
    private int requestionID;
    private Patient patient;

    private Date updateDate;
    private Person person;

    private Map<String, String> labTest;
    private Map<String, String> labTestNames;

    public LabReport() {
        this(0, "");
        this.requestionID = 0; //TODO: make this a random number.
    }

    public LabReport(int requestionID, String data) {
        this.requestionID = requestionID;
        patient = new Patient();
        person = new Person();
        updateDate = new Date();

        labTest = new TreeMap<String, String>();
        labTestNames = new TreeMap<String, String>();

        this.labTest.put("comprehensiveMetabolicPanel", "false");
        this.labTestNames.put("comprehensiveMetabolicPanel", "Comprehensive Metabolic Panel");

        this.labTest.put("chemPanelBasic", "false");
        this.labTestNames.put("chemPanelBasic", "ChemPanel Basic");

        this.labTest.put("electrolytePanel", "false");
        this.labTestNames.put("electrolytePanel", "Electrolyte Panel");

        this.labTest.put("hepaticFunctionPanel", "false");
        this.labTestNames.put("hepaticFunctionPanel", "Hepatic Function Panel");

        this.labTest.put("lipidPanel", "false");
        this.labTestNames.put("lipidPanel", "Lipid Panel");

        this.labTest.put("liverProfile", "false");
        this.labTestNames.put("liverProfile", "Liver Profile");

        this.labTest.put("amylase", "false");
        this.labTestNames.put("amylase", "Amylase");

        this.labTest.put("hemogram", "false");
        this.labTestNames.put("hemogram", "Hemogram");

        this.labTest.put("completeBloodCount", "false");
        this.labTestNames.put("completeBloodCount", "Complete Blood Count");

        this.labTest.put("creatinine", "false");
        this.labTestNames.put("creatinine", "Creatinine");

        this.labTest.put("cholesterol", "false");
        this.labTestNames.put("cholesterol", "Cholesterol");

        this.labTest.put("follicleStimulatingHoromone", "false");
        this.labTestNames.put("follicleStimulatingHoromone", "Follicle Stimulating Horomone");

        this.labTest.put("glucose", "false");
        this.labTestNames.put("glucose", "Glucose");

        this.labTest.put("Hemoglobin", "false");
        this.labTestNames.put("Hemoglobin", "Hemoglobin");

        this.labTest.put("hepatitusB", "false");
        this.labTestNames.put("hepatitusB", "Hepatitus B");

        this.labTest.put("hepatitusC", "false");
        this.labTestNames.put("hepatitusC", "Hepatitus C");

        this.labTest.put("hiv", "false");
        this.labTestNames.put("hiv", "HIV");

        this.labTest.put("Iron", "false");
        this.labTestNames.put("Iron", "Iron");

        this.labTest.put("lacticDehydrogenase", "false");
        this.labTestNames.put("lacticDehydrogenase", "Lactic Dehydrogenase");

        this.labTest.put("lithium", "false");
        this.labTestNames.put("lithium", "Lithium");

        this.labTest.put("potassium", "false");
        this.labTestNames.put("potassium", "Potassium");

        this.labTest.put("pregnancy", "false");
        this.labTestNames.put("pregnancy", "Pregnancy");

        this.labTest.put("rheumatoidFactor", "false");
        this.labTestNames.put("rheumatoidFactor", "Rheumatoid Factor");

        this.labTest.put("sedimentationRate", "false");
        this.labTestNames.put("sedimentationRate", "Sedimentation Rate");

        this.labTest.put("syphillis", "false");
        this.labTestNames.put("syphillis", "Syphillis");

        this.labTest.put("thyroidStimulatingHormone", "false");
        this.labTestNames.put("thyroidStimulatingHormone", "Thyroid Stimulating Hormone");

        this.labTest.put("triglycerides", "false");
        this.labTestNames.put("triglycerides", "Triglycerides");

        this.labTest.put("uricAcid", "false");
        this.labTestNames.put("uricAcid", "Uric Acid");

        this.labTest.put("urogram", "false");
        this.labTestNames.put("urogram", "Urogram");

        this.labTest.put("vitaminB12", "false");
        this.labTestNames.put("vitaminB12", "Vitamin B12");

        this.labTest.put("vitaminD", "false");
        this.labTestNames.put("vitaminD", "Vitamin D");

        this.labTest.put("culture", "false");
        this.labTestNames.put("culture", "Culture");

        if(!data.equals("")) {
            String[] pairs = data.split(":");
            for (String x : pairs) {
                String[] pair = x.split(",");
                String abcd = pair[1];
                this.labTest.put(pair[0], abcd);
            }
        }
    }

    @Override
    public String toString() {
        String value = "";
        for (String key : labTest.keySet()) {
            value += (key + "," + labTest.get(key) + ":");
        }
        //System.out.println(value);
        return value;

    }
    public void toMapObj(String str){

        String[] parts = str.split(":");
        for(String temp2:parts)
        {
            String[] temp3 =  temp2.split(",");
            this.labTest.put(temp3[0], temp3[1]);
        }

    }



    public void setlabTest(Map<String, String> labTest) { this.labTest = labTest; }
    public Map<String, String> getlabTest() { return this.labTest;}

    public Map<String, String> getlabTestNames() { return labTestNames; }
    public void setlabTestNames(Map<String, String> labTestNames) { this.labTestNames = labTestNames; }

    public void setRequestionID(int requestionID) { this.requestionID = requestionID; }
    public int getRequestionID() { return requestionID; }

    public void setPatient(Patient patientID) { this.patient = patientID; }
    public Patient getPatient() { return patient; }

    public void setComprehensiveMetabolicPanel(String value) { this.labTest.put("comprehensiveMetabolicPanel", value); }
    public String getComprehensiveMetabolicPanel() { return this.labTest.get("comprehensiveMetabolicPanel"); }

    public void setChemPanelBasic(String value) { this.labTest.put("chemPanelBasic", value); }
    public String getChemPanelBasic() { return this.labTest.get("chemPanelBasic"); }

    public void setElectrolytePanel(String value) { this.labTest.put("electrolytePanel", value); }
    public String getElectrolytePanel() { return this.labTest.get("electrolytePanel"); }

    public void setHepaticFunctionPanel(String value) { this.labTest.put("hepaticFunctionPanel", value); }
    public String getHepaticFunctionPanel() { return this.labTest.get("hepaticFunctionPanel"); }

    public void setLipidPanel(String value) { this.labTest.put("lipidPanel", value); }
    public String getLipidPanel() { return this.labTest.get("lipidPanel"); }

    public void setLiverProfile(String value) { this.labTest.put("liverProfile", value); }
    public String getLiverProfile() { return this.labTest.get("liverProfile"); }

    public void setAmylase(String value) { this.labTest.put("amylase", value); }
    public String getAmylase() { return this.labTest.get("amylase"); }

    public void setHemogram(String value) { this.labTest.put("hemogram", value); }
    public String getHemogram() { return this.labTest.get("hemogram"); }

    public void setCompleteBloodCount(String value) { this.labTest.put("completeBloodCount", value); }
    public String getCompleteBloodCount() { return this.labTest.get("completeBloodCount"); }

    public void setCreatinine(String value) { this.labTest.put("creatinine", value); }
    public String getCreatinine() { return this.labTest.get("creatinine"); }

    public void setcholesterol(String value) { this.labTest.put("cholesterol", value); }
    public String getcholesterol() { return this.labTest.get("cholesterol"); }

    public void setFollicleStimulatingHoromone(String value) { this.labTest.put("follicleStimulatingHoromone", value); }
    public String getFollicleStimulatingHoromone() { return this.labTest.get("follicleStimulatingHoromone"); }

    public void setGlucose(String value) { this.labTest.put("glucose", value); }
    public String getGlucose() { return this.labTest.get("glucose"); }

    public void setHemoglobin(String value) { this.labTest.put("Hemoglobin", value); }
    public String getHemoglobin() { return this.labTest.get("Hemoglobin"); }

    public void setHepatitusB(String value) { this.labTest.put("hepatitusB", value); }
    public String getHepatitusB() { return this.labTest.get("hepatitusB"); }

    public void setHepatitusC(String value) { this.labTest.put("hepatitusC", value); }
    public String getHepatitusC() { return this.labTest.get("hepatitusC"); }

    public void sethiv(String value) { this.labTest.put("hiv", value); }
    public String gethiv() { return this.labTest.get("hiv"); }

    public void setIron(String value) { this.labTest.put("Iron", value); }
    public String getIron() { return this.labTest.get("Iron"); }

    public void setLacticDehydrogenase(String value) { this.labTest.put("lacticDehydrogenase", value); }
    public String getLacticDehydrogenase() { return this.labTest.get("lacticDehydrogenase"); }

    public void setLithium(String value) { this.labTest.put("lithium", value); }
    public String getLithium() { return this.labTest.get("lithium"); }

    public void setPotassium(String value) { this.labTest.put("potassium", value); }
    public String getPotassium() { return this.labTest.get("potassium"); }

    public void setPregnancy(String value) { this.labTest.put("pregnancy", value); }
    public String getPregnancy() { return this.labTest.get("pregnancy"); }

    public void setRheumatoidFactor(String value) { this.labTest.put("rheumatoidFactor", value); }
    public String getRheumatoidFactor() { return this.labTest.get("rheumatoidFactor"); }

    public void setSedimentationRate(String value) { this.labTest.put("sedimentationRate", value); }
    public String getSedimentationRate() { return this.labTest.get("sedimentationRate"); }

    public void setSyphillis(String value) { this.labTest.put("syphillis", value); }
    public String getSyphillis() { return this.labTest.get("syphillis"); }

    public void setThyroidStimulatingHormone(String value) { this.labTest.put("thyroidStimulatingHormone", value); }
    public String getThyroidStimulatingHormone() { return this.labTest.get("thyroidStimulatingHormone"); }

    public void setTriglycerides(String value) { this.labTest.put("triglycerides", value); }
    public String getTriglycerides() { return this.labTest.get("triglycerides"); }

    public void setUricAcid(String value) { this.labTest.put("uricAcid", value); }
    public String getUricAcid() { return this.labTest.get("uricAcid"); }

    public void setUrogram(String value) { this.labTest.put("urogram", value); }
    public String getUrogram() { return this.labTest.get("urogram"); }

    public void setVitaminB12(String value) { this.labTest.put("vitaminB12", value); }
    public String getVitaminB12() { return this.labTest.get("vitaminB12"); }

    public void setVitaminD(String value) { this.labTest.put("vitaminD", value); }
    public String getVitaminD() { return this.labTest.get("vitaminD"); }

    public void setCulture(String value) { this.labTest.put("culture", value); }
    public String getCulture() { return this.labTest.get("culture"); }

    public void setDate(String value) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        updateDate = sdf.parse(value, new ParsePosition(0));
    }
    public String getDate() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        return sdf.format(updateDate);
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}