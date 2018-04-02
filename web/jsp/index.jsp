<%@ page contentType="text/html;charset=UTF-8" language="java" autoFlush="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1, user-scalable=no">
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">
    <title>Siren's Book Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
</head>

<body>

<jsp:include page="head.jsp"></jsp:include>

<main>
    <div class="container product-list">

        <div class="jumbotron">
            <h1>Siren Store </h1>
            <p>This store includes the books I had read, the computers I had used, and the toys that I like. This is a store of my daily life.</p>

            <a class="btn btn-primary" href="https://github.com/sirenChen/SirenStore">Source Code</a>
        </div>


        <%--<div class="row">--%>
            <%--<h3>New Item</h3>--%>

            <%--<c:forEach items="${newList}" var="newItem">--%>
                <%----%>
                <%--<div class="col-md-3">--%>
                    <%--<img class="img-thumbnail img-responsive" src="${pageContext.request.contextPath}${newItem.pimage}">--%>
                    <%--<h3>${newItem.pname}</h3>--%>
                    <%--<p style="text-overflow: ellipsis; overflow: hidden; margin-bottom: 10px">--%>
                        <%--<nobr>${newItem.pdesc}</nobr>--%>
                    <%--</p>--%>
                    <%--<p>--%>
                        <%--<a href="${pageContext.request.contextPath}/product?method=showProductInfo&pid=${newItem.pid}"--%>
                           <%--class="btn btn-primary" role="button">Detail</a>--%>
                    <%--</p>--%>
                <%--</div>--%>

            <%--</c:forEach>--%>
        <%--</div>--%>

        <%--<hr>--%>

        <div class="row">
            <h3>Hot Item</h3>

            <c:forEach items="${hotList}" var="hotItem">
                <div class="col-md-3">
                    <img class="img-thumbnail img-responsive" src="${pageContext.request.contextPath}${hotItem.pimage}">
                    <h3 style="text-overflow: ellipsis; overflow: hidden;"><nobr>${hotItem.pname}</nobr></h3>
                    <p style="text-overflow: ellipsis; overflow: hidden; margin-bottom: 10px">
                        <nobr>${hotItem.pdesc}</nobr>
                    </p>
                    <p>
                        <a href="${pageContext.request.contextPath}/product?method=showProductInfo&pid=${hotItem.pid}"
                           class="btn btn-primary" role="button">Detail</a>
                    </p>
                </div>
            </c:forEach>
        </div>


    </div>
</main>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
