<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/28/2026
  Time: 7:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
<%--    <link rel="stylesheet" href="${pageContext.request.getContextPath}/a">--%>
</head>
<body>
<main class="card login-card">
    <h1>Đăng nhập</h1>
    <p class="hint">Tài khoản demo:<strong>student</strong>/<strong>123456</strong></p>
    <p class="error">${error}</p>
    <form method="post"
          action="${pageContext.request.contextPath}/login">
        <label for="username">Tên đăng nhập</label>
        <input id="username" name="username" value="${username}"
               required autofocus>
        <label for="password">Mật khẩu</label>
        <input id="password" name="password" type="password"
               required>
        <button type="submit">Đăng nhập</button>
    </form>
</main>
</body>
</html>
