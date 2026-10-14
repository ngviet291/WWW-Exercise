package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.util;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RequiredArgsConstructor
public class DBUtil {
    private final DataSource dataSource;
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Can not connect to database", e);
        }
    }
}