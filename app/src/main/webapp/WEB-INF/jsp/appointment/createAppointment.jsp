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
    </jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
            <h2>Create an Appointment</h2>
            <form:form method="post" commandName="appointment" onsubmit="return getDate()">
                <c:if test="${appointment.failedToInsert == 1}">
                    <script>
                        alert("That time and day is occupied. Please select a different time or day."); </script>
                    Occupied Times for Doctor: <c:out value="${appointment.doctorID}"/>
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

                </c:if>

                <div class="row">
                    <div class="col-md-12">
                        <div class="datepaginator" id="paginator"></div>
                        <form:input style= "display: none" id="day" size="50%" path="date" /><!-- vulnerability. Inspect element and turn delete none. inject symbols to break SQL. Fixed by using getDate()-->

                        <br>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="timeselect">Time</label>
                            <br>

                            <div class="col-md-4">
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
                            </div>
                        </div>


                        <div class="form-class">
                            <c:if test="${user.person.occupation == 'hsp'}">
                                <br><label class="col-md-4 control-label" for="docID">Doctor ID</label>

                                <div class="col-md-4">
                                    <form:input id="docID" size='3' path="tempDocID"
                                                class="readonly" type="number" min="501" max="511" step="1"
                                                maxlength="10"
                                                autofocus="autofocus"
                                                required="required"/>
                                </div>
                            </c:if>
                        </div>

                        <div class="button_holder" style="text-align: center;">
                            <br><br>
                            <span class="group-btn">
                                <input type="submit" value="Create" class="btn btn-primary btn-md"
                                       style="float:inherit"/>
                             </span>
                        </div>

                    </div>

                </div>
            </form:form>

        </div>


    </jsp:body>
</t:template>
