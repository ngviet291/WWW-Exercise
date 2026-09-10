<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/10/2026
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/login" method="post">
        Tên đăng nhập <input type="text" name="username" value="${username}"> <br> <br>
        Password <input type="password" name="password" > <br> <br>
        <button type="submit">Đăng nhập</button>
    </form>
</body>
</html>
