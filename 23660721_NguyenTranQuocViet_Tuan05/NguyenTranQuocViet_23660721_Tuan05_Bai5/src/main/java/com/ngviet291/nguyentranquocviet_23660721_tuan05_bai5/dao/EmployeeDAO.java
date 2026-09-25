package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.dao;

import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.model.Employee;
import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private DBUtil dbUtil;
    public EmployeeDAO(DataSource dbSource) {
        dbUtil = new DBUtil(dbSource);
    }
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                ){
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employees.add(employee);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
    public Employee getById(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE id = ?";
        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartmentId(rs.getInt("department_id"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
    public List<Employee> getByDepartmentId(int deptId){
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE department_id = ?";
        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, deptId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employees.add(employee);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
    public boolean save(Employee employee) {
        String sql = "INSERT INTO employees (name, salary, department_id) VALUES (?, ?, ?, ?)";
        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setString(1, employee.getName());
            stmt.setDouble(3, employee.getSalary());
            stmt.setInt(4, employee.getDepartmentId());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Employee update(Employee employee) {
        String sql = "UPDATE employees SET name = ?, salary = ?, department_id = ? WHERE id = ?";
        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setString(1, employee.getName());
            stmt.setDouble(2, employee.getSalary());
            stmt.setInt(3, employee.getDepartmentId());
            stmt.setInt(4, employee.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                return employee;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try(
                Connection conn = dbUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
