package _3660721_nguyentranquocviet_tuan6_jdbc.mapper;

import _3660721_nguyentranquocviet_tuan6_jdbc.dto.DepartmentCount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentCountMapper implements ResultSetMapper<DepartmentCount> {
    @Override
    public DepartmentCount map(ResultSet rs) throws SQLException {
        return new DepartmentCount(rs.getString("name"), rs.getLong("employee_count"));
    }
}
