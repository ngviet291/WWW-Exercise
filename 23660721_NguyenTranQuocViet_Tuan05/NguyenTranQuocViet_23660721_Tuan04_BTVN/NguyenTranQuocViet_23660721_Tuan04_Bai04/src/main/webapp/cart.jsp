<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/20/2026
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Your Shopping Cart</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            color: #333;
        }

        /* Header */
        .top-header {
            width: 100%;
            height: 100px;
            padding: 0 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #7a6a58;
            background-size: cover;
        }

        .shop-name {
            padding: 8px 16px;
            color: #fff;
            background-color: rgba(90, 90, 90, 0.5);
            border-radius: 4px;
            font-size: 26px;
            font-weight: bold;
            letter-spacing: 1px;
            text-decoration: none;
        }

        .navigation {
            display: flex;
            gap: 10px;
            margin: 0;
            padding: 0;
            list-style: none;
        }

        .navigation a {
            display: block;
            padding: 8px 14px;
            color: #fff;
            background-color: rgba(90, 90, 90, 0.5);
            border-radius: 4px;
            font-size: 13px;
            font-weight: bold;
            text-decoration: none;
            text-transform: uppercase;
        }

        .navigation a:hover {
            background-color: rgba(60, 60, 60, 0.8);
        }

        /* Main layout */
        .main-layout {
            width: 1100px;
            max-width: 95%;
            margin: 20px auto;
            padding: 0 15px;
            display: flex;
            gap: 30px;
        }

        /* Sidebar */
        .side-area {
            width: 250px;
            flex-shrink: 0;
        }

        .about-section {
            margin-bottom: 25px;
            padding: 15px;
            background-color: #e6e6e6;
        }

        .side-heading {
            margin-bottom: 10px;
            color: #777;
            font-size: 14px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .about-section p {
            color: #555;
            font-size: 12px;
            line-height: 1.4;
        }

        .about-section a {
            color: #333;
            text-decoration: underline;
        }

        .search-section {
            margin-bottom: 20px;
        }

        .search-box {
            width: 100%;
            padding: 5px;
            border: 1px solid #777;
            border-radius: 6px;
            outline: none;
        }

        .basket-link {
            color: #333;
            font-size: 12px;
            text-decoration: underline;
        }

        /* Cart */
        .basket-area {
            flex: 1;
        }

        .basket-heading {
            margin-bottom: 15px;
            color: #555;
            font-size: 14px;
            text-align: center;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .basket-table {
            width: 100%;
            border-collapse: collapse;
            font-size: 13px;
        }

        .basket-table th,
        .basket-table td {
            padding: 8px 10px;
            border: 1px solid #999;
            text-align: left;
        }

        .basket-table th {
            background-color: #2f3e46;
            color: #fff;
            font-weight: bold;
        }

        .text-center {
            text-align: center !important;
        }

        .text-right {
            text-align: right !important;
        }

        .basket-table a {
            color: #333;
            text-decoration: underline;
        }

        .summary-row td {
            font-weight: normal;
        }

        .summary-label {
            border-right: none !important;
        }

        .summary-value {
            border-left: none !important;
        }

        /* Buttons */
        .action-area {
            margin-top: 15px;
            display: flex;
            gap: 10px;
        }

        .action-button {
            padding: 4px 10px;
            color: #333;
            background-color: #f0f0f0;
            border: 1px solid #999;
            border-radius: 3px;
            font-size: 12px;
            cursor: pointer;
            text-decoration: none;
        }

        .action-button:hover {
            background-color: #e0e0e0;
        }

        .remove-button {
            padding: 0;
            color: #333;
            background-color: #fff;
            border: none;
            font-size: 12px;
            text-decoration: underline;
            cursor: pointer;
        }
        .empty-basket {
            padding: 30px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
            text-align: center;
        }

        .empty-basket p {
            margin-bottom: 15px;
            color: #555;
            font-size: 14px;
        }
    </style>
</head>

<body>
<nav class="top-header">
    <a href="#" class="shop-name">
        IUH BOOKSTORE
    </a>
    <ul class="navigation">
        <li><a href="#">HOME</a></li>
        <li><a href="#">EXAMPLES</a></li>
        <li><a href="#">SERVICES</a></li>
        <li><a href="#">PRODUCTS</a></li>
        <li><a href="#">CONTACT</a></li>
    </ul>
</nav>
<div class="main-layout">
    <aside class="side-area">
        <div class="about-section">
            <h3 class="side-heading">ABOUT US</h3>
            <p>
                About us information will be here......
                <a href="#">Read More »</a>
            </p>
        </div>
        <div class="search-section">
            <h3 class="side-heading">SEARCH SITE</h3>
            <form action="search" method="get">
                <input type="text" name="keyword" class="search-box" value="${keyword}"/>
            </form>
        </div>
        <div>
            <a href="cart" class="basket-link">
                Shopping cart (${cart.items.size()})
            </a>
        </div>
    </aside>
    <main class="basket-area">
        <h2 class="basket-heading">
            YOUR SHOPPING CART
        </h2>
        <c:choose>
            <%-- Có giỏ hàng và có sản phẩm --%>
            <c:when test="${not empty cart and not empty cart.items}">
                <table class="basket-table">
                    <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Product name</th>
                        <th class="text-right">Price</th>
                        <th class="text-center">Qty</th>
                        <th class="text-right">Total</th>
                        <th class="text-center">Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="grandTotal" value="0"/>
                    <c:forEach var="item" items="${cart.items}">
                        <c:set var="itemTotal" value="${item.book.price * item.quantity}"/>
                        <c:set var="grandTotal" value="${grandTotal + itemTotal}" />
                        <tr>
                            <td>
                                    ${item.book.bookId}
                            </td>
                            <td>
                                    ${item.book.title}
                                <c:if test="${not empty item.book.author}">
                                    - Tác giả: ${item.book.author}
                                </c:if>
                            </td>
                            <td class="text-right">
                                    ${item.book.price}
                            </td>
                            <td class="text-center">
                                    ${item.quantity}
                            </td>
                            <td class="text-right">
                                    ${itemTotal}
                            </td>
                            <td class="text-center">

                                <form action="cart" method="post">
                                    <input type="hidden" name="action"  value="remove"/>
                                    <input type="hidden"  name="bookId" value="${item.book.bookId}"/>
                                    <button  type="submit" class="remove-button">
                                        Remove
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr class="summary-row">
                        <td colspan="4"  class="text-right summary-label">
                            Total price
                        </td>
                        <td  colspan="2"  class="text-right summary-value">
                            (VNĐ) ${grandTotal}
                        </td>
                    </tr>
                </tbody>

                </table>
                <div class="action-area">
                    <button class="action-button" onclick="location.href='checkout'" >
                        Checkout
                    </button>

                    <button class="action-button"  onclick="location.href='books'" >
                        Continue shopping
                    </button>

                </div>
            </c:when>

            <%-- Giỏ hàng không có sản phẩm --%>
            <c:otherwise>
                <div class="empty-basket">
                    <p>Giỏ hàng của bạn đang trống.</p>

                    <a href="books" class="action-button">
                        Continue shopping
                    </a>
                </div>

            </c:otherwise>

        </c:choose>

    </main>

</div>

</body>
</html>