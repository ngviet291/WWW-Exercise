package com.se.demorestdb.repo;

import com.se.demorestdb.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
}
