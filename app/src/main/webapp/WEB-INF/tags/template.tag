<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="head" fragment="true" %>

<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href="<c:url value="/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />"/>
    <link href="/css/global.css" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="/webjars/jquery/3.0.0-alpha1/jquery.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="/js/maxlength.js"></script>
    <c:if test="${readonly}" >
        <script type="text/javascript" src="/js/readonly.js "></script>
    </c:if>
    <script type="text/javascript" src="/js/colors.js"></script>
    <jsp:invoke fragment="head"/>
</head>

<body>
<div id="page">
    <div id="nav">
        <jsp:directive.include file="navbar.jspf"/>
    </div>
    <div id="body">
        <jsp:doBody/>
    </div>
    <div id="pagefooter">
        <jsp:directive.include file="footer.jspf"/>
    </div>
</div>
</body>
</html>