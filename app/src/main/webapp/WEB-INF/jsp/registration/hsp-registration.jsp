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
    <form:form action="page1" method="post" commandName="userInput" onsubmit="return checkFormRegistration()" name="test"> <!-- action="<name>" <!-- this does /registration/<name> on POST -->
    <div class="span8">
      <div class="widget-content" style="padding: 0"> <!-- Border around table and Table -->
        <table class="table" style="margin-bottom: 0;border: none"> <!-- Rows and cols of the table -->
          <tbody>
          <tr> <!-- Row 1 -->
            <td>First Name: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="firstName" required="true" /> <!-- only checked to see if it is empty -->
            </td>
            <td>Last Name: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="lastName" required="true" /> <!-- only checked to see if it is empty -->
            </td>
          </tr>
          <tr> <!-- Row 2 -->
            <td>Age: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="age" id="age" required="true" /> <!-- age must be a number -->
            </td>
            <td>Address: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="address" required="true" /> <!-- only checked to see if it is empty -->
            </td>
          </tr>
          <tr> <!-- Row 3 -->
            <td>City: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="city" required="true" /> <!-- only checked to see if it is empty -->
            </td>
            <td>State: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="state" required="true" /> <!-- only checked to see if it is empty -->
            </td>
          </tr>
          <tr> <!-- Row 4 -->
            <td>Zipcode: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="zipcode" id="zipcode" required="true" /> <!-- must be of form ##### or #####-#### to pass -->
            </td>
            <td>Home Phone #: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="homePhone" id="phone" required="true" /> <!-- must be of form (###)-###-#### -->
            </td>
          </tr>
          <tr> <!-- Row 5 -->
            <td>Email: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="email" id="email" required="true" /> <!-- must be (any char)@(any two or more char).(any two or more char) to pass -->
            </td>
            <td>Insurance: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="insurance" required="true" /> <!-- only checked to see if it is empty -->
            </td>
          </tr>
          <tr> <!-- Row 6 -->
            <td>Social Security #: </td>
            <td>
              <form:input class='form-control' size='4' type='text' path="ssn" id="ssn" required="true" /> <!-- must be ###-##-#### -->
            </td>
            <td>Gender: </td>
            <td>
              <form:select path="gender" class="selectpicker" name="gender" > <!-- one of the other options than "select one" must be selected -->
                <option>select one</option>
                <option>Male</option>
                <option>Female</option>
              </form:select>
            </td>
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


<!-- http://stackoverflow.com/questions/16134733/html-javascript-simple-form-validation-on-submit -->
<script>
  function checkFormRegistration(){
    var email = $("#email").val();
    var gender = $("#gender").val();
    var zipcode = $("#zipcode").val();
    var phone = $("#phone").val();
    var ssn = $("#ssn").val();
    var age = $("#age").val();
    if ((/(.+)@(.+){2,}\.(.+){2,}/.test(email)) || email=="" || email==null) { } else {       //this is copied and pasted from stack overflow
      alert("Please enter a valid email");
      return false;
    }
    if (gender == "select one"){
      alert("Please select a gender");
      return false;
    }
    if((/^\d{5}$/.test(zipcode)) || (/^\d{5}-\d{4}$/.test(zipcode))){} else { // && !/^(.+){6}/.test(zipcode) //  && !/^\d{6}/.test(zipcode) && !/-\d{5}$/.test(zipcode) Just added $ ^ and it worked. Yeah. Removed stuff and it still worked
      alert("Please enter a valid zipcode.\nEither ##### or #####-####");
      return false;
    }
    if(/^\(\d{3}\)-\d{3}-\d{4}$/.test(phone)){} else{
      alert("Please enter a valid phone number.\n(###)-###-####");
      return false;
    }
    if(/^\d{3}-\d{2}-\d{4}$/.test(ssn)){} else{
      alert("Please enter a valid social security number.\n###-##-####");
      return false;
    }
    if(/^\d{1,}$/.test(age)){} else{
      alert("Please enter a number for age.")
      return false;
    }
    return true;
  }
</script>