<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>



<t:template>
  <jsp:body>
    <form:form method="post" commandName="prescriptions">
      <c:forEach var="prescript" items="${prescriptions}">
        <div class="row" style="margin: 30px; text-align: center">
            Prescription Type:
            <form:input class='form-control' type='text' path="prescriptionType" id="prescriptionType" items="${prescript}" required="true"/>
          <br/>
          Quantity:
          <form:input class='form-control' type='text' path="quantity" id="quantity" required="true"/>
        </div>
      </c:forEach>
      <div class="button_holder" style="text-align: center;"> <!-- Cause an error -->
          <span class="group-btn">
            <input type="submit" value="Update" class="btn btn-primary btn-md"/>
          </span>
      </div>
    </form:form>
  </jsp:body>
</t:template>