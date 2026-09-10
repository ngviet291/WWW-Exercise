package com.ngviet291.nguyentranquocviet_23660721_bai02.web;

import com.ngviet291.nguyentranquocviet_23660721_bai02.service.ProductCatalog;
import com.ngviet291.nguyentranquocviet_23660721_bai02.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Inject
    private  UserSession userSession ;
    @Inject
    private  ProductCatalog productCatalog;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        if(!userSession.isLoggedIn()){
            req.setAttribute("error","Bạn chưa đăng nhập");
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }

        req.setAttribute("products",productCatalog.findAll());
        req.setAttribute("userSession",userSession);
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);
    }
}
