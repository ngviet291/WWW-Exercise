package _3660721_nguyentranquocviet_tuan6_jdbc.repo;

import _3660721_nguyentranquocviet_tuan6_jdbc.utils.DBConnection;
import _3660721_nguyentranquocviet_tuan6_jdbc.mapper.DepartmentCountMapper;
import _3660721_nguyentranquocviet_tuan6_jdbc.mapper.DepartmentSalaryMapper;
import _3660721_nguyentranquocviet_tuan6_jdbc.mapper.EmployeeMapper;
import _3660721_nguyentranquocviet_tuan6_jdbc.dto.DepartmentCount;
import _3660721_nguyentranquocviet_tuan6_jdbc.dto.DepartmentSalary;
import _3660721_nguyentranquocviet_tuan6_jdbc.model.Employee;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private final DBConnection db;
    private final EmployeeMapper employeeMapper = new EmployeeMapper();
    private final DepartmentCountMapper countMapper = new DepartmentCountMapper();
    private final DepartmentSalaryMapper salaryMapper = new DepartmentSalaryMapper();

    public EmployeeRepository(DBConnection db) {
        this.db = db;
    }

    // SELECT chung: JOIN để lấy luôn tên phòng ban và tên chức vụ
    private static final String SELECT = """
            SELECT e.id, e.name, e.role, e.age, e.salary, e.department_id, e.position_id,
                   d.name AS department_name, p.title AS position_title
            FROM employees e
            LEFT JOIN departments d ON e.department_id = d.id
            LEFT JOIN positions p ON e.position_id = p.id
            """;

    // ---------- CRUD ----------
    /** INSERT nếu chưa có id, ngược lại UPDATE */
    public void save(Employee e) {
        boolean isNew = e.getId() == null;
        String sql = isNew
                ? "INSERT INTO employees (name, role, age, salary, department_id, position_id) VALUES (?, ?, ?, ?, ?, ?)"
                : "UPDATE employees SET name = ?, role = ?, age = ?, salary = ?, department_id = ?, position_id = ? WHERE id = ?";
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getName());
            ps.setString(2, e.getRole());
            setInteger(ps, 3, e.getAge());
            setDouble(ps, 4, e.getSalary());
            setInteger(ps, 5, e.getDepartmentId());
            setInteger(ps, 6, e.getPositionId());
            if (!isNew) {
                ps.setInt(7, e.getId());
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deleteById(Integer id) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Employee> findAll() {
        return queryEmployees("ORDER BY e.id");
    }

    public Optional<Employee> findById(Integer id) {
        List<Employee> result = queryEmployees("WHERE e.id = ?", id);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    // ---------- Tìm kiếm ----------
    // WHERE name LIKE ? (không phân biệt hoa thường)
    public List<Employee> findByNameContainingIgnoreCase(String name) {
        return queryEmployees("WHERE LOWER(e.name) LIKE ? ORDER BY e.id", "%" + name.toLowerCase() + "%");
    }

    // WHERE age BETWEEN ? AND ?
    public List<Employee> findByAgeBetween(Integer a, Integer b) {
        return queryEmployees("WHERE e.age BETWEEN ? AND ? ORDER BY e.id", a, b);
    }

    // WHERE salary > ?
    public List<Employee> findBySalaryGreaterThan(Double s) {
        return queryEmployees("WHERE e.salary > ? ORDER BY e.id", s);
    }

    // ---------- Theo quan hệ ----------
    // WHERE position_id = ?
    public List<Employee> findByPositionId(Integer positionId) {
        return queryEmployees("WHERE e.position_id = ? ORDER BY e.id", positionId);
    }

    // WHERE department_id = ?
    public List<Employee> findByDepartmentId(Integer departmentId) {
        return queryEmployees("WHERE e.department_id = ? ORDER BY e.id", departmentId);
    }

    // WHERE department_id = ? AND position_id = ?
    public List<Employee> findByDepartmentIdAndPositionId(Integer departmentId, Integer positionId) {
        return queryEmployees("WHERE e.department_id = ? AND e.position_id = ? ORDER BY e.id",
                departmentId, positionId);
    }

    // Top N lương cao nhất trong một Department: ORDER BY salary DESC LIMIT N
    public List<Employee> findTopByDepartmentIdOrderBySalaryDesc(Integer departmentId, int n) {
        return queryEmployees("WHERE e.department_id = ? ORDER BY e.salary DESC LIMIT ?", departmentId, n);
    }

    // ---------- Thống kê ----------
    // LEFT JOIN để giữ cả phòng ban có 0 nhân viên
    public List<DepartmentCount> countEmployeesByDepartment() {
        String sql = """
                SELECT d.name, COUNT(e.id) AS employee_count
                FROM departments d
                LEFT JOIN employees e ON e.department_id = d.id
                GROUP BY d.id, d.name
                ORDER BY d.id
                """;
        List<DepartmentCount> result = new ArrayList<>();
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(countMapper.map(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    // AVG / SUM lương theo Department
    public List<DepartmentSalary> salaryStatsByDepartment() {
        String sql = """
                SELECT d.id, d.name, AVG(e.salary) AS avg_salary, SUM(e.salary) AS total_salary
                FROM employees e
                JOIN departments d ON e.department_id = d.id
                GROUP BY d.id, d.name
                ORDER BY d.id
                """;
        List<DepartmentSalary> result = new ArrayList<>();
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(salaryMapper.map(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    // ---------- Hàm dùng chung: chạy SELECT + điều kiện, map từng dòng thành Employee ----------
    private List<Employee> queryEmployees(String conditions, Object... params) {
        List<Employee> result = new ArrayList<>();
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT + conditions)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(employeeMapper.map(rs));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    // Cột cho phép NULL: phải setNull thay vì setInt/setDouble
    private static void setInteger(PreparedStatement ps, int index, Integer value) throws SQLException {
        if (value == null) ps.setNull(index, Types.INTEGER); else ps.setInt(index, value);
    }

    private static void setDouble(PreparedStatement ps, int index, Double value) throws SQLException {
        if (value == null) ps.setNull(index, Types.DOUBLE); else ps.setDouble(index, value);
    }
}
