package org.teamone.core.labs;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by daniel on 10/22/15.
 */
public class LabTestRequest {

    private int requestionID;
    private int patientID;

    private Map<String, Boolean> labTestRequest;
    private Map<String, String> labTestRequestNames;

    public Set<String> getKeys() {
        return labTestRequest.keySet();
    }
    public Map<String, Boolean> getLabTestRequest() { return this.labTestRequest; }
    public void set(String test, boolean state) {
        this.labTestRequest.put(test, state);
    }

    public boolean isRequested(String test) {
        return this.labTestRequest.get(test);
    }

    public LabTestRequest() {
        this(0, "");
        this.requestionID = 0; //TODO: make this a random number.
    }

    @Override
    public String toString() {
        String value = "";
        for (String key : labTestRequest.keySet()) {
            value += (key + ":" + labTestRequest.get(key) + ",");
        }
        return value;
    }

    public LabTestRequest(int requestionID, String data) {
        this.requestionID = requestionID;

        labTestRequest = new TreeMap<String, Boolean>();
        labTestRequestNames = new TreeMap<String, String>();

        this.labTestRequest.put("comprehensiveMetabolicPanel", false);
        this.labTestRequestNames.put("comprehensiveMetabolicPanel", "Comprehensive Metabolic Panel");
        
        this.labTestRequest.put("chemPanelBasic", false);
        this.labTestRequestNames.put("chemPanelBasic", "ChemPanel Basic");
        
        this.labTestRequest.put("electrolytePanel", false);
        this.labTestRequestNames.put("electrolytePanel", "Electrolyte Panel");
        
        this.labTestRequest.put("hepaticFunctionPanel", false);
        this.labTestRequestNames.put("hepaticFunctionPanel", "Hepatic Function Panel");
        
        this.labTestRequest.put("lipidPanel", false);
        this.labTestRequestNames.put("lipidPanel", "Lipid Panel");
        
        this.labTestRequest.put("liverProfile", false);
        this.labTestRequestNames.put("liverProfile", "Liver Profile");
        
        this.labTestRequest.put("amylase", false);
        this.labTestRequestNames.put("amylase", "Amylase");
        
        this.labTestRequest.put("hemogram", false);
        this.labTestRequestNames.put("hemogram", "Hemogram");
        
        this.labTestRequest.put("completeBloodCount", false);
        this.labTestRequestNames.put("completeBloodCount", "Complete Blood Count");
        
        this.labTestRequest.put("creatinine", false);
        this.labTestRequestNames.put("creatinine", "Creatinine");
        
        this.labTestRequest.put("cholesterol", false);
        this.labTestRequestNames.put("cholesterol", "Cholesterol");
        
        this.labTestRequest.put("follicleStimulatingHoromone", false);
        this.labTestRequestNames.put("follicleStimulatingHoromone", "Follicle Stimulating Horomone");
        
        this.labTestRequest.put("glucose", false);
        this.labTestRequestNames.put("glucose", "Glucose");
        
        this.labTestRequest.put("Hemoglobin", false);
        this.labTestRequestNames.put("Hemoglobin", "Hemoglobin");
        
        this.labTestRequest.put("hepatitusB", false);
        this.labTestRequestNames.put("hepatitusB", "Hepatitus B");
        
        this.labTestRequest.put("hepatitusC", false);
        this.labTestRequestNames.put("hepatitusC", "Hepatitus C");
        
        this.labTestRequest.put("hiv", false);
        this.labTestRequestNames.put("hiv", "HIV");
        
        this.labTestRequest.put("Iron", false);
        this.labTestRequestNames.put("Iron", "Iron");
        
        this.labTestRequest.put("lacticDehydrogenase", false);
        this.labTestRequestNames.put("lacticDehydrogenase", "Lactic Dehydrogenase");
        
        this.labTestRequest.put("lithium", false);
        this.labTestRequestNames.put("lithium", "Lithium");
        
        this.labTestRequest.put("potassium", false);
        this.labTestRequestNames.put("potassium", "Potassium");
        
        this.labTestRequest.put("pregnancy", false);
        this.labTestRequestNames.put("pregnancy", "Pregnancy");
        
        this.labTestRequest.put("rheumatoidFactor", false);
        this.labTestRequestNames.put("rheumatoidFactor", "Rheumatoid Factor");
        
        this.labTestRequest.put("sedimentationRate", false);
        this.labTestRequestNames.put("sedimentationRate", "Sedimentation Rate");
        
        this.labTestRequest.put("syphillis", false);
        this.labTestRequestNames.put("syphillis", "Syphillis");
        
        this.labTestRequest.put("thyroidStimulatingHormone", false);
        this.labTestRequestNames.put("thyroidStimulatingHormone", "Thyroid Stimulating Hormone");
        
        this.labTestRequest.put("triglycerides", false);
        this.labTestRequestNames.put("triglycerides", "Triglycerides");
        
        this.labTestRequest.put("uricAcid", false);
        this.labTestRequestNames.put("uricAcid", "Uric Acid");
        
        this.labTestRequest.put("urogram", false);
        this.labTestRequestNames.put("urogram", "Urogram");
        
        this.labTestRequest.put("vitaminB12", false);
        this.labTestRequestNames.put("vitaminB12", "Vitamin B12");
        
        this.labTestRequest.put("vitaminD", false);
        this.labTestRequestNames.put("vitaminD", "Vitamin D");
        
        this.labTestRequest.put("culture", false);
        this.labTestRequestNames.put("culture", "Culture");

        if(!data.equals("")) {
            String[] pairs = data.split(":");
            for (String x : pairs) {
                String[] pair = x.split(",");
                boolean abcd = Boolean.parseBoolean(pair[1]);
                this.labTestRequest.put(pair[0], abcd);
            }
        }
    }

