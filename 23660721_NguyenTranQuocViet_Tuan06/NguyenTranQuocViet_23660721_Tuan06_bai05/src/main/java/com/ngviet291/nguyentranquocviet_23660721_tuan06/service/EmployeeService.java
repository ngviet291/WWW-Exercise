package com.ngviet291.nguyentranquocviet_23660721_tuan06.service;

import com.ngviet291.nguyentranquocviet_23660721_tuan06.model.Employee;
import com.ngviet291.nguyentranquocviet_23660721_tuan06.repo.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
@Named
@ApplicationScoped
public class EmployeeService {
    @Inject
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
       return employeeRepository.getAllEmployees();
    }
}
