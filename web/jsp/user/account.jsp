<%--
  Created by IntelliJ IDEA.
  User: sirenchen
  Date: 2017/1/14
  Time: PM12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.user.username}'s account</title>
</head>

<body>

<p>${sessionScope.user.username}'s account</p>

<a href="updatePsw.jsp">update my information</a>

</body>
</html>
