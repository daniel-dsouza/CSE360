<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<t:template>
  <jsp:body>
    <div class="container" style="text-align: center">
      <h1>Prescription ${prescription.prescriptionID}</h1>
      <div class="box" style="margin-left: 33%">
        <h3 style="text-align: left">Prescribing Doctor:<span style="margin-right: 15px"></span>${doc.firstName} ${doc.lastName}</h3>
        <h3 style="text-align: left">Intended Patient:<span style="margin-right: 38px"></span>${pat.firstName} ${pat.lastName}</h3>
        <h3 style="text-align: left">Time Prescribed:<span style="margin-right: 38px"></span>${prescription.strDateAndTime}</h3>
        <h3 style="text-align: left">Prescription:<span style="margin-right: 85px"></span>${prescription.prescriptionType}</h3>
        <h3 style="text-align: left">Amount (quantity):<span style="margin-right: 23px"></span>${prescription.quantity}</h3>
      </div>
    </div>
    <div class="container" style="text-align: center">

    </div>
  </jsp:body>
</t:template>