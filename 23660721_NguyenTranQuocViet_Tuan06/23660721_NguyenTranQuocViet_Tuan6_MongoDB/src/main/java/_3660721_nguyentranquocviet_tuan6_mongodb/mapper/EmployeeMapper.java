package _3660721_nguyentranquocviet_tuan6_mongodb.mapper;

import _3660721_nguyentranquocviet_tuan6_mongodb.model.Employee;
import org.bson.Document;

public class EmployeeMapper implements DocumentMapper<Employee> {

    @Override
    public Employee map(Document doc) {
        Employee e = new Employee();
        e.setId(DocumentMapper.toInteger(doc.get("employeeId", Number.class)));
        e.setName(doc.getString("name"));
        e.setRole(doc.getString("role"));
        e.setAge(DocumentMapper.toInteger(doc.get("age", Number.class)));
        e.setSalary(DocumentMapper.toDouble(doc.get("salary", Number.class)));
        e.setDepartmentId(DocumentMapper.toInteger(doc.get("departmentId", Number.class)));
        e.setPositionId(DocumentMapper.toInteger(doc.get("positionId", Number.class)));
        return e;
    }
}
