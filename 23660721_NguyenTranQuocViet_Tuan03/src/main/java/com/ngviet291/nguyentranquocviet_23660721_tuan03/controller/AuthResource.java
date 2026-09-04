package com.ngviet291.nguyentranquocviet_23660721_tuan03.controller;

import jakarta.inject.Named;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Named
@Path("/auth")
public class AuthResource{
    @POST
    @Path("/login")
    public String login(String username, String password){
        if("student".equals(username)&&"123456".equals(password)){
            return "Login successful";
        }else{
            return "Login failed";
        }
    }
}
