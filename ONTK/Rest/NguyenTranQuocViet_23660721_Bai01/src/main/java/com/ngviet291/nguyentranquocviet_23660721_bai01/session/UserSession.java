package com.ngviet291.nguyentranquocviet_23660721_bai01.session;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serializable;

@SessionScoped
@Named("userSession")
@Getter
public class UserSession implements Serializable {
    private String username;
    public void login(String username){
        this.username= username;
    }
    public boolean isLoggedIn(){
        return username!=null;
    }
}
