<%@ include file="header.jsp" %>

<!-- used http://bootsnipp.com/snippets/featured/simple-login -->
<div class="container">
    <form:form action="login" method="post" commandName="userInput">
        <div class="row">
            <div class="col-md-offset-5 col-md-3">
                <div class="form-login">
                    <h4>Please Login</h4>
                    <form:input path="username" id="userName" class="form-control input-sm chat-input" placeholder="username" />
                    </br>
                    <input:password path="password" id="userPassword" class="form-control input-sm chat-input" placeholder="password" />
                    </br>
                    <div class="wrapper">
                        <span class="group-btn">
                            <input type="submit" value="Register" class="btn btn-primary btn-md"/>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>

</body>
</html>
