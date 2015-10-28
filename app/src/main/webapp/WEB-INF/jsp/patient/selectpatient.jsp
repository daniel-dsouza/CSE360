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

  <div id="accordian" class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">1. What is HTML?</a>
        </h4>
      </div>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
      <div class="panel-body">
        <div style="float:left">
          <button type="button">Click Me!</button></br>
          <button type="button">Click Me!</button>
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
</jsp:body>
</t:template>