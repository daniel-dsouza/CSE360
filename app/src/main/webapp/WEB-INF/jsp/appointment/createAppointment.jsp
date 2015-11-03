<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <jsp:attribute name="head">
        <link href="http://jondmiles.com/bootstrap-datepaginator/css/bootstrap.min.css" rel="stylesheet" media="screen"
              type="text/css">
        <link href="http://jondmiles.com/bootstrap-datepaginator/css/bootstrap-datepicker.css" rel="stylesheet"
              media="screen" type="text/css">
        <link href="http://jondmiles.com/bootstrap-datepaginator/css/bootstrap-datepaginator.min.css" rel="stylesheet"
              media="screen" type="text/css">
        <script type="text/javascript" src="http://jondmiles.com/bootstrap-datepaginator/js/moment.min.js"></script>
        <script type="text/javascript"
                src="http://jondmiles.com/bootstrap-datepaginator/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript"
                src="http://jondmiles.com/bootstrap-datepaginator/js/bootstrap-datepaginator.min.js"></script>
        <script type="text/javascript" src="/js/datepaginator.js"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <h2>Create an Appointment</h2>
            <form:form method="post" commandName="appointment" onsubmit="return getDate()">
                <div class="row">
                    <div class="col-md-12">
                        <div class="datepaginator" id="paginator"></div>
                        <form:input style= "display: none" id="day" size="50%" path="date" /><!-- vulnerability. Inspect element and turn delete none. inject symbols to break SQL. Fixed by using getDate()-->
                        <br>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="timeselect">Time</label>

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


                        <div class="row">
                            <c:if test="${user.person.occupation == 'hsp'}">
                            <label class="col-md-4 control-label" for="docID">Doctor ID</label>
                            <form:input id="docID" size='3' path="tempID"
                                        class="readonly" type="number" min="501" max="511" step="1" maxlength="10"
                                        autofocus="autofocus"
                                        required="required"/>
                            </c:if>
                        </div>

                        <div class="button_holder" style="text-align: center;">
                            <span class="group-btn">
                                <input type="submit" value="Create" class="btn btn-primary btn-md"/>
                             </span>
                        </div>

                    </div>

                </div>
            </form:form>

        </div>


    </jsp:body>
</t:template>
