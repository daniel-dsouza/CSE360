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

    <div class="row">
      <div class="col-lg-12">
        <h1>${createoredit} Lab Report</h1>
      </div>
    </div>

    <form:form method="post" commandName="report">
      <c:forEach var="test" items="${report.labTestNames}">
        <div class="row">
          <div class="col-lg-12">
            <div>Test: ${test.value}</div>
            <br/>
            <div>
              <form:textarea path="${test.key}" rows="5" />
            </div>
          </div>
        </div>
      </c:forEach>

      <div class="row">
        <input type="submit" class="btn btn-info" value="Submit Lab Test">
      </div>
    </form:form>
  </div>
</jsp:body>
</t:template>