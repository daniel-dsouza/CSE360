<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="nav" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href="<c:url value="/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />"/>
    <script type="text/javascript" src="<c:url value="${}/webjars/jquery/2.1.4/jquery.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</head>

<body>
<div id="nav">
    <jsp:invoke fragment="nav"/>
</div>
<div id="body">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
</body>
</html>