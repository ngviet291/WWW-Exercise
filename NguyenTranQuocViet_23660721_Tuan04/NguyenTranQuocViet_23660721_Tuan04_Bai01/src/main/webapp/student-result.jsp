<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/11/2026
  Time: 7:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>Student Information</h2>
  <p><b>Name:</b> ${student.firstName} ${student.lastName}</p>
  <p><b>Date of Birth:</b> ${student.dateOfBirth}</p>
  <p><b>Email:</b> ${student.email}</p>
  <p><b>Mobile:</b> ${student.mobile}</p>
  <p><b>Gender:</b> ${student.gender}</p>
  <p><b>Address:</b> ${student.address}</p>
  <p><b>City:</b> ${student.city}</p>
  <p><b>State:</b> ${student.state}</p>
  <p><b>Country:</b> ${student.country}</p>
  <p><b>Course:</b> ${student.course}</p>
  <ul>
    <c:forEach var="item" items="${student.hobbies}">
      <li>${item}</li>
    </c:forEach>
  </ul>

</body>
</html>
