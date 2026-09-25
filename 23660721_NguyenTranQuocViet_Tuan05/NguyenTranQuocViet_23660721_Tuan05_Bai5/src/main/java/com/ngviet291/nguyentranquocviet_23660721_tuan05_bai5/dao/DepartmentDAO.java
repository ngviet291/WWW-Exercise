package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.dao;

import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.model.Department;
import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DepartmentDAO {

    private DBUtil dbUtil;
    public DepartmentDAO(DataSource dataSource) {
        dbUtil= new DBUtil(dataSource);
    }
    public boolean addDepartment(String name) {
        String sql = "INSERT INTO departments (name) VALUES (?)";
        try (
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, name);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Department> getAllDepartments() {
        List<Department> departments = new java.util.ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                java.sql.ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

}
