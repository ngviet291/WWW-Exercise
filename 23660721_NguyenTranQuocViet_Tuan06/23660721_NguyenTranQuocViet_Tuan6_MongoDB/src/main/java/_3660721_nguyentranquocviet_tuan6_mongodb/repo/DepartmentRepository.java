package _3660721_nguyentranquocviet_tuan6_mongodb.repo;

import _3660721_nguyentranquocviet_tuan6_mongodb.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, Integer> {

    @Query("{ $or: [ { employees: { $exists: false } }, { employees: { $size: 0 } } ] }")
    List<Department> findDepartmentsWithoutEmployees();
}
