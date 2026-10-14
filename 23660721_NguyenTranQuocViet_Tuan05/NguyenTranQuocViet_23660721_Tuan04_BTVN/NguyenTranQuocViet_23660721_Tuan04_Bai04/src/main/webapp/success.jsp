<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/20/2026
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Order Confirmation</title>

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
        .top-bar {
            width: 100%;
            height: 100px;
            padding: 0 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            background: url('${pageContext.request.contextPath}/images/background-header.jpg')
            no-repeat center center;
            background-size: cover;
            background-color: #7a6a58;
        }

        .site-name {
            padding: 8px 16px;
            color: #fff;
            background-color: rgba(90, 90, 90, 0.5);
            border-radius: 4px;
            font-size: 26px;
            font-weight: bold;
            letter-spacing: 1px;
            text-decoration: none;
        }

        .menu-bar {
            display: flex;
            gap: 10px;
            margin: 0;
            padding: 0;
            list-style: none;
        }

        .menu-bar a {
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

        .menu-bar a:hover {
            background-color: rgba(60, 60, 60, 0.8);
        }

        /* Main layout */
        .page-content {
            width: 1100px;
            max-width: 95%;
            margin: 20px auto;
            padding: 0 15px;
            display: flex;
            gap: 30px;
        }

        /* Sidebar */
        .left-sidebar {
            width: 250px;
            flex-shrink: 0;
        }

        .about-box {
            margin-bottom: 25px;
            padding: 15px;
            background-color: #e6e6e6;
        }

        .side-title {
            margin-bottom: 10px;
            color: #777;
            font-size: 14px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .about-box p {
            color: #555;
            font-size: 12px;
            line-height: 1.4;
        }

        .about-box a {
            color: #333;
            text-decoration: underline;
        }

        .search-box {
            margin-bottom: 20px;
        }

        .search-field {
            width: 100%;
            padding: 5px;
            border: 1px solid #777;
            border-radius: 6px;
            outline: none;
        }

        /* Confirmation */
        .confirmation-box {
            flex: 1;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
        }

        .confirmation-heading {
            margin-bottom: 15px;
            color: #2e7d32;
            font-size: 18px;
            font-weight: bold;
        }

        .confirmation-text {
            color: #555;
            font-size: 13px;
        }

        .order-table {
            width: 100%;
            margin-top: 15px;
            border-collapse: collapse;
            font-size: 13px;
        }

        .order-table td {
            padding: 8px 0;
            color: #555;
        }

        .field-label {
            width: 150px;
            font-weight: bold;
        }

        .continue-button {
            display: inline-block;
            margin-top: 20px;
            padding: 6px 14px;
            color: #333;
            background-color: #f0f0f0;
            border: 1px solid #999;
            border-radius: 3px;
            font-size: 12px;
            text-decoration: none;
        }

        .continue-button:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>

<body>

<nav class="top-bar">

    <a href="#" class="site-name">
        IUH BOOKSTORE
    </a>

    <ul class="menu-bar">
        <li><a href="#">HOME</a></li>
        <li><a href="#">EXAMPLES</a></li>
        <li><a href="#">SERVICES</a></li>
        <li><a href="#">PRODUCTS</a></li>
        <li><a href="#">CONTACT</a></li>
    </ul>

</nav>

<div class="page-content">
    <aside class="left-sidebar">
        <div class="about-box">
            <h3 class="side-title">ABOUT US</h3>
            <p>
                About us information will be here......
                <a href="#">Read More »</a>
            </p>
        </div>
        <div class="search-box">
            <h3 class="side-title">SEARCH SITE</h3>

            <form action="search" method="get">
                <input
                        type="text"
                        name="keyword"
                        class="search-field"
                        value="${keyword}"
                />
            </form>
        </div>

    </aside>

    <main class="confirmation-box">
        <h2 class="confirmation-heading">
            Thank you for your order!
        </h2>
        <p class="confirmation-text">
            Your order has been placed successfully.
            Below are your order details:
        </p>

        <table class="order-table">

            <tr>
                <td class="field-label">
                    Fullname:
                </td>
                <td>
                    ${param.fullname}
                </td>
            </tr>

            <tr>
                <td class="field-label">
                    Shipping Address:
                </td>
                <td>
                    ${param.address}
                </td>
            </tr>

            <tr>
                <td class="field-label">
                    Total Price:
                </td>
                <td>
                    (VNĐ) ${param.totalPrice}
                </td>
            </tr>

            <tr>
                <td class="field-label">
                    Payment Method:
                </td>
                <td>
                    ${param.paymentMethod}
                </td>
            </tr>

        </table>

        <a href="books" class="continue-button">
            Continue shopping
        </a>
    </main>

</div>

</body>
</html>