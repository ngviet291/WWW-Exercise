package _3660721_nguyentranquocviet_tuan6_jdbc.service;

import _3660721_nguyentranquocviet_tuan6_jdbc.model.Department;
import _3660721_nguyentranquocviet_tuan6_jdbc.repo.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepo;

    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> findAll() { return departmentRepo.findAll(); }

    /** Department chưa có Employee nào */
    public List<Department> findDepartmentsWithoutEmployees() {
        return departmentRepo.findDepartmentsWithoutEmployees();
    }
}
