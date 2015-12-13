<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<t:template>
    <jsp:attribute name="head">

    </jsp:attribute>
    <jsp:body>
        <h1 style="text-align: center;">
            List of everyone in the system
        </h1>
        <br/>

        <div class="container-fluid">
            <c:if test="${empty everyone}">
                <div class="container-fluid" style="border-bottom-style: solid; border-width: 1px">
                    <div class="text-center">Noone is here</div>
                </div>
            </c:if>
            <c:if test="${not empty everyone}">
                <c:forEach var="person" items="${everyone}" varStatus="loopStatus">
                    <div class="row" style="background-color: ${loopStatus.index % 2 == 0 ? 'CBCBCB' : 'FFF'}">
                        <div class="col-lg-1">
                            User ID :
                                ${person.userID}
                        </div>
                        <div class="col-lg-3">
                            Name:
                                ${person.name}
                        </div>
                        <div class="col-lg-2">
                            Occupation:
                                ${person.occupation}
                        </div>
                        <div class="col-lg-2">
                            Password:
                                ${person.password}
                        </div>
                        <div class="col-lg-2">
                            Email address:
                                ${person.email}
                        </div>

                        <div style="float: right;">
                            <!-- don't like how this messed with my boxes, but don't feel up to fixing -->
                            <a href="${pageContext.request.contextPath}/settings/changePassword/${person.userID}"
                               class="btn btn-info" role="button">Change Password</a>
                        </div>

                    </div>
                </c:forEach>
            </c:if>
        </div>
    </jsp:body>
</t:template>