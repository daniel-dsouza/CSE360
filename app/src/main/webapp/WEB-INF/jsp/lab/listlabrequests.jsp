<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <jsp:attribute name="head">

    </jsp:attribute>

  <jsp:body>
      <div class="container-fluid" id="target">
          <div class="row" style="margin: 5px">
              <h1>Start a Test</h1>
          </div>
          <div class="row" style="margin: 10px">
              <c:forEach var="request" items="${list}">
                  <div class="col-lg-12" style="border-bottom-style: solid; border-width: 1px">
                      <div style="float: left; padding: 5px 5px 5px"> #${request.requestionID}</div>
                      <div style="float: right; padding: 5px 5px 5px">
                          <a href="${pageContext.request.contextPath}/request_test/${request.requestionID}/view" class="btn btn-info" role="button">View</a>
                      </div>
                      <div style="float: right; padding: 5px 5px 5px">
                          <a href="${pageContext.request.contextPath}/lab_report/${request.requestionID}/create" class="btn btn-info" role="button">Create</a>
                      </div>
                  </div>
              </c:forEach>
          </div>
      </div>
  </jsp:body>
</t:template>