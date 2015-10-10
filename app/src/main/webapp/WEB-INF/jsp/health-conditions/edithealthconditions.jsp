<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:userpage>
    <jsp:attribute name="nav">
        <jsp:include page="/WEB-INF/jsp/generic/navbar.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <jsp:include page="../generic/footer.jsp"/>
    </jsp:attribute>
  <jsp:body> hi
<%--    <form:form method="POST" commandName="healthConditions">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-4">
            Ankle Pain
          </div>
          <div class="col-lg-4">
            <form:checkbox path="anklePain" />
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4">
            Anxiety
          </div>
          <div class="col-lg-4">
            <form:checkbox path="anxiety" />
          </div>
        </div>
        <div class="row">
          <span class="group-btn">
              <input type="submit" value="Login" class="btn btn-primary btn-md"/>
          </span>
        </div>
      </div>
    </form:form>--%>
  </jsp:body>
</t:userpage>
