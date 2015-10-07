<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="navbar" class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="index">IPIMS</a>
  </div>
  <div class="navbar-collapse collapse">
    <ul class="nav navbar-nav">
      <li><a href="../../../"> Home </a></li>
      <c:forTokens items="Zara,nuha,login,navbar,login" delims="," var="name">
        <li>
          <a href="${pageContext.request.contextPath}/${name}">
            Page: <c:out value="${name}" />
          </a>
        </li>
      </c:forTokens>
    </ul>
  </div>
</div>