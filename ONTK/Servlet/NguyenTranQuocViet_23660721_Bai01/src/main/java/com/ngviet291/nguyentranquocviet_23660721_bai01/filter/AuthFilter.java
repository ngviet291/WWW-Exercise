package com.ngviet291.nguyentranquocviet_23660721_bai01.filter;

import com.ngviet291.nguyentranquocviet_23660721_bai01.session.UserSession;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/course/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(!UserSession.isLoggedIn(request)){
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        filterChain.doFilter(request,response);
    }
}
