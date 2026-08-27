package com.ngviet291.web;

import com.ngviet291.model.Product;
import com.ngviet291.service.ProductCatalog;
import com.ngviet291.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Inject
    private ProductCatalog productCatalog;
    @Inject
    private UserSession userSession;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        if(!userSession.isLoggedin()){
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
        try{
            long productId=Long.parseLong(req.getParameter("productId"));
            Product product=productCatalog.getProductById(productId);
            if(product!=null) {
                userSession.getShoppingCart().addItem(product);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath()+"/products");
    }

}
