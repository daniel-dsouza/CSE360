package org.teamone.core.labs;

import org.teamone.core.users.Patient;

import java.text.ParsePosition;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by daniel on 10/11/15.
 */
public class LabTest {
    private String requestionID; // yay
    private Patient patient;     // two-way pointer
    private Date reportUpdated;

    private Map<String, String> labTestRequest; // stores values.
    private Map<String, String> labTestRequestNames; // only for frontend

    public LabTest() {
        this("0", "");
        this.requestionID = "0"; //TODO: make this a random number.
    }

    public LabTest(String requestionID, String data) {
        this.requestionID = requestionID;

        labTestRequest = new TreeMap<String, String>();
        labTestRequestNames = new TreeMap<String, String>();

        this.labTestRequest.put("comprehensiveMetabolicPanel", "false");
        this.labTestRequestNames.put("comprehensiveMetabolicPanel", "Comprehensive Metabolic Panel");

        this.labTestRequest.put("chemPanelBasic", "false");
        this.labTestRequestNames.put("chemPanelBasic", "ChemPanel Basic");

        this.labTestRequest.put("electrolytePanel", "false");
        this.labTestRequestNames.put("electrolytePanel", "Electrolyte Panel");

        this.labTestRequest.put("hepaticFunctionPanel", "false");
        this.labTestRequestNames.put("hepaticFunctionPanel", "Hepatic Function Panel");

        this.labTestRequest.put("lipidPanel", "false");
        this.labTestRequestNames.put("lipidPanel", "Lipid Panel");

        this.labTestRequest.put("liverProfile", "false");
        this.labTestRequestNames.put("liverProfile", "Liver Profile");

        this.labTestRequest.put("amylase", "false");
        this.labTestRequestNames.put("amylase", "Amylase");

        this.labTestRequest.put("hemogram", "false");
        this.labTestRequestNames.put("hemogram", "Hemogram");

        this.labTestRequest.put("completeBloodCount", "false");
        this.labTestRequestNames.put("completeBloodCount", "Complete Blood Count");

        this.labTestRequest.put("creatinine", "false");
        this.labTestRequestNames.put("creatinine", "Creatinine");

        this.labTestRequest.put("cholesterol", "false");
        this.labTestRequestNames.put("cholesterol", "Cholesterol");

        this.labTestRequest.put("follicleStimulatingHoromone", "false");
        this.labTestRequestNames.put("follicleStimulatingHoromone", "Follicle Stimulating Horomone");

        this.labTestRequest.put("glucose", "false");
        this.labTestRequestNames.put("glucose", "Glucose");

        this.labTestRequest.put("Hemoglobin", "false");
        this.labTestRequestNames.put("Hemoglobin", "Hemoglobin");

        this.labTestRequest.put("hepatitusB", "false");
        this.labTestRequestNames.put("hepatitusB", "Hepatitus B");

        this.labTestRequest.put("hepatitusC", "false");
        this.labTestRequestNames.put("hepatitusC", "Hepatitus C");

        this.labTestRequest.put("hiv", "false");
        this.labTestRequestNames.put("hiv", "HIV");

        this.labTestRequest.put("Iron", "false");
        this.labTestRequestNames.put("Iron", "Iron");

        this.labTestRequest.put("lacticDehydrogenase", "false");
        this.labTestRequestNames.put("lacticDehydrogenase", "Lactic Dehydrogenase");

        this.labTestRequest.put("lithium", "false");
        this.labTestRequestNames.put("lithium", "Lithium");

        this.labTestRequest.put("potassium", "false");
        this.labTestRequestNames.put("potassium", "Potassium");

        this.labTestRequest.put("pregnancy", "false");
        this.labTestRequestNames.put("pregnancy", "Pregnancy");

        this.labTestRequest.put("rheumatoidFactor", "false");
        this.labTestRequestNames.put("rheumatoidFactor", "Rheumatoid Factor");

        this.labTestRequest.put("sedimentationRate", "false");
        this.labTestRequestNames.put("sedimentationRate", "Sedimentation Rate");

        this.labTestRequest.put("syphillis", "false");
        this.labTestRequestNames.put("syphillis", "Syphillis");

        this.labTestRequest.put("thyroidStimulatingHormone", "false");
        this.labTestRequestNames.put("thyroidStimulatingHormone", "Thyroid Stimulating Hormone");

        this.labTestRequest.put("triglycerides", "false");
        this.labTestRequestNames.put("triglycerides", "Triglycerides");

        this.labTestRequest.put("uricAcid", "false");
        this.labTestRequestNames.put("uricAcid", "Uric Acid");

        this.labTestRequest.put("urogram", "false");
        this.labTestRequestNames.put("urogram", "Urogram");

        this.labTestRequest.put("vitaminB12", "false");
        this.labTestRequestNames.put("vitaminB12", "Vitamin B12");

        this.labTestRequest.put("vitaminD", "false");
        this.labTestRequestNames.put("vitaminD", "Vitamin D");

        this.labTestRequest.put("culture", "false");
        this.labTestRequestNames.put("culture", "Culture");

        if(!data.equals("")) {
            String[] pairs = data.split(":");
            for (String x : pairs) {
                String[] pair = x.split(",");
                String abcd = pair[1];
                this.labTestRequest.put(pair[0], abcd);
            }
        }
    }

