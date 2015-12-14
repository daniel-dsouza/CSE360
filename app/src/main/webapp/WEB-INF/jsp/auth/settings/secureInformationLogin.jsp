<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<t:template>
    <jsp:attribute name="head">
        <script type="text/javascript"
                src="<c:url value="/webjars/jquery-maskedinput/1.4.0/jquery.maskedinput.min.js" />"></script>
         <script type="text/javascript"
                 src="<c:url value="/js/login.js" />"></script>
    </jsp:attribute>

    <jsp:body>
        <!-- used http://bootsnipp.com/snippets/featured/simple-login -->
        <form:form name="login" action="" method="post" commandName="userInput">
            <div class="container-fluid">

                <c:if test="${not empty errorMessage}">
                    <div class="row">
                        <div class="col-md-offset-4 col-md-4"
                             style="background-color: #FF4D4D; text-align: center; border-radius: 4px" ; for>
                            <h4><c:out value="${errorMessage}"/></h4>
                        </div>
                    </div>
                </c:if>
                <div class="row" id="body1">
                    <div class="col-md-offset-4 col-md-4">
                        <div class="custom-login">
                            <h4><c:out value="${infoMessage}"/></h4>
                            <input:password path="password" id="userPassword" class="form-control input-sm chat-input"
                                            placeholder="password" maxlength="40" required="required"
                                            autofocus="autofocus"
                                            onkeypress="capLock(event)"/>
                            <div id="divMayus" style="visibility:hidden">Caps Lock is on.</div>
                            </br>
                            <div style="text-align: center;">
                            <span class="group-btn">
                                <input type="submit" value="Login" class="btn btn-primary btn-md"/>
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
                <script>
                    var url = window.location.href;
                    var lastPart = url.substr(url.lastIndexOf('/') + 1);

                    if (lastPart === "masterPanel") {
                        displayWarning("body1");
                    }
                </script>


            </div>
        </form:form>
    </jsp:body>
</t:template>
