<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<t:template>
    <jsp:attribute name="head">
        <!-- http://stackoverflow.com/a/1484514 -->
        <script type="text/javascript">
            function getRandomColor() {
                var letters = '56789A'.split('');
                var color = '#';
                for (var i = 0; i < 6; i++) {
                    color += letters[Math.floor(Math.random() * 6)];
                }
                return color;
            }

            function setRandomColors() {
                $(".row").each(function () {
                    $(this).css("background-color", getRandomColor());
                });
            }

            $(document).ready(function () {
                //setRandomColors();
                //setInterval("setRandomColors()", 50);
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h1 style="text-align: center;">
            Prescriptions for <c:out value="${user.patient.firstName}"/> <c:out value="${user.patient.lastName}"/>
        </h1>
        <br/>

        <div class="container-fluid">
            <c:if test="${empty prescriptions}">
                <div class="container" style="border-bottom-style: solid; border-width: 1px">
                    <div class="text-center">No Prescriptions Available</div>
                </div>
            </c:if>
            <c:if test="${not empty prescriptions}">
                <c:forEach var="prescript" items="${prescriptions}" varStatus="loopStatus">
                    <div class="row" style="background-color: ${loopStatus.index % 2 == 0 ? 'CBCBCB' : 'FFF'}">
                        <div class="col-lg-4">
                            Prescription Type:
                                ${prescript.prescriptionType}
                        </div>
                        <div class="col-lg-4">
                            Quantity:
                                ${prescript.quantity}
                        </div>
                        <div class="col-lg-4">
                            Date Prescribed:
                                ${prescript.strDateAndTime}
                        </div>
                        <c:if test="${user.person.occupation == 'doctor'}">
                            <div style="float: right;">
                                <!-- don't like how this messed with my boxes, but don't feel up to fixing -->
                                <a href="${pageContext.request.contextPath}/prescription/${prescript.prescriptionID}/print"
                                   class="btn btn-info" role="button">Print Page</a>
                            </div>
                        </c:if>
                    </div>
                </c:forEach>
            </c:if>
            <br/>
            <br/>
            <form:form method="post" commandName="gotoCreate" class="hiddenonreadonly" cssStyle="text-align: center">
                <input type="submit" class="btn btn-info" value="Create Prescription">
            </form:form>
        </div>
    </jsp:body>
</t:template>