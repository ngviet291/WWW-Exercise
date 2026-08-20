package com.ngviet291.bai5.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/bai5/secure/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        boolean loggedIn=(session!=null&&session.getAttribute("user")!=null);
        if(loggedIn){
            filterChain.doFilter(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/bai5/login.jsp");
        }
    }
}