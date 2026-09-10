package com.ngviet291.nguyentranquocviet_23660721_bai01.service;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;
@ApplicationScoped
public class AuthenticateService implements Serializable {
    public boolean authenticate(String username,String password){
        return "student".equalsIgnoreCase(username)&&"Viet37fc".equals(password);
    }
}
