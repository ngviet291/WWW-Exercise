<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>

    <style>
        .product-class {
            border: 1px solid #ccc;
            width: 250px;
            padding: 15px;
            margin: 10px;
            display: inline-block;
            vertical-align: top;
        }

        .hinh {
            width: 150px;
            height: 150px;
            object-fit: contain;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>

<body>

<p>
    <a href="${pageContext.request.contextPath}/cart">View Cart</a>
</p>

<c:forEach items="${products}" var="p">

    <div class="product-class">

        <b>${p.model}</b>

        <br/>

        <img src="${pageContext.request.contextPath}/images/${p.imgUrl}"
             class="hinh"
             alt="${p.model}">

        <br/>

        Price: ${p.price}

        <br/>

        <form action="${pageContext.request.contextPath}/cart" method="post">

            <input type="text"
                   size="2"
                   value="1"
                   name="quantity">

            <br/>

            <input type="hidden"
                   name="id"
                   value="${p.id}">

            <input type="hidden"
                   name="price"
                   value="${p.price}">

            <input type="hidden"
                   name="model"
                   value="${p.model}">

            <input type="hidden"
                   name="action"
                   value="add">

            <br/>

            <input type="submit"
                   name="addToCart"
                   value="Add To Cart">

            <br/>

        </form>

        <a href="${pageContext.request.contextPath}/product?id=${p.id}">
            Product Detail
        </a>

        <br/>

    </div>

</c:forEach>

</body>
</html>