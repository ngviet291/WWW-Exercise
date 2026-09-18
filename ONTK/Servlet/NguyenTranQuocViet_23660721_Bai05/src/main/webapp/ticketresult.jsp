<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 9/15/2026
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Danh sách vé đã đặt</h2>
    <table style="border: 1px solid black;">
        <thead>
            <tr>
                <th>Họ và tên hành khách</th>
                <th style="margin-right: 10px">Loại ghế</th>
                <th>Chuyến đi</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <td>${ticket.passengerName}</td>
                    <td style="margin-right: 10px">${ticket.seatType}</td>
                    <td>
                        <c:forEach var="route" items="${ticket.route}">
                            <p>${route}</p> <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
<style>
    th, td {
        border: 1px solid black;
        padding: 10px;
    }
</style>
</html>
