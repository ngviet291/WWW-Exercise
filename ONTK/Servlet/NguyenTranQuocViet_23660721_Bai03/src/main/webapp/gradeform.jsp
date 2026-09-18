<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/14/2026
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Đăng ký phiếu điểm</h2>
    <form action="${pageContext.request.contextPath}/grade" method="post">
        Mã sinh viên: <input type="text" name="id" value=""> <br> <br>
        Họ và tên: <input type="text" name="name" value=""> <br> <br>
        Học kỳ:
        <select name="semester">
            <option value="Học kỳ 1">Học kỳ 1</option>
            <option value="Học kỳ 2">Học kỳ 2</option>
        </select>
        <br> <br>
        Chọn môn học:
        <div>
            <input type="checkbox" name="subjects" value="Lập trình java"> Lập trình java <br> <br>
            <input type="checkbox" name="subjects" value="Cơ sở dữ liệu"> Cơ sở dữ liệu <br> <br>
            <input type="checkbox" name="subjects" value="Cấu trúc dữ liệu">Cấu trúc dữ liệu <br> <br>
        </div>
        <button type="submit">Gửi phiếu điểm</button>
    </form>
</body>
</html>
