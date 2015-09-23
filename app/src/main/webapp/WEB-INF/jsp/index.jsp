<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 9/18/15
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Static</title>
  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <link rel='stylesheet' href='webjars/bootstrap/3.3.5/css/bootstrap.min.css'>
</head>
<body>

<div id="navbar" class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse"
            data-target=".navbar-collapse">
      <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
    </button>
    <a class="navbar-brand"
       href="https://github.com/spring-projects/spring-boot"> Spring Boot
    </a>
  </div>
  <div class="navbar-collapse collapse">
    <ul class="nav navbar-nav">
      <li><a href="../../"> Home </a></li>
    </ul>
  </div>
</div>
<div class="jumbotron">
  <h1>Home</h1>
  <p>Some static content</p>
  <p>
    <a class="btn btn-lg btn-primary" href="#navbar" role="button">Go &raquo;</a>
  </p>
</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
</body>
</html>
