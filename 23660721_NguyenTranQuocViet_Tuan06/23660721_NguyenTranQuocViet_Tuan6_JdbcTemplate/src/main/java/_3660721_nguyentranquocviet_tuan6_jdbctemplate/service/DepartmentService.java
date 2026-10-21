package _3660721_nguyentranquocviet_tuan6_jdbctemplate.service;

import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Department;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepo;

    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> findAll() { return departmentRepo.findAll(); }

    public List<Department> findDepartmentsWithoutEmployees() {
        return departmentRepo.findDepartmentsWithoutEmployees();
    }
}
