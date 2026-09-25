<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/25/2026
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div class="container">
    <img src="${pageContext.request.contextPath}/images/HRbanner.jpg" height="200px" width="100%">
    <form action="${pageContext.request.contextPath}/employees" method="post">
        <input type="hidden" name="id">
        Name: <input type="text" name="name"><br>
        Salary: <input type="text" name="salary"><br>
      Department: <select name="departmentId">
            <c:forEach var="department" items="${departments}">
                <option value="${department.id}">${department.name}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Save Employee">
    </form>
  </div>
</body>
</html>
