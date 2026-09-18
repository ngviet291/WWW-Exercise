package com.ngviet291.nguyentranquocviet_23660721_bai05.controller;

import com.ngviet291.nguyentranquocviet_23660721_bai05.cdi.TicketManager;
import com.ngviet291.nguyentranquocviet_23660721_bai05.model.Passenger;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ticket")
public class BusTicketServlet extends HttpServlet {
    @Inject
    private TicketManager ticketManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("/ticketform.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String passengerName= req.getParameter("passengerName");
        String password = req.getParameter("password");
        String seatType = req.getParameter("seatType");
        String route = req.getParameter("route");
        List<String> routes = new ArrayList<>();
        routes.add(route);
        Passenger passenger = Passenger.builder()
                .passengerName(passengerName)
                .password(password)
                .seatType(seatType)
                .route(routes)
                .build();
        ticketManager.addPassenger(passenger);
        req.setAttribute("tickets",ticketManager.getPassengers());
        req.getRequestDispatcher("/ticketresult.jsp").forward(req,resp);
    }
}
