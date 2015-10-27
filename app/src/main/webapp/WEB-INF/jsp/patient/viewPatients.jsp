<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:userpage>
    <jsp:attribute name="head">
    </jsp:attribute>

    <jsp:attribute name="nav">
        <jsp:include page="/WEB-INF/jsp/generic/navbar.jsp"/>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <jsp:include page="../generic/footer.jsp"/>
    </jsp:attribute>

  <jsp:body>
    <c:forEach var="current" items="${patientList}">
      <div class="container-fluid" id="target">

          <div  style="float:right; padding: 20px 20px 10px 10px; width=100%">
              <a href=${pageContext.request.contextPath}/${current.PatientInformation.name}/${current.patientID}/appointment/list" class="btn btn-info" role="button">
                  View/Edit<br>Appointments</a>
          </div>
          <div  style="float:right; padding: 20px 20px 10px 10px; width=100%">      //TODO: fill in href
              <a href=${pageContext.request.contextPath}/${}/" class="btn btn-info" role="button">
                  View/Edit<br>Health Conditions</a>
          </div>
          <div  style="float:right; padding: 20px 20px 10px 10px; width=100%">      //TODO: fix href
              <a href=${pageContext.request.contextPath}/${}/" class="btn btn-info" role="button">
              View/Edit<br>Medical History</a>
          </div>
          <div  style="float:right; padding: 20px 20px 10px 10px; width=100%">      //TODO: fix href
              <a href=${pageContext.request.contextPath}/${}/" class="btn btn-info" role="button">
              Labs and<br>Prescriptions</a>
          </div>
          <div  style="float:left; padding: 20px 20px 10px 10px; width=100%">
              <c:out value="${current.PatientInformation.name}"/>
          </div>
      </div>
    </c:forEach>
  </jsp:body>
</t:userpage>

