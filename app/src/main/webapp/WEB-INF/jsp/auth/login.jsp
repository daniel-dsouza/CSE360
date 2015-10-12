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
        <!-- used http://bootsnipp.com/snippets/featured/simple-login -->
        <form:form name="login" action="login" method="post" commandName="userInput">
            <div class="container">

                <c:if test="${not empty errorMessage}" >
                    <div class="row">
                        <div class="col-md-offset-5 col-md-3" style="background-color: #FF4D4D; text-align: center; border-radius: 4px"; for>
                            <h4><c:out value="${errorMessage}" /></h4>
                        </div>
                    </div>
                </c:if>

                <div class="row">
                    <div class="col-md-offset-5 col-md-3">
                        <div class="form-login">
                            <h4>Please Login</h4>
                            <form:input path="userID" id="userID" class="form-control input-sm chat-input" placeholder="userID" maxlength="10" autofocus="autofocus" />
                            </br>
                            <input:password path="password" id="userPassword" class="form-control input-sm chat-input" placeholder="password" maxlength="40"/>
                            </br>

                            <span class="group-btn">
                                <input type="submit" value="Login" class="btn btn-primary btn-md"/>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:userpage>
