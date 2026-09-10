package com.ngviet291.nguyentranquocviet_23660721_bai02.session;

import com.ngviet291.nguyentranquocviet_23660721_bai02.service.CartService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serializable;

@Named("userSession")
@SessionScoped
@Getter
public class UserSession implements Serializable {

    private final CartService cartService= new CartService();

    private String username;

    public void login(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return username != null;
    }
    public void logout(){
        this.username=null;
    }
}
