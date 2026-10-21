package _3660721_nguyentranquocviet_tuan6_jdbc.mapper;

import _3660721_nguyentranquocviet_tuan6_jdbc.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements ResultSetMapper<Employee> {

    @Override
    public Employee map(ResultSet rs) throws SQLException {
        Employee e = new Employee();
        e.setId(rs.getInt("id"));
        e.setName(rs.getString("name"));
        e.setRole(rs.getString("role"));
        e.setAge(getInteger(rs, "age"));
        e.setSalary(getDouble(rs, "salary"));
        e.setDepartmentId(getInteger(rs, "department_id"));
        e.setPositionId(getInteger(rs, "position_id"));
        e.setDepartmentName(rs.getString("department_name"));
        e.setPositionTitle(rs.getString("position_title"));
        return e;
    }

    // Cột cho phép NULL: getInt/getDouble trả 0 khi NULL nên phải kiểm tra wasNull()
    private static Integer getInteger(ResultSet rs, String column) throws SQLException {
        int v = rs.getInt(column);
        return rs.wasNull() ? null : v;
    }

    private static Double getDouble(ResultSet rs, String column) throws SQLException {
        double v = rs.getDouble(column);
        return rs.wasNull() ? null : v;
    }
}
