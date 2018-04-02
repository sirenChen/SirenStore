<%--
  Created by IntelliJ IDEA.
  User: sirenchen
  Date: 2017/2/4
  Time: PM7:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
</head>
<body>

<jsp:include page="head.jsp"></jsp:include>

<div class="container">

    <div class="alert alert-danger">
        <p class="lead">Sorry, Server are encountering a problem !!</p>
    </div>

</div>

</body>
</html>
