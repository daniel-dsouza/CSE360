<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:userpage>
    <jsp:attribute name="head">
        <script type="text/javascript" src="js/alerts.js"></script>
        <script type="text/javascript">
          <!--
          $(document).ready(function () {
              loadAlerts('target');
              setInterval("loadAlerts('target')", 20000);
          });
          //-->
        </script>
    </jsp:attribute>

    <jsp:attribute name="nav">
        <jsp:include page="/WEB-INF/jsp/generic/navbar.jsp"/>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <jsp:include page="../generic/footer.jsp"/>
    </jsp:attribute>

  <jsp:body>
    <div class="container-fluid" id="target">

    </div>
  </jsp:body>
</t:userpage>
