package com.ngviet291._3660721_nguyentranquocviet_tuan03.controller;

import com.ngviet291._3660721_nguyentranquocviet_tuan03.model.LoginRequest;
import com.ngviet291._3660721_nguyentranquocviet_tuan03.service.AuthenticationService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Named
@Path("/auth")
public class AuthResource{
    @Inject
    private AuthenticationService authenticationService;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public String login(LoginRequest loginRequest) {
        boolean isAuthenticated = authenticationService.authentication(loginRequest.getUsername(), loginRequest.getPassword());
        if(isAuthenticated){
            return "Login successful";
        }else{
            return "Login failed";
        }
    }
}

