<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/15/2026
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form thêm khách hàng</h1>
<form action="${pageContext.request.contextPath}/customer" method="post">
    <label for="id">Mã khách hàng:</label>
    <input type="text" id="id" name="id" required>

    <label for="name">Tên khách hàng:</label>
    <input type="text" id="name" name="name" required>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required>

    <label for="address">Địa chỉ:</label>
    <select id="address" name="address">
        <option value="Ha Noi">Hà Nội</option>
        <option value="Da Nang">Đà Nẵng</option>
        <option value="TPHCM">TPHCM</option>
        <option value="Ho Chi Minh">Hồ Chí Minh</option>
    </select>

    <button type="submit">Thêm khách hàng</button>
</form>
</body>
</html>
