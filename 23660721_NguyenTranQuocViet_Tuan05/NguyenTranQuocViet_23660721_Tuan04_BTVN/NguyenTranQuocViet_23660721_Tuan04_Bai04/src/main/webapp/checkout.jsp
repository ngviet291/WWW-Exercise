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
    <title>Checkout</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            color: #444;
            background: #fafafa;
        }

        /* Header */
        .top-area {
            height: 95px;
            padding: 0 35px;

            display: flex;
            align-items: center;
            justify-content: space-between;

            background: url('${pageContext.request.contextPath}/images/background-header.jpg')
            center / cover no-repeat;

            background-color: #75695e;
        }

        .store-name {
            padding: 10px 18px;

            color: white;
            background: rgba(0, 0, 0, 0.45);

            border-radius: 5px;

            font-size: 25px;
            font-weight: bold;
            letter-spacing: 1px;
            text-decoration: none;
        }

        .menu-list {
            display: flex;
            gap: 8px;

            margin: 0;
            padding: 0;

            list-style: none;
        }

        .menu-list a {
            display: block;

            padding: 9px 13px;

            color: white;
            background: rgba(0, 0, 0, 0.4);

            border-radius: 4px;

            font-size: 12px;
            font-weight: bold;
            text-decoration: none;
        }

        .menu-list a:hover {
            background: rgba(0, 0, 0, 0.7);
        }

        /* Content */
        .page-layout {
            width: 1080px;
            max-width: 92%;

            margin: 25px auto;

            display: flex;
            gap: 30px;
            align-items: flex-start;
        }

        /* Left side */
        .left-column {
            width: 245px;
            flex-shrink: 0;
        }

        .info-box,
        .find-box {
            margin-bottom: 22px;
            padding: 16px;

            background: #ededed;
            border: 1px solid #d5d5d5;
        }

        .box-heading {
            margin: 0 0 12px;

            color: #666;
            font-size: 14px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .info-box p {
            margin: 0;

            color: #666;
            font-size: 12px;
            line-height: 1.6;
        }

        .info-box a {
            color: #333;
            text-decoration: underline;
        }

        .keyword-input {
            width: 100%;
            height: 32px;

            padding: 5px 8px;

            border: 1px solid #aaa;
            border-radius: 4px;

            background: white;
            outline: none;
        }

        .keyword-input:focus {
            border-color: #666;
        }

        .basket-link {
            color: #444;
            font-size: 13px;
            text-decoration: underline;
        }

        /* Checkout area */
        .order-area {
            flex: 1;
        }

        .order-heading {
            margin-bottom: 12px;

            color: #666;
            font-size: 14px;
            text-align: center;
        }

        .order-form {
            width: 100%;

            border: 1px solid #bbb;
            border-spacing: 0;

            background: white;

            font-size: 13px;
        }

        .order-form td {
            padding: 11px 14px;

            border-right: 1px solid #ccc;
            border-bottom: 1px solid #ccc;

            vertical-align: middle;
        }

        .order-form tr:last-child td {
            border-bottom: none;
        }

        .order-form td:last-child {
            border-right: none;
        }

        .field-name {
            width: 180px;

            color: #555;
            background: #f1f1f1;
        }

        .text-field {
            width: 210px;
            height: 30px;

            padding: 5px 8px;

            border: 1px solid #aaa;
            border-radius: 3px;

            background: #f8f8f8;
            color: #444;

            outline: none;
        }

        .address-field {
            width: 330px;
        }

        .text-field:focus {
            background: white;
            border-color: #666;
        }

        .payment-options {
            display: flex;
            align-items: center;
            gap: 18px;
        }

        .payment-options label {
            display: flex;
            align-items: center;
            gap: 5px;

            color: #555;
            cursor: pointer;
        }

        .action-row {
            padding: 14px !important;

            background: #f5f5f5;
            text-align: center;
        }

        .action-button {
            min-width: 65px;

            padding: 6px 14px;

            border: 1px solid #999;
            border-radius: 3px;

            background: #e9e9e9;
            color: #333;

            font-size: 12px;
            cursor: pointer;
        }

        .action-button:hover {
            background: #dcdcdc;
        }
    </style>
</head>

<body>

<nav class="top-area">
    <a href="#" class="store-name">
        IUH BOOKSTORE
    </a>

    <ul class="menu-list">
        <li><a href="#">HOME</a></li>
        <li><a href="#">EXAMPLES</a></li>
        <li><a href="#">SERVICES</a></li>
        <li><a href="#">PRODUCTS</a></li>
        <li><a href="#">CONTACT</a></li>
    </ul>

</nav>
<div class="page-layout">
    <aside class="left-column">

        <div class="info-box">
            <h3 class="box-heading">ABOUT US</h3>
            <p>
                About us information will be here......
                <a href="#">Read More »</a>
            </p>
        </div>
        <div class="find-box">
            <h3 class="box-heading">SEARCH SITE</h3>
            <form action="search" method="get">
                <input  type="text" name="keyword"  class="keyword-input"  value="${keyword}"/>
            </form>
        </div>
        <div>
            <a href="cart" class="basket-link">
                Shopping cart (${cart.items.size()})
            </a>
        </div>
    </aside>
    <main class="order-area">

        <div class="order-heading">
            Checkout - Already registered? ...
        </div>
        <form action="${pageContext.servletContext.contextPath}/checkout"  method="post">
            <table class="order-form">
                <tr>
                    <td class="field-name">
                        Fullname:
                    </td>
                    <td>
                        <input  type="text"  name="fullname"  class="text-field"  required/>
                    </td>
                </tr>
                <tr>
                    <td class="field-name">
                        Shipping address:
                    </td>
                    <td>
                        <input type="text"  name="address" class="text-field address-field" required/>
                    </td>
                </tr>
                <tr>
                    <td class="field-name">
                        Total price:
                    </td>
                    <td>
                        <input  type="text"  name="totalPrice" class="text-field" value="${totalPrice}" readonly />
                    </td>
                </tr>
                <tr>
                    <td class="field-name">
                        Payment method
                    </td>
                    <td>
                        <div class="payment-options">
                            <label>
                                <input type="radio" name="paymentMethod"  value="Paypal"   checked />
                                Paypal
                            </label>
                            <label>
                                <input type="radio" name="paymentMethod"  value="ATM"/>
                                ATM Debit
                            </label>
                            <label>
                                <input  type="radio" name="paymentMethod" value="VisaMaster"/>
                                Visa/Master card
                            </label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="action-row">

                        <button type="submit"  class="action-button">
                            Save
                        </button>

                        <button type="button"  class="action-button"  onclick="location.href='cart'">
                            Cancel
                        </button>
                    </td>
                </tr>
            </table>
        </form>
    </main>

</div>

</body>
</html>