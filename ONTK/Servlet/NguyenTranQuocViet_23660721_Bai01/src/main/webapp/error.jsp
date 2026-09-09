<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/9/2026
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
    <a href="javascript:history.back()"> Quay về trang trước</a>
</body>
</html>
