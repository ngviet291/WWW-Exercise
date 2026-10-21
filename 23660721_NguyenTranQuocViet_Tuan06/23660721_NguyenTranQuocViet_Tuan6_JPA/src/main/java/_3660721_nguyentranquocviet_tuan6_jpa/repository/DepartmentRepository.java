package _3660721_nguyentranquocviet_tuan6_jpa.repository;

import _3660721_nguyentranquocviet_tuan6_jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // Department chưa có Employee nào
    @Query("""
           select d from Department d left join d.employees e
           where e.id is null
           """)
    List<Department> findDepartmentsWithoutEmployees();
}
