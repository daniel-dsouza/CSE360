<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<t:userpage>
    <jsp:attribute name="head">
        <script type="text/javascript">
          <!--

          function loadDoctors() {
              $.ajax('/alert/getalerts/' + 'nom', {
                  type:'GET',
                  dataType:'json',
                  success:function(data) {
                      var outputHTML = 'Alert list';
                      var len = data.length;
                      for (var i = 0; i < len; i++) {
                          outputHTML +=
                                  '<div style="background-color: #FF6666; border-radius: 5px; margin: 10px; padding: 10px">' +
                                    '<div class="row" data-toggle="collapse" data-target="#' + i +' ">' +
                                        '<div class="col-lg-8">'+
                                            '<div style="float:left"><h2>Patient#: ' + data[i].patientID + '</h2><h5 style="padding: 0px 5px 0px;">' + data[i].alertDateAndTime+ '</h5></div>' +
                                            '<div style="float:left; padding: 20px 0px 10px 10px; width=100%">' +
                                                '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Expand Detail' + '</button>' +
                                                '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Health Conditions' + '</button>' +
                                                '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Medical History' + '</button>' +
                                                '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Labs' + '</button>' +
                                                '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Prescriptions' + '</button>' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>' +
                                    '<div class="row collapse out" style="margin: 0px 5px 10px" id="' + i + '">' + data[i].reason + '</div>' +
                                  '</div>';
                      }
                      $('#target').html(outputHTML)
                  },
                  error: function() {
                      alert("error getting list.")
                  }
              })
          };
          $(document).ready(loadDoctors());
          window.setInterval(loadDoctors(), 60000);
          //-->
        </script>
    </jsp:attribute>

    <jsp:attribute name="nav">
        <jsp:include page="/WEB-INF/jsp/generic/navbar.jsp"/>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <jsp:include page="../generic/footer.jsp"/>
    </jsp:attribute>

  <jsp:body>
    <div class="container-fluid" id="target">
        <div class="row">
            <div class="col-lg-8">
                <h1>Stephanie Bui</h1>
            </div>
            <div class="col-lg-4">
                <button type="button" class="btn btn-primary btn-md" >
                    herp
                </button>
                <button type="button" class="btn btn-primary btn-md" >
                    derp
                </button>
            </div>
            <div class="row collapse out" id="demo">
                incididunt ut labore et dolore magna aliqua.
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
                nisi ut aliquip ex ea commodo consequat.
            </div>
        </div>
    </div>
  </jsp:body>
</t:userpage>
