<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 8/20/2026
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Database</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/uploadDatabase" method="post" enctype="multipart/form-data">
    FirstName: <input type="text" name="firstName"> <br> <br>
    LastName: <input type="text" name="lastName"> <br> <br>
    Portrait Photo: <input type="text" name="photo"> <br> <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
