package com.ngviet291.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {
    public boolean authentication(String username, String password){
        return "student".equals(username)&&"123456".equals(password);
    }
}

