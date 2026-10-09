package com.se.demorestdb.repo;

import com.se.demorestdb.model.Department;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepoImpl implements DepartmentRepo {
    private volatile DataSource dataSource;
    private DataSource getDataSource(){
        if (dataSource == null) {
            try {
                javax.naming.Context env = (javax.naming.Context) new javax.naming.InitialContext().lookup("java:comp/env");
                dataSource = (DataSource) env.lookup("jdbc/employee_db");
            } catch (javax.naming.NamingException e) {
                throw new RuntimeException("Không tìm thấy DataSource jdbc/employee_db", e);
            }
        }
        return dataSource;
    }
    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (
                Connection con= getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while (rs.next()) {
                Department dept = new Department();
                dept.setId(rs.getInt("id"));
                dept.setName(rs.getString("name"));
                list.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    @Override
    public Department getDepartmentById(int id) {
        Department dept = null;
        String sql = "SELECT * FROM departments WHERE id = ?";
        try (
                Connection con= getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dept = new Department();
                    dept.setId(rs.getInt("id"));
                    dept.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dept;
    }
    @Override
    public Department addDepartment(Department department) {
        String sql = "INSERT INTO departments (name) VALUES (?)";
        try (
                Connection con= getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
                ){
            ps.setString(1, department.getName());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating department failed, no rows affected.");
            }
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    department.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return department;
    }
    @Override
    public Department updateDepartment(Department department) {
        String sql = "UPDATE departments SET name = ? WHERE id = ?";
        try (
                Connection con= getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setString(1, department.getName());
            ps.setInt(2, department.getId());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating department failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return department;
    }
    @Override
    public void deleteDepartment(int id) {
        String sql = "DELETE FROM departments WHERE id = ?";
        try (
                Connection con= getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting department failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
