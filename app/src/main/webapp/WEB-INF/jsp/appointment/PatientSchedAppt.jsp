<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:userpage>
    <jsp:attribute name="head">
        <script type="text/javascript">
            <!--
            function loadDoctors() {
                $.ajax('/appointment/getdoctors/' + $("#special").val(), {
                    type:'GET',
                    dataType:'json',
                    success:function(data) {
                        var outputHTML = '<option value="">List of Doctors</option>';
                        var len = data.length;
                        for (var i = 0; i < len; i++) {
                            outputHTML += '<option value="' + data[i].name + '">' + data[i].name + '</option>';
                        }
                        outputHTML += '</option>';

                        $('#doctor').html(outputHTML)
                    },
                    error: function() {

                        alert("error getting list.")
                    }
                })
            }

            function loadTimes() {
                $.ajax('/appointment/gettimes/' + $("#doctor").val(), {
                    type: 'GET',
                    dataType: 'json',
                    success: function (data) {
                        var outputHTML = '<option value="">List of Times</option>';
                        var len = data.length;
                        for (var i = 0; i < len; i++) {
                            outputHTML += '<option value="' + data[i].appointmentID + '">' + data[i].date + ' ' + data[i].time + '</option>';
                        }
                        outputHTML += '</option>';

                        $('#date').html(outputHTML)
                    },
                    error: function () {
                        alert("error getting list.")
                    }
                })
            }
            //-->
        </script>
    </jsp:attribute>
    <jsp:attribute name="nav">
        <jsp:include page="/WEB-INF/jsp/generic/navbar.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <jsp:include page="../generic/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <div class="container"> <!-- don't forget your bootstrap html. do the basic tutorial... -->
            <div class="row">
                <!-- method is what do when done, commandName is what object from the model to put stuff into, action should be the name of your jsp. -->
                <form:form method="post" commandName="appointment">
                    Specialty:<br/><form:select id="special" path="doctorSpec" items="${speclist}"
                                                onchange="loadDoctors()"/><br/>
                    <!-- path is where in the object specified by command name to store the result, a get method for Java. items is the list of results -->
                    <!-- Doctor: -->

                    <!-- id is how jquery get the element. -->
                    Doctor:<br/><form:select id="doctor" path="doctorName" items="${doctorlist}"
                                             onchange="loadTimes()"/><br/>
                    Time:<br/><form:select id="date" path="appointmentID" items="${dateList}"/><br/>


                    Reason:<br/><form:input path="reason" /><br/>
                    <span class="group-btn">
                        <input type="submit" value="Schedule" class="btn btn-primary btn-md"/>
                    </span>
                </form:form>
            </div>
        </div>

    </jsp:body>
</t:userpage>
