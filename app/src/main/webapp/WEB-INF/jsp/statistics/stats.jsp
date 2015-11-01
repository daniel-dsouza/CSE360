<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <jsp:attribute name="head">
        <script type="text/javascript" src="<c:url value="/webjars/highcharts/4.1.9/highcharts.js" />"></script>
        <script type="text/javascript" src="<c:url value="/webjars/highcharts/4.1.9/modules/exporting.js" />"></script>
        <script type="text/javascript" src="js/displaystats.js"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="container" id="target">
            <div class="row">
                <div id="accordion" class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#patients_per_specialty">
                                Number of Patients per Doctor Speciality</a></h4>
                        </div>

                        <div id="patients_per_specialty" class="panel-collapse collapse out">
                            <div class="panel-body ">
                                <div class="display">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#number_of_alerts">
                                Number of Submitted alerts</a></h4>
                        </div>

                        <div id="number_of_alerts" class="panel-collapse collapse out">
                            <div class="panel-body ">
                                <div class="display">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#new_patients">
                                Number of New Patients</a></h4>
                        </div>

                        <div id="new_patients" class="panel-collapse collapse out">
                            <div class="panel-body ">
                                <div class="display">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#age_groups">
                                Distribution of Age Groups</a></h4>
                        </div>

                        <div id="age_groups" class="panel-collapse collapse out">
                            <div class="panel-body ">
                                <div class="display">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>