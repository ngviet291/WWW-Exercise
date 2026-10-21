package com.ngviet291.nguyentranquocviet_23660721_tuan06.controller;

import com.ngviet291.nguyentranquocviet_23660721_tuan06.model.Employee;
import com.ngviet291.nguyentranquocviet_23660721_tuan06.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebFilter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {
    @Inject
    private EmployeeService employeeService;
    @GET
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
