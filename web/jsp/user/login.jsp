<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sirenchen
  Date: 2017/1/12
  Time: PM11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
</head>

<body>

<jsp:include page="../head.jsp"></jsp:include>

<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/user?method=doLogin" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">User Name</label>
        <input type="text" name="username" id="inputEmail" class="form-control" placeholder="User name" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

    </form>

    <c:if test="${not empty requestScope.loginMsg}">
        <div class="alert alert-warning" style="text-align: center">${requestScope.loginMsg}</div>
    </c:if>


</div>


</body>
</html>
