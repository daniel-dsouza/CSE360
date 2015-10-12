<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:userpage>
    <jsp:attribute name="nav">
        <jsp:include page="/WEB-INF/jsp/generic/navbar.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <jsp:include page="../generic/footer.jsp"/>
    </jsp:attribute>
  <jsp:body>
    <div class="container"> <!-- don't forget your bootstrap html. do the basic tutorial... -->
      <div class="row">
        <!-- method is what do when done, commandName is what object from the model to put stuff into, action should be the name of your jsp. -->
        <form:form method="post" commandName="appointment">
          <!-- path is where in the object specified by command name to store the result, items is the list of results -->
          Select Patient:<br/><br/><form:select path="patient" items="${patientlist}" /><br/>
          <!-- path is where in the object specified by command name to store the result, items is the list of results -->
          <%--Doctor:<br/><form:select path="doctorPerson" items="${doctorPersonList}" /><br/>--%>
          <%--Reason:<br/><form:input path="reason" /><br/>--%>
                    <span class="group-btn">
                        <br/><br/><input type="submit" value="Edit Appointment" class="btn btn-primary btn-md"/>
                    </span>
        </form:form>
      </div>
    </div>

  </jsp:body>
</t:userpage>
