package _3660721_nguyentranquocviet_tuan6_jpa.repository;

import _3660721_nguyentranquocviet_tuan6_jpa.dto.DepartmentCount;
import _3660721_nguyentranquocviet_tuan6_jpa.dto.DepartmentSalary;
import _3660721_nguyentranquocviet_tuan6_jpa.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Override
    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findAll();

    @Override
    @EntityGraph(attributePaths = {"department", "position"})
    Optional<Employee> findById(Integer id);

    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findByNameContainingIgnoreCase(String name);

    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findByAgeBetween(Integer a, Integer b);

    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findBySalaryGreaterThan(Double s);

    // ----- Theo quan hệ -----
    // WHERE position_id = ?
    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findByPositionId(Integer positionId);

    // WHERE department_id = ?
    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findByDepartmentId(Integer departmentId);

    // WHERE department_id = ? AND position_id = ?
    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findByDepartmentIdAndPositionId(Integer departmentId, Integer positionId);

    // Top 5 lương cao nhất trong một Department
    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findTop5ByDepartmentIdOrderBySalaryDesc(Integer departmentId);

    // Top N (N động): truyền PageRequest.of(0, n)
    @EntityGraph(attributePaths = {"department", "position"})
    List<Employee> findByDepartmentIdOrderBySalaryDesc(Integer departmentId, Pageable pageable);

    // Số Employee của mỗi Department (LEFT JOIN giữ cả phòng ban có 0 nhân viên)
    @Query("""
           select d.name as departmentName, count(e.id) as employeeCount
           from Department d left join d.employees e
           group by d.id, d.name
           order by d.id
           """)
    List<DepartmentCount> countEmployeesByDepartment();

    // Lương trung bình và tổng lương theo Department
    @Query("""
           select d.id as departmentId, d.name as departmentName,
                  avg(e.salary) as avgSalary, sum(e.salary) as totalSalary
           from Employee e join e.department d
           group by d.id, d.name
           order by d.id
           """)
    List<DepartmentSalary> salaryStatsByDepartment();
}
