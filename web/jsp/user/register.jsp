<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
    <script type="text/javascript">
        function changeImage () {
            document.getElementById("captcha_img").src = "/captcha?time=" + new Date().getTime();
        }
    </script>
</head>

<body>

<jsp:include page="../head.jsp"></jsp:include>

<div class="container">

    <div class="page-header">
        <h3>Register</h3>
    </div>

    <form action="${pageContext.request.contextPath}/user?method=doRegister" method="post"
          style="max-width: 500px" class="center-block">

        <div class="form-group">
            <label for="username">username</label>
            <input type="text" class="form-control" name="username" id="username" placeholder="username" required/>
        </div>

        <div class="form-group">
            <label for="password">password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="password" required/>
        </div>

        <div class="form-group">
            <label for="re_password">re-password</label>
            <input type="password" class="form-control" name="re_password" id="re_password" placeholder="confirm password" required/>
        </div>

        <div class="form-group">
            <label for="email">email</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="email" required/>
        </div>

        <div class="form-group">
            <label for="phone">phone</label>
            <input type="text" class="form-control" name="phone" id="phone" placeholder="phone number" required/>
        </div>

        <div class="form-group">
            <label>
                <input type="radio" name="gender" value="male" id="gender_male" required> male
            </label>

            <label>
                <input type="radio" name="gender" value="female" id="gender_female" required> female
            </label>
        </div>

        <div class="form-group">
            <label for="birthday">birthday</label>
            <input type="date" class="form-control" name="birthday" id="birthday" placeholder="birthday" required>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <c:if test="${not empty requestScope.registerMsg}">
        <div class="alert alert-warning" style="text-align: center">${requestScope.registerMsg}</div>
    </c:if>

</div>

</body>
</html>
