<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/20/2026
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Book List</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
        }

        /* Header */
        .header-bar {
            width: 100%;
            height: 120px;
            padding: 0 40px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #ff7100;
        }

        .store-title {
            padding: 10px 20px;
            color: #fff;
            background-color: rgba(90, 90, 90, 0.6);
            border-radius: 4px;
            font-size: 28px;
            font-weight: bold;
            letter-spacing: 1px;
            text-decoration: none;
        }

        .menu-list {
            display: flex;
            gap: 12px;
            margin: 0;
            padding: 0;
            list-style: none;
        }

        .menu-list a {
            display: block;
            padding: 8px 16px;
            color: #fff;
            background-color: rgba(90, 90, 90, 0.6);
            border-radius: 4px;
            font-size: 13px;
            font-weight: bold;
            text-decoration: none;
            text-transform: uppercase;
        }

        .menu-list a:hover {
            background-color: rgba(60, 60, 60, 0.8);
        }

        /* Main layout */
        .page-wrapper {
            width: 1100px;
            max-width: 95%;
            margin: 20px auto;
            padding: 0 15px;
            display: flex;
            gap: 20px;
        }

        /* Left side */
        .left-panel {
            width: 250px;
            flex-shrink: 0;
        }

        .info-panel {
            padding: 15px;
            margin-bottom: 25px;
            background-color: #e6e6e6;
        }

        .section-heading {
            margin-bottom: 10px;
            color: #777;
            font-size: 14px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .info-panel p {
            color: #555;
            font-size: 12px;
            line-height: 1.4;
        }

        .info-panel a {
            color: #333;
            text-decoration: underline;
        }

        .search-panel {
            padding: 15px;
            background-color: #e6e6e6;
        }

        .search-field {
            width: 100%;
            padding: 5px;
            border: 1px solid #777;
            border-radius: 6px;
            outline: none;
        }

        /* Book list */
        .book-list {
            flex: 1;
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 15px;
        }

        .book-item {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 10px;
            border: 1px solid #333;
            background-color: #fff;
            text-align: center;
        }

        .book-name {
            width: 100%;
            height: 36px;
            margin-bottom: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #666;
            font-size: 13px;
            text-align: center;
        }

        .book-cover {
            width: 140px;
            height: 190px;
            margin-bottom: 10px;
            object-fit: cover;
        }

        .book-data {
            color: #555;
            font-size: 13px;
            line-height: 1.5;
        }

        .book-data a {
            color: #555;
            text-decoration: underline;
        }

        .book-data a:hover {
            color: #000;
        }

        .cart-form {
            margin-top: 5px;
        }

        .cart-button {
            padding: 5px 10px;
            border: 1px solid #555;
            border-radius: 4px;
            background-color: #eee;
            cursor: pointer;
        }

        .cart-button:hover {
            background-color: #ddd;
        }
    </style>
</head>

<body>
<nav class="header-bar">
    <a href="#" class="store-title">IUH BOOKSTORE</a>

    <ul class="menu-list">
        <li><a href="#">HOME</a></li>
        <li>
            <a href="${pageContext.request.contextPath}/cart">Cart</a>
        </li>
        <li><a href="#">SERVICES</a></li>
        <li><a href="#">PRODUCTS</a></li>
        <li><a href="#">CONTACT</a></li>
    </ul>
</nav>

<div class="page-wrapper">
    <aside class="left-panel">
        <div class="info-panel">
            <h3 class="section-heading">ABOUT US</h3>
            <p>
                About us information will be here......
                <a href="#">Read More »</a>
            </p>
        </div>
        <div class="search-panel">
            <h3 class="section-heading">SEARCH SITE</h3>
            <form action="search" method="get">
                <input  type="text" name="keyword" class="search-field" value="${keyword}" />
            </form>
        </div>
    </aside>
    <main class="book-list">
        <c:forEach var="book" items="${books}">
            <div class="book-item">
                <div class="book-name">
                        ${book.title}
                    <c:if test="${not empty book.author}">
                        - Tác giả: ${book.author}
                    </c:if>
                </div>
                <img src="${pageContext.request.contextPath}/images/${book.image}" alt="${book.title}" class="book-cover"/>
                <div class="book-data">
                    <p>Price: ${book.price}</p>
                    <p>Quantity: ${book.quantity}</p>
                    <p>
                        <a href="${pageContext.request.contextPath}/book?id=${book.bookId}">
                            Product details
                        </a>
                    </p>
                    <form action="${pageContext.request.contextPath}/cart" method="post" class="cart-form">
                        <input type="hidden" name="action" value="add"/>
                        <input  type="hidden" name="bookId"  value="${book.bookId}"/>
                        <button type="submit" class="cart-button">
                            Add to cart
                        </button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </main>

</div>

</body>
</html>