<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <jsp:body>

        <h2 style="text-align: center;">
            HSP: New Staff Member
        </h2>
        <c:if test="${not empty errorMessage}">
           <script>
               alert("${errorMessage}");
               window.location.href = "/user/";
           </script>
        </c:if>
        <!-- used http://bootsnipp.com/snippets/featured/styled-table -->
        <form:form action="" method="post" commandName="userInput" onsubmit="return checkFormRegistration()"
                   name="test"> <!-- action="<name>" <!-- this does /registration/<name> on POST -->
            <div class="span8">
                <div class="widget-content" style="padding: 0"> <!-- Border around table and Table -->
                    <table class="table" style="margin-bottom: 0;border: none"> <!-- Rows and cols of the table -->
                        <tbody>
                        <tr> <!-- Row 1 -->
                            <td>First Name:<span style="Color: red">*</span></td>
                            <td>
                                <form:input class='form-control' size='4' type='text'
                                            path="firstName" id="firstName"
                                            required="true"/> <!-- name can only be letters -->
                            </td>
                            <td>Last Name:<span style="Color: red">*</span></td>
                            <td>
                                <form:input class='form-control' size='4' type='text' path="lastName"
                                            id="lastName"
                                            required="true"/> <!-- name can only be letters -->
                            </td>
                        </tr>
                        <tr> <!-- Row 2 -->
                            <td>Email:<span style="Color: red">*</span></td>
                            <td>
                                <form:input class='form-control' size='4' type='text' path="email"
                                            id="email"
                                            required="true"/>
                                <!-- must be (any char)@(any two or more char).(any two or more char) to pass -->
                            </td>
                            <td>Title:<span style="Color: red">*</span></td>
                            <td>
                                <form:select id="title" path="schedule" class="form-control" items="${titlelist}"/>

                                <!-- must be (any char)@(any two or more char).(any two or more char) to pass -->
                            </td>

                        </tr>

                        <tr> <!-- Row 3 -->
                            <c:if test="${user.person.occupation == 'hsp'}">
                                <td>Occupation:<span style="Color: red">*</span></td>
                                <td>
                                    <form:select id="occup" path="occupation" class="form-control" items="${occlist}"/>
                                    <br>Current Occupation:
                                    <c:out value="${userInput.occupation}"/>
                                </td>
                            </c:if>
                            <c:if test="${user.person.occupation != 'labstaff'}">
                                <td>Specialty:<span style="Color: red">*</span></td>
                                <td>
                                    <form:select id="special" path="specialty" class="form-control"
                                                 items="${speclist}"/>
                                    <br>Current Specialty:
                                    <c:out value="${userInput.specialty}"/>
                                </td>
                            </c:if>
                        </tr>


                        </tbody>
                    </table>
                    <!-- End of table -->
                </div>
                <!-- End of widget-content -->
                <br/>

                <div class="button_holder" style="text-align: center;">
        <span class="group-btn">
            <input type="submit" value="Register" class="btn btn-primary btn-md"/>
        </span>
                </div>
                <h4 style="Color: black">
                    <span style="Color: red">*</span> Indicates required field
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
        var occ = $("#occup").val();
        var spec = $("#special").val();
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        if ((/(.+)@(.+){2,}\.(.+){2,}/.test(email)) || email == "" || email == null) {
        } else {       //this is copied and pasted from stack overflow
            alert("Please enter a valid email");
            return false;
        }
        if (occ == "List" || occ == null) {
            alert("Please select a occupation");
            return false;
        }
        if (spec == "List" || spec == null) {
            alert("Please select a specialty");
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
