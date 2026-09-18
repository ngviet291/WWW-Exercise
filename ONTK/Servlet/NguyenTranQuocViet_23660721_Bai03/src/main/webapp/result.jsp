<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/14/2026
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Thông tin phiếu điểm sinh viên</h2>
    <p><b>Mã sinh viên</b>${grade.id}</p>
    <p><b>Họ và tên</b>${grade.name}</p>
    <p><b>Học kỳ</b>${grade.semester}</p>
    <p><b>Các môn học đã chọn:</b></p>
    <ul>
        <c:forEach var="subject" items="${grade.subjects}">
            <li>${subject}</li>
         </c:forEach>

    </ul>

</body>
</html>
