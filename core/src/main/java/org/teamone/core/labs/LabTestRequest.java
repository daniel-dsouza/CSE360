package org.teamone.core.labs;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by daniel on 10/22/15.
 */
public class LabTestRequest {

    private int requestionID;
    private Map<String, Boolean> labTestRequest;

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

        this.labTestRequest.put("Comprehensive Metabolic Panel", false);
        this.labTestRequest.put("ChemPanel Basic", false);
        this.labTestRequest.put("Electrolyte Panel", false);
        this.labTestRequest.put("Hepatic Function Panel", false);
        this.labTestRequest.put("Lipid Panel", false);
        this.labTestRequest.put("Liver Profile", false);
        this.labTestRequest.put("Amylase", false);
        this.labTestRequest.put("Hemogram", false);
        this.labTestRequest.put("Complete Blood Count", false);
        this.labTestRequest.put("Creatinine", false);
        this.labTestRequest.put("Cholesterol", false);
        this.labTestRequest.put("Follicle Stimulating Horomone", false);
        this.labTestRequest.put("Glucose", false);
        this.labTestRequest.put("Hemoglobin", false);
        this.labTestRequest.put("Hepatitus B", false);
        this.labTestRequest.put("Hepatitus C", false);
        this.labTestRequest.put("HIV", false);
        this.labTestRequest.put("Iron", false);
        this.labTestRequest.put("Lactic Dehydrogenase", false);
        this.labTestRequest.put("Lithium", false);
        this.labTestRequest.put("Potassium", false);
        this.labTestRequest.put("Pregnancy", false);
        this.labTestRequest.put("Rheumatoid Factor", false);
        this.labTestRequest.put("Sedimentation Rate", false);
        this.labTestRequest.put("Syphillis", false);
        this.labTestRequest.put("Thyroid Stimulating Hormone", false);
        this.labTestRequest.put("Triglycerides", false);
        this.labTestRequest.put("Uric Acid", false);
        this.labTestRequest.put("Urogram", false);
        this.labTestRequest.put("Vitamin B12", false);
        this.labTestRequest.put("Vitamin D", false);
        this.labTestRequest.put("Culture", false);

        Map<String, Boolean> medicalHistory = null;

