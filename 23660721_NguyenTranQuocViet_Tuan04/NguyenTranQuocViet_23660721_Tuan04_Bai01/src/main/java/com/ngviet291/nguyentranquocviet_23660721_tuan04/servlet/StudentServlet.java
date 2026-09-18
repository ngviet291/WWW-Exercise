package com.ngviet291.nguyentranquocviet_23660721_tuan04.servlet;

import com.ngviet291.nguyentranquocviet_23660721_tuan04.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("pinCode");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String course = req.getParameter("course");

        String[] hobbies = req.getParameterValues("hobbies");

        Student student = new Student();

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dateOfBirth);
        student.setEmail(email);
        student.setMobile(mobile);
        student.setGender(gender);
        student.setAddress(address);
        student.setCity(city);
        student.setPinCode(pinCode);
        student.setState(state);
        student.setCountry(country);
        student.setHobbies(hobbies);
        student.setCourse(course);

        req.setAttribute("student",student);

        req.getRequestDispatcher("/student-result.jsp").forward(req,resp);
    }
}
