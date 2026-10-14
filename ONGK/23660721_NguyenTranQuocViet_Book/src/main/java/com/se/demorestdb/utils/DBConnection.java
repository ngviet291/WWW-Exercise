package com.se.demorestdb.utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped
public class DBConnection {
    @Produces
    public DataSource dataSource() {
        try {
            return (DataSource) new InitialContext()
                    .lookup("java:comp/env/jdbc/LibraryDB");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}