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
    <title>Product Details</title>

    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            color: #444;
            background-color: #fafafa;
        }

        /* Header */
        .top-header {
            height: 100px;
            padding: 0 30px;

            display: flex;
            align-items: center;
            justify-content: space-between;

            background-image: url('${pageContext.request.contextPath}/images/background-header.jpg');
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            background-color: #75695e;
        }

        .store-logo {
            padding: 9px 17px;

            color: white;
            background-color: rgba(70, 70, 70, 0.55);

            border-radius: 5px;

            font-size: 25px;
            font-weight: bold;
            letter-spacing: 1px;
            text-decoration: none;
        }

        .main-menu {
            display: flex;
            gap: 9px;

            margin: 0;
            padding: 0;

            list-style: none;
        }

        .main-menu a {
            display: block;

            padding: 9px 14px;

            color: white;
            background-color: rgba(70, 70, 70, 0.5);

            border-radius: 4px;

            font-size: 12px;
            font-weight: bold;
            text-decoration: none;
        }

        .main-menu a:hover {
            background-color: rgba(40, 40, 40, 0.8);
        }

        /* Layout */
        .content-area {
            width: 1100px;
            max-width: 92%;

            margin: 25px auto;

            display: flex;
            gap: 30px;
        }

        /* Sidebar */
        .side-panel {
            width: 250px;
            flex-shrink: 0;
        }

        .about-box {
            margin-bottom: 25px;
            padding: 16px;

            background-color: #e9e9e9;
        }

        .search-box {
            padding: 16px;
            background-color: #e9e9e9;
        }

        .panel-heading {
            margin-bottom: 10px;

            color: #707070;
            font-size: 14px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .about-box p {
            color: #555;
            font-size: 12px;
            line-height: 1.5;
        }

        .about-box a {
            color: #333;
            text-decoration: underline;
        }

        .keyword-box {
            width: 100%;

            padding: 6px 8px;

            border: 1px solid #888;
            border-radius: 5px;

            background-color: white;
            outline: none;
        }

        .keyword-box:focus {
            border-color: #555;
        }

        /* Book details */
        .book-content {
            flex: 1;
        }

        .book-heading {
            margin-bottom: 20px;

            color: #666;
            font-size: 14px;
        }

        .book-picture {
            width: 200px;
            height: 280px;

            display: block;

            margin-bottom: 15px;

            object-fit: cover;
        }

        .book-information {
            color: #555;
            font-size: 13px;
            line-height: 1.7;
        }

        .book-information p {
            margin-bottom: 4px;
        }

        .return-link {
            display: inline-block;

            margin-top: 25px;

            color: #333;
            font-size: 13px;
            text-decoration: underline;
        }

        .return-link:hover {
            color: #000;
        }
    </style>
</head>

<body>
<nav class="top-header">
    <a href="#" class="store-logo">
        IUH BOOKSTORE
    </a>
    <ul class="main-menu">
        <li><a href="#">HOME</a></li>
        <li><a href="#">EXAMPLES</a></li>
        <li><a href="#">SERVICES</a></li>
        <li><a href="#">PRODUCTS</a></li>
        <li><a href="#">CONTACT</a></li>
    </ul>
</nav>
<div class="content-area">
    <aside class="side-panel">
        <div class="about-box">
            <h3 class="panel-heading">
                ABOUT US
            </h3>
            <p>
                About us information will be here......
                <a href="#">Read More »</a>
            </p>

        </div>
        <div class="search-box">

            <h3 class="panel-heading">
                SEARCH SITE
            </h3>
            <form action="search" method="get">
                <input type="text" name="keyword"  class="keyword-box"  value="${keyword}"/>
            </form>
        </div>
    </aside>
    <main class="book-content">
        <div class="book-heading">

            Product details: ${book.title}

            <c:if test="${not empty book.author}">
                - Tác giả: ${book.author}
            </c:if>
        </div>
        <img  src="${pageContext.request.contextPath}/images/${book.image}" alt="${book.title}"  class="book-picture"/>
        <div class="book-information">
            <p>
                Price (VNĐ): ${book.price}
            </p>
            <p>
                Quantity: ${book.quantity}
            </p>
        </div>
        <a  href="${pageContext.request.contextPath}/books" class="return-link">
            Back to Product List
        </a>
    </main>
</div>

</body>
</html>