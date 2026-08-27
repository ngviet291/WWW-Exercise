<%--
  Created by IntelliJ IDEA.
  User: NguyenViet
  Date: 8/20/2026
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Multifile</title>
</head>
<body>
<h2>Upload Multifile</h2>
<form action="${pageContext.request.contextPath}/multi-upload" method="post" enctype="multipart/form-data">
    File 1: <input type="file" name="file1"/><br/>
    File 2: <input type="file" name="file2"/><br/>
    File 3: <input type="file" name="file3"/><br/>
    File 4: <input type="file" name="file4"/><br/>
    File 5: <input type="file" name="file5"/><br/>
    <button type="submit">Upload</button>
    <button type="reset">Reset</button>
</form>
</body>
</html>
