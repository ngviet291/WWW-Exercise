package _3660721_nguyentranquocviet_tuan6_jdbc.service;

import _3660721_nguyentranquocviet_tuan6_jdbc.dto.DepartmentCount;
import _3660721_nguyentranquocviet_tuan6_jdbc.dto.DepartmentSalary;
import _3660721_nguyentranquocviet_tuan6_jdbc.model.Employee;
import _3660721_nguyentranquocviet_tuan6_jdbc.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // ---------- CRUD ----------
    public void save(Employee e) { employeeRepo.save(e); }

    public void deleteById(Integer id) { employeeRepo.deleteById(id); }

    public List<Employee> findAll() { return employeeRepo.findAll(); }

    public Optional<Employee> findById(Integer id) { return employeeRepo.findById(id); }

    // ---------- Tìm kiếm ----------
    public List<Employee> findByNameContainingIgnoreCase(String name) {
        return employeeRepo.findByNameContainingIgnoreCase(name);
    }

    public List<Employee> findByAgeBetween(Integer a, Integer b) {
        return employeeRepo.findByAgeBetween(a, b);
    }

    public List<Employee> findBySalaryGreaterThan(Double s) {
        return employeeRepo.findBySalaryGreaterThan(s);
    }

    // ---------- Theo quan hệ ----------
    public List<Employee> findByPositionId(Integer positionId) {
        return employeeRepo.findByPositionId(positionId);
    }

    public List<Employee> findByDepartmentId(Integer departmentId) {
        return employeeRepo.findByDepartmentId(departmentId);
    }

    public List<Employee> findByDepartmentIdAndPositionId(Integer departmentId, Integer positionId) {
        return employeeRepo.findByDepartmentIdAndPositionId(departmentId, positionId);
    }

    public List<Employee> findTopByDepartmentIdOrderBySalaryDesc(Integer departmentId, int n) {
        return employeeRepo.findTopByDepartmentIdOrderBySalaryDesc(departmentId, n);
    }

    // ---------- Thống kê ----------
    public List<DepartmentCount> countEmployeesByDepartment() {
        return employeeRepo.countEmployeesByDepartment();
    }

    public List<DepartmentSalary> salaryStatsByDepartment() {
        return employeeRepo.salaryStatsByDepartment();
    }
}
