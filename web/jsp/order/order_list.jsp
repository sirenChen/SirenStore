<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>order list</title>
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
        <h3>${sessionScope.user.username}'s Orders</h3>
    </div>


    <c:forEach items="${page.list}" var="order">
        <div class="panel ${order.state == 0 ? 'panel-danger':'panel-success'}">
            <div class="panel-heading clearfix">
                ${order.oid}
                <a class="btn btn-primary pull-right" href="${pageContext.request.contextPath}/order?method=showOrderInfo&oid=${order.oid}">Detail</a>
            </div>

            <table class="table">
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
        </div>

    </c:forEach>
</div>



</body>

</html>
