<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
<jsp:attribute name="head">

</jsp:attribute>

    <jsp:body>
        <div class="container-fluid" id="target">
            <div class="row" style="margin: 5px">
                <h1>Appointments</h1>
            </div>
            <div class="row" style="margin: 10px">
                <c:forEach var="appt" items="${patientList}">
                    <div class="col-lg-12" style="border-bottom-style: solid; border-width: 1px">
                        <div style="float: left; padding: 5px 5px 5px"> ${appt.reason}</div>
                        <div style="float: left; padding: 5px 5px 5px"> ${appt.date}</div>
                        <div style="float: left; padding: 5px 5px 5px"> ${appt.time}</div>
                        <div style="float: right; padding: 5px 5px 5px">
                            <a href="${pageContext.request.contextPath}/appointment/edit/${appt.appointmentID}"
                               class="btn btn-info" role="button">Edit appointment</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </jsp:body>
</t:template>