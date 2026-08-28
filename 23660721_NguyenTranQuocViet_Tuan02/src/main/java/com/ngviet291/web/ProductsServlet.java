package com.ngviet291.web;

import com.ngviet291.service.ProductCatalog;
import com.ngviet291.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    @Inject
    private ProductCatalog productCatalog;

    @Inject
    private UserSession userSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        if(!userSession.isLoggedin()){
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
        req.setAttribute("products", productCatalog.getProducts());
        req.setAttribute("userSession", userSession);
        req.getRequestDispatcher("/views/products.jsp").forward(req, resp);
    }

}
