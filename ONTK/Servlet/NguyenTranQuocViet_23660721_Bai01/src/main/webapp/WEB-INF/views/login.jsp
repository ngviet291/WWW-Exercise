<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/9/2026
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Login</title>
</head>
<h2>Login</h2>
<c:if test="${not empty error}"><p style="color: red">${error}</p></c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
Tên đăng nhập: <input type="text" name="username" value="${username}"/> <br> <br>
Mật khẩu : <input type="password" name="password"> <br> <br>
<input type="submit" value="Đăng nhập">
</form>
</body>
</html>
