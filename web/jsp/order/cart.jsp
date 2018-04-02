<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>shopping cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
</head>

<body>
<jsp:include page="../head.jsp"></jsp:include>


<div class="container">

    <div class="page-header">
        <h3>Shopping Cart</h3>
    </div>

    <div class="row">

        <c:if test="${empty cart || cart.totalQuantity == 0}">
            <div class="alert alert-warning">
                Your Shopping Cart is Empty !!!
            </div>
        </c:if>



        <table class="table table-hover" style="text-align: center">
            <thead>
            <tr>
                <td>Product</td>
                <td>Quantity</td>
                <td>Sub Total</td>
                <td>Management</td>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${sessionScope.cart.cartItems}" var="cartItem">
                <tr>
                    <td>${cartItem.product.pname}</td>
                    <td>${cartItem.quantity}</td>
                    <td>${cartItem.subtotal}</td>
                    <td>
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/cart?method=removeFromCart&pid=${cartItem.product.pid}">
                            remove
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>
</div>

<hr>

<div class="container">
    <div class="row">

        <div class="col-md-5 col-lg-offset-7">
                Total Price: <span class="text-danger">CDN$ ${sessionScope.cart.total}</span>
                <a style="margin-left: 20px"
                        class="btn btn-primary" href="${pageContext.request.contextPath}/order?method=genOrder">
                    submit my order
                </a>
        </div>

    </div>
</div>



</body>
</html>
