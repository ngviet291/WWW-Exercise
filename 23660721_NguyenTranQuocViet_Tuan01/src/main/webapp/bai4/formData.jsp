<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/21/2026
  Time: 7:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTML Form Example with File Upload</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/processFormUpload" method="post" enctype="multipart/form-data">
        Name: <input type="text" name="name" ><br><br>
        Password: <input type="password" name="password" ><br><br>
        Gender: <input type="radio" name="gender" value="male"> Male
                <input type="radio" name="gender" value="female"> Female
        <br><br>
        Hobbies: <input type="checkbox" name="hobbies" value="reading">Reading
                 <input type="checkbox" name="hobbies" value="sports">Sports
                 <input type="checkbox" name="hobbies" value="music">Music
        <br><br>
        Country: <select name="country">
                    <option value="USA">USA</option>
                    <option value="Canada">Canada</option>
                    <option value="UK">UK</option>
                 </select>
        <br><br>
        Birth Date: <input type="date" name="birthDate"><br><br>
        Profile Picture: <input type="file" name="profilePicture"><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
