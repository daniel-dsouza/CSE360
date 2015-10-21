<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="navbar" class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/user/${user.person.userID}">IPIMS</a>
  </div>
  <div class="navbar-collapse collapse">
    <ul class="nav navbar-nav">
      <%--<c:forTokens items="${user.actions}" delims="," var="name">--%>
        <%--<li>--%>
          <%--<a href="${pageContext.request.contextPath}/${name}">--%>
            <%--<c:out value="${name}" />--%>
          <%--</a>--%>
        <%--</li>--%>
      <%--</c:forTokens>--%>
      <c:forEach var="item" items="${user.person.genericActions}">
        <li>
          <a href="${pageContext.request.contextPath}/${item.value}">
              <c:out value="${item.key}" />
          </a>
        </li>
      </c:forEach>
      <c:forEach var="item" items="${user.person.agentActions}">
        <li>
          <a href="${pageContext.request.contextPath}/${item.value}">
            <c:out value="${item.key}" />
          </a>
        </li>
      </c:forEach>
    </ul>
  </div>
</div>