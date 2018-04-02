<%--
  Created by IntelliJ IDEA.
  User: sirenchen
  Date: 2017/1/23
  Time: PM8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product detail</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
</head>
<body>

<jsp:include page="../head.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-md-5">
            <img class="img-thumbnail img-responsive" src="${pageContext.request.contextPath}${product.pimage}">
        </div>


        <div class="col-md-7">
            <div class="page-header">
                <h2>${product.pname}</h2>
            </div>
            <p class="lead"> ${product.pdesc}</p>
            <p>Price: CDN$ <span class="text-primary">${product.price}</span></p>

            <%--add to cart form--%>
            <form action="${pageContext.request.contextPath}/cart?method=addToCart" method="post"
                  class="form-inline" style="margin-top: 30px">

                <div class="input-group">
                    <div class="input-group-addon">Quantity</div>
                    <input name="quantity" type="number" class="form-control text-right" value="1">
                </div>

                <button type="submit" class="btn btn-primary">Add to Cart</button>
                <input type="hidden" name="pid" value="${product.pid}">
            </form>

        </div>
    </div>
</div>

</body>
</html>
