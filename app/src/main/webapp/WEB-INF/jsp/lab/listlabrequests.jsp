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
                <h1>Start a Test</h1>
            </div>
            <c:forEach var="request" items="${list}">
                <div class="row border_row">
                <div class="col-lg-12">
                    <div >
                        <div style="float: left; padding: 5px 5px 5px">
                            <h4>#${request.requestionID}</h4>
                            <h5>for patient #${request.patient.userID}</h5>
                        </div>
                        <div class="btn-group-vertical" style="float: right; padding: 5px 5px 5px">
                            <a href="${pageContext.request.contextPath}/request_test/${request.requestionID}/view"
                               class="btn btn-info" role="button">View</a>
                            <a href="${pageContext.request.contextPath}/lab_report/${request.requestionID}/create"
                               class="btn btn-info" role="button">Create</a>
                        </div>
                    </div>
                </div>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:template>