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
            <div class="row">
                <div class="col-lg-12">
                    <h1>Lab Reports</h1>
                </div>
            </div>
            <c:if test="${empty list}">
                <div class="row">
                    <div class="col-lg-12">
                        <p>No Lab Reports Available</p>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty list}">
                <c:forEach var="test" items="${list}">
                    <div class="row border_row">
                        <div class="col-lg-12">
                            <div style="float: left; padding: 5px 5px 5px">
                                <h4>#${test.requestionID}</h4>
                                <h5>for patient #${test.patient.userID}</h5>
                            </div>
                            <div class="btn-group-vertical" style="float: right; padding: 5px 5px 5px">
                                <a href="${pageContext.request.contextPath}/lab_report/${test.requestionID}/view"
                                   class="btn btn-info" role="button">View</a>
                                <c:if test="${user.person.occupation == 'labstaff'}">
                                    <a href="${pageContext.request.contextPath}/lab_report/${test.requestionID}/edit"
                                       class="btn btn-info" role="button">Edit</a>
                                </c:if>
                                <a href="${pageContext.request.contextPath}/lab_report/${test.requestionID}/print"
                                   class="btn btn-info" role="button">Print</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </jsp:body>
</t:template>
