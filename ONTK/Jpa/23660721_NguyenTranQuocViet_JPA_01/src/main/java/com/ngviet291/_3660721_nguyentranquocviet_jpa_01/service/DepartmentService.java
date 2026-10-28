package com.ngviet291._3660721_nguyentranquocviet_jpa_01.service;

import com.ngviet291._3660721_nguyentranquocviet_jpa_01.model.Employee;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.projection.DepartmentCount;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.repo.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public List<DepartmentCount> departmentCounts(){
        return  departmentRepository.getEmployeeCountByDepartment();
    }
    public List<Employee> findTopNByDepartmentId(int id, int n) {
        return departmentRepository.findTopByDepartmentIdOrderBySalaryDesc(id,PageRequest.of(0,n));
    }
}
