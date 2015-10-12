package org.teamone.core.users;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by daniel on 10/12/15.
 */
public class HealthConditions {

    private Map<String, Boolean> healthConditions;

    public void set(String condition, boolean state) {
        this.healthConditions.put(condition, state);
    }

    public boolean isTrue(String condition) {
        return this.healthConditions.get(condition);
    }

    public Set<String> getKeys() {
        return healthConditions.keySet();
    }

    public boolean isAnklePain() {
        return this.healthConditions.get("anklePain");
    }

    public void setAnklePain(boolean anklePain) {
        this.healthConditions.put("anklePain", anklePain);
    }

    public boolean isAnxiety() {
        return this.healthConditions.get("anxiety");
    }

    public void setAnxiety(boolean anxiety) {
        this.healthConditions.put("anxiety", anxiety);
    }

    public boolean isBadBreath() {
        return this.healthConditions.get("badBreath");
    }

    public void setBadBreath(boolean badBreath) {
        this.healthConditions.put("badBreath", badBreath);
    }

    public boolean isBleedingGums() {
        return this.healthConditions.get("bleedingGums");
    }

    public void setBleedingGums(boolean bleedingGums) {
        this.healthConditions.put("bleedingGums", bleedingGums);
    }

    public boolean isBloodyStools() {
        return this.healthConditions.get("bloodyStools");
    }

    public void setBloodyStools(boolean bloodyStools) {
        this.healthConditions.put("bloodyStools", bloodyStools);
    }

    public boolean isConstipation() {
        return this.healthConditions.get("constipation");
    }

    public void setConstipation(boolean constipation) {
        this.healthConditions.put("constipation", constipation);
    }

    public boolean isDiarrhea() {
        return this.healthConditions.get("diarrhea");
    }

    public void setDiarrhea(boolean diarrhea) {
        this.healthConditions.put("diarrhea", diarrhea);
    }

    public boolean isDiscoloredUrine() {
        return this.healthConditions.get("discoloredUrine");
    }

    public void setDiscoloredUrine(boolean discoloredUrine) {
        this.healthConditions.put("discoloredUrine", discoloredUrine);
    }

    public boolean isDizziness() {
        return this.healthConditions.get("dizziness");
    }

    public void setDizziness(boolean dizziness) {
        this.healthConditions.put("dizziness", dizziness);
    }

    public boolean isDrySkin() {
        return this.healthConditions.get("drySkin");
    }

    public void setDrySkin(boolean drySkin) {
        this.healthConditions.put("drySkin", drySkin);
    }

    public boolean isEarDrainage() {
        return this.healthConditions.get("earDrainage");
    }

    public void setEarDrainage(boolean earDrainage) {
        this.healthConditions.put("earDrainage", earDrainage);
    }

    public boolean isExcessiveBurping() {
        return this.healthConditions.get("excessiveBurping");
    }

    public void setExcessiveBurping(boolean excessiveBurping) {
        this.healthConditions.put("excessiveBurping", excessiveBurping);
    }

    public boolean isExcessiveYawning() {
        return this.healthConditions.get("excessiveYawning");
    }

    public void setExcessiveYawning(boolean excessiveYawning) {
        this.healthConditions.put("excessiveYawning", excessiveYawning);
    }

    public boolean isFatigue() {
        return this.healthConditions.get("fatigue");
    }

    public void setFatigue(boolean fatigue) {
        this.healthConditions.put("fatigue", fatigue);
    }

    public boolean isFootPain() {
        return this.healthConditions.get("footPain");
    }

    public void setFootPain(boolean footPain) {
        this.healthConditions.put("footPain", footPain);
    }

    public boolean isFrequentUrination() {
        return this.healthConditions.get("frequentUrination");
    }

    public void setFrequentUrination(boolean frequentUrination) {
        this.healthConditions.put("frequentUrination", frequentUrination);
    }

    public boolean isGas() {
        return this.healthConditions.get("gas");
    }

    public void setGas(boolean gas) {
        this.healthConditions.put("gas", gas);
    }

    public boolean isHairLoss() {
        return this.healthConditions.get("hairLoss");
    }

    public void setHairLoss(boolean hairLoss) {
        this.healthConditions.put("hairLoss", hairLoss);
    }

    public boolean isHeadaches() {
        return this.healthConditions.get("headaches");
    }

