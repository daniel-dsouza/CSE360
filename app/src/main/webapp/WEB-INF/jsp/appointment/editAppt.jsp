<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <jsp:attribute name="head">
        <link href="/css/datepaginator/bootstrap-datepicker.css" rel="stylesheet" media="screen">
        <link href="/css/datepaginator/bootstrap-datepaginator.css" rel="stylesheet" media="screen">

        <script type="text/javascript" src="/js/datepaginator/jQuery.js"></script> <!-- forward declaration like in c++. call JQuery and moment first -->
        <script type="text/javascript" src="/js/datepaginator/moment.js"></script>
        <script type="text/javascript" src="/js/datepaginator/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="/js/datepaginator/bootstrap-datepaginator.js"></script>
        <script type="text/javascript" src="/js/datepaginator/datepaginator.js"></script>

        <!-- ADDED -->
        <script type="text/javascript" src="/js/appointments.js"></script>


    </jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
        <h2>Edit Appointment</h2>


        <form:form method="post" commandName="appointment" onsubmit="return getDate()">

            <!-- ADDED -->
            <div class="container-fluid"> <!-- don't forget your bootstrap html. do the basic tutorial... -->
            <div class="row">
                <div class="form-class" style="padding-bottom: 10px;">
                    <br>
                    <label class="col-md-4 control-label" for="special">Specialty:</label>

                    <div class="col-md-6">
                        <!-- method is what do when done, commandName is what object from the model to put stuff into, action should be the name of your jsp. -->
                        <form:select id="special" path="doctorSpec" items="${speclist}"
                                     onchange="loadDoctors()"/><br>Current Specialty: <c:out
                            value="${appointment.doctor.specialty}"/><br/>
                    </div>
                </div>
                <!-- path is where in the object specified by command name to store the result, a get method for Java. items is the list of results -->
                <!-- Doctor: -->

                <!-- id is how jquery get the element. -->
                <div class="form-class" style="padding-bottom: 10px;">
                    <br><br>
                    <label class="col-md-4 control-label" for="doctor">Doctor:</label>

                    <div class="col-md-6">
                        <form:select id="doctor" path="tempDocID" items="${doctorlist}"/><br>Current Doctor:
                        <c:out
                                value="${appointment.doctor.firstName}"/> <br/>
                    </div>
                    <br><br><br>
                </div>
            </div>


            <c:if test="${appointment.failedToInsert == 1}">
                <script>
                    alert("That time and day is occupied. Please select a different time or day."); </script>
                Occupied Times for: <c:out value="${appointment.doctor.firstName}"/>
                <br>
                <br>

                <div style="overflow:scroll;height:80px;width:100%;overflow:auto">

                    <table width="800" border="0" class="my-table">
                        <tr>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Date</th>
                            <th>Time</th>
                        </tr>
                        <tr>
                            <c:forEach var="test" items="${list}" varStatus="loop">
                            <c:if test="${not loop.first and loop.index % 4 == 0}">
                        </tr>
                        <!-- http://stackoverflow.com/questions/15551599/how-to-break-and-display-one-arraylist-into-multiple-table-columns -->
                        <tr>
                            </c:if>

                            <td style="border-left: 1px solid cyan; padding: 5px;">
                                <c:out value="${test.date}"/>
                            </td>
                            <td>
                                <c:out value="${test.time}"/>
                            </td>

                            </c:forEach>
                        </tr>
                    </table>
                </div>
                <br><br>

            </c:if>

            <div class="row">
                <div class="col-md-12" style="padding-bottom: 10px;">
                    <div class="datepaginator" id="paginator"></div>
                    <label class="col-md-4 control-label"></label>

                    <div class="col-md-6">
                        Current Date: <c:out value="${appointment.date}"/> <br/>
                    </div>
                    <form:input style= "display: none" id="day" size="50%" path="date" /><!-- vulnerability. Inspect element and turn delete none. inject symbols to break SQL. Fixed by using getDate()-->
                </div>
            </div>

            <div class="row">
                <div class="form-group" style="padding-bottom: 10px;">

                    <br><label class="col-md-4 control-label" for="timeselect">Time:</label>


                    <div class="col-md-6">
                        <form:select id="timeselect" name="timeselect" path="time" class="form-control">
                            <option value="8:00 AM">8:00 AM</option>
                            <option value="9:00 AM">9:00 AM</option>
                            <option value="10:00 AM">10:00 AM</option>
                            <option value="11:00 AM">11:00 AM</option>
                            <option value="12:00 PM">12:00 PM</option>
                            <option value="1:00 PM">1:00 PM</option>
                            <option value="2:00 PM">2:00 PM</option>
                            <option value="3:00 PM">3:00 PM</option>
                            <option value="4:00 PM">4:00 PM</option>
                            <option value="5:00 PM">5:00 PM</option>
                            <option value="6:00 PM">6:00 PM</option>
                            <option value="7:00 PM">7:00 PM</option>
                            <option value="8:00 PM">8:00 PM</option>
                        </form:select>
                        Current Time: <c:out value="${appointment.time}"/> <br/>
                    </div>
                </div>
            </div>
            <div class="row">


                <div class="form-class">

                    <br><br><label class="col-md-4 control-label" for="reason">Reason:</label>

                    <div class="col-md-6">
                        <form:input class='form-control' size='4' type='text' path="reason" id="reason"
                                    required="true"/> <!-- name can only be letters -->

                    </div>

                </div>
                <div class="button_holder" style="text-align: center;">
                    <br><br><br>
                            <span class="group-btn">
                                <input type="submit" value="Edit" class="btn btn-primary btn-md"
                                       style="float:inherit"/>
                             </span>
                </div>


            </div>
        </form:form>

        </div>


    </jsp:body>
</t:template>