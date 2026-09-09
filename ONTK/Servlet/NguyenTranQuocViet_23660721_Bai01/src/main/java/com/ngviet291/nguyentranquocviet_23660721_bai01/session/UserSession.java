package com.ngviet291.nguyentranquocviet_23660721_bai01.session;

import com.ngviet291.nguyentranquocviet_23660721_bai01.model.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserSession {
    public static final String SESSION_USER="loggedUser";

    public static final void login(HttpServletRequest req, User user){
        HttpSession session = req.getSession(true);
        session.setAttribute(SESSION_USER,user);
    }
    public static final void  logout(HttpServletRequest req){
        // lấy session hiện tại, KHÔNG có thì KHÔNG tạo session mới
        HttpSession session = req.getSession(false);
        if(session!=null) session.invalidate();
    }
    public static final User getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session==null) return  null;
        return (User) session.getAttribute(SESSION_USER);
    }
    public static boolean isLoggedIn(HttpServletRequest req){
        return getCurrentUser(req) !=null;
    }
    public static boolean isAdmin(HttpServletRequest req){
        User user = getCurrentUser(req);
        return user !=null && "Admin".equalsIgnoreCase(user.getRole());
    }
}
