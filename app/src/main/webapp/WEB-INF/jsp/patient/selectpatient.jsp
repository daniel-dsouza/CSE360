<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>

<jsp:attribute name="head">
  <script type="text/javascript" src="js/selectperson.js"></script>
</jsp:attribute>

<jsp:body>
  <!-- Page header -->
  <div class="row">
    <div class="col-lg-12">
      <h1>Select Patient</h1>
    </div>
  </div>

  <!--Display list of partial-patient-->
  <div style="margin: 20px">
    <c:forEach var="patient" items="${patients}">
      <div id="accordion" class="panel-group">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#${patient.userID}">Patient: ${patient.userID}</a></h4>
          </div>

          <div id="${patient.userID}" class="panel-collapse collapse out">
            <div class="panel-body ">
              <div class="btn-group-vertical" style="float:left">
                <c:forEach var="action" items="${actions}">
                  <a href="${pageContext.request.contextPath}/select_patient/${patient.userID}/${action.key}" class="btn btn-info" role="button">${action.value}</a>
                </c:forEach>
              </div>
              <div class="container" style="float:left">
                <div class="row">
                  <div class="col-sm-3" >
                    <div class="panel panel-default">
                      <div class="panel-heading">
                        <h6 class="panel-title">Personal Info</h6>
                      </div>
                      <div class="panel-body" id="personal_info_${patient.userID}"> some content here </div>
                    </div>
                  </div>
                  <div class="col-sm-3">
                    <div class="panel panel-default">
                      <div class="panel-heading">
                        <h6 class="panel-title">Appointments</h6>
                      </div>
                      <div class="panel-body" id="appointments_${patient.userID}"> some content here </div>
                    </div>
                  </div>
                  <div class="col-sm-3" >
                    <div class="panel panel-default">
                      <div class="panel-heading">
                        <h6 class="panel-title">Alerts</h6>
                      </div>
                      <div class="panel-body" id="alerts_${patient.userID}"> some content here </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </c:forEach>
  </div>

</jsp:body>
</t:template>