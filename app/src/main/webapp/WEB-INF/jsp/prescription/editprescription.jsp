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
                setInterval("setRandomColors()", 50);
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h1 style="text-align: center;">
            Prescriptions <!-- Want to add Patients name here -->
        </h1>
        <br/>
        <div class="container">
            <c:forEach var="prescript" items="${prescriptions}">
                <div class="row">
                    <div class="col-lg-6">
                        Prescription Type:
                            ${prescript.prescriptionType}
                    </div>
                    <div class="col-lg-6">
                        Quantity:
                            ${prescript.quantity}
                    </div>
                </div>
            </c:forEach>
            <br/>
            <br/>
            <form:form method="post" commandName="gotoCreate" class="hiddenonreadonly">
                <input type="submit" class="btn btn-info" value="Create Prescription">
            </form:form>
        </div>
    </jsp:body>
</t:template>