<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration Form</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background-color: #ffffff;
            border-top: 4px solid #6cbf3d;
        }

        .form-container {
            max-width: 640px;
            margin: 60px auto;
        }

        .form-control,
        .form-select {
            padding: 12px 14px;
            font-size: 15px;
        }

        .btn-signup {
            background-color: #2563eb;
            border: none;
            padding: 12px;
            font-size: 16px;
        }

        .btn-signup:hover {
            background-color: #1d4ed8;
        }
    </style>
</head>

<body>

<div class="container-fluid">
    <div class="form-container">

        <h2 class="text-center fw-bold mb-4">User Registration Form</h2>

        <form action="${pageContext.request.contextPath}/registerform" method="post">

            <!-- First Name / Last Name -->
            <div class="row g-3 mb-3">
                <div class="col-md-6">
                    <input type="text"
                           name="firstname"
                           class="form-control"
                           placeholder="First Name">
                </div>

                <div class="col-md-6">
                    <input type="text"
                           name="lastname"
                           class="form-control"
                           placeholder="Last Name">
                </div>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <input type="email"
                       name="email"
                       class="form-control"
                       placeholder="Your Email">
            </div>

            <!-- Password -->
            <div class="mb-3">
                <input type="password"
                       name="password"
                       value="123456"
                       class="form-control"
                       placeholder="Password">
            </div>

            <!-- Birthday -->
            <div class="mb-2">
                <label class="form-label fw-semibold">Birthday</label>

                <div class="row g-3">
                    <div class="col-md-4">
                        <select name="month" class="form-select">
                            <option selected disabled>Month</option>
                            <option value="1">January</option>
                            <option value="2">February</option>
                            <option value="3">March</option>
                            <option value="4">April</option>
                            <option value="5">May</option>
                            <option value="6">June</option>
                            <option value="7">July</option>
                            <option value="8">August</option>
                            <option value="9">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                    </div>

                    <div class="col-md-4">
                        <select name="day" class="form-select">
                            <option selected disabled>Day</option>
                            <c:forEach begin="1" end="31" var="d">
                                <option value="${d}">${d}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-4">
                        <select name="year" class="form-select">
                            <option selected disabled>Year</option>
                            <c:forEach begin="1950" end="2025" var="y">
                                <option value="${y}">${y}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <!-- Submit -->
            <button type="submit" class="btn btn-signup btn-primary w-100 text-white">
                Sign Up
            </button>

        </form>

    </div>
</div>

</body>
</html>
