<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register success</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/redirect.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
</head>

<body onload="startCount()">

<jsp:include page="head.jsp"></jsp:include>

<div class="container">

    <div class="alert alert-info">
        <p class="lead">${requestScope.msg}</p>
        <p>Redirecting after <span id="count">5</span> seconds!!!</p>

    </div>

</div>

</body>
</html>