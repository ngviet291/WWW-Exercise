package com.ngviet291.nguyentranquocviet_23660721_test1.controller;

import com.ngviet291.nguyentranquocviet_23660721_test1.model.LoginRequest;
import com.ngviet291.nguyentranquocviet_23660721_test1.service.AuthenticateService;
import com.ngviet291.nguyentranquocviet_23660721_test1.session.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/auth")
public class AuthResource {
    @Inject
    private AuthenticateService authenticateService;
    @Inject
    private UserSession userSession;
    @POST
    @Path("/login")
    public String login(LoginRequest loginRequest){
        boolean isAuthenticate = authenticateService.authenticate(loginRequest.getUsername(),loginRequest.getPassword());
        if(isAuthenticate){
            userSession.login(loginRequest.getUsername());
            return "Đăng nhập thành công";
        }
        return "Đăng nhập thất bại";
    }
    @POST
    @Path("/logout")
    public String logout(@Context HttpServletRequest request){
//        userSession.logout();
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "Logout thanh cong";
    }
}
