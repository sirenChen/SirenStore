<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <title>order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
</head>

<body>

<jsp:include page="../head.jsp"></jsp:include>

<div class="container">

    <c:if test="${sessionScope.user.state == 0}">
        <div class="alert alert-warning">You are not active yet, please check you email to active your account!!</div>
    </c:if>

    <div class="page-header">
        <h3>Order Details</h3>
    </div>

    <div class="row">
        <div class="col-md-4">
            Order ID: <p>${order.oid}</p>
        </div>

        <div class="col-md-4">
            Order time: <p>${order.orderTime}</p>
        </div>

        <div class="col-md-4">
            Order state: <p>${order.state == 0 ? 'pending':'done'}</p>
        </div>

    </div>

    <table class="table table-bordered">
        <thead>
            <tr>
                <td>Product</td>
                <td>Quantity</td>
                <td>Sub Total</td>
            </tr>
        </thead>

        <tbody>
        <c:forEach items="${order.orderItems}" var="orderItem">

            <tr>
                <td>${orderItem.product.pname}</td>
                <td>${orderItem.quantity}</td>
                <td>${orderItem.subtotal}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <div class="row">
        <div class="col-md-2 col-md-offset-9 lead">
            Total CAD$ ${order.total}
        </div>
    </div>

</div>

<div class="container">

    <div class="page-header">
        <h3>Shipping Information</h3>
    </div>

    <c:if test="${order.state == 0}">
        <form class="form-inline" action="${pageContext.request.contextPath}/order?method=placeOrder" method="post">
            <div class="form-group">
                <input name="receiverName" type="text" class="form-control" placeholder="name">
            </div>

            <div class="form-group">
                <input name="receiverAdd" type="text" class="form-control" placeholder="address">
            </div>

            <div class="form-group">
                <input name="receiverPhone" type="text" class="form-control" placeholder="phone">
            </div>

            <button class="btn btn-primary">Place Order</button>

            <input type="hidden" value="${order.oid}" name="oid">
        </form>
    </c:if>

    <c:if test="${order.state == 1}">
        <div class="col-md-4">
            Name: <p>${order.receiverName}</p>
        </div>

        <div class="col-md-4">
            Address: <p>${order.receiverAdd}</p>
        </div>

        <div class="col-md-4">
            Phone: <p>${order.receiverPhone}</p>
        </div>
    </c:if>

</div>



</body>

</html>
