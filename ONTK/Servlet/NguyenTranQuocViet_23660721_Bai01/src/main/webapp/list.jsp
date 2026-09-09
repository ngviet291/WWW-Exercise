<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/9/2026
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>Mã</th>
            <th>Tên khóa học</th>
            <th>Giảng viên</th>
            <th>Danh mục</th>
            <th>Trình độ</th>
            <th>Học phí</th>
            <th>Thời lượng</th>
            <th>Ngày khai giảng</th>
            <th>Có nổi bật hay không?</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.id}</td>
                <td>${course.courseName}</td>
                <td>${course.instructor}</td>
                <td>${course.instructorEmail}</td>
                <td>${course.category}</td>
                <td>${course.level}</td>
                <td>${course.price}</td>
                <td>${course.duration}</td>
                <td>${course.startDate}</td>
                <td>
                    <c:choose>
                            <c:when test="${course.featured}">
                            Có
                            </c:when>
                            <c:otherwise>
                            Không
                            </c:otherwise>
                        </c:choose>

            </tr>
        </c:forEach>
    </tbody>
</table>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <button>Logout</button>
</form>
</body>
</html>
