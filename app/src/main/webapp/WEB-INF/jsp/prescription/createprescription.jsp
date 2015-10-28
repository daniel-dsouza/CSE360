<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>



<t:template>
  <jsp:body>
    <h2 style="text-align: center;">
    Create Prescription
    </h2>
    <form:form action="create" method="post" commandName="userInput">
      <div class="row" style="margin: 30px; text-align: center">
        <label style="column-count: 2; -webkit-column-count: 2; -moz-column-count: 2; text-align: right;"> <!-- http://www.w3schools.com/cssref/css3_pr_column-count.asp -->
          Prescription Type:
          <form:input class='form-control' type='text' path="prescriptionType" id="prescriptionType" required="true"/>
        </label>
        <br/>
        <label style="column-count: 2; -webkit-column-count: 2; -moz-column-count: 2; text-align: right;">
          Quantity:
          <form:input class='form-control' type='text' path="quantity" id="quantity" required="true"/>
        </label>
      </div>
      <div class="button_holder" style="text-align: center;"> <!-- Cause an error -->
        <span class="group-btn">
          <input type="submit" value="Prescribe" class="btn btn-primary btn-md"/>
        </span>
      </div>
    </form:form>
  </jsp:body>
</t:template>