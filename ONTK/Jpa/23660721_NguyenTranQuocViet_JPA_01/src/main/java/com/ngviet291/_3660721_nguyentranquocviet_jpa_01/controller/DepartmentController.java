package com.ngviet291._3660721_nguyentranquocviet_jpa_01.controller;

import com.ngviet291._3660721_nguyentranquocviet_jpa_01.model.Employee;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.projection.DepartmentCount;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping
    public List<DepartmentCount> departmentCounts(){
        return departmentService.departmentCounts();
    }
    @GetMapping("/top-salary")
    public List<Employee> topSalary(
            @RequestParam int departmentId,
            @RequestParam int n) {
        return departmentService.findTopNByDepartmentId(departmentId, n);
    }
}
