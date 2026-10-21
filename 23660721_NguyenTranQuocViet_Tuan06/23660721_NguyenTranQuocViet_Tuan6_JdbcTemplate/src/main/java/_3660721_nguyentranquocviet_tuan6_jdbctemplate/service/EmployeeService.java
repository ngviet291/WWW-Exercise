package _3660721_nguyentranquocviet_tuan6_jdbctemplate.service;

import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.DepartmentCount;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.DepartmentSalary;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Employee;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Transactional
    public void save(Employee e) { employeeRepo.save(e); }

    @Transactional
    public void deleteById(Integer id) { employeeRepo.deleteById(id); }

    public List<Employee> findAll() { return employeeRepo.findAll(); }

    public Optional<Employee> findById(Integer id) { return employeeRepo.findById(id); }

    public List<Employee> findByNameContainingIgnoreCase(String name) {
        return employeeRepo.findByNameContainingIgnoreCase(name);
    }

    public List<Employee> findByAgeBetween(Integer a, Integer b) {
        return employeeRepo.findByAgeBetween(a, b);
    }

    public List<Employee> findBySalaryGreaterThan(Double s) {
        return employeeRepo.findBySalaryGreaterThan(s);
    }

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

    public List<DepartmentCount> countEmployeesByDepartment() {
        return employeeRepo.countEmployeesByDepartment();
    }

    public List<DepartmentSalary> salaryStatsByDepartment() {
        return employeeRepo.salaryStatsByDepartment();
    }
}
