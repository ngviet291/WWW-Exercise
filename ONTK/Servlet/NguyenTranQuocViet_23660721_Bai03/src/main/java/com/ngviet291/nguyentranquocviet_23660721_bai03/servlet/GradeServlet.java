package com.ngviet291.nguyentranquocviet_23660721_bai03.servlet;

import com.ngviet291.nguyentranquocviet_23660721_bai03.model.GradeReport;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/grade")
public class GradeServlet extends HttpServlet {
    @Inject
    private GradeReport gradeReport;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("/gradeform.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String semester = req.getParameter("semester");
        String[] subjects = req.getParameterValues("subjects");
        GradeReport gr= gradeReport.builder()
                .id(id)
                .name(name)
                .semester(semester)
                .subjects(subjects)
                .build();
        req.setAttribute("grade",gr);
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }
}
