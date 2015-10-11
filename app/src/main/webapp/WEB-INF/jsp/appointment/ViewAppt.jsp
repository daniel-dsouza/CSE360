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
        <h1>Appointments</h1> <br><br>
        <div class = "container">
            <u1 class = "list-inline">
                <li style="margin-left: 10px;">Patient: Rie Hinze</li>     <!-- Displays patient name if HSP is editing, optional for Patient (DIFFERENT FROM MOCKUP) -->
                <li>10/12/15</li>
                <li>9:00 AM</li>
                <li>Doctor: Dr. Stephanie Bui</li>
                <li>Reason: Headache</li>
            </u1>
        </div>
        <hr size = 7>
        <div class = "container">
            <u1 class = "list-inline">
                <li style="margin-left: 10px;">Patient: Bob shmo</li>
                <li>10/13/15</li>
                <li>10:30 AM</li>
                <li>Dr. Ryan Ang</li>
                <li>Reason: Insomnia</li>
            </u1>
        </div>

    </jsp:body>
</t:userpage>
