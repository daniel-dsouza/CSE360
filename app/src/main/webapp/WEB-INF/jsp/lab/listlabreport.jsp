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
                <h1>Lab Reports</h1>
            </div>
            <div class="row" style="margin: 10px">
                <c:if test="${empty list}">
                    <div class="container" style="border-bottom-style: solid; border-width: 1px">
                        <div class="text-center">No Lab Reports Available</div>
                    </div>
                </c:if>
                <c:if test="${not empty list}">
                    <c:forEach var="test" items="${list}">
                        <div class="col-lg-12" style="border-bottom-style: solid; border-width: 1px">
                            <div style="float: left; padding: 5px 5px 5px"> #${test.requestionID}</div>
                            <div class="btn-group" style="float: right">
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
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </jsp:body>
</t:template>
