package com.ngviet291._3660721_nguyentranquocviet_jpa_01.repo;

import com.ngviet291._3660721_nguyentranquocviet_jpa_01.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByAgeBetween(int a, int b);
    List<Employee> findBySalaryGreaterThan(double s);
    @Query("SELECT e FROM Employee e  WHERE e.position.id = :positionId")
    List<Employee> findEmployeeByPositionId(@Param("positionId") Integer positionId);
}
