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
            <c:if test="${empty doctorList}">
                <div class="container" style="border-bottom-style: solid; border-width: 1px">
                    <div class="text-center">No Appointments Available</div>
                </div>
            </c:if>
            <c:if test="${not empty doctorList}">
                <div class="container" style="border-bottom-style: solid; border-width: 1px">
                    <div class="col-sm-2 col-sm-offset-1">Reason</div>
                    <div class="col-sm-2">Date</div>
                    <div class="col-sm-1">Time</div>
                    <div class="col-sm-1">Patient</div>
                </div>
                <c:forEach var="appt" items="${doctorList}">
                    <div class="row" style="margin: 5px">
                        <div class="container" style="border-bottom-style: solid; border-width: 1px">
                            <div class="col-sm-2 col-sm-offset-1"> ${appt.reason}</div>
                            <div class="col-sm-2"> ${appt.date}</div>
                            <div class="col-sm-1"> ${appt.time}</div>
                            <div class="col-sm-1"> ${appt.patient.patientInformation.firstName}</div>
                            <div class="col-sm-2">
                                <a href="${pageContext.request.contextPath}/appointment/edit/${appt.appointmentID}"
                                   class="btn btn-info" role="button">Edit appointment</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

        </div>
    </jsp:body>
</t:template>