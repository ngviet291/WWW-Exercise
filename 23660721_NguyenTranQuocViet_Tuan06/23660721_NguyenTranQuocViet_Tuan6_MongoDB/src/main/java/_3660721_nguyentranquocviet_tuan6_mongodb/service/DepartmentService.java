package _3660721_nguyentranquocviet_tuan6_mongodb.service;

import _3660721_nguyentranquocviet_tuan6_mongodb.model.Department;
import _3660721_nguyentranquocviet_tuan6_mongodb.repo.DepartmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepo;

    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> findAll() { return departmentRepo.findAll(Sort.by("id")); }

    /** Department chưa có Employee nào */
    public List<Department> findDepartmentsWithoutEmployees() {
        return departmentRepo.findDepartmentsWithoutEmployees();
    }

    /** id -> tên phòng ban, để view hiển thị tên từ Employee.departmentId */
    public Map<Integer, String> nameById() {
        Map<Integer, String> map = new HashMap<>();
        for (Department d : findAll()) map.put(d.id(), d.name());
        return map;
    }
}
