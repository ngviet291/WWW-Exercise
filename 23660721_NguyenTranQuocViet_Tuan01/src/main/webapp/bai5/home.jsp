<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 8/18/2026
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
    <h2>Xin chào, ${sessionScope.user}</h2>
    <a href="${pageContext.request.contextPath}/bai5/secure/secret.jsp">Trang bảo mật</a><br/>
    <a href="${pageContext.request.contextPath}/bai5/login.jsp">Đăng xuất</a>
</body>
</html>
