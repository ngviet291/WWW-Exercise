<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Form Student Register</title>
</head>
<body>

<h2>Student Registration Form</h2>

<form action="${pageContext.request.contextPath}/student" method="post">

    First Name:
    <input type="text" name="firstName"><br><br>

    Last Name:
    <input type="text" name="lastName"><br><br>

    Date of Birth:
    <input type="date" name="dateOfBirth"><br><br>

    Email:
    <input type="email" name="email"><br><br>

    Mobile:
    <input type="text" name="mobile"><br><br>

    Gender:
    <input type="radio" name="gender" value="Male"> Male
    <input type="radio" name="gender" value="Female"> Female
    <br><br>

    Address:
    <textarea name="address"></textarea><br><br>

    City:
    <input type="text" name="city"><br><br>

    Pin Code:
    <input type="text" name="pinCode"><br><br>

    State:
    <input type="text" name="state"><br><br>

    Country:
    <select name="country">
        <option value="India">India</option>
        <option value="Vietnam">Vietnam</option>
    </select>
    <br><br>

    Hobbies:
    <input type="checkbox" name="hobbies" value="Drawing"> Drawing
    <input type="checkbox" name="hobbies" value="Singing"> Singing
    <input type="checkbox" name="hobbies" value="Dancing"> Dancing
    <input type="checkbox" name="hobbies" value="Sketching"> Sketching
    <br><br>

    <h3>Qualification</h3>

    <table border="1">
        <tr>
            <th>Sl.No</th>
            <th>Examination</th>
            <th>Board</th>
            <th>Percentage</th>
            <th>Year</th>
        </tr>

        <tr>
            <td>1</td>
            <td>Class X</td>
            <td><input type="text" name="board10"></td>
            <td><input type="text" name="percentage10"></td>
            <td><input type="text" name="year10"></td>
        </tr>

        <tr>
            <td>2</td>
            <td>Class XII</td>
            <td><input type="text" name="board12"></td>
            <td><input type="text" name="percentage12"></td>
            <td><input type="text" name="year12"></td>
        </tr>
    </table>

    <br>

    Course applies for:
    <input type="radio" name="course" value="BCA"> BCA
    <input type="radio" name="course" value="B.Com"> B.Com
    <input type="radio" name="course" value="B.Sc"> B.Sc
    <input type="radio" name="course" value="B.A"> B.A

    <br><br>

    <input type="submit" value="Submit">
    <input type="reset" value="Reset">

</form>

</body>
</html>