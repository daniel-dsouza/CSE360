<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
  <jsp:body>
    <div class="container-fluid">
      <div class="jumbotron" style="background-color: deepskyblue">
        <h1>Welcome <c:out value="${user.person.firstName}"/> <c:out value="${user.person.lastName}"/> to the IPIMS</h1>
        <p>Circle of Health</p>
      </div>
      <c:if test="${user.doctor.alertsPresent == 1}">
        <c:if test="${user.doctor.specialty == 'Emergency'}">
          <div class="alertDoctor"><h2> Detected patients with severe conditions. Please report to the emergency room.</h2> </div>
        </c:if>
      </c:if>
    </div>
  </jsp:body>
</t:template>


