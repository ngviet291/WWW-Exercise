
<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 8/21/2026
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Date of Birth</th>
        </tr>

        <c:forEach var="account" items="${accounts}">
            <tr>
                <td>${account.id}</td>
                <td>${account.firstName}</td>
                <td>${account.lastName}</td>
                <td>${account.email}</td>
                <td>${account.password}</td>
                <td>${account.dateOfBirth}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