    public void setLabTestRequest(Map<String, Boolean> labTestRequest) { this.labTestRequest = labTestRequest; }

    public int getRequestionID() { return requestionID; }

    public void setRequestionID(int requestionID) { this.requestionID = requestionID; }

    public int getPatientID() { return patientID; }

    public void setPatientID(int patientID) { this.patientID = patientID; }

    public Map<String, String> getLabTestRequestNames() { return labTestRequestNames; }

    public void setLabTestRequestNames(Map<String, String> labTestRequestNames) { this.labTestRequestNames = labTestRequestNames; }

    public void setComprehensiveMetabolicPanel(boolean value) { this.labTestRequest.put("comprehensiveMetabolicPanel", value); }
    public boolean getComprehensiveMetabolicPanel() { return this.labTestRequest.get("comprehensiveMetabolicPanel"); }

    public void setChemPanelBasic(boolean value) { this.labTestRequest.put("chemPanelBasic", value); }
    public boolean getChemPanelBasic() { return this.labTestRequest.get("chemPanelBasic"); }

    public void setElectrolytePanel(boolean value) { this.labTestRequest.put("electrolytePanel", value); }
    public boolean getElectrolytePanel() { return this.labTestRequest.get("electrolytePanel"); }

    public void setHepaticFunctionPanel(boolean value) { this.labTestRequest.put("hepaticFunctionPanel", value); }
    public boolean getHepaticFunctionPanel() { return this.labTestRequest.get("hepaticFunctionPanel"); }

    public void setLipidPanel(boolean value) { this.labTestRequest.put("lipidPanel", value); }
    public boolean getLipidPanel() { return this.labTestRequest.get("lipidPanel"); }

    public void setLiverProfile(boolean value) { this.labTestRequest.put("liverProfile", value); }
    public boolean getLiverProfile() { return this.labTestRequest.get("liverProfile"); }

    public void setAmylase(boolean value) { this.labTestRequest.put("amylase", value); }
    public boolean getAmylase() { return this.labTestRequest.get("amylase"); }

    public void setHemogram(boolean value) { this.labTestRequest.put("hemogram", value); }
    public boolean getHemogram() { return this.labTestRequest.get("hemogram"); }

    public void setCompleteBloodCount(boolean value) { this.labTestRequest.put("completeBloodCount", value); }
    public boolean getCompleteBloodCount() { return this.labTestRequest.get("completeBloodCount"); }

    public void setCreatinine(boolean value) { this.labTestRequest.put("creatinine", value); }
    public boolean getCreatinine() { return this.labTestRequest.get("creatinine"); }

