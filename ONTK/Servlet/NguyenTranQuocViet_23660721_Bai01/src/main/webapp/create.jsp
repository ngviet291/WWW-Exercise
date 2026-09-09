<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/9/2026
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/course/create" method="post">
        Tên khóa học <input type="text" name="courseName" value="${course.courseName}"> <br> <br>
        Giảng viên <input type="text" name="instructor" value="${course.instructor}"> <br> <br>
        Email <input type="email" name="instructorEmail" value="${course.instructorEmail}"> <br> <br>
        Category <input type="text" name="category" value="${course.category}"> <br> <br>
        Level <input type="text" name="level" value="${course.level}"> <br> <br>
        Price <input type="text" name="price" value="${course.price}"> <br> <br>
        Duration <input type="text" name="duration" value="${course.duration}"> <br> <br>
        StartDate <input type="text" name="startDate" value="${course.startDate}"> <br> <br>
        Featured <input type="checkbox" name="featured"> <br> <br>
        <button type="submit">Thêm khóa học</button>
    </form>
</body>
</html>
