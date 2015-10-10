<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 10/7/2015
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
--%>
<%@ include file="header.jsp" %>
<div class="container"> <!-- don't forget your bootstrap html. do the basic tutorial... -->
    <div class="row">
        <!-- method is what do when done, commandName is what object from the model to put stuff into, action should be the name of your jsp. -->
        <form:form method="post" commandName="appointment">
            <!-- path is where in the object specified by command name to store the result, items is the list of results -->
            <form:select path="doctor" items="${doctorlist}" />
            <div class="wrapper">
                <span class="group-btn">
                    <input type="submit" value="Register" class="btn btn-primary btn-md"/>
                </span>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>
