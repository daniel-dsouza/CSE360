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
    <form:form action="registration" method="post" commandName="userInput">
        <div class="container-fluid">
            <div class="span8">
                <form:input class='form-control' size='4' type='text' path="firstName" />
                <br/>
                <div class="button_holder" style="text-align: center;">
                    <span class="group-btn">
                        <input type="submit" value="Next" class="btn btn-primary btn-md"/>
                    </span>
                </div>
            </div>
        </div>
    </form:form>
  </jsp:body>
</t:userpage>