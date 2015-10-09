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
        <form:form action="login" method="post" commandName="userInput">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-5 col-md-3" style="background-color: red; text-align: center">
                        <h4><c:out value="${errorMessage}" /></h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-5 col-md-3">
                        <div class="form-login">
                            <h4>Please Login</h4>
                            <form:input path="username" id="userName" class="form-control input-sm chat-input" placeholder="username" />
                            </br>
                            <input:password path="password" id="userPassword" class="form-control input-sm chat-input" placeholder="password" />
                            </br>
                            <div class="wrapper">
                        <span class="group-btn">
                            <input type="submit" value="Login" class="btn btn-primary btn-md"/>
                        </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:userpage>
