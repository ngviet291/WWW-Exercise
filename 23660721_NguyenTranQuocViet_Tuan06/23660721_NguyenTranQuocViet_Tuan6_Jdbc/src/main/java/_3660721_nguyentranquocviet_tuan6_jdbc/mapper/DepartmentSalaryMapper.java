package _3660721_nguyentranquocviet_tuan6_jdbc.mapper;

import _3660721_nguyentranquocviet_tuan6_jdbc.dto.DepartmentSalary;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentSalaryMapper implements ResultSetMapper<DepartmentSalary> {
    @Override
    public DepartmentSalary map(ResultSet rs) throws SQLException {
        return new DepartmentSalary(rs.getInt("id"), rs.getString("name"),
                rs.getDouble("avg_salary"), rs.getDouble("total_salary"));
    }
}
