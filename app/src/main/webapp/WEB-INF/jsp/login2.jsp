<%@ include file="generic/header.jsp" %>
<jsp:include page="generic/navbar.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<div class="container-fluid">
    <div class="jumbotron" style="background-color: deepskyblue">
        <h1>Welcome to the IPIMS</h1>
        <p>We put the 'balling in eyeballing</p>
    </div>
</div>

<!-- used http://bootsnipp.com/snippets/featured/simple-login -->
<form:form action="login" method="post" commandName="userInput">
<div class="container">
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

<%@ include file="generic/footer.jsp" %>
