<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>



<!-- used http://community.sitepoint.com/t/make-all-table-cells-the-same-size/3363/3 -->
<style type="text/css">
  td {
    border-spacing: 0;
    width: 70px;
    margin: 0; padding: 0;
  }
</style>


<t:template>
  <jsp:body>
    <h2 style="text-align: center;">
      HSP: Create Health Conditions
    </h2>
    <!-- used http://bootsnipp.com/snippets/featured/animated-radios-amp-checkboxes-nojs -->
    <form:form action="page2" method="post" commandName="userInput">
      <div class="container">
        <table class="table" style="margin-bottom: 0;border: none">
          <tbody>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.anklePain"/>
                <span class="cr"></span>
                Ankle Pain
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.anxiety"/>
                <span class="cr"></span>
                Anxiety
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.badBreath"/>
                <span class="cr"></span>
                Bad Breath
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.bleedingGums"/>
                <span class="cr"></span>
                Bleeding Gums
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.bloodyStools"/>
                <span class="cr"></span>
                Bloody Stools
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.constipation"/>
                <span class="cr"></span>
                Constipation
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.diarrhea"/>
                <span class="cr"></span>
                Diarrhea
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.discoloredUrine"/>
                <span class="cr"></span>
                Discolored Urine
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.dizziness"/>
                <span class="cr"></span>
                Dizziness
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.drySkin"/>
                <span class="cr"></span>
                Dry Skin
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.earDrainage"/>
                <span class="cr"></span>
                Ear Drainage
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.excessiveBurping"/>
                <span class="cr"></span>
                Excessive Burping
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.excessiveYawning"/>
                <span class="cr"></span>
                Excessive Yawning
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.fatigue"/>
                <span class="cr"></span>
                Fatigue
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.footPain"/>
                <span class="cr"></span>
                Foot Pain
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.frequentUrination"/>
                <span class="cr"></span>
                Frequent Urination
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.gas"/>
                <span class="cr"></span>
                Gas
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.hairLoss"/>
                <span class="cr"></span>
                Hair Loss
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.headaches"/>
                <span class="cr"></span>
                Headaches
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.hearingProblems"/>
                <span class="cr"></span>
                Hearing Problems
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.heartBurn"/>
                <span class="cr"></span>
                Heart Burn
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.highBloodPressure"/>
                <span class="cr"></span>
                High Blood Pressure
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.impotence"/>
                <span class="cr"></span>
                Impotence
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.jointPain"/>
                <span class="cr"></span>
                Joint Pain
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.lowerBackPain"/>
                <span class="cr"></span>
                Lower Back Pain
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.nightBlindness"/>
                <span class="cr"></span>
                Night Blindness
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.nightUrination"/>
                <span class="cr"></span>
                Night Urination
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.noseBleeds"/>
                <span class="cr"></span>
                Nose Bleeds
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.protrudingEyes"/>
                <span class="cr"></span>
                Protruding Eyes
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.redFace"/>
                <span class="cr"></span>
                Red Face
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.redThickSkin"/>
                <span class="cr"></span>
                Red, Thick Skin
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.sensitivityToLight"/>
                <span class="cr"></span>
                Sensitivity to Light
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.snoring"/>
                <span class="cr"></span>
                Snoring
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.stomachPain"/>
                <span class="cr"></span>
                Stomach Pain
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.swelling"/>
                <span class="cr"></span>
                Swelling
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.testiclePain"/>
                <span class="cr"></span>
                Testicle Pain
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.visionProblems"/>
                <span class="cr"></span>
                Vision Problems
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.vomiting"/>
                <span class="cr"></span>
                Vomiting
              </label>
            </td>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.warts"/>
                <span class="cr"></span>
                Warts
              </label>
            </td>
          </tr>
          <tr>
            <td>
              <label class="checkbox">
                <form:checkbox path="healthConditions.wheezing"/>
                <span class="cr"></span>
                Wheezing
              </label>
            </td>
            <td>
            </td>
            <td>
            </td>
          </tr>
          </tbody>
        </table>
        <br/>
        <div class="button_holder" style="text-align: center;"> <!-- Cause an error -->
          <span class="group-btn">
              <input type="submit" value="Next" class="btn btn-primary btn-md"/>
          </span>
        </div>
      </div>
    </form:form>
  </jsp:body>
</t:template>


