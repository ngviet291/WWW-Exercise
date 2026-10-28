package com.ngviet291._3660721_nguyentranquocviet_jdbc1.repo;

import com.ngviet291._3660721_nguyentranquocviet_jdbc1.model.Employee;
import com.ngviet291._3660721_nguyentranquocviet_jdbc1.projection.Statistic;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeRepository extends ListCrudRepository<Employee, Integer> {
    @Query("""
    SELECT COALESCE(COUNT(e.id), 0)  AS quantity,
           COALESCE(SUM(e.salary), 0) AS total_price,
           COALESCE(AVG(e.salary), 0) AS avg_price
    FROM employees e
    """)
    Statistic getStatistic();
}
