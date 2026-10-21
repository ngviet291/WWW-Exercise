package _3660721_nguyentranquocviet_tuan6_jdbctemplate.repository;

import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {

    private final JdbcTemplate jdbc;

    private static final RowMapper<Department> MAPPER = (rs, rowNum) ->
            new Department(rs.getInt("id"), rs.getString("name"));

    public DepartmentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Department> findAll() {
        return jdbc.query("SELECT id, name FROM departments ORDER BY id", MAPPER);
    }

    public List<Department> findDepartmentsWithoutEmployees() {
        return jdbc.query("""
                SELECT d.id, d.name
                FROM departments d
                LEFT JOIN employees e ON e.department_id = d.id
                WHERE e.id IS NULL
                ORDER BY d.id
                """, MAPPER);
    }
}
