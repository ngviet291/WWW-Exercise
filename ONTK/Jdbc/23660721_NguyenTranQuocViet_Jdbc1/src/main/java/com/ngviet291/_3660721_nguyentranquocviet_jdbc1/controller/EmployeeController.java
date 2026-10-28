package com.ngviet291._3660721_nguyentranquocviet_jdbc1.controller;

import com.ngviet291._3660721_nguyentranquocviet_jdbc1.model.Employee;
import com.ngviet291._3660721_nguyentranquocviet_jdbc1.projection.Statistic;
import com.ngviet291._3660721_nguyentranquocviet_jdbc1.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/statistic")
    public Statistic getStatistic(){
        return employeeService.getStatistic();
    }
    @GetMapping
    public List<Employee> getAll(){
        return  employeeService.getAll();
    }
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id){
        return  employeeService.getById(id);
    }
    @PatchMapping("/{id}")
    public Employee update(@PathVariable Integer id,@RequestBody Employee employee){
        return employeeService.update(id, employee);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        employeeService.delete(id);
    }
    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }
}
