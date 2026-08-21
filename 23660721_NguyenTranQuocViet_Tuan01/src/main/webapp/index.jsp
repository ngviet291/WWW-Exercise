<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<a href="${pageContext.request.contextPath}/bai4/formData.jsp">Bài 4</a>
<br/>
<a href="${pageContext.request.contextPath}/bai5/login.jsp">Bài 5</a>
<br/>
<a href="${pageContext.request.contextPath}/bai6/upload.jsp">Bài 6</a>
<br>
<a href="${pageContext.request.contextPath}/bai7/uploadDatabase.jsp">Bài 7</a>
</body>
</html>