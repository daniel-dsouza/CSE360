package org.teamone.core.users;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by daniel on 10/12/15.
 */
public class MedicalHistory {
    private Map<String, Boolean> medicalHistory;
    
    public Set<String> getKeys() {
        return medicalHistory.keySet();
    }

    public void set(String condition, boolean state) {
        this.medicalHistory.put(condition, state);
    }

    public boolean isTrue(String condition) {
        return this.medicalHistory.get(condition);
    }

    public String toString() {


        String str = "", temp = "";
        Iterator<Map.Entry<String, Boolean>> entries = medicalHistory.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Boolean> entry = entries.next();
            temp=entry.getKey()+","+entry.getValue()+":";
            str = str.concat(temp);
        }
        System.out.println(str);
        return str;
    }

    public void toMapObj(String str){
        Map<String, Boolean> medicalHistory = null;

        String[] parts = str.split(":");
        for(String temp2:parts)
        {
            String[] temp3 =  temp2.split(",");
            boolean abcd = Boolean.parseBoolean(temp3[1]);
            this.medicalHistory.put(temp3[0], abcd);
        }

    }

    public void setAidsHIVPositive(boolean aidsHIVPositive) { this.medicalHistory.put("aidsHIVPositive", aidsHIVPositive); }
    public boolean getAidsHIVPositive() { return this.medicalHistory.get("aidsHIVPositive"); }

    public void setAlzheimerDisease(boolean alzheimerDisease) { this.medicalHistory.put("alzheimerDisease", alzheimerDisease); }
    public boolean getAlzheimerDisease() { return this.medicalHistory.get("alzheimerDisease"); }

    public void setAnaphylaxis(boolean anaphylaxis) { this.medicalHistory.put("anaphylaxis", anaphylaxis); }
    public boolean getAnaphylaxis() { return this.medicalHistory.get("anaphylaxis"); }

    public void setAnemia(boolean anemia) { this.medicalHistory.put("anemia", anemia); }
    public boolean getAnemia() { return this.medicalHistory.get("anemia"); }

    public void setAngina(boolean angina) { this.medicalHistory.put("angina", angina); }
    public boolean getAngina() { return this.medicalHistory.get("angina"); }

    public void setArthritis(boolean arthritis) { this.medicalHistory.put("arthritis", arthritis); }
    public boolean getArthritis() { return this.medicalHistory.get("arthritis"); }

    public void setArtificialHeartValve(boolean artificialHeartValve) { this.medicalHistory.put("artificialHeartValve", artificialHeartValve); }
    public boolean getArtificialHeartValve() { return this.medicalHistory.get("artificialHeartValve"); }

    public void setArtificialJoint(boolean artificialJoint) { this.medicalHistory.put("artificialJoint", artificialJoint); }
    public boolean getArtificialJoint() { return this.medicalHistory.get("artificialJoint"); }

    public void setAsthma(boolean asthma) { this.medicalHistory.put("asthma", asthma); }
    public boolean getAsthma() { return this.medicalHistory.get("asthma"); }

    public void setBloodDisease(boolean bloodDisease) { this.medicalHistory.put("bloodDisease", bloodDisease); }
    public boolean getBloodDisease() { return this.medicalHistory.get("bloodDisease"); }

    public void setBloodTransfusion(boolean bloodTransfusion) { this.medicalHistory.put("bloodTransfusion", bloodTransfusion); }
    public boolean getBloodTransfusion() { return this.medicalHistory.get("bloodTransfusion"); }

    public void setBreathingProblem(boolean breathingProblem) { this.medicalHistory.put("breathingProblem", breathingProblem); }
    public boolean getBreathingProblem() { return this.medicalHistory.get("breathingProblem"); }

    public void setBruiseEasily(boolean bruiseEasily) { this.medicalHistory.put("bruiseEasily", bruiseEasily); }
    public boolean getBruiseEasily() { return this.medicalHistory.get("bruiseEasily"); }

    public void setCancer(boolean cancer) { this.medicalHistory.put("cancer", cancer); }
    public boolean getCancer() { return this.medicalHistory.get("cancer"); }

    public void setChemotherapy(boolean chemotherapy) { this.medicalHistory.put("chemotherapy", chemotherapy); }
    public boolean getChemotherapy() { return this.medicalHistory.get("chemotherapy"); }

    public void setChestPains(boolean chestPains) { this.medicalHistory.put("chestPains", chestPains); }
    public boolean getChestPains() { return this.medicalHistory.get("chestPains"); }

    public void setColdSores(boolean coldSores) { this.medicalHistory.put("coldSores", coldSores); }
    public boolean getColdSores() { return this.medicalHistory.get("coldSores"); }

    public void setCongenitalDisorder(boolean congenitalDisorder) { this.medicalHistory.put("congenitalDisorder", congenitalDisorder); }
    public boolean getCongenitalDisorder() { return this.medicalHistory.get("congenitalDisorder"); }

    public void setConvulsions(boolean convulsions) { this.medicalHistory.put("convulsions", convulsions); }
    public boolean getConvulsions() { return this.medicalHistory.get("convulsions"); }

    public void setCortisonMedicine(boolean cortisonMedicine) { this.medicalHistory.put("cortisonMedicine", cortisonMedicine); }
    public boolean getCortisonMedicine() { return this.medicalHistory.get("cortisonMedicine"); }

    public void setDiabetes(boolean diabetes) { this.medicalHistory.put("diabetes", diabetes); }
    public boolean getDiabetes() { return this.medicalHistory.get("diabetes"); }

    public void setDrugAddiction(boolean drugAddiction) { this.medicalHistory.put("drugAddiction", drugAddiction); }
    public boolean getDrugAddiction() { return this.medicalHistory.get("drugAddiction"); }

    public void setEasilyWinded(boolean easilyWinded) { this.medicalHistory.put("easilyWinded", easilyWinded); }
    public boolean getEasilyWinded() { return this.medicalHistory.get("easilyWinded"); }

    public void setEmphysema(boolean emphysema) { this.medicalHistory.put("emphysema", emphysema); }
    public boolean getEmphysema() { return this.medicalHistory.get("emphysema"); }

    public void setEpilepsy(boolean epilepsy) { this.medicalHistory.put("epilepsy", epilepsy); }
    public boolean getEpilepsy() { return this.medicalHistory.get("epilepsy"); }

    public void setExcessiveBleeding(boolean excessiveBleeding) { this.medicalHistory.put("excessiveBleeding", excessiveBleeding); }
    public boolean getExcessiveBleeding() { return this.medicalHistory.get("excessiveBleeding"); }

    public void setExcessiveThirst(boolean excessiveThirst) { this.medicalHistory.put("excessiveThirst", excessiveThirst); }
    public boolean getExcessiveThirst() { return this.medicalHistory.get("excessiveThirst"); }

    public void setFaintingSpells(boolean faintingSpells) { this.medicalHistory.put("faintingSpells", faintingSpells); }
    public boolean getFaintingSpells() { return this.medicalHistory.get("faintingSpells"); }

    public void setGlaucoma(boolean glaucoma) { this.medicalHistory.put("glaucoma", glaucoma); }
    public boolean getGlaucoma() { return this.medicalHistory.get("glaucoma"); }

    public void setHeyFever(boolean heyFever) { this.medicalHistory.put("heyFever", heyFever); }
    public boolean getHeyFever() { return this.medicalHistory.get("heyFever"); }

    public void setHeartAttack(boolean heartAttack) { this.medicalHistory.put("heartAttack", heartAttack); }
    public boolean getHeartAttack() { return this.medicalHistory.get("heartAttack"); }

    public void setHeartMurmur(boolean heartMurmur) { this.medicalHistory.put("heartMurmur", heartMurmur); }
    public boolean getHeartMurmur() { return this.medicalHistory.get("heartMurmur"); }

    public void setHeartPacemaker(boolean heartPacemaker) { this.medicalHistory.put("heartPacemaker", heartPacemaker); }
    public boolean getHeartPacemaker() { return this.medicalHistory.get("heartPacemaker"); }

    public void setHeartDisease(boolean heartDisease) { this.medicalHistory.put("heartDisease", heartDisease); }
    public boolean getHeartDisease() { return this.medicalHistory.get("heartDisease"); }

    public void setHemophilia(boolean hemophilia) { this.medicalHistory.put("hemophilia", hemophilia); }
    public boolean getHemophilia() { return this.medicalHistory.get("hemophilia"); }

    public void setHepitisA(boolean hepitisA) { this.medicalHistory.put("hepitisA", hepitisA); }
    public boolean getHepitisA() { return this.medicalHistory.get("hepitisA"); }

    public void setHepatitisBC(boolean hepatitisBC) { this.medicalHistory.put("hepatitisBC", hepatitisBC); }
    public boolean getHepatitisBC() { return this.medicalHistory.get("hepatitisBC"); }

    public void setHighBloodPressure2(boolean highBloodPressure2) { this.medicalHistory.put("highBloodPressure2", highBloodPressure2); }
    public boolean getHighBloodPressure2() { return this.medicalHistory.get("highBloodPressure2"); }

    public void setHighCholesterol(boolean highCholesterol) { this.medicalHistory.put("highCholesterol", highCholesterol); }
    public boolean getHighCholesterol() { return this.medicalHistory.get("highCholesterol"); }

    public void setHives(boolean hives) { this.medicalHistory.put("hives", hives); }
    public boolean getHives() { return this.medicalHistory.get("hives"); }

    public void setHypoglicemia(boolean hypoglicemia) { this.medicalHistory.put("hypoglicemia", hypoglicemia); }
    public boolean getHypoglicemia() { return this.medicalHistory.get("hypoglicemia"); }

    public void setIrregularHearbeat(boolean irregularHearbeat) { this.medicalHistory.put("irregularHearbeat", irregularHearbeat); }
    public boolean getIrregularHearbeat() { return this.medicalHistory.get("irregularHearbeat"); }

    public void setKidneyProblems(boolean kidneyProblems) { this.medicalHistory.put("kidneyProblems", kidneyProblems); }
    public boolean getKidneyProblems() { return this.medicalHistory.get("kidneyProblems"); }

    public void setLeukemia(boolean leukemia) { this.medicalHistory.put("leukemia", leukemia); }
    public boolean getLeukemia() { return this.medicalHistory.get("leukemia"); }

    public void setLiverDisease(boolean liverDisease) { this.medicalHistory.put("liverDisease", liverDisease); }
    public boolean getLiverDisease() { return this.medicalHistory.get("liverDisease"); }

    public void setLowBloodPressure(boolean lowBloodPressure) { this.medicalHistory.put("lowBloodPressure", lowBloodPressure); }
    public boolean getLowBloodPressure() { return this.medicalHistory.get("lowBloodPressure"); }

    public void setLungDisease(boolean lungDisease) { this.medicalHistory.put("lungDisease", lungDisease); }
    public boolean getLungDisease() { return this.medicalHistory.get("lungDisease"); }

    public void setMitralValveProlapse(boolean mitralValveProlapse) { this.medicalHistory.put("mitralValveProlapse", mitralValveProlapse); }
    public boolean getMitralValveProlapse() { return this.medicalHistory.get("mitralValveProlapse"); }
    
    public MedicalHistory() {
        medicalHistory = new HashMap<String, Boolean>();

        this.medicalHistory.put("aidsHIVPositive", false);
        this.medicalHistory.put("alzheimerDisease", false);
        this.medicalHistory.put("anaphylaxis", false);
        this.medicalHistory.put("anemia", false);
        this.medicalHistory.put("angina", false);
        this.medicalHistory.put("arthritis", false);
        this.medicalHistory.put("artificialHeartValve", false);
        this.medicalHistory.put("artificialJoint", false);                //8
        this.medicalHistory.put("asthma", false);
        this.medicalHistory.put("bloodDisease", false);
        this.medicalHistory.put("bloodTransfusion", false);
        this.medicalHistory.put("breathingProblem", false);               //12
        this.medicalHistory.put("bruiseEasily", false);
        this.medicalHistory.put("cancer", false);
        this.medicalHistory.put("chemotherapy", false);
        this.medicalHistory.put("chestPains", false);                     //16
        this.medicalHistory.put("coldSores", false);
        this.medicalHistory.put("congenitalDisorder", false);
        this.medicalHistory.put("convulsions", false);
        this.medicalHistory.put("cortisonMedicine", false);               //20
        this.medicalHistory.put("diabetes", false);
        this.medicalHistory.put("drugAddiction", false);
        this.medicalHistory.put("easilyWinded", false);
        this.medicalHistory.put("emphysema", false);                      //24
        this.medicalHistory.put("epilepsy", false);
        this.medicalHistory.put("excessiveBleeding", false);
        this.medicalHistory.put("excessiveThirst", false);
        this.medicalHistory.put("faintingSpells", false);                 //28
        this.medicalHistory.put("glaucoma", false);
        this.medicalHistory.put("heyFever", false);
        this.medicalHistory.put("heartAttack", false);
        this.medicalHistory.put("heartMurmur", false);                    //32
        this.medicalHistory.put("heartPacemaker", false);
        this.medicalHistory.put("heartDisease", false);
        this.medicalHistory.put("hemophilia", false);
        this.medicalHistory.put("hepitisA", false);                       //36
        this.medicalHistory.put("hepatitisBC", false);
        this.medicalHistory.put("highBloodPressure2", false);
        this.medicalHistory.put("highCholesterol", false);
        this.medicalHistory.put("hives", false);                          //40
        this.medicalHistory.put("hypoglicemia", false);
        this.medicalHistory.put("irregularHearbeat", false);
        this.medicalHistory.put("kidneyProblems", false);
        this.medicalHistory.put("leukemia", false);                       //44
        this.medicalHistory.put("liverDisease", false);
        this.medicalHistory.put("lowBloodPressure", false);
        this.medicalHistory.put("lungDisease", false);
        this.medicalHistory.put("mitralValveProlapse", false);
    }
}
