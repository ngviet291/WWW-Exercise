package com.ngviet291.bai7.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
    public static final String DB_URL = "jdbc:mariadb://localhost:3306/23660721viet";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "sapassword";

    public DatabaseUtil() {
    }
    public static Connection getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
