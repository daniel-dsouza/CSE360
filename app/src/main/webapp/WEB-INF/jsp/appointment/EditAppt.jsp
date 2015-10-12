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
    <h1>Edit Appointment</h1> <br><br>
    <h2>Patient: Rie Hinze</h2><br><br>
      <h4>Speciality: Cardiologist</h4><br><br>
      Edit Specialty:
      <div class="container"> <!-- don't forget your bootstrap html. do the basic tutorial... -->
          <div class="row">
              <!-- method is what do when done, commandName is what object from the model to put stuff into, action should be the name of your jsp. -->
              <form:form method="post" commandName="appointment">
                  <!-- path is where in the object specified by command name to store the result, items is the list of results -->
                    <br/><form:select path="doctorSpec" items="${doctorlist}" /><br/>
                    <span class="group-btn">
                        <input type="submit" value="Update" class="btn btn-primary btn-md"/>
                    </span>
              </form:form>
          </div>
      </div>
      <hr size = 5>
      <h4>Doctor: Dr. Stephanie Bui</h4>
      <br>Edit Doctor:
      <div class="container"> <!-- don't forget your bootstrap html. do the basic tutorial... -->
          <div class="row">
              <!-- method is what do when done, commandName is what object from the model to put stuff into, action should be the name of your jsp. -->
              <form:form method="post" commandName="appointment">
                  <!-- path is where in the object specified by command name to store the result, items is the list of results -->
                  <br/><form:select path="doctorName" items="${doctorPersonList}" /><br/>
                  <!-- path is where in the object specified by command name to store the result, items is the list of results -->
                    <span class="group-btn">
                        <input type="submit" value="Update" class="btn btn-primary btn-md"/>
                    </span>
              </form:form>
          </div>
      </div>
      <hr size = 5>
      <h4>Appointment Time: October 14, 2015 10:00 AM</h4>
      <br>Edit Time:
      <div class="container"> <!-- don't forget your bootstrap html. do the basic tutorial... -->
          <div class="row">
              <!-- method is what do when done, commandName is what object from the model to put stuff into, action should be the name of your jsp. -->
              <form:form method="post" commandName="appointment">
                  <!-- path is where in the object specified by command name to store the result, items is the list of results -->
                  <br/><form:select path="date" items="${dateList}" /><br/>
                  <!-- path is where in the object specified by command name to store the result, items is the list of results -->
                    <span class="group-btn">
                        <input type="submit" value="Update" class="btn btn-primary btn-md"/>
                    </span>
              </form:form>
          </div>
      </div>
      <h4>Reason: Chest Pain</h4>
      <br>Edit Reason:
      <div class="container"> <!-- don't forget your bootstrap html. do the basic tutorial... -->
          <div class="row">
              <!-- method is what do when done, commandName is what object from the model to put stuff into, action should be the name of your jsp. -->
              <form:form method="post" commandName="appointment">
                  <!-- path is where in the object specified by command name to store the result, items is the list of results -->
                    <form:input path="reason" /><br/>
                    <span class="group-btn">
                        <input type="submit" value="Update" class="btn btn-primary btn-md"/>
                        <br><br><br>
                        <span class="group-btn">
                            <input type="submit" value="Submit" class="btn btn-primary btn-md"/>
                         </span>
                    </span>
              </form:form>
          </div>
      </div>

  </jsp:body>
</t:userpage>
