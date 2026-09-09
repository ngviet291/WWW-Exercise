package com.ngviet291.nguyentranquocviet_23660721_bai01.filter;

import com.ngviet291.nguyentranquocviet_23660721_bai01.session.UserSession;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter({"/course/create","/course/edit","/course/delete"})
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(!UserSession.isAdmin(request)){
            request.getRequestDispatcher("/unauthorized.jsp").forward(servletRequest,servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