        if(!data.equals("")) {
            String[] pairs = data.split(":");
            for (String x : pairs) {
                String[] pair = x.split(",");
                boolean abcd = Boolean.parseBoolean(pair[1]);
                this.labTestRequest.put(pair[0], abcd);
            }
        }
    }

    public void setComprehensiveMetabolicPanel(boolean value) { this.labTestRequest.put("Comprehensive Metabolic Panel", value); }
    public boolean getComprehensiveMetabolicPanel() { return this.labTestRequest.get("Comprehensive Metabolic Panel"); }

    public void setChemPanelBasic(boolean value) { this.labTestRequest.put("ChemPanel Basic", value); }
    public boolean getChemPanelBasic() { return this.labTestRequest.get("ChemPanel Basic"); }

    public void setElectrolytePanel(boolean value) { this.labTestRequest.put("Electrolyte Panel", value); }
    public boolean getElectrolytePanel() { return this.labTestRequest.get("Electrolyte Panel"); }

    public void setHepaticFunctionPanel(boolean value) { this.labTestRequest.put("Hepatic Function Panel", value); }
    public boolean getHepaticFunctionPanel() { return this.labTestRequest.get("Hepatic Function Panel"); }

    public void setLipidPanel(boolean value) { this.labTestRequest.put("Lipid Panel", value); }
    public boolean getLipidPanel() { return this.labTestRequest.get("Lipid Panel"); }

    public void setLiverProfile(boolean value) { this.labTestRequest.put("Liver Profile", value); }
    public boolean getLiverProfile() { return this.labTestRequest.get("Liver Profile"); }

    public void setAmylase(boolean value) { this.labTestRequest.put("Amylase", value); }
    public boolean getAmylase() { return this.labTestRequest.get("Amylase"); }

    public void setHemogram(boolean value) { this.labTestRequest.put("Hemogram", value); }
    public boolean getHemogram() { return this.labTestRequest.get("Hemogram"); }

    public void setCompleteBloodCount(boolean value) { this.labTestRequest.put("Complete Blood Count", value); }
    public boolean getCompleteBloodCount() { return this.labTestRequest.get("Complete Blood Count"); }

    public void setCreatinine(boolean value) { this.labTestRequest.put("Creatinine", value); }
    public boolean getCreatinine() { return this.labTestRequest.get("Creatinine"); }

    public void setFollicleStimulatingHoromone(boolean value) { this.labTestRequest.put("Follicle Stimulating Horomone", value); }
    public boolean getFollicleStimulatingHoromone() { return this.labTestRequest.get("Follicle Stimulating Horomone"); }

    public void setGlucose(boolean value) { this.labTestRequest.put("Glucose", value); }
    public boolean getGlucose() { return this.labTestRequest.get("Glucose"); }

    public void setHemoglobin(boolean value) { this.labTestRequest.put("Hemoglobin", value); }
    public boolean getHemoglobin() { return this.labTestRequest.get("Hemoglobin"); }

    public void setHepatitusB(boolean value) { this.labTestRequest.put("Hepatitus B", value); }
    public boolean getHepatitusB() { return this.labTestRequest.get("Hepatitus B"); }

    public void setHepatitusC(boolean value) { this.labTestRequest.put("Hepatitus C", value); }
    public boolean getHepatitusC() { return this.labTestRequest.get("Hepatitus C"); }

    public void setHIV(boolean value) { this.labTestRequest.put("HIV", value); }
    public boolean getHIV() { return this.labTestRequest.get("HIV"); }

    public void setIron(boolean value) { this.labTestRequest.put("Iron", value); }
    public boolean getIron() { return this.labTestRequest.get("Iron"); }

    public void setLacticDehydrogenase(boolean value) { this.labTestRequest.put("LacticDehydrogenase", value); }
    public boolean getLacticDehydrogenase() { return this.labTestRequest.get("LacticDehydrogenase"); }

    public void setLithium(boolean value) { this.labTestRequest.put("Lithium", value); }
    public boolean getLithium() { return this.labTestRequest.get("Lithium"); }

    public void setPotassium(boolean value) { this.labTestRequest.put("Potassium", value); }
    public boolean getPotassium() { return this.labTestRequest.get("Potassium"); }

    public void setPregnancy(boolean value) { this.labTestRequest.put("Pregnancy", value); }
    public boolean getPregnancy() { return this.labTestRequest.get("Pregnancy"); }

    public void setRheumatoidFactor(boolean value) { this.labTestRequest.put("Rheumatoid Factor", value); }
    public boolean getRheumatoidFactor() { return this.labTestRequest.get("Rheumatoid Factor"); }

    public void setSedimentationRate(boolean value) { this.labTestRequest.put("Sedimentation Rate", value); }
    public boolean getSedimentationRate() { return this.labTestRequest.get("Sedimentation Rate"); }

    public void setSyphillis(boolean value) { this.labTestRequest.put("Syphillis", value); }
    public boolean getSyphillis() { return this.labTestRequest.get("Syphillis"); }

    public void setThyroidStimulatingHormone(boolean value) { this.labTestRequest.put("Thyroid Stimulating Hormone", value); }
    public boolean getThyroidStimulatingHormone() { return this.labTestRequest.get("Thyroid Stimulating Hormone"); }

    public void setTriglycerides(boolean value) { this.labTestRequest.put("Triglycerides", value); }
    public boolean getTriglycerides() { return this.labTestRequest.get("Triglycerides"); }

    public void setUricAcid(boolean value) { this.labTestRequest.put("Uric Acid", value); }
    public boolean getUricAcid() { return this.labTestRequest.get("Uric Acid"); }

    public void setUrogram(boolean value) { this.labTestRequest.put("Urogram", value); }
    public boolean getUrogram() { return this.labTestRequest.get("Urogram"); }

    public void setVitaminB12(boolean value) { this.labTestRequest.put("Vitamin B12", value); }
    public boolean getVitaminB12() { return this.labTestRequest.get("Vitamin B12"); }

    public void setVitaminD(boolean value) { this.labTestRequest.put("Vitamin D", value); }
    public boolean getVitaminD() { return this.labTestRequest.get("Vitamin D"); }

    public void setCulture(boolean value) { this.labTestRequest.put("Culture", value); }
    public boolean getCulture() { return this.labTestRequest.get("Culture"); }
}
