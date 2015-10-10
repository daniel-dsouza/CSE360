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

<t:userpage>
    <jsp:attribute name="nav">
        <jsp:include page="/WEB-INF/jsp/generic/navbar.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <jsp:include page="../generic/footer.jsp"/>
    </jsp:attribute>
  <jsp:body>
      <!-- used http://bootsnipp.com/snippets/featured/animated-radios-amp-checkboxes-nojs -->
      <form:form action="page3" method="post" commandName="userInput">
          <div class="container-fluid">
              <table class="table" style="margin-bottom: 0;border: none">
                  <tbody>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="aidsHIVPositive" />
                                  <span class="cr"></span>
                                  AIDS/HIV Positive
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="alzheimerDisease" />
                                  <span class="cr"></span>
                                  Alzheimer's Disease
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="anaphylaxis" />
                                  <span class="cr"></span>
                                  Anaphylaxis
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="anemia" />
                                  <span class="cr"></span>
                                  Anemia
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="angina" />
                                  <span class="cr"></span>
                                  Angina
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="arthritis" />
                                  <span class="cr"></span>
                                  Arthritis/Gout
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="artificialHeartValve" />
                                  <span class="cr"></span>
                                  Artificial Heart Valve
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="artificialJoint" />
                                  <span class="cr"></span>
                                  Artificial Joint
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="asthma" />
                                  <span class="cr"></span>
                                  Asthma
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="bloodDisease" />
                                  <span class="cr"></span>
                                  Blood Disease
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="bloodTransfusion" />
                                  <span class="cr"></span>
                                  Blood Transfusion
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="breathingProblem" />
                                  <span class="cr"></span>
                                  Breathing Problem
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="bruiseEasily" />
                                  <span class="cr"></span>
                                  Bruise Easily
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="cancer" />
                                  <span class="cr"></span>
                                  Cancer
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="chemotherapy" />
                                  <span class="cr"></span>
                                  Chemotherapy
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="chestPains" />
                                  <span class="cr"></span>
                                  Chest Pains
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="coldSores" />
                                  <span class="cr"></span>
                                  Cold Sores
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="congenitalDisorder" />
                                  <span class="cr"></span>
                                  Congenital Disorder
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="convulsions" />
                                  <span class="cr"></span>
                                  Convulsions
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="cortisonMedicine" />
                                  <span class="cr"></span>
                                  Cortisone Medicine
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="diabetes" />
                                  <span class="cr"></span>
                                  Diabetes
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="drugAddiction" />
                                  <span class="cr"></span>
                                  Drug Addiction
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="easilyWinded" />
                                  <span class="cr"></span>
                                  Easily Winded
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="emphysema" />
                                  <span class="cr"></span>
                                  Emphysema
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="epilepsy" />
                                  <span class="cr"></span>
                                  Epilepsy or Seizures
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="excessiveBleeding" />
                                  <span class="cr"></span>
                                  Excessive Bleeding
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="excessiveThirst" />
                                  <span class="cr"></span>
                                  Excessive Thirst
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="faintingSpells" />
                                  <span class="cr"></span>
                                  Fainting Spells
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="glaucoma" />
                                  <span class="cr"></span>
                                  Glaucoma
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="heyFever" />
                                  <span class="cr"></span>
                                  Hay Fever
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="heartAttack" />
                                  <span class="cr"></span>
                                  Heart Attack/Failure
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="heartMurmur" />
                                  <span class="cr"></span>
                                  Heart Murmur
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="heartPacemaker" />
                                  <span class="cr"></span>
                                  Heart Pacemaker
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="heartDisease" />
                                  <span class="cr"></span>
                                  Heart Trouble/Disease
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="hemophilia" />
                                  <span class="cr"></span>
                                  Hemophilia
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="hepitisA" />
                                  <span class="cr"></span>
                                  Hepatitis A
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="hepatitisBC" />
                                  <span class="cr"></span>
                                  Hepatitis B or C
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="highBloodPressure2" />
                                  <span class="cr"></span>
                                  High Blood Pressure
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="highCholesterol" />
                                  <span class="cr"></span>
                                  High Cholesterol
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="hives" />
                                  <span class="cr"></span>
                                  Hives or Rash
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="hypoglicemia" />
                                  <span class="cr"></span>
                                  Hypoglicemia
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="irregularHearbeat" />
                                  <span class="cr"></span>
                                  Irregular Heartbeat
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="kidneyProblems" />
                                  <span class="cr"></span>
                                  Kidney Problems
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="leukemia" />
                                  <span class="cr"></span>
                                  Leukemia
                              </label>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="liverDisease" />
                                  <span class="cr"></span>
                                  Liver Disease
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="lowBloodPressure" />
                                  <span class="cr"></span>
                                  Low Blood Pressure
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="lungDisease" />
                                  <span class="cr"></span>
                                  Lung Disease
                              </label>
                          </td>
                          <td>
                              <label class="checkbox">
                                  <form:checkbox path="mitralValveProlapse" />
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
</t:userpage>