    @Override
    public String toString() {
        String value = "";
        for (String key : labTestRequest.keySet()) {
            value += (key + ":" + labTestRequest.get(key) + ",");
        }
        return value;
    }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patientID) { this.patient = patientID; }

    public Set<String> getKeys() { return labTestRequest.keySet(); }
    public Map<String, String> getLabTestRequest() { return this.labTestRequest; }
    public void set(String test, String state) { this.labTestRequest.put(test, state); }

    public String getRequestionID() { return requestionID; }
    public void setRequestionID(String requestionID) { this.requestionID = requestionID; }

    public Map<String, String> getLabTestRequestNames() { return labTestRequestNames; }
    public void setLabTestRequestNames(Map<String, String> labTestRequestNames) { this.labTestRequestNames = labTestRequestNames; }

    public void setComprehensiveMetabolicPanel(String value) { this.labTestRequest.put("comprehensiveMetabolicPanel", value); }
    public String getComprehensiveMetabolicPanel() { return this.labTestRequest.get("comprehensiveMetabolicPanel"); }

    public void setChemPanelBasic(String value) { this.labTestRequest.put("chemPanelBasic", value); }
    public String getChemPanelBasic() { return this.labTestRequest.get("chemPanelBasic"); }

    public void setElectrolytePanel(String value) { this.labTestRequest.put("electrolytePanel", value); }
    public String getElectrolytePanel() { return this.labTestRequest.get("electrolytePanel"); }

    public void setHepaticFunctionPanel(String value) { this.labTestRequest.put("hepaticFunctionPanel", value); }
    public String getHepaticFunctionPanel() { return this.labTestRequest.get("hepaticFunctionPanel"); }

    public void setLipidPanel(String value) { this.labTestRequest.put("lipidPanel", value); }
    public String getLipidPanel() { return this.labTestRequest.get("lipidPanel"); }

    public void setLiverProfile(String value) { this.labTestRequest.put("liverProfile", value); }
    public String getLiverProfile() { return this.labTestRequest.get("liverProfile"); }

    public void setAmylase(String value) { this.labTestRequest.put("amylase", value); }
    public String getAmylase() { return this.labTestRequest.get("amylase"); }

    public void setHemogram(String value) { this.labTestRequest.put("hemogram", value); }
    public String getHemogram() { return this.labTestRequest.get("hemogram"); }

    public void setCompleteBloodCount(String value) { this.labTestRequest.put("completeBloodCount", value); }
    public String getCompleteBloodCount() { return this.labTestRequest.get("completeBloodCount"); }

    public void setCreatinine(String value) { this.labTestRequest.put("creatinine", value); }
    public String getCreatinine() { return this.labTestRequest.get("creatinine"); }

    public void setcholesterol(String value) { this.labTestRequest.put("cholesterol", value); }
    public String getcholesterol() { return this.labTestRequest.get("cholesterol"); }

    public void setFollicleStimulatingHoromone(String value) { this.labTestRequest.put("follicleStimulatingHoromone", value); }
    public String getFollicleStimulatingHoromone() { return this.labTestRequest.get("follicleStimulatingHoromone"); }

    public void setGlucose(String value) { this.labTestRequest.put("glucose", value); }
    public String getGlucose() { return this.labTestRequest.get("glucose"); }

    public void setHemoglobin(String value) { this.labTestRequest.put("Hemoglobin", value); }
    public String getHemoglobin() { return this.labTestRequest.get("Hemoglobin"); }

    public void setHepatitusB(String value) { this.labTestRequest.put("hepatitusB", value); }
    public String getHepatitusB() { return this.labTestRequest.get("hepatitusB"); }

    public void setHepatitusC(String value) { this.labTestRequest.put("hepatitusC", value); }
    public String getHepatitusC() { return this.labTestRequest.get("hepatitusC"); }

    public void sethiv(String value) { this.labTestRequest.put("hiv", value); }
    public String gethiv() { return this.labTestRequest.get("hiv"); }

    public void setIron(String value) { this.labTestRequest.put("Iron", value); }
    public String getIron() { return this.labTestRequest.get("Iron"); }

    public void setLacticDehydrogenase(String value) { this.labTestRequest.put("lacticDehydrogenase", value); }
    public String getLacticDehydrogenase() { return this.labTestRequest.get("lacticDehydrogenase"); }

    public void setLithium(String value) { this.labTestRequest.put("lithium", value); }
    public String getLithium() { return this.labTestRequest.get("lithium"); }

    public void setPotassium(String value) { this.labTestRequest.put("potassium", value); }
    public String getPotassium() { return this.labTestRequest.get("potassium"); }

    public void setPregnancy(String value) { this.labTestRequest.put("pregnancy", value); }
    public String getPregnancy() { return this.labTestRequest.get("pregnancy"); }

    public void setRheumatoidFactor(String value) { this.labTestRequest.put("rheumatoidFactor", value); }
    public String getRheumatoidFactor() { return this.labTestRequest.get("rheumatoidFactor"); }

    public void setSedimentationRate(String value) { this.labTestRequest.put("sedimentationRate", value); }
    public String getSedimentationRate() { return this.labTestRequest.get("sedimentationRate"); }

    public void setSyphillis(String value) { this.labTestRequest.put("syphillis", value); }
    public String getSyphillis() { return this.labTestRequest.get("syphillis"); }

    public void setThyroidStimulatingHormone(String value) { this.labTestRequest.put("thyroidStimulatingHormone", value); }
    public String getThyroidStimulatingHormone() { return this.labTestRequest.get("thyroidStimulatingHormone"); }

    public void setTriglycerides(String value) { this.labTestRequest.put("triglycerides", value); }
    public String getTriglycerides() { return this.labTestRequest.get("triglycerides"); }

    public void setUricAcid(String value) { this.labTestRequest.put("uricAcid", value); }
    public String getUricAcid() { return this.labTestRequest.get("uricAcid"); }

    public void setUrogram(String value) { this.labTestRequest.put("urogram", value); }
    public String getUrogram() { return this.labTestRequest.get("urogram"); }

    public void setVitaminB12(String value) { this.labTestRequest.put("vitaminB12", value); }
    public String getVitaminB12() { return this.labTestRequest.get("vitaminB12"); }

    public void setVitaminD(String value) { this.labTestRequest.put("vitaminD", value); }
    public String getVitaminD() { return this.labTestRequest.get("vitaminD"); }

    public void setCulture(String value) { this.labTestRequest.put("culture", value); }
    public String getCulture() { return this.labTestRequest.get("culture"); }

    public void setDate(String value) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reportUpdated = sdf.parse(value, new ParsePosition(0));
    }

    public String getDate() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(reportUpdated);
    }
}
