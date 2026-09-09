package com.ngviet291.nguyentranquocviet_23660721_bai01.web;

import com.ngviet291.nguyentranquocviet_23660721_bai01.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/course/delete")
public class DeleteServlet extends HttpServlet {
    private final CourseService courseService = new CourseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean isDeleted = courseService.removeCourse(id);
            if(!isDeleted){
                req.setAttribute("message", "Khóa học đã bị xóa hoặc không tồn tại");
                req.getRequestDispatcher("/error.jsp").forward(req,resp);
                return;
            }
        }catch (NumberFormatException e){
            req.setAttribute("message","Mã khóa học không hợp lệ");
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
            return;
        }
        resp.sendRedirect(req.getContextPath()+"/course/list");
    }
}
