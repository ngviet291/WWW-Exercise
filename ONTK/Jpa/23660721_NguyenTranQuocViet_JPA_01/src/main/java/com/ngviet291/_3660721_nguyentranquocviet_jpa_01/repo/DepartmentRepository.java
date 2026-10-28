package com.ngviet291._3660721_nguyentranquocviet_jpa_01.repo;

import com.ngviet291._3660721_nguyentranquocviet_jpa_01.model.Department;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.model.Employee;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.projection.DepartmentCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @Query("""
    SELECT d.name AS name, COUNT(e.id) AS total
    FROM Department d left  join d.employees e
    GROUP BY d.id, d.name
    """)
    List<DepartmentCount> getEmployeeCountByDepartment();
    //Top N Employee lương cao nhất trong mot Department
    @Query("""
        SELECT e FROM Employee e
        WHERE e.department.id = :id
        ORDER BY e.salary DESC
    """)
    List<Employee> findTopByDepartmentIdOrderBySalaryDesc(
            @Param("id") int id,
            Pageable pageable
    );
}
