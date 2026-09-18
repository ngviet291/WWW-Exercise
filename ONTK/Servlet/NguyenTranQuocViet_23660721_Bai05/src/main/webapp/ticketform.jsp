<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/15/2026
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/ticket" method="post">
        Họ và tên hành khách: <input type="text" name="passengerName"> <br> <br>
        Password: <input type="password" name="password"> <br> <br>
        Loại ghế:
        <div>
            <input type="radio" name="seatType" value="Ghế Ngồi"> Ghế Ngồi
            <input type="radio" name="seatType" value="Giường Nằm"> Giường Nằm
        </div>
        <br> <br>
        Tuyến xe:
        <select name="route">
            <option value="Hà Nội - Hải Phòng">Hà Nội - Hải Phòng</option>
            <option value="TP.HCM - Đà Lạt">TP.HCM - Đà Lạt</option>
            <option value="Đà Nẵng - Huế">Đà Nẵng - Huế</option>
        </select>
        <br> <br>
        <button type="submit">Đặt vé</button>
    </form>
</body>
</html>