    public void setcholesterol(boolean value) { this.labTestRequest.put("cholesterol", value); }
    public boolean getcholesterol() { return this.labTestRequest.get("cholesterol"); }

    public void setFollicleStimulatingHoromone(boolean value) { this.labTestRequest.put("follicleStimulatingHoromone", value); }
    public boolean getFollicleStimulatingHoromone() { return this.labTestRequest.get("follicleStimulatingHoromone"); }

    public void setGlucose(boolean value) { this.labTestRequest.put("glucose", value); }
    public boolean getGlucose() { return this.labTestRequest.get("glucose"); }

    public void setHemoglobin(boolean value) { this.labTestRequest.put("Hemoglobin", value); }
    public boolean getHemoglobin() { return this.labTestRequest.get("Hemoglobin"); }

    public void setHepatitusB(boolean value) { this.labTestRequest.put("hepatitusB", value); }
    public boolean getHepatitusB() { return this.labTestRequest.get("hepatitusB"); }

    public void setHepatitusC(boolean value) { this.labTestRequest.put("hepatitusC", value); }
    public boolean getHepatitusC() { return this.labTestRequest.get("hepatitusC"); }

    public void sethiv(boolean value) { this.labTestRequest.put("hiv", value); }
    public boolean gethiv() { return this.labTestRequest.get("hiv"); }

    public void setIron(boolean value) { this.labTestRequest.put("Iron", value); }
    public boolean getIron() { return this.labTestRequest.get("Iron"); }

    public void setLacticDehydrogenase(boolean value) { this.labTestRequest.put("lacticDehydrogenase", value); }
    public boolean getLacticDehydrogenase() { return this.labTestRequest.get("lacticDehydrogenase"); }

    public void setLithium(boolean value) { this.labTestRequest.put("lithium", value); }
    public boolean getLithium() { return this.labTestRequest.get("lithium"); }

    public void setPotassium(boolean value) { this.labTestRequest.put("potassium", value); }
    public boolean getPotassium() { return this.labTestRequest.get("potassium"); }

    public void setPregnancy(boolean value) { this.labTestRequest.put("pregnancy", value); }
    public boolean getPregnancy() { return this.labTestRequest.get("pregnancy"); }

    public void setRheumatoidFactor(boolean value) { this.labTestRequest.put("rheumatoidFactor", value); }
    public boolean getRheumatoidFactor() { return this.labTestRequest.get("rheumatoidFactor"); }

    public void setSedimentationRate(boolean value) { this.labTestRequest.put("sedimentationRate", value); }
    public boolean getSedimentationRate() { return this.labTestRequest.get("sedimentationRate"); }

    public void setSyphillis(boolean value) { this.labTestRequest.put("syphillis", value); }
    public boolean getSyphillis() { return this.labTestRequest.get("syphillis"); }

    public void setThyroidStimulatingHormone(boolean value) { this.labTestRequest.put("thyroidStimulatingHormone", value); }
    public boolean getThyroidStimulatingHormone() { return this.labTestRequest.get("thyroidStimulatingHormone"); }

    public void setTriglycerides(boolean value) { this.labTestRequest.put("triglycerides", value); }
    public boolean getTriglycerides() { return this.labTestRequest.get("triglycerides"); }

    public void setUricAcid(boolean value) { this.labTestRequest.put("uricAcid", value); }
    public boolean getUricAcid() { return this.labTestRequest.get("uricAcid"); }

    public void setUrogram(boolean value) { this.labTestRequest.put("urogram", value); }
    public boolean getUrogram() { return this.labTestRequest.get("urogram"); }

    public void setVitaminB12(boolean value) { this.labTestRequest.put("vitaminB12", value); }
    public boolean getVitaminB12() { return this.labTestRequest.get("vitaminB12"); }

    public void setVitaminD(boolean value) { this.labTestRequest.put("vitaminD", value); }
    public boolean getVitaminD() { return this.labTestRequest.get("vitaminD"); }

    public void setCulture(boolean value) { this.labTestRequest.put("culture", value); }
    public boolean getCulture() { return this.labTestRequest.get("culture"); }
}
