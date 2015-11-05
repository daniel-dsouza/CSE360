<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
  <jsp:attribute name="head">
      <link href="/css/dropdown.css" rel="stylesheet" media="screen">
      <script type="text/javascript">
          <!--
          $(document).ready(function () {
              showEmergencyRoom('alert');
          });
          //-->
      </script>
          </jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
            <div class="jumbotron" style="background-color: deepskyblue">
                <h1>Welcome <c:out value="${user.person.firstName}"/> <c:out value="${user.person.lastName}"/> to the
                    IPIMS</h1>

                <div class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Circle of Health</a>
                    <ul class="dropdown-menu">
                        <li>It means no worries</li>
                        <li>for the rest of your days.</li>
                        <li>It's a problem free</li>
                        <li>philosophy</li>
                        <!-- <li>&copy; Disney. No copyright infringement intended</li> -->
                    </ul>

                </div>

            </div>

        </div>
    </jsp:body>
</t:template>


