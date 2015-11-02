<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<t:template>
    <jsp:attribute name="head">
        <!-- http://stackoverflow.com/a/1484514 -->
        <script type="text/javascript">
            function getRandomColor() {
                var letters = '56789A'.split('');
                var color = '#';
                for (var i = 0; i < 6; i++ ) {
                    color += letters[Math.floor(Math.random() * 6)];
                }
                return color;
            }

            function setRandomColors(){
                $(".row").each(function(){
                    $(this).css("background-color",getRandomColor());
                });
            }

            $( document ).ready(function() {
                setRandomColors();
                //setInterval("setRandomColors()", 50);
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h1 style="text-align: center;">
            Prescriptions for <c:out value="${user.patient.firstName}"/> <c:out value="${user.patient.lastName}"/>
        </h1>
        <br/>
        <div class="container">
            <c:forEach var="prescript" items="${prescriptions}">
                <div class="row">
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
                    <div style="float: right;">     <!-- don't like how this messed with my boxes, but don't feel up to fixing -->
                        <a href="${pageContext.request.contextPath}/prescription/${prescript.prescriptionID}/print" class="btn btn-info" role="button">Print Page</a>
                    </div>
                    </c:if>
                </div>
            </c:forEach>
            <br/>
            <br/>
            <form:form method="post" commandName="gotoCreate" class="hiddenonreadonly" cssStyle="text-align: center">
                <input type="submit" class="btn btn-info" value="Create Prescription">
            </form:form>
        </div>
    </jsp:body>
</t:template>