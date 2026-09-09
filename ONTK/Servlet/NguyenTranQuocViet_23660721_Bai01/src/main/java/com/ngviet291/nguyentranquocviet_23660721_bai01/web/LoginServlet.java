package com.ngviet291.nguyentranquocviet_23660721_bai01.web;

import com.ngviet291.nguyentranquocviet_23660721_bai01.model.User;
import com.ngviet291.nguyentranquocviet_23660721_bai01.service.UserService;
import com.ngviet291.nguyentranquocviet_23660721_bai01.session.UserSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = UserService.login(username, password);
        if(user==null){
            req.setAttribute("error", "Sai tk hoặc mk");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
            return;
        }
        UserSession.login(req,user);
        resp.sendRedirect(req.getContextPath()+"/course/list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }
}
