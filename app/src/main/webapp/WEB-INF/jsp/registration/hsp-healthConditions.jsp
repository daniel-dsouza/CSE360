<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>



<!-- used http://community.sitepoint.com/t/make-all-table-cells-the-same-size/3363/3 -->
<style type="text/css">
  td {
    border-spacing: 0;
    width: 70px;
    margin: 0; padding: 0;
  }
</style>


<t:userpage>
    <jsp:attribute name="nav">
        <jsp:include page="/WEB-INF/jsp/generic/navbar.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <jsp:include page="../generic/footer.jsp"/>
    </jsp:attribute>
  <jsp:body>
    <!-- used http://bootsnipp.com/snippets/featured/animated-radios-amp-checkboxes-nojs -->
    <form:form action="registration" method="post" commandName="userInput">
      <div class="container">
        <div class="col-sm-12">
          <table class="table" style="margin-bottom: 0;border: none">
            <tbody>
              <tr>
                <td>
                  <label class="checkbox">
                    <form:checkbox path="anklePain" />
                    <span class="cr"></span>
                    Ankle Pain
                  </label>
                </td>
                <td>
                  <label class="checkbox">
                    <form:checkbox path="anxiety" />
                    <span class="cr"></span>
                    Anxiety
                  </label>
                </td>
                <td>
                  <label class="checkbox">
                    <form:checkbox path="badBreath" />
                    <span class="cr"></span>
                    Bad Breath
                  </label>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </form:form>
  </jsp:body>
</t:userpage>

