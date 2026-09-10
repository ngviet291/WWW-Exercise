package com.ngviet291.nguyentranquocviet_23660721_bai01.web;

import com.ngviet291.nguyentranquocviet_23660721_bai01.model.Course;
import com.ngviet291.nguyentranquocviet_23660721_bai01.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/course/edit")
public class EditServlet extends HttpServlet {
    private CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        int id = getId(req);

        Course course = courseService.getCourseById(id);

        if (course == null) {
            req.setAttribute("error", "Không tìm thấy khóa học");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("course", course);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        int id = getId(req);
        String courseName = req.getParameter("courseName");
        String instructor = req.getParameter("instructor");
        String email = req.getParameter("instructorEmail");
        String category = req.getParameter("category");
        String level = req.getParameter("level");
        double price = Double.parseDouble(req.getParameter("price"));
        int duration = Integer.parseInt(req.getParameter("duration"));
        String startDate = req.getParameter("startDate");
        boolean featured= req.getParameter("featured") !=null;
        Course course= Course.builder()
                .id(id)
                .courseName(courseName)
                .instructor(instructor)
                .price(price)
                .instructorEmail(email)
                .category(category)
                .level(level)
                .duration(duration)
                .startDate(startDate)
                .featured(featured)
                .build();
        courseService.editCourse(course);
        resp.sendRedirect(req.getContextPath()+"/course/list");

    }
    private int getId(HttpServletRequest request){
        return Integer.parseInt(request.getParameter("id"));
    }
}
