<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 8/18/2026
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
    Tên đăng nhập: <input type="text" name="username"/>
    <br/>
    Mật khẩu: <input type="password" name="password"/>
    <br/>
    <button type="submit">Đăng nhập</button>
</form>
</body>
</html>
