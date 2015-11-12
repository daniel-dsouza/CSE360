<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <jsp:attribute name="head">
        <script type="text/javascript" src="js/alerts.js"></script>
        <script type="text/javascript">
            <!--
            $(document).ready(function () {
                loadAlerts('target');
                setInterval("loadAlerts('target')", 16666);
            });
            //-->
        </script>
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid" id="target">

        </div>
    </jsp:body>
</t:template>
