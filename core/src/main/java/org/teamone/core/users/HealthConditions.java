package org.teamone.core.users;

import java.util.*;

/**
 * Created by daniel on 10/12/15.
 */
public class HealthConditions {

    private Map<String, Boolean> healthConditions;

    private static String alertCondition[] = {"anklePain", "bloodyStools", "discoloredUrine", "floatingStools", "footPain", "impotence", "protrudingEyes", "redFace", "stomachPain", "swelling", "testiclePain", "vomitting"};

    public String alertReason = null;
    public Date alertDateAndTime = null;

    public void set(String condition, boolean state) {
        this.healthConditions.put(condition, state);
    }

    public boolean isTrue(String condition) {
        return this.healthConditions.get(condition);
    }

    public Set<String> getKeys() {
        return healthConditions.keySet();
    }

    public String toString() {
        String str = "", temp = "";
        alertReason ="";//clear out alerts
        Iterator<Map.Entry<String, Boolean>> entries = healthConditions.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Boolean> entry = entries.next();
            for(int i =0; i< alertCondition.length;i++)
            {
                if (alertCondition[i] == entry.getKey() && entry.getValue()==true)
                {
                    alertReason=alertReason+entry.getKey()+":";
                    alertDateAndTime = new Date();//timeStamp

                }
            }
            temp=entry.getKey()+","+entry.getValue()+":";
            str = str.concat(temp);
        }
        System.out.println(str);
        return str;
    }

    public void toMapObj(String str){
        Map<String, Boolean> healthConditions = null;

        String[] parts = str.split(":");
        for(String temp2:parts)
        {
            String[] temp3 =  temp2.split(",");
            boolean abcd = Boolean.parseBoolean(temp3[1]);
            this.healthConditions.put(temp3[0], abcd);
        }

    }

    public boolean getAnklePain() {
        return this.healthConditions.get("anklePain");
    }

    public void setAnklePain(boolean anklePain) {
        this.healthConditions.put("anklePain", anklePain);
    }

    public boolean getAnxiety() {
        return this.healthConditions.get("anxiety");
    }

    public void setAnxiety(boolean anxiety) {
        this.healthConditions.put("anxiety", anxiety);
    }

    public boolean getBadBreath() {
        return this.healthConditions.get("badBreath");
    }

    public void setBadBreath(boolean badBreath) {
        this.healthConditions.put("badBreath", badBreath);
    }

    public boolean getBleedingGums() {
        return this.healthConditions.get("bleedingGums");
    }

    public void setBleedingGums(boolean bleedingGums) {
        this.healthConditions.put("bleedingGums", bleedingGums);
    }

    public boolean getBloodyStools() {
        return this.healthConditions.get("bloodyStools");
    }

    public void setBloodyStools(boolean bloodyStools) {
        this.healthConditions.put("bloodyStools", bloodyStools);
    }

    public boolean getConstipation() {
        return this.healthConditions.get("constipation");
    }

    public void setConstipation(boolean constipation) {
        this.healthConditions.put("constipation", constipation);
    }

    public boolean getDiarrhea() {
        return this.healthConditions.get("diarrhea");
    }

    public void setDiarrhea(boolean diarrhea) {
        this.healthConditions.put("diarrhea", diarrhea);
    }

    public boolean getDiscoloredUrine() {
        return this.healthConditions.get("discoloredUrine");
    }

    public void setDiscoloredUrine(boolean discoloredUrine) {
        this.healthConditions.put("discoloredUrine", discoloredUrine);
    }

    public boolean getDizziness() {
        return this.healthConditions.get("dizziness");
    }

    public void setDizziness(boolean dizziness) {
        this.healthConditions.put("dizziness", dizziness);
    }

    public boolean getDrySkin() {
        return this.healthConditions.get("drySkin");
    }

    public void setDrySkin(boolean drySkin) {
        this.healthConditions.put("drySkin", drySkin);
    }

    public boolean getEarDrainage() {
        return this.healthConditions.get("earDrainage");
    }

    public void setEarDrainage(boolean earDrainage) {
        this.healthConditions.put("earDrainage", earDrainage);
    }

    public boolean getExcessiveBurping() {
        return this.healthConditions.get("excessiveBurping");
    }

    public void setExcessiveBurping(boolean excessiveBurping) {
        this.healthConditions.put("excessiveBurping", excessiveBurping);
    }

    public boolean getExcessiveYawning() {
        return this.healthConditions.get("excessiveYawning");
    }

    public void setExcessiveYawning(boolean excessiveYawning) {
        this.healthConditions.put("excessiveYawning", excessiveYawning);
    }

    public boolean getFatigue() {
        return this.healthConditions.get("fatigue");
    }

    public void setFatigue(boolean fatigue) {
        this.healthConditions.put("fatigue", fatigue);
    }

    public boolean getFootPain() {
        return this.healthConditions.get("footPain");
    }

    public void setFootPain(boolean footPain) {
        this.healthConditions.put("footPain", footPain);
    }

    public boolean getFrequentUrination() {
        return this.healthConditions.get("frequentUrination");
    }

    public void setFrequentUrination(boolean frequentUrination) {
        this.healthConditions.put("frequentUrination", frequentUrination);
    }

    public boolean getGas() {
        return this.healthConditions.get("gas");
    }

    public void setGas(boolean gas) {
        this.healthConditions.put("gas", gas);
    }

    public boolean getHairLoss() {
        return this.healthConditions.get("hairLoss");
    }

    public void setHairLoss(boolean hairLoss) {
        this.healthConditions.put("hairLoss", hairLoss);
    }

    public boolean getHeadaches() {
        return this.healthConditions.get("headaches");
    }

    public void setHeadaches(boolean headaches) {
        this.healthConditions.put("headaches", headaches);
    }

    public boolean getHearingProblems() {
        return this.healthConditions.get("hearingProblems");
    }

    public void setHearingProblems(boolean hearingProblems) {
        this.healthConditions.put("hearingProblems", hearingProblems);
    }

    public boolean getHeartBurn() {
        return this.healthConditions.get("heartBurn");
    }

    public void setHeartBurn(boolean heartBurn) {
        this.healthConditions.put("heartBurn", heartBurn);
    }

    public boolean getHighBloodPressure() {
        return this.healthConditions.get("highBloodPressure");
    }

    public void setHighBloodPressure(boolean highBloodPressure) {
        this.healthConditions.put("highBloodPressure", highBloodPressure);
    }

    public boolean getImpotence() {
        return this.healthConditions.get("impotence");
    }

    public void setImpotence(boolean impotence) {
        this.healthConditions.put("impotence", impotence);
    }

    public boolean getJointPain() {
        return this.healthConditions.get("jointPain");
    }

    public void setJointPain(boolean jointPain) {
        this.healthConditions.put("jointPain", jointPain);
    }

    public boolean getLowerBackPain() {
        return this.healthConditions.get("lowerBackPain");
    }

    public void setLowerBackPain(boolean nightBlindness) {
        this.healthConditions.put("nightBlindness", nightBlindness);
    }

    public boolean getNightBlindness() {
        return this.healthConditions.get("nightBlindness");
    }

    public void setNightBlindness(boolean nightBlindness) {
        this.healthConditions.put("nightBlindness", nightBlindness);
    }

    public boolean getNightUrination() {
        return this.healthConditions.get("nightUrination");
    }

    public void setNightUrination(boolean nightUrination) {
        this.healthConditions.put("nightUrination", nightUrination);
    }

    public boolean getNoseBleeds() {
        return this.healthConditions.get("noseBleeds");
    }

    public void setNoseBleeds(boolean noseBleeds) {
        this.healthConditions.put("noseBleeds", noseBleeds);
    }

    public boolean getProtrudingEyes() {
        return this.healthConditions.get("protrudingEyes");
    }

    public void setProtrudingEyes(boolean protrudingEyes) {
        this.healthConditions.put("protrudingEyes", protrudingEyes);
    }

    public boolean getRedFace() {
        return this.healthConditions.get("redFace");
    }

    public void setRedFace(boolean redFace) {
        this.healthConditions.put("redFace", redFace);
    }

    public boolean getRedThickSkin() {
        return this.healthConditions.get("redThickSkin");
    }

    public void setRedThickSkin(boolean redThickSkin) {
        this.healthConditions.put("redThickSkin", redThickSkin);
    }

    public boolean getSensitivityToLight() {
        return this.healthConditions.get("sensitivityToLight");
    }

    public void setSensitivityToLight(boolean sensitivityToLight) {
        this.healthConditions.put("sensitivityToLight", sensitivityToLight);
    }

    public boolean getSnoring() {
        return this.healthConditions.get("snoring");
    }

    public void setSnoring(boolean snoring) {
        this.healthConditions.put("snoring", snoring);
    }

    public boolean getStomachPain() {
        return this.healthConditions.get("stomachPain");
    }

    public void setStomachPain(boolean stomachPain) {
        this.healthConditions.put("stomachPain", stomachPain);
    }

    public boolean getSwelling() {
        return this.healthConditions.get("swelling");
    }

    public void setSwelling(boolean swelling) {
        this.healthConditions.put("swelling", swelling);
    }

    public boolean getTesticlePain() {
        return this.healthConditions.get("testiclePain");
    }

    public void setTesticlePain(boolean testiclePain) {
        this.healthConditions.put("testiclePain", testiclePain);
    }

    public boolean getVisionProblems() {
        return this.healthConditions.get("visionProblems");
    }

    public void setVisionProblems(boolean visionProblems) {
        this.healthConditions.put("visionProblems", visionProblems);
    }

    public boolean getVomiting() {
        return this.healthConditions.get("vomiting");
    }

    public void setVomiting(boolean vomiting) {
        this.healthConditions.put("vomiting", vomiting);
    }

    public boolean getWarts() {
        return this.healthConditions.get("warts");
    }

    public void setWarts(boolean warts) {
        this.healthConditions.put("warts", warts);
    }

    public boolean getWheezing() {
        return this.healthConditions.get("wheezing");
    }

    public void setWheezing(boolean wheezing) {
        this.healthConditions.put("wheezing", wheezing);
    }

    HealthConditions() {
        healthConditions = new HashMap<String, Boolean>();
        healthConditions.put("anklePain", false);
        healthConditions.put("anxiety", false);
        healthConditions.put("badBreath", false);
        healthConditions.put("bleedingGums", false);
        healthConditions.put("bloodyStools", false);
        healthConditions.put("constipation", false);
        healthConditions.put("diarrhea", false);
        healthConditions.put("discoloredUrine", false);
        healthConditions.put("dizziness", false);
        healthConditions.put("drySkin", false);
        healthConditions.put("earDrainage", false);
        healthConditions.put("excessiveBurping", false);
        healthConditions.put("excessiveYawning", false);
        healthConditions.put("fatigue", false);
        healthConditions.put("footPain", false);
        healthConditions.put("frequentUrination", false);
        healthConditions.put("gas", false);
        healthConditions.put("hairLoss", false);
        healthConditions.put("headaches", false);
        healthConditions.put("hearingProblems", false);
        healthConditions.put("heartBurn", false);
        healthConditions.put("highBloodPressure", false);
        healthConditions.put("impotence", false);
        healthConditions.put("jointPain", false);
        healthConditions.put("lowerBackPain", false);
        healthConditions.put("nightBlindness", false);
        healthConditions.put("nightUrination", false);
        healthConditions.put("noseBleeds", false);
        healthConditions.put("protrudingEyes", false);
        healthConditions.put("redFace", false);
        healthConditions.put("redThickSkin", false);
        healthConditions.put("sensitivityToLight", false);
        healthConditions.put("snoring", false);
        healthConditions.put("stomachPain", false);
        healthConditions.put("swelling", false);
        healthConditions.put("testiclePain", false);
        healthConditions.put("visionProblems", false);
        healthConditions.put("vomiting", false);
        healthConditions.put("warts", false);
        healthConditions.put("wheezing", false);
    }
}
