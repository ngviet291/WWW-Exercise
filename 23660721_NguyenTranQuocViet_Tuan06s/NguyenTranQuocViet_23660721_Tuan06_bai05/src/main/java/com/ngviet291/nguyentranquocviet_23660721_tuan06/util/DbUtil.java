package com.ngviet291.nguyentranquocviet_23660721_tuan06.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
    private final DataSource dataSource;
    public DbUtil(DataSource dataSource){
        this.dataSource=dataSource;
    }
    public Connection getConnection(){
        Connection connection;
        try{
            connection= dataSource.getConnection();
        }catch (SQLException e){
            throw  new RuntimeException();
        }
        return connection;
    }
}
