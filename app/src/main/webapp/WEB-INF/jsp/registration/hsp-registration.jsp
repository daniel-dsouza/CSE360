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
  <jsp:body>
    <form:form action="registration" method="post" commandName="userInput">
    <div class="span12">
      <div class="widget stacked widget-table action-table">
        <div class="widget-content" style="padding: 0"> <!-- Border around table and Table -->
          <table class="table" style="margin-bottom: 0;border: none"> <!-- Rows and cols of the table -->
            <tbody>
            <tr> <!-- Row 1 -->
              <td>First Name: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="firstName" />
              </td>
              <td>Last Name: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="lastName" />
              </td>
            </tr>
            <tr> <!-- Row 2 -->
              <td>Date of Birth: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="dob" />
              </td>
              <td>Address: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="address" />
              </td>
            </tr>
            <tr> <!-- Row 3 -->
              <td>City: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="city" />
              </td>
              <td>State: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="state" />
              </td>
            </tr>
            <tr> <!-- Row 4 -->
              <td>Zipcode: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="zipcode" />
              </td>
              <td>Home Phone #: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="homePhone" />
              </td>
            </tr>
            <tr> <!-- Row 5 -->
              <td>Email: </td>
              <td>
                <form:input class='form-control' size='4' type='text' path="email" />
              </td>
              <td>Gender: </td>
              <td> <!-- IMPORTANT: Likely should change input type -->
                <form:input class='form-control' size='4' type='text' path="gender" />
              </td>
            </tr>
            </tbody>
          </table> <!-- End of table -->
        </div>
      </div> <!-- End of widget-content -->
      <br/>
      <div class="button_holder" style="text-align: center;">
        <!-- Figure out how to center and if I need to change the "type" -->
        <span class="group-btn">
            <input type="submit" value="Next" class="btn btn-primary btn-md"/>
        </span>
      </div>
    </div> <!-- /widget -->
    </form:form>
  </jsp:body>
</t:userpage>