package com.ngviet291.nguyentranquocviet_23660721_bai01.web;

import com.ngviet291.nguyentranquocviet_23660721_bai01.model.Course;
import com.ngviet291.nguyentranquocviet_23660721_bai01.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/course/create")
public class CreateServlet extends HttpServlet {
    private final CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String courseName= req.getParameter("courseName");
        String instructor= req.getParameter("instructor");
        String instructorEmail= req.getParameter("instructorEmail");
        String category= req.getParameter("category");
        String level= req.getParameter("level");
        String startDate= req.getParameter("startDate");
        boolean featured= req.getParameter("featured") !=null;

        double price;
        int duration;
        try {
            price = Double.parseDouble(req.getParameter("price"));
            duration = Integer.parseInt(req.getParameter("duration"));
        } catch (Exception e) {
            req.setAttribute("message", "Học phí và thời lượng phải là số");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
            return;
        }
        Course course= Course.builder()
                .courseName(courseName)
                .instructor(instructor)
                .instructorEmail(instructorEmail)
                .category(category)
                .level(level)
                .price(price)
                .duration(duration)
                .startDate(startDate)
                .featured(featured)
                .build();

        courseService.addCourse(course);
        resp.sendRedirect(req.getContextPath()+"/course/list");
    }

}
