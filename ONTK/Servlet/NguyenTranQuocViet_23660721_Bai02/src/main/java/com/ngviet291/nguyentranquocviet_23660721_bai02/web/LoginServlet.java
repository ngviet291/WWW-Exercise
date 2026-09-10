package com.ngviet291.nguyentranquocviet_23660721_bai02.web;

import com.ngviet291.nguyentranquocviet_23660721_bai02.service.AuthenticateService;
import com.ngviet291.nguyentranquocviet_23660721_bai02.session.UserSession;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Inject
    private  UserSession userSession;
    @Inject
    private  AuthenticateService authenticateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        if(userSession.isLoggedIn()){
            resp.sendRedirect(req.getContextPath()+"/products");
            return;
        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(!authenticateService.authentication(username,password)){
            req.setAttribute("error","Ten dang nhap hoac mat khau sai");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        userSession.login(username);
        resp.sendRedirect(req.getContextPath()+"/products");
    }
}
