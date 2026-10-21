package _3660721_nguyentranquocviet_tuan6_jpa.service;


import _3660721_nguyentranquocviet_tuan6_jpa.entity.Department;
import _3660721_nguyentranquocviet_tuan6_jpa.entity.Employee;
import _3660721_nguyentranquocviet_tuan6_jpa.entity.Position;
import _3660721_nguyentranquocviet_tuan6_jpa.dto.DepartmentCount;
import _3660721_nguyentranquocviet_tuan6_jpa.dto.DepartmentSalary;
import _3660721_nguyentranquocviet_tuan6_jpa.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    public EmployeeService(EmployeeRepository employeeRepo,
                           DepartmentService departmentService,
                           PositionService positionService) {
        this.employeeRepo = employeeRepo;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }
    @Transactional
    public Employee save(Employee e) {
        Department d = e.getDepartment();
        e.setDepartment(d != null && d.getId() != null ? departmentService.getReference(d.getId()) : null);
        Position p = e.getPosition();
        e.setPosition(p != null && p.getId() != null ? positionService.getReference(p.getId()) : null);
        return employeeRepo.save(e);
    }

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
    public List<Employee> findTop5ByDepartmentIdOrderBySalaryDesc(Integer departmentId) {
        return employeeRepo.findTop5ByDepartmentIdOrderBySalaryDesc(departmentId);
    }

    public List<Employee> findTopNByDepartmentIdOrderBySalaryDesc(Integer departmentId, int n) {
        return employeeRepo.findByDepartmentIdOrderBySalaryDesc(departmentId, PageRequest.of(0, n));
    }

    public List<DepartmentCount> countEmployeesByDepartment() {
        return employeeRepo.countEmployeesByDepartment();
    }

    public List<DepartmentSalary> salaryStatsByDepartment() {
        return employeeRepo.salaryStatsByDepartment();
    }
}
