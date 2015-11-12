<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:template>
<jsp:attribute name="head">
  <c:if test="${fn:contains(createoreditorview, 'Print')}">
      <script type="text/javascript">
          $(document).ready(function () {
              print();
          });
      </script>
  </c:if>
</jsp:attribute>

    <jsp:body>
        <div class="container-fluid" id="section-to-print">

            <div class="row">
                <div class="col-lg-12">
                    <h1>${createoreditorview} Lab Report #${report.requestionID}</h1>

                    <p>Patient ID: ${report.patient.userID}</p>
                </div>
            </div>

            <form:form method="post" commandName="report">
                <c:forEach var="test" items="${report.labTestNames}">
                    <div class="row">
                        <div class="col-lg-12">
                            <h4>Test: ${test.value}</h4>

                            <div>
                                <form:textarea path="${test.key}" rows="3" class="readonly"/>
                            </div>
                            <br/>
                        </div>
                    </div>
                </c:forEach>

                <div class="row hiddenonreadonly">
                    <div class="col-lg-12">
                        <br/>
                        <input type="submit" class="btn btn-info" value="${createoreditorview} Lab Report">
                    </div>
                </div>

            </form:form>
        </div>

        <style>
            @media print {
                body * {
                    visibility: hidden;
                }

                div#section-to-print * {
                    visibility: visible;
                }

                div#section-to-print {
                    position: absolute;
                    left: 0;
                    top: 0;
                }
            }
        </style>

    </jsp:body>
</t:template>