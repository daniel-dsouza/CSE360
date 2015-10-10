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
    <!-- used http://bootsnipp.com/snippets/featured/styled-table -->
    <form:form action="page1" method="post" commandName="userInput"> <!-- action="<name>" <!-- this does /registration/<name> on POST -->
    <div class="span8">
      <div class="widget-content" style="padding: 0"> <!-- Border around table and Table -->
        <table class="table" style="margin-bottom: 0;border: none"> <!-- Rows and cols of the table -->
          <tbody>
          <tr> <!-- Row 1 -->
            <td>First Name: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="firstName" required="true" />
            </td>
            <td>Last Name: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="lastName" required="true" />
            </td>
          </tr>
          <tr> <!-- Row 2 -->
            <td>Date of Birth: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="dob" required="true" />
            </td>
            <td>Address: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="address" required="true" />
            </td>
          </tr>
          <tr> <!-- Row 3 -->
            <td>City: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="city" required="true" />
            </td>
            <td>State: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="state" required="true" />
            </td>
          </tr>
          <tr> <!-- Row 4 -->
            <td>Zipcode: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="zipcode" required="true" />
            </td>
            <td>Home Phone #: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="homePhone" required="true" />
            </td>
          </tr>
          <tr> <!-- Row 5 -->
            <td>Email: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="email" required="true" />
            </td>
            <td>Insurance: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="insurance" required="true" />
            </td>
          </tr>
          <tr> <!-- Row 6 -->
            <td>Social Security #: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="ssn" required="true" />
            </td>
            <td>Age: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="age" required="true" />
            </td>
          </tr>
          <tr>  <!-- Row 7 -->
            <td>Gender: </td>
            <td>
              <form:select path="gender" class="selectpicker" > <!-- need to come up with a way to check this input -->
                <option>select one</option>
                <option>Male</option>
                <option>Female</option>
              </form:select>
            </td>
            <td></td>
            <td></td>
          </tr>
          </tbody>
        </table> <!-- End of table -->
      </div> <!-- End of widget-content -->
      <br/>
      <div class="button_holder" style="text-align: center;">
        <span class="group-btn">
            <input type="submit" value="Next" class="btn btn-primary btn-md"/>
        </span>
      </div>
    </div> <!-- /widget -->
    </form:form>
  </jsp:body>
</t:userpage>