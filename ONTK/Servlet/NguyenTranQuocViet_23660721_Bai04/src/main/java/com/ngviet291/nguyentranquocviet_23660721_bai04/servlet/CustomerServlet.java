package com.ngviet291.nguyentranquocviet_23660721_bai04.servlet;

import com.ngviet291.nguyentranquocviet_23660721_bai04.model.Customer;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    @Inject
    private CustomerList customerList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("/customerform.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id= req.getParameter("id");
        String name = req.getParameter("name");
        String email= req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = Customer.builder()
                .id(id)
                .name(name)
                .email(email)
                .address(address)
                .build();
        customerList.addCustomer(customer);
        req.setAttribute("customers",customerList.list());
        req.getRequestDispatcher("/customerlist.jsp").forward(req,resp);
    }
}
