package _3660721_nguyentranquocviet_tuan6_jdbc.mapper;

import _3660721_nguyentranquocviet_tuan6_jdbc.model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements ResultSetMapper<Department> {
    @Override
    public Department map(ResultSet rs) throws SQLException {
        return new Department(rs.getInt("id"), rs.getString("name"));
    }
}
