<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
  <jsp:attribute name="head">
          </jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
            <div class="jumbotron" style="background-color: deepskyblue">
                <h1>Welcome <c:out value="${user.person.firstName}"/> <c:out value="${user.person.lastName}"/> to the
                    IPIMS</h1>

                <p>Circle of Health</p>
            </div>

        </div>
    </jsp:body>
</t:template>


