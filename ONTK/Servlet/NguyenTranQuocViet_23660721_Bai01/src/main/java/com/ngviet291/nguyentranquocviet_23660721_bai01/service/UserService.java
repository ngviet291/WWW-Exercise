package com.ngviet291.nguyentranquocviet_23660721_bai01.service;

import com.ngviet291.nguyentranquocviet_23660721_bai01.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static final List<User> users = new ArrayList<>(List.of(
            new User("admin", "admin123","Admin"),
            new User("user","user123","User")
    ));
    public static User login(String username, String password){
        for (User user:users){
            if (user.getUsername().equalsIgnoreCase(username)&&user.getPassword().equals(password)){
                return  user;
            }
        }
        return  null;
    }
}
