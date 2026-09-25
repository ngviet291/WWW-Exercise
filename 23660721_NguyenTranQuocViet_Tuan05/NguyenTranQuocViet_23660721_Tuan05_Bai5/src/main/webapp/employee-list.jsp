<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/25/2026
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <img src="${pageContext.request.contextPath}/images/HRbanner.jpg" height="200px" width="100%">
    <h2>Employees List</h2>
    <a href="${pageContext.request.contextPath}/employees?action=new">Add Employee</a>
    <br/>
    <table class="table table-primary">
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Department ID</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.departmentId}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/employees?action=edit&id=${employee.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/employees?action=delete&id=${employee.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/departments">Department</a>
</div>
</body>
</html>
