<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Shop</title>
</head>
<body>

<div style="display: flex; gap: 50px;">
    <div>
        <h2>Danh sách sản phẩm</h2>

        <c:forEach var="product" items="${products}">
            <div>
                <p>Tên: ${product.name}</p>
                <p>Giá: ${product.price}</p>

                <form action="${pageContext.request.contextPath}/cart/add" method="post">
                    <input type="hidden" name="id" value="${product.id}">
                    <button type="submit">Thêm vào giỏ</button>
                </form>

                <hr>
            </div>
        </c:forEach>
    </div>

    <div>
        <h2>Giỏ hàng</h2>

        <c:forEach var="item" items="${items}">
            <div>
                <p>Tên: ${item.product.name}</p>
                <p>Giá: ${item.product.price}</p>
                <p>Số lượng: ${item.quantity}</p>
                <hr>
            </div>
        </c:forEach>
    </div>

</div>

</body>
</html>