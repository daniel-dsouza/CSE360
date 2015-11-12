<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>

<jsp:attribute name="head">
    <script type="text/javascript" src="/js/selectDoctor.js"></script>
     <script type="text/javascript" src="/js/alerts.js"></script>
        <script type="text/javascript">
            <!--
            $(document).ready(function () {
                loadAlertsHsp('target');
                setInterval("loadAlertsHsp('target')", 19999);
            });
            //-->
        </script>
</jsp:attribute>
    <jsp:body>
        <!--Display list of partial-doctors-->
        <h1>Alerts</h1>

        <div class="container-fluid" id="target" style="overflow:auto;height:150px;width:100%;">

        </div>
        <div class="container-fluid">
            <div style="margin: 20px">
                <!-- Page header -->
                <div class="row">
                    <h1>Select Doctor</h1>
                    <h5>Please select a doctor and create an emergency appointment.</h5>
                </div>
                <div class="row">
                    <div id="accordion" class="panel-group">
                        <c:forEach var="doc" items="${docList}">
                            <div class="panel panel-default">
                                <!--title of sub box-->
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion"
                                           href="#${doc.userID}">Doctor: ${doc.userID}</a>
                                    </h4>
                                </div>
                                <!--options-->
                                <div id="${doc.userID}" class="panel-collapse collapse out">
                                    <div class="panel-body ">
                                        <div class="row">

                                            <div class="col-lg-4">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <h6 class="panel-title">Personal Info</h6>
                                                    </div>
                                                    <div class="panel-body" id="personal_info_${doc.userID}">
                                                        Loading...
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="panel panel-default "
                                                     style="overflow:auto;height:290px;width:100%;">
                                                    <div class="panel-heading">
                                                        <h6 class="panel-title">Appointments</h6>
                                                    </div>
                                                    <div class="panel-body" id="appointments_${doc.userID}">
                                                        Loading...
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>