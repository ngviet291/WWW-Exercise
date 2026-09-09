package com.ngviet291.nguyentranquocviet_23660721_bai01.web;

import com.ngviet291.nguyentranquocviet_23660721_bai01.session.UserSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        UserSession.logout(req);
        resp.sendRedirect(req.getContextPath()+"/login");
    }
}
