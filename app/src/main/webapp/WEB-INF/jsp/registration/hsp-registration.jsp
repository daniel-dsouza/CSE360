<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
  <jsp:body>
    <h2 style="text-align: center;">
      HSP: New Patient
    </h2>
    <!-- used http://bootsnipp.com/snippets/featured/styled-table -->
    <form:form action="page1" method="post" commandName="userInput" onsubmit="return checkFormRegistration()" name="test"> <!-- action="<name>" <!-- this does /registration/<name> on POST -->
      <div class="span8">
        <div class="widget-content" style="padding: 0"> <!-- Border around table and Table -->
          <table class="table" style="margin-bottom: 0;border: none"> <!-- Rows and cols of the table -->
            <tbody>
            <tr> <!-- Row 1 -->
              <td>First Name:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.firstName" id="firstName"
                            required="true"/> <!-- name can only be letters -->
              </td>
              <td>Last Name:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.lastName" id="lastName"
                            required="true"/> <!-- name can only be letters -->
              </td>
            </tr>
            <tr> <!-- Row 2 -->
              <td>Age:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.age" id="age"
                            required="true"/> <!-- age must be a number -->
              </td>
              <td>Address:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.address"
                            required="true"/> <!-- only checked to see if it is empty -->
              </td>
            </tr>
            <tr> <!-- Row 3 -->
              <td>City:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.city" required="true"/>
                <!-- only checked to see if it is empty -->
              </td>
              <td>State:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.state" required="true"/>
                <!-- only checked to see if it is empty -->
              </td>
            </tr>
            <tr> <!-- Row 4 -->
              <td>Zipcode:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.zipcode" id="zipcode"
                            required="true"/> <!-- must be of form ##### or #####-#### to pass -->
              </td>
              <td>Phone Number:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.homePhone" id="phone"
                            required="true"/> <!-- must be of form (###)-###-#### -->
              </td>
            </tr>
            <tr> <!-- Row 5 -->
              <td>Email:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.email" id="email"
                            required="true"/>
                <!-- must be (any char)@(any two or more char).(any two or more char) to pass -->
              </td>
              <td>Insurance:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.insurance"
                            required="true"/> <!-- only checked to see if it is empty -->
              </td>
            </tr>
            <tr> <!-- Row 6 -->
              <td>Social Security #:<span style = "Color: red">*</span></td>
              <td>
                <form:input class='form-control' size='4' type='text' path="patientInformation.ssn" id="ssn"
                            required="true"/> <!-- must be ###-##-#### -->
              </td>
              <td>Gender:<span style = "Color: red">*</span></td>
              <td>
                <form:select path="patientInformation.gender" class="selectpicker"
                             id="gender"> <!-- one of the other options than "select one" must be selected -->
                  <option>select one</option>
                  <option>Male</option>
                  <option>Female</option>
                </form:select>
              </td>
            </tbody>
          </table>
          <!-- End of table -->
        </div>
        <!-- End of widget-content -->
        <br/>

                <div class="button_holder" style="text-align: center;">
        <span class="group-btn">
            <input type="submit" value="Next" class="btn btn-primary btn-md"/>
        </span>
        </div>
        <h4 style="Color: black">
          <span style = "Color: red">*</span> Indicates required field
        </h4>
      </div>
      <!-- /widget -->
    </form:form>
  </jsp:body>
</t:template>


<!-- http://stackoverflow.com/questions/16134733/html-javascript-simple-form-validation-on-submit -->
<script>
    function checkFormRegistration() {
        var email = $("#email").val();
        var gender = $("#gender").val();
        var zipcode = $("#zipcode").val();
        var phone = $("#phone").val();
        var ssn = $("#ssn").val();
        var age = $("#age").val();
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        if ((/(.+)@(.+){2,}\.(.+){2,}/.test(email)) || email == "" || email == null) {
        } else {       //this is copied and pasted from stack overflow
            alert("Please enter a valid email");
            return false;
        }
        if (gender == "select one" || gender == null) {
            alert("Please select a gender");
            return false;
        }
        if ((/^\d{5}$/.test(zipcode)) || (/^\d{5}-\d{4}$/.test(zipcode))) {
        } else { // && !/^(.+){6}/.test(zipcode) //  && !/^\d{6}/.test(zipcode) && !/-\d{5}$/.test(zipcode) Just added $ ^ and it worked. Yeah. Removed stuff and it still worked
            alert("Please enter a valid zipcode.\nEither ##### or #####-####");
            return false;
        }
        if (/^\(\d{3}\)-\d{3}-\d{4}$/.test(phone)) {
        } else {
            alert("Please enter a valid phone number.\n(###)-###-####");
            return false;
        }
        if (/^\d{3}-\d{2}-\d{4}$/.test(ssn)) {
        } else {
            alert("Please enter a valid social security number.\n###-##-####");
            return false;
        }
        if (/^\d{1,}$/.test(age)) {
            if (age > 150) {
                alert("Please enter an age under 150.");
            }
        } else {
            alert("Please enter a number for age.");
            return false;
        }
        if (/^[a-zA-Z]{1,}$/.test(firstName)) {
        } else {
            alert("Please make sure your first name only contains letters");
            return false;
        }
        if (/^[a-zA-Z]{1,}$/.test(lastName)) {
        } else {
            alert("Please make sure your last name only contains letters");
            return false;
        }
        return true;
    }
</script>
