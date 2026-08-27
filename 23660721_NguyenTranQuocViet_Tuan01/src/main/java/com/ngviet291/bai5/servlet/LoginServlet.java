package com.ngviet291.bai5.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            resp.sendRedirect(req.getContextPath() + "/bai5/home.jsp");
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/bai5/login.jsp").forward(req, resp);
        }
    }
}
