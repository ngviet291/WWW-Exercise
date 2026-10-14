package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.servlet;

import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.model.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({ "/checkout", "/checkout/*" })
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        req.setAttribute("totalPrice", cart.getTotalPrice());

        req.getRequestDispatcher("/checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paymentMethod = req.getParameter("paymentMethod");
        String totalPrice = req.getParameter("totalPrice");
        String address = req.getParameter("address");
        String fullname = req.getParameter("fullname");

        req.setAttribute("paymentMethod", paymentMethod);
        req.setAttribute("totalPrice", totalPrice);
        req.setAttribute("address", address);
        req.setAttribute("fullname", fullname);

        HttpSession httpSession = req.getSession();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        cart.clear();
        req.getRequestDispatcher("/success.jsp").forward(req, resp);

    }
}