package com.ngviet291.nguyentranquocviet_23660721_tuan03.controller;

import com.ngviet291.nguyentranquocviet_23660721_tuan03.service.AuthenticationService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Named
@Path("/auth")
public class AuthResource{
    @Inject
    private AuthenticationService authenticationService;
    @POST
    @Path("/login")
    public String login(String username, String password){
        boolean isAuthenticated = authenticationService.authentication(username, password);
        if(isAuthenticated){
            return "Login successful";
        }else{
            return "Login failed";
        }
    }
}
