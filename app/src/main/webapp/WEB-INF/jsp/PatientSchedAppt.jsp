<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 10/7/2015
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
@media (min-width: 979px) {
body {
padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
}
}

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <div class="container">
    <center>
      <h1>New Appointment</h1>
      <br>
      <br>
      <div class="form-group">
        <label for="sel1">Type of Doctor:</label>
        <select class="form-control" id="sel1">
          <option>Foot Doctor</option>
          <option>Emergency Doctor</option>
          <option>General Care Physician</option>
          <option>Pediatrician</option>
        </select>
      </div>

      <div class="form-group">
        <label for="sel1">Doctor:</label>
        <select class="form-control" id="sel1">
          <option>Dr. Ang</option>
          <option>Dr. D'Souza</option>
          <option>Dr. Dudley</option>
          <option>Dr. Hinze</option>
          <option>Dr. Hutchins</option>
          <option>Dr. Lin</option>
          <option>Dr. Romero</option>
          <option>Dr. Rose</option>
          <option>Dr. Venkata</option>
        </select>
      </div>
      <div class="form-group">
        <label for="comment">Comment:</label>
        <textarea class="form-control" rows="5" id="comment"></textarea>
      </div>
    </center>
  </div>
  <!-- /container -->
</head>
<body>

</body>
</html>
