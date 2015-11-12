<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<!-- used http://community.sitepoint.com/t/make-all-table-cells-the-same-size/3363/3 -->
<style type="text/css">
    td {
        border-spacing: 0;
        width: 70px;
        margin: 0;
        padding: 0;
    }
</style>

<t:template>
    <jsp:body>
        <h2 style="text-align: center;">
            HSP: Create Medical History
        </h2>
        <!-- used http://bootsnipp.com/snippets/featured/animated-radios-amp-checkboxes-nojs -->
        <form:form action="page3" method="post" commandName="userInput">
            <div class="container-fluid">
                <table class="table" style="margin-bottom: 0;border: none">
                    <tbody>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.aidsHIVPositive"/>
                                <span class="cr"></span>
                                AIDS/HIV Positive
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.alzheimerDisease"/>
                                <span class="cr"></span>
                                Alzheimer's Disease
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.anaphylaxis"/>
                                <span class="cr"></span>
                                Anaphylaxis
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.anemia"/>
                                <span class="cr"></span>
                                Anemia
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.angina"/>
                                <span class="cr"></span>
                                Angina
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.arthritis"/>
                                <span class="cr"></span>
                                Arthritis/Gout
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.artificialHeartValve"/>
                                <span class="cr"></span>
                                Artificial Heart Valve
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.artificialJoint"/>
                                <span class="cr"></span>
                                Artificial Joint
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.asthma"/>
                                <span class="cr"></span>
                                Asthma
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.bloodDisease"/>
                                <span class="cr"></span>
                                Blood Disease
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.bloodTransfusion"/>
                                <span class="cr"></span>
                                Blood Transfusion
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.breathingProblem"/>
                                <span class="cr"></span>
                                Breathing Problem
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.bruiseEasily"/>
                                <span class="cr"></span>
                                Bruise Easily
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.cancer"/>
                                <span class="cr"></span>
                                Cancer
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.chemotherapy"/>
                                <span class="cr"></span>
                                Chemotherapy
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.chestPains"/>
                                <span class="cr"></span>
                                Chest Pains
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.coldSores"/>
                                <span class="cr"></span>
                                Cold Sores
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.congenitalDisorder"/>
                                <span class="cr"></span>
                                Congenital Disorder
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.convulsions"/>
                                <span class="cr"></span>
                                Convulsions
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.cortisonMedicine"/>
                                <span class="cr"></span>
                                Cortisone Medicine
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.diabetes"/>
                                <span class="cr"></span>
                                Diabetes
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.drugAddiction"/>
                                <span class="cr"></span>
                                Drug Addiction
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.easilyWinded"/>
                                <span class="cr"></span>
                                Easily Winded
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.emphysema"/>
                                <span class="cr"></span>
                                Emphysema
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.epilepsy"/>
                                <span class="cr"></span>
                                Epilepsy or Seizures
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.excessiveBleeding"/>
                                <span class="cr"></span>
                                Excessive Bleeding
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.excessiveThirst"/>
                                <span class="cr"></span>
                                Excessive Thirst
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.faintingSpells"/>
                                <span class="cr"></span>
                                Fainting Spells
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.glaucoma"/>
                                <span class="cr"></span>
                                Glaucoma
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.heyFever"/>
                                <span class="cr"></span>
                                Hay Fever
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.heartAttack"/>
                                <span class="cr"></span>
                                Heart Attack/Failure
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.heartMurmur"/>
                                <span class="cr"></span>
                                Heart Murmur
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.heartPacemaker"/>
                                <span class="cr"></span>
                                Heart Pacemaker
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.heartDisease"/>
                                <span class="cr"></span>
                                Heart Trouble/Disease
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.hemophilia"/>
                                <span class="cr"></span>
                                Hemophilia
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.hepitisA"/>
                                <span class="cr"></span>
                                Hepatitis A
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.hepatitisBC"/>
                                <span class="cr"></span>
                                Hepatitis B or C
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.highBloodPressure2"/>
                                <span class="cr"></span>
                                High Blood Pressure
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.highCholesterol"/>
                                <span class="cr"></span>
                                High Cholesterol
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.hives"/>
                                <span class="cr"></span>
                                Hives or Rash
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.hypoglicemia"/>
                                <span class="cr"></span>
                                Hypoglicemia
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.irregularHearbeat"/>
                                <span class="cr"></span>
                                Irregular Heartbeat
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.kidneyProblems"/>
                                <span class="cr"></span>
                                Kidney Problems
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.leukemia"/>
                                <span class="cr"></span>
                                Leukemia
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.liverDisease"/>
                                <span class="cr"></span>
                                Liver Disease
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.lowBloodPressure"/>
                                <span class="cr"></span>
                                Low Blood Pressure
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.lungDisease"/>
                                <span class="cr"></span>
                                Lung Disease
                            </label>
                        </td>
                        <td>
                            <label class="checkbox">
                                <form:checkbox path="medicalHistory.mitralValveProlapse"/>
                                <span class="cr"></span>
                                Mitral Valve Prolapse
                            </label>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <br/>

                <div class="button_holder" style="text-align: center;"> <!-- Cause an error -->
                  <span class="group-btn">
                      <input type="submit" value="Done" class="btn btn-primary btn-md"/>
                  </span>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:template>
