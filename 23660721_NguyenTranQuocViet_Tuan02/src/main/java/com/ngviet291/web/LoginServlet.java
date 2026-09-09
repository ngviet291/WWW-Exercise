package com.ngviet291.web;

import com.ngviet291.service.AuthenticationService;
import com.ngviet291.session.UserSession;
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
    private AuthenticationService authenticationService;
    @Inject
    private UserSession userSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        if(userSession.isLoggedin()){
            resp.sendRedirect(req.getContextPath()+"/");
        }else {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if(!authenticationService.authentication(username,password)) {
            req.setAttribute("error", "Invalid username or password");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
        userSession.login(username);
        resp.sendRedirect(req.getContextPath() + "/products");

    }

}
