package com.se.demorestdb.repo;

import com.se.demorestdb.model.Department;

import java.util.List;

public interface DepartmentRepo {
    List<Department> getAllDepartments();

    Department getDepartmentById(int id);

    Department addDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(int id);
}
