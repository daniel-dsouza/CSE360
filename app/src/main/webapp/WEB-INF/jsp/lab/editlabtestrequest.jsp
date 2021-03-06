<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <jsp:body>
        <form:form method="post" commandName="request">
            <div class="container-fluid" id="target">
                <div class="row" style="margin: 5px">
                    <h1>Request a Test</h1>
                </div>
                <div class="row" style="margin: 10px">
                    <c:forEach var="test" items="${request.labTestRequestNames}">
                        <div class="col-sm-4">
                            <label class="checkbox">
                                <form:checkbox path="${test.key}" class="readonly"/>
                                <span class="cr"></span>
                                    ${test.value}
                            </label>
                        </div>
                    </c:forEach>
                </div>
            <span class="group-btn hiddenonreadonly" style="margin: 0px 10px 0px">
                <input type="submit" value="Request Test" class="btn btn-primary btn-md"/>
            </span>
            </div>
        </form:form>
    </jsp:body>
</t:template>