    public void setHeadaches(boolean headaches) {
        this.healthConditions.put("headaches", headaches);
    }

    public boolean isHearingProblems() {
        return this.healthConditions.get("hearingProblems");
    }

    public void setHearingProblems(boolean hearingProblems) {
        this.healthConditions.put("hearingProblems", hearingProblems);
    }

    public boolean isHeartBurn() {
        return this.healthConditions.get("heartBurn");
    }

    public void setHeartBurn(boolean heartBurn) {
        this.healthConditions.put("heartBurn", heartBurn);
    }

    public boolean isHighBloodPressure() {
        return this.healthConditions.get("highBloodPressure");
    }

    public void setHighBloodPressure(boolean highBloodPressure) {
        this.healthConditions.put("highBloodPressure", highBloodPressure);
    }

    public boolean isImpotence() {
        return this.healthConditions.get("impotence");
    }

    public void setImpotence(boolean impotence) {
        this.healthConditions.put("impotence", impotence);
    }

    public boolean isJointPain() {
        return this.healthConditions.get("jointPain");
    }

    public void setJointPain(boolean jointPain) {
        this.healthConditions.put("jointPain", jointPain);
    }

    public boolean isLowerBackPain() {
        return this.healthConditions.get("lowerBackPain");
    }

    public void setLowerBackPain(boolean nightBlindness) {
        this.healthConditions.put("nightBlindness", nightBlindness);
    }

    public boolean isNightBlindness() {
        return this.healthConditions.get("nightBlindness");
    }

    public void setNightBlindness(boolean nightBlindness) {
        this.healthConditions.put("nightBlindness", nightBlindness);
    }

    public boolean isNightUrination() {
        return this.healthConditions.get("nightUrination");
    }

    public void setNightUrination(boolean nightUrination) {
        this.healthConditions.put("nightUrination", nightUrination);
    }

    public boolean isNoseBleeds() {
        return this.healthConditions.get("noseBleeds");
    }

    public void setNoseBleeds(boolean noseBleeds) {
        this.healthConditions.put("noseBleeds", noseBleeds);
    }

    public boolean isProtrudingEyes() {
        return this.healthConditions.get("protrudingEyes");
    }

    public void setProtrudingEyes(boolean protrudingEyes) {
        this.healthConditions.put("protrudingEyes", protrudingEyes);
    }

    public boolean isRedFace() {
        return this.healthConditions.get("redFace");
    }

    public void setRedFace(boolean redFace) {
        this.healthConditions.put("redFace", redFace);
    }

    public boolean isRedThickSkin() {
        return this.healthConditions.get("redThickSkin");
    }

    public void setRedThickSkin(boolean redThickSkin) {
        this.healthConditions.put("redThickSkin", redThickSkin);
    }

    public boolean isSensitivityToLight() {
        return this.healthConditions.get("sensitivityToLight");
    }

    public void setSensitivityToLight(boolean sensitivityToLight) {
        this.healthConditions.put("sensitivityToLight", sensitivityToLight);
    }

    public boolean isSnoring() {
        return this.healthConditions.get("snoring");
    }

    public void setSnoring(boolean snoring) {
        this.healthConditions.put("snoring", snoring);
    }

    public boolean isStomachPain() {
        return this.healthConditions.get("stomachPain");
    }

    public void setStomachPain(boolean stomachPain) {
        this.healthConditions.put("stomachPain", stomachPain);
    }

    public boolean isSwelling() {
        return this.healthConditions.get("swelling");
    }

    public void setSwelling(boolean swelling) {
        this.healthConditions.put("swelling", swelling);
    }

    public boolean isTesticlePain() {
        return this.healthConditions.get("testiclePain");
    }

    public void setTesticlePain(boolean testiclePain) {
        this.healthConditions.put("testiclePain", testiclePain);
    }

    public boolean isVisionProblems() {
        return this.healthConditions.get("visionProblems");
    }

    public void setVisionProblems(boolean visionProblems) {
        this.healthConditions.put("visionProblems", visionProblems);
    }

    public boolean isVomiting() {
        return this.healthConditions.get("vomiting");
    }

    public void setVomiting(boolean vomiting) {
        this.healthConditions.put("vomiting", vomiting);
    }

    public boolean isWarts() {
        return this.healthConditions.get("warts");
    }

    public void setWarts(boolean warts) {
        this.healthConditions.put("warts", warts);
    }

    public boolean isWheezing() {
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
