package com.ngviet291._3660721_nguyentranquocviet_jpa_01.controller;

import com.ngviet291._3660721_nguyentranquocviet_jpa_01.model.Employee;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.findAll();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Integer id){
        return  employeeService.findById(id);
    }
    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return  employeeService.create(employee);
    }
    @PatchMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee employee){
        return  employeeService.update(id,employee);
    }
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable Integer id){
        employeeService.delete(id);
    }
    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) {
        return employeeService.search(name);
    }
    @GetMapping("/age")
    public List<Employee> byAge(@RequestParam Integer from, @RequestParam Integer to) {
        return employeeService.findByAgeBetween(from, to);
    }

    @GetMapping("/salary")
    public List<Employee> bySalary(@RequestParam Double min) {
        return employeeService.findBySalaryGreaterThan(min);
    }
    @GetMapping("/position/{id}")
    public List<Employee> findEmployeeByPositionId(@PathVariable int id){
        return employeeService.findEmployeeByPositionId(id);
    }
}
