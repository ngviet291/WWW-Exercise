package com.ngviet291.nguyentranquocviet_23660721_bai01.controller;

import com.ngviet291.nguyentranquocviet_23660721_bai01.model.LoginRequest;
import com.ngviet291.nguyentranquocviet_23660721_bai01.service.AuthenticateService;
import com.ngviet291.nguyentranquocviet_23660721_bai01.session.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces
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
}
