<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
<jsp:attribute name="head">

</jsp:attribute>

<jsp:body>
  <!-- Page header -->
  <div class="row">
    <div class="col-lg-12">
      <h1>Select Patient</h1>
    </div>
  </div>

  <!--Display list of partial-patient-->
  <c:forEach var="patient" items="${patients}">
    <div id="accordion" class="panel-group">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#tbd">1. What is HTML?</a></h4>
        </div>
      </div>
      <div id="tbd" class="panel-collapse collapse in">
        <div class="panel-body">
          <div class="btn-group-vertical" style="float:left">
            <button type="submit" name="action" value="${patient.id}/nom" class="btn btn-info">Medical History</button>
            <button type="submit" name="action" value="save" class="btn btn-info">Health Conditions</button>
            <button type="submit" name="action" value="${patient.id}/nom" class="btn btn-info">Personal Info</button>
          </div>
          <div class="container" style="float:right">
            <div class="row">
              <div class="col-sm-6">some content here</div>
              <div class="col-sm-6">more content here</div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </c:forEach>
</jsp:body>
</t:template>