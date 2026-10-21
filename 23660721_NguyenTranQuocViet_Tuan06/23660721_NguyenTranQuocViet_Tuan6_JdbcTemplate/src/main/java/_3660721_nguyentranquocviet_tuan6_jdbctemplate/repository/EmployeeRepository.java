package _3660721_nguyentranquocviet_tuan6_jdbctemplate.repository;

import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.DepartmentCount;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.DepartmentSalary;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Employee;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbc;

    public EmployeeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // ---------- RowMapper ----------
    private static final RowMapper<Employee> EMPLOYEE_MAPPER = (rs, rowNum) -> {
        Employee e = new Employee();
        e.setId(rs.getInt("id"));
        e.setName(rs.getString("name"));
        e.setRole(rs.getString("role"));
        e.setAge(rs.getObject("age", Integer.class));
        e.setSalary(rs.getObject("salary", Double.class));
        e.setDepartmentId(rs.getObject("department_id", Integer.class));
        e.setPositionId(rs.getObject("position_id", Integer.class));
        e.setDepartmentName(rs.getString("department_name"));
        e.setPositionTitle(rs.getString("position_title"));
        return e;
    };

    private static final RowMapper<DepartmentCount> COUNT_MAPPER = (rs, rowNum) ->
            new DepartmentCount(rs.getString("name"), rs.getLong("employee_count"));

    private static final RowMapper<DepartmentSalary> SALARY_MAPPER = (rs, rowNum) ->
            new DepartmentSalary(rs.getInt("id"), rs.getString("name"),
                    rs.getDouble("avg_salary"), rs.getDouble("total_salary"));

    // SELECT chung: JOIN để lấy luôn tên phòng ban và tên chức vụ
    private static final String SELECT = """
            SELECT e.id, e.name, e.role, e.age, e.salary, e.department_id, e.position_id,
                   d.name AS department_name, p.title AS position_title
            FROM employees e
            LEFT JOIN departments d ON e.department_id = d.id
            LEFT JOIN positions p ON e.position_id = p.id
            """;

    private List<Employee> queryList(String where, Object... args) {
        return jdbc.query(SELECT + where + " ORDER BY e.id", EMPLOYEE_MAPPER, args);
    }

    // ---------- CRUD ----------
    /** INSERT nếu chưa có id, ngược lại UPDATE */
    public void save(Employee e) {
        if (e.getId() == null) {
            jdbc.update("""
                    INSERT INTO employees (name, role, age, salary, department_id, position_id)
                    VALUES (?, ?, ?, ?, ?, ?)
                    """,
                    e.getName(), e.getRole(), e.getAge(), e.getSalary(), e.getDepartmentId(), e.getPositionId());
        } else {
            jdbc.update("""
                    UPDATE employees
                    SET name = ?, role = ?, age = ?, salary = ?, department_id = ?, position_id = ?
                    WHERE id = ?
                    """,
                    e.getName(), e.getRole(), e.getAge(), e.getSalary(), e.getDepartmentId(), e.getPositionId(),
                    e.getId());
        }
    }

    public void deleteById(Integer id) {
        jdbc.update("DELETE FROM employees WHERE id = ?", id);
    }

    public List<Employee> findAll() {
        return queryList("");
    }

    public Optional<Employee> findById(Integer id) {
        try {
            return Optional.ofNullable(jdbc.queryForObject(SELECT + "WHERE e.id = ?", EMPLOYEE_MAPPER, id));
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    // ---------- Tìm kiếm ----------
    // WHERE name LIKE ? (không phân biệt hoa thường)
    public List<Employee> findByNameContainingIgnoreCase(String name) {
        return queryList("WHERE LOWER(e.name) LIKE ?", "%" + name.toLowerCase() + "%");
    }

    // WHERE age BETWEEN ? AND ?
    public List<Employee> findByAgeBetween(Integer a, Integer b) {
        return queryList("WHERE e.age BETWEEN ? AND ?", a, b);
    }

    // WHERE salary > ?
    public List<Employee> findBySalaryGreaterThan(Double s) {
        return queryList("WHERE e.salary > ?", s);
    }

    // ---------- Theo quan hệ ----------
    // WHERE position_id = ?
    public List<Employee> findByPositionId(Integer positionId) {
        return queryList("WHERE e.position_id = ?", positionId);
    }

    // WHERE department_id = ?
    public List<Employee> findByDepartmentId(Integer departmentId) {
        return queryList("WHERE e.department_id = ?", departmentId);
    }

    // WHERE department_id = ? AND position_id = ?
    public List<Employee> findByDepartmentIdAndPositionId(Integer departmentId, Integer positionId) {
        return queryList("WHERE e.department_id = ? AND e.position_id = ?", departmentId, positionId);
    }

    // Top N lương cao nhất trong một Department: ORDER BY salary DESC LIMIT N
    public List<Employee> findTopByDepartmentIdOrderBySalaryDesc(Integer departmentId, int n) {
        return jdbc.query(SELECT + "WHERE e.department_id = ? ORDER BY e.salary DESC LIMIT ?",
                EMPLOYEE_MAPPER, departmentId, n);
    }

    // ---------- Thống kê ----------
    // LEFT JOIN để giữ cả phòng ban có 0 nhân viên
    public List<DepartmentCount> countEmployeesByDepartment() {
        return jdbc.query("""
                SELECT d.name, COUNT(e.id) AS employee_count
                FROM departments d
                LEFT JOIN employees e ON e.department_id = d.id
                GROUP BY d.id, d.name
                ORDER BY d.id
                """, COUNT_MAPPER);
    }

    // AVG / SUM lương theo Department
    public List<DepartmentSalary> salaryStatsByDepartment() {
        return jdbc.query("""
                SELECT d.id, d.name, AVG(e.salary) AS avg_salary, SUM(e.salary) AS total_salary
                FROM employees e
                JOIN departments d ON e.department_id = d.id
                GROUP BY d.id, d.name
                ORDER BY d.id
                """, SALARY_MAPPER);
    }
}
