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
<a href="${pageContext.request.contextPath}/course/create">Thêm khóa học</a>
<form action="${pageContext.request.contextPath}/course/list" method="get">
    Tên khóa học <input type="text" name="keyword" value="${keyword}"> <br> <br>
    Danh mục
    <select name="category">
        <option value="All" ${empty category || category=="All" ? 'selected':"" }>Tất cả</option>
        <option value="Lập trình" ${category=="Lập trình"?'selected':""}>Lập trình</option>
        <option value="Thiết kế" ${category =="Thiết kế"? 'selected':""}>Thiết kế</option>
        <option value="Marketing"${category =="Marketing"? 'selected':""}>Marketing</option>
        <option value="Ngoại ngữ" ${category =="Ngoại ngữ"? 'selected':""}>Ngoại ngữ</option>
    </select>

    <button>Tìm kiếm</button>
</form>
<c:choose>
    <c:when test="${empty courses}">
        <p>Không tìm thấy khóa học</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>Mã</th>
                <th>Tên khóa học</th>
                <th>Giảng viên</th>
                <th>Email</th>
                <th>Danh mục</th>
                <th>Trình độ</th>
                <th>Học phí</th>
                <th>Thời lượng</th>
                <th>Ngày khai giảng</th>
                <th>Có nổi bật hay không?</th>
                <th>Xóa</th>
                <th>Sửa</th>
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
                            ${course.featured ? 'Có' : 'Không'}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/course/delete?id=${course.id}">Xoá</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/course/edit?id=${course.id}">Chỉnh sửa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<form action="${pageContext.request.contextPath}/logout" method="post">
    <button>Logout</button>
</form>
</body>
</html>
