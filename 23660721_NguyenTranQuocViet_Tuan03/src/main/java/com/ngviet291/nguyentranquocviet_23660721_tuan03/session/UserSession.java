package com.ngviet291.nguyentranquocviet_23660721_tuan03.session;

import com.ngviet291.nguyentranquocviet_23660721_tuan03.service.ShoppingCart;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Named("userSession")
@SessionScoped
@Getter
public class UserSession  implements Serializable {
    private final String instanceId= UUID.randomUUID().toString();
    private final ShoppingCart shoppingCart= new ShoppingCart();
    private String username;
    public void login(String username){
        this.username=username;
    }
    public boolean isLoggedin(){
        return username!=null;
    }
}