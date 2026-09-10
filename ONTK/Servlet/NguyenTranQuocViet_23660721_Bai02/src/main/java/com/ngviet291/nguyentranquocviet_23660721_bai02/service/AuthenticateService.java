package com.ngviet291.nguyentranquocviet_23660721_bai02.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticateService {
    public boolean authentication(String username, String password){
        return "student".equals(username)&&"123456".equals(password);
    }
}
