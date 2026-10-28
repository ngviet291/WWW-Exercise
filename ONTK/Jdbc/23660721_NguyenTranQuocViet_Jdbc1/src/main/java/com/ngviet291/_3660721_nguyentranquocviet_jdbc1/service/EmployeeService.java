package com.ngviet291._3660721_nguyentranquocviet_jdbc1.service;

import com.ngviet291._3660721_nguyentranquocviet_jdbc1.model.Employee;
import com.ngviet291._3660721_nguyentranquocviet_jdbc1.projection.Statistic;
import com.ngviet291._3660721_nguyentranquocviet_jdbc1.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public Employee create(Employee employee){
        employee.setId(null);
        return employeeRepository.save(employee);
    }
    public List<Employee> getAll(){
        return  employeeRepository.findAll();
    }
    public Employee getById(Integer id){
        return  employeeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public Employee update(Integer id,Employee employee){
        Employee employeeUpdate = getById(id);
        employeeUpdate.setName(employee.getName());
        employeeUpdate.setAge(employee.getAge());
        employeeUpdate.setRole(employee.getRole());
        employeeUpdate.setSalary(employee.getSalary());
        employeeUpdate.setPosition_id(employeeUpdate.getPosition_id());
        employeeUpdate.setDepartment_id(employeeUpdate.getDepartment_id());
        return  employeeRepository.save(employeeUpdate);
    }
    public void delete(Integer id){
        getById(id);
        employeeRepository.deleteById(id);
    }
    public Statistic getStatistic(){
        return employeeRepository.getStatistic();
    }

}
