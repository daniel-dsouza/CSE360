<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="head" fragment="true" %>
<%@attribute name="nav" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href="<c:url value="/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />"/>
    <link href="/css/global.css" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="/webjars/jquery/3.0.0-alpha1/jquery.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="/js/maxlength.js"></script>
    <jsp:invoke fragment="head"/>
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
