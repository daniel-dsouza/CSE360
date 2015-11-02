<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>



<t:template>
  <jsp:body>
    <div class="container">
      <!-- header -->
      <div class="row">
        <h1>Create Prescription</h1>
      </div>

      <!-- form -->
      <form:form action="create" method="post" commandName="userInput">
        <div class="row">
          <label id="prescriptionType" >Prescription Type: </label>
          <form:input class='form-control' type='text' path="prescriptionType" id="prescriptionType" required="true"/>
          <br/>
        </div>
        <div class="row">
          <label id="quantity">Quantity: </label>
          <form:input class='form-control' type='text' path="quantity" id="quantity" required="true"/>
          <br/>
        </div>
        <div class="row">
          <input type="submit" class="btn btn-info" value="Prescribe">
        </div>
      </form:form>
    </div>
  </jsp:body>
</t:template>