package com.ngviet291._3660721_nguyentranquocviet_tuan03.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {
    public boolean authentication(String username, String password){
        return "student".equals(username) && "123456".equals(password);
    }
}

