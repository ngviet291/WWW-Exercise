package _3660721_nguyentranquocviet_tuan6_jpa.service;

import _3660721_nguyentranquocviet_tuan6_jpa.entity.Department;
import _3660721_nguyentranquocviet_tuan6_jpa.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepo;

    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> findAll() { return departmentRepo.findAll(); }

    public Optional<Department> findById(Integer id) { return departmentRepo.findById(id); }

    public Department getReference(Integer id) { return departmentRepo.getReferenceById(id); }
    public List<Department> findDepartmentsWithoutEmployees() {
        return departmentRepo.findDepartmentsWithoutEmployees();
    }
}
