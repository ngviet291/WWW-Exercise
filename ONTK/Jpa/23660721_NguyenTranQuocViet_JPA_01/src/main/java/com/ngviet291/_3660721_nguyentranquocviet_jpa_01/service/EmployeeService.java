package com.ngviet291._3660721_nguyentranquocviet_jpa_01.service;

import com.ngviet291._3660721_nguyentranquocviet_jpa_01.model.Employee;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.projection.DepartmentCount;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.repo.DepartmentRepository;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.repo.EmployeeRepository;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.repo.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public Employee findById(Integer id){
        return employeeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public Employee create(Employee e){
        e.setId(null);
        return employeeRepository.save(e);
    }
    public Employee update(Integer id,Employee e){
        Employee employee= findById(id);
        employee.setName(e.getName());
        employee.setRole(e.getRole());
        employee.setAge(e.getAge());
        employee.setSalary(e.getSalary());
        employee.setDepartment(e.getDepartment());
        employee.setPosition(e.getPosition());
        return  employeeRepository.save(employee);
    }
    public void delete(Integer id){
        findById(id);
        employeeRepository.deleteById(id);
    }
    public List<Employee> search (String name){
        return  employeeRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Employee> findByAgeBetween(int a, int b){
        return employeeRepository.findByAgeBetween(a,b);
    }
    public List<Employee> findBySalaryGreaterThan(double s)
    {
        return  employeeRepository.findBySalaryGreaterThan(s);
    }
    public List<Employee> findEmployeeByPositionId(int id){
        return  employeeRepository.findEmployeeByPositionId(id);
    }
}
