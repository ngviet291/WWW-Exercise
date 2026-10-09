package com.se.demorestdb.repo;

import com.se.demorestdb.model.Category;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepoImpl {
    private volatile DataSource dataSource;
    private DataSource getDataSource() {
        if (dataSource == null) {
            try {
                Context env= (Context) new InitialContext().lookup("java:comp/env");
                dataSource = (DataSource) env.lookup("jdbc/quanlytintuc");
            } catch (NamingException e) {
                throw new RuntimeException(e);
            }
        }
        return dataSource;
    }
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM danhmuc";
        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ) {
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("MADM"));
                category.setName(rs.getString("TENDANHMUC"));
                category.setManager(rs.getString("NGUOIQUANLY"));
                category.setNote(rs.getString("GHICHU"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    public Category getCategoryById(int id) {
        Category category = null;
        String sql = "SELECT * FROM danhmuc WHERE MADM = ?";
        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    category = new Category();
                    category.setId(rs.getInt("MADM"));
                    category.setName(rs.getString("TENDANHMUC"));
                    category.setManager(rs.getString("NGUOIQUANLY"));
                    category.setNote(rs.getString("GHICHU"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }
    public boolean addCategory(Category category) {
        String sql = "INSERT INTO danhmuc (TENDANHMUC, NGUOIQUANLY, GHICHU) VALUES (?, ?, ?)";
        try (
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getManager());
            ps.setString(3, category.getNote());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updateCategory(Category category) {
        String sql = "UPDATE danhmuc SET TENDANHMUC = ?, NGUOIQUANLY = ?, GHICHU = ? WHERE MADM = ?";
        try (
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getManager());
            ps.setString(3, category.getNote());
            ps.setInt(4, category.getId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deleteCategory(int id) {
        String sql = "DELETE FROM danhmuc WHERE MADM = ?";
        try (
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
