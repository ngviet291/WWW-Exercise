package com.ngviet291.nguyentranquocviet_23660721_tuan06.repo;

import com.ngviet291.nguyentranquocviet_23660721_tuan06.model.Employee;
import com.ngviet291.nguyentranquocviet_23660721_tuan06.util.DbUtil;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Named
@ApplicationScoped
public class EmployeeRepository {
    @Resource(lookup = "java:comp/env/jdbc/employee_db")
    private DataSource dataSource;

    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getBigDecimal("salary"));

                employees.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }
}
