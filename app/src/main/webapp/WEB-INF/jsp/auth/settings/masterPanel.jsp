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
                <div class="container-fluid" style="border-bottom-style: solid; border-width: 1px">
                    <div class="col-sm-1 col-sm-offset-.5">User ID</div>
                    <div class="col-sm-3">Name</div>
                    <div class="col-sm-1">Occupation</div>
                    <div class="col-sm-2">Password</div>
                    <div class="col-sm-3">Email address</div>
                </div>
                <c:forEach var="person" items="${everyone}" varStatus="loopStatus">
                    <div class="row" style="margin: 5px">
                        <div class="container-fluid"
                             style="background-color: ${loopStatus.index % 2 == 0 ? 'CBCBCB' : 'FFF'}; padding-top: 5px; padding-bottom: 5px">
                            <div class="col-sm-1">
                                    ${person.userID}
                            </div>
                            <div class="col-sm-3">
                                    ${person.name}
                            </div>
                            <div class="col-sm-1">
                                    ${person.occupation}
                            </div>
                            <div class="col-sm-2" id="master-password">
                                    ${person.password}
                            </div>
                            <div class="col-sm-3">
                                    ${person.email}
                            </div>
                            <div style="float: right;">
                                <!-- don't like how this messed with my boxes, but don't feel up to fixing -->
                                <a href="${pageContext.request.contextPath}/settings/changePassword/${person.userID}"
                                   class="btn btn-info" role="button">Change Password</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </jsp:body>
</t:template>