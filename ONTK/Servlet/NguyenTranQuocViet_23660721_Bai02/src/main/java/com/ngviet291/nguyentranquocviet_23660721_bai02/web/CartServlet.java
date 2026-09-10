package com.ngviet291.nguyentranquocviet_23660721_bai02.web;

import com.ngviet291.nguyentranquocviet_23660721_bai02.model.Product;
import com.ngviet291.nguyentranquocviet_23660721_bai02.service.ProductCatalog;
import com.ngviet291.nguyentranquocviet_23660721_bai02.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ConcurrentModificationException;

@WebServlet("/cart/add")
public class CartServlet extends HttpServlet {
    @Inject
    private UserSession userSession ;
    @Inject
    private  ProductCatalog productCatalog;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setAttribute("products", productCatalog.findAll());
        req.setAttribute("items", userSession.getCartService().getItems());
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        if(!userSession.isLoggedIn()){
            req.setAttribute("error","Bạn chưa đăng nhập");
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        Product  product = productCatalog.findById(id);
        if(product==null){
            req.setAttribute("error","Không có sản phẩm nào");
            req.getRequestDispatcher("/cart.jsp").forward(req,resp);
            return;
        }

        userSession.getCartService().addProduct(product);
        resp.sendRedirect(req.getContextPath()+"/cart/add");
    }
}