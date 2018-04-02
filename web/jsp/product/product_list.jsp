<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>all books</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myCss.css">
</head>

<body>

<jsp:include page="../head.jsp"></jsp:include>

<div class="container product-list">
    <div class="jumbotron">
        <h3>${requestScope.category.cname} </h3>
        <p>${requestScope.category.cdesc}</p>
    </div>

    <%--product list--%>
    <div class="row">
        <c:forEach items="${page.list}" var="product">

            <div class="col-md-3">
                <img class="img-thumbnail img-responsive" src="${pageContext.request.contextPath}${product.pimage}">
                <h3 style="text-overflow: ellipsis; overflow: hidden;"><nobr>${product.pname}</nobr></h3>
                <p style="text-overflow: ellipsis; overflow: hidden; margin-bottom: 10px">
                    <nobr>${product.pdesc}</nobr>
                </p>
                <p>
                    <a href="${pageContext.request.contextPath}/product?method=showProductInfo&pid=${product.pid}"
                       class="btn btn-primary" role="button">Detail</a>
                </p>
            </div>

        </c:forEach>
    </div>

    <%--page number--%>
    <nav aria-label="Page navigation" style="text-align: center">
        <ul class="pagination">
            <li>
                <a href="">&laquo;</a>
            </li>

            <c:forEach begin="${page.curPage-5>0 ? page.curPage-5:1}" end="${page.curPage+4>page.lastPage?page.lastPage:page.curPage+4}" var="n">
                <c:if test="${page.curPage == n}">
                    <li class="active">
                        <a>${n}</a>
                    </li>
                </c:if>

                <c:if test="${page.curPage != n}">
                    <li>
                        <a href="${pageContext.request.contextPath}/product?method=showProductList&curPage=${n}&cid=${param.cid}">${n}</a>
                    </li>
                </c:if>
            </c:forEach>


            <li>
                <a href="">&raquo;</a>
            </li>
        </ul>
    </nav>

    <hr>

    <%--recent visit list--%>
    <div class="row">
        <h3>visit list</h3>

        <c:if test="${empty requestScope.visitList}" >
            <p class="alert alert-info">no recent visit item</p>
        </c:if>


        <p>
            <c:forEach items="${requestScope.visitList}" var="visitProduct">
                <span class="label label-primary">${visitProduct.pname}</span>
            </c:forEach>
        </p>
    </div>

</div>
</body>
</html>
